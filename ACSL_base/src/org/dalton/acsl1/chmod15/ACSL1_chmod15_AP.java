package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/*
 * Aryav Pal
 * ACSL chmod
 */

public class ACSL1_chmod15_AP {
	public static void main(String[] args) throws IOException {
		parseToForm("4, 5, 6, 7");
		//declarations:
		String filein = "testdata/chmodAP";
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
		return parseToForm(s);
	}
	public static String parseToForm(String input) {
		String[] data = input.split(",[ ]*");
		String one = octToBin(data[1]);
		String two = octToBin(data[2]);
		String three = octToBin(data[3]);
		String ret = "something went wrong";
		if(data[0].equals("0")) {
			char[] a = partTwo(one);
			char[] b = partTwo(two);
			char[] c = partTwo(three);
			ret = (one + " " + two + " " + three + " " + "and " + newString(a, b, c));
		}
		if(data[0].equals("1")) {
			char[] a = partTwo(one, data[0]);
			char[] b = partTwo(two);
			char[] c = partTwo(three);
			ret =(one + " " + two + " " + three + " " + "and " + newString(a, b, c));
		}
		if(data[0].equals("2")) {
			char[] a = partTwo(one);
			char[] b = partTwo(two, data[0]);
			char[] c = partTwo(three);
			ret = (one + " " + two + " " + three + " " + "and " + newString(a, b, c));
		}
		if(data[0].equals("4")) {
			char[] a = partTwo(one);
			char[] b = partTwo(two);
			char[] c = partTwo(three, data[0]);
			ret = (one + " " + two + " " + three + " " + "and " + newString(a, b, c));
		}
		return ret;
	}
	public static String octToBin(String input) {
		int i = Integer.parseInt(input,8);
		String s = Integer.toBinaryString(i);
		int g = Integer.parseInt(s);
		return String.format("%03d",g);
	}
	public static char[] partTwo(String input){
		char[] data = input.toCharArray();
		char[] answer = new char[]{'0', '0', '0'};
		if(data[0]=='1') answer[0] = 'r';
		else answer[0] = '-';
		if(data[1] == '1') answer[1] = 'w';
		else answer[1] = '-';
		if(data[2] == '1') answer[2] = 'x';
		else answer[2] = '-';
		return answer;
	}
	public static char[] partTwo(String input, String determiner) {
		char[] data = input.toCharArray();
		char[] answer = new char[]{'0', '0', '0'};
		if(determiner.equals("0")){
			if(data[0]=='1') answer[0] = 'r';
			else answer[0] = '-';
			if(data[1] == '1') answer[1] = 'w';
			else answer[1] = '-';
			if(data[2] == '1') answer[2] = 'x';
			else answer[2] = '-';
		}
		if(determiner.equals("1") || determiner.equals("2")){
			if(data[0]=='1') answer[0] = 'r';
			else answer[0] = '-';
			if(data[1] == '1') answer[1] = 'w';
			else answer[1] = '-';
			if(data[2] == '1') answer[2] = 's';
			else answer[2] = '-';
		}
		if(determiner.equals("4")){
			if(data[0]=='1') answer[0] = 'r';
			else answer[0] = '-';
			if(data[1] == '1') answer[1] = 'w';
			else answer[1] = '-';
			if(data[2] == '1') answer[2] = 't';
			else answer[2] = '-';
		}
		return answer;
	}
	public static String newString(char[] a, char[] b, char[] c){
		String res =  new String(a) + " " + new String(b) + " " + new String(c);
		return res;
	}
}
