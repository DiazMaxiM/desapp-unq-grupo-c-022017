package bootLoad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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
import model.Category;
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

@Component
public class DataLoader{
	
	public MenuService menuService;
	public ProviderService providerService;
	public UserService userService;
	
	public void initialize() {
		
		System.out.println("Start data loading");
		try {
			userService.newUser("password", "Maximiliano", "Diaz", "12345678", "diazmaxi@gmail.com", "54", "011",
					"43511464", "AVELLANEDA", "BOGOTA", "4040", "1", "1", "1");
		} catch (NumberFormatException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidAddressException | InvalidTelephoneNumberException
				| InvalidMapPositionException | InvalidLengthMapPositionException | InvalidLatitudeMapPositionException
				| InvalidNumberStreetException | InvalidStreetAddressException | InvalidLocalityAddressException
				| InvalidCuitException | InvalidFirstNameException | InvalidLastNameException
				| InvalidEmailAddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MapPosition mapPosition = null;
		try {
			mapPosition = new MapPosition(new Double(1), new Double(1));
		} catch (InvalidLengthMapPositionException | InvalidLatitudeMapPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Telephone telephone = null;
		try {
			telephone = new Telephone("54", "011", "43511111");
		} catch (InvalidLocalNumberException | InvalidAreaCodeException | InvalidCountryCodeException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}

		Address address = null;
		try {
			address = new Address(Locality.ALMIRANTEBROWN, "street", "numberStreet", "floor", mapPosition);
		} catch (InvalidNumberStreetException | InvalidStreetAddressException | InvalidLocalityAddressException
				| InvalidMapPositionException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		Provider provider = null;
		try {
			provider = new Provider("87654321", "Rosali", "Zaracho", "zaracho.rosali@gmail.com", telephone,
					address, "password");
		} catch (InvalidAddressException | InvalidTelephoneNumberException | InvalidMapPositionException
				| InvalidCuitException | InvalidFirstNameException | InvalidLastNameException
				| InvalidEmailAddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HashMap<Integer, List<TimeZone>> serviceWorkingHours = new HashMap<>();
		List<TimeZone> workingHours = new ArrayList<>();
		TimeZone lateShift = null;
		try {
			lateShift = new TimeZone("17:00", "22:30");
		} catch (InvalidTimeZoneException | InvalidFormatTimeZoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workingHours.add(lateShift);
		serviceWorkingHours.put(1, workingHours);
		serviceWorkingHours.put(2, workingHours);
		serviceWorkingHours.put(3, workingHours);
		serviceWorkingHours.put(4, workingHours);
		serviceWorkingHours.put(5, workingHours);
		serviceWorkingHours.put(6, workingHours);
		serviceWorkingHours.put(7, workingHours);

		Set<Locality> lista = new HashSet<Locality>();
		lista.add(Locality.ALMIRANTEBROWN);
		lista.add(Locality.BERAZATEGUI);

		Set<Locality> lista2 = new HashSet<Locality>();
		lista2.add(Locality.AVELLANEDA);

		Service service = null;
		try {
			service = new Service("Mi Negocio", "Logo",
					new Address(Locality.BERAZATEGUI, "CALLE 14", "1000", "1", new MapPosition(1.0, 1.0)), "Mi Descripcion",
					"www.ventas.com.ar", "mail@ventas.com.ar", new Telephone("54", "011", "44444444"), serviceWorkingHours,
					lista);
		} catch (InvalidServiceException | InvalidAddressException | InvalidTelephoneNumberException
				| InvalidMapPositionException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidServiceNameException | InvalidServiceLogoException
				| InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Service service2 = null;
		try {
			service2 = new Service("Mi Negocio 2", "Logo",
					new Address(Locality.AVELLANEDA, "CALLE 14", "1000", "1", new MapPosition(1.0, 1.0)), "Mi Descripcion",
					"www.ventas.com.ar", "mail@ventas.com.ar", new Telephone("54", "011", "44444444"), serviceWorkingHours,
					lista2);
		} catch (InvalidServiceException | InvalidAddressException | InvalidTelephoneNumberException
				| InvalidMapPositionException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidServiceNameException | InvalidServiceLogoException
				| InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			provider.addNewService(service);
		} catch (InvalidServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			provider.addNewService(service2);
		} catch (InvalidServiceException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		providerService.save(provider);

		Menu menu1 = null;
		try {
			menu1 = new MenuBuilder().withMenuService(service).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Menu menu2 = null;
		try {
			menu2 = new MenuBuilder().withMenuService(service).withMenuName("Cerveza artesanal")
					.withMenuCategory(Category.BEER).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu menu3 = null;
		try {
			menu3 = new MenuBuilder().withMenuService(service2).withMenuCategory(Category.PIZZA).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Menu menu4 = null;
		try {
			menu4 = new MenuBuilder().withMenuService(service2).withMenuCategory(Category.VEGAN).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu menu5 = null;
		try {
			menu5 = new MenuBuilder().withMenuService(service2).withMenuCategory(Category.GREEN).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu menu6 = null;
		try {
			menu6 = new MenuBuilder().withMenuService(service2).withMenuCategory(Category.EMPANADAS).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu menu7 = null;
		try {
			menu7 = new MenuBuilder().withMenuService(service2).withMenuCategory(Category.SUSHI).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu menu8 = null;
		try {
			menu8 = new MenuBuilder().withMenuService(service2).withMenuCategory(Category.PIZZA).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu menu9 = null;
		try {
			menu9 = new MenuBuilder().withMenuService(service2).withMenuCategory(Category.EMPANADAS).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu menu10 = null;
		try {
			menu10 = new MenuBuilder().withMenuService(service2).withMenuCategory(Category.GREEN).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu menu11 = null;
		try {
			menu11 = new MenuBuilder().withMenuService(service2).withMenuCategory(Category.BURGER).build();
		} catch (InvalidAverageDeliveryTimeOfMenuException | InvalidServiceException | InvalidAddressException
				| InvalidTelephoneNumberException | InvalidNumberStreetException | InvalidStreetAddressException
				| InvalidLocalityAddressException | InvalidLocalNumberException | InvalidAreaCodeException
				| InvalidCountryCodeException | InvalidTimeZoneException | InvalidLengthMapPositionException
				| InvalidLatitudeMapPositionException | InvalidMapPositionException | InvalidMenuNameException
				| InvalidMenuDescriptionException | InvalidMenuCategoryException | InvalidStartDateOfferMenuException
				| InvalidMenuDeliveryPriceException | InvalidMinimumNumberOfMenusToBuyException
				| InvalidMinimumPriceOfMenusToBuyException | InvalidMaximumNumberOfMenusSalesPerDay
				| InvalidPricesException | InvalidMenuPriceException | InvalidServiceNameException
				| InvalidServiceLogoException | InvalidServiceDescriptionException | InvalidServiceEmailException
				| InvalidServiceWorkingHoursException | InvalidFormatTimeZoneException
				| InvalidEndDateOfferMenuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		menuService.save(menu1);
		menuService.save(menu2);
		menuService.save(menu3);
		menuService.save(menu4);
		menuService.save(menu5);
		menuService.save(menu6);
		menuService.save(menu7);
		menuService.save(menu8);
		menuService.save(menu9);
		menuService.save(menu10);
		menuService.save(menu11);
	}
	
	@Autowired
	public void setMenuService(final MenuService menuService) {
		this.menuService = menuService;
	}

	@Autowired
	public void setProviderService(final ProviderService providerService) {
		this.providerService = providerService;
	}
    
	@Autowired
	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

}
