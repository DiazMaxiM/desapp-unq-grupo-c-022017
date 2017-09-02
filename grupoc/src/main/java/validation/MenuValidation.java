package validation;

import org.joda.time.DateTime;

import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidServiceException;
import menuExceptions.InvalidDeliveryPriceException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidMaximumNumberOfMunusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidStartDateOfferMenuException;
import model.Category;
import model.Service;

public class MenuValidation extends Validation{
	
	public boolean isAValidMenu(String menuName, String menuDescription,Category menuCategory,Double menuDeliveryPrice,
			DateTime startDateOfferMenu, DateTime endDateOfferMenu, Integer averageDeliveryTimeOfMenu,
			Integer firstMinimumNumberOfMenusToBuy, Double firstminimumPriceOfMenusToBuy,
			Integer secondMinimumNumberOfMenusToBuy, Double secondMinimumPriceOfMenusToBuy,
			Integer maximumNumberOfMunusSalesPerDay, Service service) throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException,InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidServiceException, InvalidMaximumNumberOfMunusSalesPerDay {
		
		return isValidMenuName(menuName)
			   && isValidMenuDescription(menuDescription)
			   && isValidCategory(menuCategory)
			   && isValidMenuDeliveryPrice(menuDeliveryPrice)
			   && isValidStartDateOfferMenu(startDateOfferMenu)
			   && isValidEndDateOfferMenu(endDateOfferMenu)
			   && isValidAverageDeliveryTimeOfMenu(averageDeliveryTimeOfMenu)
			   && isValidFirstMinimumNumberOfMenusToBuy(firstMinimumNumberOfMenusToBuy)
			   && isValidFirstMinimumPriceOfMenusToBuy(firstminimumPriceOfMenusToBuy)
			   && isValidSecondMinimumNumberOfMenusToBuy(secondMinimumNumberOfMenusToBuy)
			   && isValidSecondMinimumPriceOfMenusToBuy(secondMinimumPriceOfMenusToBuy)
		       && isValidMaximumNumberOfMunusSalesPerDay(maximumNumberOfMunusSalesPerDay)
		       && isValidService(service);
	}
	
	private boolean isValidMenuDeliveryPrice(Double menuDeliveryPrice) throws InvalidMenuDeliveryPriceException{
		if(isValidDoubleNumber(menuDeliveryPrice)){
			return isHasValidDeliveryPrice(menuDeliveryPrice);
		}
		return true;
	}
    
	private boolean isHasValidDeliveryPrice(Double menuDeliveryPrice) throws InvalidMenuDeliveryPriceException {
		if(!isValidDeliveryPrice(menuDeliveryPrice)){
			throw new InvalidMenuDeliveryPriceException("El precio del delivery no es valido");
		}
	   return isValidDeliveryPrice(menuDeliveryPrice);
	}

	private boolean isValidDeliveryPrice(Double menuDeliveryPrice) {
		return menuDeliveryPrice>=10 && menuDeliveryPrice<=40;
	}

	private boolean isValidService(Service service) throws InvalidServiceException {
		if (service==null){
			throw new InvalidServiceException("El menu debe tener un servicio asociado");
		}
		return service!=null;
	}

	private boolean isValidMaximumNumberOfMunusSalesPerDay(Integer maximumNumberOfMunusSalesPerDay) throws InvalidMaximumNumberOfMunusSalesPerDay {
		if(!isValidIntegerNumber(maximumNumberOfMunusSalesPerDay)){
			throw new InvalidMaximumNumberOfMunusSalesPerDay("Ingrese la cantidad maxima de ventas de menus por dia");
		}
		return isValidIntegerNumber(maximumNumberOfMunusSalesPerDay);
	}
    
	private boolean isValidSecondMinimumPriceOfMenusToBuy(Double secondMinimumPriceOfMenusToBuy) throws InvalidMinimumPriceOfMenusToBuyException {
		boolean isValidSecondMinimumPriceOfMenusToBuy=isHasValidSecondMinimumPriceOfMenusToBuy(secondMinimumPriceOfMenusToBuy)
			   && isHasValidPriceOfMenusToBuy(secondMinimumPriceOfMenusToBuy);
		if(!isValidSecondMinimumPriceOfMenusToBuy){
			throw new InvalidMinimumPriceOfMenusToBuyException("El segundo precio para la venta de menus no es valido");
		}
		return isValidSecondMinimumPriceOfMenusToBuy;
	}

	private boolean isHasValidSecondMinimumPriceOfMenusToBuy(Double secondMinimumPriceOfMenusToBuy) {
		return isValidDoubleNumber(secondMinimumPriceOfMenusToBuy);
	}

	private boolean isValidSecondMinimumNumberOfMenusToBuy(Integer secondMinimumNumberOfMenusToBuy) throws InvalidMinimumNumberOfMenusToBuyException {
		boolean isValidSecondMinimumNumberOfMenusToBuy= isHasValidSecondMinimumNumberOfMenusToBuy(secondMinimumNumberOfMenusToBuy)
				&& isHasNumberOfSecondMinimumNumberOfMenusToBuy(secondMinimumNumberOfMenusToBuy);
		if(!isValidSecondMinimumNumberOfMenusToBuy){
			throw new InvalidMinimumNumberOfMenusToBuyException("La segunda cantidad minima ingresada no es valida");
		}
	    return isValidSecondMinimumNumberOfMenusToBuy;
	}

