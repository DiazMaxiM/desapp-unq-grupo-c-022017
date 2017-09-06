package sortingMenus;

import java.util.ArrayList;

import model.Menu;
import model.MenuManager;

public class SortingMenuByScore extends SortingMenuCriteria {

	public SortingMenuByScore(MenuManager menuManager) {
		super.setMenuManager(menuManager);
	}

	@Override
	public ArrayList<Menu> menusToOrder() {
		return null;// this.getMenuManager().getScoringManager().getMenuWithAverage();
	}

	@Override
	public ArrayList<Menu> orderMenu() {
		// TODO Auto-generated method stub
		return null;
	}
}
