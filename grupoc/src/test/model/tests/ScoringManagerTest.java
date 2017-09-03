package tests;

import org.junit.Test;
import org.mockito.Mockito;

import builders.ScoreBuilder;
import exception.InvalidAddressException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import exception.InvalidValueScoreException;
import junit.framework.Assert;
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
import model.Provider;
import model.Score;
import model.ScoringManager;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;

public class ScoringManagerTest {

	@Test
	public void testIfAddNewScoreWhatNotValueScoreThenTheExistsScoresPendingForClient()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException {

		ScoringManager scoringManager = new ScoringManager();
		Client client = Mockito.mock(Client.class);
		Score score = new ScoreBuilder().setClient(client).build();

		scoringManager.addScore(score);

		Assert.assertTrue(scoringManager.hasPendingScoreForClient(client));

	}

	@Test
	public void testIfAddNewScoreWhatHasValueScoreThenTheNotExistsScoresPendingForClient()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidValueScoreException {

		ScoringManager scoringManager = new ScoringManager();
		Client client = Mockito.mock(Client.class);
		Score score = new ScoreBuilder().setClient(client).build();
		score.setScore(3);
		scoringManager.addScore(score);

		Assert.assertFalse(scoringManager.hasPendingScoreForClient(client));

	}

	@Test
	public void testIfAddTwoNewsScoresWithValueScore3And4ThenTheAverageIs3point5()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidValueScoreException {

		ScoringManager scoringManager = new ScoringManager();
		Provider provider = Mockito.mock(Provider.class);
		Client client = Mockito.mock(Client.class);
		Client client2 = Mockito.mock(Client.class);

		Score score = new ScoreBuilder().setClient(client).setProvider(provider).build();
		Score score2 = new ScoreBuilder().setClient(client2).setProvider(provider).build();
		score.setScore(4);
		score2.setScore(3);
		scoringManager.addScore(score);
		scoringManager.addScore(score2);

		Assert.assertEquals(scoringManager.averageScoresForProvider(provider), new Double(3.5));

	}

	@Test
	public void testIfAddTwentyNewsScoresWithAvarege1ThenRetunListWith1Element()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidValueScoreException {

		ScoringManager scoringManager = new ScoringManager();
		Provider provider = Mockito.mock(Provider.class);
		Client client = Mockito.mock(Client.class);
		Score score;
		for (int i = 0; i < 20; i++) {
			score = new ScoreBuilder().setClient(client).setProvider(provider).build();
			score.setScore(1);
			scoringManager.addScore(score);
		}
		Assert.assertTrue(scoringManager.providerWith20ScoresAndAverageLess2().contains(provider));
		Assert.assertEquals(scoringManager.providerWith20ScoresAndAverageLess2().size(), 1);

	}

	@Test
	public void testIfAddTwentyNewsScoresWithAvarege3ThenRetunListWith0Element()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidValueScoreException {

		ScoringManager scoringManager = new ScoringManager();
		Provider provider = Mockito.mock(Provider.class);
		Client client = Mockito.mock(Client.class);
		Score score;
		for (int i = 0; i < 20; i++) {
			score = new ScoreBuilder().setClient(client).setProvider(provider).build();
			score.setScore(3);
			scoringManager.addScore(score);
		}
		Assert.assertFalse(scoringManager.providerWith20ScoresAndAverageLess2().contains(provider));
		Assert.assertEquals(scoringManager.providerWith20ScoresAndAverageLess2().size(), 0);

	}

}
