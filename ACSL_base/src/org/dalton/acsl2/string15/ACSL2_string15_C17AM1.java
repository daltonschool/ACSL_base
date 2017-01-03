package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ACSL2_string15_C17AM1 {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/string_DATA";
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
	 * 
	 * Name: Aly Milich
	 * 
	 * Formats the input
	 * If the number of digits in the formatted output is greater than the specified size,
	 * 	puts #'s in
	 * If the number of digits in the formatted output is less than specified size,
	 * 	shifts the formatted over by the difference and fills the difference with #'s
	 * Returns string s
	 */
	static String solve(String s) {

		String[] input = s.split(",[ ]*");

		String origfloat = input[0];
		double floatnum = Double.parseDouble(input[0]);
		int formatsize = Integer.parseInt(input[1]);
		int decsize = Integer.parseInt(input[2]);
		int intsize = (formatsize - (decsize+1));
		int integerPlaces = origfloat.indexOf('.');
		int decimalPlaces = origfloat.length() - integerPlaces - 1;

		DecimalFormat decimal = new DecimalFormat(); 
		decimal.setRoundingMode(RoundingMode.HALF_UP);
		decimal.setMaximumFractionDigits(decsize);
		decimal.setMinimumFractionDigits(decsize);
		decimal.setMinimumIntegerDigits(0);
		s = decimal.format(floatnum);

		if(origfloat.contains("+")){
			System.out.print("+");
		}

		else if(s.length() > formatsize || decsize > decimalPlaces){
			s="";
			for (int i = 0; i < intsize; i++) {
				System.out.print("#");
			}
			System.out.print(".");
			for (int i = 0; i < decsize; i++) {
				System.out.print("#");
			}
		}
		else if(s.length() < formatsize){
			int difference = formatsize - s.length();
			for (int i = 0; i < difference; i++) {
				System.out.print("#");
			}
		}

		else if(s.length() > formatsize){
			int greatdifference = s.length() - formatsize;
			for (int i = 0; i < greatdifference; i++) {
				System.out.print("#");
			}
		}
		return s;
	}
}