 package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import builders.AddressBuilder;
import builders.MenuBuilder;
import builders.ServiceBuilder;
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
import menusearch.MenuSearchByLocality;
import model.Address;
import model.Locality;
import model.Menu;
import model.MenuManager;
import model.Service;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import validation.InvalidFormatTimeZoneException;

public class MenuSearchByLocalityTest {

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
			InvalidLatitudeMapPositionException, InvalidLengthMapPositionException, InvalidTelephoneNumberException,
			NoMenusFoundException, InvalidTimeZoneException, InvalidFormatTimeZoneException {

		Address serviceAddress = new AddressBuilder().withLocality(Locality.AVELLANEDA).build();
		Service service = new ServiceBuilder().withServiceAddress(serviceAddress).build();
		Menu menuPizza = new MenuBuilder().withMenuService(service).build();

		MenuManager menuManager = new MenuManager();
		menuManager.addMenuToMenusOffered(menuPizza);

		MenuSearchByLocality searchCriteria = new MenuSearchByLocality(menuManager, Locality.BERAZATEGUI);

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
			InvalidTelephoneNumberException, NoMenusFoundException, InvalidLengthMapPositionException,
			InvalidLatitudeMapPositionException, InvalidTimeZoneException, InvalidFormatTimeZoneException {

		Address serviceAddress = new AddressBuilder().withLocality(Locality.AVELLANEDA).build();
		Service service = new ServiceBuilder().withServiceAddress(serviceAddress).build();
		Menu menuPizza = new MenuBuilder().withMenuService(service).build();

		Address serviceAddress2 = new AddressBuilder().withLocality(Locality.BERAZATEGUI).build();
		Service service2 = new ServiceBuilder().withServiceAddress(serviceAddress2).build();
		Menu menuEmpanadas = new MenuBuilder().withMenuService(service2).build();

		MenuManager menuManager = new MenuManager();
		menuManager.addMenuToMenusOffered(menuPizza);
		menuManager.addMenuToMenusOffered(menuEmpanadas);

		MenuSearchByLocality searchCriteria = new MenuSearchByLocality(menuManager, Locality.BERAZATEGUI);
		searchCriteria.menuSearch();

		assertTrue(searchCriteria.menuSearch().length == 1);
	}

}
