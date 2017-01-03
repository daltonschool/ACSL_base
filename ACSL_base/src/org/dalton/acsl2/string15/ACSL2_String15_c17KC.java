package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;


public class ACSL2_String15_c17KC {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/TestThis";
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
	static String solve(String s) {
		String[] data = s.split(",[ ]*");
		String str = data[0];
		int length = Integer.parseInt(data[1]);
		int decimal = Integer.parseInt(data[2]);
		int sign = 0;
		
		if(str.contains ("+")){
			sign = 1;
			System.out.print("+");
		}
		else if (str.contains ("-")){
			sign = 2;
		}
		
		 double strDouble = Double.parseDouble(str);
		 
		 DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(decimal);
			df.setMinimumIntegerDigits(0);
			df.setMaximumIntegerDigits(length);
			
			df.setRoundingMode(RoundingMode.HALF_UP);
			df.format(strDouble);
			System.out.println(df.format(strDouble));
			System.out.println("length" + length);
			
			String Backstr = String.valueOf(df.format(strDouble));
		
			
			char[] strDoubleARR = Backstr.toCharArray();
			System.out.println("str" + strDoubleARR.length);
		
			//equal with no plus sign
			if(strDoubleARR.length==length){
				System.out.println(df.format(strDouble));
				System.out.println("first pass");
			}
			//too short
			else if(strDoubleARR.length>length){
			for (int i = 0; i < length; i++) {
				if(i==(length-decimal-1)){
					System.out.print(".");
				}
				else{
					System.out.print("#");
				}
			}
		}
		//hard part, if longer
		else if(strDoubleARR.length<length){
			int diff = length-strDoubleARR.length;
			char[] Array;
			Array = new char[diff+length];
			for (int i = 0; i < diff; i++) {
				Array[i]='#';
				System.out.print(Array[i]);
			}
			System.out.println(df.format(strDouble));
			
		}
			
		else if(strDoubleARR.length==length-1){
				System.out.println("+" + df.format(strDouble));
				System.out.println("first pass 2");
		}
			

		else{
			System.out.println("You screwed up kyle");
		}
	
		return "";
	}

}
