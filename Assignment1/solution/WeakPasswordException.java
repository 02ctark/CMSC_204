
public class WeakPasswordException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4845496814364015264L;

	
	public WeakPasswordException() {
		
		
		super("The password is OK but weak - it contains fewer than 10 characters");
		
	}

}
