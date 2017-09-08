package validation;

import exception.InvalidTimeZoneException;

public class TimeZoneValidation extends Validation{

	public boolean isValidTimeZome(Integer startHour, Integer starMinutes, Integer endHour, Integer endMinutes) throws InvalidTimeZoneException {
		  if  (!( isValidIntegerNumber(startHour)
			  && isValidIntegerNumber(starMinutes)
			  && isValidIntegerNumber(endHour)
			  && isValidIntegerNumber(endMinutes))){
			  throw new InvalidTimeZoneException("La horas ingresadas no son validas");
		  }
		  return true;
	}

}
