package exception;

import org.omg.CORBA.UserException;

public class InvalidValueScoreException extends UserException {
	private static final long serialVersionUID = 1L;

	public InvalidValueScoreException(String message) {
		super(message);
	}

}