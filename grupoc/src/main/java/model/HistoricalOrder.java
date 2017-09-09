package model;

import org.joda.time.DateTime;

public class HistoricalOrder {

	private Score score;
	private DateTime deliveryTime;
	private TypeStatusOrder typeStatusOrder;
	private Menu menu;
	private Double price;
	private DateTime dateOfOrder;
	private TypeOfDelivery typeOfDelivery;

	public HistoricalOrder(Score score, DateTime deliveryTime, TypeStatusOrder typeStatusOrder, Menu menu, Double price,
			DateTime dateOfOrder, TypeOfDelivery typeOfDelivery) {
		this.score = score;
		this.deliveryTime = deliveryTime;
		this.typeStatusOrder = typeStatusOrder;
		this.menu = menu;
		this.price = price;
		this.dateOfOrder = dateOfOrder;
		this.typeOfDelivery = typeOfDelivery;
	}

}
