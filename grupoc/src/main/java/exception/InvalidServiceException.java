package exception;

import org.omg.CORBA.UserException;

@SuppressWarnings("all")
public class InvalidServiceException extends UserException {
	public InvalidServiceException(String message){
		super(message);
	}

}
