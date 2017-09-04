package model;

import java.util.ArrayList;
import java.util.List;

import exception.InvalidServiceException;

public class Provider extends User {
	private String cuit;
	private List<Service> servicesOffered;
	private TypeStatusUsers status = TypeStatusUsers.ACTIVE;

	public Provider() {
		this.servicesOffered = new ArrayList<Service>();
	}

	public void addNewService(Service newService) throws InvalidServiceException {
		this.servicesOffered.add(newService);
	}

	@Override
	public boolean equals(Object provider) {
		return this.cuit.equals(((Provider) provider).cuit);
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
