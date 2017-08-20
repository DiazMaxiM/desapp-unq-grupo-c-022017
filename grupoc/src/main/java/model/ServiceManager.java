package model;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager {
	private List<Service> servicesOffered;

	public List<Service> getServicesOffered() {
		return servicesOffered;
	}

	public void addService(Service newService) {
		this.servicesOffered.add(newService);
		
	}
	
	public ArrayList<Menu> getAllMenus(){
		ArrayList<Menu> allMenus = new ArrayList<Menu>();
		for(int i = 0; i < this.getServicesOffered().size(); i++){
			allMenus.addAll(this.getServicesOffered().get(i).getServiceMenusOffered());
		}
		return allMenus;
	}

}
