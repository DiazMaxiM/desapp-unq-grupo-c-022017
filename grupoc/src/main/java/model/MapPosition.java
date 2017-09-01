package model;

import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidMapPositionException;

public class MapPosition {
	private Double latitude;
	private Double length;

	public MapPosition(Double latitude, Double length)
			throws InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		if (isAValidMapPosition(latitude, length)) {
			createMapPosition(latitude, length);
		} else {
			throw new InvalidMapPositionException("Ingrese un MapPosition valido");
		}
	}

	private boolean isAValidMapPosition(Double latitude, Double lenght)
			throws InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		return isValidLatitude(latitude) && isValidLength(lenght);
	}

	private boolean isValidLength(Double length) throws InvalidLengthMapPositionException {
		if (length == null) {
			throw new InvalidLengthMapPositionException("Debe ingresar una longitud válida");
		}
		return length != null;
	}

	private boolean isValidLatitude(Double latitude) throws InvalidLatitudeMapPositionException {
		if (latitude == null) {
			throw new InvalidLatitudeMapPositionException("Debe ingresar una latitud válida");
		}
		return latitude != null;
	}

	private void createMapPosition(Double latitude, Double length) {
		this.setLatitude(latitude);
		this.setLength(length);
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}
}