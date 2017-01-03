package org.dalton.acsl1.chmod15;
/**
 * @author Swarup Dhar
 * 
 * ACSL Program 1 chmod
 */

import java.util.Scanner;
public class ACSL1_chmod15_SD {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String data = scan.nextLine().trim(); //get the line
			String result = data.contains(".")? data.substring(0, 2)+" ":"";//check if the input has a "1." and if it does then just remove it 
			String temp = ""; // this will hold the rwx part
			String[] input = (data.contains("."))? data.substring(2).trim().split(",[ ]*"):data.split(",[ ]*"); // get the input and trom it to make sure no empty spaces
			for(int i = 1; i < input.length; i++){ 
				//convert string to int and then turn it to binary while checking to see if there are enough zeros/places
				String bin = Integer.toBinaryString(Integer.parseInt(input[i])).length() != 3? ((Integer.toBinaryString(Integer.parseInt(input[i])).length() == 1)?"00"+Integer.toBinaryString(Integer.parseInt(input[i])):"0"+Integer.toBinaryString(Integer.parseInt(input[i]))):Integer.toBinaryString(Integer.parseInt(input[i]));
				//do the checks for rw-
				temp += bin.charAt(0) == '1'? "r":"-";
				temp += bin.charAt(1) == '1'? "w":"-";
				//check for st-
				if(Integer.parseInt(input[0]) == i && bin.charAt(2) == '1') temp+= "s ";
				else if(Integer.parseInt(input[0]) == 4 && i == 3 && bin.charAt(2) == '1') temp+= "t ";
				else temp += bin.charAt(2) == '1'? "x ": "- ";
				//concat it to the result
				result+= bin + " ";
			}
			//concat the "and ..."
			result+= "and " + temp;

			//print result
			System.out.println(result);
		}
	}
}