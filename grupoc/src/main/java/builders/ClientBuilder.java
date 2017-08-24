package builders;

import model.Address;
import model.Client;
import model.Locality;
import model.MapPosition;
import model.Telephone;

public class ClientBuilder {
	protected Client client = new Client("any", "person", "any@person.com", new Telephone("+54", "011", "4444-4444"),
			new Address(Locality.AVELLANEDA, "Saenz Peña", "1000", "PB", new MapPosition(-34.796581, -58.276012)));

	public Client build() {
		return this.client;
	}

	public void setName(String name) {
		this.client.setName(name);
	}

	public void setSurname(String surname) {
		this.client.setSurname(surname);
	}

	public void setMail(String mail) {
		this.client.setMail(mail);
	}

	public void setTelephone(Telephone telephone) {
		this.client.setTelephone(telephone);
	}

	public void setAddress(Address address) {
		this.client.setAddress(address);
	}

}
