package org.dalton.acsl1.chmod15;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ACSL1_chmod15_AC {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/chmoddata";
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
		int permissions = Integer.parseInt(data[0]);
		String binstore = "";
		String permstore = "";
		for (int i = 1; i < data.length; i++) {
			//i = 1 --> owner, i = 2 --> group, i = 3 --> others
			int convert = Integer.parseInt(data[i]);
			String binconvert = Integer.toString(convert,2);
			String permconvert = "";
			if(Integer.parseInt(binconvert) < 2) binconvert = "00" + binconvert;
			else if(Integer.parseInt(binconvert) < 12) binconvert = "0" + binconvert;
			if(binconvert.charAt(0) == '0') permconvert += "-";
			else if(binconvert.charAt(0) == '1') permconvert += "r";
			if(binconvert.charAt(1) == '0')	permconvert += "-";
			else if(binconvert.charAt(1) == '1') permconvert += "w";
			if(binconvert.charAt(2) == '0') permconvert += "-";
			else if(binconvert.charAt(2) == '1'){
				if(i == 1 && permissions == 1) permconvert += "s";
				else if(i == 2 && permissions == 2) permconvert += "s";			
				else if(i == 3 && permissions == 4)	permconvert += "t";
				else permconvert += "x";
			}
			binstore += binconvert + " ";
			permstore += permconvert + " ";
		}
		return binstore + "and " + permstore;
	}
}  