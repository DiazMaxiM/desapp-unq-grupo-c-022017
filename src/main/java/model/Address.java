package model;

import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import validation.AddressValidation;

public class Address extends Entity {

	private static final long serialVersionUID = 1L;
	private Locality locality;
	private String street;
	private String numberStreet;
	private String floor;
	private MapPosition mapPosition;
	private AddressValidation validator = new AddressValidation();

	public Address() {

	}

	public Address(Locality locality, String street, String numberStreet, String floor, MapPosition mapPosition)
			throws InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidMapPositionException {
		if (validator.isAValidAddress(locality, street, numberStreet, mapPosition)) {
			createAddress(locality, street, numberStreet, floor, mapPosition);
		}
	}

	private void createAddress(Locality locality, String street, String numberStreet, String floor,
			MapPosition mapPosition) {
		this.mapPosition = mapPosition;
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

	public void updateInformation(Locality locality, String street, String numberStreet, String floor,
			MapPosition mapPosition) throws InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidMapPositionException {
		if (validator.isAValidAddress(locality, street, numberStreet, mapPosition)) {
			createAddress(locality, street, numberStreet, floor, mapPosition);
		}
		
	}

}
