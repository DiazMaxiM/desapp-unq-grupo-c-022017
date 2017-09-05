package model;

import org.joda.time.DateTime;

import exception.InvalidMenuException;
import orderExceptions.InvalidDateOfDeliveryException;
import orderExceptions.InvalidDeliveryTimeException;
import orderExceptions.InvalidNumberOfMenusToOrderException;
import orderExceptions.InvalidTypeOfDeliveryException;
import validation.OrderValidation;

public class Order {
	  private TypeStatusOrder  typeStatusOrder;
      private Menu menuToOrder;
      private Integer numberOfMenusToOrder;
      private TypeOfDelivery typeOfDelivery;
      private DateTime dateOfDelivery;
      private String deliveryTime;
      private User   client; 
      private Provider provider;
      private Transaction transactionClient;
      private Transaction transactionProvider;
      private OrderValidation validator= new OrderValidation();
   
      
    public Order(Menu menuToOrder,Integer numberOfMenusToOrder,
    		     TypeOfDelivery typeOfDelivery,DateTime dateOfDelivery,String deliveryTime) throws InvalidMenuException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException{
    	if(validator.isValidOrder(menuToOrder,numberOfMenusToOrder,typeOfDelivery,dateOfDelivery,deliveryTime)){
    		createOrder(menuToOrder,numberOfMenusToOrder,typeOfDelivery,dateOfDelivery,deliveryTime);
    	}
    }
    
    public void createOrder(Menu menuToOrder,Integer numberOfMenusToOrder,
    		     TypeOfDelivery typeOfDelivery,DateTime dateOfDelivery,String deliveryTime){
    	setMenuToOrder(menuToOrder);
    	setNumberOfMenusToOrder(numberOfMenusToOrder);
    	setTypeOfDelivery(typeOfDelivery);
    	setDateOfDelivery(dateOfDelivery);
    	setDeliveryTime(deliveryTime);
    	
    }
	public Menu getMenuToOrder() {
		return menuToOrder;
	}
	public void setMenuToOrder(Menu menuToOrder) {
		this.menuToOrder = menuToOrder;
	}
	public Integer getNumberOfMenusToOrder() {
		return numberOfMenusToOrder;
	}
	public void setNumberOfMenusToOrder(Integer numberOfMenusToOrder) {
		this.numberOfMenusToOrder = numberOfMenusToOrder;
	}
	public TypeOfDelivery getTypeOfDelivery() {
		return typeOfDelivery;
	}
	public void setTypeOfDelivery(TypeOfDelivery typeOfDelivery) {
		this.typeOfDelivery = typeOfDelivery;
	}
	public DateTime getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(DateTime dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public TypeStatusOrder getTypeStatusOrder() {
		return typeStatusOrder;
	}

	public void setTypeStatusOrder(TypeStatusOrder typeStatusOrder) {
		this.typeStatusOrder = typeStatusOrder;
	}

	public Transaction getTransactionProvider() {
		return transactionProvider;
	}

	public void setTransactionProvider(Transaction transactionProvider) {
		this.transactionProvider = transactionProvider;
	}

	public Transaction getTransactionClient() {
		return transactionClient;
	}

	public void setTransactionClient(Transaction transactionClient) {
		this.transactionClient = transactionClient;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
      
      
}