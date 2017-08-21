package menusearch;

import java.util.ArrayList;
import model.Menu;
import model.ServiceManager;

public abstract class MenuSearchCriteria {
	
	private ServiceManager serviceManager;
	private Object searchCriteria;

	public  ArrayList<Menu> menuSearch(){
		ArrayList<Menu> allMenus = this.getServiceManager().getAllMenus();
		ArrayList<Menu> menuSearchResult = new ArrayList<Menu>();
		for(int i = 0; i < allMenus.size(); i++){
			if(this.getPropertyToCompare(allMenus.get(i)) == this.getSearchCriteria()){
				menuSearchResult.add(allMenus.get(i));
			}
		}
		return menuSearchResult;
	}

	public Object getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(Object criteria) {
		this.searchCriteria = criteria;
	}

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		serviceManager = serviceManager;
	}
	
	public abstract Object getPropertyToCompare(Menu menu);
	
}