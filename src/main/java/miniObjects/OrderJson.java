package miniObjects;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class OrderJson {
	

	public String client;
	public String provider;
	public String menu;
	public String typeDelivery;
	public String countMenu;
	public String startTimeDelivery;
	public String endTimeDelivery;
	public String dateDelivery;
	
	public OrderJson() {
	
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getTypeDelivery() {
		return typeDelivery;
	}

	public void setTypeDelivery(String typeDelivery) {
		this.typeDelivery = typeDelivery;
	}

	public String getCountMenu() {
		return countMenu;
	}

	public void setCountMenu(String countMenu) {
		this.countMenu = countMenu;
	}

	public String getStartTimeDelivery() {
		return startTimeDelivery;
	}

	public void setStartTimeDelivery(String startTimeDelivery) {
		this.startTimeDelivery = startTimeDelivery;
	}

	public String getEndTimeDelivery() {
		return endTimeDelivery;
	}

	public void setEndTimeDelivery(String endTimeDelivery) {
		this.endTimeDelivery = endTimeDelivery;
	}

	public String getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(String dateDelivery) {
		this.dateDelivery = dateDelivery;
	}
	
	


	

	
	
	

}
