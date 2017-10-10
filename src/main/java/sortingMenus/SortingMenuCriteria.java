package sortingMenus;

import java.util.ArrayList;

import model.Menu;
import model.MenuManager;

public abstract class SortingMenuCriteria {

	private MenuManager menuManager;

	public MenuManager getMenuManager() {
		return menuManager;
	}

	public void setMenuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public abstract ArrayList<Menu> orderMenu();

	public abstract Object menusToOrder();
}
