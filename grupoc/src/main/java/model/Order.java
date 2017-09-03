package model;

import org.joda.time.DateTime;

public class Order {
	  private TypeStatusOrder  typeStatusOrder;
      private Menu menuToOrder;
      private Integer numberOfMenusToOrder;
      private TypeOfDelivery typeOfDelivery;
      private DateTime dateOfDelivery;
      private String deliveryTime;
      private Transaction transactionClient;
      private Transaction transactionProvider;
      
    public Order(Menu menuToOrder,Integer numberOfMenusToOrder,
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
      
      
}