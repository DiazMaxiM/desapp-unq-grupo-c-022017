package model;

import java.util.ArrayList;
import java.util.List;

import exception.InvalidServiceException;

public class Provider {
	private String cuit;
	private List<Service> servicesOffered;

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
	
	public List<Service>getServicesOffered(){
		return this.servicesOffered;
	}
	
}
