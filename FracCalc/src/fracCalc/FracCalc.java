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
        String finalFRAC = produceAnswer(input);
        System.out.println();
        System.out.println("The final fraction is: " + finalFRAC);
        System.out.println();
        
        System.out.print("What calculation may I perform for you, my liege (type quit to stop)? ");
        input = console.nextLine();
        }
    }
    
    public static String produceAnswer(String input) {
    	String[] arrays1 = new String[3];
    	arrays1[0] = "0";
    	arrays1[1] = "0";
    	arrays1[2] = "0";
    	
    	String[] arrays2 = new String[3];
    	arrays2[0] = "0";
    	arrays2[1] = "0";
    	arrays2[2] = "0";
    	
    	int length = input.length();
    	int space1 = input.indexOf(" ");
    	int space2 = space1 + 3;
    	
    	String operand1 = input.substring(0, space1);
    	String operand2 = input.substring(space2, length);
    	String operator = input.substring((space1 + 1), (space1 + 2));

        String[] firstFrac = firstFraction(operand1, arrays1);
        String[] secondFrac = secondFraction(operand2, arrays2);
        
        String finalFrac = doTheMathPlz(firstFrac, secondFrac, operator);
        String finalFRAC = reduce(finalFrac);
    	
    	return finalFRAC;
    }
    
    /* firstFraction is for identifying each number within the first variable in the 
     * String, and then returns a completed statement with all numbers within it
     * called out */
    
    public static String[] firstFraction(String input, String[] arrays1) {	
		int length = input.length();
    	int slash = input.indexOf("/");
    	
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
    		
    	} else {
        	System.out.println();
    		whole = input;
    		denom = "1";
    	}
    	arrays1[0] = whole;
    	arrays1[1] = numer;
    	arrays1[2] = denom;
    	
    	return arrays1;
    }  
    
    public static String[] secondFraction(String input, String[] arrays2) {	
		int length = input.length();
    	int slash = input.indexOf("/");
    	
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
    		
    	} else {
        	System.out.println();
    		whole = input;
    		denom = "1";
    	}
    	arrays2[0] = whole;
    	arrays2[1] = numer;
    	arrays2[2] = denom;
    	
    	return arrays2;
    } 
    
    public static String doTheMathPlz(String[] arrays1, String[] arrays2, String operator) {
    	/*Assuming that you have a String variable myString, and you want to create an int variable 
    	 * named myInteger that is the numeric version of what is in your string, use this command:
		 * int myInteger = Integer.parseInt(myString); */
    	
    	int finalNumer = 0;
    	int finalDenom = 0;
    	int temp1 = 0; //temporary holder
    	int temp2 = 0; //temporary holder
    	int temp3 = 0; //temporary holder
    	
    	// reducedArray[0] = numer1
    	// reducedArray[1] = denom1
    	// reducedArray[2] = numer2
    	// reducedArray[3] = denom2
    	
    	int[] reducedArray = improperFracs(arrays1, arrays2);

    	if (operator.contentEquals("*")) {
    		finalNumer = reducedArray[0] * reducedArray[2];
    		finalDenom = reducedArray[1] * reducedArray[3];
    	}
    	if (operator.contentEquals("/")) {
    		finalNumer = reducedArray[0] * reducedArray[3];
    		finalDenom = reducedArray[1] * reducedArray[2];
    	}
    	if (operator.contentEquals("-")) {
    		temp1 = reducedArray[0] * reducedArray[3]; // numerator of first frac
    		temp2 = reducedArray[1] * reducedArray[3]; // final denominator
    		temp3 = reducedArray[2] * reducedArray[1]; // numerator of second frac
    		
    		finalNumer = temp1 - temp3;
    		finalDenom = temp2;
    	}
    	if (operator.contentEquals("+")) {
    		temp1 = reducedArray[0] * reducedArray[3]; // numerator of first frac
    		temp2 = reducedArray[1] * reducedArray[3]; // final denominator
    		temp3 = reducedArray[2] * reducedArray[1]; // numerator of second frac
    		
    		finalNumer = temp1 + temp3;
    		finalDenom = temp2;
    	}
    	String finalFrac = finalNumer + "/" + finalDenom;
    	return finalFrac;
    }
    
    public static int[] improperFracs(String[] arrays1, String[] arrays2) {
    	//temporary holders
    	int idk1 = 0;
    	int idk2 = 0;
    	
    	int[] allNums = new int[4];
    	
    	//turning each string number into an int number
    	
    	int whole1 = Integer.parseInt(arrays1[0]);
    	int whole2 = Integer.parseInt(arrays2[0]);
    	
    	int numer1 = Integer.parseInt(arrays1[1]);
    	int numer2 = Integer.parseInt(arrays2[1]);
    	
    	int denom1 = Integer.parseInt(arrays1[2]);
    	int denom2 = Integer.parseInt(arrays2[2]);
    	
    	//do the math with the converted string-to-int variables
    	//make them into improper fractions
    	
   // if the number is positive
    	
    	if (whole1 > 0) {
    		idk1 = whole1 * denom1;
    		idk2 = idk1 + numer1;
    		numer1 = idk2;
    		allNums[0] = numer1;
    		allNums[1] = denom1;
    		
    // if the number is negative
    		
    	} if (whole1 < 0) {
    		idk1 = whole1 * denom1;
    		idk2 = idk1 - numer1;
    		numer1 = idk2;
    		allNums[0] = numer1;
    		allNums[1] = denom1;
    		
    // if no whole number is present
    	
    	} else {
    		allNums[0] = numer1;
    		allNums[1] = denom1;
    		
    // if the number is positive
    		
    	} if (whole2 > 0) {
    		idk1 = whole2 * denom2;
    		idk2 = idk1 + numer2;
    		numer2 = idk2;
    		allNums[2] = numer2;
    		allNums[3] = denom2;
    		
    // if the number is negative
    		
    	} if (whole2 < 0) {
    		idk1 = whole2 * denom2;
    		idk2 = idk1 - numer2;
    		numer2 = idk2;
    		allNums[2] = numer2;
    		allNums[3] = denom2;
    		
    // if no whole number is present
    		
    	} else {
    		allNums[2] = numer2;
    		allNums[3] = denom2;
    	}
    	return allNums;
    }
    
    public static String reduce(String finalFrac) {
    	int length = finalFrac.length();
    	int slash = finalFrac.indexOf("/");
    	int temp1 = 0;
    	int temp2 = 0;
    	String finalFRAC = "0";
    	
    	String whole1 = "0";
    	String numer1 = finalFrac.substring(0, slash);
    	String denom1 = finalFrac.substring((slash + 1), length);
    	
    	int numer = Integer.parseInt(numer1);
    	int denom = Integer.parseInt(denom1);
    	int whole = Integer.parseInt(whole1);
    	
    	if (numer > denom) {
    		temp1 = numer / denom;
    		whole = temp1;
    		temp2 = numer % denom;
    		numer = temp2;
    		return finalFRAC =  whole + "_" + numer + "/" + denom;
    	
    	} else { // if nothing needs to be changed
    		return finalFRAC = numer + "/" + denom;
    	}
    }
}


