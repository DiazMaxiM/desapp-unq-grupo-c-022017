
import org.junit.Test;

import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLocalNumberException;
import exception.InvalidTelephoneNumberException;
import model.Telephone;

public class TelephoneTest {

	@Test(expected = InvalidCountryCodeException.class)
	public void testShouldFailWhenICreateAnInvalidTelephoneNumberWithInvalidCountryCode()
			throws InvalidTelephoneNumberException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException {
		new Telephone("56", "011", "243456");
	}

	@Test(expected = InvalidAreaCodeException.class)
	public void testShouldFailWhenICreateAnInvalidTelephoneNumberWithInvalidAreaCode()
			throws InvalidTelephoneNumberException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException {
		new Telephone("54", "250", "243456");
	}

	@Test(expected = InvalidLocalNumberException.class)
	public void testShouldFailWhenICreateAnInvalidTelephoneNumberWithInvalidLocalNumber()
			throws InvalidTelephoneNumberException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException {
		new Telephone("54", "011", "");
	}

	@Test()
	public void testShouldPassWhenICreateAValidTelephoneNumber() throws InvalidTelephoneNumberException,
			InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException {
		new Telephone("54", "011", "2356890");
	}

}
