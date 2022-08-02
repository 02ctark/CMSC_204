import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * The MorseCodeConverter contains a static MorseCodeTree object and constructs (calls the constructor for) the MorseCodeTree.
 * 
 * @author Tark
 *
 */
public class MorseCodeConverter extends Object{

	//data field
	static MorseCodeTree mct = new MorseCodeTree();
	
	/**
	 * Constructor
	 */
	MorseCodeConverter(){
		
	}
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 *Example:
	 *a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	 *string returned = "Hello World"
	 * @param codeFile
	 * @return English translation of the file
	 * @Throws FileNotFoundException
	 */
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {

		// data holds final string word of converted morse code 
		StringBuilder inEnglish = new StringBuilder();
		
		try {
			//reads file
			Scanner scanner = new Scanner(codeFile);
			
			//loops through file line
			while(scanner.hasNextLine()) {
				
				//holds a line
				String currentLine = scanner.nextLine();
				
				//first convert line to english then add to final string
				inEnglish.append(convertToEnglish(currentLine));
				
			}
			
			//close
			scanner.close();
			
			return inEnglish.toString();
			
		} catch (Exception e) {
			
			e.getStackTrace();
		}
		
		//method never reaches this point
		return null;
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * 
	 *Example:
	 *code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	 *string returned = "Hello World"
	 * @param code - the morse code
	 * @return the English translation
	 */
	
	public static String convertToEnglish(String code) {
		
		//create stringbuilder to return final string in english
		StringBuilder sb = new StringBuilder("");
		//split each array index by "/" essentially holds the word
		String[] word = code.split("/");
		
		//iterate through array
		for (int i = 0; i < word.length; i++) {
			
			//get rid of all the whitespace 
			word[i] = word[i].trim();
			
			//split each array index by " " getting each letter
			String[] letter = word[i].split(" ");
			
			for (int j = 0; j < letter.length; j++) {
			
				try {
					
					//make sure a the note 
					if(mct.fetch(letter[j]) != null) {
						
						//every letter is added to create words
						sb.append(mct.fetch(letter[j]));
						
						
					} else {
						
						//print letter if code is irrelevent
						System.err.println(letter[j]);
					}
				//catch if the node is null 
				} catch (NullPointerException e) {
					
					System.err.println(letter[j]);
					
				}
			}
			
			//add space when a word is finished
			sb.append(" ");
		}
		
		return sb.toString().trim();
	}
	

	/**
	 * 	
	 *Returns a string with all the data in the tree in LNR order with an space in between them. 
	 *Uses the toArrayList method in MorseCodeTree It should return the data in this order:
	 *"h s v i f u e l r a p w j b d x n c k y t z g q m o"
	 *Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR traversal, 
	 *the root would come between the right most child of the left tree (j) and the left most child of the right tree (b). 
	 *This is used for testing purposes to make sure the MorseCodeTree has been built properly
	 * 
	 * @return
	 */
	public static String printTree() {
		
		//create ArrayList<String> (tree) with values of inorder
		ArrayList<String> tree = mct.toArrayList();
		//create StringBuilder, finalString is returned
		StringBuilder finalString = new StringBuilder();
		
		//iterate through tree
		for(String list: tree) {
			
			//each iteration add to string
			finalString.append(list + " ");
			
		}
	
		return finalString.toString().trim();
		
		
		
	}

}
