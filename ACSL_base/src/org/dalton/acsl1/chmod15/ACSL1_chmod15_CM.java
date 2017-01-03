package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * ACSL CHMOD
 * by Christopher Mailman II, 1/4/2016
 * Converts 3 character octal into binary pairs
 * and detects CHMOD permissions.
 */

public class ACSL1_chmod15_CM {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/TEST";
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
			//Splits the answer string at commas and stores in string array.
			String[] answerArray = (answer.split(","));

			//sets 3 arrays to enter binary values into.
			int[] digit1;
			digit1 = new int[3];

			int[] digit2;
			digit2 = new int[3];

			int[] digit3;
			digit3 = new int[3];

			//permissions string arrays to print out permissions, default to -.
			String[] permissions1;
			permissions1 = new String[3];
			permissions1[0] = "-";
			permissions1[1] = "-";
			permissions1[2] = "-";

			String[] permissions2;
			permissions2 = new String[3];
			permissions2[0] = "-";
			permissions2[1] = "-";
			permissions2[2] = "-";

			String[] permissions3;
			permissions3 = new String[3];
			permissions3[0] = "-";
			permissions3[1] = "-";
			permissions3[2] = "-";

			//special value to detect special permissions in 0 slot of the answer array.
			int special = Integer.valueOf(answerArray[0]);
			//octal integers are the numerical values of slots of string array.
			int octal1 = Integer.valueOf(answerArray[1]);
			int octal2 = Integer.valueOf(answerArray[2]);
			int octal3 = Integer.valueOf(answerArray[3]);
	
			//-----------------------------------------------------------------------------1
			//converts octal numbers into binary, using same method as by hand (checks 4, then 2, then 1 places, subtracts from original value until complete).
			 
			if(octal1 - 4 >= 0){
				digit1[0] = 1;
				octal1 = octal1 - 4;
				permissions1[0] = "r";
			}

			if(octal1 - 2 >= 0){
				digit1[1] = 1;
				octal1 = octal1 - 2;
				permissions1[1] = "w";
			}

			if(octal1 - 1 >= 0){
				digit1[2] = 1;
				octal1 = octal1 - 1;
				permissions1[2] = "x";
				if(special == 1){
					permissions1[2] = "s";
					//checks for special permissions only if execute permission already granted.
				}
			}

			System.out.print(digit1[0]);
			System.out.print(digit1[1]);
			System.out.print(digit1[2]);
			//-----------------------------------------------------------------------------2			

			if(octal2 - 4 >= 0){
				digit2[0] = 1;
				octal2 = octal2 - 4;
				permissions2[0] = "r";
			}

			if(octal2 - 2 >= 0){
				digit2[1] = 1;
				octal2 = octal2 - 2;
				permissions2[1] = "w";
			}

			if(octal2 - 1 >= 0){
				digit2[2] = 1;
				octal2 = octal2 - 1;
				permissions2[2] = "x";
				if(special == 2){
					permissions2[2] = "s";
				}		
			}

			System.out.print(" ");
			System.out.print(digit2[0]);
			System.out.print(digit2[1]);
			System.out.print(digit2[2]);

			//-----------------------------------------------------------------------------3	
			if(octal3 - 4 >= 0){
				digit3[0] = 1;
				octal3 = octal3 - 4;
				permissions3[0] = "r";
			}

			if(octal3 - 2 >= 0){
				digit3[1] = 1;
				octal3 = octal3 - 2;
				permissions3[1] = "w";
			}

			if(octal3 - 1 >= 0){
				digit3[2] = 1;
				octal3 = octal3 - 1;
				permissions3[2] = "x";


				if(special == 4){
					permissions3[2] = "t";
					//t for others class.
				}
			}

			System.out.print(" ");
			System.out.print(digit3[0]);
			System.out.print(digit3[1]);
			System.out.print(digit3[2]);
			System.out.print(" and ");
			System.out.print(permissions1[0]);
			System.out.print(permissions1[1]);
			System.out.print(permissions1[2]);
			System.out.print(" ");
			System.out.print(permissions2[0]);
			System.out.print(permissions2[1]);
			System.out.print(permissions2[2]);
			System.out.print(" ");
			System.out.print(permissions3[0]);
			System.out.print(permissions3[1]);
			System.out.println(permissions3[2]);

			//-----------------------------------------------------------------------------	
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
		return s;
	}
}