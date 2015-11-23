package org.dalton.acsl2.format13;
/**
 * Alia Richardson

 * ASCL Print Formatting
 * The Dalton School
 * 
 */

import java.text.DecimalFormat;  
import java.math.RoundingMode;
import java.util.Scanner;

public class ACSL2_Format13_AR {
	
	//if it contains $ and * replace & with #, but for anything else replace & with 0
	public static String ChangeSymbol(String input){
		if(((input.contains("$")==true)&&(input.contains("*") ==false))){
			input = input.replace('&', '#');
		}
		//if it contains anything else, replace with 0
		else{
			input = input.replace('&', '0');
		}
		return input;
	}
	// puts into scientific notation, works for 7
	public static String E(String pattern, double number){
		DecimalFormat df = new DecimalFormat("0." + pattern.substring(1,pattern.length()) + "0");  
		return df.format(number);  
	}
	//works for 1, 3, 4, 5
	public static String Format(String pattern, double value ) {
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		myFormatter.setRoundingMode(RoundingMode.HALF_UP);
		String output = myFormatter.format(value);
		//change any 0 at the beginning to *
		char [] outputchar =  output.toCharArray();
		for(int x = 0; x < 100; x++) 
		{
			if (outputchar[x] != '0'){
				break;
			}
			if (outputchar[x]=='0'){
				outputchar[x]='*';
			}	
		}
		output = String.valueOf(outputchar);
		return output;
	}
	//adds commas, works for rule 2
	public static String commas(String pattern, double value){
		pattern = pattern.replace(",", "");
		String temp = Format(pattern,value);
		//make a string that contains all the stars
		char [] tempchar =  temp.toCharArray();
		char[] starsA = new char[100];
		for(int x = 0; x < 100; x++) 
		{
			if (tempchar[x]=='*'){
				starsA[x]=tempchar[x];
			}
			if (tempchar[x]!='*'){
				break;
			}
		}
		//make a string that contain all the numbers
		String numbers = temp.replace("*","");
		double numbs = Double.parseDouble(numbers);
		numbers = Format("###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###", numbs);
		String stars = String.valueOf(starsA);
		return stars+numbers;
	}
	//works for rule 6
	public static String dollarshift(String pattern, double value){
		pattern = Format(pattern, value);
		//removes * from beginning
		pattern = pattern.substring(1);
		//replaces 0 with *
		char [] patternchar = pattern.toCharArray();
		patternchar[0]='*';
		for(int x = 1; x < 100; x++) 
		{
			if (patternchar[x] != '0'){
				patternchar[x-1]='$';
				break;
			}
			if (patternchar[x]=='0'){
				patternchar[x]='*';
			}	
		}
		pattern = String.valueOf(patternchar);
		return pattern;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(true){
			String input = scan.nextLine();
			input = ChangeSymbol(input);
			String[] inputA = input.split(", ");
			double number = Double.parseDouble(inputA[1]);
			//puts each input in the function it belongs in
			if((inputA[0].contains("*") == false) &&(inputA[0].contains("E") == false)){
				if(inputA[0].contains(",")){
					System.out.println(commas(inputA[0], number));
				}
				else{
					System.out.println(Format(inputA[0], number));
				}
			}
			if ((inputA[0].contains("*")) && (inputA[0].contains("$"))){
				System.out.println(dollarshift(inputA[0], number));
			}
			if(inputA[0].contains("E")){
				System.out.println(E(inputA[0], number));
			}
		}
	}//main
}//class
