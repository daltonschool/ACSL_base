package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Davis Haupt
 * ACSL 1 - CHMOD
 * 
 * 1/6/16
 * 
 */
public class ACSL1_chmod15_DH {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/chmod15";
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
		int[] a = new int[args.length];
		
		for (int i = 0; i < args.length; i++)
			a[i] = Integer.parseInt(args[i]);
		
		String solution = "";
		solution = solution + octalToBinary(a[1]) + " " + octalToBinary(a[2]) + " " + octalToBinary(a[3]);
		solution = solution + " and ";
		if (args.length == 4)
			solution = solution + getPermString(octalToBinary(a[1]), a[0] == 1) + " " + getPermString(octalToBinary(a[2]), a[0] == 2) + " " + getPermString(octalToBinary(a[3]), a[0] == 4);
		if (solution.charAt(solution.length()-1) == 's')
			solution = solution.substring(0, solution.length()-1) + 't';
		return solution;
	}
	
	static String octalToBinary(int o) {
		switch(o) {
		case 0:
			return "000";
		case 1:
			return "001";
		case 2:
			return "010";
		case 3:
			return "011";
		case 4:
			return "100";
		case 5:
			return "101";
		case 6:
			return "110";
		case 7:
			return "111";
		default:
			return "";
		}
	}
	static String getPermString(String o, boolean special) {
		StringBuffer s = new StringBuffer("---");
		if (o.charAt(0) == '1') s.setCharAt(0, 'r');
		if (o.charAt(1) == '1') s.setCharAt(1, 'w');
		if (o.charAt(2) == '1') {
			if (special)
				s.setCharAt(2, 's');
			else
				s.setCharAt(2, 'x');
		}
		
		return s.toString();
	}
}
