package validation;

import java.util.List;

import exception.InvalidAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidRegisterException;
import exception.InvalidTelephoneNumberException;
import model.Address;
import model.Telephone;
import model.User;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class UserValidation extends Validation{

	public boolean isValidUser(String cuit, String userfirstName, String userLastName, String userEmailAddress,
			Telephone userTelephone, Address userAddress) throws InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidMapPositionException {
		    return isValidCuit(cuit)
		    	  && isValidFirstName(userfirstName)
		    	  && isValidLastName(userLastName)
		          && isValidEmailAddress(userEmailAddress)
		          && isValidTelephone(userTelephone)
		          && isValidAddress(userAddress);		         
	}

	private boolean isValidEmailAddress(String userEmailAddress) throws InvalidEmailAddressException {
		if (!isValidString(userEmailAddress)|| !isValidadEmail(userEmailAddress)){
			throw new InvalidEmailAddressException("Ingrese un email valido");
		}
		return true;
	}

	private boolean isValidadEmail(String userEmailAddress) {
		return userEmailAddress.contains("@");
	}

	private boolean isValidLastName(String userLastName) throws InvalidLastNameException {
		if(!isValidString(userLastName)){
			throw new InvalidLastNameException("Ingrese un apellido valido");
		}
		return true;
	}

	private boolean isValidFirstName(String userfirstName) throws InvalidFirstNameException {
		if(!isValidString(userfirstName)){
			throw new InvalidFirstNameException("Ingrese un nombre valido");
		}
		return true;
	}

	private boolean isValidCuit(String cuit) throws InvalidCuitException {
	    if(!isValidString(cuit)){
	    	throw new InvalidCuitException("Ingrese un cuit valido");
	    }	    	
	    return true;
	}

	public boolean isNewUser(User newUser, List<User> users) throws InvalidRegisterException {
		Long  usersWithSameEmail = users.stream().filter(user -> user.getEmail().equals(newUser.getEmail())).count();
		Long  usersWithSameCuit = users.stream().filter(user -> user.equals(newUser)).count();
		if(usersWithSameEmail>0||usersWithSameCuit>0){
			throw new InvalidRegisterException("Ya existe un usuario");
		}
		return true;
	}
	

}
