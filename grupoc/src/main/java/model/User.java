package model;

import exception.InvalidAddressException;
import exception.InvalidTelephoneNumberException;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
import validation.UserValidation;

public class User {
	private String cuit;
	private String userfirstName;
	private String userLastName;
	private String userEmailAddress;
	private Telephone userTelephone;
	private Address userAddress;
	private Account account = new Account();
	private UserValidation validator= new UserValidation();
	
	public User(String cuit,String userfirstName,String userLastName,String userEmailAddress,Telephone userTelephone,Address userAddress) throws InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException{
		if(validator.isValidUser(cuit,userfirstName,userLastName,userEmailAddress,
				               userTelephone,userAddress)){
			createUser(cuit,userfirstName,userLastName,userEmailAddress,userTelephone,userAddress);
		}
	}

	private void createUser(String cuit, String userfirstName, String userLastName, String userEmailAddress,
			Telephone userTelephone, Address userAddress) {	
		setCuit(cuit);
		setUserfirstName(userfirstName);
		setUserLastName(userLastName);
		setUserEmailAddress(userEmailAddress);
		setUserAddress(userAddress);
	}

	public String getUserfirstName() {
		return userfirstName;
	}
	
	public void setUserfirstName(String userfirstName) {
		this.userfirstName = userfirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	public Telephone getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(Telephone userTelephone) {
		this.userTelephone = userTelephone;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
}
