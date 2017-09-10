package exception;

public class BalanceInsufficient extends Exception {

	private static final long serialVersionUID = 1L;

	public BalanceInsufficient(String message) {
		super(message);
	}
}
