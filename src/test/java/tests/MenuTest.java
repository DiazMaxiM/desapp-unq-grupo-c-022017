package tests;

import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.junit.Test;

import builders.MenuBuilder;
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
import model.Menu;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import validation.InvalidFormatTimeZoneException;
import validation.InvalidMenuPriceException;
import validation.MenuValidation;

public class MenuTest {

	@Test()
	public void testShouldPassWhenICreateAValidMenu() throws InvalidMenuNameException, InvalidMenuDescriptionException,
			InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		Menu menu = new MenuBuilder().build();
		MenuValidation validator = new MenuValidation();
		assertTrue(validator.isAValidMenu(menu.getMenuName(), menu.getMenuDescription(), menu.getMenuCategory(),
				menu.getMenuDeliveryPrice(), menu.getStartDateOfferMenu(), menu.getEndDateOfferMenu(),
				menu.getAverageDeliveryTimeOfMenu(), menu.getFirstMinimumNumberOfMenusToBuy(),
				menu.getFirstminimumPriceOfMenusToBuy(), menu.getSecondMinimumNumberOfMenusToBuy(),
				menu.getSecondMinimumPriceOfMenusToBuy(), menu.getMaximumNumberOfMenusSalesPerDay(), menu.getService(),
				menu.getMenuPrice()));
	}

	@Test(expected = InvalidMaximumNumberOfMenusSalesPerDay.class)
	public void testShouldFailWhenICreateAnInvalidMaximumNumberOfMenusSalesPerDay()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withMaximumNumberOfMenusSalesPerDay(null).build();
	}

	@Test(expected = InvalidMenuNameException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithAShortName()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withMenuName("ppp").build();
	}

	@Test(expected = InvalidMenuDescriptionException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithAShortDescription()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withMenuDescription("ppp").build();
	}

	@Test(expected = InvalidMenuCategoryException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidCategory()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withMenuCategory(null).build();
	}

	@Test(expected = InvalidMenuDeliveryPriceException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidMenuDeliveryPrice()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withMenuDeliveryPrice(new Double(50)).build();
	}

	@Test(expected = InvalidStartDateOfferMenuException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidStartDateOfferMenu()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withStartDateOfferMenu(null).build();
	}

	@Test(expected = InvalidStartDateOfferMenuException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithStartDateOfferMenuBeforeToday()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {

		LocalDateTime startDate = new DateTime(2017, 9, 6, 0, 0).toLocalDateTime();
		new MenuBuilder().withStartDateOfferMenu(startDate).build();
	}

	@Test(expected = InvalidEndDateOfferMenuException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithEndDateOfferMenuBeforeStartDate()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {

		LocalDateTime startDate = new DateTime().plusDays(1).toLocalDateTime();
		LocalDateTime endDate = new DateTime().minusDays(1).toLocalDateTime();
		new MenuBuilder().withStartDateOfferMenu(startDate).withEndDateOfferMenu(endDate).build();
	}

	@Test(expected = InvalidEndDateOfferMenuException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidEndDateOfferMenu()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withEndDateOfferMenu(null).build();
	}

	@Test(expected = InvalidAverageDeliveryTimeOfMenuException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidAverageDeliveryTimeOfMenu()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withAverageDeliveryTimeOfMenu(null).build();
	}

	@Test(expected = InvalidMinimumNumberOfMenusToBuyException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidFirstMinimumNumberOfMenusToBuy()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withFirstMinimumNumberOfMenusToBuy(100).build();
	}

	@Test(expected = InvalidMinimumPriceOfMenusToBuyException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidFirstMinimumPriceOfMenusToBuy()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withFirstMinimumPriceOfMenusToBuy(new Double(1500)).build();
	}

	@Test(expected = InvalidMinimumNumberOfMenusToBuyException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidSecondMinimumNumberOfMenusToBuy()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withSecondMinimumNumberOfMenusToBuy(200).build();
	}

	@Test(expected = InvalidMinimumPriceOfMenusToBuyException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidSecondMinimumPriceOfMenusToBuy()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withSecondMinimumPriceOfMenusToBuy(new Double(1500)).build();
	}

	@Test(expected = InvalidServiceException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidService()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withMenuService(null).build();
	}

	@Test(expected = InvalidMinimumNumberOfMenusToBuyException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithNumberOfMenusToOfferEquals()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withFirstMinimumNumberOfMenusToBuy(40).withSecondMinimumNumberOfMenusToBuy(40).build();
	}

	@Test(expected = InvalidPricesException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidMenusPrices()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withMenuPrice(new Double(40)).withFirstMinimumPriceOfMenusToBuy(new Double(30))
				.withSecondMinimumPriceOfMenusToBuy(new Double(30)).build();
	}

	@Test(expected = InvalidMenuPriceException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidMenuPrice()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		new MenuBuilder().withMenuPrice(null).build();
	}

}
