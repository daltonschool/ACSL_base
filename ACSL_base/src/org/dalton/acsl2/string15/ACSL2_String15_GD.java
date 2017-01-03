package org.dalton.acsl2.string15;
import java.io.BufferedReader;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * ACSL String program 2015/2016
 * @GretchenDoyle
 *
 */

public class ACSL2_String15_GD {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "stringtest";
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
	
	
	static String solve(String s){
		String[] data = s.split(",[ ]*");
		String floatnum = data[0];
		int length = Integer.parseInt(data[1]);
		int decimal = Integer.parseInt(data[2]);
		char[] toolong = new char[length];
		//char[] justright = new char[length];
/**
		if(length > floatnum.length()){
			int dif = length - floatnum.length();
			
			char[] pound = new char[dif];
			for(int i=0; i < dif; i++){
				pound[i] = '#';
			}
			String p = pound.toString();
			
			
			
			
			for(int i = floatnum.length(); i > 0; i--){
			toolong[i + dif] = floatnum.charAt(i);
			}
			for(int i = dif; i > 0; i--){
				toolong[i] = '#';
			}
		
		}
		**/
		
		int l = length;
		char[] floatarray = new char[floatnum.length()];	      
		for(int i = 0; i < floatnum.length(); i++){
			floatarray[i] = new Character(floatnum.charAt(i));
		}
		
		char[] temp = new char[length];
		for(int i = 0; i < length; i++){
			temp[i] = floatarray[i];
		}
		
		if((floatarray[length]) >= 5){
			String u = String.valueOf(floatarray);
			char val = temp[temp.length-1];
			//System.out.println("floatarray: " + u);
			//System.out.println("floatarray[length]: " + floatarray[length]);
			//System.out.println("temp[temp.length-1]: " + temp[temp.length-1]);
			temp[temp.length-1]++;
		}
		else temp[temp.length-1] = temp[temp.length-1];
		

		
		
		
		
	

		
	
		//if(floatarray.length < length){
			
		//}
		//String output = String.valueOf(floatarray);
		//System.out.println("floatarray: " + output);
		String output1 = String.valueOf(temp);
		System.out.print(output1);
		
		String output2 = String.valueOf(toolong);
		System.out.print(output2);
		return "";
		
	}
}
