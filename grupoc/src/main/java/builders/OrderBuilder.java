package builders;

import org.joda.time.DateTime;

import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidClientException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidMenuException;
import exception.InvalidNumberStreetException;
import exception.InvalidProviderException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import exception.InvalidTimeZoneException;
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
import model.Menu;
import model.Order;
import model.Provider;
import model.TimeZone;
import model.TypeOfDelivery;
import model.User;
import orderExceptions.InvalidDateOfDeliveryException;
import orderExceptions.InvalidDeliveryTimeException;
import orderExceptions.InvalidNumberOfMenusToOrderException;
import orderExceptions.InvalidTypeOfDeliveryException;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
import validation.InvalidFormatTimeZoneException;
import validation.InvalidMenuPriceException;

public class OrderBuilder {
	 private Menu menuToOrder;
     private Integer numberOfMenusToOrder=1;
     private TypeOfDelivery typeOfDelivery= TypeOfDelivery.LOCALDELIVERY;
     private DateTime dateOfDelivery = new DateTime().plusDays(7);
     private TimeZone deliveryTime;
     private User client;
     private Provider provider;
     
     
     public OrderBuilder() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidTelephoneNumberException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException, InvalidTimeZoneException, InvalidFormatTimeZoneException, InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException{
    	 this.menuToOrder= new MenuBuilder().build();
    	 this.client= new ClientBuilder().build();
    	 this.client.setMail("zaracho.rosali@gmail.com");
    	 this.provider = new ProviderBuilder().build();
    	 this.deliveryTime = new TimeZone("18:00","20:00");
     }
     
     public Order build() throws InvalidMenuException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException, InvalidClientException, InvalidProviderException{
    	 return new Order(this.menuToOrder,this.numberOfMenusToOrder,this.typeOfDelivery,this.dateOfDelivery,this.deliveryTime,this.client,this.provider);
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
		this.menuToOrder = menu;
		return this;
		
	}
	
	public OrderBuilder withTypeOfDelivery(TypeOfDelivery typeOfDelivery) {
		this.typeOfDelivery = typeOfDelivery;
		return this;
		
	}
	
	public OrderBuilder withDeliveryTime(TimeZone deliveryTime) {
		this.deliveryTime = deliveryTime;
		return this;
		
	}

	public OrderBuilder withClient(User client) {
		this.client = client;
		return this;
	}
	
	public OrderBuilder withProvider(Provider provider) {
		this.provider = provider;
		return this;
	}
	
	
}
