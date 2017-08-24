package builder;

import model.Category;
import model.Menu;
import model.Service;

public class MenuBuilder {
	
	public static MenuBuilder aMenu() {
		return new MenuBuilder();
	}
	
	private String menuName = "Menu name";
    private String menuDescription = "Menu description";
    private Category menuCategory = Category.BURGER;
    private Service service = new Service(); 

    public Menu build() {
    	Menu menu = new Menu(menuName, menuDescription, menuCategory, service);
    	return menu;
    }
}
