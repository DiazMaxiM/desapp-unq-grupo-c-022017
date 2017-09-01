package exception;

import org.omg.CORBA.UserException;

public class InvalidAreaCodeException extends UserException {

	private static final long serialVersionUID = -3804316760765292574L;

	public InvalidAreaCodeException(String message) {
		super(message);
	}

}
