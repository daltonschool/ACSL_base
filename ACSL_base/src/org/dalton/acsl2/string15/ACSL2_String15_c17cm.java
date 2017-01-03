package org.dalton.acsl2.string15;

	import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
	
public class ACSL2_String15_c17cm {
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
			
			//Sets Comma-separated input into booleans
			float floatexp = Float.valueOf(answerArray[0]);
			int length = Integer.valueOf(answerArray[1]);
			int decimal = Integer.valueOf(answerArray[2]);
			
			char[] hashtags;
			hashtags = new char[length];
			
			 for (int i = length; i < length; i++){
				 hashtags[i] = '#';
			 }
			 
			 hashtags[(length - decimal)] = '.';
			 
			 for (int i = length; i < length; i++){
				 System.out.println(hashtags[i]);
			 }
			
			
			System.out.println(answer);
			
			System.out.print(floatexp);
			System.out.print(length);
			System.out.println(decimal);
			System.out.println();
			
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

