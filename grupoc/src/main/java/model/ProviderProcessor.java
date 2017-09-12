package model;

import java.util.List;

public class ProviderProcessor extends Thread {

	private ScoringManager scoringManager;
	@SuppressWarnings("unused")
	private Mail mail;

	public ProviderProcessor(ScoringManager scoringManager, Mail mail) {
		this.mail = mail;
		this.scoringManager = scoringManager;
	}

	public void run() {
		List<Menu> menuForDelete = this.scoringManager.menuWith20ScoresAndAverageLess2();
		disabledMenu(menuForDelete);
	}

	private void disabledMenu(List<Menu> menu) {
		menu.stream().forEach(m -> m.disabled());
	}

}
