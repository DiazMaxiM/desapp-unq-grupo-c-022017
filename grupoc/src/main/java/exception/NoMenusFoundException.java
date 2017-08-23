package exception;

import org.omg.CORBA.UserException;

@SuppressWarnings("all")
public class NoMenusFoundException extends UserException {
	public NoMenusFoundException(String message){
		super(message);
	}
}
