package model;

import exception.InvalidMapPositionException;

public class MapPosition {
	private Double latitude;
	private Double lenght;

	public MapPosition(Double latitude, Double lenght) throws InvalidMapPositionException {
		if(isAValidMapPosition(latitude,lenght)){
			createMapPosition(latitude,lenght);
		}	
		else{
			throw new InvalidMapPositionException("Ingrese un MapPosition valido");
		}
	}

	private boolean isAValidMapPosition(Double latitude, Double lenght) {
		return isValidLatitude(latitude)&& isValidLenght(lenght);
	}

	private boolean isValidLenght(Double lenght) {
		return lenght!=(null);
	}

	private boolean isValidLatitude(Double latitude) {
		return latitude!=(null);
	}
	
	private void createMapPosition(Double latitude, Double lenght) {	
		this.setLatitude(latitude);
		this.setLenght(lenght);
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLenght() {
		return lenght;
	}

	public void setLenght(Double lenght) {
		this.lenght = lenght;
	}

}
