package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ASCL2_String15_KS {
		public static void main(String[] args) throws IOException {
			//declarations:
			String filein = "testdata/kevdata";
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
		String[] data = s.split(",[ ]*");
		String first = data[0];
		int desiredlength = Integer.parseInt(data[1]);
		int decimal = Integer.parseInt(data[2]);
		
		//splitting -523.125 at every character
		String[] firstfirst = first.split("(?<!^)");
		
		//determining the sign of the sample output 
		if(firstfirst[0].equals("-")){
			System.out.print("-");
			
		
		}
		else if(firstfirst[0].equals("+")){
			System.out.print("+");
		}
		else{
			System.out.print("");
		}
		
		//making the int if theres a sign in the front
		//int[] k = new int[firstfirst.length-1];
		StringBuilder strNum = new StringBuilder();
		for (int i = 1; i < firstfirst.length-1; i++) {
			strNum.append(firstfirst[i]);	
		}
		int finalint = Integer.parseInt(strNum.toString());
		
		//System.out.println(first.length()); Printing the length of the float 
		
		
//		String[] output = new String[desiredlength];
//		for (int i = desiredlength-1; i >= 0; i--) {
//			
//		}
//		if(first.length()>desiredlength){
//			System.out.println("");
//		}
		
		
		
		
		
		//return "" + first+ " " + firstdata[0] + " " + firstfirst[0];
		return " " + finalint;
	}


}
