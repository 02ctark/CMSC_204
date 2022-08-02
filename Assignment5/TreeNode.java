

/**
 * The external Tree Node for Linked Trees
 * 
 * @author Tark
 * @param <T>
 */
public class TreeNode<T> extends Object{
	
	
	TreeNode<T> left;
	TreeNode<T> right;
	private T data;
	
	
	/**
	 * Constructor - Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	TreeNode(T dataNode){
		
		left = null;
		right = null;
		data = dataNode;
		
	}
	
	/**
	 * Constructor - used for making deep copies
	 * @param node - node to make copy of
	 */
	TreeNode(TreeNode<T> node){
		
		data = node.getData();
		left = node.left;
		right = node.right;
		
		
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return "" - the data within the TreeNode
	 */
	public T getData() {
		
		return data;
	}
}
