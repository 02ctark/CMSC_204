
/**
 * Thrown if password and retyped password are not identical
 * @author Christopher Tark
 *
 */
public class UnmatchedException extends Exception{


	/**
	 * constructor displaying default error
	 */
	UnmatchedException(){
		
		super("Passwords do not match");
		
	}

	/**
	 * parameterized constructor
	 * @param message display string
	 */
	UnmatchedException(String message){
		
		super(message);
		
	}
}
