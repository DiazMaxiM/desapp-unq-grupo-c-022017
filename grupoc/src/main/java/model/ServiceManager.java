package model;

import java.util.List;

public class ServiceManager {
	private List<Service> servicesOffered;

	public List<Service> getServicesOffered() {
		return servicesOffered;
	}

	public void addService(Service newService) {
		this.servicesOffered.add(newService);
		
	}

}
