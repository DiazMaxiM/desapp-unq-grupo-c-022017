package validation;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import menuExceptions.InvalidMenuCategoryException;
import model.Category;

public class Validation {
    
	public boolean isValidString(String string){
		return !StringUtils.isEmpty(string);
	}
	public  boolean isValidDate(DateTime date) {
		return date!=null;
	}
	
	public boolean isValidCategory(Category menuCategory) throws InvalidMenuCategoryException{
		if(menuCategory==null){
			throw new InvalidMenuCategoryException("Ingrese una categoria");
		}
		return  menuCategory!=null;
	}
 
	public boolean isValidIntegerNumber(Integer integerNumber){
		return integerNumber!= null;
	}
	
	public boolean isValidDoubleNumber(Double doubleNumber){
		return doubleNumber!= null;
	}
}
