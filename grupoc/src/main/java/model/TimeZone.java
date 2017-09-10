package model;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import exception.InvalidTimeZoneException;
import validation.InvalidFormatTimeZoneException;
import validation.TimeZoneValidation;

public class TimeZone {
    private LocalTime startHours;
    private LocalTime endHours;
    private TimeZoneValidation validator = new TimeZoneValidation();
    
    public TimeZone(String startHours,String endHours) throws InvalidTimeZoneException, InvalidFormatTimeZoneException{
    	if(validator.isValidTimeZone(startHours,endHours)){
    	    evaluateTimeZone(startHours,endHours);	
    	} 
    }  
    
    private void evaluateTimeZone(String startHours,String endHours) throws InvalidTimeZoneException, InvalidFormatTimeZoneException{
    	if(validator.ishasValidFormaterTimeZone(parseString(startHours),parseString(endHours))){
    		setStartHours(startHours);
        	setEndHours(endHours);   
    	}
    }

	private LocalTime parseString(String hours) {
		 DateTimeFormatter newDateTimeFormatter = DateTimeFormat.forPattern("HH:mm");
		 LocalTime localTime = newDateTimeFormatter.parseLocalTime(hours);
		return  localTime;
	}
	
	public void setStartHours(String endHour) {
		this.startHours =parseString(endHour);
	}

	public void setEndHours(String endHour) {
		this.endHours =parseString(endHour);
	}

	public boolean  isWithinRangeofWorking(TimeZone timeZone) throws InvalidTimeZoneException {
		if (!(isInStartTimeWorking(timeZone) && isInEndTimeWorking(timeZone))){
			throw new InvalidTimeZoneException("El rango debe estar dentro de las horas de trabajo");
		}
		return true;
	}

	private boolean isInEndTimeWorking(TimeZone timeZone) {
		return getEndHours().isAfter(timeZone.getEndHours());
	}

	private boolean isInStartTimeWorking(TimeZone timeZone) {
		return getStartHours().isBefore(timeZone.getStartHours())
			   || getStartHours().equals(timeZone.getStartHours());
	}

	public LocalTime getStartHours() {
		return startHours;
	}

	public LocalTime getEndHours() {
		return endHours;
	}

   
    
}
