package org.dalton.acsl1.chmod15;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;


public class ACSL_chmod15_JF {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/TITLEYEAR";
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
		String input = s;
		String[] data = input.split(",[ ]*"); //get all of the letters
		int special = Integer.parseInt(data[0]);
		int[] length = new int[4];
		String[] groups = new String[4];
		DecimalFormat a = new DecimalFormat("###");
		for(int i = 1; i < 4; i++){
			length[i] = Integer.parseInt(data[i]);
		}
		for(int i = 1; i < 4; i++){
			data[i] = String.format("%3s", Integer.toBinaryString(length[i])).replace(" ", "0");
		}
		System.out.print(data[1]);
		System.out.print(" " + data[2]);
		System.out.print(" " + data[3]);
		for(int i = 1; i < 4; i++){
			if(data[i].equals("101")){
				groups[i] = "r-x";
			}
			if(data[i].equals("111")){
				groups[i] = "rwx";
			}
			else if(data[i].equals("101")){
				groups[i] = "r-x";
			}
			else if(data[i].equals("100")){
				groups[i] = "r--";
			}
			else if(data[i].equals("110")){
				groups[i] = "rw-";
			}
			else if(data[i].equals("001")){
				groups[i] = "--x";
			}
			else if(data[i].equals("010")){
				groups[i] = "-w-";
			}
			else if(data[i].equals("000")){
				groups[i] = "---";
			}
			else if(data[i].equals("011")){
				groups[i] = "-wx";
			}
		}
		if(special == 1){
		groups[1] = groups[1].replaceAll("x", "s");
		}
		if(special == 2){
		groups[2] = groups[2].replaceAll("x", "s");
		}
		if(special == 4){
		groups[3] = groups[3].replaceAll("x", "t");
		}
		System.out.print(" and " + groups[1]);
		System.out.print(" " + groups[2]);
		System.out.print(" " + groups[3]);

		return " ";
	}

}
