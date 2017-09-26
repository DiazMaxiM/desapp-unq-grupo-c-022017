package services;

public class GeneralService {

	public UserService userService;
	public TimeZoneService timeZoneService;
	public TransactionService transactionService;
	public MoneyService moneyService;
	public AccountService accountService;
	public TelephoneService telephoneService;
	public MapPositionService mapPositionService;

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