package tests;
import org.junit.Test;
import exception.InvalidMapPositionException;
import model.MapPosition;

public class MapPositionTest {

	@Test(expected=InvalidMapPositionException.class)
	public void testShouldFailWhenICreateAnInvalidMapPosition() throws InvalidMapPositionException {
		new MapPosition(null,null);
	}
	
	@Test(expected=InvalidMapPositionException.class)
	public void testShouldFailWhenICreateAMapPositionWithLatitudeInvalid() throws InvalidMapPositionException {
		new MapPosition(null,new Double(12));
	}
	
	@Test(expected=InvalidMapPositionException.class)
	public void testShouldFailWhenICreateAMapPositionWithLengthInvalid() throws InvalidMapPositionException {
		new MapPosition(new Double(12),null);
	}
	
	@Test()
	public void testShouldPassWhenICreateAnValidMapPosition() throws InvalidMapPositionException {
		new MapPosition(new Double(12),new Double(3.3333));
		
	}
	
	

}
