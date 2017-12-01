package validation;

import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;

public class MapPositionValidation extends Validation {
	public boolean isAValidMapPosition(Double latitude, Double lenght)
			throws InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		return isValidLatitude(latitude) && isValidLength(lenght);
	}

	public boolean isValidLength(Double length) throws InvalidLengthMapPositionException {
		if (length == null) {
			throw new InvalidLengthMapPositionException("Debe ingresar una longitud válida");
		}
		return true;
	}

	public boolean isValidLatitude(Double latitude) throws InvalidLatitudeMapPositionException {
		if (latitude == null) {
			throw new InvalidLatitudeMapPositionException("Debe ingresar una latitud válida");
		}
		return true;
	}

}
