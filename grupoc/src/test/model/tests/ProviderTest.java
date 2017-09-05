package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import builders.ProviderBuilder;
import builders.ServiceBuilder;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLocalNumberException;
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
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
import validation.UserValidation;

public class ProviderTest {
    
	@Test
	public void testShouldPassWhenICreatAValidProvider() throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidTelephoneNumberException{
		Provider provider= new ProviderBuilder().build();
		UserValidation validator= new UserValidation();
		assertTrue(validator.isValidUser(provider.getCuit(),provider.getName(), 
				                       provider.getSurname(),provider.getEmail(),
				                       provider.getTelephone(), provider.getAddress()));
		
	}
	
	@Test
	public void testTheAmountOfServicesOfferedByTheProviderShouldBe1WhenAddingAValidService()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException {
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
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException {
		Provider provider = new ProviderBuilder().build();
		Service service = new ServiceBuilder().withServiceName(null).build();
		provider.addNewService(service);
		assertEquals(0, provider.getServicesOffered().size());

	}

}
