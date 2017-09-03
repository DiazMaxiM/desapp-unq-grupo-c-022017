package exception;

import org.omg.CORBA.UserException;

public class InvalidCountryCodeException extends UserException {

	private static final long serialVersionUID = 8092287658498487903L;

	public InvalidCountryCodeException(String message) {
		super(message);
	}

}
