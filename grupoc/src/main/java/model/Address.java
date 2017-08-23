package model;

public class Address {

	private Locality locality;
	private String street;
	private String numberStreet;
	private String floor;
	private MapPosition mapPosition;
	
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
