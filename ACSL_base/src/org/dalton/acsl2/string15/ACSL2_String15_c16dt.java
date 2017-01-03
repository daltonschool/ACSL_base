package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ACSL2_String15_c16dt {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/String15fewafe";
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
		
		String[] input = s.split(",[ ]*");
		int lengthCount = Integer.parseInt(input[1]);
		int decCount = Integer.parseInt(input[2]);
		
		String prefix = "";
		String num = input[0];
		
		DecimalFormat df = new DecimalFormat();
		
		if(num.charAt(0)=='+') {
			prefix = "+";
			lengthCount--;
			num = num.substring(1);
		}
		else if (num.charAt(0)=='-') {
			prefix = "-";
			lengthCount--;
			num = num.substring(1);
		}
		
		int idx = num.indexOf('.');
		String before = "";
		String after = "";
		if (idx == -1) before = num;
		else {
			before = num.substring(0, idx);
			after = num.substring(idx+1);
		}
		
		df.setMinimumFractionDigits(decCount);
		df.setMaximumFractionDigits(decCount);
		df.setRoundingMode(RoundingMode.HALF_UP);
		df.setMaximumIntegerDigits(0);
		after = df.format(Double.parseDouble("."+(after.equals("")?"0":after))).substring(1);

		if (decCount != 0) lengthCount -= (decCount + 1);
		
		// length of before---- \/
		
		
		if (lengthCount < before.length()) {
			before = "";
			for (int i = 0; i < lengthCount; i++) before += "#";
			after = "";
			for (int i = 0; i < decCount; i++) after += "#";
		}
		
		String padding = "";
		if (lengthCount > before.length()) for (int i = lengthCount-before.length(); i > 0; i--) padding += "#";
		
		String out = prefix + padding + before;
		if (decCount != 0) out += "." + after;
		
		return out;
	}
}
