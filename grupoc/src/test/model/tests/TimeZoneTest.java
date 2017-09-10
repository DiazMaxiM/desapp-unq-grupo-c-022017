package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import exception.InvalidTimeZoneException;
import model.TimeZone;
import validation.InvalidFormatTimeZoneException;

public class TimeZoneTest {
	
	@Test(expected= InvalidFormatTimeZoneException.class)
	public void testShouldFailWhenCreateAInvalidTimeZone() throws InvalidTimeZoneException, InvalidFormatTimeZoneException {
		 new TimeZone("9:00","8:00");		
	}

	@Test(expected= InvalidTimeZoneException.class)
	public void testShouldFailWhenCreateAEmptyZone() throws InvalidTimeZoneException, InvalidFormatTimeZoneException {
		 new TimeZone("","");		
	}
	
	@Test
	public void testShoulPassWhenATimeZoneIsWithinATimeRange() throws InvalidTimeZoneException, InvalidFormatTimeZoneException {
		TimeZone timeWorking= new TimeZone("8:30","12:00");	
		TimeZone timeWorking2= new TimeZone("8:30","9:30");	
		assertTrue(timeWorking.isWithinRangeofWorking(timeWorking2));
	}
	
	@Test(expected = InvalidTimeZoneException.class)
	public void testShoulFailWhenATimeZoneIsWithinATimeRange() throws InvalidTimeZoneException, InvalidFormatTimeZoneException {
		TimeZone timeWorking= new TimeZone("8:30","12:00");	
		TimeZone timeWorking2= new TimeZone("11:00","12:00");	
		assertTrue(timeWorking.isWithinRangeofWorking(timeWorking2));
	}
}
