
public class InvalidSequenceException extends Exception {
	
		
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4730240530176547860L;

	//constructor
	public InvalidSequenceException() {
		
		super("Password contains more than 2 of the same character in sequence");
		
	}
}
