
/**
 * Creating a circle array queue
 * @author Christopher Tark
 * @param <T>
 */
public class ArrayQueue<T> implements QueueInterface<T>{

	private int frontIndex;
	private int backIndex;
	private T[] queue;
	private static final int DEFAULTCAPACITY = 50;
	
	ArrayQueue(){
		
		this(DEFAULTCAPACITY);
		
	}

	
	ArrayQueue(int capacity){
		
		@SuppressWarnings("unchecked")
		T[] queueTemp = (T[]) new Object[capacity + 1];
		queue = queueTemp;
		
		backIndex = capacity;
		frontIndex = 0;
		
	}
	/**
	 * Double the array queue size if it is full
	 */
	private void ensureCapacity() {
		
		if(frontIndex == ((backIndex + 2) % queue.length)) {
			
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[oldSize * 2];
			queue = tempQueue;
			
			//transverse all items into new array
			for(int i = 0; i < queue.length; i++) {
				
				queue[i] = oldQueue[frontIndex];
				frontIndex = (frontIndex+1) % oldSize;
				
			}
			
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
		
		
	}
	
	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		
		ensureCapacity();
		
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;

		
	}
	
	/**
	 * Throws an exception if the queue is empty
	 * @throws EmptyQueueException
	 */
	private void isEmptyException() throws EmptyQueueException {
		
		if(isEmpty()) {
			
			throw new EmptyQueueException();
		}
		
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		
		try {
			isEmptyException();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		T front = null;
		
		if(!isEmpty()) {
			
			front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
		}
		
		return front;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		
		try {
			
			isEmptyException();
			
		} catch (EmptyQueueException e) {
			
			e.getMessage();
			
		}
		

		return queue[frontIndex];

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return frontIndex == ((backIndex + 1) % queue.length);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < queue.length; i++) {
			
			queue[i] = null;
			
		}
		
	
		
	}

}
