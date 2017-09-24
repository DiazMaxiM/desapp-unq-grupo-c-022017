package services;

public class GeneralService {

	public UserService userService;
	

	public UserService getUserService() {
		return userService;
	}


	public void seUserService(final UserService userService) {
		this.userService = userService;
	}

}
