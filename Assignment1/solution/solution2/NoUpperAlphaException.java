
/**
 * Thrown if password does not contain an uppercase alpha character
 * @author Christopher Tark
 *
 */
public class NoUpperAlphaException extends Exception{
	
	/**
	 * constructor displaying default error
	 */
	NoUpperAlphaException(){
		
		super("The password must contain at least one uppercase character");
		
	}
	
	/**
	 * Parameterized constructor
	 * @param message display message
	 */
	NoUpperAlphaException(String message){
		
		super(message);
		
	}

}
