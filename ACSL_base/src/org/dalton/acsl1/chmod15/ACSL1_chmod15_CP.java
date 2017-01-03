package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.text.*;

public class ACSL1_chmod15_CP {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/CHMOD";
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
		int specpermits = 0;
		int owner = 0;
		int group = 0;
		int others = 0;
		
		
		specpermits = Integer.parseInt(data[0]);
		owner = Integer.parseInt(data[1]);
		group = Integer.parseInt(data[2]);
		others = Integer.parseInt(data[3]);
		
		Integer.toBinaryString(owner);
		Integer.toBinaryString(group);
		Integer.toBinaryString(others);
		
		
		
		DecimalFormat ayy = new DecimalFormat();
		ayy.setMinimumIntegerDigits(3);
		System.out.println(ayy.format(owner) + " " + ayy.format(group) + " " + ayy.format(others) + " ");
		
		return "";
	}
}