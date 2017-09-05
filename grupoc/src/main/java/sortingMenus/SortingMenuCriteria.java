package sortingMenus;

import model.Menu;
import model.MenuManager;

public abstract class SortingMenuCriteria {
	private MenuManager menuManager;
	private Object searchCriteria;

	public MenuManager getMenuManager() {
		return menuManager;
	}

	public void setMenuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public Object getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(Object searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public abstract Object getPropertyToOrder(Menu menu);
}
