/* For produceAnswer, find the index of the first space
     - then make a substring of (0, substring)
     - this will be the first fraction
*/

package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner console = new Scanner(System.in);
    	String input;
    	
        System.out.print("What calculation may I perform for you, my liege (type quit to stop)? ");
        input = console.nextLine();
        
    	while (!input.equals("quit")) {
        String second = produceAnswer(input);
        System.out.println("The second fraction is " + second);
        firstFraction(input);
        secondFraction(second);
        System.out.println();
        System.out.print("What calculation may I perform for you, my liege (type quit to stop)? ");
        input = console.nextLine();
        }
    }
    
    public static String produceAnswer(String input) { 
    	int length = input.length();
    	int space = input.indexOf(" ") + 3;
    	
    	return input.substring(space, length);
    }
    
    /* firstFraction is for identifying each number within the first variable in the 
     * String, and then returns a completed statement with all numbers within it
     * called out */
    
    public static void firstFraction(String input) {
    	int space = input.indexOf(" ");
    	String first = input.substring(0, space);
    	System.out.println("first: " + first);
    	System.out.println();
    	
		int length = first.length();
    	int slash = first.indexOf("/");
    	
    	String whole = "0";
    	String numer = "0";
    	String denom = "0";
    	
    	//sets whole number
		int index1 = first.indexOf("_");
    	if (index1 > 0) {
    		whole = first.substring(0, index1);
    	}
    	//sets numerator if there is an underscore (with whole number)
    	if (index1 > 0) {
    		numer = first.substring((index1 + 1), slash);
        //sets numerator if there is no underscore (no whole number)
    	} else {
    		numer = first.substring(0, slash);
    	}
    	
    	//sets denominator
    	if (slash > 0) {
    		denom = first.substring((slash + 1), length);
    		
    	} else {
        	System.out.println();
    		whole = first;
    		denom = "1";
    	}
    	System.out.println("whole: " + whole + "  numerator: " + numer + "  denominator: " + denom);
    	System.out.println();
    }
    
    /* secondFraction is also for identifying each integer within the second variable
     * in the String, then returning the completed assigned statement back to the
     * main method */
    
    public static void secondFraction(String second) {
    	
    }
}
