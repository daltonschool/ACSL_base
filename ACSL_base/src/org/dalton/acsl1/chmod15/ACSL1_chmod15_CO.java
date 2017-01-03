package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



/**
 * 
 * @author Charlotte Ohana
 *
 *https://www.daniweb.com/programming/software-development/threads/364010/convert-octal-to-binary
 *
 *
 *
 *
 */
public class ACSL1_chmod15_CO {

	public static void main(String[] args) throws IOException {

		String filein = "testdata/chmod15Test";
		Scanner scan;
		//	FileOutputStream fop = null;

		/**
		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			scan = new Scanner(System.in);
		}

		String answer = null; 
		while(scan.hasNext()) {
			answer = solve(scan.nextLine());
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}
		fop.flush();
		fop.close();
		scan.close();
	}
	public static String solve (String s) {
		String input = s;
		Scanner scan = new Scanner(new ByteArrayInputStream(input.getBytes())); 
		scan.useDelimiter(",[ ]*");
		return "\n";
		 **/

		//convert octal to binary
		//scan = new Scanner(new BufferedReader(new FileReader(filein)));
		//fop = new FileOutputStream(new File(filein+"-out"));
		//scan = new Scanner(System.in);

	}
	//convert octal to binary
	public static String solve (String s) {
		String result = "";
		Scanner input = new Scanner(System.in);
		Scanner scan = new Scanner(System.in); 
		scan.useDelimiter(",[ ]*");
		String OctStr;
		char c;
		int num = 0;
		String biArray[]={"000", "001", "010", "011", "100", "101", "110", "111"};
		int j, n;
		OctStr = input.nextLine();


		for (int i = 0; i < OctStr.length(); i++) {
			c = OctStr.charAt(0);

			for (j=0+1; j<c; j++) {
				n = Character.getNumericValue(c);
				if(n <8)	
				{
					biArray[0] = "000";
					biArray[1] = "001";
					biArray[2] = "010";
					biArray[3] = "011";
					biArray[4] = "100";
					biArray[5] = "101";
					biArray[6] = "110";
					biArray[7] = "111";


				}
			}
		}
		
		return result;
	}
}



