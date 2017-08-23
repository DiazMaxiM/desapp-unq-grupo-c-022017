package exception;

import org.omg.CORBA.UserException;

public class InvalidServiceException extends UserException {

	private static final long serialVersionUID = 1L;

	public InvalidServiceException(String message) {
		super(message);
	}

}
