package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import builders.ClientBuilder;
import builders.ProviderBuilder;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidRegisterException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import model.Provider;
import model.User;
import model.UserAdministration;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class UserAdministrationTest {

	@Test
	public void testWhenCreateAValidRegisterOfAFutureProviderTheSizeOfUserIs1() throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidRegisterException {
		UserAdministration userAdministration = new UserAdministration();
		Provider newUser                      = new ProviderBuilder().build();
		userAdministration.registerUser(newUser);
		assertEquals(1,userAdministration.getUsers().size());
	}
	
	@Test(expected=InvalidRegisterException.class)
	public void testShouldFailWhenANewUserWantsRegistrerWithAEmailUsed() throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidRegisterException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		UserAdministration userAdministration = new UserAdministration();
		Provider newUser1                         = new ProviderBuilder().build();
		User newUser2                         = new ClientBuilder().build();
		newUser2.setMail("zaracho.rosali@gmail.com");
		
		userAdministration.registerUser(newUser1);
		userAdministration.registerUser(newUser2);
	}
	
	@Test(expected=InvalidRegisterException.class)
	public void testShouldFailWhenANewUserWantsRegistrerWithACuitUsed() throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidRegisterException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		UserAdministration userAdministration = new UserAdministration();
		Provider newUser1                     = new ProviderBuilder().build();
		newUser1.setCuit("30-457346876-8");
		User newUser2                         = new ClientBuilder().build();
		
		userAdministration.registerUser(newUser1);
		userAdministration.registerUser(newUser2);
	}

}
