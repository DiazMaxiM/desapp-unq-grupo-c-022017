package tests;

import static org.junit.Assert.assertTrue;

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
import exception.NoMenusFoundException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidMaximumNumberOfMunusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidStartDateOfferMenuException;
import menusearch.MenuSearchByName;
import model.Menu;
import model.MenuManager;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import validation.InvalidFormatTimeZoneException;

public class MenuSearchByNameTest {

	@Test(expected = NoMenusFoundException.class)
	public void testWhenLookForAMenuAndItIsNotInTheSystemShouldThrowAnException()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, NoMenusFoundException, InvalidTimeZoneException, InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMapPositionException {

		Menu menuPastas = new MenuBuilder().withMenuName("Pastas").build();

		MenuManager menuManager = new MenuManager();
		menuManager.addMenuToMenusOffered(menuPastas);

		MenuSearchByName searchCriteria = new MenuSearchByName(menuManager, "Milanesas");

		searchCriteria.menuSearch();
	}

	@Test 
	public void testWhenLookForAMenuAndItIsInTheSystemShouldFindResults()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, NoMenusFoundException, InvalidTimeZoneException, InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMapPositionException {

		Menu menuMilanesas = new MenuBuilder().withMenuName("Milanesas").build();
		Menu menuPastas = new MenuBuilder().withMenuName("Pastas").build();

		MenuManager menuManager = new MenuManager();
		menuManager.addMenuToMenusOffered(menuPastas);
		menuManager.addMenuToMenusOffered(menuMilanesas);

		MenuSearchByName searchCriteria = new MenuSearchByName(menuManager, "Milanesas");

		searchCriteria.menuSearch();

		assertTrue(searchCriteria.menuSearch().length == 1);
	}

}
