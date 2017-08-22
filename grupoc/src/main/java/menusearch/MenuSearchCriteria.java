package menusearch;

import java.util.ArrayList;
import exception.NoMenusFoundException;
import model.Menu;
import model.ServiceManager;

public abstract class MenuSearchCriteria {
	
	private ServiceManager serviceManager;
	private Object searchCriteria;

	public ArrayList<Menu> menuSearch() throws NoMenusFoundException{
		ArrayList<Menu> allMenus = this.getServiceManager().getAllMenus();
		ArrayList<Menu> menuSearchResult = new ArrayList<Menu>();
		for(int i = 0; i < allMenus.size(); i++){
			if(isTheMenuSearchInIndex(allMenus, i)){
				menuSearchResult.add(allMenus.get(i));
			}
		}
		
		if(!this.areElementsAsAResult(menuSearchResult)) {
			throw new NoMenusFoundException("No se han encontrado resultados para su búsqueda");
		}
		return menuSearchResult;
	}
	
	public boolean isTheMenuSearchInIndex(ArrayList<Menu> menus, int index) {
		return this.getPropertyToCompare(menus.get(index)) == this.getSearchCriteria();
	}
	
	public boolean areElementsAsAResult(ArrayList<Menu> resultSearch) {
		return !resultSearch.isEmpty();
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
		this.serviceManager = serviceManager;
	}
	
	public abstract Object getPropertyToCompare(Menu menu);
	
}