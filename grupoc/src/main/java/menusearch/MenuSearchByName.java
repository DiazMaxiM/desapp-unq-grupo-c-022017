package menusearch;

import model.Menu;

public class MenuSearchByName extends MenuSearchCriteria{
		
	public MenuSearchByName(String name){
		super.setSearchCriteria(name);
	}

	@Override
	public Object getPropertyToCompare(Menu menu) {
		return menu.getMenuName();
	}

}