package org.dalton.acsl2.string15;

import java.math.BigDecimal;
import java.util.Scanner;


public class ACSL2_String15_C17KB {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int times = 5;
		while(times > 0){	
			//scanning input
			users(scan.nextLine());
		}
		times --;
	}

	static String users(String b){
		//getting rid of commas
		String [] c = b.split(",[ ]*");
		String plus = "";
		if(c[0].contains("+")){
			plus = plus + "+";
		}
		//parsing data
		float float_exp = Float.parseFloat(c[0]);
		int length = Integer.parseInt(c[1]);	
		int decimal = Integer.parseInt(c[2]);					

		//converting float to double
		double exp = float_exp;

		//send exp and decimal to round to get rounded number
		double roundednumber = round(exp, decimal); 

		//converting double into string
		String rounded = String.valueOf(roundednumber);


		//converting string into char array
		char[] charArray = rounded.toCharArray();
		String hash = "";
		if(plus.length() != 0){
			hash = hash + "+";
			length--;
		}
		if(charArray.length < length){
			int mixed = (length - charArray.length);

			for(int i = mixed; i > 0; i--){
				hash = hash + "#";
			}
			hash = hash + rounded;	
			System.out.println(hash);
		}//if less than

		else if(charArray.length == length){
			System.out.println(plus + rounded);
		}
		else if(charArray.length > length){
			int numhash = (length - (decimal+1));
			for (int i = numhash; i >0; i--){
				hash = hash + "#";
			}
			hash = hash + ".";
			int dechash = decimal;
			for(int j = dechash; j > 0; j--){
				hash = hash + "#";
			}
			System.out.println(hash);
		}


		return null;
	}


	public static double round(double value, int decimal) {
		BigDecimal bigDecimal = new BigDecimal(value);
		bigDecimal = bigDecimal.setScale(decimal,
				BigDecimal.ROUND_HALF_UP);
		return bigDecimal.doubleValue();
	}
}