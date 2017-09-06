package builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import model.Address;
import model.Days;
import model.Locality;
import model.MapPosition;
import model.Service;
import model.Telephone;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;

public class ServiceBuilder {
	public ServiceBuilder() throws InvalidAddressException, InvalidNumberStreetException, InvalidStreetAddressException,
			InvalidLocalityAddressException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException {
		this.serviceAddress = this.address();
	}

	private String serviceName = "Fast-Food";
	private String serviceLogo = "Perez-H";
	private Address serviceAddress;
	private String serviceDescription = "Hamburguesas caseras";
	private String serviceWebDirection = "";
	private String serviceEmail = "perezH@gmail.com";
	private Telephone serviceTelephone = this.telephone();
	private HashMap<Days, List<String>> serviceWorkingHours = this.serviceWorkingHours();
	private List<Locality> serviceDeliveryLocations = this.serviceDeliveryLocations();

	public Service build() throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException {
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
		} catch (InvalidLengthMapPositionException | InvalidLatitudeMapPositionException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Address address() throws InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		return new Address(Locality.FLORENCIOVARELA, "damasco", "124", "", this.mapPosition());

	}

	private Telephone telephone()
			throws InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException {
		return new Telephone("54", "011", "1245567");
	}

	public ServiceBuilder withServiceName(final String aServiceName) {
		this.serviceName = aServiceName;
		return this;
	}

	public ServiceBuilder withServiceLogo(final String aServiceLogo) {
		this.serviceLogo = aServiceLogo;
		return this;
	}

	public ServiceBuilder withServiceAddress(final Address aServiceAddress) {
		this.serviceAddress = aServiceAddress;
		return this;
	}

	public ServiceBuilder withServiceDescription(final String aServiceDescription) {
		this.serviceDescription = aServiceDescription;
		return this;
	}

	public ServiceBuilder withServiceEmail(final String aServiceEmail) {
		this.serviceEmail = aServiceEmail;
		return this;
	}

	public ServiceBuilder withServiceTelephone(final Telephone aServiceTelephone) {
		this.serviceTelephone = aServiceTelephone;
		return this;
	}

	public ServiceBuilder withServiceWorkingHours(final HashMap<Days, List<String>> aServiceWorkingHours) {
		this.serviceWorkingHours = aServiceWorkingHours;
		return this;
	}

	public ServiceBuilder withServiceDeliveryLocations(final List<Locality> aServiceDeliveryLocations) {
		this.serviceDeliveryLocations = aServiceDeliveryLocations;
		return this;
	}

}
