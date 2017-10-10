package menuExceptions;

public class InvalidMenuDeliveryPriceException  extends Exception {
	 private static final long serialVersionUID = 1L;
		
	public InvalidMenuDeliveryPriceException(String message) {
			super(message);
	}
}
