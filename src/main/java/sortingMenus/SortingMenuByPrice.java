package sortingMenus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Menu;
import model.MenuManager;

public class SortingMenuByPrice extends SortingMenuCriteria {

	public SortingMenuByPrice(MenuManager menuManager) {
		super.setMenuManager(menuManager);
	}

	@Override
	public ArrayList<Menu> menusToOrder() {
		return this.getMenuManager().getAllMenusOffered();
	}

	@Override
	public ArrayList<Menu> orderMenu() {
		ArrayList<Menu> allMenus = this.menusToOrder();
		Comparator<Menu> comparator = new Comparator<Menu>() {
			public int compare(Menu menuCurrent, Menu menuToCompare) {
				return menuCurrent.getMenuPrice().getValue() < menuToCompare.getMenuPrice().getValue() ? -1 : 1;
			}
		};
		Collections.sort(allMenus, comparator);
		return allMenus;
	}
}