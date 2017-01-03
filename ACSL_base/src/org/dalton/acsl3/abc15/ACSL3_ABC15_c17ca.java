package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//haha this sucks see you for resubmission <3 :)
//luv compsci
//how is days of blood and starlight going hope its good


public class ACSL3_ABC15_c17ca {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/nil";
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
		
		String[] data = input.split(",[ ]*");
		int x1 = Integer.parseInt(data[0]);
		int x2 = Integer.parseInt(data[1]);
		int x3 = Integer.parseInt(data[2]);
		int x4 = Integer.parseInt(data[3]);
		int numberfound = Integer.parseInt(data[4]);
		for (int i = 1; i < 2*numberfound; i = i+2) {
			//char letterfound = 
			//int foundat =
			
		}
		
		
		
		return input;
	}
}
