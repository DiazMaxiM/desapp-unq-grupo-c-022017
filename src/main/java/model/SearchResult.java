package model;

public class SearchResult {

	private String menuName;
	private String menuDescription;
	private Price menuPrice;
	private Integer firstMinimumNumberOfMenusToBuy;
	private Price firstminimumPriceOfMenusToBuy;
	private Integer secondMinimumNumberOfMenusToBuy;
	private Price secondMinimumPriceOfMenusToBuy;
	private Address serviceAddress;
	private String serviceName;

	public SearchResult(Menu menu) {
		this.menuName = menu.getMenuName();
		this.menuDescription = menu.getMenuDescription();
		this.menuPrice = menu.getMenuPrice();
		this.firstMinimumNumberOfMenusToBuy = menu.getFirstMinimumNumberOfMenusToBuy();
		this.firstminimumPriceOfMenusToBuy = menu.getFirstminimumPriceOfMenusToBuy();
		this.secondMinimumNumberOfMenusToBuy = menu.getSecondMinimumNumberOfMenusToBuy();
		this.secondMinimumPriceOfMenusToBuy = menu.getSecondMinimumPriceOfMenusToBuy();
		this.serviceAddress = menu.getService().getServiceAddress();
		this.serviceName = menu.getService().getServiceName();
		// reputación del vendedor
		// cantidad restando para llegar al mínimo de los próximos 10 días
	}

}
