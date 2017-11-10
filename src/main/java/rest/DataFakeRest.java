/**
 *
 */
package rest;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;

import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidMaximumNumberOfMenusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidPricesException;
import menuExceptions.InvalidStartDateOfferMenuException;
import model.Address;
import model.Category;
import model.Locality;
import model.MapPosition;
import model.Menu;
import model.Money;
import model.Price;
import model.Provider;
import model.Service;
import model.Symbol;
import model.Telephone;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import services.MenuService;
import services.ProviderService;
import services.UserService;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
import validation.InvalidMenuPriceException;

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
			Provider provider = providerService.newProvider("password", "Rosali", "Zaracho", "87654321",
					"zaracho.rosali@gmail.com", "54", "011", "43511464", "FLORENCIOVARELA", "BOGOTA", "4040", "1", "1",
					"1");
			Service service = new Service("Mi Negocio", "Logo",
					new Address(Locality.BERAZATEGUI, "CALLE 14", "1000", "1", new MapPosition(1.0, 1.0)),
					"Mi Descripcion", "www.ventas.com.ar", "mail@ventas.com.ar", new Telephone("54", "011", "44444444"),
					new HashMap(), new ArrayList());
			provider.addNewService(service);

			Menu menu = new Menu("Papas Fritas", "Riquisimo", Category.BURGER, new Price(new Money(Symbol.ARG), 10.0),
					new DateTime().now(), new DateTime().plusDays(1), new ArrayList(), null,
					new Price(new Money(Symbol.ARG), 2.0), 1, new Price(new Money(Symbol.ARG), 5.0), 5,
					new Price(new Money(Symbol.ARG), 1.0), null, service);
		} catch (NumberFormatException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidAddressException | InvalidTelephoneNumberException
				| InvalidMapPositionException | InvalidLengthMapPositionException | InvalidLatitudeMapPositionException
				| InvalidNumberStreetException | InvalidStreetAddressException | InvalidLocalityAddressException
				| InvalidCuitException | InvalidFirstNameException | InvalidLastNameException
				| InvalidEmailAddressException | InvalidServiceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidAverageDeliveryTimeOfMenuException
				| InvalidMenuNameException | InvalidMenuDescriptionException | InvalidMenuCategoryException
				| InvalidStartDateOfferMenuException | InvalidMenuDeliveryPriceException
				| InvalidMinimumNumberOfMenusToBuyException | InvalidMinimumPriceOfMenusToBuyException
				| InvalidMaximumNumberOfMenusSalesPerDay | InvalidPricesException | InvalidMenuPriceException
				| InvalidEndDateOfferMenuException e) {

		}

		return Response.ok().build();
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
