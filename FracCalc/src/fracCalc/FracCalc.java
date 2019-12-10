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
    	
    	if (first.contains("_")) {
    		int whoole = first.indexOf("_");
    		int denommm = first.indexOf("//");
    		String whole = first.substring(0, whoole);
    		
        	System.out.print("whole: " + whole);
    		
    		String numerr = first.substring((whoole + 1), denommm);
        	System.out.print("  numerator: " + numerr);
    	}
    	if (first.contains("//")) {
    		int lengthh = first.length();
        	int denomm = first.indexOf("//");
        	String denom = first.substring(denomm, lengthh);
        	
        	System.out.print("  demoninator: " + denom);
    	}
    	else {
        	System.out.println();
    		String whooole = first;
    		int numer = 0;
    		int denoom = 0;
    		
        	System.out.println("whole: " + whooole + "  numerator: " + numer + "  denominator: " + denoom);
    	}
    }
    
    /* secondFraction is also for identifying each integer within the second variable
     * in the String, then returning the completed assigned statement back to the
     * main method */
    
    public static void secondFraction(String second) {
    	System.out.println(second);
    	
    }
}
