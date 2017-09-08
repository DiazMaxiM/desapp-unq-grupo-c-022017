package tests;

import static org.junit.Assert.assertTrue;

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
import exception.NoMenusFoundException;
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
import menusearch.MenuSearchByCategory;
import model.Category;
import model.Menu;
import model.MenuManager;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;

public class MenuSearchByCategoryTest {

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
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, NoMenusFoundException, InvalidTimeZoneException {

		Menu menuPizza = new MenuBuilder().withMenuCategory(Category.PIZZA).build();

		MenuManager menuManager = new MenuManager();
		menuManager.addMenuToMenusOffered(menuPizza);

		MenuSearchByCategory searchCriteria = new MenuSearchByCategory(menuManager, Category.BEER);

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
			InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, NoMenusFoundException, InvalidTimeZoneException {

		Menu menuBurguer = new MenuBuilder().withMenuCategory(Category.BURGER).build();
		Menu menuEmpanadas = new MenuBuilder().withMenuCategory(Category.EMPANADAS).build();

		MenuManager menuManager = new MenuManager();
		menuManager.addMenuToMenusOffered(menuBurguer);
		menuManager.addMenuToMenusOffered(menuEmpanadas);

		MenuSearchByCategory searchCriteria = new MenuSearchByCategory(menuManager, Category.EMPANADAS);

		searchCriteria.menuSearch();

		assertTrue(searchCriteria.menuSearch().length == 1);
	}

}
