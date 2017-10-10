package userExceptions;

public class InvalidLastNameException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidLastNameException(String msg){
		super(msg);
	}

}
