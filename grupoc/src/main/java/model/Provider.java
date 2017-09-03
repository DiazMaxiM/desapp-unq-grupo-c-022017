package model;

import java.util.ArrayList;
import java.util.List;

import exception.InvalidAddressException;
import exception.InvalidServiceException;
import exception.InvalidTelephoneNumberException;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class Provider extends User{
	private List<Service> servicesOffered= new ArrayList<Service>();
	private TypeStatusUsers status = TypeStatusUsers.ACTIVE;
	
	public Provider(String cuit, String userfirstName, String userLastName, String userEmailAddress,
			Telephone userTelephone, Address userAddress)
			throws InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException {
		super(cuit, userfirstName, userLastName, userEmailAddress, userTelephone, userAddress);
		
	}
	
	public void addNewService(Service newService) throws InvalidServiceException {
		this.servicesOffered.add(newService);
	}

	@Override
	public boolean equals(Object provider) {
		return super.getCuit().equals(((Provider) provider).getCuit());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public List<Service> getServicesOffered() {
		return this.servicesOffered;
	}

	public void disabled() {
		this.setStatus(TypeStatusUsers.INACTIVE);
	}

	private TypeStatusUsers getStatus() {
		return status;
	}

	private void setStatus(TypeStatusUsers status) {
		this.status = status;
	}

}
