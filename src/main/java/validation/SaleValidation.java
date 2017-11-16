package validation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDateTime;

import exception.BalanceInsufficient;
import exception.InvalidPurchaseException;
import exception.InvalidTimeZoneException;
import exception.NumberOfMenusExceededException;
import exception.PendingScoreException;
import model.HolidaysChecker;
import model.Locality;
import model.Order;
import model.ScoringManager;
import model.TimeZone;
import model.TypeOfDelivery;
import model.User;
import orderExceptions.InvalidDateOfDeliveryException;
import orderExceptions.InvalidDeliveryTimeException;
import serviceException.InvalidDeliveryLocation;

public class SaleValidation extends Validation {

	ScoringManager scoringManager;
	HolidaysChecker holidayChecker = new HolidaysChecker();

	public SaleValidation(ScoringManager scoringManager) {
		this.scoringManager = scoringManager;

	}

	public boolean isValidSale(Order order) throws BalanceInsufficient, PendingScoreException, InvalidPurchaseException,
			InvalidTimeZoneException, InvalidDeliveryLocation, InvalidDeliveryTimeException,
			NumberOfMenusExceededException, IOException, InvalidDateOfDeliveryException {
		return isNotHasPendingScoreForClient(order.getClient()) && isHasClientBalanceToBuy(order)
				&& isTheSaleWithinDeliveryLocationsAndTimes(order) && isTheSaleWithinTheWorkingHoursofTheService(order)
				&& isTheSaleOfTheMenuWithinTheLimitOfPurchase(order) && isWithinTheMaximumAmountOfMenuSales(order);
	}

	private boolean isTheSaleWithinDeliveryLocationsAndTimes(Order order) throws InvalidPurchaseException,
			InvalidDeliveryLocation, InvalidDeliveryTimeException, InvalidTimeZoneException {
		if (order.getTypeOfDelivery().equals(TypeOfDelivery.HOMEDELIVERY)) {
			return isWithinDeliveryLocations(order) && isWithinDeliveryTimesOfMenus(order);
		}
		return true;
	}

	private boolean isWithinDeliveryTimesOfMenus(Order order)
			throws InvalidDeliveryTimeException, InvalidTimeZoneException {
		boolean isTimeZoneOrderInMenuDeliveryTime = false;
		List<TimeZone> menuDeliveryTimes = order.getMenuToOrder().getDeliveryTimesMenus();
		TimeZone timeZoneOrder = order.getDeliveryTime();
		for (TimeZone timeZone : menuDeliveryTimes) {
			isTimeZoneOrderInMenuDeliveryTime = isTimeZoneOrderInMenuDeliveryTime
					|| timeZone.isWithinRangeofWorking(timeZoneOrder);

		}
		if (!isTimeZoneOrderInMenuDeliveryTime) {
			throw new InvalidDeliveryTimeException(
					"El horario de entrega debe estar dentro de los horarios de delivey");
		}
		return isTimeZoneOrderInMenuDeliveryTime;
	}

	private boolean isWithinDeliveryLocations(Order order) throws InvalidPurchaseException, InvalidDeliveryLocation {
		List<Locality> serviceDeliveryLocality = order.getMenuToOrder().getService().getServiceDeliveryLocations();
		Locality localityClient = order.getClient().getAddress().getLocality();
		if (!(serviceDeliveryLocality.contains(localityClient))) {
			throw new InvalidDeliveryLocation("Su localidad no esta dentro de los limites de entregas");
		}
		return true;
	}

	private boolean isTheSaleWithinTheWorkingHoursofTheService(Order order)
			throws InvalidPurchaseException, InvalidTimeZoneException, IOException, InvalidDateOfDeliveryException {
		Integer dayOfWeek = order.getDateOfDelivery().getDayOfWeek();
		HashMap<Integer, List<TimeZone>> workingsHours = order.getMenuToOrder().getService().getServiceWorkingHours();
		if (!(isThePurchaseMadeWithinOneBusinessDay(workingsHours, dayOfWeek)
				&& isTheDeliveryDateIsNotMadeOnHoliday(order.getDateOfDelivery())
				&& isThePurchaseWithinTheWorkingHoursOfBusinessDay(workingsHours, dayOfWeek,
						order.getDeliveryTime()))) {
			throw new InvalidPurchaseException("La compra debe ser dentro de los dias y horarios laborales");
		}
		return true;
	}

	private boolean isTheDeliveryDateIsNotMadeOnHoliday(LocalDateTime localDateTime)
			throws IOException, InvalidDateOfDeliveryException {
		if (holidayChecker.isHolidays(localDateTime)) {
			throw new InvalidDateOfDeliveryException("No se realizan ventas los dias feriados");
		}

		return true;

	}

	private boolean isThePurchaseWithinTheWorkingHoursOfBusinessDay(HashMap<Integer, List<TimeZone>> workingsHours,
			Integer dayOfWeek, TimeZone deliveryTimeOfClientWantsTheOrder) throws InvalidTimeZoneException {
		boolean isInTimeWorking = false;
		List<TimeZone> hours = workingsHours.get(dayOfWeek);
		for (TimeZone timeZone : hours) {
			isInTimeWorking = isInTimeWorking || timeZone.isWithinRangeofWorking(deliveryTimeOfClientWantsTheOrder);
		}
		return isInTimeWorking;
	}

	private boolean isThePurchaseMadeWithinOneBusinessDay(HashMap<Integer, List<TimeZone>> workingsHours,
			Integer dayOfWeek) {
		return workingsHours.containsKey(dayOfWeek);
	}

	private boolean isNotHasPendingScoreForClient(User client) throws PendingScoreException {
		if (scoringManager.hasPendingScoreForClient(client)) {
			throw new PendingScoreException("Tiene calificaciones pendientes a completar");
		}
		return true;
	}

	private boolean isHasClientBalanceToBuy(Order order) throws BalanceInsufficient {
		Double clientBalance = order.getClient().getAccount().balance();
		if (!isHasBalanceToBuy(clientBalance, calculatePriceToDiscount(order))) {
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
		if (!isMenuWithinTheLimitOfPurchase(order)) {
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

	private boolean isWithinTheMaximumAmountOfMenuSales(Order order) throws NumberOfMenusExceededException {
		if (!isHasServiceWithMenusToSale(order)) {
			throw new NumberOfMenusExceededException("Se ha superado el limite de ventas");
		}
		return true;
	}

	private boolean isHasServiceWithMenusToSale(Order order) {
		return order.getMenuToOrder().getNumberOfMenuSale() + order.getNumberOfMenusToOrder() < order.getMenuToOrder()
				.getMaximumNumberOfMenusSalesPerDay();
	}

}
