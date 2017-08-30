package model;

import java.util.ArrayList;
import java.util.List;

public class ScoringManager {
	List<Score> scoresList = new ArrayList<Score>();

	public void addScore(Score score) {
		scoresList.add(score);
	}

	public Boolean hasPendingScoreForClient(Client client) {

		Long countPending = scoresList.stream().filter(score -> score.isClient(client) && score.isPending()).count();

		return countPending > 0;

	}

	public Double averageScoresForProvider(Provider provider) {
		return scoresList.stream().filter(score -> score.isProvider(provider) && score.isFinish())
				.mapToDouble(score -> score.getValue()).average().getAsDouble();
	}

}
