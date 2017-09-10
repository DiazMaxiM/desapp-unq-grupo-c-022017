package menuExceptions;

public class InvalidMaximumNumberOfMenusSalesPerDay extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidMaximumNumberOfMenusSalesPerDay (String message) {
		super(message);
	}
}
