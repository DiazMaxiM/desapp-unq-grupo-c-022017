package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

import exception.BalanceInsufficient;
import exception.InvalidPurchaseException;
import exception.PendingScoreException;

public class SalesAdministration {
	ScoringManager scoringManager;
	MenuManager    menuManager;
	List<Order> ordersToConfirm= new ArrayList<>();
	
	public SalesAdministration(ScoringManager scoringManager, MenuManager menuManager){
		this.scoringManager=scoringManager;
		this.menuManager= menuManager;
		
	}
	
     public void saleMenu(Order order, Client client, Provider provider) throws PendingScoreException, BalanceInsufficient, InvalidPurchaseException{
    	 if(scoringManager.hasPendingScoreForClient(client)){
    		 throw new PendingScoreException("Tiene calificaciones pendientes a completar");
    	 }
    	 manageSales(order,client,provider);
    	 
     }

	private void manageSales(Order order, Client client, Provider provider) throws BalanceInsufficient, InvalidPurchaseException {
		Double clientBalance= client.getAccount().balance();
		if(!isHasBalanceToBuy(clientBalance,order.getMenuToOrder().getMenuPrice())){
			throw new BalanceInsufficient("No tiene dinero suficiente para realizar la compra");
		}
		forSale(order,client,provider);
	}

	private void forSale(Order order, Client client, Provider provider) throws InvalidPurchaseException, BalanceInsufficient {
		    if(!isWithinTheMaximumAmountOfMenuSales(order)){
		    	throw new InvalidPurchaseException("Se ha superado el limite de ventas");
		    }
		    finishSale(order,client,provider); 
		
	}

	private boolean isWithinTheMaximumAmountOfMenuSales(Order order) {	
		return order.getMenuToOrder().getNumberOfMenuSale()+ order.getNumberOfMenusToOrder()<order.getMenuToOrder().getMaximumNumberOfMenusSalesPerDay();
	}

	private void finishSale(Order order, Client client, Provider provider) throws BalanceInsufficient, InvalidPurchaseException {
		if(!isTheSaleOfTheMenuWithinTheLimitOfPurchase(order)){
		    	throw new InvalidPurchaseException("El pedido debe estar dentro de las 48 horas");
		}
		increaseNumberOfMenuSales(order.getMenuToOrder(),order.getNumberOfMenusToOrder());
		createNewScoreOfClient(provider,client,order.getMenuToOrder());
		order.setTransactionClient(chargeClientMenu(order.getMenuToOrder(),client));
		order.setTransactionProvider(payTheProvider(order.getMenuToOrder(),provider));
		addOrderToConfirm(order);
	}
	
	private void addOrderToConfirm(Order order){
		this.ordersToConfirm.add(order);
	}

	private Transaction payTheProvider(Menu menu, Provider provider) throws BalanceInsufficient {
	     Transaction newTransaction= new Transaction(TypeTransaction.CREDIT,menu.getMenuPrice().getValue());
		 provider.getAccount().addTransaction(newTransaction);
		 return newTransaction;
	}

	private void increaseNumberOfMenuSales(Menu menu,Integer numberOfMenusToOrder) {
		menuManager.increaseNumberOfMenuSales(menu,numberOfMenusToOrder);
		
	}

	private Transaction chargeClientMenu(Menu menu, Client client) throws BalanceInsufficient {
		Transaction newTransaction= new Transaction(TypeTransaction.DEBIT, menu.getMenuPrice().getValue());
		client.getAccount().addTransaction(newTransaction);
		return newTransaction;
		
	}

	private void createNewScoreOfClient(Provider provider,Client client, Menu menu) {
		Score newScore= new Score(provider, client, menu);
		this.scoringManager.addScore(newScore);
		
	}

	private boolean isTheSaleOfTheMenuWithinTheLimitOfPurchase(Order order){
	   DateTime purchaseDayMade= new DateTime();
       Integer days= Days.daysBetween(purchaseDayMade.toLocalDate(),order.getDateOfDelivery().toLocalDate()).getDays();
	   return days>=2;
	}

	private boolean isHasBalanceToBuy(Double clientBalance,Price menuPrice) {	
		return clientBalance>=menuPrice.getValue();
	}

}
