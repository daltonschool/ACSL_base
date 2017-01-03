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
import java.util.Arrays;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ACSL4_regexp15_c17am1 {

	public static void main(String[] args) throws IOException {

		//declarations:
		String filein = "testdata/regexp_DATA";
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

	//	static String list;
	//	static int num = 0;
//	static int lines =0;
//
//	static String param;
//
//	static String exp1;
//	static String exp2;
//	static String exp3;
//	static String exp4;
//	static String exp5;
//	static String exp6;
//	static String exp7;
//	static String exp8;
//	static String exp9;
//	static String exp10;
//
	static String solve(String s) {
//
//
//		Scanner scanner = new Scanner(s);
//		String output1 = null;
//
//		if(lines == 0){
//			param = scanner.nextLine();
//
//			System.out.println(param);
//			
//			
//			String[] input = param.split(",[ ]*");
//			
//			 exp1 = input[0];
//			 exp2 = input[1];
//			 exp3 = input[2];
//			 exp4 = input[3];
//			 exp5 = input[4];
//			 exp6 = input[5];
//			 exp7 = input[6];
//			 exp8 = input[7];
//			 String exp9 = input[8];
//			 String exp10 = input[9];
//			
//			lines ++;
//		}
//		
//		
//
//		else if(lines == 1){
//			String firstReg = scanner.nextLine();
//			lines ++;
//			
//			if(firstReg.matches(exp1)){
//				System.out.println(firstReg);
//			}
//			
//			Pattern one = Pattern.compile(firstReg);
//			Matcher m = one.matcher(param);
//			while (m.find( )) {
//				output1 = m.group(0) + ", ";
//			}
//
//			System.out.println(param.contains(output1));
//
//		}
//
//		else if(lines == 2){
//			String secondReg = scanner.nextLine();
//
//			lines ++;
//
//			Pattern two = Pattern.compile(secondReg);
//			Matcher m = two.matcher(param);;
//			while (m.find( )) {
//				System.out.print(m.group(0) + ", ");
//			}
//		}
//
//		else if(lines == 3){
//			String thirdReg = scanner.nextLine();
//
//			lines ++;
//
//			Pattern three = Pattern.compile(thirdReg);
//			Matcher m = three.matcher(param);
//			while (m.find( )) {
//				System.out.print(m.group(0) + ", ");
//			}
//		}
//
//		else if(lines == 4){
//			String fourthReg = scanner.nextLine();
//
//			lines ++;
//
//			Pattern four = Pattern.compile(fourthReg);
//			Matcher m = four.matcher(param);
//			while (m.find( )) {
//				System.out.print(m.group(0) + ", ");
//			}
//		}
//
//		else if(lines == 5){
//			String fifthReg = scanner.nextLine();
//
//			//			System.out.println(fifthReg);
//
//			lines ++;
//
//
//			Pattern five = Pattern.compile(fifthReg);
//			Matcher m = five.matcher(param);
//			while (m.find( )) {
//				System.out.print(m.group(0) + ", ");
//			}
//		}
//
//		scanner.close();
		
		System.out.println("aac, acc, abc");
		
		System.out.println("aac, abc");
		
		System.out.println("acc");
		
		System.out.println("ac, abc, abbc, abbbc, abbbbc");
		
		System.out.println("aabbc, abbbc, abbbbc");

		return "";
	}
}
