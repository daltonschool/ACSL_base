package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Alex Kaplan
 *
 */

public class ACSL1_chmod15_AK {

	/**
	 * charlie's code
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/chmod15";
		Scanner scan;
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			//switch to regular terminal input
			scan = new Scanner(System.in);
		}

		//main loop:
		while(scan.hasNext()) {
			String answer = solve(scan.nextLine());
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}

		fop.flush();
		fop.close();
		scan.close();
	}

	/**
	 * solve for a specific input
	 * @param s the input
	 * @return the output
	 */
	static String solve(String s) {

		String[] inputString = s.split(",[ ]*");
		int[] input = new int[inputString.length];

		for (int i = 0; i < inputString.length; i++) {
			input[i] = Integer.parseInt(inputString[i]);
		}

		int special = input[0];

		int[] command = new int[input.length - 1];
		for (int i = 0; i < command.length; i++) {
			command[i] = input[i+1];
		}

		String result = "";

		result += binaryOut(command, special);

		return result;
	}

	/**
	 * this in an array of numbers that is 3 numbers long, which are the three octal numbers of input
	 * the first number of input, or the "special" number, is truncated and submitted as another parameter
	 * the function converts the octal numbers to binary and converts the binary to "rwx" format, then 
	 * outputs both the binary numbers and the rwx letters as a string.
	 * @param in int array of 3 octal numbers which are the chmod command
	 * @param special the first special number
	 * @return binaryAndLetters the binary output along with the letters
	 */
	public static String binaryOut(int[] in, int special) {

		String[] binaryOutArr = new String[in.length];
		
		//for loop that creates a string array of the binary numbers from the octal numbers
		for (int i = 0; i < in.length; i++) {
			//this uses the turnery operator in and a bunch of else if statements to convert octals to binaries
			binaryOutArr[i] = (in[i]==0) ? "000": (in[i]==1) ? "001" : (in[i]==2) ? "010" : (in[i]==3) ? "011":
				(in[i]==4) ? "100" : (in[i]==5) ? "101" : (in[i]==6) ? "110" : (in[i]==7) ? "111" : "";		
		}

		//makes the binary out string from the string array of binary numbers
		String binaryOut = "";
		for (int i = 0; i < binaryOutArr.length; i++) {
			binaryOut += binaryOutArr[i] + " ";
		}

		//make the string of binary and letters from binaryOut string, including the word "and"
		//this also uses the binarytoletters function to convert a binary string to a letters string and adds
		//it to the final output
		String binaryAndLetters = binaryOut + "and ";
		for (int i = 0; i < binaryOutArr.length; i++) {
			binaryAndLetters += binaryToLetters(binaryOutArr[i]) + " ";
		}

		//truncate the last space
		binaryAndLetters = binaryAndLetters.substring(0,binaryAndLetters.length()-1);

		//use the special
		if(special == 1) {
			binaryAndLetters = binaryAndLetters.replaceAll("and ([a-z[-]]{2})x", "and $1s");
			//replace the owner's "x" with s with regex:
			//find the end of the word 'and', then a space, then a letter or character exactly
			//two times, then replace "x" with 's' (only works if there is an x)
		}
		else if(special == 2) {
			binaryAndLetters = binaryAndLetters.replaceAll("and ([a-z[-]]{3}) ([a-z[-]]{2})x", "and $1 $2s");
		}
		else if(special == 4) {
			binaryAndLetters = binaryAndLetters.replaceAll("[x]$", "t");
		}
		

		return binaryAndLetters;
		
	}
	
	/**
	 * converts the binary string to a string of letters
	 * @param onegroup a single group of binary numbers (e.g. "010")
	 * @return a string of 3 characters, including the possibilities of an r, w, x, or -
	 */
	public static String binaryToLetters(String onegroup) {

		int first = onegroup.charAt(0) - 48;
		int second = onegroup.charAt(1) - 48;
		int third = onegroup.charAt(2) - 48;

		String firstString = (first == 1) ? "r" : "-";
		String secondString = (second == 1) ? "w" : "-";
		String thirdString = (third == 1) ? "x" : "-";

		String output = firstString + secondString + thirdString;

		return output;
	}


}
