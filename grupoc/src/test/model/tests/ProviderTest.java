package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import builders.MenuBuilder;
import builders.ProviderBuilder;
import builders.ServiceBuilder;
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
import exception.NumberOfMenusExceededException;
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
import model.Provider;
import model.Service;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
import validation.InvalidFormatTimeZoneException;
import validation.UserValidation;

public class ProviderTest {

	@Test
	public void testTheAmountOfServicesOfferedByTheProviderShouldBe1WhenAddingAValidService()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidTimeZoneException, InvalidFormatTimeZoneException {
		Provider provider = new ProviderBuilder().build();
		Service service = new ServiceBuilder().build();
		provider.addNewService(service);
		assertEquals(1, provider.getServicesOffered().size());

	}

	@Test(expected = InvalidServiceNameException.class)
	public void testTheAmountOfServicesOfferedByTheProviderShouldBe0WhenAddingAInvalidService()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidTimeZoneException, InvalidFormatTimeZoneException {
		Provider provider = new ProviderBuilder().build();
		Service service = new ServiceBuilder().withServiceName(null).build();
		provider.addNewService(service);
		assertEquals(0, provider.getServicesOffered().size());

	}

	@Test
	public void testWhenAddAMenuToAServiceItMustBeAddedToTheListOfServiceMenus()
			throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidServiceException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, NumberOfMenusExceededException, InvalidTimeZoneException, InvalidFormatTimeZoneException {
		Provider provider = new ProviderBuilder().build();
		Service service = new ServiceBuilder().build();
		provider.addNewService(service);
		Menu menu = new MenuBuilder().build();
		provider.addNewMenuInService(service, menu);

		assertTrue(provider.getServicesOffered().get(0).getServiceMenusOffered().contains(menu));
		assertEquals(1, provider.getServicesOffered().get(0).getServiceMenusOffered().size());
	}

	@Test
	public void testWhenDeleteAMenuToAServiceItMustBeRemovedToTheListOfServiceMenus()
			throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidServiceException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, NumberOfMenusExceededException, InvalidTimeZoneException, InvalidFormatTimeZoneException {
		Provider provider = new ProviderBuilder().build();
		Service service = new ServiceBuilder().build();
		provider.addNewService(service);

		Menu menu = new MenuBuilder().build();
		provider.addNewMenuInService(service, menu);

		Menu menu2 = new MenuBuilder().build();
		provider.addNewMenuInService(service, menu2);

		provider.deleteMenuOfService(service, menu);

		assertFalse(provider.getServicesOffered().get(0).getServiceMenusOffered().contains(menu));
		assertTrue(provider.getServicesOffered().get(0).getServiceMenusOffered().contains(menu2));
		assertEquals(1, provider.getServicesOffered().get(0).getServiceMenusOffered().size());

	}

	@Test
	public void testWhenUpdateAMenuToAServiceThisShouldBeToModifyTheMenuListOfTheService()
			throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidServiceException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException,
			InvalidAverageDeliveryTimeOfMenuException, NumberOfMenusExceededException, InvalidTimeZoneException, InvalidFormatTimeZoneException {
		Provider provider = new ProviderBuilder().build();
		Service service = new ServiceBuilder().build();
		provider.addNewService(service);

		Menu menu = new MenuBuilder().build();
		provider.addNewMenuInService(service, menu);

		Menu menu2 = new MenuBuilder().build();

		provider.updateMenuInService(service, menu, menu2);

		assertTrue(provider.getServicesOffered().get(0).getServiceMenusOffered().contains(menu2));
	}

}
