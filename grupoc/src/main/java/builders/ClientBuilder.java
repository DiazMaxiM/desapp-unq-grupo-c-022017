package builders;

import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import model.Address;
import model.Locality;
import model.MapPosition;
import model.Telephone;
import model.User;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class ClientBuilder {
	protected User client;
    
	public ClientBuilder() throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidTelephoneNumberException {
		this.client=this.getClient();		
	}
	
	public User build() {
		return this.client;
	}

	public void setName(String name) {
		this.client.setName(name);
	}

	public void setSurname(String surname) {
		this.client.setSurname(surname);
	}

	public void setMail(String mail) {
		this.client.setMail(mail);
	}

	public void setTelephone(Telephone telephone) {
		this.client.setTelephone(telephone);
	}

	public void setAddress(Address address) {
		this.client.setAddress(address);
	}
	
	public User getClient() throws InvalidAddressException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidTelephoneNumberException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
			return new User("30-457346876","any", "person", "any@person.com", new Telephone("54", "011", "4444-4444"), new Address(
					Locality.AVELLANEDA, "Saenz Peña", "1000", "PB", new MapPosition(-34.796581, -58.276012)));
	}
	
}