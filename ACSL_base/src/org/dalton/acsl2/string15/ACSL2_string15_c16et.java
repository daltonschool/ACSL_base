package org.dalton.acsl2.string15;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ACSL2_string15_c16et {

	//check if length is right
	public static boolean length(int total, int decimal, String input){

		boolean works = true;


		//find number of ints that are before decimal
		int count=0;
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i)=='.'){
				break;
			}
			else count++;
		}
		if((total-decimal-1)>=count){
			works = true;
		}
		else works=false;

		return works;
	}

	//return # if the number is wrong
	public static String wrongnum(int total, int decimal, String input){
		String wrong = "";
		int beforedecimal = total-decimal-1;

		//do before the decimal point
		for(int i=0; i<beforedecimal; i++){
			wrong+="#";
		}
		//add in the decimal point
		wrong+=".";

		//after decimal point
		for(int j=0; j<decimal; j++){
			wrong+="#";
		}

		return wrong;
	}

	public static boolean needhashtags(int total, int decimal, String input){
		boolean hashtags = false;
		//find total number of chars in string
		int count=0;
		for(int i=0; i<input.length(); i++){
			count++;
		}
		//if it's too small add on hashtags
		if(total>count||decimal==0){
			hashtags=true;
		}
		return hashtags;
	}

	public static String hashtags(int total, int decimal, String input){
		String hashtags = "";
		//find total number of chars in string
		int count=0;
		//first if there are no decimals
		if(decimal==0){
			for(int i=0; i<input.length(); i++){
				if(input.charAt(i)=='.'){
					break;
				}
				else count++;
			}
			//now just do the hashtags + chars
			int hashnum = total-count;
			for(int i=0; i<hashnum; i++){
				hashtags+="#";
			}
			for(int i=0; i<count; i++){
				hashtags+=input.charAt(i);
			}

		}
		else{
			for(int i=0; i<input.length(); i++){
				count++;
			}
			//if it's too small add on hashtags
			if(total>count){
				for(int i=0; i<total-count; i++){
					hashtags+="#";
				}
			}
			//add in the rest of the string
			for(int j=0; j<input.length(); j++){
				hashtags+=input.charAt(j);
			}
		}

		return hashtags;
	}

	public static String rightnum(int total, int decimal, String input){

		String right = "";
		int decimalstart = total-decimal;
		//get the string that is the decimal part
		String toround = "";
		int countdecimal = 0;
		for(int i=decimalstart; i<input.length(); i++){
			toround+=input.charAt(i);
			countdecimal++;
		}
		//make it an int
		double roundint = Integer.parseInt(toround);
		roundint = roundint/(Math.pow(10,countdecimal));

		//round the decimal
		BigDecimal bd = new BigDecimal(roundint).setScale(decimal, RoundingMode.HALF_UP);
		roundint = bd.doubleValue();

		//put it back together
		for(int i=0; i<total-decimal-1; i++){
			right += input.charAt(i);
		}
		String temp = Double.toString(roundint).substring(1);
		right+=temp;

		return right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		for(int j=0; j<5; j++) {
			//print the answer
			String[] stringIn = scan.nextLine().split(", ");
			int total=Integer.parseInt(stringIn[1]);
			int decimal=Integer.parseInt(stringIn[2]);
			String input = stringIn[0];
			boolean which = true;

			which = length(total, decimal, input);

			if(which==false){
				System.out.println(wrongnum(total, decimal, input));
			}
			else{
				if(needhashtags(total, decimal, input)==true){
					System.out.println(hashtags(total, decimal, input));
				}
				else{
					System.out.println(rightnum(total, decimal, input));
				}
			}
		}

	}

}
