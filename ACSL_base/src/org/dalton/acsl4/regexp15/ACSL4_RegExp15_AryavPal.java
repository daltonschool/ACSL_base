package org.dalton.acsl4.regexp15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ACSL4_RegExp15_AryavPal {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/aryavtes";
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
		String[] base = new String[10];
		String a = scan.nextLine();
		if(parse(a).length == 10) base = parse(a);
		while(scan.hasNext()) {
			String answer = solve(scan.nextLine(), base);
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}
		fop.flush();
		fop.close();
		scan.close();
	}
	static String solve(String s, String [] base) {
		String b = "";
		if(parse(s).length != 10) {
			for (int i = 0; i < base.length; i++) {
				if(base[i].matches(s)) b = b + base[i] + ", ";
			}
		}
		char[] x = b.toCharArray();
		char[] y = new char[x.length-2];
		for (int i = 0; i < y.length; i++) {
			y[i] = x[i];
		}
		String a = new String(y);
		return a;
	}
	static String[] parse(String s) {
		String[] data = s.split(",[ ]");
		return data;
	}
}