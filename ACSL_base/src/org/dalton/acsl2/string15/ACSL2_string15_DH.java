package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;

public class ACSL2_string15_DH {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/string15";
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
		String[] args = s.split(", ?");

		String num = args[0];
		int len = Integer.parseInt(args[1]);
		int dec = Integer.parseInt(args[2]);
		char first = num.charAt(0);

		Pattern p = Pattern.compile("([\\+\\-]?)([0-9]+)\\.([0-9]+)");
		Matcher m = p.matcher(num);

		if (m.matches()) {
			String sign = m.group(1);
			String number = m.group(2);
			String decimal = m.group(3);

			if (number.length() > len - (dec+1))
				return repeat("#", len - (dec + 1)) + "." + repeat("#", dec);

			if (decimal.length() > dec && dec > 0) {
				int d = Integer.parseInt(decimal.substring(0, dec));
				if (decimal.charAt(dec) - 48 >= 5) // round up
					d += 1;

				decimal = new Integer(d).toString();
			}
			String result;
			if (dec > 0)
				 result = sign + number + "." + decimal;
			else
				 result = sign + number;
			if (result.length() < len) {
				result = repeat("#", len - result.length()) + result;
			}
			
			return result;
		}
		return "";
	}

	static String repeat(String s, int num) {
		StringBuffer r = new StringBuffer();
		for (int i = 0; i < num; i++)
			r = r.append(s);

		return r.toString();
	}
}
