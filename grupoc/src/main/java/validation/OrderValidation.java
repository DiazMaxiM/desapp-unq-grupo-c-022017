package validation;

import org.joda.time.DateTime;

import exception.InvalidClientException;
import exception.InvalidMenuException;
import exception.InvalidProviderException;
import model.Menu;
import model.Provider;
import model.TypeOfDelivery;
import model.User;
import orderExceptions.InvalidDateOfDeliveryException;
import orderExceptions.InvalidDeliveryTimeException;
import orderExceptions.InvalidNumberOfMenusToOrderException;
import orderExceptions.InvalidTypeOfDeliveryException;

public class OrderValidation extends Validation{

	public boolean isValidOrder(Menu menuToOrder, Integer numberOfMenusToOrder, TypeOfDelivery typeOfDelivery,
			DateTime dateOfDelivery, String deliveryTime,
			User client, Provider provider) throws InvalidMenuException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException, InvalidClientException, InvalidProviderException {
	    return isValidMenu(menuToOrder)
	    	   && isValidNumberOfMenusToOrder(numberOfMenusToOrder)
	    	   && isValidTypeOfDelivery(typeOfDelivery)
	    	   && isValidDateOfDelivery(dateOfDelivery)
	    	   && isValidDeliveryTime(deliveryTime)
	           && isValidClient(client)
	           && isValidProvider(provider);
	}

	private boolean isValidDeliveryTime(String deliveryTime) throws InvalidDeliveryTimeException {
		if(!isValidString(deliveryTime)){
			throw new InvalidDeliveryTimeException("Ingrese la hora de entrega");
		}
		return true;
	}

	private boolean isValidDateOfDelivery(DateTime dateOfDelivery) throws InvalidDateOfDeliveryException {
	    if(!isValidDate(dateOfDelivery)){
	    	throw new InvalidDateOfDeliveryException("Ingrese la fecha de entrega");
	    }
		return true;
	}

	private boolean isValidTypeOfDelivery(TypeOfDelivery typeOfDelivery) throws InvalidTypeOfDeliveryException {
		if(typeOfDelivery==null){
			throw new InvalidTypeOfDeliveryException("Ingrese el tipo de entrega");
		}
		return true;
	}

	private boolean isValidNumberOfMenusToOrder(Integer numberOfMenusToOrder) throws InvalidNumberOfMenusToOrderException {
		if(!isValidIntegerNumber(numberOfMenusToOrder)|| numberOfMenusToOrder==0){
			throw new InvalidNumberOfMenusToOrderException("Ingrese la cantidad de menus a comprar");
		}
		return true;
	}

	private boolean isValidMenu(Menu menuToOrder) throws InvalidMenuException {
	    if(menuToOrder==null){
	    	throw new InvalidMenuException("Ingrese un menu");
	    }
		return true;
	}

}
