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
}
