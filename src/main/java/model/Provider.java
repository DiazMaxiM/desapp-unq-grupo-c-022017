package model;

import java.util.ArrayList;
import java.util.List;

import exception.InvalidAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidServiceException;
import exception.InvalidTelephoneNumberException;
import exception.NumberOfMenusExceededException;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

public class Provider extends User {
	private List<Service> servicesOffered = new ArrayList<>();
	private TypeStatusUsers status = TypeStatusUsers.ACTIVE;
	private ArrayList<HistoricalOrder> historicalOrders = new ArrayList<HistoricalOrder>();

	public Provider(String cuit, String userfirstName, String userLastName, String userEmailAddress,
			Telephone userTelephone, Address userAddress, String password) throws InvalidAddressException,
			InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException,
			InvalidEmailAddressException, InvalidMapPositionException {
		super(cuit, userfirstName, userLastName, userEmailAddress, userTelephone, userAddress, password);

	}

	public void addNewService(Service newService) throws InvalidServiceException {
		this.servicesOffered.add(newService);
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

	public void addNewMenuInService(Service service, Menu menuToOffer) throws NumberOfMenusExceededException {
		int indexServiceToAdd = this.getServicesOffered().indexOf(service);
		this.getServicesOffered().get(indexServiceToAdd).addMenuToOffer(menuToOffer);
	}

	public void updateMenuInService(Service service, Menu menuToModify, Menu menuToUpdate) {
		int indexServiceToUpdate = this.getServicesOffered().indexOf(service);
		this.getServicesOffered().get(indexServiceToUpdate).updateMenu(menuToModify, menuToUpdate);
	}

	public void deleteMenuOfService(Service service, Menu menuToDelete) {
		int indexServiceToDelete = this.getServicesOffered().indexOf(service);
		this.getServicesOffered().get(indexServiceToDelete).removeMenuToDelete(menuToDelete);

	}

	public void addHistoricalOrder(HistoricalOrder historicalOrder) {
		this.historicalOrders.add(historicalOrder);
	}

}
