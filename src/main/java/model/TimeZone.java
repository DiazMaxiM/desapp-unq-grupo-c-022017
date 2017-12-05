package model;

import java.time.format.DateTimeFormatter;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import exception.InvalidTimeZoneException;
import validation.InvalidFormatTimeZoneException;
import validation.TimeZoneValidation;

public class TimeZone extends Entity{
	
	private static final long serialVersionUID = 1L;
	private LocalDateTime startHours;
    private LocalDateTime endHours;
    private TimeZoneValidation validator = new TimeZoneValidation();
    
    public TimeZone(String startHours,String endHours) throws InvalidTimeZoneException, InvalidFormatTimeZoneException{
    	if(validator.isValidTimeZone(startHours,endHours)){
    	    evaluateTimeZone(startHours,endHours);	
    	} 
    }  
    
    public TimeZone() {
	}

	private void evaluateTimeZone(String startHours,String endHours) throws InvalidTimeZoneException, InvalidFormatTimeZoneException{
    	if(validator.ishasValidFormaterTimeZone(parseString(startHours),parseString(endHours))){
    		setStartHours(startHours);
        	setEndHours(endHours);   
    	}
    }
 
	private LocalDateTime parseString(String hours) {

 LocalDateTime localTime = LocalDateTime.parse(hours,  DateTimeFormat.forPattern("HH:mm"));
		return  localTime;
	}
	
	public void setStartHours(String endHour) {
		this.startHours =parseString(endHour);
	}

	public void setEndHours(String endHour) {
		this.endHours =parseString(endHour);
	}

	public boolean  isWithinRangeofWorking(TimeZone timeZone) {
		return isInStartTimeWorking(timeZone) && isInEndTimeWorking(timeZone);
		
	}

	private boolean isInEndTimeWorking(TimeZone timeZone) {
		return getEndHours().isAfter(timeZone.getEndHours());
	}

	private boolean isInStartTimeWorking(TimeZone timeZone) {
		return getStartHours().isBefore(timeZone.getStartHours())
			   || getStartHours().equals(timeZone.getStartHours());
	}

	public LocalDateTime getStartHours() {
		return startHours;
	}

	public LocalDateTime getEndHours() {
		return endHours;
	}

   
    
}
