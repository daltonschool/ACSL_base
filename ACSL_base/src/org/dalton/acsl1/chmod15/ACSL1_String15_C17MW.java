package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ACSL1_String15_C17MW {


	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/ACSLString";
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

		String input = s;
		Scanner scan = new Scanner(new ByteArrayInputStream(input.getBytes()));
		scan.useDelimiter(",[ ]*");




		String val = scan.next();
		char[] val1 = val.toCharArray();

		List o = new ArrayList();

		System.out.print(val1);


		int p = scan.nextInt();
		int j = scan.nextInt();

		System.out.println(" "+  p + " " + j);

		for (int i = 0; i < val1.length; i++) {
			o.add(val1[i]);

			if(o.size() == p-1){
				break;
			}
		}

		System.out.println(o);
		return "";
	}
}

