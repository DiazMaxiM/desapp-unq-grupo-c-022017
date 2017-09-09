package model;

import java.util.List;

import org.joda.time.DateTime;

import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidServiceException;
import menuExceptions.InvalidDeliveryPriceException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidMaximumNumberOfMunusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidStartDateOfferMenuException;
import validation.MenuValidation;

public class Menu {
	private String menuName;
	private String menuDescription;
	private Category menuCategory;
	private Price menuDeliveryPrice;
	private DateTime startDateOfferMenu;
	private DateTime endDateOfferMenu;
	private List<TimeZone> deliveryTimesMenus;
	private Integer averageDeliveryTimeOfMenu;
	private Price menuPrice;
	private Integer firstMinimumNumberOfMenusToBuy;
	private Price firstminimumPriceOfMenusToBuy;
	private Integer secondMinimumNumberOfMenusToBuy;
	private Price secondMinimumPriceOfMenusToBuy;
	private Integer maximumNumberOfMenusSalesPerDay;
	private Integer numberOfMenuSale = 0;
	private Service service;
	private TypeStatusMenu status = TypeStatusMenu.ENABLED;
	private MenuValidation validator = new MenuValidation();

	public Menu(String menuName, String menuDescription, Category menuCategory, Price menuDeliveryPrice,
			DateTime startDateOfferMenu, DateTime endDateOfferMenu, List<TimeZone> deliveryTimesMenus,
			Integer averageDeliveryTimeOfMenu, Price menuPrice, Integer firstMinimumNumberOfMenusToBuy,
			Price firstminimumPriceOfMenusToBuy, Integer secondMinimumNumberOfMenusToBuy,
			Price secondMinimumPriceOfMenusToBuy, Integer maximumNumberOfMunusSalesPerDay, Service service)
			throws InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException,
			InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidAverageDeliveryTimeOfMenuException, InvalidServiceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMunusSalesPerDay {

		if (validator.isAValidMenu(menuName, menuDescription, menuCategory, menuDeliveryPrice, startDateOfferMenu,
				endDateOfferMenu, averageDeliveryTimeOfMenu, firstMinimumNumberOfMenusToBuy,
				firstminimumPriceOfMenusToBuy, secondMinimumNumberOfMenusToBuy, secondMinimumPriceOfMenusToBuy,
				maximumNumberOfMunusSalesPerDay, service)) {

			createMenu(menuName, menuDescription, menuCategory, menuDeliveryPrice, startDateOfferMenu, endDateOfferMenu,
					deliveryTimesMenus, averageDeliveryTimeOfMenu, menuPrice, firstMinimumNumberOfMenusToBuy,
					firstminimumPriceOfMenusToBuy, secondMinimumNumberOfMenusToBuy, secondMinimumPriceOfMenusToBuy,
					maximumNumberOfMunusSalesPerDay, service);
		}
	}

