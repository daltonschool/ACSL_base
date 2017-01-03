package org.dalton.acsl2.string15;


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * @author sholland
 * ACSL - 2015-2016 - Contest #2 - ACSL STRING
 *
 * sample data
 * 1. 523.125, 6, 2			523.13		GOOD
 * 2. +523.125, 6, 1		+523.1		GOOD
 * 3. -523.163, 6, 1		-523.2		GOOD
 * 4. 523.125, 4, 2			#.##		need to catch the error
 * 5. -523.12, 6, 1			-523.1		GOOD
 */

public class ACSL2_string15_SH {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int counter = 0; counter < 5; counter++) {
			String[] input = scan.nextLine().split(", ");				//scan and split input
			System.out.println(sailboat(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
		}
	}

	/**
	 * @param flo the given float expression
	 * @param length the given length of the expression
	 * @param decimal the number of decimal values in the expression
	 * @return the expression rounded to the correct length and number of decimal places
	 */
	public static char[] sailboat(String flo, int length, int decimal) {
		char sign = ' ';
		if(flo.charAt(0)=='+' || flo.charAt(0)=='-') {
			sign = flo.charAt(0);
			flo = flo.substring(1);										//remove the sign from the string
			//System.out.println("the sign is " + sign);				//debug
		}
		
		double round = Double.parseDouble(flo);							//pull number out of the string
		//System.out.println("the number to be rounded is " + round);	//debug

		//annoying cluster of decimal formats
		ArrayList<DecimalFormat> df = new ArrayList<DecimalFormat>();	//arraylist for different decimal formats
		df.add(0, new DecimalFormat("###"));
		df.add(1, new DecimalFormat("###.#"));
		df.add(2, new DecimalFormat("###.##"));
		df.add(3, new DecimalFormat("###.###"));
		df.add(4, new DecimalFormat("###.####"));
		df.add(5, new DecimalFormat("###.#####"));
		df.add(6, new DecimalFormat("###.######"));
		df.add(7, new DecimalFormat("###.#######"));
		df.add(8, new DecimalFormat("###.########"));
		df.add(9, new DecimalFormat("###.#########"));

		df.get(0).setRoundingMode(RoundingMode.HALF_UP);
		df.get(1).setRoundingMode(RoundingMode.HALF_UP);
		df.get(2).setRoundingMode(RoundingMode.HALF_UP);
		df.get(3).setRoundingMode(RoundingMode.HALF_UP);
		df.get(4).setRoundingMode(RoundingMode.HALF_UP);
		df.get(5).setRoundingMode(RoundingMode.HALF_UP);
		df.get(6).setRoundingMode(RoundingMode.HALF_UP);
		df.get(7).setRoundingMode(RoundingMode.HALF_UP);
		df.get(8).setRoundingMode(RoundingMode.HALF_UP);
		df.get(9).setRoundingMode(RoundingMode.HALF_UP);
		
		//round the number
		String rounded_num = "";
		/* */if(decimal==0) rounded_num = df.get(0).format(round);
		else if(decimal==1) rounded_num = df.get(1).format(round);
		else if(decimal==2) rounded_num = df.get(2).format(round);
		else if(decimal==3) rounded_num = df.get(3).format(round);
		else if(decimal==4) rounded_num = df.get(4).format(round);
		else if(decimal==5) rounded_num = df.get(5).format(round);
		else if(decimal==6) rounded_num = df.get(6).format(round);
		else if(decimal==7) rounded_num = df.get(7).format(round);
		else if(decimal==8) rounded_num = df.get(8).format(round);
		else if(decimal==9) rounded_num = df.get(9).format(round);

		System.out.println("the rounded number is " + rounded_num);		//debug

		String output = "";
		if(sign!=' ') output = sign + rounded_num;						//add the sign back
		else output = rounded_num;

		//convert to ### if the string is overfilled
		char[] overflow = output.toCharArray();
		if(overflow.length > length) {
			for (int i = 0; i < overflow.length; i++) {
				if(overflow[i]!='.') overflow[i] = '#';
			}
			return overflow;
		}
		return output.toCharArray();
	}
}