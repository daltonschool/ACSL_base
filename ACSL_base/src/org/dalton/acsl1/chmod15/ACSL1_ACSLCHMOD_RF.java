package org.dalton.acsl1.chmod15;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * @ author = Robert Freitag
 * Test Data:
 * input: 1, 7, 3, 4
 * output: 111 011 100 and rws -wx r-- 
 * input: 0, 1, 2, 3
 * output: 001 010 011 and --x -w- -wx 
 */

public class ACSL1_ACSLCHMOD_RF {
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

	static String solve(String s) {
		String input = s;
		String[] data = input.split(",[ ]*");
		
		int oct1 = Integer.parseInt(data[1]);
		int oct2 = Integer.parseInt(data[2]);
		int oct3 = Integer.parseInt(data[3]);
		
		String bin1 = "";
		String bin2 = "";
		String bin3 = "";
		
		//owner
		if(oct1 == 0){
			bin1 = "000 ";
		}
		if(oct1 == 1){
			bin1 = "001 ";
		}
		if(oct1 == 2){
			bin1 = "010 ";
		}
		if(oct1 == 3){
			bin1 = "011 ";
		}
		if(oct1 == 4){
			bin1 = "100 ";
		}
		if(oct1 == 5){
			bin1 = "101 ";
		}
		if(oct1 == 6){
			bin1 = "110 ";
		}
		if(oct1 == 7){
			bin1 = "111 ";
		}
		
		//group
		if(oct2 == 0){
			bin2 = "000 ";
		}
		if(oct2 == 1){
			bin2 = "001 ";
		}
		if(oct2 == 2){
			bin2 = "010 ";
		}
		if(oct2 == 3){
			bin2 = "011 ";
		}
		if(oct2 == 4){
			bin2 = "100 ";
		}
		if(oct2 == 5){
			bin2 = "101 ";
		}
		if(oct2 == 6){
			bin2 = "110 ";
		}
		if(oct2 == 7){
			bin2 = "111 ";
		}
		
		//others
		if(oct3 == 0){
			bin3 = "000 ";
		}
		if(oct3 == 1){
			bin3 = "001 ";
		}
		if(oct3 == 2){
			bin3 = "010 ";
		}
		if(oct3 == 3){
			bin3 = "011 ";
		}
		if(oct3 == 4){
			bin3 = "100 ";
		}
		if(oct3 == 5){
			bin3 = "101 ";
		}
		if(oct3 == 6){
			bin3 = "110 ";
		}
		if(oct3 == 7){
			bin3 = "111 ";
		}
		
		
		String bin_order = bin1 + bin2 + bin3; // binary output of octal input
		
		char[] bin1_array = bin1.toCharArray(); // puts bin output to char array
		char[] bin2_array = bin2.toCharArray();
		char[] bin3_array = bin3.toCharArray();
		
		String first1 = null;
		String first2 = null;
		String first3 = null;
		
		//owner r/w/x
		for (int i = 0; i < bin1_array.length; i++) {
			if(bin1_array[0] == '1'){
				first1 = "r";
			}
			else{
				first1 = "-";
			}
			if(bin1_array[1] == '1'){
				first2 = "w";
			}
			else{
				first2 = "-";
			}
			if(bin1_array[2] == '1'){
				first3 = "x";
			}
			else{
				first3 = "-";
			}
		}
		
		String second1=null;
		String second2=null;
		String second3=null;
		
		//group r/w/x
		for (int i = 0; i < bin2_array.length; i++) {
			if(bin2_array[0] == '1'){
				second1 = "r";
			}
			else{
				second1 = "-";
			}
			if(bin2_array[1] == '1'){
				second2 = "w";
			}
			else{
				second2 = "-";
			}
			if(bin2_array[2] == '1'){
				second3 = "x";
			}
			else{
				second3 = "-";
			}
		}
		
		String third1=null;
		String third2=null;
		String third3=null;
		
		//others r/w/x
		for (int i = 0; i < bin3_array.length; i++) {
			if(bin3_array[0] == '1'){
				third1 = "r";
			}
			else{
				third1 = "-";
			}
			if(bin3_array[1] == '1'){
				third2 = "w";
			}
			else{
				third2 = "-";
			}
			if(bin3_array[2] == '1'){
				third3 = "x";
			}
			else{
				third3 = "-";
			}
		}
		
		String output1 = first1 + first2 + first3 + " ";
		String output2 = second1 + second2 + second3 + " ";
		String output3 = third1 + third2 + third3 + " ";
		
		String output = "";
		int fourth = Integer.parseInt(data[0]);
		
		//does the fourth special changes
		if(fourth == 0){
			output = bin_order + "and " + output1 + output2 + output3;
		}
		if(fourth == 1){
			output = bin_order + "and " + output1.replace('x', 's') + output2 + output3;
		}
		if(fourth == 2){
			output = bin_order + "and " + output1 + output2.replace('x', 's') + output3;
		}
		if(fourth == 4){
			output = bin_order + "and " + output1 + output2 + output3.replace('x', 't');
		}
			
		return output;
	}
}
