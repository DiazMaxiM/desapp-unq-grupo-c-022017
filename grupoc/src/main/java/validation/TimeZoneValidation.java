package validation;

import org.joda.time.LocalTime;

import exception.InvalidTimeZoneException;

public class TimeZoneValidation extends Validation {
	
	public boolean isValidTimeZone(String startHours, String endHours) throws InvalidTimeZoneException {
		 if  (!(isValidString(startHours)
				&& isValidString(endHours))){
			  throw new InvalidTimeZoneException("La horas ingresadas no son validas");
		  }
		  return true;
	}

	public boolean ishasValidFormaterTimeZone(LocalTime starHours, LocalTime endHours) throws InvalidTimeZoneException, InvalidFormatTimeZoneException {
		if(!starHours.isBefore(endHours)){
			throw new InvalidFormatTimeZoneException("La hora de comiezo debe ser menor a la hora de fin");
		}
		return true;
	}
}
