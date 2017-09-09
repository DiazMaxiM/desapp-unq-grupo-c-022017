package serviceException;

public class InvalidDeliveryLocation extends Exception {

	private static final long serialVersionUID = 1L;
	public InvalidDeliveryLocation(String msg){
		super(msg);
	}
}
