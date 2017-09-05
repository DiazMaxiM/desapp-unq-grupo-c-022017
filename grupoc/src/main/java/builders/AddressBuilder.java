package builders;

import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import model.Address;
import model.Locality;
import model.MapPosition;

public class AddressBuilder {
	protected Locality locality = Locality.ENSENADA;
	protected String street = "Av. Cabildo";
	protected String numberStreet = "98";
	protected String floor = "7";
	protected MapPosition mapPosition;

	public AddressBuilder() throws InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		mapPosition = new MapPosition(30.4, 70.0);
	}

	public Address build()
			throws InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
		return new Address(locality, street, numberStreet, floor, mapPosition);

	}

	public AddressBuilder withLocality(Locality locality) {
		this.locality = locality;
		return this;
	}

	public AddressBuilder withStreet(String street) {
		this.street = street;
		return this;
	}

	public AddressBuilder withNumberStreet(String numberStreet) {
		this.numberStreet = numberStreet;
		return this;
	}

	public AddressBuilder withFloor(String floor) {
		this.floor = floor;
		return this;
	}

	public AddressBuilder withMapPosition(MapPosition mapPosition) {
		this.mapPosition = mapPosition;
		return this;
	}

}
