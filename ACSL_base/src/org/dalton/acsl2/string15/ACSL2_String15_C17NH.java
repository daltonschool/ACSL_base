package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


	/**
	 * 
	 * @author Nell Hurley
	 * ACSL competition - program 1
	 * 
	 */

public class ACSL2_String15_C17NH {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "chmodtest";
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
		String[] data = s.split(",[ ]*");
		double data1 = Integer.parseInt(data[0]);
		int data2 = Integer.parseInt(data[1]);
		int data3 = Integer.parseInt(data[2]);
		
		//data1 = float_expression
		//take the string and make it a char array
		
		
		//data2 = length
		
		
		//data3 = decimal
		
		
		
		
		
		
		return "";
	}
}
