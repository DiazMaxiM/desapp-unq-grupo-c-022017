package validation;

import java.util.HashMap;
import java.util.List;

import exception.InvalidAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidTelephoneNumberException;
import model.Address;
import model.Telephone;
import model.TimeZone;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;

public class ServiceValidation extends Validation{

	public boolean isAValidService(String serviceName, String serviceLogo,
    		Address serviceAddress,String serviceDescription, 
    		String serviceWebDirection,String serviceEmail,
    		Telephone serviceTelephone,HashMap<Integer, List<TimeZone>> serviceWorkingHours) throws InvalidServiceNameException, InvalidAddressException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidMapPositionException {
		
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
		return true;
	}
	
	private boolean isValidServiceWorkingHours(HashMap<Integer, List<TimeZone>> serviceWorkingHours) throws InvalidServiceWorkingHoursException {
        if(serviceWorkingHours==null || serviceWorkingHours.isEmpty()){
        	throw new InvalidServiceWorkingHoursException("Ingrese las horas y dias de atencion");
        }
		return true;
	}
	
	private boolean isValidServiceEmail(String serviceEmail) throws InvalidServiceEmailException {
		if(!isValidString(serviceEmail)){
			throw new InvalidServiceEmailException("Ingrese una direccion de mail para el servicio");
		}
		return true;
	}
	
	private boolean isValidServiceDescription(String serviceDescription) throws InvalidServiceDescriptionException {
		if(!isValidString(serviceDescription)){
			throw new InvalidServiceDescriptionException("Ingrese una descripcion del servicio");
		}
		return true;
	}
	
	private boolean isValidServiceLogo(String serviceLogo) throws InvalidServiceLogoException {
		if(!isValidString(serviceLogo)){
			throw new InvalidServiceLogoException("Ingrese un logo para el servicio");
		}
		return true;
	}
	
	private boolean isValidServiceName(String serviceName) throws InvalidServiceNameException {
		if(!isValidString(serviceName)){
			throw new InvalidServiceNameException("Ingrese un nombre para el servicio");
		}
		return true;
	}
}
