package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * @author AryavPal
 * string15 ACSL
 */

public class ACSL2_string15_AP {
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
		System.out.print(s + "     ");
		return remDecP(fix(s));
	}
	static String fix(String input) {
		String[] data = input.split(", ");
		char[] expr = data[0].toCharArray();
		int nonDec = nonDecCount(data[0]);
		int length = Integer.parseInt(data[1]);
		int decLength = Integer.parseInt(data[2]);
		if(decLength + nonDec > length){ //if the input is completely bad
			int a = length - decLength;
			char[] ans = new char[length];
			for (int i = 0; i < ans.length; i++) {
				if(a!=0) {
					ans[i] = '#';
					a--;
				}
				if(a==0) {
					ans[i] = '.';
					a--;
				}
			}
			String ret = new String(ans);
			return ret;
		}
		if(decLength + nonDec < length){ //if the input asks for something too big
			int a = length - (nonDec + decLength);
			int b = a;
			char[] ans = new char[length];
			for (int i = 0; i < ans.length; i++) {
				if(a>0) {
					ans[i] = '#';
					a--;
				}
				else {
					ans[i] = expr[i-b];
				}
			}
			boolean t = false;
			int counter = decLength;
			int num = 0;
			for (int i = 0; i < expr.length; i++) {
				if(expr[i] == '.') t = true;
				if(t == true) counter--;
				if(counter==0) num = expr[i];
			}
			round(ans, num, length-1);
			String ret = new String(ans);
			return ret;
		}
		if(decLength + nonDec == length){ //if the input is just right :)
			char[] ans = new char[length];
			for (int i = 0; i < ans.length; i++) {
				ans[i] = expr[i];
				
			}
			round(ans, (int)expr[length] - 48, length-1);
			String ret = new String(ans);
			return ret;
		}
		return "failed";
	}
	static String remDecP(String input) {
		char[] fix = input.toCharArray();
		char[] change = new char[fix.length-1];
		String ret;
		if(fix[fix.length-1] == '.') {
				for (int i = 0; i < change.length; i++) {
					change[i] = fix[i];
				}
				ret = new String(change);
				return ret;
		}
		return input;
	}
	static int nonDecCount(String input) {
		char[] array = input.toCharArray();
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			counter = i;
			if(array[i] == '.') break;
		}
		return counter +1;
	}
	static void round(char[] ans, int adj, int fin) {
		int end = (int)(ans[fin]);
		if(adj >= 5) {
			ans[fin] = (char)(end + 1);
		}
		else if(adj < 5) {
			ans[fin] = (char)(end);
		}
	}
}

