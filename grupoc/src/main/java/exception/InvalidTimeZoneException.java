package exception;

public class InvalidTimeZoneException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidTimeZoneException(String msg){
		super(msg);
	}

}
