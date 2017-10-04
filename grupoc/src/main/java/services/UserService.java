package services;

import javax.transaction.Transactional;

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
import model.Telephone;
import model.User;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class UserService extends GenericService<User> {

	private static final long serialVersionUID = -2932116622242535843L;

	@Transactional
	public User newUser(String name, String surname, String cuit, String mail, String countryCode, String areaCode,
			String localNumber, String locality, String street, String numberStreet, String floor, String latitude,
			String length) throws InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException,
			InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidMapPositionException, NumberFormatException,
			InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {

		MapPosition mapPosition = new MapPosition(new Double(latitude), new Double(length));

		Telephone telephone = new Telephone(countryCode, areaCode, localNumber);

		Address address = new Address(Locality.valueOf(locality), street, numberStreet, floor, mapPosition);
		User newUser = new User(cuit, name, surname, mail, telephone, address);

		this.getRepository().save(newUser);
		return newUser;
	}

}
