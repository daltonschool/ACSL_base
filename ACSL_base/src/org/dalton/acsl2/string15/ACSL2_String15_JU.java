package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import java.text.DecimalFormat;

//Julia Udell

public class ACSL2_String15_JU {

	public static void main(String[] args) throws IOException {
		//declarations 
		Scanner scan;
		String filein = "testdata/stringTest";
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			//switch to regular terminal input
			scan = new Scanner(System.in);
		}

		//main loop:
		String answer = null; 
		while(scan.hasNext()) {
			answer = solve(scan.nextLine());
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}

		fop.flush();
		fop.close();
		scan.close();
	}

	public static String solve(String s) { 
		String input = s;
		String[] data = input.split(",");
		double flot = Integer.parseInt(data[0]);
		int length = Integer.parseInt(data[1]);
		int dec = Integer.parseInt(data[2]);
		
		//split at the decimal into the integer and decimal (not sure if I still need this if using decimal format)
		String flotstring = Double.toString(flot);
		String[] flotarr = flotstring.split(".");
		int integer = Integer.parseInt(flotarr[0]);
		int decimal = Integer.parseInt(flotarr[1]);

		//System.out.println(decimal + " " + integer);
		
		//rounding
	     BigDecimal bd = new BigDecimal(flot);
	     
	     //do cases for rounding (Scaling etc.) 
	    	
	    
		
		//bd = new BigDecimal(decimal);
		
		
		/*int[] flotnums = new int[10]; //how should it be 
		double roundedNumber = 0; //ask if this is what I should set it to 
		*/

		
		

		
		
		return " "; 
	}
    
}
