package exception;

import org.omg.CORBA.UserException;

public class InvalidLatitudeMapPositionException extends UserException {

	private static final long serialVersionUID = 8681915118113442559L;

	public InvalidLatitudeMapPositionException(String message) {
		super(message);
	}

}
