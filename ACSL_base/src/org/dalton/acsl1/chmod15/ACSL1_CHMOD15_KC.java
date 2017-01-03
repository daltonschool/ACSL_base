package org.dalton.acsl1.chmod15;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ACSL1_CHMOD15_KC {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/TestThis";
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
	 * Author @KyleChu
	 * CHMOD
	 * 
	 * 
	 * solve for a specific input
	 * @param s the input
	 * @return the output
	 */
	static String solve(String s) {
		String[] data = s.split(",[ ]*");
		int sp = Integer.parseInt(data[0]);
		int a = Integer.parseInt(data[1]);
		int b = Integer.parseInt(data[2]);
		int c = Integer.parseInt(data[3]);
		
//		//if permissions
		String p1 = null; 
		String p2 = null;
		String p3 = null;
		
		//To String
		String A = null;
		String B = null;
		String C = null;
		
		
		//cases for a
		if (a == 0) A = String.format("%3s", Integer.toBinaryString(a)).replace(' ', '0');
		else if(a == 1) A = String.format("%3s", Integer.toBinaryString(a)).replace(' ', '0');
		else if(a == 2) A = String.format("%3s", Integer.toBinaryString(a)).replace(' ', '0');
		else if(a == 3) A = String.format("%3s", Integer.toBinaryString(a)).replace(' ', '0');
		else if(a == 4) A = String.format("%3s", Integer.toBinaryString(a)).replace(' ', '0');
		else if(a == 5) A = String.format("%3s", Integer.toBinaryString(a)).replace(' ', '0');
		else if(a == 6) A = String.format("%3s", Integer.toBinaryString(a)).replace(' ', '0');
		else if(a == 7) A = String.format("%3s", Integer.toBinaryString(a)).replace(' ', '0');
		
		//ZERO
		if(a==0) p1 = "---";
		
		//normal cases
		else if(a==1 && sp != 1) p1 = "--x";
		else if(a==2) p1 = "-w-";
		else if(a==3 && sp != 1) p1 = "-wx";
		else if(a==4) p1 = "r--";
		else if(a==5 && sp != 1) p1 = "r-x";
		else if(a==6) p1 = "rw-";
		else if(a==7 && sp != 1) p1 = "rwx";
		
		//cases for changing x to s
		if(a==1 && sp==1) p1 = "--s";
		else if(a==3 && sp==1) p1 = "-ws";
		else if(a==5 && sp==1) p1 = "r-s";
		else if(a==7 && sp==1) p1 = "rws";
				

		//Cases for B
		
		if (b == 0) B = String.format("%3s", Integer.toBinaryString(b)).replace(' ', '0');
		else if(b == 1) B = String.format("%3s", Integer.toBinaryString(b)).replace(' ', '0');
		else if(b == 2) B = String.format("%3s", Integer.toBinaryString(b)).replace(' ', '0');
		else if(b == 3) B = String.format("%3s", Integer.toBinaryString(b)).replace(' ', '0');
		else if(b == 4) B = String.format("%3s", Integer.toBinaryString(b)).replace(' ', '0');
		else if(b == 5) B = String.format("%3s", Integer.toBinaryString(b)).replace(' ', '0');
		else if(b == 6) B = String.format("%3s", Integer.toBinaryString(b)).replace(' ', '0');
		else if(b == 7) B = String.format("%3s", Integer.toBinaryString(b)).replace(' ', '0');
		
		//ZERO
		if(b==0) p2 = "---";
		
		//normal cases
		else if(b==1 && sp != 2) p2 = "--x";
		else if(b==2) p2 = "-w-";
		else if(b==3 && sp != 2) p2 = "-wx";
		else if(b==4) p2 = "r--";
		else if(b==5 && sp != 2) p2 = "r-x";
		else if(b==6) p2 = "rw-";
		else if(b==7 && sp != 2) p2 = "rwx";
		
		//cases for changing x to s
		if(b==1 && sp==2) p2 = "--s";
		else if(b==3 && sp==2) p2 = "-ws";
		else if(b==5 && sp==2) p2 = "r-s";
		else if(b==7 && sp==2) p2 = "rws";
		
		//Cases for C
		
				if (c == 0) C = String.format("%3s", Integer.toBinaryString(c)).replace(' ', '0');
				else if(c == 1) C = String.format("%3s", Integer.toBinaryString(c)).replace(' ', '0');
				else if(c == 2) C = String.format("%3s", Integer.toBinaryString(c)).replace(' ', '0');
				else if(c == 3) C = String.format("%3s", Integer.toBinaryString(c)).replace(' ', '0');
				else if(c == 4) C = String.format("%3s", Integer.toBinaryString(c)).replace(' ', '0');
				else if(c == 5) C = String.format("%3s", Integer.toBinaryString(c)).replace(' ', '0');
				else if(c == 6) C = String.format("%3s", Integer.toBinaryString(c)).replace(' ', '0');
				else if(c == 7) C = String.format("%3s", Integer.toBinaryString(c)).replace(' ', '0');
				
				//ZERO
				if(c==0) p3 = "---";
				
				//normal cases
				else if(c==1 && sp != 4) p3 = "--x";
				else if(c==2) p3 = "-w-";
				else if(c==3 && sp != 4) p3 = "-wx";
				else if(c==4) p3 = "r--";
				else if(c==5 && sp != 4) p3 = "r-x";
				else if(c==6) p3 = "rw-";
				else if(c==7 && sp != 4) p3 = "rwx";
				
				//cases for changing x to t
				if(c==1 && sp==4) p3 = "--t";
				else if(c==3 && sp==4) p3 = "-wt";
				else if(c==5 && sp==4) p3 = "r-t";
				else if(c==7 && sp==4) p3 = "rwt";
		
		System.out.println(A + " " + B + " " + C + " and " + p1 + " " + p2 + " " + p3);
		
		//Return
		return "";	
		}
	}


