import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

/**
 * My sorted double linked list implementation.
 * Implements a generic sorted double list using a provided Comparator. It extends BasicDoubleLinkedList class.
 * @author Tark
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	
	//data field
	Comparator<T> comparator;
	
	/**
	 * constructor
	 * Creates an empty list that is associated with the specified comparator.
	 * @param comparator
	 */
	SortedDoubleLinkedList(Comparator<T> comparator){
		
		this.comparator = comparator;
		
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * @param data - the data for the Node within the linked list
	 */
	public void add(T data) {
		
		//create new node with wanted data
		Node<T> newNode = new Node<>(data);
		//node for equivilent to first node
		Node<T> node = firstNode;
		
		//add if linked list is empty
		if(firstNode == null) {
			
			firstNode = newNode;
			lastNode = newNode;
		}
		
		//loop for firstNode not equal to null
		while(node != null) {
			
			//new data is less then firstNode
			if(comparator.compare(newNode.getData(), node.getData()) > 0) {
				
				if (node == lastNode) {
					
					//firstNode last node is new node, new node connects to firstNode
					newNode.setNextNode(firstNode);
					firstNode.setPreviousNode(newNode);
					
					//lastNode next node is set to new data/node
					//connect new node to lastNode
					lastNode.setNextNode(newNode);
					newNode.setPreviousNode(lastNode);
					
					lastNode = newNode;
					
					//stop the loop
					break;
					
				} else {
					
					//next node
					node = node.getNextNode();
					
				}
				
			//new node is greater then previous node
			} else if (comparator.compare(newNode.getData(), node.getData()) < 0) { 
				
				
				if (node == firstNode) {
					
					// connect the new node with firstNode
					newNode.setNextNode(node);
					node.setPreviousNode(newNode);
					
					//connect newNode with lastNode
					newNode.setPreviousNode(lastNode);
					lastNode.setNextNode(newNode);
					
					firstNode = newNode;
					
				} else {
					
					//connect newNode with node/firstNode
					newNode.setNextNode(node);
					newNode.setPreviousNode(node.getPreviousNode());
					
					//wire node with newNode
					node.setPreviousNode(newNode);
					newNode.getPreviousNode().setNextNode(newNode);
					
				}
				
				//stop the loop
				break;
			
			// new data is equal to firstNode value
			} else if (comparator.compare(newNode.getData(), node.getData()) == 0) {
				
				//set newNode to node
				newNode.setNextNode(node.getNextNode());
				//firstNode set to newNode
				node.setNextNode(newNode);
				
				//set new node to firstNode
				newNode.setPreviousNode(node);
				//the next value of newNode is set to previous newNode
				newNode.getNextNode().setPreviousNode(newNode);
				
				//stop the loop
				break;
				
			} else {
				
				//increment
				node = node.getNextNode();
			}
			
		}
		
		numberOfEntries++;
			
		
	}
	
	
	
	/**
	 * This operation is invalid for a sorted list.
	 * @param data - the data for the Node within the linked list
	 * @throws UnsupportedOperationException - 
	 */
	public void addToEnd(T data) throws UnsupportedOperationException{
		
		throw new UnsupportedOperationException("Invalid operation for sorted list");
		
	}
	
	/**
	 * This operation is invalid for a sorted list.
	 * @param data - the data for the Node within the linked list
	 */
	public void addToFront(T data) throws UnsupportedOperationException{
		
		
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	/**
	 * Implements the iterator by calling the super class iterator method.
	 */
	public ListIterator<T> iterator(){
		
		return super.iterator();
		
	}
	
	
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @param data - the data for the Node within the linked list
	 * @param comparator - compare elements
	 */
	public BasicDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		
		super.remove(data, comparator);
		return this;
	}
	
}
