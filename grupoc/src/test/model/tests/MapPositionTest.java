package tests;

import org.junit.Ignore;
import org.junit.Test;

import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidMapPositionException;
import model.MapPosition;

public class MapPositionTest {

	@Test(expected = InvalidMapPositionException.class)
	@Ignore
	public void testShouldFailWhenICreateAnInvalidMapPosition()
			throws InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		new MapPosition(null, null);

	}

	@Test(expected = InvalidLatitudeMapPositionException.class)
	public void testShouldFailWhenICreateAMapPositionWithLatitudeInvalid()
			throws InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		new MapPosition(null, new Double(12));
	}

	@Test(expected = InvalidLengthMapPositionException.class)
	public void testShouldFailWhenICreateAMapPositionWithLengthInvalid()
			throws InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		new MapPosition(new Double(12), null);
	}

	@Test()
	public void testShouldPassWhenICreateAnValidMapPosition()
			throws InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException {
		new MapPosition(new Double(12), new Double(3.3333));

	}

}
