package menusearch;

import model.Category;
import model.Menu;

public class MenuSearchByCategory extends MenuSearchCriteria {
	
	public MenuSearchByCategory(Category category){
		super.setSearchCriteria(category);
	}
	
	@Override
	public Object getPropertyToCompare(Menu menu) {
		return menu.getMenuCategory();
	}

}