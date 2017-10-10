package model;

import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import validation.MapPositionValidation;

public class MapPosition extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double latitude;
	private Double length;
	private MapPositionValidation validator = new MapPositionValidation();

	public MapPosition() {
	}

	public MapPosition(Double latitude, Double length)
			throws InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		if (validator.isAValidMapPosition(latitude, length)) {
			createMapPosition(latitude, length);
		}
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