package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ACSL3_ABC15_RF {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/abc_testdata";
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
		
		int[][] board = new int[4][4];
		String input = s;
		String[] data = input.split(",[ ]*");
		
		int filled = Integer.parseInt(data[0]);
		String type = data[1];
		int age = Integer.parseInt(data[2]);
		double weight = Double.parseDouble(data[3]);
		
		
		return s;
	}
}
