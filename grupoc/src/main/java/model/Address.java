package model;

import org.apache.commons.lang3.StringUtils;

import exception.InvalidAddressException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;

public class Address {

	private Locality locality;
	private String street;
	private String numberStreet;
	private String floor;
	private MapPosition mapPosition;

	public Address(Locality locality, String street, String numberStreet, String floor, MapPosition mapPosition)
			throws InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException {
		if (isAValidAddress(locality, street, numberStreet)) {
			createAddress(locality, street, numberStreet, floor, mapPosition);
		} else {
			throw new InvalidAddressException("Ingrese una dirección válida");
		}
	}

	private boolean isAValidAddress(Locality locality, String street, String numberStreet)
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

	private void createAddress(Locality locality, String street, String numberStreet, String floor,
			MapPosition mapPosition) {
		this.setLocality(locality);
		this.setStreet(street);
		this.setFloor(floor);
		this.setMapPosition(mapPosition);
		this.setNumberStreet(numberStreet);
	}

	public Locality getLocality() {
		return locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumberStreet() {
		return numberStreet;
	}

	public void setNumberStreet(String numberStreet) {
		this.numberStreet = numberStreet;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public MapPosition getMapPosition() {
		return mapPosition;
	}

	public void setMapPosition(MapPosition mapPosition) {
		this.mapPosition = mapPosition;
	}
}
