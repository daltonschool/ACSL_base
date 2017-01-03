package org.dalton.acsl4.regexp15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ACSL4_REGEXP15_MD {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/expTEST";
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
			String[] data = new String[6];
			for (int i = 0; i < data.length; i++) {
				data[i] = scan.nextLine();
			}
			String[] answer = solve(data);
			System.out.println(answer[1] + "\n" + answer[2] + "\n" + answer[3] + "\n" + answer[4] + "\n" + answer[5]);
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
	static String[] solve(String[] s) {
		//parse through first line to get the values of the ten strings
		//make '#' in the string empty
		String[] tenStrings = s[0].split(", ");
		for (int i = 0; i < tenStrings.length; i++) {
			if (tenStrings[i].charAt(0) == '#') tenStrings[i] = "";
		}

		String regExpOne = s[1];
		String regExpTwo = s[2];
		String regExpThree = s[3];
		String regExpFour = s[4];
		String regExpFive = s[5];

		String[] answer = new String[6];

		answer[1] = finish(tenStrings,regExpOne);
		answer[2] = finish(tenStrings,regExpTwo);
		answer[3] = finish(tenStrings,regExpThree);
		answer[4] = finish(tenStrings,regExpFour);
		answer[5] = finish(tenStrings,regExpFive);

		return answer;

	}

	static String finish(String[] values, String regExp) {

		Pattern p = Pattern.compile(regExp);
		String fin = "";
		boolean matchedYet = false;

		for (int i = 0; i < values.length; i++) {
			Matcher m = p.matcher(values[i]);
			if (m.matches() == true && matchedYet == false) {
				if (values[i].isEmpty()) fin = fin.concat("#");
				fin = fin.concat(values[i]);
				matchedYet = true;
			}
			else if (matchedYet == true && m.matches() == true) {
				if (values[i].isEmpty()) fin = fin.concat(", " + "#");
				else fin = fin.concat(", " + values[i]);
			}
		}

		if (fin.isEmpty()) fin = "NONE";

		return fin;
	}
}

