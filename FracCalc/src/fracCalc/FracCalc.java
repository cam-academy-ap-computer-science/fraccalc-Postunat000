/* For produceAnswer, find the index of the first space
     - then make a substring of (0, substring)
     - this will be the first fraction
*/

package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner console = new Scanner(System.in); 	
        System.out.print("What calculation may I perform for you, my liege (type quit to stop)? ");
        String input = console.nextLine();
        
    	while (!input.equals("quit")) {
        String operand2 = produceAnswer(input);
        //System.out.println("The second fraction is: " + operand2);
        System.out.println();
        
        System.out.print("What calculation may I perform for you, my liege (type quit to stop)? ");
        input = console.nextLine();
        }
    }
    
    public static String produceAnswer(String input) {
    	int length = input.length();
    	int space1 = input.indexOf(" ");
    	int space2 = space1 + 3;
    	
    	String operand1 = input.substring(0, space1);
    	String operand2 = input.substring(space2, length);
    	String operator = input.substring((space1 + 1), (space1 + 2));
    	//System.out.println("operand1: " + operand1 + " operand2: " + operand2 + " operator: " + operator);
        String firstFrac = firstFraction(operand1);
        String secondFrac = firstFraction(operand2);
        System.out.println(secondFrac);
    	
    	return secondFrac;
    }
    
    /* firstFraction is for identifying each number within the first variable in the 
     * String, and then returns a completed statement with all numbers within it
     * called out */
    
    public static String firstFraction(String input) {	
		int length = input.length();
    	int slash = input.indexOf("/");
    	//System.out.print(input);
    	
    	String whole = "0";
    	String numer = "0";
    	String denom = "1";
    	
    	//sets whole number
		int index1 = input.indexOf("_");
    	if (index1 > 0) {
    		whole = input.substring(0, index1);
    	}
    	//sets numerator if there is an underscore (with whole number)
    	if (index1 > 0) {
    		numer = input.substring((index1 + 1), slash);
    		
        //sets numerator if there is no underscore (no whole number)
    	} else if(slash > 0) {
    		numer = input.substring(0, slash);
    	}
    	
    	//sets denominator
    	if (slash > 0) {
    		denom = input.substring((slash + 1), length);
    		//numer = input.substring(0, slash);
    		
    	} else {
        	System.out.println();
    		whole = input;
    		denom = "1";
    	}
    	return "whole:" + whole + " numerator:" + numer + " denominator:" + denom;
    }  
}