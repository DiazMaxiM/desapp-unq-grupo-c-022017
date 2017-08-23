package model;

import java.util.ArrayList;
import java.util.List;

import exception.InvalidServiceException;

public class Provider {
	private List<Service> servicesOffered;
	
	public Provider(){
		this.servicesOffered= new ArrayList<Service>();
	}
	public void addNewService(Service newService) throws InvalidServiceException{
			this.servicesOffered.add(newService);
	}
}
