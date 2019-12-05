/* For produceAnswer, find the index of the first space
     - then make a substring of (0, substring)
     - this will be the first fraction
*/

package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
    	Scanner console = new Scanner(System.in);
    	
        // TODO: Read the input from the user and call produceAnswer with an equation
    	
    	String input;
    	System.out.print("What do you want bro ");
    	input = console.next();
    	
    	String second = produceAnswer(input);
    	System.out.println("The second fraction is " + second);
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input

    	String inputOne = input + " ";
    	int length = inputOne.length();
    	
    	int space = input.indexOf(" ");
    	int first = space + 5;
    	return inputOne.substring(first, length);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
