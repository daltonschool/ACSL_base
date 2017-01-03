package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
//import java.util.toBinaryString; 

public class ACSL1_chmod_RS {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int[] toBinary = new int[10];
		String[] permission = new String[10];
		int size = 0;
		
		for(int i = 0; i < toBinary.length; i++) {		
			input = size++;
			System.out.println(toBinary[i]);
		}

	}

}


//FIND A WAY TO CONVERT OCTAL DIGITS INTO BINARY
//if(input after conversion = 0) {
//System.out.println("-");
//}
//else if(input = 1) {
//table[0, 3, 6] = r;
//table[1, 4, 7] = w;
//table[2, 5, 8] = x;
//}
//else if(input before conversion for table[0] = 1) {
//change all Xs to Ss for table[0, 3, 6]
//else if(input before conversion for table[0] = 2 ) {
//change all Xs to Ss for table[1, 4, 7]
//else if(input before conversion for table[0] = 4) {
//change all Xs to Ts for table[2, 5, 8]



