package model;

import org.apache.commons.lang3.StringUtils;

import exception.InvalidAddressException;

public class Address {
	
	private Locality locality;
	private String street;
	private String numberStreet;
	private String floor;
	private MapPosition mapPosition;

	public Address(Locality locality, String street, String numberStreet, String floor, MapPosition mapPosition) throws InvalidAddressException {
		
			if(isAValidAddress(locality, street, numberStreet)){
				createAddress(locality, street,numberStreet,floor,mapPosition);
			}
			else{
				throw new InvalidAddressException("Ingrese una direccion valida");
			}
	}
	
	private boolean isAValidAddress(Locality locality, String street, String numberStreet) {
		return isValidLocality(locality)&& isValidStreet(street)&& isValidNumberStreet(numberStreet);
	}

	private boolean isValidNumberStreet(String numberStreet) {
		return !StringUtils.isEmpty(numberStreet);
	}

	private boolean isValidStreet(String street) {
		return !StringUtils.isEmpty(street) ;
	}

	private boolean isValidLocality(Locality locality) {
		return locality!=null;
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
