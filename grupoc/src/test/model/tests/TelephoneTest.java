package tests;

import org.junit.Test;

import exception.InvalidTelephoneNumberException;
import model.Telephone;


public class TelephoneTest {
     
	@Test(expected=InvalidTelephoneNumberException.class)
	public void testShouldFailWhenICreateAnInvalidTelephoneNumber() throws InvalidTelephoneNumberException{
		new Telephone(null,null,null);
	}
	
	@Test(expected=InvalidTelephoneNumberException.class)
	public void testShouldFailWhenICreateAnInvalidTelephoneNumberWithInvalidCountryCode() throws InvalidTelephoneNumberException{
		new Telephone("56","011","243456");
	}
	
	@Test(expected=InvalidTelephoneNumberException.class)
	public void testShouldFailWhenICreateAnInvalidTelephoneNumberWithInvalidAreaCode() throws InvalidTelephoneNumberException{
		new Telephone("54","250","243456");
	}
	
	@Test(expected=InvalidTelephoneNumberException.class)
	public void testShouldFailWhenICreateAnInvalidTelephoneNumberWithInvalidLocalNumber() throws InvalidTelephoneNumberException{
		new Telephone("54","011","");
	}
	
	@Test()
	public void testShouldPassWhenICreateAValidTelephoneNumber() throws InvalidTelephoneNumberException{
		new Telephone("54","011","2356890");
	}
	
}
