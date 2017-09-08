package validation;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import exception.InvalidAddressException;
import exception.InvalidClientException;
import exception.InvalidProviderException;
import exception.InvalidTelephoneNumberException;
import menuExceptions.InvalidMenuCategoryException;
import model.Address;
import model.Category;
import model.Provider;
import model.Telephone;
import model.User;

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
		return true;
	}
 
	public boolean isValidIntegerNumber(Integer integerNumber){
		return integerNumber!= null || integerNumber instanceof Integer;
	}
	
	public boolean isValidDoubleNumber(Double doubleNumber){
		return doubleNumber!= null;
	}
	
	public boolean isValidTelephone(Telephone telephone) throws InvalidTelephoneNumberException{
		if(telephone==null){
			throw new InvalidTelephoneNumberException("ingrese un numero de telefono valido");
		}
		return true;
	}
	
	public boolean isValidAddress(Address address) throws InvalidAddressException{
		if(address==null){
			throw new InvalidAddressException("ingrese una direccion valida");
		}
		return true;
	}
	
	public boolean isValidProvider(Provider provider) throws InvalidProviderException {
		if(provider==null){
			throw new InvalidProviderException("Indique el proveedor");
		}
		return true;
		
	}

	public boolean  isValidClient(User client) throws InvalidClientException {
		if(client==null){
			throw new InvalidClientException("Indique el cliente");
		}
	    return true;
	}
}
