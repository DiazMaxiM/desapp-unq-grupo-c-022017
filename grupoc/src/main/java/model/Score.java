package model;

import exception.InvalidValueScoreException;

public class Score {
	private Provider provider;
	private User client;
	private Integer valueScore = 0;
	private Menu menu;
	private TypeStatusTransaction status = TypeStatusTransaction.PENDING;

	public Score(Provider provider, User client, Menu menu) {
		this.provider = provider;
		this.client = client;
		this.menu = menu;
	}

	public Boolean isPending() {
		return this.status.equals(TypeStatusTransaction.PENDING);
	}

	public Boolean isClient(User client) {
		return this.client.equals(client);
	}

	public Boolean isProvider(Provider provider) {
		return this.provider.equals(provider);
	}

	public Boolean isFinish() {
		return this.status.equals(TypeStatusTransaction.FINISH);
	}

	public Integer getValue() {
		return valueScore;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public void setScore(Integer valueScore) throws InvalidValueScoreException {
		if (valueScore >= 1 && valueScore <= 5) {
			this.valueScore = valueScore;
			this.status = TypeStatusTransaction.FINISH;
		} else {
			throw new InvalidValueScoreException("puntuacion incorrecta");
		}

	}

}
