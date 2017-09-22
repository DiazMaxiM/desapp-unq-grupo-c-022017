package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import builders.ProviderBuilder;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import model.User;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
import validation.UserValidation;

public class UserTest {

	@Test
	public void testShouldPassWhenICreatAValidUser()
			throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		User provider = new ProviderBuilder().build();
		UserValidation validator = new UserValidation();
		assertTrue(validator.isValidUser(provider.getCuit(), provider.getName(), provider.getSurname(),
				provider.getEmail(), provider.getTelephone(), provider.getAddress()));

	}
	
	@Test(expected=InvalidFirstNameException.class)
	public void testShoulFailWhenICreatAInvalidUserWithNullName()
			throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		User provider = new ProviderBuilder()
				        .withName(null)
				        .build();
		UserValidation validator = new UserValidation();
		assertTrue(validator.isValidUser(provider.getCuit(), provider.getName(), provider.getSurname(),
				provider.getEmail(), provider.getTelephone(), provider.getAddress()));

	}
	
	@Test(expected=InvalidLastNameException.class)
	public void testShoulFailWhenICreatAInvalidUserWithEmptyLastName()
			throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		User provider = new ProviderBuilder()
				        .withLastName("")
				        .build();
		UserValidation validator = new UserValidation();
		assertTrue(validator.isValidUser(provider.getCuit(), provider.getName(), provider.getSurname(),
				provider.getEmail(), provider.getTelephone(), provider.getAddress()));

	}
	
	@Test(expected=InvalidEmailAddressException.class)
	public void testShoulFailWhenICreatAInvalidUserWithInvalidEmail()
			throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		User provider = new ProviderBuilder()
				        .withEmail("zaracho.rosali.gmail.com")
				        .build();
		UserValidation validator = new UserValidation();
		assertTrue(validator.isValidUser(provider.getCuit(), provider.getName(), provider.getSurname(),
				provider.getEmail(), provider.getTelephone(), provider.getAddress()));

	}
	
	@Test(expected=InvalidTelephoneNumberException.class)
	public void testShoulFailWhenICreatAInvalidUserWithNullTelephone()
			throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		User provider = new ProviderBuilder()
				        .withTelephone(null)
				        .build();
		UserValidation validator = new UserValidation();
		assertTrue(validator.isValidUser(provider.getCuit(), provider.getName(), provider.getSurname(),
				provider.getEmail(), provider.getTelephone(), provider.getAddress()));

	}
	
	@Test(expected=InvalidAddressException.class)
	public void testShoulFailWhenICreatAInvalidUserWithNullAddress()
			throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		User provider = new ProviderBuilder()
				        .withAddress(null)
				        .build();
		UserValidation validator = new UserValidation();
		assertTrue(validator.isValidUser(provider.getCuit(), provider.getName(), provider.getSurname(),
				provider.getEmail(), provider.getTelephone(), provider.getAddress()));

	}
	
	@Test(expected=InvalidCuitException.class)
	public void testShoulFailWhenICreatAInvalidUserWithEmptyCuit()
			throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		User provider = new ProviderBuilder()
				        .withCuit("")
				        .build();
		UserValidation validator = new UserValidation();
		assertTrue(validator.isValidUser(provider.getCuit(), provider.getName(), provider.getSurname(),
				provider.getEmail(), provider.getTelephone(), provider.getAddress()));

	}
    
	
}
