package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.joda.time.DateTime;
import org.joda.time.Days;

import exception.BalanceInsufficient;
import exception.InvalidPurchaseException;
import exception.PendingScoreException;

public class SalesAdministration {
	ScoringManager scoringManager;
	MenuManager    menuManager;
	Mail           mail;
	List<Order> ordersToConfirm= new ArrayList<>();
	
	public SalesAdministration(ScoringManager scoringManager, MenuManager menuManager,Mail mail){
		this.scoringManager=scoringManager;
		this.menuManager= menuManager;
		this.mail= mail;
		
	}
	
     public void saleMenu(Order order,User client, Provider provider) throws PendingScoreException, BalanceInsufficient, InvalidPurchaseException, EmailException{
    	 if(scoringManager.hasPendingScoreForClient(client)){
    		 throw new PendingScoreException("Tiene calificaciones pendientes a completar");
    	 }
    	 manageSales(order,client,provider);
    	 
     }

	private void manageSales(Order order, User client, Provider provider) throws BalanceInsufficient, InvalidPurchaseException, EmailException {
		Double clientBalance= client.getAccount().balance();
		if(!isHasBalanceToBuy(clientBalance,calculatePriceToDiscount(order))){
			throw new BalanceInsufficient("No tiene dinero suficiente para realizar la compra");
		}
		forSale(order,client,provider);
	}

	private void forSale(Order order, User client, Provider provider) throws InvalidPurchaseException, BalanceInsufficient, EmailException {
		    if(!isWithinTheMaximumAmountOfMenuSales(order)){
		    	throw new InvalidPurchaseException("Se ha superado el limite de ventas");
		    }
		    finishSale(order,client,provider); 
		
	}

	private boolean isWithinTheMaximumAmountOfMenuSales(Order order) {	
		return order.getMenuToOrder().getNumberOfMenuSale()+ order.getNumberOfMenusToOrder()<order.getMenuToOrder().getMaximumNumberOfMenusSalesPerDay();
	}

	private void finishSale(Order order, User client, Provider provider) throws BalanceInsufficient, InvalidPurchaseException, EmailException {
		if(!isTheSaleOfTheMenuWithinTheLimitOfPurchase(order)){
		    	throw new InvalidPurchaseException("El pedido debe estar dentro de las 48 horas");
		}
		increaseNumberOfMenuSales(order.getMenuToOrder(),order.getNumberOfMenusToOrder());
		createNewScoreOfClient(provider,client,order.getMenuToOrder());
		chargeClientMenu(order, client);
		payTheProvider(order, provider);
		addOrderToConfirm(order);
	}
	
	private void addOrderToConfirm(Order order){
		this.ordersToConfirm.add(order);
	}

	private void payTheProvider(Order order, Provider provider) throws BalanceInsufficient, EmailException {
		 Double priceToAcredit= calculatePriceToDiscount(order);
	     Transaction newTransaction= new Transaction(TypeTransaction.CREDIT,priceToAcredit);
	     order.setProvider(provider);
	     order.setTransactionProvider(newTransaction);
		 this.mail.send(provider.getEmail(), "Pedido Pendiente", "Se realizo una compra por "+ priceToAcredit.toString());
		
	}

	private void increaseNumberOfMenuSales(Menu menu,Integer numberOfMenusToOrder) {
		menuManager.increaseNumberOfMenuSales(menu,numberOfMenusToOrder);
		
	}

	private  void chargeClientMenu(Order order, User client) throws BalanceInsufficient, EmailException {
		Double priceToDiscount= calculatePriceToDiscount(order);
		Transaction newTransaction= new Transaction(TypeTransaction.DEBIT,priceToDiscount);
		client.getAccount().addTransaction(newTransaction);
		this.mail.send(client.getEmail(), "Cobro de pedido", "Se descontaron "+ priceToDiscount.toString());
		order.setClient(client);
		order.setTransactionClient(newTransaction);		
		
	}

	private Double calculatePriceToDiscount(Order order) {
		Double priceToDiscount=order.getNumberOfMenusToOrder() *
		                       order.getMenuToOrder().getMenuDeliveryPrice().getValue();
		if(order.getTypeOfDelivery()==TypeOfDelivery.HOMEDELIVERY){
			priceToDiscount+= order.getMenuToOrder().getMenuDeliveryPrice().getValue();
		}
		return priceToDiscount;
	}

	private void createNewScoreOfClient(Provider provider,User client, Menu menu) {
		Score newScore= new Score(provider, client, menu);
		this.scoringManager.addScore(newScore);
		
	}

	private boolean isTheSaleOfTheMenuWithinTheLimitOfPurchase(Order order){
	   DateTime purchaseDayMade= new DateTime();
       Integer days= Days.daysBetween(purchaseDayMade.toLocalDate(),order.getDateOfDelivery().toLocalDate()).getDays();
	   return days>=2;
	}

	private boolean isHasBalanceToBuy(Double clientBalance,Double orderPrice) {	
		return clientBalance>=orderPrice;
	}

}
