package exception;

import org.omg.CORBA.UserException;

public class BalanceInsufficient extends UserException {

	private static final long serialVersionUID = 1L;

	public BalanceInsufficient(String message) {
		super(message);
	}
}
