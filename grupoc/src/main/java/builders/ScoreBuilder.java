package builders;

import exception.InvalidAddressException;
import exception.InvalidAverageDeliveryTimeOfMenuException;
import exception.InvalidServiceException;
import exception.InvalidTelephoneNumberException;
import menuExceptions.InvalidDeliveryPriceException;
import menuExceptions.InvalidEndDateOfferMenuException;
import menuExceptions.InvalidFirstMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMaximumNumberOfMunusSalesPerDay;
import menuExceptions.InvalidMenuCategoryException;
import menuExceptions.InvalidMenuDeliveryPriceException;
import menuExceptions.InvalidMenuDescriptionException;
import menuExceptions.InvalidMenuNameException;
import menuExceptions.InvalidMinimumNumberOfMenusToBuyException;
import menuExceptions.InvalidMinimumPriceOfMenusToBuyException;
import menuExceptions.InvalidStartDateOfferMenuException;
import model.Menu;
import model.Score;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;

public class ScoreBuilder {
	protected Score score;

	public ScoreBuilder() throws InvalidServiceException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidStartDateOfferMenuException, InvalidMenuDeliveryPriceException, InvalidFirstMinimumNumberOfMenusToBuyException, InvalidMinimumNumberOfMenusToBuyException, InvalidMinimumPriceOfMenusToBuyException, InvalidMaximumNumberOfMunusSalesPerDay, InvalidDeliveryPriceException, InvalidEndDateOfferMenuException, InvalidAverageDeliveryTimeOfMenuException, InvalidAddressException, InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException {
		Menu menu = null;
		menu = new MenuBuilder().build();
		score = new Score(null, new ClientBuilder().build(), menu);
	}

	public Score build() {
		return score;
	}

}
