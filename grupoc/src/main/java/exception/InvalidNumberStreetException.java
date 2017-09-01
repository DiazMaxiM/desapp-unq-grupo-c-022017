package exception;

import org.omg.CORBA.UserException;

public class InvalidNumberStreetException extends UserException {

	private static final long serialVersionUID = 4174085320665029046L;

	public InvalidNumberStreetException(String message) {
		super(message);
	}

}
