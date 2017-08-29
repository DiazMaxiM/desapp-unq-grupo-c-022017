package menuExceptions;

public class InvalidMaximumNumberOfMunusSalesPerDay extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidMaximumNumberOfMunusSalesPerDay (String message) {
		super(message);
	}
}
