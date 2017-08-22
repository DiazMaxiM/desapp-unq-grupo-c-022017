package model;

import java.util.Date;
import java.util.List;

public class Menu {
    private String menuName;
    private String menuDescription;
    private Category menuCategory;
    private Float menuDeliveryPrice;
    private Date startDateOfferMenu;
    private Date endDateOfferMenu;
    private List<Double> deliveryTimesMenus;
    private Float averageDeliveryTimeOfMenu;
    private Float menuPrice;
    private Integer firstMinimumNumberOfMenusToBuy;
    private Float firstminimumPriceOfMenusToBuy;
    private Integer secondMinimumNumberOfMenusToBuy;
    private Float secondMinimumPriceOfMenusToBuy;
    private Float maximumNumberOfMunusSalesPerDay;
    private Service service;
    
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
	public Float getMenuDeliveryPrice() {
		return menuDeliveryPrice;
	}
	public void setMenuDeliveryPrice(Float menuDeliveryPrice) {
		this.menuDeliveryPrice = menuDeliveryPrice;
	}
	public Date getStartDateOfferMenu() {
		return startDateOfferMenu;
	}
	public void setStartDateOfferMenu(Date startDateOfferMenu) {
		this.startDateOfferMenu = startDateOfferMenu;
	}
	public Date getEndDateOfferMenu() {
		return endDateOfferMenu;
	}
	public void setEndDateOfferMenu(Date endDateOfferMenu) {
		this.endDateOfferMenu = endDateOfferMenu;
	}
	public List<Double> getDeliveryTimesMenus() {
		return deliveryTimesMenus;
	}
	public void setDeliveryTimesMenus(List<Double> deliveryTimesMenus) {
		this.deliveryTimesMenus = deliveryTimesMenus;
	}
	public Float getAverageDeliveryTimeOfMenu() {
		return averageDeliveryTimeOfMenu;
	}
	public void setAverageDeliveryTimeOfMenu(Float averageDeliveryTimeOfMenu) {
		this.averageDeliveryTimeOfMenu = averageDeliveryTimeOfMenu;
	}
	public Float getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(Float menuPrice) {
		this.menuPrice = menuPrice;
	}
	public Integer getFirstMinimumNumberOfMenusToBuy() {
		return firstMinimumNumberOfMenusToBuy;
	}
	public void setFirstMinimumNumberOfMenusToBuy(Integer firstMinimumNumberOfMenusToBuy) {
		this.firstMinimumNumberOfMenusToBuy = firstMinimumNumberOfMenusToBuy;
	}
	public Float getFirstminimumPriceOfMenusToBuy() {
		return firstminimumPriceOfMenusToBuy;
	}
	public void setFirstminimumPriceOfMenusToBuy(Float firstminimumPriceOfMenusToBuy) {
		this.firstminimumPriceOfMenusToBuy = firstminimumPriceOfMenusToBuy;
	}
	public Integer getSecondMinimumNumberOfMenusToBuy() {
		return secondMinimumNumberOfMenusToBuy;
	}
	public void setSecondMinimumNumberOfMenusToBuy(Integer secondMinimumNumberOfMenusToBuy) {
		this.secondMinimumNumberOfMenusToBuy = secondMinimumNumberOfMenusToBuy;
	}
	public Float getSecondMinimumPriceOfMenusToBuy() {
		return secondMinimumPriceOfMenusToBuy;
	}
	public void setSecondMinimumPriceOfMenusToBuy(Float secondMinimumPriceOfMenusToBuy) {
		this.secondMinimumPriceOfMenusToBuy = secondMinimumPriceOfMenusToBuy;
	}
	public Float getMaximumNumberOfMunusSalesPerDay() {
		return maximumNumberOfMunusSalesPerDay;
	}
	public void setMaximumNumberOfMunusSalesPerDay(Float maximumNumberOfMunusSalesPerDay) {
		this.maximumNumberOfMunusSalesPerDay = maximumNumberOfMunusSalesPerDay;
	}
    
}
