package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.mail.EmailException;
import org.joda.time.DateTime;

import exception.BalanceInsufficient;
import exception.InvalidPurchaseException;
import exception.InvalidTimeZoneException;
import exception.NumberOfMenusExceededException;
import exception.PendingScoreException;
import orderExceptions.InvalidDeliveryTimeException;
import serviceException.InvalidDeliveryLocation;
import validation.SaleValidation;

public class SalesAdministration {
	ScoringManager scoringManager;
	MenuManager menuManager;
	Mail mail;
	List<Order> ordersToConfirm = new ArrayList<>(); 
	SaleValidation validator;

	public SalesAdministration(ScoringManager scoringManager, MenuManager menuManager, Mail mail) {
		this.scoringManager = scoringManager;
		this.menuManager = menuManager;
		this.mail = mail;
		this.validator = new SaleValidation(scoringManager);

	}
	
    public void saleMenu(Order order) throws PendingScoreException, BalanceInsufficient, InvalidPurchaseException, EmailException, InvalidTimeZoneException, InvalidDeliveryLocation, InvalidDeliveryTimeException, NumberOfMenusExceededException{
    	 if(validator.isValidSale(order)){
    		 forSale(order); 
    	 }
     }

	private void forSale(Order order) throws BalanceInsufficient, InvalidPurchaseException, EmailException {
		increaseNumberOfMenuSales(order);
		chargeClientMenu(order);
		payTheProvider(order);
		// sendEmailClientAndProvider(order);
		addOrderToConfirm(order);
		addOrderAsHistoricalOrder(order);
	}

	private void sendEmailClientAndProvider(Order order) throws EmailException {
		this.mail.sendMailProviderSale(order.getProvider().getEmail());
		this.mail.sendMailClientBuy(order.getClient().getEmail());

	}

	private void addOrderToConfirm(Order order) {
		this.ordersToConfirm.add(order);
	}

	private void payTheProvider(Order order) throws BalanceInsufficient {
		Provider provider = order.getProvider();
		Double priceToAcredit = calculatePriceToDiscount(order);
		Transaction newTransaction = new Transaction(TypeTransaction.CREDIT, priceToAcredit);
		provider.getAccount().addTransaction(newTransaction);
		order.setTransactionProvider(newTransaction);
	}

	private void increaseNumberOfMenuSales(Order order) {
		menuManager.increaseNumberOfMenuSales(order.getMenuToOrder(), order.getNumberOfMenusToOrder());

	}

	private void chargeClientMenu(Order order) throws BalanceInsufficient, EmailException {
		Double priceToDiscount = calculatePriceToDiscount(order);
		Transaction newTransaction = new Transaction(TypeTransaction.DEBIT, priceToDiscount);
		newTransaction.setFinish();
		order.getClient().getAccount().addTransaction(newTransaction);
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

	private Score createNewScoreOfClient(Order order) {
		Score newScore = new Score(order.getProvider(), order.getClient(), order.getMenuToOrder());
		this.scoringManager.addScore(newScore);
		return newScore;
	}

	public List<Order> getSalesForDay(DateTime day) {
		return ordersToConfirm.stream()
				.filter(order -> order.getDateOfDelivery().getDayOfMonth() == day.getDayOfMonth()
						&& order.getDateOfDelivery().getMonthOfYear() == day.getMonthOfYear()
						&& order.getDateOfDelivery().getDayOfYear() == day.getDayOfYear())
				.collect(Collectors.toList());
	}

	public void addOrderAsHistoricalOrder(Order order) {
		order.getProvider()
				.addHistoricalOrder(new HistoricalOrder(this.createNewScoreOfClient(order), order.getDateOfDelivery(),
						order.getTypeStatusOrder(), order.getMenuToOrder(), calculatePriceToDiscount(order),
						order.getDateOfOrder(), order.getTypeOfDelivery()));
	}

}
