package validation;

import org.apache.commons.lang3.StringUtils;

import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import model.Locality;

public class AddressValidation extends Validation{

	public boolean isAValidAddress(Locality locality, String street, String numberStreet)
			throws InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
		return isValidLocality(locality) && isValidStreet(street) && isValidNumberStreet(numberStreet);
	}

	private boolean isValidNumberStreet(String numberStreet) throws InvalidNumberStreetException {
		if (StringUtils.isEmpty(numberStreet)) {
			throw new InvalidNumberStreetException("Debe ingresar un número de calle válido");
		}
		return !StringUtils.isEmpty(numberStreet);
	}

	private boolean isValidStreet(String street) throws InvalidStreetAddressException {
		if (StringUtils.isEmpty(street)) {
			throw new InvalidStreetAddressException("Debe ingresar un nombre de calle válido");
		}
		return !StringUtils.isEmpty(street);
	}

	private boolean isValidLocality(Locality locality) throws InvalidLocalityAddressException {
		if (locality == null) {
			throw new InvalidLocalityAddressException("Debe ingresar una localidad válida");
		}
		return locality != null;
	}

}
