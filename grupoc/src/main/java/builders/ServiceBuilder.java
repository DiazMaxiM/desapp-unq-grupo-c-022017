package builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exception.InvalidAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidServiceException;
import exception.InvalidTelephoneNumberException;
import model.Address;
import model.Days;
import model.Locality;
import model.MapPosition;
import model.Service;
import model.Telephone;

public class ServiceBuilder {
	public ServiceBuilder() {
	}

	private String serviceName = "Fast-Food";
	private String serviceLogo = "Perez-H";
	private Address serviceAddress = this.address();
	private String serviceDescription = "Hamburguesas caseras";
	private String serviceWebDirection = "";
	private String serviceEmail = "perezH@gmail.com";
	private Telephone serviceTelephone = this.telephone();
	private HashMap<Days, List<String>> serviceWorkingHours = this.serviceWorkingHours();
	private List<Locality> serviceDeliveryLocations = this.serviceDeliveryLocations();

	public Service build() throws InvalidServiceException {
		Service service = new Service(serviceName, serviceLogo, serviceAddress, serviceDescription, serviceWebDirection,
				serviceEmail, serviceTelephone, serviceWorkingHours, serviceDeliveryLocations);
		return service;
	}

	private HashMap<Days, List<String>> serviceWorkingHours() {
		HashMap<Days, List<String>> serviceWorkingHours = new HashMap<>();
		List<String> workingHours = new ArrayList<>();
		workingHours.add("17:00 a 24:00");
		serviceWorkingHours.put(Days.THURSDAY, workingHours);
		serviceWorkingHours.put(Days.FRIDAY, workingHours);
		serviceWorkingHours.put(Days.SATURDAY, workingHours);
		serviceWorkingHours.put(Days.SUNDAY, workingHours);
		return serviceWorkingHours;
	}

	private List<Locality> serviceDeliveryLocations() {
		List<Locality> serviceDeliveryLocations = new ArrayList<>();
		serviceDeliveryLocations.add(Locality.BERAZATEGUI);
		serviceDeliveryLocations.add(Locality.QUILMES);
		serviceDeliveryLocations.add(Locality.FLORENCIOVARELA);
		return serviceDeliveryLocations;
	}

	private MapPosition mapPosition() {
		try {
			return new MapPosition(new Double(12345), new Double(34456));
		} catch (InvalidMapPositionException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Address address() {
		try {
			return new Address(Locality.FLORENCIOVARELA, "damasco", "124", "", this.mapPosition());
		} catch (InvalidAddressException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Telephone telephone() {
		try {
			return new Telephone("54", "011", "1245567");
		} catch (InvalidTelephoneNumberException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ServiceBuilder withServiceName(final String aServiceName) {
		this.setServiceName(aServiceName);
		return this;
	}

	public ServiceBuilder withServiceLogo(final String aServiceLogo) {
		this.setServiceLogo(aServiceLogo);
		return this;
	}
	
	public ServiceBuilder withServiceAddress(final Address aServiceAddress) {
		this.setServiceAddress(aServiceAddress);
		return this;
	}

	public ServiceBuilder withServiceDescription(final String aServiceDescription) {
		this.setServiceDescription(aServiceDescription);
		return this;
	}

	public ServiceBuilder withServiceEmail(final String aServiceEmail) {
		this.setServiceEmail(aServiceEmail);
		return this;
	}

	public ServiceBuilder withServiceTelephone(final Telephone aServiceTelephone) {
		this.setServiceTelephone(aServiceTelephone);
		return this;
	}

	public ServiceBuilder withServiceWorkingHours(final HashMap<Days, List<String>> aServiceWorkingHours) {
		this.setServiceWorkingHours(aServiceWorkingHours);
		return this;
	}

	public ServiceBuilder withServiceDeliveryLocations(final List<Locality> aServiceDeliveryLocations) {
		this.setServiceDeliveryLocations(aServiceDeliveryLocations);
		return this;
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

	public HashMap<Days, List<String>> getServiceWorkingHours() {
		return serviceWorkingHours;
	}

	public void setServiceWorkingHours(HashMap<Days, List<String>> serviceWorkingHours) {
		this.serviceWorkingHours = serviceWorkingHours;
	}

	public List<Locality> getServiceDeliveryLocations() {
		return serviceDeliveryLocations;
	}

	public void setServiceDeliveryLocations(List<Locality> serviceDeliveryLocations) {
		this.serviceDeliveryLocations = serviceDeliveryLocations;
	}

}
