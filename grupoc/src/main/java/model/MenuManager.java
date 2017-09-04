package model;

import java.util.ArrayList;

public class MenuManager {
	private ArrayList<Menu> menusOffered;

	public MenuManager() {
		this.menusOffered = new ArrayList<>();
	}

	public ArrayList<Menu> getAllMenusOffered() {
		return menusOffered;
	}

	public void addMenu(Menu menu) {
		menusOffered.add(menu);
	}

	public void increaseNumberOfMenuSales(Menu menu, Integer numberOfMenusToOrder) {
		Menu menuOfferd = this.menusOffered.stream().filter(menuSearch -> menuSearch.equals(menu)).findFirst().get();
		menuOfferd.increaseMenuSale(numberOfMenusToOrder);
	}

	public void addMenuToMenusOffered(Menu menuToAdd) {
		this.menusOffered.add(menuToAdd);
	}

}
