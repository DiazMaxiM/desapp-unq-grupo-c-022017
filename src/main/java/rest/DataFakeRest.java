/**
 *
 */
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import model.Locality;
import services.MenuService;
import services.ProviderService;
import services.UserService;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

@Path("/")
public class DataFakeRest {

	public static final int NUMBER_OF_POST = 1;
	private MenuService menuService;
	private ProviderService providerService;
	private UserService userService;

	@GET
	@Path("/load")
	@Produces("application/json")
	public Response load() {

		try {
			userService.newUser("password", "Maximiliano", "Diaz", "12345678", "diazmaxi@gmail.com", "54", "011",
					"43511464", "AVELLANEDA", "BOGOTA", "4040", "1", "1", "1");
			providerService.newProvider("password", "Rosali", "Zaracho", "87654321", "zaracho.rosali@gmail.com", "54",
					"011", "43511464", "FLORENCIOVARELA", "BOGOTA", "4040", "1", "1", "1");
		} catch (NumberFormatException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidAddressException | InvalidTelephoneNumberException
				| InvalidMapPositionException | InvalidLengthMapPositionException | InvalidLatitudeMapPositionException
				| InvalidNumberStreetException | InvalidStreetAddressException | InvalidLocalityAddressException
				| InvalidCuitException | InvalidFirstNameException | InvalidLastNameException
				| InvalidEmailAddressException e) {

		}

		return Response.ok(Locality.values()).build();
	}

	public void setMenuService(final MenuService menuService) {
		this.menuService = menuService;
	}

	public void setProviderService(final ProviderService providerService) {
		this.providerService = providerService;
	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}
}
