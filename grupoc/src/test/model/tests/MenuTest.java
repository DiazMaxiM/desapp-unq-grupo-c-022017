package tests;

import org.junit.Test;

import builders.MenuBuilder;
import exception.InvalidAddressException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
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
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;

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
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
		new MenuBuilder().build();
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
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidStreetAddressException, InvalidLocalityAddressException {
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
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
		new MenuBuilder().withMenuService(null).build();
	}

}
