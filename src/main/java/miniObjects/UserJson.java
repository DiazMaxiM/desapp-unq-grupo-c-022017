package miniObjects;

import model.TypeUser;

public class UserJson {
	public Integer id;
	public String name;
	public TypeUser typeUser;

	public UserJson(Integer id, String name, TypeUser typeUser) {
		this.id = id;
		this.name = name;
		this.typeUser = typeUser;
	}

}
