package validation;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import exception.InvalidAddressException;
import exception.InvalidTelephoneNumberException;
import menuExceptions.InvalidMenuCategoryException;
import model.Address;
import model.Category;
import model.Telephone;

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
	
	public boolean isValidTelephone(Telephone telephone) throws InvalidTelephoneNumberException{
		if(telephone==null){
			throw new InvalidTelephoneNumberException("ingrese un numero de telefono valido");
		}
		return telephone!=null;
	}
	
	public boolean isValidAddress(Address address) throws InvalidAddressException{
		if(address==null){
			throw new InvalidAddressException("ingrese una direccion valida");
		}
		return address!=null;
	}
}
