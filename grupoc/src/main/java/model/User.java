package model;

import exception.InvalidAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidTelephoneNumberException;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
import validation.UserValidation;

public class User {
	private String cuit;
	private String  name;
	private String surname;
	private String mail;
	private Telephone telephone;
	private Address address;
	private Account account = new Account();
	private UserValidation validator= new UserValidation();
	
	public User(String cuit,String userfirstName,String userLastName,String userEmailAddress,Telephone userTelephone,Address userAddress) throws InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidMapPositionException{
		if(validator.isValidUser(cuit,userfirstName,userLastName,userEmailAddress,
				               userTelephone,userAddress)){
			createUser(cuit,userfirstName,userLastName,userEmailAddress,userTelephone,userAddress);
		}
	}

	private void createUser(String cuit, String userfirstName, String userLastName, String userEmailAddress,
			Telephone userTelephone, Address userAddress) {	
		setCuit(cuit);
		setName(userfirstName);
		setSurname(userLastName);
		setMail(userEmailAddress);
		setTelephone(userTelephone);
		setAddress(userAddress);
	}
	
	@Override
	public boolean equals(Object user) {
		return this.getCuit().equals(((User) user).getCuit());
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return mail;
	}

	public void setMail(String email) {
		this.mail = email;
	}

	public Telephone getTelephone() {
		return telephone;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
