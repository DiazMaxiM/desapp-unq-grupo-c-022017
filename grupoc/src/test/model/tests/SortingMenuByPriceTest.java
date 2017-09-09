package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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
import exception.InvalidNumberStreetException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import exception.InvalidTimeZoneException;
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
import model.Menu;
import model.MenuManager;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import sortingMenus.SortingMenuByPrice;
import validation.InvalidFormatTimeZoneException;

public class SortingMenuByPriceTest {

	@Test
	public void testWhenIOrderAListOfMenusAndItIsEmptyItReturnsAnEmptyList() {
		MenuManager menuManager = new MenuManager();
		SortingMenuByPrice sortingMenuByPrice = new SortingMenuByPrice(menuManager);

		assertEquals(0, menuManager.orderMenus(sortingMenuByPrice).size());
	}

	@Test
	public void testWhenIOrderAListOfMenusWithMenusWithDifferentPricesReturnsAListSortedByPriceFromLowestToHighest()
			throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException,
			InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidTimeZoneException, InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		MenuManager menuManager = new MenuManager();
		Menu menu = new MenuBuilder().withMenuPrice(120).build();
		Menu menu2 = new MenuBuilder().withMenuPrice(50).build();
		Menu menu3 = new MenuBuilder().withMenuPrice(1).build();
		Menu menu4 = new MenuBuilder().withMenuPrice(30).build();

		menuManager.addMenuToMenusOffered(menu);
		menuManager.addMenuToMenusOffered(menu2);
		menuManager.addMenuToMenusOffered(menu3);
		menuManager.addMenuToMenusOffered(menu4);

		SortingMenuByPrice sortingMenuByPrice = new SortingMenuByPrice(menuManager);
		ArrayList<Menu> menusOrdered = menuManager.orderMenus(sortingMenuByPrice);

		assertEquals(4, menusOrdered.size());
		assertTrue(menusOrdered.get(0).equals(menu3));
		assertTrue(menusOrdered.get(1).equals(menu4));
		assertTrue(menusOrdered.get(2).equals(menu2));
		assertTrue(menusOrdered.get(3).equals(menu));

	}

}
