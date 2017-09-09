package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exception.InvalidAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidServiceException;
import exception.InvalidTelephoneNumberException;
import exception.NumberOfMenusExceededException;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import validation.ServiceValidation;

public class Service {
	private String serviceName; // Required
	private String serviceLogo; // Required
	private Address serviceAddress; // Required
	private String serviceDescription;// Required
	private List<Menu> serviceMenusOffered;
	private String serviceWebDirection;
	private String serviceEmail;// Required
	private Telephone serviceTelephone;// Required
	private HashMap<Integer, List<TimeZone>> serviceWorkingHours;// Required
	private List<Locality> serviceDeliveryLocations;
	private int maximumNumberOfMenus = 20;
	private ServiceValidation validator = new ServiceValidation();

	public Service(String serviceName, String serviceLogo, Address serviceAddress, String serviceDescription,
			String serviceWebDirection, String serviceEmail, Telephone serviceTelephone,
			HashMap<Integer, List<TimeZone>> serviceWorkingHours, List<Locality> serviceDeliveryLocations)
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidMapPositionException {

		if (validator.isAValidService(serviceName, serviceLogo, serviceAddress, serviceDescription, serviceWebDirection,
				serviceEmail, serviceTelephone, serviceWorkingHours)) {

			createService(serviceName, serviceLogo, serviceAddress, serviceDescription, serviceWebDirection,
					serviceEmail, serviceTelephone, serviceWorkingHours, serviceDeliveryLocations);
		}
	}

	private void createService(String serviceName, String serviceLogo, Address serviceAddress,
			String serviceDescription, String serviceWebDirection, String serviceEmail, Telephone serviceTelephone,
			HashMap<Integer, List<TimeZone>> serviceWorkingHours, List<Locality> serviceDeliveryLocations) {

		this.setServiceName(serviceName);
		this.setServiceLogo(serviceLogo);
		this.setServiceAddress(serviceAddress);
		this.setServiceDescription(serviceDescription);
		this.serviceMenusOffered = new ArrayList<>();
		this.setServiceWebDirection(serviceWebDirection);
		this.setServiceEmail(serviceEmail);
		this.setServiceTelephone(serviceTelephone);
		this.setServiceWorkingHours(serviceWorkingHours);
		this.setServiceDeliveryLocations(serviceDeliveryLocations);
	}

	public List<Menu> getServiceMenusOffered() {
		return this.serviceMenusOffered;
	}

	public int numberOfMenusOffered() {
		return this.getServiceMenusOffered().size();
	}

	public void addMenuToOffer(Menu menuToOffer) throws NumberOfMenusExceededException {
		if (this.numberOfMenusOffered() < this.maximumNumberOfMenus) {
			this.getServiceMenusOffered().add(menuToOffer);
		} else {
			throw new NumberOfMenusExceededException("No puede ofrecer más de 20 menús");
		}
	}

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

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
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

	public HashMap<Integer, List<TimeZone>> getServiceWorkingHours() {
		return serviceWorkingHours;
	}

	public void setServiceWorkingHours(HashMap<Integer, List<TimeZone>> serviceWorkingHours) {
		this.serviceWorkingHours = serviceWorkingHours;
	}

	public List<Locality> getServiceDeliveryLocations() {
		return serviceDeliveryLocations;
	}

	public void setServiceDeliveryLocations(List<Locality> serviceDeliveryLocations) {
		this.serviceDeliveryLocations = serviceDeliveryLocations;
	}

	public Locality serviceLocality() {
		return this.getServiceAddress().getLocality();
	}

	public void removeMenuToDelete(Menu menuToDelete) {
		this.getServiceMenusOffered().remove(menuToDelete);

	}

	public void updateMenu(Menu menuToModify, Menu menuToUpdate) {
		int indexToModify = this.getServiceMenusOffered().indexOf(menuToModify);
		this.getServiceMenusOffered().add(indexToModify, menuToUpdate);
	}

}
