package model;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class Validation {
    
	public boolean isValidString(String string){
		return !StringUtils.isEmpty(string);
	}
	public  boolean isValidDate(DateTime date) {
		return date!=null;
	}
	
	public boolean isValidCategory(Category menuCategory){
		return menuCategory!=null;
	}
	
	public boolean isValidIntegerNumber(Integer integerNumber){
		return integerNumber!= null;
	}
	
	public boolean isValidDoubleNumber(Double doubleNumber){
		return doubleNumber!= null;
	}
}
