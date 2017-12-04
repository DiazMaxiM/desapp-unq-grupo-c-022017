package model;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoringManager {
	List<Score> scoresList = new ArrayList<Score>();

	public List<Score> getScoresList() {
		return scoresList;
	}

	public void setScoresList(List<Score> scoresList) {
		this.scoresList = scoresList;
	}

	public void addScore(Score score) {
		scoresList.add(score);
	} 

	public Boolean hasPendingScoreForClient(User client) {

		Long countPending = scoresList.stream().filter(score -> score.isClient(client) && score.isPending()).count();

		return countPending > 0;

	}

	public Double averageScoresForMenu(Menu menu) {
		return scoresList.stream().filter(score -> score.isMenu(menu) && score.isFinish())
				.mapToDouble(score -> score.getValue()).average().getAsDouble();
	}

	public List<Menu> menuWith20ScoresAndAverageLess2() {
		Map<Menu, Long> map = scoresList.stream()
				.collect(Collectors.groupingBy(s -> s.getMenu(), Collectors.counting()));

		List<Menu> list = map.entrySet().stream().filter(m -> m.getValue() >= 20).map(Map.Entry::getKey)
				.collect(Collectors.toList());

		return list.stream().filter(menu -> averageScoresForMenu(menu) <= 2).collect(Collectors.toList());
	}

	public Map<Menu, Double> getMenusWithAverage() {
		Map<Menu, DoubleSummaryStatistics> data = scoresList.stream()
				.collect(Collectors.groupingBy(Score::getMenu, Collectors.summarizingDouble(Score::getValue)));

		return data.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().getAverage()));

	}

}
