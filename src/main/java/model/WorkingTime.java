package model;

import java.util.List;

public class WorkingTime extends Entity {

	public WorkingTime(Integer day, List<TimeZone> workingHours) {
		numberDay = day;
		timeZone = workingHours;
	}
	
	public WorkingTime() {}


	public Integer getDay() {
		return numberDay;
	}

	private Integer numberDay;
	private List<TimeZone> timeZone;

	public List<TimeZone> getListTimeZone() {
		// TODO Auto-generated method stub
		return timeZone;
	}

}
