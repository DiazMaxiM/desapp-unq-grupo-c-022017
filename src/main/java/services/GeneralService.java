package services;

public class GeneralService {

	public UserService userService;
	public TimeZoneService timeZoneService;
	public TransactionService transactionService;
	public MoneyService moneyService;
	public AccountService accountService;
	public TelephoneService telephoneService;
	public MapPositionService mapPositionService;
	public AddressService addressService;
	public MenuService menuService;
	public PriceService priceService;
	public ProviderService providerService;
	public ServiceService serviceService;
	public OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public ServiceService getServiceService() {
		return serviceService;
	}

	public void setServiceService(ServiceService serviceService) {
		this.serviceService = serviceService;
	}

	public ProviderService getProviderService() {
		return providerService;
	}

	public void setProviderService(ProviderService providerService) {
		this.providerService = providerService;
	}

	public PriceService getPriceService() {
		return priceService;
	}

	public void setPriceService(PriceService priceService) {
		this.priceService = priceService;
	}

	//
	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	//

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	//

	public MoneyService getMoneyService() {
		return this.moneyService;
	}

	public void setMoneyService(MoneyService moneyService) {
		this.moneyService = moneyService;
	}

	public AccountService getAccountService() {
		return this.accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public TransactionService getTransactionService() {
		return this.transactionService;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	public TimeZoneService getTimeZoneService() {
		return timeZoneService;
	}

	public void setTimeZoneService(TimeZoneService timeZoneService) {
		this.timeZoneService = timeZoneService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public TelephoneService getTelephoneService() {
		return telephoneService;
	}

	public void setTelephoneService(TelephoneService telephoneService) {
		this.telephoneService = telephoneService;
	}

	public MapPositionService getMapPositionService() {
		return mapPositionService;
	}

	public void setMapPositionService(MapPositionService mapPositionService) {
		this.mapPositionService = mapPositionService;
	}

}