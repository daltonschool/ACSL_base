package org.dalton.acsl4.regexp15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;


/*
 * first line of input: store it 
 */

public class ACSL4_regex15_JS {

	public static void main(String[] args)  throws IOException {
		//declarations:
		String filein = "testdata/ ";
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
		int size = data.length-1;
		
		String pattern = "";
		
		boolean matches = Pattern.matches(pattern, input);
		
		return s;

	}

}
