
/**
 * Thrown if password contains more than 2 characters in order.
 * @author Christopher Tark
 *
 */
public class InvalidSequenceException extends Exception{

	
	/**
	 * constructor displaying default error
	 */
	InvalidSequenceException(){
		
		super("The password cannot contain more than two of the same character in sequence");
		
	}
	
	/**
	 * parameterized constructor
	 * @param message display string
	 */
	InvalidSequenceException(String message){
		
		super(message);
		
	}
}
