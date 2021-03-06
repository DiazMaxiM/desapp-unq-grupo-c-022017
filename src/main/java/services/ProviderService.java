package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidRegisterException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import model.Address;
import model.Locality;
import model.MapPosition;
import model.Provider;
import model.Service;
import model.Telephone;
import model.User;
import repositories.ProviderRepository;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class ProviderService extends GenericService<Provider> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transactional
	public Provider newProvider(String pass, String name, String surname, String cuit, String mail, String countryCode,
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
		Provider newProvider = new Provider(cuit, name, surname, mail, telephone, address, pass);

		List<Provider> providers = this.getRepository().findAll();

		if (isNewProvider(newProvider, providers)) {
			this.getRepository().save(newProvider);

		}

		return newProvider;
	}

	private boolean isNewProvider(Provider newProvider, List<Provider> providers) throws InvalidRegisterException {
		Long providersWithSameEmail = providers.stream()
				.filter(provider -> provider.getEmail().equals(newProvider.getEmail())).count();
		Long providersWithSameCuit = providers.stream().filter(provider -> provider.equals(newProvider)).count();
		if (providersWithSameEmail > 0 || providersWithSameCuit > 0) {
			throw new InvalidRegisterException("Ya existe un usuario");
		}
		return true;
	}

	@Transactional
	public List<Service> getServicesByIdProvider(String id) {
		Provider provider = this.getRepository().findById(new Integer(id));
		return provider.getServicesOffered();
	}

	@Transactional

	public User getProviderForServiceId(String id) {
		ProviderRepository provider = (ProviderRepository) this.getRepository();
		return provider.byIdService(new Integer(id));

	}

}
