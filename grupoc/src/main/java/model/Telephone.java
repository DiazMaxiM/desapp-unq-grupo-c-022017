package model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import exception.InvalidTelephoneNumberException;

public class Telephone {
	private String countryCode="54"; //Area Code Argentina
	private String areaCode;
	private String localNumber;
	private List<String>areasCode=this.areasCode();
	private Validation validator= new Validation();

	public Telephone(String countryCode, String areaCode, String localNumber) throws InvalidTelephoneNumberException {
		if(isAValidTelephone(countryCode,areaCode,localNumber)){
			createTelephone(countryCode,areaCode,localNumber);
		}
		else{
			throw new InvalidTelephoneNumberException("El telefono ingresado no es valido");
		}
	}

	private List<String> areasCode() {
		List<String> areasCode=new ArrayList<>();
		areasCode.add("011");
		areasCode.add("220");
		areasCode.add("221");
		areasCode.add("223");		
		return areasCode;
	}

	private boolean isAValidTelephone(String countryCode, String areaCode, String localNumber) {
		return isValidCountryCode(countryCode)
				&& isValidAreaCode(areaCode)
				&& isValidLocalNumber(localNumber);
	}
	
	private boolean isValidLocalNumber(String localNumber) {
		return  !StringUtils.isEmpty(localNumber);
	}

	private boolean isValidAreaCode(String areaCode) {
		return !StringUtils.isEmpty(areaCode)&& this.areasCode.contains(areaCode) ;
	}

	private boolean isValidCountryCode(String countryCode) {
		return !StringUtils.isEmpty(countryCode)&& this.getCountryCode().equals(countryCode);
	}

	private void createTelephone(String countryCode,String areaCode, String localNumber){
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
