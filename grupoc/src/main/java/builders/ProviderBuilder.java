package builders;

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
import model.Address;
import model.Locality;
import model.MapPosition;
import model.Provider;
import model.Telephone;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class ProviderBuilder {
	
	private String userCuit = "30-678789567-9";
	private String userfirstName= "Rosali";
	private String userLastName = "Zaracho";
	private String userEmailAddress= "zaracho.rosali@gmail.com";
	private Telephone userTelephone;
	private Address userAddress;
	
	public ProviderBuilder() throws InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException{
		this.userTelephone= new Telephone("54","011","43567829");
		MapPosition mapPosition = new MapPosition(new Double(678990), new Double (679977));
		this.userAddress = new Address(Locality.FLORENCIOVARELA, "damasco", "124", "",mapPosition);
	}
	
	public Provider build() throws InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidMapPositionException{
		return new Provider(userCuit, userfirstName, userLastName,userEmailAddress, userTelephone, userAddress);
	}

	public ProviderBuilder withName(String name) {
		this.userfirstName = name;
		return this;
	}
	
	public ProviderBuilder withLastName(String lastName) {
		this.userLastName = lastName;
		return this;
	}
	
	public ProviderBuilder withEmail(String email) {
		this.userEmailAddress = email;
		return this;
	}
	
	public ProviderBuilder withTelephone(Telephone telephone) {
		this.userTelephone = telephone;
		return this;
	}
	
	public ProviderBuilder withAddress(Address address) {
		this.userAddress = address;
		return this;
	}
	
	public ProviderBuilder withCuit(String cuit) {
		this.userCuit = cuit;
		return this;
	}
}
