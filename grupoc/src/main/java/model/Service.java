package model;

import java.util.HashMap;
import java.util.List;

import exception.NumberOfMenusExceededException;

public class Service {
	private String serviceName;
	private String serviceLogo;
	private Address serviceAddress;
	private MapPosition serviceMapPosition;
	private String serviceDescription;
	private List<Menu> serviceMenusOffered; //Tiene que tener al menos 30 elementos y menos que 200
	private String serviceWebDirection;
	private String serviceEmail;
	private Telephone serviceTelephone;
	private HashMap<String,String> serviceWorkingHours;
	private List<String> serviceDeliveryLocations;
	private int maximumNumberOfMenus = 20;

	public String getServiceName() {
		return serviceName;
	}
	
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public String getServiceLogo() {
		return serviceLogo;
	}
	
	public void setServiceLogo(String serviceLogo) {
		this.serviceLogo = serviceLogo;
	}
	
	public Address getServiceAddress() {
		return serviceAddress;
	}
	
	public void setServiceAddress(Address serviceAddress) {
		this.serviceAddress = serviceAddress;
	}
	
	public MapPosition getServiceMapPosition() {
		return serviceMapPosition;
	}
	
	public void setServiceMapPosition(MapPosition serviceMapPosition) {
		this.serviceMapPosition = serviceMapPosition;
	}
	
	public String getServiceDescription() {
		return serviceDescription;
	}
	
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	
	public List<Menu> getServiceMenusOffered() {
		return serviceMenusOffered;
	}
	
	public void setServiceMenusOffered(List<Menu> serviceMenusOffered) {
		this.serviceMenusOffered = serviceMenusOffered;
	}
	
	public String getServiceWebDirection() {
		return serviceWebDirection;
	}
	
	public void setServiceWebDirection(String serviceWebDirection) {
		this.serviceWebDirection = serviceWebDirection;
	}
	
	public String getServiceEmail() {
		return serviceEmail;
	}
	
	public void setServiceEmail(String serviceEmail) {
		this.serviceEmail = serviceEmail;
	}
	
	public Telephone getServiceTelephone() {
		return serviceTelephone;
	}
	
	public void setServiceTelephone(Telephone serviceTelephone) {
		this.serviceTelephone = serviceTelephone;
	}
	
	public HashMap<String,String> getServiceWorkingHours() {
		return serviceWorkingHours;
	}
	
	public void setServiceWorkingHours(HashMap<String,String> serviceWorkingHours) {
		this.serviceWorkingHours = serviceWorkingHours;
	}
	
	public List<String> getServiceDeliveryLocations() {
		return serviceDeliveryLocations;
	}
	
	public void setServiceDeliveryLocations(List<String> serviceDeliveryLocations) {
		this.serviceDeliveryLocations = serviceDeliveryLocations;
	}

	public boolean isAValidService() {
		return true;
	}
	
	public int getMaximumNumberOfMenus() {
		return maximumNumberOfMenus;
	}
	
	public int numberOfMenusOffered() {
		return this.getServiceMenusOffered().size();
	}
	
	public void addMenuToOffer(Menu menuToOffer) throws NumberOfMenusExceededException {
		if(this.numberOfMenusOffered() < this.maximumNumberOfMenus) {
			this.getServiceMenusOffered().add(menuToOffer);		
		} else {
			throw new NumberOfMenusExceededException("No puede ofrecer más de 20 menús");
		}
	}
	
	public Locality serviceLocality() {
		return this.getServiceAddress().getLocality();
	}

}
