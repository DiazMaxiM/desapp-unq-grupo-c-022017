package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import builders.ServiceBuilder;
import exception.InvalidAddressException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import model.Provider;
import model.Service;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;

public class ProviderTest {

	@Test
	public void testTheAmountOfServicesOfferedByTheProviderShouldBe1WhenAddingAValidService()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		Provider provider = new Provider();
		Service service = new ServiceBuilder().build();
		provider.addNewService(service);
		assertEquals(1, provider.getServicesOffered().size());

	}

	@Test(expected = InvalidServiceNameException.class)
	public void testTheAmountOfServicesOfferedByTheProviderShouldBe0WhenAddingAInvalidService()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		Provider provider = new Provider();
		Service service = new ServiceBuilder().withServiceName(null).build();
		provider.addNewService(service);
		assertEquals(0, provider.getServicesOffered().size());

	}

}
