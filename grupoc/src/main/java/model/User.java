package model;

public class User {
	
	private String userfirstName;
	private String userLastName;
	private String userEmailAddress;
	private Telephone userTelephone;
	private Address userAddress;

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
	

}
