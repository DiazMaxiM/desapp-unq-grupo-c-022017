package orderExceptions;

public class InvalidDeliveryTimeException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidDeliveryTimeException(String msg){
		super(msg);
	}

}
