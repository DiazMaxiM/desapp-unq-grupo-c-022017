package model;
import java.util.List;
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

public class Menu {
    private String menuName;
    private String menuDescription;
    private Category menuCategory;
    private Double menuDeliveryPrice;
    private DateTime startDateOfferMenu;
    private DateTime endDateOfferMenu;
    private List<String> deliveryTimesMenus;
    private Integer averageDeliveryTimeOfMenu;
    private Double menuPrice;
    private Integer firstMinimumNumberOfMenusToBuy;
    private Double firstminimumPriceOfMenusToBuy;
    private Integer secondMinimumNumberOfMenusToBuy;
    private Double secondMinimumPriceOfMenusToBuy;
    private Integer maximumNumberOfMunusSalesPerDay;
    private Service service;
    private Validation validator= new Validation();
    
	public Menu(String menuName, String menuDescription, Category menuCategory,
			    Double menuDeliveryPrice,DateTime startDateOfferMenu,
			    DateTime endDateOfferMenu,List<String> deliveryTimesMenus,
			    Integer averageDeliveryTimeOfMenu,Double menuPrice,
			    Integer firstMinimumNumberOfMenusToBuy,Double firstminimumPriceOfMenusToBuy,
			    Integer secondMinimumNumberOfMenusToBuy,Double secondMinimumPriceOfMenusToBuy,
			    Integer maximumNumberOfMunusSalesPerDay,Service service) throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay {
		
		if(isAValidMenu(menuName,menuDescription,menuCategory,menuDeliveryPrice,
				startDateOfferMenu,endDateOfferMenu,averageDeliveryTimeOfMenu,
				firstMinimumNumberOfMenusToBuy,firstminimumPriceOfMenusToBuy,
				secondMinimumNumberOfMenusToBuy,secondMinimumPriceOfMenusToBuy,
				maximumNumberOfMunusSalesPerDay,service)){
			
			createMenu(menuName,menuDescription,menuCategory,menuDeliveryPrice,
					   startDateOfferMenu,endDateOfferMenu,deliveryTimesMenus,
				       averageDeliveryTimeOfMenu,menuPrice,firstMinimumNumberOfMenusToBuy,
				       firstminimumPriceOfMenusToBuy,secondMinimumNumberOfMenusToBuy,
				       secondMinimumPriceOfMenusToBuy,maximumNumberOfMunusSalesPerDay,
				       service);
		}
	}
	
