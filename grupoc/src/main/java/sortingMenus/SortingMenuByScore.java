package sortingMenus;

import model.Menu;
import model.MenuManager;

public class SortingMenuByScore extends SortingMenuCriteria {
	public SortingMenuByScore(MenuManager menuManager) {
		super.setMenuManager(menuManager);
	}

	@Override
	public Object getPropertyToOrder(Menu menu) {
		return null;
	}
}
