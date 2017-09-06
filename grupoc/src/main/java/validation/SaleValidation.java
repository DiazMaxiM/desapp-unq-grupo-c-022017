package validation;

import org.joda.time.DateTime;
import org.joda.time.Days;

import exception.BalanceInsufficient;
import exception.InvalidPurchaseException;
import exception.PendingScoreException;
import model.Order;
import model.ScoringManager;
import model.TypeOfDelivery;
import model.User;

public class SaleValidation extends Validation{
    
    ScoringManager scoringManager;
	public SaleValidation(ScoringManager scoringManager){
		this.scoringManager= scoringManager;
		
	}
	public boolean isValidSale(Order order) throws BalanceInsufficient, PendingScoreException, InvalidPurchaseException {
		return isNotHasPendingScoreForClient(order.getClient())
			   && isHasClientBalanceToBuy(order)
		       && isTheSaleOfTheMenuWithinTheLimitOfPurchase(order)
		       && isWithinTheMaximumAmountOfMenuSales(order);
	}
	
	private boolean isNotHasPendingScoreForClient(User client) throws PendingScoreException {
		 if(scoringManager.hasPendingScoreForClient(client)){
    		 throw new PendingScoreException("Tiene calificaciones pendientes a completar");
    	 }
		return true;
	}
	private boolean isHasClientBalanceToBuy(Order order) throws BalanceInsufficient {
		Double clientBalance= order.getClient().getAccount().balance();
		if(!isHasBalanceToBuy(clientBalance,calculatePriceToDiscount(order))){
			throw new BalanceInsufficient("No tiene dinero suficiente para realizar la compra");
		}
		return true;
	}
	
	private boolean isHasBalanceToBuy(Double clientBalance, Double orderPrice) {
		return clientBalance >= orderPrice;
	}
	
	private Double calculatePriceToDiscount(Order order) {
		Double priceToDiscount = order.getNumberOfMenusToOrder()
				* order.getMenuToOrder().getMenuDeliveryPrice().getValue();
		if (order.getTypeOfDelivery() == TypeOfDelivery.HOMEDELIVERY) {
			priceToDiscount += order.getMenuToOrder().getMenuDeliveryPrice().getValue();
		}
		return priceToDiscount;
	}
	
	
	private boolean isTheSaleOfTheMenuWithinTheLimitOfPurchase(Order order) throws InvalidPurchaseException {
		if(!isMenuWithinTheLimitOfPurchase(order)){
	    	throw new InvalidPurchaseException("El pedido debe estar dentro de las 48 horas");
	     }		
		return true;
	}
	private boolean isMenuWithinTheLimitOfPurchase(Order order) {
		DateTime purchaseDayMade = new DateTime();
		Integer days = Days.daysBetween(purchaseDayMade.toLocalDate(), order.getDateOfDelivery().toLocalDate())
				.getDays();
		return days >= 2;
	}
	private boolean isWithinTheMaximumAmountOfMenuSales(Order order) throws InvalidPurchaseException {
		if(!isHasServiceWithMenusToSale(order)){
	    	throw new InvalidPurchaseException("Se ha superado el limite de ventas");
	    }
		return true;
	}
	private boolean isHasServiceWithMenusToSale(Order order) {
		return order.getMenuToOrder().getNumberOfMenuSale() + order.getNumberOfMenusToOrder() < order.getMenuToOrder()
				.getMaximumNumberOfMenusSalesPerDay();
	}


}
