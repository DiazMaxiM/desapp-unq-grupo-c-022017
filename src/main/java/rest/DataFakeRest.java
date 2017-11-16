/**
 *
 */
package rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import builders.MenuBuilder;
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
import exception.InvalidTimeZoneException;
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
import model.Locality;
import model.MapPosition;
import model.Menu;
import model.Provider;
import model.Service;
import model.Telephone;
import model.TimeZone;
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
import validation.InvalidFormatTimeZoneException;
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
	public Response load() throws NumberFormatException, InvalidLocalNumberException, InvalidAreaCodeException,
			InvalidCountryCodeException, InvalidAddressException, InvalidTelephoneNumberException,
			InvalidMapPositionException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException,
			InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException,
			InvalidServiceException, InvalidServiceNameException, InvalidServiceLogoException,
			InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidAverageDeliveryTimeOfMenuException, InvalidMenuNameException, InvalidMenuDescriptionException,
			InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException,
			InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException,
			InvalidMaximumNumberOfMenusSalesPerDay, InvalidPricesException, InvalidMenuPriceException,
			InvalidEndDateOfferMenuException, InvalidTimeZoneException, InvalidFormatTimeZoneException {

		userService.newUser("password", "Maximiliano", "Diaz", "12345678", "diazmaxi@gmail.com", "54", "011",
				"43511464", "AVELLANEDA", "BOGOTA", "4040", "1", "1", "1");
		MapPosition mapPosition = new MapPosition(new Double(1), new Double(1));

		Telephone telephone = new Telephone("54", "011", "43511111");

		Address address = new Address(Locality.ALMIRANTEBROWN, "street", "numberStreet", "floor", mapPosition);
		Provider provider = new Provider("87654321", "Rosali", "Zaracho", "zaracho.rosali@gmail.com", telephone,
				address, "password");

		HashMap<Integer, List<TimeZone>> serviceWorkingHours = new HashMap<>();
		List<TimeZone> workingHours = new ArrayList<>();
		TimeZone lateShift = new TimeZone("17:00", "22:30");
		workingHours.add(lateShift);
		serviceWorkingHours.put(1, workingHours);
		serviceWorkingHours.put(2, workingHours);
		serviceWorkingHours.put(3, workingHours);
		serviceWorkingHours.put(4, workingHours);
		serviceWorkingHours.put(5, workingHours);
		serviceWorkingHours.put(6, workingHours);
		serviceWorkingHours.put(7, workingHours);

		List<Locality> lista = new ArrayList<Locality>();
		lista.add(Locality.ALMIRANTEBROWN);
		lista.add(Locality.BERAZATEGUI);

		Service service = new Service("Mi Negocio", "Logo",
				new Address(Locality.BERAZATEGUI, "CALLE 14", "1000", "1", new MapPosition(1.0, 1.0)), "Mi Descripcion",
				"www.ventas.com.ar", "mail@ventas.com.ar", new Telephone("54", "011", "44444444"), serviceWorkingHours,
				lista);
		provider.addNewService(service);

		providerService.save(provider);

		Menu menu = new MenuBuilder().withMenuService(service).build();

		menuService.save(menu);

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
