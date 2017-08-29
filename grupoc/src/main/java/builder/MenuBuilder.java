package builder;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import builders.ServiceBuilder;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidServiceException;
import menuExceptions.InvalidDeliveryPriceException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidFirstMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMaximumNumberOfMunusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidStartDateOfferMenuException;
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
    
    public Menu build() throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidServiceException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay {
			return new Menu(menuName, menuDescription, menuCategory, menuDeliveryPrice,startDateOfferMenu,endDateOfferMenu,deliveryTimesMenus, averageDeliveryTimeOfMenu, menuPrice,firstMinimumNumberOfMenusToBuy,firstminimumPriceOfMenusToBuy,secondMinimumNumberOfMenusToBuy,secondMinimumPriceOfMenusToBuy,maximumNumberOfMunusSalesPerDay,service);
			
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

	public MenuBuilder withStartDateOfferMenu(DateTime dateOfferMenu) {
		this.startDateOfferMenu=dateOfferMenu;
		return this;
	}

	public MenuBuilder withEndDateOfferMenu(DateTime dateOfferMenu) {
		this.endDateOfferMenu=dateOfferMenu;
		return this;
	}

	public MenuBuilder withAverageDeliveryTimeOfMenu(Integer averageDeliveryTimeOfMenu) {
		this.averageDeliveryTimeOfMenu= averageDeliveryTimeOfMenu;
		return this;
	}

	public MenuBuilder withFirstMinimumNumberOfMenusToBuy(Integer firstMinimumNumberOfMenusToBuy) {
		this.firstMinimumNumberOfMenusToBuy=firstMinimumNumberOfMenusToBuy;
		return this;
	}

	public MenuBuilder withFirstMinimumPriceOfMenusToBuy(Double firstminimumPriceOfMenusToBuy) {
		this.firstminimumPriceOfMenusToBuy=firstminimumPriceOfMenusToBuy;
		return this;
	}

	public MenuBuilder withSecondMinimumNumberOfMenusToBuy(Integer secondMinimumNumberOfMenusToBuy) {
		this.secondMinimumNumberOfMenusToBuy=secondMinimumNumberOfMenusToBuy;
		return this;
	}

	public MenuBuilder withSecondMinimumPriceOfMenusToBuy(Double secondMinimumPriceOfMenusToBuy) {
		this.secondMinimumPriceOfMenusToBuy=secondMinimumPriceOfMenusToBuy;
		return this;
	}

	public MenuBuilder withMenuService(Service service) {
		this.service=service;
		return this;
	}


}