	private void createMenu(String menuName, String menuDescription, Category menuCategory, Price menuDeliveryPrice,
			DateTime startDateOfferMenu, DateTime endDateOfferMenu, List<TimeZone> deliveryTimesMenus,
			Integer averageDeliveryTimeOfMenu, Price menuPrice, Integer firstMinimumNumberOfMenusToBuy,
			Price firstminimumPriceOfMenusToBuy, Integer secondMinimumNumberOfMenusToBuy,
			Price secondMinimumPriceOfMenusToBuy, Integer maximumNumberOfMunusSalesPerDay, Service service) {

		setMenuName(menuName);
		setMenuDescription(menuDescription);
		setMenuCategory(menuCategory);
		setMenuDeliveryPrice(menuDeliveryPrice);
		setStartDateOfferMenu(startDateOfferMenu);
		setEndDateOfferMenu(endDateOfferMenu);
		setDeliveryTimesMenus(deliveryTimesMenus);
		setAverageDeliveryTimeOfMenu(averageDeliveryTimeOfMenu);
		setMenuPrice(menuPrice);
		setFirstMinimumNumberOfMenusToBuy(firstMinimumNumberOfMenusToBuy);
		setFirstminimumPriceOfMenusToBuy(firstminimumPriceOfMenusToBuy);
		setSecondMinimumNumberOfMenusToBuy(secondMinimumNumberOfMenusToBuy);
		setSecondMinimumPriceOfMenusToBuy(secondMinimumPriceOfMenusToBuy);
		setMaximumNumberOfMenusSalesPerDay(maximumNumberOfMunusSalesPerDay);
		setService(service);

	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public Category getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(Category menuCategory) {
		this.menuCategory = menuCategory;
	}

	public Price getMenuDeliveryPrice() {
		return menuDeliveryPrice;
	}

	public void setMenuDeliveryPrice(Price menuDeliveryPrice) {
		this.menuDeliveryPrice = menuDeliveryPrice;
	}

	public DateTime getStartDateOfferMenu() {
		return startDateOfferMenu;
	}

	public void setStartDateOfferMenu(DateTime startDateOfferMenu) {

		this.startDateOfferMenu = startDateOfferMenu;
	}

	public DateTime getEndDateOfferMenu() {
		return endDateOfferMenu;
	}

	public void setEndDateOfferMenu(DateTime endDateOfferMenu) {
		this.endDateOfferMenu = endDateOfferMenu;
	}

	public List<TimeZone> getDeliveryTimesMenus() {
		return deliveryTimesMenus;
	}

	public void setDeliveryTimesMenus(List<TimeZone> deliveryTimesMenus) {
		this.deliveryTimesMenus = deliveryTimesMenus;
	}

	public Integer getAverageDeliveryTimeOfMenu() {
		return averageDeliveryTimeOfMenu;
	}

	public void setAverageDeliveryTimeOfMenu(Integer averageDeliveryTimeOfMenu) {
		this.averageDeliveryTimeOfMenu = averageDeliveryTimeOfMenu;
	}

	public Price getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(Price menuPrice) {
		this.menuPrice = menuPrice;
	}

	public Integer getFirstMinimumNumberOfMenusToBuy() {
		return firstMinimumNumberOfMenusToBuy;
	}

	public void setFirstMinimumNumberOfMenusToBuy(Integer firstMinimumNumberOfMenusToBuy) {
		this.firstMinimumNumberOfMenusToBuy = firstMinimumNumberOfMenusToBuy;
	}

	public Price getFirstminimumPriceOfMenusToBuy() {
		return firstminimumPriceOfMenusToBuy;
	}

	public void setFirstminimumPriceOfMenusToBuy(Price firstminimumPriceOfMenusToBuy) {
		this.firstminimumPriceOfMenusToBuy = firstminimumPriceOfMenusToBuy;
	}

	public Integer getSecondMinimumNumberOfMenusToBuy() {
		return secondMinimumNumberOfMenusToBuy;
	}

	public void setSecondMinimumNumberOfMenusToBuy(Integer secondMinimumNumberOfMenusToBuy) {
		this.secondMinimumNumberOfMenusToBuy = secondMinimumNumberOfMenusToBuy;
	}

	public Price getSecondMinimumPriceOfMenusToBuy() {
		return secondMinimumPriceOfMenusToBuy;
	}

	public void setSecondMinimumPriceOfMenusToBuy(Price secondMinimumPriceOfMenusToBuy) {
		this.secondMinimumPriceOfMenusToBuy = secondMinimumPriceOfMenusToBuy;
	}

	public Integer getMaximumNumberOfMenusSalesPerDay() {
		return maximumNumberOfMenusSalesPerDay;
	}

	public void setMaximumNumberOfMenusSalesPerDay(Integer maximumNumberOfMunusSalesPerDay) {
		this.maximumNumberOfMenusSalesPerDay = maximumNumberOfMunusSalesPerDay;
	}

	public Integer getNumberOfMenuSale() {
		return numberOfMenuSale;
	}

	public void setNumberOfMenuSale(Integer numberOfMenuSale) {
		this.numberOfMenuSale = numberOfMenuSale;
	}

	public void increaseMenuSale(Integer numberOfMenusToAdd) {
		this.numberOfMenuSale = this.numberOfMenuSale + numberOfMenusToAdd;

	}

	public void disabled() {
		this.setStatus(TypeStatusMenu.DISABLED);
	}

	public TypeStatusMenu getStatus() {
		return status;
	}

	public void setStatus(TypeStatusMenu status) {
		this.status = status;
	}

}
