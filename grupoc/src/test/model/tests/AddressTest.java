package tests;

import org.junit.Test;

import exception.InvalidAddressException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import model.Address;
import model.Locality;
import model.MapPosition;

public class AddressTest {

	@Test(expected = InvalidLatitudeMapPositionException.class)
	public void testShouldFailWhenICreateAnInvalidAddressWithInvalidMapPosition() throws InvalidAddressException,
			InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
		MapPosition mapPosition = new MapPosition(null, new Double(12));
		new Address(Locality.FLORENCIOVARELA, "monserrat", "558", "12", mapPosition);
	}

	@Test(expected = InvalidLocalityAddressException.class)
	public void testShouldFailWhenICreateAnInvalidAddressWithInvalidLocality() throws InvalidAddressException,
			InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
		MapPosition mapPosition = new MapPosition(new Double(114), new Double(12));
		new Address(null, "monserrat", "558", "12", mapPosition);
	}

	@Test(expected = InvalidStreetAddressException.class)
	public void testShouldFailWhenICreateAnInvalidAddressWithInvalidStreet() throws InvalidAddressException,
			InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
		MapPosition mapPosition = new MapPosition(new Double(114), new Double(12));
		new Address(Locality.ALMIRANTEBROWN, "", "558", "12", mapPosition);
	}

	@Test(expected = InvalidNumberStreetException.class)
	public void testShouldFailWhenICreateAnInvalidAddressWithInvalidStreetNumber() throws InvalidAddressException,
			InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
		MapPosition mapPosition = new MapPosition(new Double(114), new Double(12));
		new Address(Locality.QUILMES, "monserrat", "", "12", mapPosition);
	}

	@Test()
	public void testShouldPassWhenICreateAValidAddress() throws InvalidAddressException, InvalidMapPositionException,
			InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		MapPosition mapPosition = new MapPosition(new Double(114), new Double(12));
		new Address(Locality.BERAZATEGUI, "monserrat", "558", "12", mapPosition);
	}

}
