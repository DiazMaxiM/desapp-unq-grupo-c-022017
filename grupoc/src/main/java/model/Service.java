package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import exception.InvalidAddressException;
import exception.InvalidServiceException;
import exception.InvalidTelephoneNumberException;
import exception.NumberOfMenusExceededException;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import validation.Validation;

public class Service {
	private String serviceName; //Required
	private String serviceLogo; //Required
	private Address serviceAddress; //Required
	private String serviceDescription;//Required
	private List<Menu>serviceMenusOffered; //Tiene que tener al menos 30 elementos y menos que 200
	private String serviceWebDirection;
	private String serviceEmail;//Required
	private Telephone serviceTelephone;//Required
	private HashMap<Days,List<String>> serviceWorkingHours;//Required
	private List<Locality> serviceDeliveryLocations;
	private int maximumNumberOfMenus = 20;
	private Validation validator = new Validation();
	
	public Service(String serviceName,String serviceLogo,Address serviceAddress,
			       String serviceDescription,String serviceWebDirection,
			       String serviceEmail,Telephone serviceTelephone,
			       HashMap<Days,List<String>> serviceWorkingHours,
			       List<Locality>serviceDeliveryLocations) throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException{
		
		  if(isAValidService(serviceName,serviceLogo,
				             serviceAddress,serviceDescription,
				             serviceWebDirection,serviceEmail,
				             serviceTelephone,serviceWorkingHours)){
			  
			  createService(serviceName, serviceLogo, 
					        serviceAddress, serviceDescription, 
					        serviceWebDirection, serviceEmail, 
					        serviceTelephone, serviceWorkingHours,
					        serviceDeliveryLocations);
		  }
	}
	
    private boolean isAValidService(String serviceName, String serviceLogo,
    		Address serviceAddress,String serviceDescription, 
    		String serviceWebDirection,String serviceEmail,
    		Telephone serviceTelephone,HashMap<Days, List<String>> serviceWorkingHours) throws InvalidServiceNameException, InvalidAddressException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException {
		
		return isValidServiceName(serviceName)
			   && isValidServiceLogo(serviceLogo)
			   && isValidServiceDescription(serviceDescription)
			   && isValidServiceEmail(serviceEmail)
			   && isValidAddress(serviceAddress)
			   && isAValidTelephone(serviceTelephone)
			   && isValidServiceWorkingHours(serviceWorkingHours);
	}
    
	private boolean isAValidTelephone(Telephone serviceTelephone) throws InvalidTelephoneNumberException {
		if(serviceTelephone==null){
			
			throw new InvalidTelephoneNumberException("Ingrese un telefono para el servicio");
			
		}
		return serviceTelephone!=null;
	}
	
	private boolean isValidAddress(Address serviceAddress) throws InvalidAddressException{
		if(serviceAddress==null){
			throw new InvalidAddressException("Ingrese un direccion para el servicio");
		}
		return serviceAddress!=null;
	}
	
	private boolean isValidServiceWorkingHours(HashMap<Days, List<String>> serviceWorkingHours) throws InvalidServiceWorkingHoursException {
        if(serviceWorkingHours==null || serviceWorkingHours.isEmpty()){
        	throw new InvalidServiceWorkingHoursException("Ingrese las horas y dias de atencion");
        }
		return serviceWorkingHours!=null && !serviceWorkingHours.isEmpty();
	}
	
	private boolean isValidServiceEmail(String serviceEmail) throws InvalidServiceEmailException {
		if(!validator.isValidString(serviceEmail)){
			throw new InvalidServiceEmailException("Ingrese una direccion de mail para el servicio");
		}
		return validator.isValidString(serviceEmail);
	}
	
	private boolean isValidServiceDescription(String serviceDescription) throws InvalidServiceDescriptionException {
		if(!validator.isValidString(serviceDescription)){
			throw new InvalidServiceDescriptionException("Ingrese una descripcion del servicio");
		}
		return validator.isValidString(serviceDescription);
	}
	
	private boolean isValidServiceLogo(String serviceLogo) throws InvalidServiceLogoException {
		if(!validator.isValidString(serviceLogo)){
			throw new InvalidServiceLogoException("Ingrese un logo para el servicio");
		}
		return validator.isValidString(serviceLogo);
	}
	
	private boolean isValidServiceName(String serviceName) throws InvalidServiceNameException {
		if(!validator.isValidString(serviceName)){
			throw new InvalidServiceNameException("Ingrese un nombre para el servicio");
		}
		return validator.isValidString(serviceName);
	}
	
	private void createService(String serviceName,String serviceLogo,Address serviceAddress,
		       String serviceDescription,String serviceWebDirection,
		       String serviceEmail,Telephone serviceTelephone,
		       HashMap<Days,List<String>> serviceWorkingHours,
		       List<Locality> serviceDeliveryLocations){
    	  
    	this.setServiceName(serviceName);
		this.setServiceLogo(serviceLogo);
		this.setServiceAddress(serviceAddress);
		this.setServiceDescription(serviceDescription);
		this.serviceMenusOffered      = new ArrayList<>();
		this.setServiceWebDirection(serviceWebDirection);
		this.setServiceEmail(serviceEmail);
		this.setServiceTelephone(serviceTelephone);
		this.setServiceWorkingHours(serviceWorkingHours);
		this.setServiceDeliveryLocations(new ArrayList<>());	
    }
    public List<Menu>getServiceMenusOffered(){
	   return this.serviceMenusOffered;
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
	
	public HashMap<Days,List<String>> getServiceWorkingHours() {
		return serviceWorkingHours;
	}
	
	public void setServiceWorkingHours(HashMap<Days,List<String>> serviceWorkingHours) {
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

}
