package model;

public class Telephone {
	private String countryCode;
	private String areaCode;
	private String localNumber;

	public Telephone(String countryCode, String areaCode, String localNumber) {
		this.setAreaCode(areaCode);
		this.setCountryCode(countryCode);
		this.setLocalNumber(localNumber);

	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}

}
