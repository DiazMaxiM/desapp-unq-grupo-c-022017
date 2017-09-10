package tests;

import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;

import builders.ScoreBuilder;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import exception.InvalidTimeZoneException;
import exception.InvalidValueScoreException;
import junit.framework.Assert;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidMaximumNumberOfMunusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidPricesException;
import menuExceptions.InvalidStartDateOfferMenuException;
import model.Menu;
import model.Score;
import model.ScoringManager;
import model.User;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import validation.InvalidFormatTimeZoneException;
import validation.InvalidMenuPriceException;

public class ScoringManagerTest {

	@Test
	public void testIfAddNewScoreWhatNotValueScoreThenTheExistsScoresPendingForClient()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidTimeZoneException, InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {

		ScoringManager scoringManager = new ScoringManager();
		User client = Mockito.mock(User.class);
		Score score = new ScoreBuilder().setClient(client).build();

		scoringManager.addScore(score);

		Assert.assertTrue(scoringManager.hasPendingScoreForClient(client));

	}

	@Test
	public void testIfAddNewScoreWhatHasValueScoreThenTheNotExistsScoresPendingForClient() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTimeZoneException, InvalidFormatTimeZoneException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, InvalidValueScoreException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException
	     {

		ScoringManager scoringManager = new ScoringManager();
		User client = Mockito.mock(User.class);
		Score score = new ScoreBuilder().setClient(client).build();
		score.setScore(3);
		scoringManager.addScore(score);

		Assert.assertFalse(scoringManager.hasPendingScoreForClient(client));

	}

	@Test
	public void testIfAddTwoNewsScoresWithValueScore3And4ThenTheAverageIs3point5()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidValueScoreException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException, InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {

		ScoringManager scoringManager = new ScoringManager();
		Menu menu = Mockito.mock(Menu.class);
		User client = Mockito.mock(User.class);
		User client2 = Mockito.mock(User.class);

		Score score = new ScoreBuilder().setClient(client).setMenu(menu).build();
		Score score2 = new ScoreBuilder().setClient(client2).setMenu(menu).build();
		score.setScore(4);
		score2.setScore(3);
		scoringManager.addScore(score);
		scoringManager.addScore(score2);

		Assert.assertEquals(scoringManager.averageScoresForMenu(menu), new Double(3.5));

	}

	@Test
	public void testIfAddTwentyNewsScoresWithAvarege1ThenRetunListWith1Element()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidValueScoreException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException, InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {

		ScoringManager scoringManager = new ScoringManager();
		Menu menu = Mockito.mock(Menu.class);
		User client = Mockito.mock(User.class);
		Score score;
		for (int i = 0; i < 20; i++) {
			score = new ScoreBuilder().setClient(client).setMenu(menu).build();
			score.setScore(1);
			scoringManager.addScore(score);
		}
		Assert.assertTrue(scoringManager.menuWith20ScoresAndAverageLess2().contains(menu));
		Assert.assertEquals(scoringManager.menuWith20ScoresAndAverageLess2().size(), 1);

	}

	@Test
	public void testIfAddTwentyNewsScoresWithAvarege3ThenRetunListWith0Element()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidValueScoreException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException, InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {

		ScoringManager scoringManager = new ScoringManager();
		Menu menu = Mockito.mock(Menu.class);
		User client = Mockito.mock(User.class);
		Score score;
		for (int i = 0; i < 20; i++) {
			score = new ScoreBuilder().setClient(client).setMenu(menu).build();
			score.setScore(3);
			scoringManager.addScore(score);
		}
		Assert.assertFalse(scoringManager.menuWith20ScoresAndAverageLess2().contains(menu));
		Assert.assertEquals(scoringManager.menuWith20ScoresAndAverageLess2().size(), 0);

	}

	@Test
	public void testIfGetListOrderForScoreThenGetFirtsMenuWithBestAverageScore()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidValueScoreException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException, InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {

		ScoringManager scoringManager = new ScoringManager();
		Menu menu = Mockito.mock(Menu.class);
		Menu menu2 = Mockito.mock(Menu.class);
		Menu menu3 = Mockito.mock(Menu.class);
		User client = Mockito.mock(User.class);
		Score score;

		for (int i = 0; i < 20; i++) {
			score = new ScoreBuilder().setClient(client).setMenu(menu).build();
			score.setScore(3);
			scoringManager.addScore(score);
		}
		for (int i = 0; i < 20; i++) {
			score = new ScoreBuilder().setClient(client).setMenu(menu2).build();
			score.setScore(4);
			scoringManager.addScore(score);
		}
		for (int i = 0; i < 20; i++) {
			score = new ScoreBuilder().setClient(client).setMenu(menu3).build();
			score.setScore(1);
			scoringManager.addScore(score);
		}
		Map<Menu, Double> mapMenuScoringAverage = scoringManager.getMenusWithAverage();
		Assert.assertTrue(mapMenuScoringAverage.get(menu).equals(new Double(3.0)));
		Assert.assertTrue(mapMenuScoringAverage.get(menu2).equals(new Double(4.0)));
		Assert.assertTrue(mapMenuScoringAverage.get(menu3).equals(new Double(1.0)));

	}

}
