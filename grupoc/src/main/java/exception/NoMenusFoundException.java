package exception;

import org.omg.CORBA.UserException;

public class NoMenusFoundException extends UserException {

	private static final long serialVersionUID = 1L;

	public NoMenusFoundException(String message) {
		super(message);
	}
}
