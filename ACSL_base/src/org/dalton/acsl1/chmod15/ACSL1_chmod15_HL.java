package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ACSL1_chmod15_HL {

	/**
	 * Hannah Labow
	 * ASCL Program #1
	 * CHMOD
	 * 
	 * 
	 */

	//declarations:

	public static void main(String[] args) throws IOException {	
		//declarations:
		String filein = "modtest1/";
		Scanner scan;
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			//switch to regular terminal input
			scan = new Scanner(System.in);
		}
	}
	static String solve(String s){
		String[] data = s.split(" ,[]*");
		int input1 = Integer.parseInt(s);
		int input2 = Integer.parseInt(s);
		int input3 = Integer.parseInt(s);
		String conBin1 = "";
		String conBin2 = "";
		String conBin3 = "";
		String sol = "";

		for (int i = 0; i <= 7; i++) {
			if(input1==0) conBin1 = "000";
			if(input1==1) conBin1 = "001";
			if(input1==2) conBin1 = "010";
			if(input1==3) conBin1 = "011";
			if(input1==4) conBin1 = "100";
			if(input1==5) conBin1 = "101";
			if(input1==6) conBin1 = "110";
			if(input1==7) conBin1 = "111";

			if(input2==0) conBin2 = "000";
			if(input2==1) conBin2 = "001";
			if(input2==2) conBin2 = "010";
			if(input2==3) conBin2 = "011";
			if(input2==4) conBin2 = "100";
			if(input2==5) conBin2 = "101";
			if(input2==6) conBin2 = "110";
			if(input2==7) conBin2 = "111";

			if(input3==0) conBin3 = "000";
			if(input3==1) conBin3 = "001";
			if(input3==2) conBin3 = "010";
			if(input3==3) conBin3 = "011";
			if(input3==4) conBin3 = "100";
			if(input3==5) conBin3 = "101";
			if(input3==6) conBin3 = "110";
			if(input3==7) conBin3 = "111";
		}

		System.out.println("1. " + conBin1 + conBin2 + conBin3 + " and " );
		return s;

	}
			String read = "r";
			String non = "-";
			String execute = "x";
			String st = "s";
			String to = "t";
			String dub= "w";
			
			String res = "";
	
}

