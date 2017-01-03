package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ACSL2_String15_AC {


	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/stringdata";
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
		//parse functions:
		String[] data = s.split(",[ ]*");
		String[] floatexp = data[0].toString().split("\\.[ ]*");
		String unit = floatexp[0]; String decimal = "." + floatexp[1]; 
		String length = data[1]; String declength = data[2]; 
		//parse test:
		System.out.println();
		System.out.println(s);
		System.out.println("unit:" + unit);
		System.out.println("decimal:" + decimal);
		System.out.println("length:" + length);
		System.out.println("declength:" + declength);

		String returnvar = "";

		int finalunitlength = Integer.parseInt(length) - (Integer.parseInt(declength) + 1);
		if(unit.length() > finalunitlength){
			//replace all numbers with #
			for (int i = 0; i < finalunitlength; i++) {
				returnvar += "#";
			}
			returnvar += ".";
			for (int i = 0; i < Integer.parseInt(declength); i++) {
				returnvar += "#";
			}
			System.out.println("Ret: " + returnvar);
		}
		else{

			String rawdf = ".";
			for (int i = 0; i < Integer.parseInt(declength); i++) {
				rawdf += "#";
			}
			
			DecimalFormat df = new DecimalFormat(rawdf);
			df.setRoundingMode(RoundingMode.HALF_UP);
			String rounddecimal = df.format(Double.parseDouble(decimal));
			System.out.println(rounddecimal);
			returnvar = unit + rounddecimal;
			System.out.println(df.getRoundingMode());
			System.out.println("Ret: " + returnvar);
		}
		return "";
	}
}
