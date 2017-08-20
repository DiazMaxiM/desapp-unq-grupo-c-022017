package menusearch;

import java.util.ArrayList;
import model.Menu;
import model.ServiceManager;

public abstract class MenuSearchCriteria {
	
	private ServiceManager serviceManager;
	private Object criteria;
				
	public  ArrayList<Menu> menuSearch(){
		ArrayList<Menu> menus = this.getServiceManager().getAllMenus();
		ArrayList<Menu> result = new ArrayList<Menu>();
		for(int i = 0; i < menus.size(); i++){
			if(menus.get(i).getMenuCategory() == this.getCriteria()){
				result.add(menus.get(i));
			}
		}
		return result;
	}

	public Object getCriteria() {
		return criteria;
	}

	public void setCriteria(Object criteria) {
		this.criteria = criteria;
	}

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

}
