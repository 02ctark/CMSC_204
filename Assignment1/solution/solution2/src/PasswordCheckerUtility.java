import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Christopher Tark
 * 
 * 
 *
 */

public class PasswordCheckerUtility {
	
	/**
	 * constructor
	 */
	PasswordCheckerUtility(){
		
		
	}
	
	
	//method details
	

	/**
	 * Compare equality of two passwords
	 * @param password password string to be checked for
	 * @param passwordConfirm passwordConfirm string to be checked against password for
	 * @throws UnmatchException thrown if not same (case sensitive)
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		
		if(!(password.equals(passwordConfirm)) ) {
			
			throw new UnmatchedException();
			

		}
		
		
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password check string
	 * @param passwordConfirm this string is be compared with password
	 * @return isValid return true if password and passwordConfirm are equal
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
		boolean isValid = false;
		
		if(password == passwordConfirm) {
			
			isValid = true;
		}
		
		return isValid;
	}
	

	/**
	 * Reads a file of passwords and the passwords that failed the check will be added to an 
	 * invalidPasswords with the reason
	 * @param passwords list of strings to read
	 * @return ArrayList of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		
		//create array list
		ArrayList<String> invalidPasswords = new ArrayList<>();
		
		//loop that runs through all the strings
		for(int i = 0; i < passwords.size(); i++) {
			
			try {
				
				//check if the each string is valid
				isValidPassword(passwords.get(i));
				
			//if false then add the password and display message
			}catch(Exception e) {
				
				invalidPasswords.add(passwords.get(i) + " -> " + e.getMessage());
				
			}
		
		}
		
		//return array list
		return invalidPasswords;
	}
	
	/**
	 * Weak password length check - Password contains 6 to 9 characters , still considers valid, just weak
	 * @param password
	 * @return
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		
		boolean isValid = false;
		
		if(password.length() >= 6) {
			
			isValid = true;
			
		}
		
		return isValid;
		
	}
	

	//*
	public static boolean hasDigit(String password) throws NoDigitException{
		
		//for-each loop is used  to go through each character in a string
		for(Character c : password.toCharArray()) {
			
			//if a character is lower case return true
			if(Character.isDigit(c)) {
				
				return true;
				
			}
		}
		
		throw new NoDigitException();
		
	}
	
	/**
	 * Checks the password lowercase requirement - Password must contain a lowercase alpha character
	 * @param password string to test 
	 * @return true if string has at least one lower case character
	 * @throws NoLowerAlphaException thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		
		if(password.equals(password.toUpperCase())){
			
			throw new NoLowerAlphaException();
		}
		
		return true;
		
		//another option
		/*
		 * for(Character c : password.toCharArray()) {
		 * 
		 * if(Character.isLowerCase(c)) {
		 * 
		 * return true;
		 * 
		 * } }
		 * 
		 * throw new NoLowerAlphaException();
		 */
	}

	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password take string in to test
	 * @return return true if no repeating characters
	 * @throws InvalidSequenceException thrown if does not meet Sequence requirement
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException{
		
		//
		Pattern pt = Pattern.compile("((.)\\2{2,})");
		Matcher m = pt.matcher(password);
		
		if(m.find()) {
			
			throw new InvalidSequenceException();
			
		}
		
		return true;
		
	}
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password string to test characters
	 * @return true if string contain special character
	 * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(password);
		
		//if password has a special character return true
		if(m.find()) {
			
			return true;
			
		}else {
			
			throw new NoSpecialCharacterException();
		}
		
	}
	
	
	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password string to test
	 * @return true if there is at least one upper case in password
	 * @throws NoUpperAlphaException thrown if does not meet alpha character requirement
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		
		
			
		if(password.equals(password.toLowerCase())) {
				
			throw new NoUpperAlphaException();
				
		} else {
				
			return true;
				
		}
		
		
		//another option
		/*
		 * for(Character c : password.toCharArray()) {
		 * 
		 * if(Character.isUpperCase(c)) {
		 * 
		 * return true;
		 * 
		 * } }
		 * 
		 * throw new NoUpperAlphaException();
		 */
		
		
	}
	
	/**
	 * Checks the password length requirement - – The password must be at least 6 characters long
	 * @param password input string for testing length
	 * @return isValid return true if password is greater than 6
	 * @throws LengthException thrown if length of password is less than 6
	 */
	public static boolean isValidLength(String password) throws LengthException{
		
		
		if(password.length() >= 6) {
			
			return true;
			
		}else {
			
			throw new LengthException();
			
		}
		
		
	}
	

	/**
	 * Return true if valid password (follows all rules from above), returns false if an invalid password
	 * @param password string input for testing validity
	 * @return  true if valid password (follows all rules from above), false if an invalid password
	 * @throws LengthException thrown if length is less than 6 characters
	 * @throws NoUpperAlphaException thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException thrown if no lowercase alphabetic
	 * @throws NoDigitException thrown if no digit 
	 * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter requirement
	 * @throws InvalidSequenceException thrown if more than 2 of same character
	 */
	public static boolean isValidPassword(String password) throws 
	LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		boolean isValid = false;
		//if all are true password is valid
		if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) 
				&& hasSpecialChar(password) && hasSameCharInSequence(password) ) {
			
			isValid = true;
			
		}
		
		return isValid;
	}
	
	/**
	 * Checks if password is valid but between 6 -9 characters
	 * @param password intake a string for testing
	 * @return isWeak true if the length of password is between 6 and 9
	 * @throws WeakPasswordException thrown if password length password is between 6 and 9
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		
		boolean isWeak = false;
		
		if(password.length() <= 9 && password.length() >= 6) {
		
			isWeak = true;
			
		}
		
		return isWeak;
	}
	
	
	
}
