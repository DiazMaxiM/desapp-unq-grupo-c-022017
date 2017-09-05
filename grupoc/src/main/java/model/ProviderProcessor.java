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
		List<Provider> providerForDelete = this.scoringManager.providerWith20ScoresAndAverageLess2();
		disabledProviders(providerForDelete);
		sendMailsForDisabled(providerForDelete);
	}

	private void sendMailsForDisabled(List<Provider> providers) {
		providers.stream().forEach(provider -> {
			try {
				mail.sendMailDisabledProvider(provider.getEmail());
			} catch (Exception e) {
				// TODO: preguntar al profe que pasa si sale un error al enviar
				// un mail;
			}
		});

	}

	private void disabledProviders(List<Provider> providers) {
		providers.stream().forEach(provider -> provider.disabled());
	}

}
