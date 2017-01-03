package org.dalton.acsl4.regexp15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class ACSL4_RegExp_AC {


	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/regexpdata";
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
	/**TODO: 
	 * 1) make the 1st inputed item the list to search thru
	 * 2) take the items 2-6 as a "all star regex expression" string (not real regex)
	 * 3) convert to real regex?????
	 * 4) use that regex string to search thru the list
	 * 5) if anything falls under that expression, add it to the output string
	 * 6) loop from 2-6
	 * 
	 * DONE
	 * ok, uhh is there anything with #?
	 */

	//global dec:
	static String reglist;
	static int solvecount = 0;
	
	static String solve(String s) {
		if(solvecount == 0){
			reglist = s;
		}
		if(solvecount > 0){
			String regexp = s;
			String[] data = reglist.split(",[ ]*");
			String lineoutput = "";
			for (int i = 0; i < data.length; i++) {
				if(data[i].matches(regexp)) lineoutput +=  data[i] + ", ";
			}
			if(lineoutput.length()>0) return lineoutput.substring(0, lineoutput.length()-2);
			else return "NONE";
		}
		solvecount++; return "";
	}
}