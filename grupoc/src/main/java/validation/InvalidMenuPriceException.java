package validation;

public class InvalidMenuPriceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidMenuPriceException(String msg){
		super(msg);
	}

}
