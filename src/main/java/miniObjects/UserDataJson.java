package miniObjects;

import model.Address;
import model.Telephone;
import model.User;

public class UserDataJson {
	public String name;
	public String surname;
	public String cuit;
	public String mail;
	public Telephone telephone;
	public Address address;
	public String password;


	public UserDataJson(User user) {
		this.name = user.getName();
		this.surname = user.getSurname();
		this.cuit = user.getCuit();
		this.mail = user.getEmail();
		this.telephone = user.getTelephone();
		this.password = user.getPassword();	
		this.address = user.getAddress();
	}

}
