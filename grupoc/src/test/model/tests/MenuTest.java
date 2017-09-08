package tests;

import org.junit.Test;

import builders.MenuBuilder;
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
import model.Menu;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import validation.MenuValidation;

import static org.junit.Assert.*;
public class MenuTest {

	@Test()
	public void testShouldPassWhenICreateAValidMenu() throws InvalidMenuNameException, InvalidMenuDescriptionException,
			InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException,
			InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidServiceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		Menu menu = new MenuBuilder().build();
		MenuValidation validator = new MenuValidation();
		assertTrue(validator.isAValidMenu(menu.getMenuName(),menu.getMenuDescription(),menu.getMenuCategory(), 
				                          menu.getMenuDeliveryPrice(),menu.getStartDateOfferMenu(),menu.getEndDateOfferMenu(), 
				                          menu.getAverageDeliveryTimeOfMenu(), menu.getFirstMinimumNumberOfMenusToBuy(), 
				                          menu.getFirstminimumPriceOfMenusToBuy(), menu.getSecondMinimumNumberOfMenusToBuy(), 
				                          menu.getSecondMinimumPriceOfMenusToBuy(), menu.getMaximumNumberOfMenusSalesPerDay(), 
				                          menu.getService()));
	}

	@Test(expected = InvalidMenuNameException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithAShortName() throws InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidServiceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withMenuName("ppp").build();
	}

	@Test(expected = InvalidMenuDescriptionException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithAShortDescription() throws InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidServiceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withMenuDescription("ppp").build();
	}

	@Test(expected = InvalidMenuCategoryException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidCategory() throws InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidServiceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withMenuCategory(null).build();
	}

	@Test(expected = InvalidMenuDeliveryPriceException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidMenuDeliveryPrice() throws InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidServiceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withMenuDeliveryPrice(new Double(50)).build();
	}

	@Test(expected = InvalidStartDateOfferMenuException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidStartDateOfferMenu() throws InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidServiceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withStartDateOfferMenu(null).build();
	}

	@Test(expected = InvalidEndDateOfferMenuException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidEndDateOfferMenu() throws InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidServiceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withEndDateOfferMenu(null).build();
	}

	@Test(expected = InvalidAverageDeliveryTimeOfMenuException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidAverageDeliveryTimeOfMenu()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidFirstMinimumNumberOfMenusToBuyException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withAverageDeliveryTimeOfMenu(null).build();
	}

	@Test(expected = InvalidMinimumNumberOfMenusToBuyException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidFirstMinimumNumberOfMenusToBuy()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidFirstMinimumNumberOfMenusToBuyException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withFirstMinimumNumberOfMenusToBuy(100).build();
	}

	@Test(expected = InvalidMinimumPriceOfMenusToBuyException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidFirstMinimumPriceOfMenusToBuy()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidFirstMinimumNumberOfMenusToBuyException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withFirstMinimumPriceOfMenusToBuy(new Double(1500)).build();
	}

	@Test(expected = InvalidMinimumNumberOfMenusToBuyException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidSecondMinimumNumberOfMenusToBuy()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidFirstMinimumNumberOfMenusToBuyException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withSecondMinimumNumberOfMenusToBuy(200).build();
	}

	@Test(expected = InvalidMinimumPriceOfMenusToBuyException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidSecondMinimumPriceOfMenusToBuy()
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidFirstMinimumNumberOfMenusToBuyException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withSecondMinimumPriceOfMenusToBuy(new Double(1500)).build();
	}

	@Test(expected = InvalidServiceException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidService() throws InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException,
			InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidFirstMinimumNumberOfMenusToBuyException,
			InvalidServiceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidAddressException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidTimeZoneException {
		new MenuBuilder().withMenuService(null).build();
	}

}
