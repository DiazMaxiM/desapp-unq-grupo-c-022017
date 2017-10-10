package menusearch;

import model.Locality;
import model.Menu;
import model.MenuManager;

public class MenuSearchByLocality extends MenuSearchCriteria {

	public MenuSearchByLocality(MenuManager menuManager, Locality locality) {
		super.setMenuManager(menuManager);
		super.setSearchCriteria(locality);
	}

	@Override
	public Object getPropertyToCompare(Menu menu) {
		return menu.getService().serviceLocality();
	}

}
