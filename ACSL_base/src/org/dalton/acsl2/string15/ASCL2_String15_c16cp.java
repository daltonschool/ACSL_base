package org.dalton.acsl2.string15;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * 
 * @author Cortland Perry
 * ASCL 2
 */

public class ASCL2_String15_c16cp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while(true){
			String output = "";
			String stuff = input.nextLine();
			String[] data = stuff.split(",[ ]*");
			String float_exp = data[0];
			int length = Integer.parseInt(data[1]);
			String dfhelp = "#";
			int decimal = Integer.parseInt(data[2]);

			for(int i = 0; i < decimal; i++){	//determining the regex for DecimalFormat
				if(i == 0){
					dfhelp = dfhelp + ".";
				}
				dfhelp = dfhelp + "0";
			}

			int position = float_exp.indexOf(".");
			DecimalFormat df = new DecimalFormat(dfhelp);
			df.setRoundingMode(RoundingMode.HALF_UP);

			if(decimal == 0){
				position = position -1;
			}

			if((position + decimal + 1) > length){	//what to do if the length is too small
				for(int i = 0; i < (length-decimal-1); i++){
					output = output + "#";  
				}

				if(decimal != 0) output = output + ".";			
				else output = output + "#";

				for(int i = 0; i < decimal; i++){
					output = output + "#";
				}
				System.out.println(output);
			}


			else{	//what to print when length is good/bigger
				String a = "";
				char[] info = float_exp.toCharArray();
				if(info[0] == '+' || info[0] == '-'){
					output = output + info[0];
					float_exp = float_exp.substring(1);
				}
				if(decimal == 0){
					float_exp = float_exp.substring(0, float_exp.length()-3);
				}
				output = output + df.format(Double.parseDouble(float_exp));				
				for(int i = 0; i < (length - output.length()); i++){
					a = a + "#";
				}
				a = a + output;
				System.out.println(a);
			}
		}	

	}
}