	private boolean isAValidMenu(String menuName, String menuDescription,Category menuCategory,Double menuDeliveryPrice,
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
		if(validator.isValidDoubleNumber(menuDeliveryPrice)){
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
		if(!validator.isValidIntegerNumber(maximumNumberOfMunusSalesPerDay)){
			throw new InvalidMaximumNumberOfMunusSalesPerDay("Ingrese la cantidad maxima de ventas de menus por dia");
		}
		return validator.isValidIntegerNumber(maximumNumberOfMunusSalesPerDay);
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
		return validator.isValidDoubleNumber(secondMinimumPriceOfMenusToBuy);
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
		return validator.isValidIntegerNumber(secondMinimumNumberOfMenusToBuy);
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
		return validator.isValidDoubleNumber(firstminimumPriceOfMenusToBuy);
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
		return validator.isValidIntegerNumber(firstMinimumNumberOfMenusToBuy);
	}

	private boolean isValidAverageDeliveryTimeOfMenu(Integer averageDeliveryTimeOfMenu) throws InvalidAverageDeliveryTimeOfMenuException {
		if(!validator.isValidIntegerNumber(averageDeliveryTimeOfMenu)){
			throw new InvalidAverageDeliveryTimeOfMenuException("Ingrese un tiempo promedio de entrega");
		}
		return validator.isValidIntegerNumber(averageDeliveryTimeOfMenu);
	}

	private boolean isValidEndDateOfferMenu(DateTime endDateOfferMenu) throws InvalidEndDateOfferMenuException {
		if(!validator.isValidDate(endDateOfferMenu)){
			throw new InvalidEndDateOfferMenuException("La fecha de fin no es valida");
		}
		return validator.isValidDate(endDateOfferMenu);
	}

	private boolean isValidStartDateOfferMenu(DateTime startDateOfferMenu) throws InvalidStartDateOfferMenuException {
		if(!validator.isValidDate(startDateOfferMenu)){
			throw new InvalidStartDateOfferMenuException("La fecha ingresada no es valida");
		}
		return validator.isValidDate(startDateOfferMenu);
	}

	private boolean isValidCategory(Category menuCategory) throws InvalidMenuCategoryException {
		if(!validator.isValidCategory(menuCategory)){
			throw new InvalidMenuCategoryException("Ingrese una categoria");
		}
		return validator.isValidCategory(menuCategory);
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
		return validator.isValidString(menuDescription);
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
		return validator.isValidString(menuName);
	}

	private void createMenu(String menuName, String menuDescription, Category menuCategory,
		    Double menuDeliveryPrice,DateTime startDateOfferMenu,
		    DateTime endDateOfferMenu,List<String> deliveryTimesMenus,
		    Integer averageDeliveryTimeOfMenu,Double menuPrice,
		    Integer firstMinimumNumberOfMenusToBuy,Double firstminimumPriceOfMenusToBuy,
		    Integer secondMinimumNumberOfMenusToBuy,Double secondMinimumPriceOfMenusToBuy,
		    Integer maximumNumberOfMunusSalesPerDay,Service service) {
		
		setMenuName(menuName);
		setMenuDescription(menuDescription);
		setMenuCategory(menuCategory);
		setMenuDeliveryPrice(menuDeliveryPrice);
		setStartDateOfferMenu(startDateOfferMenu);
		setEndDateOfferMenu(endDateOfferMenu);
		setDeliveryTimesMenus(deliveryTimesMenus);
		setAverageDeliveryTimeOfMenu(averageDeliveryTimeOfMenu);
		setMenuPrice(menuPrice);
		setFirstMinimumNumberOfMenusToBuy(firstMinimumNumberOfMenusToBuy);
		setFirstminimumPriceOfMenusToBuy(firstminimumPriceOfMenusToBuy);
		setSecondMinimumNumberOfMenusToBuy(secondMinimumNumberOfMenusToBuy);
		setSecondMinimumPriceOfMenusToBuy(secondMinimumPriceOfMenusToBuy);
		setMaximumNumberOfMunusSalesPerDay(maximumNumberOfMunusSalesPerDay);
		setService(service);
		
	}

	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuDescription() {
		return menuDescription;
	}
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	public Category getMenuCategory() {
		return menuCategory;
	}
	public void setMenuCategory(Category menuCategory) {
		this.menuCategory = menuCategory;
	}
	public Double getMenuDeliveryPrice() {
		return menuDeliveryPrice;
	}
	public void setMenuDeliveryPrice(Double menuDeliveryPrice) {
		this.menuDeliveryPrice = menuDeliveryPrice;
	}
	public DateTime getStartDateOfferMenu() {
		return startDateOfferMenu;
	}
	public void setStartDateOfferMenu(DateTime startDateOfferMenu) {
		this.startDateOfferMenu = startDateOfferMenu;
	}
	public DateTime getEndDateOfferMenu() {
		return endDateOfferMenu;
	}
	public void setEndDateOfferMenu(DateTime endDateOfferMenu) {
		this.endDateOfferMenu = endDateOfferMenu;
	}
	public List<String> getDeliveryTimesMenus() {
		return deliveryTimesMenus;
	}
	public void setDeliveryTimesMenus(List<String> deliveryTimesMenus) {
		this.deliveryTimesMenus = deliveryTimesMenus;
	}
	public Integer getAverageDeliveryTimeOfMenu() {
		return averageDeliveryTimeOfMenu;
	}
	public void setAverageDeliveryTimeOfMenu(Integer averageDeliveryTimeOfMenu) {
		this.averageDeliveryTimeOfMenu = averageDeliveryTimeOfMenu;
	}
	public Double getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(Double menuPrice) {
		this.menuPrice = menuPrice;
	}
	public Integer getFirstMinimumNumberOfMenusToBuy() {
		return firstMinimumNumberOfMenusToBuy;
	}
	public void setFirstMinimumNumberOfMenusToBuy(Integer firstMinimumNumberOfMenusToBuy) {
		this.firstMinimumNumberOfMenusToBuy = firstMinimumNumberOfMenusToBuy;
	}
	public Double getFirstminimumPriceOfMenusToBuy() {
		return firstminimumPriceOfMenusToBuy;
	}
	public void setFirstminimumPriceOfMenusToBuy(Double firstminimumPriceOfMenusToBuy) {
		this.firstminimumPriceOfMenusToBuy = firstminimumPriceOfMenusToBuy;
	}
	public Integer getSecondMinimumNumberOfMenusToBuy() {
		return secondMinimumNumberOfMenusToBuy;
	}
	public void setSecondMinimumNumberOfMenusToBuy(Integer secondMinimumNumberOfMenusToBuy) {
		this.secondMinimumNumberOfMenusToBuy = secondMinimumNumberOfMenusToBuy;
	}
	public Double getSecondMinimumPriceOfMenusToBuy() {
		return secondMinimumPriceOfMenusToBuy;
	}
	public void setSecondMinimumPriceOfMenusToBuy(Double secondMinimumPriceOfMenusToBuy) {
		this.secondMinimumPriceOfMenusToBuy = secondMinimumPriceOfMenusToBuy;
	}
	public Integer getMaximumNumberOfMunusSalesPerDay() {
		return maximumNumberOfMunusSalesPerDay;
	}
	public void setMaximumNumberOfMunusSalesPerDay(Integer maximumNumberOfMunusSalesPerDay) {
		this.maximumNumberOfMunusSalesPerDay = maximumNumberOfMunusSalesPerDay;
	}
    
}
