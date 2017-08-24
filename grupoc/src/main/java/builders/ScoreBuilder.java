package builders;

import model.Score;

public class ScoreBuilder {
	protected Score score = new Score(null, null, null);

	public Score build() {
		return score;
	}

}
