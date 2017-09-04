package sortingMenus;

import model.Menu;
import model.MenuManager;

public class SortingMenuByPrice extends SortingMenuCriteria {

	public SortingMenuByPrice(MenuManager menuManager) {
		super.setMenuManager(menuManager);
	}

	@Override
	public Object getPropertyToOrder(Menu menu) {
		return menu.getMenuPrice();
	}

}
