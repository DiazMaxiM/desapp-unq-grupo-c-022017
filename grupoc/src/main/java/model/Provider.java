package model;

public class Provider {
	private ServiceManager serviceManager;
	
	public void addNewService(){
		Service newService= new Service();
		this.serviceManager.addService(newService);
	}
}
