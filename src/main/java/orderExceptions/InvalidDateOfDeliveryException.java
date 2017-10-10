package orderExceptions;

public class InvalidDateOfDeliveryException extends Exception {
	private static final long serialVersionUID = 1L;
    
	public InvalidDateOfDeliveryException(String msg){
		super(msg);
	}
}
