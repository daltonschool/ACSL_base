package org.dalton.acsl2.string15;
import java.util.Scanner;

/**
 * @author Swarup
 * ACSL2 String program
 */
public class ACSL2_String15_c18sd1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true){
			String data = scan.nextLine().trim(); //get the line and trim to make sure no empty spaces
			String[] input = data.split(",[ ]*"); // get the input
			String num = "";
			
			for(int i = 0; i< input.length; i++){ //trim each of the separated input
				input[i] = input[i].trim();
			}
			
			if(input[0].contains(" ")){ // if there is a blank space, there means that the input is in the form: 1. abcd.xyz, g, h
				num = input[0].substring(0, 3);
				input[0] = input[0].substring(3, input[0].length()); //get rid of the "1."
				input[0] = input[0].trim(); //trim it again, just to be extra careful
			}
			
			System.out.println(num + STR(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
			
		}
	}
	
	private static String STR(String float_ex, int length, int decimal){
		String result = "";
		String[] arr = float_ex.split("\\."); //split the number into the sections before and after the decimal point
		
		if(decimal == 0){
			if(arr[0].length() > length){// function should return the error hashes
				for(int i = 0; i < length; i++){
					result += "#";
				}
			}else{
				result = arr[0];
				if(result.length() < length){ //add the hashes
					String temp = result;
					result = "";
					for(int i = temp.length(); i < length; i++){
						result += "#";
					}
					result += temp;
				}
			}
			return result;
		}
		
		if(arr[0].length() + decimal + 1> length){ //this means that the function should return an error with the right amount of ##
			for(int i=0; i<length - decimal - 1; i++)
				result +="#";
			result +=".";
			for(int i = 0; i< decimal; i++)
				result += "#";
			return result;
		}
		
		//the decimal places and rounding stuff:
		String places;
		
		if(arr[1].length() == decimal){ // that means no need to check for rounding
			places = arr[1];
			result = arr[0] + "." + places;
			if(result.length() < length){ //add any necessary hashes
				String temp = result;
				result = "";
				for(int i = temp.length(); i < length; i++){
					result += "#";
				}
				result += temp;
			}
			return result;
		}
		
		// this means that the decimal places requested is not valid
		// for example: 1234.12, 7, 3 <- the 3 is invalid
		if(arr[1].length() < decimal){ 
			for(int i = 0; i < (length - decimal) - 1;i++){
				result += "#";
			}
			result +=".";
			for(int i = 0; i < decimal; i++){
				result +="#";
			}
			return result;
		}
		
		places = arr[1].substring(0, decimal+1);
		
		//do the rounding checks
		int num = places.charAt(places.length() -1) - '0'; //get the digit to the right
		if(num >= 5){ //round up
			num = places.charAt(places.length() -2) - '0'; // this the digit to be rounded
			num++; //round up
			char temp = (char)(num + '0');
			
			places = places.substring(0, places.length() -2);
			places += temp;
			
			result = arr[0]+"."+places;
		}else{ //round down
			places = places.substring(0, places.length() -1);
			
			result = arr[0]+"."+places;
		}
		
		if(result.length() < length){ //add the hashes
			String temp = result;
			result = "";
			for(int i = temp.length(); i < length; i++){
				result += "#";
			}
			result += temp;
		}
		
		if(result.charAt(result.length()-1) == '.')
			result = result.substring(0, result.length()-1);
		
		return result;
	}
}