	private boolean isHasNumberOfSecondMinimumNumberOfMenusToBuy(Integer secondMinimumNumberOfMenusToBuy) {
		return secondMinimumNumberOfMenusToBuy>=40
			  && secondMinimumNumberOfMenusToBuy<=150;
	}

	private boolean isHasValidSecondMinimumNumberOfMenusToBuy(Integer secondMinimumNumberOfMenusToBuy) {
		return isValidIntegerNumber(secondMinimumNumberOfMenusToBuy);
	}

	private boolean isValidFirstMinimumPriceOfMenusToBuy(Double firstminimumPriceOfMenusToBuy) throws InvalidMinimumPriceOfMenusToBuyException{
		boolean isValidFirstMinimumPriceOfMenusToBuy =isHasValidFirstMinimumPriceOfMenusToBuy(firstminimumPriceOfMenusToBuy)
		       && isHasValidPriceOfMenusToBuy(firstminimumPriceOfMenusToBuy);
		if(!isValidFirstMinimumPriceOfMenusToBuy){
			throw new InvalidMinimumPriceOfMenusToBuyException("El precio del menu para la su venta no es valido");
		}
		return isValidFirstMinimumPriceOfMenusToBuy;
	}

	private boolean isHasValidPriceOfMenusToBuy(Double minimumPriceOfMenusToBuy) {
		return minimumPriceOfMenusToBuy>=0
			   && minimumPriceOfMenusToBuy<=1000;
	}

	private boolean isHasValidFirstMinimumPriceOfMenusToBuy(Double firstminimumPriceOfMenusToBuy) {
		return isValidDoubleNumber(firstminimumPriceOfMenusToBuy);
	}

	private boolean isValidFirstMinimumNumberOfMenusToBuy(Integer firstMinimumNumberOfMenusToBuy) throws InvalidMinimumNumberOfMenusToBuyException {
		boolean isValidFirstMinimumNumberOfMenusToBuy= isHasValidFirstMinimumNumberOfMenusToBuy(firstMinimumNumberOfMenusToBuy)
			       && isHasNumberOfFirstMinimumNumberOfMenusToBuy(firstMinimumNumberOfMenusToBuy);
		if(!isValidFirstMinimumNumberOfMenusToBuy){
			throw new InvalidMinimumNumberOfMenusToBuyException("El primer minimo de menus para comprar no es valido ");
		}
		return isValidFirstMinimumNumberOfMenusToBuy;
	}

	private boolean isHasNumberOfFirstMinimumNumberOfMenusToBuy(Integer firstMinimumNumberOfMenusToBuy) {
		return firstMinimumNumberOfMenusToBuy>=10 
			   && firstMinimumNumberOfMenusToBuy<=70;	
	}

	private boolean isHasValidFirstMinimumNumberOfMenusToBuy(Integer firstMinimumNumberOfMenusToBuy) {		
		return isValidIntegerNumber(firstMinimumNumberOfMenusToBuy);
	}

	private boolean isValidAverageDeliveryTimeOfMenu(Integer averageDeliveryTimeOfMenu) throws InvalidAverageDeliveryTimeOfMenuException {
		if(!isValidIntegerNumber(averageDeliveryTimeOfMenu)){
			throw new InvalidAverageDeliveryTimeOfMenuException("Ingrese un tiempo promedio de entrega");
		}
		return isValidIntegerNumber(averageDeliveryTimeOfMenu);
	}

	private boolean isValidEndDateOfferMenu(DateTime endDateOfferMenu) throws InvalidEndDateOfferMenuException {
		if(!isValidDate(endDateOfferMenu)){
			throw new InvalidEndDateOfferMenuException("La fecha de fin no es valida");
		}
		return isValidDate(endDateOfferMenu);
	}

	private boolean isValidStartDateOfferMenu(DateTime startDateOfferMenu) throws InvalidStartDateOfferMenuException {
		if(!isValidDate(startDateOfferMenu)){
			throw new InvalidStartDateOfferMenuException("La fecha ingresada no es valida");
		}
		return isValidDate(startDateOfferMenu);
	}

	private boolean isValidMenuDescription(String menuDescription) throws InvalidMenuDescriptionException {
		if(!(isHasValidMenuDescription(menuDescription)&& isHasValidSizeDescription(menuDescription))){
			throw new InvalidMenuDescriptionException("La descripcion del muenu no es valida");
		}
		return isHasValidMenuDescription(menuDescription)&& isHasValidSizeDescription(menuDescription);
		
	}

	private boolean isHasValidSizeDescription(String menuDescription) {
		return menuDescription.length()>=20 && menuDescription.length()<=40;
	}

	private boolean isHasValidMenuDescription(String menuDescription) {
		return isValidString(menuDescription);
	}

	private boolean isValidMenuName(String menuName) throws InvalidMenuNameException {
		if (!(isHasValidName(menuName)&& isHasValidSizeName(menuName))){
		   throw new InvalidMenuNameException("El nombre del menu no es valido");
		}
		return isHasValidName(menuName)&& isHasValidSizeName(menuName);
	}
	
	private boolean isHasValidSizeName(String menuName) {
		return menuName.length()>=4 && menuName.length()<=30;
	}

	private boolean isHasValidName(String menuName){
		return isValidString(menuName);
	}


}
