package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.mail.EmailException;
import org.joda.time.DateTime;
import org.joda.time.Days;

import exception.BalanceInsufficient;
import exception.InvalidPurchaseException;
import exception.PendingScoreException;

public class SalesAdministration {
	ScoringManager scoringManager;
	MenuManager menuManager;
	Mail mail;
	List<Order> ordersToConfirm = new ArrayList<>();

	public SalesAdministration(ScoringManager scoringManager, MenuManager menuManager, Mail mail) {
		this.scoringManager = scoringManager;
		this.menuManager = menuManager;
		this.mail = mail;

	}
	
    public void saleMenu(Order order) throws PendingScoreException, BalanceInsufficient, InvalidPurchaseException, EmailException{
    	 if(scoringManager.hasPendingScoreForClient(order.getClient())){
    		 throw new PendingScoreException("Tiene calificaciones pendientes a completar");
    	 }
    	 manageSales(order);
    	 
     }

	private void manageSales(Order order) throws BalanceInsufficient, InvalidPurchaseException, EmailException {
		Double clientBalance= order.getClient().getAccount().balance();
		if(!isHasBalanceToBuy(clientBalance,calculatePriceToDiscount(order))){
			throw new BalanceInsufficient("No tiene dinero suficiente para realizar la compra");
		}
		forSale(order);
	}


	private void forSale(Order order) throws InvalidPurchaseException, BalanceInsufficient, EmailException {
		    if(!isWithinTheMaximumAmountOfMenuSales(order)){
		    	throw new InvalidPurchaseException("Se ha superado el limite de ventas");
		    }
		    finishSale(order); 
	}

	private boolean isWithinTheMaximumAmountOfMenuSales(Order order) {
		return order.getMenuToOrder().getNumberOfMenuSale() + order.getNumberOfMenusToOrder() < order.getMenuToOrder()
				.getMaximumNumberOfMenusSalesPerDay();
	}
	
	private void finishSale(Order order) throws BalanceInsufficient, InvalidPurchaseException, EmailException {
		if(!isTheSaleOfTheMenuWithinTheLimitOfPurchase(order)){
		    	throw new InvalidPurchaseException("El pedido debe estar dentro de las 48 horas");
		}
		increaseNumberOfMenuSales(order.getMenuToOrder(), order.getNumberOfMenusToOrder());
		createNewScoreOfClient(order);
		chargeClientMenu(order);
		payTheProvider(order);
		addOrderToConfirm(order);
	}

	private void addOrderToConfirm(Order order) {
		this.ordersToConfirm.add(order);
	}

	private void payTheProvider(Order order) throws BalanceInsufficient, EmailException {
		 Provider provider = order.getProvider();
		 Double priceToAcredit = calculatePriceToDiscount(order);
	     Transaction newTransaction= new Transaction(TypeTransaction.CREDIT,priceToAcredit);
	     provider.getAccount().addTransaction(newTransaction);
	     order.setTransactionProvider(newTransaction);
		 this.mail.sendMailProviderSale(provider.getEmail());
	}

	private void increaseNumberOfMenuSales(Menu menu, Integer numberOfMenusToOrder) {
		menuManager.increaseNumberOfMenuSales(menu, numberOfMenusToOrder);

	}

	private  void chargeClientMenu(Order order) throws BalanceInsufficient, EmailException {
		Double priceToDiscount= calculatePriceToDiscount(order);
		Transaction newTransaction= new Transaction(TypeTransaction.DEBIT,priceToDiscount);
		newTransaction.setFinish();
		order.getClient().getAccount().addTransaction(newTransaction);
		this.mail.sendMailClientBuy(order.getClient().getEmail());
		order.setTransactionClient(newTransaction);		
	}

	private Double calculatePriceToDiscount(Order order) {
		Double priceToDiscount = order.getNumberOfMenusToOrder()
				* order.getMenuToOrder().getMenuDeliveryPrice().getValue();
		if (order.getTypeOfDelivery() == TypeOfDelivery.HOMEDELIVERY) {
			priceToDiscount += order.getMenuToOrder().getMenuDeliveryPrice().getValue();
		}
		return priceToDiscount;
	}


	private void createNewScoreOfClient(Order order) {
		Score newScore= new Score(order.getProvider(),order.getClient(),order.getMenuToOrder());
		this.scoringManager.addScore(newScore);
	}

	private boolean isTheSaleOfTheMenuWithinTheLimitOfPurchase(Order order) {
		DateTime purchaseDayMade = new DateTime();
		Integer days = Days.daysBetween(purchaseDayMade.toLocalDate(), order.getDateOfDelivery().toLocalDate())
				.getDays();
		return days >= 2;
	}

	private boolean isHasBalanceToBuy(Double clientBalance, Double orderPrice) {
		return clientBalance >= orderPrice;
	}

	public List<Order> getSalesForDay(DateTime day) {
		return ordersToConfirm.stream()
				.filter(order -> order.getDateOfDelivery().getDayOfMonth() == day.getDayOfMonth()
						&& order.getDateOfDelivery().getMonthOfYear() == day.getMonthOfYear()
						&& order.getDateOfDelivery().getDayOfYear() == day.getDayOfYear())
				.collect(Collectors.toList());
	}

}
