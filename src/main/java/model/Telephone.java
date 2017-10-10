package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLocalNumberException;
import validation.Validation;

public class Telephone extends Entity {
	private static final long serialVersionUID = 1L;
	private String countryCode = "54"; // Area Code Argentina
	private String areaCode;
	private String localNumber;

	private User user;

	private List<String> areasCode = this.areasCode();
	@SuppressWarnings("unused")
	private Validation validator = new Validation();

	public Telephone() {
	}

	public Telephone(String countryCode, String areaCode, String localNumber)
			throws InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException {
		if (isAValidTelephone(countryCode, areaCode, localNumber)) {
			createTelephone(countryCode, areaCode, localNumber);
		}
	}

	private List<String> areasCode() {
		List<String> areasCode = new ArrayList<>();
		areasCode.add("011");
		areasCode.add("220");
		areasCode.add("221");
		areasCode.add("223");
		return areasCode;
	}

	private boolean isAValidTelephone(String countryCode, String areaCode, String localNumber)
			throws InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException {
		return isValidCountryCode(countryCode) && isValidAreaCode(areaCode) && isValidLocalNumber(localNumber);
	}

	private boolean isValidLocalNumber(String localNumber) throws InvalidLocalNumberException {
		if (StringUtils.isEmpty(localNumber)) {
			throw new InvalidLocalNumberException("Debe ingresar un número local válido");
		}
		return !StringUtils.isEmpty(localNumber);
	}

	private boolean isValidAreaCode(String areaCode) throws InvalidAreaCodeException {
		if (StringUtils.isEmpty(areaCode) || !this.areasCode.contains(areaCode)) {
			throw new InvalidAreaCodeException("Debe ingresar un número de área válido");
		}
		return !StringUtils.isEmpty(areaCode) && this.areasCode.contains(areaCode);
	}

	private boolean isValidCountryCode(String countryCode) throws InvalidCountryCodeException {
		if (StringUtils.isEmpty(countryCode) || !this.getCountryCode().equals(countryCode)) {
			throw new InvalidCountryCodeException("Debe ingresar un código de país válido");
		}
		return !StringUtils.isEmpty(countryCode) && this.getCountryCode().equals(countryCode);
	}

	private void createTelephone(String countryCode, String areaCode, String localNumber) {
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

	public void setUser(User user) {
		this.user = user;

	}

	public void updateInformation(String countryCode, String areaCode, String localNumber) throws InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException {
	     if(isAValidTelephone(countryCode, areaCode, localNumber)){
	    	 setCountryCode(countryCode);
	    	 setAreaCode(areaCode);
	    	 setLocalNumber(localNumber);
	     }
		
	}

}