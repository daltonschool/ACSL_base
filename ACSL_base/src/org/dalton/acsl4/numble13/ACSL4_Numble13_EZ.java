package org.dalton.acsl4.numble13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ethan Zhou
 * Dalton School
 * 3055
 */

public class ACSL4_Numble13_EZ {
	//Global Declarations
	public static class Global {
		public static ArrayList<String> combs = new ArrayList<String>();
	}

	public static void main (String[] args) {
		//Declarations
		Scanner scan = new Scanner(System.in);
		int runs = 0;

		String[] numbers;
		String[] input;
		int bigsum;
		String winningstring;
		String[] winners = new String[3];

		numbers = scan.nextLine().split(", ");
		trimZeros(numbers);

		while(runs < 5) {
			input = scan.nextLine().split(", ");

			for (int i = 0; i < numbers.length; i++) {
				//Initializations
				bigsum = 0;
				winningstring = "";

				getCombs(numbers[i]);

				for (int j = 0; j < Global.combs.size(); j++) {
					int target = sumDigits(Global.combs.get(j));
					if (Global.combs.get(j).length() == Integer.parseInt(input[i]) && target % 5 == 0 && target > bigsum) {
						bigsum = target;
						winningstring = Global.combs.get(j);
					}
				}
				winners[i] = format(winningstring);
			}

			print(winners, input[3].charAt(0), input[4].charAt(0));
			
			runs ++;
		}
	}

	/** 
	 * Prints in that ACSL format	
	 */
	public static void print (String[] input, char cross1, char cross2) {
		char[][] outputarray = new char[13][7];
		int col_1 = 0;
		int col_2 = 0;
		int offset_1 = 0;
		int offset_2 = 0;

		//find column for first number
		for (int i = 0; i < input[0].length(); i++) {
			if(input[0].charAt(i) == cross1) {
				col_1 = i;
				break;
			}
		}
		//find column for second number
		for (int i = 0; i < input[0].length(); i++) {
			if(input[0].charAt(i) == cross2) {
				col_2 = i;
				break;
			}
		}

		//Finds how far from top first number needs to begin
		for (int i = 0; i < input[1].length(); i++) {
			if(input[1].charAt(i) == cross1) {
				offset_1 = 6-i;
				break;
			}
		}
		//Finds how far from top second number needs to begin
		for (int i = 0; i < input[2].length(); i++) {
			if(input[2].charAt(i) == cross2) {
				offset_2 = 6-i;
				break;
			}
		}

		//Fills array with spaces
		for (int i = 0; i < outputarray.length; i++)
			for (int j = 0; j < outputarray[0].length; j++)
				outputarray[i][j] = ' ';

		//Middle row is first number
		for (int i = 0; i < input[0].length(); i++)
			outputarray[6][i] = input[0].charAt(i);

		//Inserts second number
		for (int i = 0; i < input[1].length(); i++)
			outputarray[offset_1+i][col_1] = input[1].charAt(i);

		//Inserts third number
		for (int i = 0; i < input[2].length(); i++)
			outputarray[offset_2+i][col_2] = input[2].charAt(i);

		for (int i = 0; i < outputarray.length; i++) {
			for (int j = 0; j < outputarray[0].length; j++) {
				System.out.print(outputarray[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Formats winning strings
	 */
	public static String format (String input) {
		String output;
		char[] formatted = input.toCharArray();

		Arrays.sort(formatted);
		reverse(formatted);
		
		output = new String(formatted);
		
		if (output.charAt(output.length()-2) == '0')
			output = "0".concat(output.substring(0, output.length()-1));
		
		return output;
	}

	/**
	 * Reverses an array, taken from Fred Swartz, http://leepoint.net/notes-java/data/arrays/arrays-ex-reverse.html
	 */
	public static void reverse(char[] b) {
		int left  = 0;          // index of leftmost element
		int right = b.length-1; // index of rightmost element

		while (left < right) {
			// exchange the left and right elements
			char temp = b[left]; 
			b[left]  = b[right]; 
			b[right] = temp;

			// move the bounds toward the center
			left++;
			right--;
		}
	}//endmethod reverse

	/**
	 * Trims numbers to include 2 zeros, maximum
	 */
	public static String[] trimZeros(String[] numbers) {
		String builder;
		int zeros;

		for (int i = 0; i < numbers.length; i++) {
			builder = "";
			zeros = 0;
			for (int j = 0; j < numbers[i].length(); j++) {
				if (numbers[i].charAt(j) != '0') 
					builder = builder + numbers[i].charAt(j);
				else if (zeros < 2) {
					builder = builder + numbers[i].charAt(j);
					zeros++;
				}
			}
			numbers[i] = builder;
		}	
		return numbers;
	}

	public static int sumDigits(String input) {
		int output = 0;

		for (int i = 0; i < input.length(); i++)
			output = output + Character.getNumericValue(input.charAt(i));

		return output;
	}

	/**
	 * 
	 * Following functions are slightly modified versions of "Combinations.java", written by Robert Sedgewick and Kevin Wayne.
	 * Available at http://introcs.cs.princeton.edu/java/23recursion/Combinations.java.html
	 * 
	 */

	// print all subsets of the characters in s
	public static void getCombs(String s) { 
		Global.combs.clear();
		comb1("", s); 
	}

	// print all subsets of the remaining elements, with given prefix 
	private static void comb1(String prefix, String s) {
		if (s.length() > 0) {
			String output = prefix + s.charAt(0);

			Global.combs.add(output);

			comb1(prefix + s.charAt(0), s.substring(1));
			comb1(prefix,               s.substring(1));
		}
	}

	/**
	 * End of foreign code
	 */
}
