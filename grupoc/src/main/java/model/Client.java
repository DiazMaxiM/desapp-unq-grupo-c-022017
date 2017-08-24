package model;

public class Client {
	private String cuit;
	private Account account = new Account();
	private String name;
	private String surname;
	private String mail;
	private Telephone telephone;
	private Address address;

	public Client(String name, String surname, String mail, Telephone telephone, Address address) {
		this.setName(name);
		this.setSurname(surname);
		this.setMail(mail);
		this.setTelephone(telephone);
		this.setAddress(address);
	}

	@Override
	public boolean equals(Object client) {
		return this.cuit.equals(((Client) client).cuit);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
}
