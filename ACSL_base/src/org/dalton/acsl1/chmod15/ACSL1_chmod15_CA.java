package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ACSL1_chmod15_CA {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/chmod_testdata";
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

	/**
	 * solve for a specific input
	 * @param s the input
	 * @return the output
	 */
	static String solve(String input) {
		
		//parse input into 4 ints
		
		String[] data = input.split(",[ ]*");
		int digit1 = Integer.parseInt(data[0]);
		int digit2 = Integer.parseInt(data[1]);
		int digit3 = Integer.parseInt(data[2]);
		int digit4 = Integer.parseInt(data[3]);
		
		//convert ints 2-4 into binary, i could turn this into a method
		
		int [] binary2 = new int [3];
		int [] binary3 = new int [3];
		int [] binary4 = new int [3];
		

		//digit 2
		if (digit2 == 0) {
			binary2[0] = 0;
			binary2[1] = 0;
			binary2[2] = 0;
		}
		else if (digit2 == 1) {
			binary2[0] = 0;
			binary2[1] = 0;
			binary2[2] = 1;
		}
		else if (digit2 == 2) {
			binary2[0] = 0;
			binary2[1] = 1;
			binary2[2] = 0;
		}
		else if (digit2 == 3) {
			binary2[0] = 0;
			binary2[1] = 1;
			binary2[2] = 1;
		}
		else if (digit2 == 4) {
			binary2[0] = 1;
			binary2[1] = 0;
			binary2[2] = 0;
		}
		else if (digit2 == 5) {
			binary2[0] = 1;
			binary2[1] = 0;
			binary2[2] = 1; 
		}
		else if (digit2 == 6) {
			binary2[0] = 1;
			binary2[1] = 1;
			binary2[2] = 0;
		}
		else {
			binary2[0] = 1;
			binary2[1] = 1;
			binary2[2] = 1; 
		}
		
		//digit 3
		if (digit3 == 0) {
			binary3[0] = 0;
			binary3[1] = 0;
			binary3[2] = 0;
		}
		else if (digit3 == 1) {
			binary3[0] = 0;
			binary3[1] = 0;
			binary3[2] = 1;
		}
		else if (digit3 == 2) {
			binary3[0] = 0;
			binary3[1] = 1;
			binary3[2] = 0;
		}
		else if (digit3 == 3) {
			binary3[0] = 0;
			binary3[1] = 1;
			binary3[2] = 1;
		}
		else if (digit3 == 4) {
			binary3[0] = 1;
			binary3[1] = 0;
			binary3[2] = 0;
		}
		else if (digit3 == 5) {
			binary3[0] = 1;
			binary3[1] = 0;
			binary3[2] = 1;
		}
		else if (digit3 == 6) {
			binary3[0] = 1;
			binary3[1] = 1;
			binary3[2] = 0;
		}
		else {
			binary3[0] = 1;
			binary3[1] = 1;
			binary3[2] = 1;
		}
		
		//digit 4
		if (digit4 == 0) {
			binary4[0] = 0;
			binary4[1] = 0;
			binary4[2] = 0;
		}
		else if (digit4 == 1) {
			binary4[0] = 0;
			binary4[1] = 0;
			binary4[2] = 1;
		}
		else if (digit4 == 2) {
			binary4[0] = 0;
			binary4[1] = 1;
			binary4[2] = 0;
		}
		else if (digit4 == 3) {
			binary4[0] = 0;
			binary4[1] = 1;
			binary4[2] = 1;
		}
		else if (digit4 == 4) {
			binary4[0] = 1;
			binary4[1] = 0;
			binary4[2] = 0;
		}
		else if (digit4 == 5) {
			binary4[0] = 1;
			binary4[1] = 0;
			binary4[2] = 1;
		}
		else if (digit4 == 6) {
			binary4[0] = 1;
			binary4[1] = 1;
			binary4[2] = 0;
		}
		else {
			binary4[0] = 1;
			binary4[1] = 1;
			binary4[2] = 1;
		}
		
		//convert binary reps. of ints 2-4 into rwx rep., this could be a method too
		
		//digit 2
		char[] letter2 = new char [3];
		if (binary2[0] == 1) letter2[0] = 'r';
		else if (binary2[0] == 0) letter2[0] = '-';
		
		if (binary2[1] == 1) letter2[1] = 'w';
		else if (binary2[1] == 0) letter2[1] = '-';
		
		if (binary2[2] == 1) letter2[2] = 'x';
		else if (binary2[2] == 0) letter2[2] = '-';
		
		//digit 3
		char[] letter3 = new char [3];
		if (binary3[0] == 1) letter3[0] = 'r';
		else if (binary3[0] == 0) letter3[0] = '-';
		
		if (binary3[1] == 1) letter3[1] = 'w';
		else if (binary3[1] == 0) letter3[1] = '-';
		
		if (binary3[2] == 1) letter3[2] = 'x';
		else if (binary3[2] == 0) letter3[2] = '-';
		
		//digit 4
		char[] letter4 = new char [3];
		if (binary4[0] == 1) letter4[0] = 'r';
		else if (binary4[0] == 0) letter4[0] = '-';
		
		if (binary4[1] == 1) letter4[1] = 'w';
		else if (binary4[1] == 0) letter4[1] = '-';
		
		if (binary4[2] == 1) letter4[2] = 'x';
		else if (binary4[2] == 0) letter4[2] = '-';

		
		//apply digit1's special permissions
		
		if (digit1 == 1){ //change letter2 x to s
			if(letter2[2] == 'x') letter2[2] = 's';
		}
		else if (digit1 == 2){ //change letter3 x to s
			if(letter3[2] == 'x') letter3[2] = 's';
		}
			
		else if (digit1 == 4){ //change letter4 x to t
			if(letter4[2] == 'x') letter4[2] = 't';
		}
			
		
		//print with correct formatting
		
		printIntArray(binary2); 
		System.out.print(" ");
		printIntArray(binary3);
		System.out.print(" ");
		printIntArray(binary4); 
		System.out.print(" and ");
		printCharArray(letter2);
		System.out.print(" ");
		printCharArray(letter3);
		System.out.print(" ");
		printCharArray(letter4);
		
		return " ";
	}
	
	static void printIntArray(int [] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		}
	}
	
	static void printCharArray(char [] p) {
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i]);
		}
	}
}
