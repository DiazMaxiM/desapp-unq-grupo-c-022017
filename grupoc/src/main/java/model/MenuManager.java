package model;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import sortingMenus.SortingMenuCriteria;

public class MenuManager {
	private ArrayList<Menu> menusOffered;
	private ScoringManager scoringManager;

	public MenuManager() {
		this.menusOffered = new ArrayList<>();
	}

	public ArrayList<Menu> getAllMenusOffered() {
		checkCurrentMenusOffered();
		return getMenusCurrents();
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

	public ArrayList<Menu> orderMenus(SortingMenuCriteria sortingCriteria) {
		return sortingCriteria.orderMenu();
	}

	public ScoringManager getScoringManager() {
		return scoringManager;
	}

	public void setScoringManager(ScoringManager scoringManager) {
		this.scoringManager = scoringManager;
	}
    
    private void checkCurrentMenusOffered() {
		this.menusOffered.forEach(menu -> checkCurrent(menu));
		
	}

	private void checkCurrent(Menu menu) {
		LocalDate today = new DateTime().toLocalDate();
		if(menu.getEndDateOfferMenu().toLocalDate().isBefore(today)){
		    menu.disabled();		
		}
	}
	
	private ArrayList<Menu> getMenusCurrents() {
		ArrayList<Menu> menusCurrents = new ArrayList<Menu>();
		for (Menu menu : this.menusOffered) {
			if (menu.getStatus().equals(TypeStatusMenu.ENABLED)){
				menusCurrents.add(menu);
			}
		}
		return menusCurrents;
	}

}
