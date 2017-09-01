package exception;

import org.omg.CORBA.UserException;

public class InvalidLengthMapPositionException extends UserException {

	private static final long serialVersionUID = 3276381329784460694L;

	public InvalidLengthMapPositionException(String message) {
		super(message);
	}

}
