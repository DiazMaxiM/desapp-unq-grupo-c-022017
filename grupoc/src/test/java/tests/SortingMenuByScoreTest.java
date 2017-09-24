package tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import builders.ScoreBuilder;
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
import exception.InvalidValueScoreException;
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
import model.Menu;
import model.MenuManager;
import model.Score;
import model.ScoringManager;
import model.User;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;
import sortingMenus.SortingMenuByScore;
import validation.InvalidFormatTimeZoneException;
import validation.InvalidMenuPriceException;

public class SortingMenuByScoreTest {

	@Test
	public void test() throws InvalidServiceException, InvalidAddressException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLocalNumberException,
			InvalidAreaCodeException, InvalidCountryCodeException, InvalidMenuNameException,
			InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException,
			InvalidMenuDeliveryPriceException, InvalidMinimumNumberOfMenusToBuyException,
			InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMenusSalesPerDay,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException,
			InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException,
			InvalidTelephoneNumberException, InvalidValueScoreException, InvalidTimeZoneException,
			InvalidFormatTimeZoneException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidMapPositionException, InvalidPricesException, InvalidMenuPriceException {
		ScoringManager scoringManager = new ScoringManager();

		Menu menu = Mockito.mock(Menu.class);
		Menu menu2 = Mockito.mock(Menu.class);
		Menu menu3 = Mockito.mock(Menu.class);
		User client = Mockito.mock(User.class);

		Score score1 = new ScoreBuilder().setClient(client).setMenu(menu).build();
		score1.setScore(3);
		scoringManager.addScore(score1);

		Score score2 = new ScoreBuilder().setClient(client).setMenu(menu2).build();
		score2.setScore(4);
		scoringManager.addScore(score2);

		Score score3 = new ScoreBuilder().setClient(client).setMenu(menu3).build();
		score3.setScore(1);
		scoringManager.addScore(score3);

		MenuManager menuManager = new MenuManager();
		menuManager.setScoringManager(scoringManager);
		SortingMenuByScore sortingMenuByScore = new SortingMenuByScore(menuManager);
		ArrayList<Menu> menusOrdered = menuManager.orderMenus(sortingMenuByScore);

		assertTrue(scoringManager.getMenusWithAverage().size() == 3);
		assertEquals(3, menusOrdered.size());

		assertTrue(menusOrdered.get(0).equals(menu3));
		assertTrue(menusOrdered.get(1).equals(menu));
		assertTrue(menusOrdered.get(2).equals(menu2));
	}

}
