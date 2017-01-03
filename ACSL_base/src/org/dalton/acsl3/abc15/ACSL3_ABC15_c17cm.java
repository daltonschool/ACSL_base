package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//
//ABC ACSL Contest #3
// by Christopher Mailman
// Work in Progress -- will be resubmitting, not much here.
//


public class ACSL3_ABC15_c17cm {

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
			String[] answerArray = (answer.split(", "));

			//sets 3 arrays to enter binary values into.
			int[] digit1;
			digit1 = new int[3];

			int[] digit2;
			digit2 = new int[3];

			int[] digit3;
			digit3 = new int[3];

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
