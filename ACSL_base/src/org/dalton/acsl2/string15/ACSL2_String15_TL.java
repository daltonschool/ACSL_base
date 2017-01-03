package org.dalton.acsl2.string15;
import java.util.Scanner;

public class ACSL2_String15_TL {
	public static void main(String[] args) {
		while(true){
			//get input
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String input[] = scan.nextLine().split(", ");
			String output = "";
			
//			System.out.println(input[0] + " "+ input[1] +" "+ input [2]);
			
			String numinput = input[0];
			int requestedFullLength = Integer.parseInt(input[1]);
			int requestedDecimalLength = Integer.parseInt(input[2]);
			if(numinput.charAt(0)=='+' || numinput.charAt(0) =='-'){
				output = numinput.charAt(0) + output;
				numinput = numinput.substring(1);
				requestedFullLength = requestedFullLength-1;
			}
			
			int inputDigitLength = numinput.split("\\.")[0].length();
			int inputDecimalLength = numinput.split("\\.")[1].length();
			int requestedDigitLength = requestedFullLength - (requestedDecimalLength+1);
//			System.out.println(inputDigitLength);
//			System.out.println(requestedDigitLength);
			if(requestedDigitLength < inputDigitLength){
				output = output + ".";
				for(int i = 0; i < requestedDecimalLength; i++){
					output = output + "#";	
				}
//				System.out.println(output);
				for(int j = 0; j < requestedDigitLength; j++){
					output = "#" + output;
				}
			}
			else if(requestedDigitLength==inputDigitLength){
				for(int j=0; j<requestedDigitLength; j++){
					output = output + numinput.charAt(j);
				}
//				System.out.println("1st"+ output);
				output = output + ".";
//				System.out.println("2nd"+ output);
				if(requestedDecimalLength < inputDecimalLength){
					for(int k=1; k<requestedDecimalLength; k++){
//						System.out.println(numinput.charAt(inputDigitLength+k));
						output = output + numinput.charAt(inputDigitLength+k);
//						System.out.println("hello");
//						System.out.println(output);
					}
					if(Integer.parseInt(numinput.charAt(inputDigitLength+requestedDecimalLength+1)+"")>=5){
//						System.out.println(numinput.charAt(inputDigitLength+requestedDecimalLength+1));
						char lastDigit = numinput.charAt(inputDigitLength+requestedDecimalLength);
						int lastDecimal = Integer.parseInt(lastDigit + "");
//						System.out.println(lastDecimal);
						output = output + (lastDecimal+1);
//						System.out.println("it works!");
//						System.out.println(output);
					}
					else{
						output = output + (numinput.charAt(inputDigitLength+requestedDecimalLength));
//						System.out.println("ummm");
					}
				}
			}
			else{
				for(int j=0; j<inputDigitLength; j++){
					output = output + numinput.charAt(j);
				}
//				System.out.println("1st"+ output);
				output = output + ".";
//				System.out.println("2nd"+ output);
				if(requestedDecimalLength < inputDecimalLength){
					for(int k=1; k<requestedDecimalLength; k++){
//						System.out.println(numinput.charAt(inputDigitLength+k));
						output = output + numinput.charAt(inputDigitLength+k);
//						System.out.println("hello");
//						System.out.println(output);
					}
					if(Integer.parseInt(numinput.charAt(inputDigitLength+requestedDecimalLength+1)+"")>=5){
//						System.out.println(numinput.charAt(inputDigitLength+requestedDecimalLength+1));
						char lastDigit = numinput.charAt(inputDigitLength+requestedDecimalLength);
						int lastDecimal = Integer.parseInt(lastDigit + "");
//						System.out.println(lastDecimal);
						output = output + (lastDecimal+1);
//						System.out.println("it works!");
//						System.out.println(output);
					}
					else{
						output = output + (numinput.charAt(inputDigitLength+requestedDecimalLength));
//						System.out.println("ummm");
					}
				}
				for(int m=0; m<requestedDigitLength-inputDigitLength; m++){
					output = "#" + output;
				}
			}
			System.out.println(output);
//			System.out.println(output.length());
		}
	}
}
