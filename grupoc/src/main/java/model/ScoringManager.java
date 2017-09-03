package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	public List<Provider> providerWith20ScoresAndAverageLess2() {
		Map<Provider, Long> map = scoresList.stream()
				.collect(Collectors.groupingBy(s -> s.getProvider(), Collectors.counting()));

		List<Provider> list = map.entrySet().stream().filter(m -> m.getValue() >= 20).map(Map.Entry::getKey)
				.collect(Collectors.toList());

		return list.stream().filter(provider -> averageScoresForProvider(provider) <= 2).collect(Collectors.toList());
	}

}
