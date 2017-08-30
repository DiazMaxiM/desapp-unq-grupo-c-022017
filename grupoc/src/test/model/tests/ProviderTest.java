package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import builders.ServiceBuilder;
import exception.InvalidAddressException;
import exception.InvalidServiceException;
import model.Provider;
import model.Service;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;

public class ProviderTest{

	@Test
	public void testTheAmountOfServicesOfferedByTheProviderShouldBe1WhenAddingAValidService() throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException {
		 Provider provider = new Provider();
		 Service service = new ServiceBuilder()
				           .build();
		 provider.addNewService(service);
		 assertEquals(1,provider.getServicesOffered().size());
		 
	}
	
	@Test(expected=InvalidServiceException.class)
	public void testTheAmountOfServicesOfferedByTheProviderShouldBe0WhenAddingAInvalidService() throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException {
		 Provider provider = new Provider();
		 Service service = new ServiceBuilder()
				           .withServiceName(null)
				           .build();
		 provider.addNewService(service);
		 assertEquals(0,provider.getServicesOffered().size());
		 
	}

}
