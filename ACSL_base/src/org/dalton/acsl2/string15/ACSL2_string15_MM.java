package org.dalton.acsl2.string15;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;


public class ACSL2_string15_MM {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		float float_expression = 0;
		int length = 0;
		int decimal = 0;
		boolean sign = false;
		String symbol = "";
		String finala = "";

		while (true){

			String[] input = s.nextLine().split(", ");
			length = Integer.parseInt(input[1]);
			decimal = Integer.parseInt(input[2]);

			if (input[0].startsWith("+")==true || input[0].startsWith("-")==true){
				sign = true;
				float_expression = Float.parseFloat(input[0].substring(1));
				symbol = String.valueOf(input[0].charAt(0));
			}//close if

			else{
				float_expression = Float.parseFloat(input[0]);
				sign = false;
				symbol = "";
			}//close else

			//System.out.println(float_expression);
			//System.out.println(length);
			//System.out.println(decimal);
			//System.out.println(symbol);

			finala = STR(sign,symbol,float_expression,length,decimal);

			System.out.println(finala);

		}//close while

	}//close main

	public static String STR(boolean sign, String symbol, float float_expression, int length, int decimal){
		String output = "";
		String[] outputarr = new String[length];
		String zeros = "";

		if (length<(String.valueOf(float_expression)).length()-1){
			outputarr[length-1-decimal] = ".";
			for (int i = 0; i < outputarr.length; i++) {
				if(outputarr[i]!="."){
					outputarr[i] = "#";
				}
			}

			output=Converter(outputarr);
		}

		else{

			for (int i = 0; i < decimal; i++) {
				zeros = zeros+"0";
			}

			DecimalFormat df = new DecimalFormat("#."+zeros);
			df.setRoundingMode(RoundingMode.HALF_UP);

			output = df.format(float_expression);


			if (sign=true){
				output = symbol+output;
			}
		}//close else
		
		if (length>output.length()){
			int loop = length-output.length();
			
			for (int i = 0; i < loop; i++) {
				output = "#"+output;
			}
		}
		
		return output;
		
	}//close STR

	public static String Converter(String[] x){
		String converted = "";
		for (int i = 0; i < x.length; i++) {
			converted = converted + x[i];
		}

		return converted;
	}//close converter

}//close pgm
