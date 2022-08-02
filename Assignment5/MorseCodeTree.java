import java.util.ArrayList;

/**
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english
 * It relies on a root (reference to root of the tree)
 * The root is set to null when the tree is empty.
 * 
 * The class uses an external generic TreeNode class which consists of a reference to the data and a 
 * reference to the left and right child. The TreeNode is parameterized as a String, TreeNode 
 * This class uses a private member root (reference to a TreeNode)
 * @author Chris Tark
 *
 */
public class MorseCodeTree extends Object implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root;
	
	/**
	 * Constructor - calls the buildTree method
	 */
	MorseCodeTree(){
		
		root = null;
		buildTree();
	}
	
	/**
	 * Returns a reference to the root
	 * getRoot in interface LinkedConverterTreeInterface<java.lang.String>
	 * @return reference to root
	 */
	public TreeNode<String> getRoot(){
		
		return root;
		
	}
	
	/**
	 * sets the root of the MorseCodeTree
	 * setRoot in interface LinkedConverterTreeInterface<java.lang.String>
	 * @param newNode - a newNode that will be the root of MorseCodeTree
	 */
	public void setRoot(TreeNode<String> newNode) {
		
		this.root = new TreeNode<String>(newNode);
		
	}
	/**
	 * Adds element to the correct position in the tree based on the code 
	 * This method will call the recursive method addNode
	 * insert in interface LinkedConverterTreeInterface<java.lang.String>
	 * @param code - the code for the new node to be added, example ".-."
	 * @param letter
	 */
	public void insert(String code, String letter) {
		
		addNode(root, code, letter);
		
	}

	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code. 
	 * A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
	 * The code ".-" would be stored as the right child of the left child of the root Algorithm for the 
	 * recursive method: 1. if there is only one character a. if the character is '.' (dot) store to the left 
	 * of the current root b. if the character is "-" (dash) store to the right of the current root c. return 
	 * 2. if there is more than one character a. if the first character is "." (dot) new root becomes the left 
	 * child b. if the first character is "-" (dash) new root becomes the right child c. new code becomes all 
	 * the remaining charcters in the code (beyond the first character) d. call addNode(new root, new code, 
	 * letter)
	 * addNode in interface LinkedConverterTreeInterface<java.lang.String>
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		//create new node holding added data
		
		//verify code/base case adding the new node holding letter
		if(code.length() == 1) {
			
			if(code.charAt(0) == '.') {
				
				if(root.left == null)
					root.left = new TreeNode<String>(letter);
				
			} else if (code.charAt(0) == '-') {
				
				if(root.right == null)
					root.right = new TreeNode<String>(letter);
			}
			
		//code has more than one combination, call recursivly	
		} else if(code.length() > 1){
			
			if(code.charAt(0) == '.') {
				
				addNode(root.left, code.substring(1), letter);
				
			} else if (code.charAt(0) == '-') {
				
				addNode(root.right, code.substring(1), letter);
				
			}
		}
	}
	
	/**
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 * @param code - the code that describes the traversals to retrieve the string (letter)
	 * @return fetchNode - the string (letter) that corresponds to the code
	 */
	public String fetch(String code) {
		
		return fetchNode(root, code);
	}
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds 
	 * with the code A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. 
	 * The code ".-" would fetch the data of the TreeNode stored as the right child of the 
	 * left child of the root
	 * fetchNode in interface LinkedConverterTreeInterface<java.lang.String>
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return currentNode - the string (letter) corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		
		
		if(code.length() == 1) {
			
			//base case
			if(code.charAt(0) == '.') {
				
				return root.left.getData();
				
			} else if(code.charAt(0) == '-') {
				
				return root.right.getData();
			}
			
			
		} else if(code.length() > 1){
			
			if(code.charAt(0) == '.') {
				
				//removes first character in code to read next 
				return fetchNode(root.left, code.substring(1));
				
			} else if (code.charAt(0) == '-') {
				
				//removes first character in code to read next 
				return fetchNode(root.right, code.substring(1));
				
			}
		}
		
		// impossible for method to reach this point
		return null;
	}
	

	/**
	 * This operation is not supported in the MorseCodeTree
	 * delete in interface LinkedConverterTreeInterface<java.lang.String>
	 * @param data - data of node to be deleted
	 * @return "" - reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		
		throw new UnsupportedOperationException("Delete is not supported in MorseCodeTree");
	}
	
	/**
	 * This operation is not supported in the MorseCodeTree
	 * update in interface LinkedConverterTreeInterface<java.lang.String>
	 * @return "" - reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public MorseCodeTree update() throws UnsupportedOperationException {
		
		throw new UnsupportedOperationException("Update is not supported in MorseCodeTree");
	}
	
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
	 * The root will have a value of "" (empty string) level one: insert(".", "e"); 
	 * insert("-", "t"); level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); 
	 * insert("--", "m"); etc. Look at the tree and the table of codes to letters in the assignment description.
	 * 
	 * buildTree in interface LinkedConverterTreeInterface<java.lang.String>
	 */
	public void buildTree() {
		
		//level 1
		setRoot(new TreeNode<String>(""));
		
		//level 2
		insert(".", "e");
		insert("-", "t");
		
		//level 3
		//children of e
		insert("..", "i");
		insert(".-", "a");
		//children of t
		insert("-.", "n");
		insert("--", "m");
		
		//level 4
		//children of i
		insert("...","s");
		insert("..-","u");
		//children of a
		insert(".-.","r");
		insert(".--","w");
		//children of n
		insert("-..","d");
		insert("-.-","k");
		//children of m
		insert("--.","g");
		insert("---","o");
		
		//level 5
		//children of s
		insert("....","h");
		insert("...-","v");
		//children of u
		insert("..-.","f");
		//children of r
		insert(".-..","l");
		//children of w
		insert(".--.","p");
		insert(".---","j");
		//children of d
		insert("-...","b");
		insert("-..-","x");
		//children of k
		insert("-.-.","c");
		insert("-.--","y");
		//children of g
		insert("--..","z");
		insert("--.-","q");
		
	}
	
	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order 
	 * Used for testing to make sure tree is built correctly
	 * toArrayList in interface LinkedConverterTreeInterface<java.lang.String>
	 * @return lnr - an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList() {
		
		//new ArrayList call lnr
		ArrayList<String> lnr = new ArrayList<>();
		//convert lnr into inorder BST
		LNRoutputTraversal(root, lnr);

		return lnr;
	}
	
	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * LNRoutputTraversal in interface LinkedConverterTreeInterface<java.lang.String>
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		//base case
		if(root == null) {
			//exit method
			return; 
		}
		
		//left node right
		LNRoutputTraversal(root.left, list);
		list.add(root.getData());
		LNRoutputTraversal(root.right, list);
		
	}
}//end MorseCodeTree
