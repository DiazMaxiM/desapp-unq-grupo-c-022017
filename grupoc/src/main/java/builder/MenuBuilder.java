package builder;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import builders.ServiceBuilder;
import exception.InvalidMenuCategoryException;
import exception.InvalidMenuDescriptionException;
import exception.InvalidMenuException;
import exception.InvalidMenuNameException;
import exception.InvalidServiceException;
import model.Category;
import model.Menu;
import model.Service;

public class MenuBuilder {
	
	private String menuName = "MenuName";
    private String menuDescription = "MenuDescription12345678910";
    private Category menuCategory = Category.BURGER;
    private Double menuDeliveryPrice = (double) 15; 
    private DateTime startDateOfferMenu= new DateTime();
    private DateTime endDateOfferMenu = new DateTime();
    private List<String> deliveryTimesMenus= this.getDeliveryTimesMenus();
    private Integer averageDeliveryTimeOfMenu= 30;
    private Double menuPrice = (double) 40;
    private Integer firstMinimumNumberOfMenusToBuy = 10;
    private Double firstminimumPriceOfMenusToBuy = (double) 40;
    private Integer secondMinimumNumberOfMenusToBuy = 50;
    private Double secondMinimumPriceOfMenusToBuy = (double) 25;
    private Integer maximumNumberOfMunusSalesPerDay= 100;
    private Service service = this.getService();
    
    public Menu build() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException {
			return new Menu(menuName, menuDescription, menuCategory, firstminimumPriceOfMenusToBuy, endDateOfferMenu, endDateOfferMenu, deliveryTimesMenus, averageDeliveryTimeOfMenu, firstminimumPriceOfMenusToBuy, averageDeliveryTimeOfMenu, firstminimumPriceOfMenusToBuy, averageDeliveryTimeOfMenu, firstminimumPriceOfMenusToBuy, averageDeliveryTimeOfMenu, service);
			
    }
    
    private List<String> getDeliveryTimesMenus() {	
		return new ArrayList<>();
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

	public MenuBuilder withMenuName(String menuName) {
		this.menuName= menuName;
		return this;
	}

	public MenuBuilder withMenuDescription(String menuDescription) {
		this.menuDescription= menuDescription;
		return this;
	}

	public MenuBuilder withMenuCategory(Category menuCategory) {
		this.menuCategory=menuCategory;
		return this;
	}

	public MenuBuilder withMenuDeliveryPrice(Double menuDelieryPrice) {
		this.menuDeliveryPrice=menuDelieryPrice;
		return this;
	}


}
