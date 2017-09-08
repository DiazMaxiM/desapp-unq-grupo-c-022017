package model;

import org.joda.time.Hours;
import org.joda.time.Minutes;

import exception.InvalidTimeZoneException;
import validation.TimeZoneValidation;

public class TimeZone {
    private Hours startHour;
    private Minutes starMinutes;
    private Hours endHour;
    private Minutes endMinutes;
    private TimeZoneValidation validator = new TimeZoneValidation();
    
    public TimeZone(Integer startHour,Integer starMinutes,Integer endHour,Integer endMinutes) throws InvalidTimeZoneException{
    	if(validator.isValidTimeZome(startHour,starMinutes,endHour,endMinutes)){
    		setStartHour(startHour);
        	setStarMinutes(starMinutes);
        	setEndHour(endHour);
        	setEndMinutes(endMinutes);       	
    	} 	
    } 

	public Integer getStartHour() {
		return startHour.getHours();
	}
	public void setStartHour(Integer startHour) {
		this.startHour = Hours.hours(startHour);
	}
	public Integer getStarMinutes() {
		return starMinutes.getMinutes();
	}
	public void setStarMinutes(Integer starMinutes) {
		this.starMinutes = Minutes.minutes(starMinutes);
	}
	public Integer getEndHour() {
		return endHour.getHours();
	}
	public void setEndHour(Integer endHour) {
		this.endHour = Hours.hours(endHour);
	}
	public Integer getEndMinutes() {
		return endMinutes.getMinutes();
	}
	public void setEndMinutes(Integer endMinutes) {
		this.endMinutes = Minutes.minutes(endMinutes);
	}
    
   
    
}
