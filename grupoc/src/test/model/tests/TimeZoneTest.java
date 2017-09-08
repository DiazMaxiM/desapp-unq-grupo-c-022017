package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import exception.InvalidTimeZoneException;
import model.TimeZone;
import validation.TimeZoneValidation;

public class TimeZoneTest {

	@Test
	public void testShouldPassWhenCreateAValidTimeZone() throws InvalidTimeZoneException {
		TimeZone timeZone = new TimeZone(13,00,22,45);
	    TimeZoneValidation validator = new TimeZoneValidation();
	    assertTrue(validator.isValidTimeZome(timeZone.getStartHour(),timeZone.getStarMinutes(),
	    		                   timeZone.getEndHour(),timeZone.getEndMinutes()));
		
	}
	
	@Test(expected= InvalidTimeZoneException.class)
	public void testShouldFailWhenCreateAInvalidTimeZone() throws InvalidTimeZoneException {
		 new TimeZone(13,null,22,45);		
	}
}
