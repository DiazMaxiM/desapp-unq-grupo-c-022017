package validation;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;

import exception.InvalidAddressException;
import exception.InvalidClientException;
import exception.InvalidMapPositionException;
import exception.InvalidProviderException;
import exception.InvalidTelephoneNumberException;
import menuExceptions.InvalidMenuCategoryException;
import model.Address;
import model.Category;
import model.MapPosition;
import model.Provider;
import model.Telephone;
import model.User;

public class Validation {

	protected boolean isValidString(String string) {
		return !StringUtils.isEmpty(string);
	}

	public boolean isValidDate(LocalDateTime date) {
		return date != null;
	}

	protected boolean isValidCategory(Category menuCategory) throws InvalidMenuCategoryException {
		if (menuCategory == null) {
			throw new InvalidMenuCategoryException("Ingrese una categoria");
		}
		return true;
	}

	protected boolean isValidIntegerNumber(Integer integerNumber) {
		return integerNumber != null;
	}

	protected boolean isValidDoubleNumber(Double doubleNumber) {
		return doubleNumber != null;
	}

	protected boolean isValidTelephone(Telephone telephone) throws InvalidTelephoneNumberException {
		if (telephone == null) {
			throw new InvalidTelephoneNumberException("ingrese un numero de telefono valido");
		}
		return true;
	}

	protected boolean isValidAddress(Address address) throws InvalidAddressException, InvalidMapPositionException {
		if (address == null) {
			throw new InvalidAddressException("ingrese una direccion valida");
		}
		return true;
	}

	protected boolean isValidMapPosition(MapPosition mapPosition) throws InvalidMapPositionException {
		if (mapPosition == null) {
			throw new InvalidMapPositionException("ingrese una direccion para ubicarlo en el mapa");
		}
		return true;
	}

	protected boolean isValidProvider(Provider provider) throws InvalidProviderException {
		if (provider == null) {
			throw new InvalidProviderException("Indique el proveedor");
		}
		return true;

	}

	protected boolean isValidClient(User client) throws InvalidClientException {
		if (client == null) {
			throw new InvalidClientException("Indique el cliente");
		}
		return true;
	}
}
