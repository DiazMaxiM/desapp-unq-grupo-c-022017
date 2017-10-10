package orderExceptions;

public class InvalidTypeOfDeliveryException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidTypeOfDeliveryException(String msg){
		super(msg);
	}

}
