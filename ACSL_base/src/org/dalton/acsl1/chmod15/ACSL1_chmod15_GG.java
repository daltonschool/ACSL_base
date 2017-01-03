package org.dalton.acsl1.chmod15;
/*
 * @author Georgia Gallant
 * 
 */
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
public class ACSL1_chmod15_GG {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String[] finalValue = new String[5];
		String[] finalSecondValue = new String[5];
		String secondValue;
		for(int x = 0; x < 5; x++){
			String input = scan.nextLine();
			String delims = "[ .,?!]+";
			String[] octal = input.split(delims);
			for(int i = 2; i<5; i++){
				int octalInt = Integer.valueOf(octal[i]);
				String binary = Integer.toBinaryString(octalInt);
				String formattedBinary = String.format("%3s", binary).replace(' ', '0');
				 if(formattedBinary.charAt(0) == '1'){
					 secondValue = "r";
				 }
				 else{
					 secondValue = "-";
				 }
				 if(formattedBinary.charAt(1) == '1'){
					 secondValue = secondValue + "w";
				 }
				 else{
					 secondValue = secondValue + "-";
				 }
				 if(formattedBinary.charAt(2) == '1'){
					 if((i==2 && Integer.valueOf(octal[1]) == 1) || (i==3 && Integer.valueOf(octal[1]) == 2)){
						 secondValue = secondValue + "s "; 
					 }
					 else if(i==4 && Integer.valueOf(octal[1]) == 4){
						 secondValue = secondValue + "t ";
					 }
					 else{
					 secondValue = secondValue + "x ";  
					 }} 
				 else{
					 secondValue = secondValue + "- ";
					 }
				 if(finalSecondValue[x] == null){
					 finalSecondValue[x] = secondValue;
				 }
				 else{
					 finalSecondValue[x] = finalSecondValue[x] + secondValue;
				 }
				if(finalValue[x] == null){
					finalValue[x] = (formattedBinary + " ");
				}
				else{
					finalValue[x] = finalValue[x] + (formattedBinary + " ");
				}}}
		for(int y = 0; y < 5; y++){
			System.out.println((y+1) + ". " + finalValue[y] + "and " + finalSecondValue[y]);
		}}}