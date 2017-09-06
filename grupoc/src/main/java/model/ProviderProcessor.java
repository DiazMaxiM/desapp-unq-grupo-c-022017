package model;

import java.util.List;

public class ProviderProcessor extends Thread {

	private ScoringManager scoringManager;
	private Mail mail;

	public ProviderProcessor(ScoringManager scoringManager, Mail mail) {
		this.mail = mail;
		this.scoringManager = scoringManager;
	}

	public void run() {
		List<Menu> menuForDelete = this.scoringManager.menuWith20ScoresAndAverageLess2();
		disabledMenu(menuForDelete);
		// sendMailsForDisabled(menuForDelete);
	}

	// private void sendMailsForDisabled(List<Menu> menu) {
	// menu.stream().forEach(menu -> {
	// try {
	// mail.sendMailDisabledProvider(menu.getEmail());
	// } catch (Exception e) {
	// // TODO: preguntar al profe que pasa si sale un error al enviar
	// // un mail;
	// }
	// });
	//
	// }

	private void disabledMenu(List<Menu> menu) {
		menu.stream().forEach(m -> m.disabled());
	}

}
