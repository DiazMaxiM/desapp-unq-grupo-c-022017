package model;

import exception.InvalidAddressException;
import exception.InvalidTelephoneNumberException;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class Client extends User {
	public Client(String cuit, String userfirstName, String userLastName, String userEmailAddress,
			Telephone userTelephone, Address userAddress)
			throws InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException,
			InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException {
		super(cuit, userfirstName, userLastName, userEmailAddress, userTelephone, userAddress);
	}
  

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
