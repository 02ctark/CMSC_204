/**
 * Occurs when a top or pop method is called on an empty stack
 * 
 * @author Christopher Tark
 *
 */

public class StackUnderflowException extends Exception{

	
	StackUnderflowException(){
		
		super("The stack is empty.");
		
	}
	
	StackUnderflowException(String message){
		
		super(message);
	}
}
