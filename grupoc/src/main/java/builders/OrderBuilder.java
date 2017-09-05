package builders;

import org.joda.time.DateTime;

import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidCountryCodeException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMenuException;
import exception.InvalidNumberStreetException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import menuExceptions.InvalidDeliveryPriceException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidFirstMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMaximumNumberOfMunusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidStartDateOfferMenuException;
import model.Menu;
import model.Order;
import model.TypeOfDelivery;
import orderExceptions.InvalidDateOfDeliveryException;
import orderExceptions.InvalidDeliveryTimeException;
import orderExceptions.InvalidNumberOfMenusToOrderException;
import orderExceptions.InvalidTypeOfDeliveryException;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;

public class OrderBuilder {
	 private Menu menuToOrder;
     private Integer numberOfMenusToOrder=1;
     private TypeOfDelivery typeOfDelivery= TypeOfDelivery.HOMEDELIVERY;
     private DateTime dateOfDelivery = new DateTime("2017-09-07T07:22:05Z");
     private String deliveryTime= "13:30";
     
     public OrderBuilder() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException{
    	 this.menuToOrder= new MenuBuilder().build();
     }
     
     public Order build() throws InvalidMenuException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException{
    	 return new Order(this.menuToOrder,this.numberOfMenusToOrder,this.typeOfDelivery,this.dateOfDelivery,this.deliveryTime);
     }
    
     public Menu getMenu(){
    	 return this.menuToOrder;
     }

	public OrderBuilder withDateOfDelivery(DateTime dateOfDelivery) {
		this.dateOfDelivery= dateOfDelivery;
		return this;
	}
    
	public OrderBuilder withNumberOfMenusToOrder(Integer numberOfMenusToOrder) {
		this.numberOfMenusToOrder= numberOfMenusToOrder;
		return this;
	}
	
	
	public OrderBuilder withMaximunMenuToSell(Integer maximumNumberOfMunusSalesPerDay) {
		this.menuToOrder.setMaximumNumberOfMenusSalesPerDay(maximumNumberOfMunusSalesPerDay);
		return this;
	}

	public OrderBuilder withMenuToOrder(Menu menu) {
		this.menuToOrder= menu;
		return this;
		
	}
	
	public OrderBuilder withTypeOfDelivery(TypeOfDelivery typeOfDelivery) {
		this.typeOfDelivery= typeOfDelivery;
		return this;
		
	}
	
	public OrderBuilder withDeliveryTime(String deliveryTime) {
		this.deliveryTime= deliveryTime;
		return this;
		
	}
	
	
}
