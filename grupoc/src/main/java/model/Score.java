package model;

public class Score {
	private Provider provider;
	private Client client;
	private Integer valueScore = 0;
	private Menu menu;
	private TypeStatus status = TypeStatus.PENDING;

	public Score(Provider provider, Client client, Menu menu) {
		this.provider = provider;
		this.client = client;
		this.menu = menu;
	}

	public Boolean isPending() {
		return this.status.equals(TypeStatus.PENDING);
	}

	public Boolean isClient(Client client) {
		return this.client.equals(client);
	}

	public Boolean isProvider(Provider provider) {
		return this.provider.equals(provider);
	}

	public Boolean isFinish() {
		return this.status.equals(TypeStatus.FINISH);
	}

	public Integer getValue() {
		return valueScore;
	}

}
