package tests;
import org.apache.commons.mail.EmailException;
import org.joda.time.DateTime;
import org.junit.Test;
import builders.ClientBuilder;
import builders.OrderBuilder;
import builders.ProviderBuilder;
import exception.BalanceInsufficient;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMenuException;
import exception.InvalidNumberStreetException;
import exception.InvalidPurchaseException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import exception.PendingScoreException;
import menuExceptions.InvalidDeliveryPriceException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidFirstMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMaximumNumberOfMunusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidStartDateOfferMenuException;
import model.Mail;
import model.MenuManager;
import model.Order;
import model.Provider;
import model.SalesAdministration;
import model.Score;
import model.ScoringManager;
import model.Transaction;
import model.TypeTransaction;
import model.User;
import orderExceptions.InvalidDateOfDeliveryException;
import orderExceptions.InvalidDeliveryTimeException;
import orderExceptions.InvalidNumberOfMenusToOrderException;
import orderExceptions.InvalidTypeOfDeliveryException;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
public class SalesAdministrationTest {

	@Test(expected = PendingScoreException.class)
	public void testShouldFailWhenAClienthas1ScorePending() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException, EmailException{
		User client = new ClientBuilder()
				        .build();
		client.setMail("zaracho.rosali@gmail.com");
		Order   order   = new OrderBuilder().build();
		Provider provider= new ProviderBuilder().build();
		Mail mail= new Mail().getInstance();
		ScoringManager scoringManager = new ScoringManager();
		MenuManager menuManager= new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		Score score= new Score(provider, client, order.getMenuToOrder());
		scoringManager.addScore(score);
		SalesAdministration salesAdministration= new SalesAdministration(scoringManager,menuManager,mail);
		salesAdministration.saleMenu(order, client, provider);
			
	}
	
	@Test(expected = BalanceInsufficient.class)
	public void testShouldFailWhenAClienthasInsufficientBalance() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException, EmailException{
		User client = new ClientBuilder()
				        .build();
		client.setMail("zaracho.rosali@gmail.com");
		Mail mail= new Mail().getInstance();
		Order   order   = new OrderBuilder().build();
		Provider provider= new ProviderBuilder().build();
		MenuManager menuManager= new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration= new SalesAdministration(scoringManager,menuManager,mail);
		salesAdministration.saleMenu(order, client, provider);
			
	}
	
	@Test(expected=InvalidPurchaseException.class)
	public void testShouldFailWhenAClientWantsBuyAMenuThatIsOutOfDate() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException, EmailException{
		User client = new ClientBuilder()
				        .build();
		client.setMail("zaracho.rosali@gmail.com");
		Mail mail= new Mail().getInstance();
		Transaction transaction= new Transaction(TypeTransaction.CREDIT,new Double(500));
		client.getAccount().addTransaction(transaction);
		DateTime dateOfDelivery= new DateTime("2017-09-03T07:22:05Z");
		Order  order   = new OrderBuilder()
				        .withDateOfDelivery(dateOfDelivery)
				        .build();
		Provider provider= new ProviderBuilder().build();
		MenuManager menuManager= new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration= new SalesAdministration(scoringManager,menuManager,mail);
		salesAdministration.saleMenu(order, client, provider);			
	}
	
	@Test(expected=InvalidPurchaseException.class)
	public void testShouldFailWhenAClientWantsBuyAMenuIsOutOfMaximunToBuy()throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException, EmailException{
		User client = new ClientBuilder()
				        .build();
		client.setMail("zaracho.rosali@gmail.com");
		Mail mail= new Mail().getInstance();
		Transaction transaction= new Transaction(TypeTransaction.CREDIT,new Double(500));
		client.getAccount().addTransaction(transaction);
		Order  order   = new OrderBuilder()
				        .withNumberOfMenusToOrder(30)
				        .withMaximunMenuToSell(20)
				        .build();
		Provider provider= new ProviderBuilder().build();
		MenuManager menuManager= new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration= new SalesAdministration(scoringManager,menuManager,mail);
		salesAdministration.saleMenu(order, client, provider);			
	}
	
	@Test()
	public void testShoulPassWhenAClientDoesNotHavePutStandingScoresHaveCreditAndTheMenuIsCurrent() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMenuException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException, EmailException{
		User client = new ClientBuilder()
				        .build();
		client.setMail("zaracho.rosali@gmail.com");
		Mail mail= new Mail().getInstance();
		Transaction transaction= new Transaction(TypeTransaction.CREDIT,new Double(500));
		client.getAccount().addTransaction(transaction);
		Order   order   = new OrderBuilder().build();				      
		Provider provider= new ProviderBuilder().build();
		MenuManager menuManager= new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration= new SalesAdministration(scoringManager,menuManager,mail);
		salesAdministration.saleMenu(order, client, provider);
	}
}
