package menusearch;

import model.Category;

public class MenuSearchByCategory extends MenuSearchCriteria {
	
	public MenuSearchByCategory(Category category){
		super.setCriteria(category);
	}
}