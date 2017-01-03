package org.dalton.acsl2.string15;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;


public class ACSL2_String15_c16cd {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		
		for (int j = 0; j < 5; j++) {
			
		
		String input = scan.nextLine();
		String[] inputs = input.split(", ");
		
		String expression = inputs[0];
		int lengthinit = expression.length();
		
		String leng = inputs[1];
		int length = Integer.parseInt(leng);
		
		String decimalCount = inputs[2];
		int count = Integer.parseInt(decimalCount);

		char sign = 0; 
		float dec = 0;
		boolean plus = false; 
		if(expression.charAt(0)=='+'||expression.charAt(0)=='-') {
			plus = true;
			sign = expression.charAt(0);
			expression = expression.substring(1);
			dec = Float.parseFloat(expression);
		}
		else{
			dec = Float.parseFloat(expression);
		}
		int predecimal = 0;
		char[] arr = expression.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]=='.') break;
			predecimal++;
		}
		
		String format ="";
		for (int i = 0; i < predecimal; i++) {
			format = format + "#";
		}
		
		
		
		format = format + ".";
		for (int i = 0; i < count; i++) {
			 format = format + "#";
		}
		DecimalFormat df = new DecimalFormat(format);
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		
		String fin = df.format(dec);
		if(plus==true){
		fin =  sign + fin; 
		}
		if(count==0) {
			fin = fin.substring(0,fin.length()-1);
		}
			
		//System.out.println(fin);
		
		String hashs = "";
		if(length<fin.length()){
			
			for (int i1 = 0; i1 < count; i1++) {
				hashs = hashs + "#";
			}
			hashs = "." + hashs;
			for (int i1 = 0; i1 < length-count-1; i1++) {
				hashs = "#" + hashs;
			}
			
			
			System.out.println(hashs);
		}
		
		else if(fin.length()<length){
			int add = length-fin.length();
			for (int i1 = 0; i1 < add ; i1++) {
					fin = "#" + fin; 
			}
			System.out.println(fin);
		}
		else System.out.println(fin);
		
		
		}	
	}
	
}
