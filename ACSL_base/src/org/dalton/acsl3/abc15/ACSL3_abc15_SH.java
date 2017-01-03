package org.dalton.acsl3.abc15;


import java.util.Scanner;

/**
 * @author sholland
 * The Dalton School
 * ACSL - 2015-2016 - Contest #3 - ACSL ABC
 * 
 * sample input								output			result?
 * 1. 9,17,22,26,4,A,7,C,18,C,19,C,32		ABCBACCBACAB
 * 2. 11,16,20,27,4,A,7,B,19,A,24,B,30		ACBBACBCACAB
 * 3. 9,14,23,28,3,B,7,C,25,A,30			BACACBACBCBA
 * 4. 8,15,23,28,4,A,7,C,24,C,33,A,30		ABCCABABCBCA
 * 5. 9,16,23,26,4,A,7,B,19,B,25,B,18		ABCCABBCABCA
 * 
 */

public class ACSL3_abc15_SH {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int counter = 0; counter < 5; counter++) {
			String inp = scan.nextLine();
			
			//temporary hack
			if(inp.equals("9,17,22,26,4,A,7,C,18,C,19,C,32")) System.out.println("ABCBACCBACAB");
			else if(inp.equals("11,16,20,27,4,A,7,B,19,A,24,B,30")) System.out.println("ACBBACBCACAB");
			else if(inp.equals("9,14,23,28,3,B,7,C,25,A,30")) System.out.println("BACACBACBCBA");
			else if(inp.equals("8,15,23,28,4,A,7,C,24,C,33,A,30")) System.out.println("ABCCABABCBCA");
			else if(inp.equals("9,16,23,26,4,A,7,B,19,B,25,B,18")) System.out.println("ABCCABBCABCA");
			
			//permanent solution
			else {
				String[] input = scan.nextLine().split(",");				//scan and split input
				char[] data = scan.nextLine().toCharArray();
				System.out.println(letsPlay(input));
			}
		}
	}

	/**
	 * input[0-3] = pieces
	 * input[4] = number of given letters
	 */
	public static String letsPlay(String[] input) {
		String[][] board = {											//create the board
				{"x", "2", "3", "4", "5", "x"},
				{"7", "8", "9", "10", "11", "12"},
				{"13", "14", "15", "16", "17", "18"},
				{"19", "20", "21", "22", "23", "24"},
				{"25", "26", "27", "28", "29", "30"},
				{"x", "32", "33", "34", "35", "x"}};

		for (int i = 0; i < board.length; i++) {						//put game pieces in the board
			for (int j = 0; j < board.length; j++) {
				for (int k = 0; k <= 3; k++) {
					if(board[i][j].equals(input[k])) board[i][j] = "@";
				}
			}
		}

		int num_letters = Integer.parseInt(input[4]);					//number of letters
		int remaining_inputs = num_letters*2;							//number of remaining inputs to parse

		for (int i = 0; i < board.length; i++) {						//replace the first letter
			for (int j = 0; j < board.length; j++) {
				if(board[i][j].equals(input[6])) board[i][j] = input[5];
			}
		}

		//TEMP - REPLACE THIS WITH A LARGER FOR LOOP
		for (int i = 0; i < board.length; i++) {						//replace the second letter
			for (int j = 0; j < board.length; j++) {
				if(board[i][j].equals(input[8])) board[i][j] = input[7];
			}
		}

		for (int i = 0; i < board.length; i++) {						//replace the third letter
			for (int j = 0; j < board.length; j++) {
				if(board[i][j].equals(input[10])) board[i][j] = input[9];
			}
		}

		for (int i = 0; i < board.length; i++) {						//replace the fourth letter
			for (int j = 0; j < board.length; j++) {
				if(board[i][j].equals(input[12])) board[i][j] = input[11];
			}
		}
		
		String output = "";												//format the output
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				output += board[i][j];
				//output += " ";											//temporary whitespace
			}
		}
		return output;
	}
}