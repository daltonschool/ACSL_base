package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;


public class ACSL2_String15_MC {

	
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/testdata";
		Scanner scan;
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			//switch to regular terminal input
			scan = new Scanner(System.in);
		}

		//main loop:
		while(scan.hasNext()) {
			String answer = solve(scan.nextLine());
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}

		fop.flush();
		fop.close();
		scan.close();



	}
	
	static String solve(String s) {
		String input = s;
		String output;
		
		Scanner scan = new Scanner(new ByteArrayInputStream(input.getBytes())); 
		scan.useDelimiter(",[ ]*");
		String floot = scan.next();
		int length = scan.nextInt();
		int decimal = scan.nextInt();
	
		
		//check for plus sign
		boolean hasPlus = false;
		if(floot.startsWith("+") == true) {
			hasPlus = true;
		}
		
		
		//round to the assigned decimal place

		//System.out.println("STRING FLOAT: " + floot);
		

		BigDecimal roundedFloot = new BigDecimal(floot);
		roundedFloot = roundedFloot.setScale(decimal, BigDecimal.ROUND_HALF_UP);
		//////System.out.println("rounded: " + roundedFloot);
		 
		
		
		//get the number of digits(including period or -/+) in the rounded float
		
		String roundedFlootString = roundedFloot.toString();
		int roundedLength = roundedFlootString.length();
		
		if(hasPlus == true) {
			roundedLength++;
		}
		
		//output length of rounded float
		/////////System.out.println("length: " + roundedLength);
		
		
		//cut down string to the desired length
		
		//defining variables
		int lengthDif = length-roundedLength;
		char[] flootArray = roundedFlootString.toCharArray();
		char[] outputFinal = new char[length];
		
		//add plus sign to flootArray if necessary
		char[] flootArray2 = new char[roundedLength];
		if(hasPlus == true) {
			for(int i = 0; i < roundedLength; i++) {
				if(i == 0) {
					flootArray2[i] = '+';
				}
				else {
					flootArray2[i] = flootArray[i-1];
				}
			}
		}
		
		
		if(roundedLength == length) {
			if(hasPlus == true) {
				for(int i = 0; i < length; i++) {
					outputFinal[i] = flootArray2[i];
				}
			}
			else {
				for(int i = 0; i < length; i++) {
					outputFinal[i] = flootArray[i];
				}
			}	
		}
		
		if(roundedLength < length) {
			if(hasPlus == true) {
				for(int i = 0; i < length; i++) {
					if(i<lengthDif) {
						outputFinal[i] = '#';
					}
					else {
						outputFinal[i] = flootArray2[i-lengthDif];
					}
				}
			}
			
			else {
			
				for(int i = 0; i < length; i++) {
					if(i<lengthDif) {
						outputFinal[i] = '#';
					}
					else {
						outputFinal[i] = flootArray[i-lengthDif];
					}
				}
			}
		}
		
		if(roundedLength > length) {
			//make the whole thing hashtags
			for(int i = 0; i < length; i++) {
				if(i == length - decimal - 1) {
					outputFinal[i] = '.';
				}
				else {
					outputFinal[i] = '#';
				}
				
			}
		
		}
		for(int j = 0; j < length; j++) {
			if(j == 0) {
				//System.out.print("Final Output: ");
				System.out.print(outputFinal[j]);
			}
			else {
				System.out.print(outputFinal[j]);
			}
			
		}

		
		return "";

		
		}
	
	}

