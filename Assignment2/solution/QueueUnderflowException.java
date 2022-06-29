
/**
 * Occurs when a dequeue method is called on an empty queue
 * 
 * @author Christopher Tark
 *
 */
public class QueueUnderflowException extends Exception{

	QueueUnderflowException(){
		
		super("The queue is empty");
	}
	
	QueueUnderflowException(String message){
		
		super(message);
		
	}
}
