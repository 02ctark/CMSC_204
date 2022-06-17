/**
 * Thrown if passowrd does not contain a lowercase alpha character
 * @author Christopher Tark
 *
 */
public class NoLowerAlphaException extends Exception{

	/**
	 * constructor displaying default error
	 */
	NoLowerAlphaException(){
		
		super("The password must contain at least one lowercase alphabetic character");
		
	}
	
	/**
	 * parameterized constructor
	 * @param message display message	
	 */
	NoLowerAlphaException(String message){
		
		super(message);
		
	}
	
}
