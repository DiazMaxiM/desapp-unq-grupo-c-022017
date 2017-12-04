package model;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import exception.InvalidClientException;
import exception.InvalidMenuException;
import exception.InvalidProviderException;
import orderExceptions.InvalidDateOfDeliveryException;
import orderExceptions.InvalidDeliveryTimeException;
import orderExceptions.InvalidNumberOfMenusToOrderException;
import orderExceptions.InvalidTypeOfDeliveryException;
import validation.OrderValidation;

public class Order extends Entity {
	private TypeStatusOrder typeStatusOrder;
	private Menu menuToOrder; 
	private Integer numberOfMenusToOrder;
	private TypeOfDelivery typeOfDelivery;
	private LocalDateTime dateOfDelivery;
	private TimeZone deliveryTime;
	private User client;
	private Provider provider;
	private Transaction transactionClient;
	private Transaction transactionProvider;
	private OrderValidation validator = new OrderValidation();
	private DateTime dateOfOrder = new DateTime();

	public Order(Menu menuToOrder, Integer numberOfMenusToOrder, TypeOfDelivery typeOfDelivery,
			LocalDateTime dateOfDelivery, TimeZone deliveryTime, User client, Provider provider)
			throws InvalidMenuException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException,
			InvalidDateOfDeliveryException, InvalidDeliveryTimeException, InvalidClientException,
			InvalidProviderException {
		if (validator.isValidOrder(menuToOrder, numberOfMenusToOrder, typeOfDelivery, dateOfDelivery, deliveryTime,
				client, provider)) {
			createOrder(menuToOrder, numberOfMenusToOrder, typeOfDelivery, dateOfDelivery, deliveryTime, client,
					provider);
		}
	}
	
	public Order() {

	}


	public void createOrder(Menu menuToOrder, Integer numberOfMenusToOrder, TypeOfDelivery typeOfDelivery,
			LocalDateTime dateOfDelivery, TimeZone deliveryTime, User client, Provider provider) {
		setMenuToOrder(menuToOrder);
		setNumberOfMenusToOrder(numberOfMenusToOrder);
		setTypeOfDelivery(typeOfDelivery);
		setDateOfDelivery(dateOfDelivery);
		setDeliveryTime(deliveryTime);
		setClient(client);
		setProvider(provider);
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

	public LocalDateTime getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(LocalDateTime dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
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

	public TimeZone getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(TimeZone deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public DateTime getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(DateTime dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

}