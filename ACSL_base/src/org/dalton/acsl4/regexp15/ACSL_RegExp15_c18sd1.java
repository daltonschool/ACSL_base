package org.dalton.acsl4.regexp15;
import java.util.Scanner;

/**
 * @author Swarup Dhar
 * 
 *  _      ___   ___   _          _ _     _ _  
   /_\    / __| / __| | |       _| | |_  | | | 
  / _ \  | (__  \__ \ | |__    |_  .  _| |_  _|
 /_/ \_\  \___| |___/ |____|   |_     _|   |_| 
                                 |_|_|        
 * ACSL #4 RegExp program
 * 
 * Uses scanner and please don't input the lines with the numbers, for example: 
 * 		1. blah, blah
 * 		2. b.h
 * 
 * 
 	Q: Why do programmers always mix up Halloween and Christmas?
	A: Because Oct 31 == Dec 25!
 *
 */
public class ACSL_RegExp15_c18sd1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // make a scanner
		String first_Line = scan.nextLine(); // get the first line
		first_Line = first_Line.replace("#", ""); // replace # with empty string
		String[] input = first_Line.split(",[ ]*"); // split it
		
//		if(input[0].charAt(0) == '1'){ // check if the input has a number, if so take it out
//			input[0] = input[0].substring(2);		
//		}
		
		String regEx = "";
		String result;
		
		for(int c = 0; c <= 4; c++){ // loop through five times since there will be 5 inputs
			result = "";
			regEx = scan.nextLine().trim();
			/*if(Character.isDigit(regEx.charAt(0)) && regEx.charAt(1) == '.' && regEx.length() >= 5){ // check if the regex is in this format: 1. a.c 
				regEx = regEx.substring(2).trim(); // take out the 1.
			}
			*/
			for(int i = 0; i < input.length; i++){ // go through the stuff in the first line and check if the regEx matches
				if(input[i].trim().matches(regEx.trim())){
					result += input[i] + ", ";
				}
			}
			if(result.equals("")){
				result = "NONE";
			}else{
				result = result.trim().substring(0, result.length() - 2);
			}
			System.out.println(result);
		}
	}
	
}
