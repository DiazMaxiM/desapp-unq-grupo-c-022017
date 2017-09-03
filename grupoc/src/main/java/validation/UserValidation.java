package validation;

import exception.InvalidAddressException;
import exception.InvalidTelephoneNumberException;
import model.Address;
import model.Telephone;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class UserValidation extends Validation{

	public boolean isValidUser(String cuit, String userfirstName, String userLastName, String userEmailAddress,
			Telephone userTelephone, Address userAddress) throws InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException {
		    return isValidCuit(cuit)
		    	  && isValidFirstName(userfirstName)
		    	  && isValidLastName(userLastName)
		          && isValidEmailAddress(userEmailAddress)
		          && isValidTelephone(userTelephone)
		          && isValidAddress(userAddress);		         
	}

	private boolean isValidEmailAddress(String userEmailAddress) throws InvalidEmailAddressException {
		if (!isValidString(userEmailAddress)){
			throw new InvalidEmailAddressException("Ingrese un correo electronico");
		}
		return isValidString(userEmailAddress);
	}

	private boolean isValidLastName(String userLastName) throws InvalidLastNameException {
		if(!isValidString(userLastName)){
			throw new InvalidLastNameException("Ingrese un apellido valido");
		}
		return isValidString(userLastName);
	}

	private boolean isValidFirstName(String userfirstName) throws InvalidFirstNameException {
		if(!isValidString(userfirstName)){
			throw new InvalidFirstNameException("Ingrese un nombre valido");
		}
		return isValidString(userfirstName);
	}

	private boolean isValidCuit(String cuit) throws InvalidCuitException {
	    if(!isValidString(cuit)){
	    	throw new InvalidCuitException("Ingrese un cuit valido");
	    }	    	
	    return isValidString(cuit);
	}
	

}
