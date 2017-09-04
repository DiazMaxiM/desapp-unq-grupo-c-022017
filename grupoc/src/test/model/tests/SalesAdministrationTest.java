package tests;
import org.joda.time.DateTime;
import org.junit.Test;
import builders.ClientBuilder;
import builders.MenuBuilder;
import builders.OrderBuilder;
import exception.BalanceInsufficient;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidCountryCodeException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
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
import model.Client;
import model.Menu;
import model.MenuManager;
import model.Order;
import model.Provider;
import model.SalesAdministration;
import model.Score;
import model.ScoringManager;
import model.Transaction;
import model.TypeTransaction;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
public class SalesAdministrationTest {

	@Test(expected = PendingScoreException.class)
	public void testShouldFailWhenAClienthas1ScorePending() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException{
		Client client = new ClientBuilder()
				        .build();
		Order   order   = new OrderBuilder().build();
		Provider provider= new Provider();
		ScoringManager scoringManager = new ScoringManager();
		MenuManager menuManager= new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		Score score= new Score(provider, client, order.getMenuToOrder());
		scoringManager.addScore(score);
		SalesAdministration salesAdministration= new SalesAdministration(scoringManager,menuManager);
		salesAdministration.saleMenu(order, client, provider);
			
	}
	
	@Test(expected = BalanceInsufficient.class)
	public void testShouldFailWhenAClienthasInsufficientBalance() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException{
		Client client = new ClientBuilder()
				        .build();
		Order   order   = new OrderBuilder().build();
		Provider provider= new Provider();
		MenuManager menuManager= new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration= new SalesAdministration(scoringManager,menuManager);
		salesAdministration.saleMenu(order, client, provider);
			
	}
	
	@Test(expected=InvalidPurchaseException.class)
	public void testShouldFailWhenAClientWantsBuyAMenuThatIsOutOfDate() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException{
		Client client = new ClientBuilder()
				        .build();
		Transaction transaction= new Transaction(TypeTransaction.CREDIT,new Double(500));
		client.getAccount().addTransaction(transaction);
		DateTime dateOfDelivery= new DateTime("2017-09-03T07:22:05Z");
		Order  order   = new OrderBuilder()
				        .withDateOfDelivery(dateOfDelivery)
				        .build();
		Provider provider= new Provider();
		MenuManager menuManager= new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration= new SalesAdministration(scoringManager,menuManager);
		salesAdministration.saleMenu(order, client, provider);			
	}
	
	@Test(expected=InvalidPurchaseException.class)
	public void testShouldFailWhenAClientWantsBuyAMenuIsOutOfMaximunToBuy()throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException{
		Client client = new ClientBuilder()
				        .build();
		Transaction transaction= new Transaction(TypeTransaction.CREDIT,new Double(500));
		client.getAccount().addTransaction(transaction);
		Order  order   = new OrderBuilder()
				        .withNumberOfMenusToOrder(30)
				        .withMaximunMenuToSell(20)
				        .build();
		Provider provider= new Provider();
		MenuManager menuManager= new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration= new SalesAdministration(scoringManager,menuManager);
		salesAdministration.saleMenu(order, client, provider);			
	}
	
	@Test()
	public void testShoulPassWhenAClientDoesNotHavePutStandingScoresHaveCreditAndTheMenuIsCurrent() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException{
		Client client = new ClientBuilder()
				        .build();
		Transaction transaction= new Transaction(TypeTransaction.CREDIT,new Double(500));
		client.getAccount().addTransaction(transaction);
		Order   order   = new OrderBuilder().build();				      
		Provider provider= new Provider();
		MenuManager menuManager= new MenuManager();
		menuManager.addMenu(order.getMenuToOrder());
		ScoringManager scoringManager = new ScoringManager();
		SalesAdministration salesAdministration= new SalesAdministration(scoringManager,menuManager);
		salesAdministration.saleMenu(order, client, provider);
	}
}
