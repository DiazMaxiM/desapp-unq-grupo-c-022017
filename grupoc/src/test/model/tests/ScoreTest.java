package tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import builders.ScoreBuilder;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidCountryCodeException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import exception.InvalidTimeZoneException;
import exception.InvalidValueScoreException;
import menuExceptions.InvalidDeliveryPriceException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidMaximumNumberOfMunusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidStartDateOfferMenuException;
import model.Provider;
import model.Score;
import model.User;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import validation.InvalidFormatTimeZoneException;

public class ScoreTest {

	@Test
	public void testIfCreateNewScoreThenTheStatusIsPendingIsTrue()
			throws InvalidServiceException, InvalidMenuNameException, InvalidMenuDescriptionException,
			InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay,
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidAddressException, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidTimeZoneException, InvalidFormatTimeZoneException {
		Score score = new ScoreBuilder().build();

		Assert.assertTrue(score.isPending());
		Assert.assertFalse(score.isFinish());
	}

	@Test
	public void testIfCreateNewScoreAndHasAScoreThenTheStatusIsPendingIsFalse()
			throws InvalidServiceException, InvalidMenuNameException, InvalidMenuDescriptionException,
			InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay,
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidAddressException, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidValueScoreException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException, InvalidFormatTimeZoneException {
		Score score = new ScoreBuilder().build();
		score.setScore(3);
		Assert.assertEquals(score.getValue(), new Integer(3));
		Assert.assertFalse(score.isPending());
		Assert.assertTrue(score.isFinish());
	}

	@Test(expected = InvalidValueScoreException.class)
	public void testIfCreateNewScoreAndHasAScore8ThenInvalidValueScoreException()
			throws InvalidServiceException, InvalidMenuNameException, InvalidMenuDescriptionException,
			InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay,
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidAddressException, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidValueScoreException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException, InvalidFormatTimeZoneException {
		Score score = new ScoreBuilder().build();
		score.setScore(8);

	}

	@Test
	public void testIfCreateNewScoreAndHasAClientThenTheClientsAreEquals()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidTimeZoneException, InvalidFormatTimeZoneException {
		User client = Mockito.mock(User.class);

		Score score = new ScoreBuilder().setClient(client).build();

		Assert.assertTrue(score.isClient(client));

	}

	@Test
	public void testIfCreateNewScoreAndHasAProviderThenTheProvidersAreEquals()
			throws InvalidServiceException, InvalidAddressException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidTimeZoneException, InvalidFormatTimeZoneException {
		Provider provider = Mockito.mock(Provider.class);

		Score score = new ScoreBuilder().setProvider(provider).build();

		Assert.assertTrue(score.isProvider(provider));

	}

}
