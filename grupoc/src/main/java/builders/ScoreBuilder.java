package builders;

import builder.MenuBuilder;
import exception.InvalidDeliveryPriceException;
import exception.InvalidEndDateOfferMenuException;
import model.Menu;
import model.Score;

public class ScoreBuilder {
	protected Score score;

	public ScoreBuilder() {
		Menu menu = null;
		try {
			try {
				menu = new MenuBuilder().build();
			} catch (InvalidDeliveryPriceException | InvalidEndDateOfferMenuException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
		}
		score = new Score(null, new ClientBuilder().build(), menu);
	}

	public Score build() {
		return score;
	}

}
