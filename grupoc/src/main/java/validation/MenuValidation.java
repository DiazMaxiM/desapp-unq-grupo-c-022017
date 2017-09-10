package validation;

import org.joda.time.DateTime;

import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidServiceException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidMaximumNumberOfMunusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidPricesException;
import menuExceptions.InvalidStartDateOfferMenuException;
import model.Category;
import model.Price;
import model.Service;

public class MenuValidation extends Validation{
	
	public boolean isAValidMenu(String menuName, String menuDescription,Category menuCategory,Price menuDeliveryPrice,
			DateTime startDateOfferMenu, DateTime endDateOfferMenu, Integer averageDeliveryTimeOfMenu,
			Integer firstMinimumNumberOfMenusToBuy, Price firstminimumPriceOfMenusToBuy,
			Integer secondMinimumNumberOfMenusToBuy, Price secondMinimumPriceOfMenusToBuy,
			Integer maximumNumberOfMunusSalesPerDay, Service service,Price menuPrice) throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException,InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidServiceException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidPricesException, InvalidMenuPriceException {
		
		return isValidMenuName(menuName)
			   && isValidMenuDescription(menuDescription)
			   && isValidCategory(menuCategory)
			   && isValidMenuDeliveryPrice(menuDeliveryPrice)
			   && isValidStartDateOfferMenu(startDateOfferMenu)
			   && isValidEndDateOfferMenu(endDateOfferMenu)
			   && isValidAverageDeliveryTimeOfMenu(averageDeliveryTimeOfMenu)
			   && isHasAValidMinimumNumber(firstMinimumNumberOfMenusToBuy,secondMinimumNumberOfMenusToBuy)
			   && isHasAValidPrices(firstminimumPriceOfMenusToBuy,secondMinimumPriceOfMenusToBuy,menuPrice)
		       && isValidMaximumNumberOfMunusSalesPerDay(maximumNumberOfMunusSalesPerDay)
		       && isValidService(service);
	}
	
	private boolean isHasAValidPrices(Price firstminimumPriceOfMenusToBuy, Price secondMinimumPriceOfMenusToBuy,
			Price menuPrice) throws InvalidMinimumPriceOfMenusToBuyException, InvalidPricesException, InvalidMenuPriceException {
		return isValidMenuPrice(menuPrice)
			   && isValidFirstMinimumPriceOfMenusToBuy(firstminimumPriceOfMenusToBuy)
			   && isValidSecondMinimumPriceOfMenusToBuy(secondMinimumPriceOfMenusToBuy)
			   && isValidPrices(firstminimumPriceOfMenusToBuy,
					            secondMinimumPriceOfMenusToBuy,
					            menuPrice);		   
		
	}

	private boolean isValidPrices(Price firstminimumPriceOfMenusToBuy, Price secondMinimumPriceOfMenusToBuy,
			Price menuPrice) throws InvalidPricesException {
		if(!(firstminimumPriceOfMenusToBuy.getValue() < menuPrice.getValue()
		   && secondMinimumPriceOfMenusToBuy.getValue() < firstminimumPriceOfMenusToBuy.getValue())){
			throw new InvalidPricesException("El precio *Min2 debe ser menor que *Min1 y este debe ser menor a Precio");
		}
		return true;
	}

	private boolean isValidMenuPrice(Price menuPrice) throws InvalidMenuPriceException {
		if(menuPrice.getValue() == null){
			throw new InvalidMenuPriceException("Debe ingresar el precio del menu");
		}
		return true;
	}

	private boolean isHasAValidMinimumNumber(Integer firstMinimumNumberOfMenusToBuy,
			Integer secondMinimumNumberOfMenusToBuy) throws InvalidMinimumNumberOfMenusToBuyException {
		   return isValidFirstMinimumNumberOfMenusToBuy(firstMinimumNumberOfMenusToBuy)
		         && isValidSecondMinimumNumberOfMenusToBuy(secondMinimumNumberOfMenusToBuy)
			     && isMinimalExclusions(firstMinimumNumberOfMenusToBuy,secondMinimumNumberOfMenusToBuy);
	}

	private boolean isMinimalExclusions(Integer firstMinimumNumberOfMenusToBuy,
			Integer secondMinimumNumberOfMenusToBuy) throws InvalidMinimumNumberOfMenusToBuyException {
		  if(firstMinimumNumberOfMenusToBuy >= secondMinimumNumberOfMenusToBuy){
			 throw new InvalidMinimumNumberOfMenusToBuyException("Las cantidades minimas deberán ser  mutuamente excluyentes");
		}
		return true;
	}

