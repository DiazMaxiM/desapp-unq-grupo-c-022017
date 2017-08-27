package builder;

import builders.ServiceBuilder;
import exception.InvalidServiceException;
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
    private Service service = this.getService();
    
    public Menu build() {
    	Menu menu = new Menu(menuName, menuDescription, menuCategory, service);
    	return menu;
    }
    
    public Service getService(){
    	try {
			return new ServiceBuilder()
			        .build();
		} catch (InvalidServiceException e) {
			e.printStackTrace();
		}
    	return null; 
    }
}
