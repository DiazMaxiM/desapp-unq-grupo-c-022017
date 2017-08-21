package model;

import java.util.ArrayList;
import java.util.List;

import exception.InvalidServiceException;

public class ServiceManager {
	private List<Service> servicesOffered;

	public List<Service> getServicesOffered() {
		return servicesOffered;
	}

	public void addService(Service newService) {
		if(newService.isAValidService()){
			this.servicesOffered.add(newService);
		}
		else{
			new InvalidServiceException("The service entered is not valid");
		}
	}
	
	public ArrayList<Menu> getAllMenus(){
		ArrayList<Menu> allMenus = new ArrayList<Menu>();
		for(int i = 0; i < this.getServicesOffered().size(); i++){
			allMenus.addAll(this.getServicesOffered().get(i).getServiceMenusOffered());
		}
		return allMenus;
	}

}
