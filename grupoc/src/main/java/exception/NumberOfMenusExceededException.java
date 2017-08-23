package exception;

import org.omg.CORBA.UserException;

public class NumberOfMenusExceededException extends UserException {

	private static final long serialVersionUID = 1L;

	public NumberOfMenusExceededException(String message) {
		super(message);
	}
}
