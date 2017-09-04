package validation;

import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;

public class MapPositionValidation extends Validation {
	public boolean isAValidMapPosition(Double latitude, Double lenght)
			throws InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		return isValidLatitude(latitude) && isValidLength(lenght);
	}

	private boolean isValidLength(Double length) throws InvalidLengthMapPositionException {
		if (length == null) {
			throw new InvalidLengthMapPositionException("Debe ingresar una longitud válida");
		}
		return true;
	}

	private boolean isValidLatitude(Double latitude) throws InvalidLatitudeMapPositionException {
		if (latitude == null) {
			throw new InvalidLatitudeMapPositionException("Debe ingresar una latitud válida");
		}
		return true;
	}

}
