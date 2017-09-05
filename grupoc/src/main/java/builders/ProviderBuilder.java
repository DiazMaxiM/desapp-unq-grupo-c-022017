package builders;

import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import model.Address;
import model.Locality;
import model.Provider;
import model.Telephone;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class ProviderBuilder {
	
	private String cuit = "30-678789567-9";
	private String userfirstName= "Rosali";
	private String userLastName = "Zaracho";
	private String userEmailAddress= "zaracho.rosali@gmail.com";
	private Telephone userTelephone;
	private Address userAddress;
	
	public ProviderBuilder() throws InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException{
		this.userTelephone= new Telephone("54","011","43567829");
		this.userAddress = new Address(Locality.FLORENCIOVARELA, "damasco", "124", "",null);
	}
	
	public Provider build() throws InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException{
		return new Provider(cuit, userfirstName, userLastName,userEmailAddress, userTelephone, userAddress);
	}
}
