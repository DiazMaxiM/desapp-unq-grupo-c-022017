package model;

public class MapPosition {
	private Double latitude;
	private Double lenght;

	public MapPosition(Double latitude, Double lenght) {
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
