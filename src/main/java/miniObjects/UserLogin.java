package miniObjects;

import model.TypeUser;

public class UserLogin {
	public Integer id;
	public String name;
	public String password;
	public TypeUser typeUser;

	public UserLogin(Integer id, String name, TypeUser typeUser) {
		this.id = id;
		this.name = name;
		this.typeUser = typeUser;
	}

	public UserLogin() {

	}

}
