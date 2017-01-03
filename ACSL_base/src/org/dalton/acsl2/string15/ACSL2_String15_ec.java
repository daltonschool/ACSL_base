package org.dalton.acsl2.string15;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ACSL2_String15_ec {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i<5; i++){
			boolean negative = false;
			String input = scan.nextLine();
			DecimalFormat df = new DecimalFormat("0.#");
			if (input.startsWith("-")) negative = true;
			//splits the array
			String[] splitArray = input.split(", ");

			//Double number = Double.parseDouble(splitArray[0]);
			if (splitArray[0].contains(".")== false){
				splitArray[0] = splitArray[0] +".";
			}
			else{
				splitArray[0] = splitArray[0] +"0";
			}
			int length = Integer.parseInt(splitArray[1]);
			int decimal = Integer.parseInt(splitArray[2]);
			int decimallocation = 0;

			for(int j = 0; j<splitArray[0].length();j++){
				if (splitArray[0].charAt(j)=='.'){
					decimallocation =j;
				}
			}

			//length is too small
			if(decimallocation+decimal+1>length){
				if(decimal == 0){
					for(int a =0; a<length; a++){
						System.out.print("#");
					}
				}
				else{
					for(int a =0; a<length-decimal-1; a++){
						System.out.print("#");
					}
					System.out.print(".");
					for(int a =0; a<decimal; a++){
						System.out.print("#");
					}
				}
				System.out.println();
			}

			//decimal is zero
			else if(decimal==0){
				for(int a =0; a<length-decimallocation; a++){
					System.out.print("#");
				}
				for(int a =0; a<decimallocation-1; a++){
					System.out.print(splitArray[0].charAt(a));
				}
				//for the last char (need to round)
				double value = Double.parseDouble(splitArray[0].substring(decimallocation-1, decimallocation+2));
				String valuestring = Double.toString(value);
				if(negative==false){
					value = Math.round(value);
					valuestring = Double.toString(value);
				}
				if(negative==true){
					if(valuestring.charAt(2) == '5'){
						StringBuilder myName = new StringBuilder(valuestring);
						myName.setCharAt(2, '9');
						valuestring = myName.toString();
						value = Double.parseDouble(valuestring);
						value = Math.round(value);
						valuestring = Double.toString(value);
					}
					else{
						value = Math.round(value);
						valuestring = Double.toString(value);
					}
				}
				System.out.print(valuestring.charAt(0));
				System.out.println();
			}
			else{
				//length is too large
				if(decimallocation+decimal+1<length){
					for(int b =0; b<(length-decimallocation-decimal-1);b++){
						System.out.print("#");
					}
					for(int b =0; b<decimallocation+decimal+1-1; b++){ //-2 is for rounding purposes
						System.out.print(splitArray[0].charAt(b));
					}
					double value = .1*Double.parseDouble(splitArray[0].substring(decimallocation+decimal+1-1, decimallocation+decimal+2));
					String valuestring = Double.toString(value);
					if(negative==false){
						value = Math.round(value);
						valuestring = Double.toString(value);
					}
					if(negative==true){
						if(valuestring.charAt(2) == '5'){
							StringBuilder myName = new StringBuilder(valuestring);
							myName.setCharAt(2, '9');
							value = Math.round(value);
							valuestring = myName.toString();
							value = Double.parseDouble(valuestring);
							value = Math.round(value);
							valuestring = Double.toString(value);
						}
						else{
							value = Math.round(value);
							valuestring = Double.toString(value);
						}
					}
					System.out.print(valuestring.charAt(0));
				}

				//length is just right :)
				if(decimallocation+decimal+1==length){
					for(int b =0; b<length-1; b++){
						System.out.print(splitArray[0].charAt(b));
					}
					double value = .1*Double.parseDouble(splitArray[0].substring(length-1, decimallocation+decimal+2));
					String valuestring = Double.toString(value);
					if(negative==false){
						value = Math.round(value);
						valuestring = Double.toString(value);
					}
					if(negative==true){
						if(valuestring.charAt(2) == '5'){
							StringBuilder myName = new StringBuilder(valuestring);
							myName.setCharAt(2, '9');
							value = Math.round(value);
							valuestring = myName.toString();
							value = Double.parseDouble(valuestring);
							value = Math.round(value);
							valuestring = Double.toString(value);
						}
						else{
							value = Math.round(value);
							valuestring = Double.toString(value);
						}
					}
					System.out.print(valuestring.charAt(0));
				}

				System.out.println();
			}//for loop
		}
	}//main
}