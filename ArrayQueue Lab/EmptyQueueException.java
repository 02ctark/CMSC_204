
public class EmptyQueueException extends Exception {
	
	EmptyQueueException(){
		
		super("Modifications invaild due to empty queue.");
		
	}
	
	EmptyQueueException(String message){
		
		super(message);
	}


}
