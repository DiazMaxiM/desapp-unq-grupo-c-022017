package menusearch;

import model.Menu;
import model.MenuManager;

public class MenuSearchByName extends MenuSearchCriteria {

	public MenuSearchByName(MenuManager menuManager, String name) {
		super.setSearchCriteria(name);
		super.setMenuManager(menuManager);
	}

	@Override
	public Object getPropertyToCompare(Menu menu) {
		return menu.getMenuName();
	}

}