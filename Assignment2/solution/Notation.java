

/** A utility class that converts an infix expression to a postfix expression, a postfix expression to an infix expression and evaluates a postfix expression.
 * 
 * @author Christopher Tark
 *
 */
public class Notation<T> {
	

	/**
	 * constructor
	 */
	public Notation(){
		
	}
	
	
	/**
	 * Evaluates a infix expression from a string to a double
	 * @param infixExpr - infix expression in string format
	 * @return infix expression as a double
	 * @throws InvalidNotationFormatException - if the infix expresssion format is invalid
	 */
	public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException{
		
		return evaluatePostfixExpression(convertInfixToPostfix(infixExpr));
		
	}
	
	/**
	 * Evaluates a postfix expression from a string to a double
	 * @param postfixExpr - the postfix expression in String format
	 * @return evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException - if the postfix expresssion format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{

		
		
		NotationStack<String> postfixStack=new NotationStack<String>(10);
		String num1, num2;
		double doubleExpression = 0;

		try {
			for(int i = 0 ;i < postfixExpr.length(); i++) {
				
				char input = postfixExpr.charAt(i);
				
				if(input == ' ') {
					
					continue;
					
				}
				
				if(Character.isDigit(input)|| input=='(') {
					
					postfixStack.push(String.valueOf(input));
					
				}else {
					
					if(postfixStack.size()<2) {
						
						throw new InvalidNotationFormatException();
						
					}else {
						
						num2=postfixStack.pop();
						num1=postfixStack.pop();
						
						doubleExpression=calculate(input,num1,num2);
						postfixStack.push(Double.toString(doubleExpression));
						
					}
				}
			}
			
		}
		catch(StackOverflowException e) {
			
			e.getMessage();
			
		}
		catch(StackUnderflowException e) {
			
			e.getMessage();
			
		}
		
					
		return doubleExpression;
		
	}
	
	
	/**
	 * Do the arithmetic according to the current operator
	 * @param operator - given operator
	 * @param one - value of type double
	 * @param two - value of type double
	 * @return dExpression - value of two operand with given operator
	 */
	private static double calculate(char operator, String one, String two) {
		
		double dExpression = 0;
		double num1, num2;
		
		if(operator == '*') {
			
			num1 = Double.parseDouble(one);
			num2 = Double.parseDouble(two);
			
			dExpression = num1 * num2;
			
		}
		
		if(operator == '/') {
			
			num1 = Double.parseDouble(one);
			num2 = Double.parseDouble(two);
			
			dExpression =(int) num1 / (int) num2;
			
		}
		
		if(operator == '+') {
			
			num1 = Double.parseDouble(one);
			num2 = Double.parseDouble(two);
			
			dExpression = num1 + num2;
			
		}
		
		if(operator == '-') {
			
			num1 = Double.parseDouble(one);
			num2 = Double.parseDouble(two);
			
			dExpression = num1 - num2;
			
		if(operator == '%') {
			
			num1 = Double.parseDouble(one);
			num2 = Double.parseDouble(two);
			
			dExpression = num1 - num2;
			
		}
			
		}
		
		return dExpression;
	}
	
	
	/**
	 * Convert the Postfix expression to the Infix expression
	 * @param postfix - the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException - if the postfix expression format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		
		//infix "(3*(5+4))+2"
		//postfix "354+*2+"
		
		//create stack
		NotationStack<String> ns = new NotationStack<String>();
		//holds infix
		String infix;
		String pop; 
		
		try {
			
			for(int i = 0; i < postfix.length(); i++) {
				
				char input = postfix.charAt(i);
				
				if(input == ' '){
					
					continue;
					
				}
				
				if(Character.isDigit(input)) {
					
					ns.push(String.valueOf(input));
					
				}
				


				
				//if operators are detected then pop the current top position
				//place operator between operands
				if(input == '*' || input == '/' || input == '+' || input == '-') {
					
					// if size is less than two, not enough operands
					if(ns.size() < 2) {
						
						throw new InvalidNotationFormatException();
						
					}else {
						
						pop = ns.pop();
						
						
						infix = "("+ns.pop() + input + pop+")";
						
						//add back on stack
						ns.push(infix);
						
						
					}
				}
				
				
			}
		
			
		} catch( StackUnderflowException e) {
			
			e.getMessage();
			
		} catch( StackOverflowException e) {
			
			e.getMessage();
			
		}
		
		return ns.toString();
		
		
	}
		

			
		
	
	
	
	/**
	 * Convert an infix expression into a postfix expression
	 * @param infix - the infix expression in string format
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFormatException - if the infix expression format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		
		
		//create instance of NotationStack and queue
		NotationStack<String> ns = new NotationStack<String>();
		NotationQueue<String> nq = new NotationQueue<String>();
		
		try {
			
			for(int i = 0; i < infix.length(); i++) {
				
				char input = infix.charAt(i);
				
				//digit
				if(Character.isDigit(input))
					nq.enqueue(String.valueOf(input));
				
				//empty space
				if(input == ' ')
					continue;
					
				//left  bracket
				if(input == '(') {
					
					ns.push(String.valueOf(input));
					
				}
				
				if( input == '*') {
					
					//verify if the stack is not empty then pop if priority is higher or equal
					//this will be the verification process for all of the character
					if(!ns.isEmpty()) {
						
						while(ns.top().equals("^") || ns.top().equals("/") || ns.top().equals("*") || ns.top().equals("%")) {
							
							nq.enqueue(ns.pop());
							
						}
					}
					
					//add chararcter into stack
					ns.push(String.valueOf(input));
					
				}
				
				if(input == '/') {
					
					if(!ns.isEmpty()) {
						
						while(ns.top().equals("^") || ns.top().equals("/") || ns.top().equals("*") || ns.top().equals("%")) {
							
							nq.enqueue(ns.pop());
							
						}
					}
					
					ns.push(String.valueOf(input));
					
				}
				
				if(input == '-') {
					
					if(!ns.isEmpty()) {
						
						//enqueue if higher or equal priority is added
						while(ns.top().equals("-") || ns.top().equals("+") || ns.top().equals("^") || ns.top().equals("/") || ns.top().equals("*") || ns.top().equals("%")) {
							
							nq.enqueue(ns.pop());
							
						}
					}
					
					ns.push(String.valueOf(input));
				}
				
				if(input == '+') {
					
					if(!ns.isEmpty()) {
						
						while(ns.top().equals("-") || ns.top().equals("+") || ns.top().equals("^") || ns.top().equals("/") || ns.top().equals("*") || ns.top().equals("%")) {
							
							nq.enqueue(ns.pop());
							
						}
					}
					
					ns.push(String.valueOf(input));
					
				}
				
				//right  bracket
				if(input == ')') {
					
					//add all characters in queue if there not equal to '(' left bracker, need loop
					while(!ns.isEmpty() && !ns.top().equals("(")) {
						
						nq.enqueue(ns.pop());
						
					}
					
					//pop if not empty and left bracket
					if(!ns.isEmpty() && ns.top().equals("(")){
						
						ns.pop();
						
					}
					
					//throw exception if stack is empty or there is a left bracket
					else if(ns.isEmpty() || !ns.top().equals("(")) {
						
						throw new InvalidNotationFormatException();
						
					}
				}
			}
			
			//after pop adding that character back to queue
			while(!ns.isEmpty() && !ns.top().equals("(")) {
				
				nq.enqueue(ns.pop());
				
			}
			
		} catch( StackOverflowException e) {
			
			e.getMessage();
			
		} catch( StackUnderflowException e) {
			
			e.getMessage();
			
		}catch( QueueOverflowException e) {
			
			e.getMessage();
			
		}
		
		return nq.toString();
		
	}
	

}
