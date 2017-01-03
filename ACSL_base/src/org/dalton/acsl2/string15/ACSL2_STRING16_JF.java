package org.dalton.acsl2.string15;
import java.text.DecimalFormat;
import java.util.Scanner;


public class ACSL2_STRING16_JF {
	public static void main(String[] args){
		
		double expresion =0;
		double length =0;
		double decimal =0;
		
		Scanner scan = new Scanner(System.in);
		
		String input;
		String[] data;
			
			//take the input
			input = scan.nextLine();

			//break up the input
			data = input.split(", ");
			
			//split parse data into different 
			expresion =Double.parseDouble(data[0]);
			length =Double.parseDouble(data[1]);
			decimal =Double.parseDouble(data[2]);
			
			
			
			
//			System.out.println(data[0]);
//			System.out.println(expresion);
//
//			System.out.println(data[1]);
//			System.out.println(length);
//
//			System.out.println(data[2]);
//			System.out.println(decimal);

			
			
//			 DecimalFormat df = new DecimalFormat("##.length");
//		 		double d = 1.234567;
//				System.out.print(df.format(d));
			
			System.out.printf("%.2f", expresion);
			
			if(expresion<0){
				System.out.println("banana");				
			}
		
	}
	
	
}