	private boolean isValidMenuDeliveryPrice(Price menuDeliveryPrice) throws InvalidMenuDeliveryPriceException{
		if(isValidDoubleNumber(menuDeliveryPrice.getValue())){
			return isHasValidDeliveryPrice(menuDeliveryPrice.getValue());
		}
		return true;
	}
    
	private boolean isHasValidDeliveryPrice(Double menuDeliveryPrice) throws InvalidMenuDeliveryPriceException {
		if(!isValidDeliveryPrice(menuDeliveryPrice)){
			throw new InvalidMenuDeliveryPriceException("El precio del delivery no es valido");
		}
	   return true;
	}

	private boolean isValidDeliveryPrice(Double menuDeliveryPrice) {
		return menuDeliveryPrice>=10 && menuDeliveryPrice<=40;
	}

	private boolean isValidService(Service service) throws InvalidServiceException {
		if (service==null){
			throw new InvalidServiceException("El menu debe tener un servicio asociado");
		}
		return true;
	}

	private boolean isValidMaximumNumberOfMunusSalesPerDay(Integer maximumNumberOfMunusSalesPerDay) throws InvalidMaximumNumberOfMunusSalesPerDay {
		if(!isValidIntegerNumber(maximumNumberOfMunusSalesPerDay)){
			throw new InvalidMaximumNumberOfMunusSalesPerDay("Ingrese la cantidad maxima de ventas de menus por dia");
		}
		return true;
	}
    
	private boolean isValidSecondMinimumPriceOfMenusToBuy(Price secondMinimumPriceOfMenusToBuy) throws InvalidMinimumPriceOfMenusToBuyException {
		boolean isValidSecondMinimumPriceOfMenusToBuy=isHasValidSecondMinimumPriceOfMenusToBuy(secondMinimumPriceOfMenusToBuy.getValue())
			   && isHasValidPriceOfMenusToBuy(secondMinimumPriceOfMenusToBuy.getValue());
		if(!isValidSecondMinimumPriceOfMenusToBuy){
			throw new InvalidMinimumPriceOfMenusToBuyException("El segundo precio para la venta de menus no es valido");
		}
		return true;
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
	    return true;
	}

	private boolean isHasNumberOfSecondMinimumNumberOfMenusToBuy(Integer secondMinimumNumberOfMenusToBuy) {
		return secondMinimumNumberOfMenusToBuy>=40
			  && secondMinimumNumberOfMenusToBuy<=150;
	}

	private boolean isHasValidSecondMinimumNumberOfMenusToBuy(Integer secondMinimumNumberOfMenusToBuy) {
		return isValidIntegerNumber(secondMinimumNumberOfMenusToBuy);
	}

	private boolean isValidFirstMinimumPriceOfMenusToBuy(Price firstminimumPriceOfMenusToBuy) throws InvalidMinimumPriceOfMenusToBuyException{
		boolean isValidFirstMinimumPriceOfMenusToBuy =isHasValidFirstMinimumPriceOfMenusToBuy(firstminimumPriceOfMenusToBuy.getValue())
		       && isHasValidPriceOfMenusToBuy(firstminimumPriceOfMenusToBuy.getValue());
		if(!isValidFirstMinimumPriceOfMenusToBuy){
			throw new InvalidMinimumPriceOfMenusToBuyException("El precio del menu para la su venta no es valido");
		}
		return true;
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
		return true;
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
		return true;
	}

	private boolean isValidEndDateOfferMenu(DateTime endDateOfferMenu) throws InvalidEndDateOfferMenuException {
		if(!isValidDate(endDateOfferMenu)){
			throw new InvalidEndDateOfferMenuException("La fecha de fin no es valida");
		}
		return true;
	}

	private boolean isValidStartDateOfferMenu(DateTime startDateOfferMenu) throws InvalidStartDateOfferMenuException {
		if(!isValidDate(startDateOfferMenu)){
			throw new InvalidStartDateOfferMenuException("La fecha ingresada no es valida");
		}
		return true;
	}

	private boolean isValidMenuDescription(String menuDescription) throws InvalidMenuDescriptionException {
		if(!(isHasValidMenuDescription(menuDescription)&& isHasValidSizeDescription(menuDescription))){
			throw new InvalidMenuDescriptionException("La descripcion del muenu no es valida");
		}
		return true;
		
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
		return true;
	}
	
	private boolean isHasValidSizeName(String menuName) {
		return menuName.length()>=4 && menuName.length()<=30;
	}

	private boolean isHasValidName(String menuName){
		return isValidString(menuName);
	}


}
