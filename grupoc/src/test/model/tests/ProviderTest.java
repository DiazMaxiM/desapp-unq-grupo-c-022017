package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import builders.ServiceBuilder;
import exception.InvalidServiceException;
import model.Provider;
import model.Service;

public class ProviderTest{

	@Test
	public void testTheAmountOfServicesOfferedByTheProviderShouldBe1WhenAddingAValidService() throws InvalidServiceException {
		 Provider provider = new Provider();
		 Service service = new ServiceBuilder()
				           .build();
		 provider.addNewService(service);
		 assertEquals(1,provider.getServicesOffered().size());
		 
	}
	
	@Test(expected=InvalidServiceException.class)
	public void testTheAmountOfServicesOfferedByTheProviderShouldBe0WhenAddingAInvalidService() throws InvalidServiceException {
		 Provider provider = new Provider();
		 Service service = new ServiceBuilder()
				           .withServiceName(null)
				           .build();
		 provider.addNewService(service);
		 assertEquals(0,provider.getServicesOffered().size());
		 
	}

}
