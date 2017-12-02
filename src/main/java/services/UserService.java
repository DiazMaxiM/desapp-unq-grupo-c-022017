package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import exception.BalanceInsufficient;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidLoggingException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidRegisterException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import miniObjects.UserDataJson;
import model.Address;
import model.Locality;
import model.MapPosition;
import model.Telephone;
import model.Transaction;
import model.TypeTransaction;
import model.User;
import repositories.UserRepository;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
import userExceptions.InvalidPasswordException;
import validation.UserValidation;

public class UserService extends GenericService<User> {

	private static final long serialVersionUID = -2932116622242535843L;

	@Transactional
	public User newUser(String pass, String name, String surname, String cuit, String mail, String countryCode,
			String areaCode, String localNumber, String locality, String street, String numberStreet, String floor,
			String latitude, String length)
			throws InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException,
			InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidMapPositionException, NumberFormatException,
			InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidRegisterException {
        
		
		MapPosition mapPosition = new MapPosition(new Double(latitude), new Double(length));

		Telephone telephone = new Telephone(countryCode, areaCode, localNumber);

		Address address = new Address(Locality.valueOf(locality), street, numberStreet, floor, mapPosition);
		User newUser = new User(cuit, name, surname, mail, telephone, address, pass);
        
		UserValidation validator = new UserValidation();
		
		List<User> users = this.getRepository().findAll();
		
		if(validator.isNewUser(newUser, users)) {
			this.getRepository().save(newUser);		
			
		}
		return newUser;
		
	}

	@Transactional
	public User loggingUser(String mail, String pass) throws InvalidLoggingException {
		UserRepository repo = (UserRepository) this.getRepository();
		List<User> user = repo.findByEmail(mail);

		if (user.size() == 1 && (user.get(0)).getPassword().equals(pass)) {
			return user.get(0);
		}
		throw new InvalidLoggingException("Error en el logging");

	}

	@Transactional
	public void addTransaction(String id, String typeTransaction, String value) throws BalanceInsufficient {
		UserRepository repo = (UserRepository) this.getRepository();
		User user = repo.findById(id);
		Transaction transaction = new Transaction(TypeTransaction.valueOf(typeTransaction), new Double(value));
		user.getAccount().addTransaction(transaction);
		repo.save(user);
	}

	@Transactional
	public Double getBalance(String id) {
		UserRepository repo = (UserRepository) this.getRepository();
		User user = repo.findById(id);
		return user.getAccount().balance();

	}

	@Transactional
	public void updateUser(String id, String password, String countryCode, String areaCode, String localNumber,
			String locality, String street, String numberStreet, String floor, String latitude, String length)
			throws NumberFormatException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidMapPositionException, InvalidPasswordException {
		UserRepository repo = (UserRepository) this.getRepository();
		User user = repo.findById(id);
		Telephone telephone = user.getTelephone();
		telephone.setAreaCode(areaCode);
		telephone.setCountryCode(countryCode);
		telephone.setLocalNumber(localNumber);
		MapPosition map = user.getMapPosition();
		map.setLatitude(new Double(latitude));
		map.setLength(new Double(length));
		Address address = user.getAddress();
		address.setFloor(floor);
		address.setLocality(Locality.valueOf(locality));
		address.setNumberStreet(numberStreet);
		address.setStreet(street);
		repo.update(user);
 
	}

	@Transactional
	public UserDataJson getUserData(String id) {
		UserRepository repo = (UserRepository) this.getRepository();
		User user = repo.findById(id);
		return new UserDataJson(user);
	}

	@Transactional
	public User loggingUserAuth0(String mail) throws InvalidLoggingException {
		UserRepository repo = (UserRepository) this.getRepository();
		List<User> user = repo.findByEmail(mail);

		if (user.size() == 1) {
			return user.get(0);
		}
		throw new InvalidLoggingException("Error en el logging");

	}
	private void a () {
		
	}
	
}
