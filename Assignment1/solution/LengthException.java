
public class LengthException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8836855037782263036L;

	
	public LengthException() {
		
		super("The password must be at least 6 characters long");
		
	}

}
