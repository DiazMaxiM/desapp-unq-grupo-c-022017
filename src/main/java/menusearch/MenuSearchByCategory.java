package menusearch;

import model.Category;
import model.Menu;
import model.MenuManager;

public class MenuSearchByCategory extends MenuSearchCriteria {

	public MenuSearchByCategory(MenuManager menuManager, Category category) {
		super.setMenuManager(menuManager);
		super.setSearchCriteria(category);
	}

	@Override
	public Object getPropertyToCompare(Menu menu) {
		return menu.getMenuCategory();
	}

}