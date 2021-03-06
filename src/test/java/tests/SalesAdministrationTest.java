package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import builders.OrderBuilder;
import exception.BalanceInsufficient;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidClientException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidMenuException;
import exception.InvalidNumberStreetException;
import exception.InvalidProviderException;
import exception.InvalidPurchaseException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import exception.InvalidTimeZoneException;
import exception.NumberOfMenusExceededException;
import exception.PendingScoreException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidMaximumNumberOfMenusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidPricesException;
import menuExceptions.InvalidStartDateOfferMenuException;
import model.Locality;
import model.Mail;
import model.MenuManager;
import model.Order;
import model.SalesAdministration;
import model.Score;
import model.ScoringManager;
import model.Service;
import model.TimeZone;
import model.Transaction;
import model.TypeOfDelivery;
import model.TypeTransaction;
import model.WorkingTime;
import orderExceptions.InvalidDateOfDeliveryException;
import orderExceptions.InvalidDeliveryTimeException;
import orderExceptions.InvalidNumberOfMenusToOrderException;
import orderExceptions.InvalidTypeOfDeliveryException;
import serviceException.InvalidDeliveryLocation;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
import validation.InvalidFormatTimeZoneException;
import validation.InvalidMenuPriceException;

public class SalesAdministrationTest {

	@Ignore
	@Test(expected = PendingScoreException.class)
	public void testShouldFailWhenAClienthas1ScorePending()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Order order = new OrderBuilder().build();
		Mail mail = new Mail().getInstance();
		ScoringManager scoringManager = new ScoringManager();
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		Score score = new Score(order.getProvider(), order.getClient(), order.getMenuToOrder());
		scoringManager.addScore(score);
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);

	}

	@Ignore
	@Test(expected = InvalidPurchaseException.class)
	public void testShouldFailWhenAClientWantsBuyAMenuThatIsOutOf48hours()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Mail mail = new Mail().getInstance();
		LocalDateTime dateOfDelivery = new DateTime("2017-09-03T07:22:05Z").toLocalDateTime();
		Order order = new OrderBuilder().withDateOfDelivery(dateOfDelivery).build();
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(500));
		order.getClient().getAccount().addTransaction(transaction);
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);
	}

	@Ignore
	@Test(expected = NumberOfMenusExceededException.class)
	public void testShouldFailWhenAClientWantsBuyAMenuIsOutOfMaximunToBuy()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Mail mail = new Mail().getInstance();
		Order order = new OrderBuilder().withNumberOfMenusToOrder(30).withMaximunMenuToSell(20).build();
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(500));
		order.getClient().getAccount().addTransaction(transaction);
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);
	}

	@Ignore
	@Test()
	public void testTheBalanceOfCustumerWith100PesosMustBe60PesosWhenBuyAMenuOf40PesosWithLocalDelivery()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Mail mail = new Mail().getInstance();
		Order order = new OrderBuilder().build();
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(100));
		order.getClient().getAccount().addTransaction(transaction);
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);
		Assert.assertEquals(new Double(60), order.getClient().getAccount().balance());
	}

	@Ignore
	@Test()
	public void testTheBalanceOfCustumerWith100PesosMustBe5PesosWhenBuy2MenusOf40PesosWithHomeDelivery()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Mail mail = new Mail().getInstance();
		Order order = new OrderBuilder().withNumberOfMenusToOrder(2).withTypeOfDelivery(TypeOfDelivery.HOMEDELIVERY)
				.build();
		order.getClient().getAddress().setLocality(Locality.FLORENCIOVARELA);
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(100));
		order.getClient().getAccount().addTransaction(transaction);
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);
		Assert.assertEquals(new Double(5), order.getClient().getAccount().balance());
	}

	@Ignore
	@Test(expected = BalanceInsufficient.class)
	public void testShouldFailWhenIClientWantsBuy3MenusOf40Pesos()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Mail mail = new Mail().getInstance();
		Order order = new OrderBuilder().withNumberOfMenusToOrder(3).build();
		order.getClient().getAddress().setLocality(Locality.FLORENCIOVARELA);
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(100));
		order.getClient().getAccount().addTransaction(transaction);
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);

	}

	@Test(expected = InvalidPurchaseException.class)
	public void testShouldFailWhenAClientWantsBuyAMenuIsOutOfDayWorkingOfTheService()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Mail mail = new Mail().getInstance();
		Order order = new OrderBuilder().withDateOfDelivery(new DateTime().plusDays(2).toLocalDateTime()).build();
		Service service = order.getMenuToOrder().getService();
		List<WorkingTime> serviceWorkingHours = new ArrayList<>();
		List<TimeZone> workingHours = new ArrayList<>();
		TimeZone lateShift = new TimeZone("17:00", "22:30");
		
		workingHours.add(lateShift);
		serviceWorkingHours.add(new WorkingTime(6,workingHours));
		serviceWorkingHours.add(new WorkingTime(7,workingHours));
		service.setServiceWorkingHours(serviceWorkingHours);
		
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(500));
		order.getClient().getAccount().addTransaction(transaction);
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);
	}

	@Test(expected = InvalidDeliveryLocation.class)
	public void testShouldFailWhenAClientWantsBuyAMenuIsOutOfDeliveryLocality()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Mail mail = new Mail().getInstance();
		Order order = new OrderBuilder().withTypeOfDelivery(TypeOfDelivery.HOMEDELIVERY).build();
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(500));
		order.getClient().getAccount().addTransaction(transaction);
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);
	}

	@Test(expected = InvalidDeliveryTimeException.class)
	public void testShouldFailWhenAClientWantsBuyAMenuIsOutOfDeliveryTimes()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Mail mail = new Mail().getInstance();
		TimeZone deliveryTime = new TimeZone("23:00", "23:50");
		Order order = new OrderBuilder().withDeliveryTime(deliveryTime).withTypeOfDelivery(TypeOfDelivery.HOMEDELIVERY)
				.build();
		order.getClient().getAddress().setLocality(Locality.FLORENCIOVARELA);
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(500));
		order.getClient().getAccount().addTransaction(transaction);
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);
	}

	@Ignore
	@Test(expected = InvalidPurchaseException.class)
	public void testShouldFailWhenAClientWantsBuyAMenuIsOutOfTimeWorkingOfTheService()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Mail mail = new Mail().getInstance();
		TimeZone deliveryTime = new TimeZone("23:00", "23:50");
		Order order = new OrderBuilder().withDeliveryTime(deliveryTime).build();
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(500));
		order.getClient().getAccount().addTransaction(transaction);
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);
	}

	@Ignore
	@Test(expected = InvalidDateOfDeliveryException.class)
	public void testShouldFailWhenAClientWantsBuyAMenuInAHoliday()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient,
			PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException,
			InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException,
			EmailException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidDeliveryLocation, InvalidMapPositionException,
			NumberOfMenusExceededException, InvalidPricesException, InvalidMenuPriceException, IOException {
		Mail mail = new Mail().getInstance();
		Order order = new OrderBuilder().withDateOfDelivery(new DateTime(2017, 12, 8, 0, 0).toLocalDateTime()).build();
		Transaction transaction = new Transaction(TypeTransaction.CREDIT, new Double(500));
		order.getClient().getAccount().addTransaction(transaction);
		MenuManager menuManager = new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration = new SalesAdministration(scoringManager, menuManager, mail);
		salesAdministration.saleMenu(order);
	}

}
