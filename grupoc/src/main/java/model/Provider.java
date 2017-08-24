package model;

public class Provider {
	private ServiceManager serviceManager;
	private String cuit;

	public void addNewService() {
		Service newService = new Service();
		this.serviceManager.addService(newService);
	}

	@Override
	public boolean equals(Object provider) {
		return this.cuit.equals(((Provider) provider).cuit);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
