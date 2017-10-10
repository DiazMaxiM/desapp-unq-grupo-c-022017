package exception;

public class BalanceInsufficient extends SystemException {

	private static final long serialVersionUID = 1L;

	public BalanceInsufficient(String message) {
		super(message);
	}
}
