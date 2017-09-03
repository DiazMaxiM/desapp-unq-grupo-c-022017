package model;

import java.util.List;

public class ProviderProcessor extends Thread {

	private ScoringManager scoringManager;

	public ProviderProcessor(ScoringManager scoringManager) {
		this.scoringManager = scoringManager;
	}

	public void run() {
		List<Provider> providerForDelete = this.scoringManager.providerWith20ScoresAndAverageLess2();
		disabledProviders(providerForDelete);
	}

	private void disabledProviders(List<Provider> providers) {
		providers.stream().forEach(provider -> provider.disabled());
	}

}
