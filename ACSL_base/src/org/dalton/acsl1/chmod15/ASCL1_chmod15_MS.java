package org.dalton.acsl1.chmod15;

//Molly Shapiro

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
public class ASCL1_chmod15_MS {
	public static void main(String[] args) throws IOException {


		//declarations:
		String filein = "testdata/CHMODTEST";
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

	static String solve(String filein) {

		//parse the int:
		String s = filein;
		String p = "";
		String [] data = s.split(",[ ]*"); 
		int num1 = Integer.parseInt(data[0]); 
		int num2 = Integer.parseInt(data[1]);
		int num3 = Integer.parseInt(data[2]);
		int num4 = Integer.parseInt(data[3]);

		//convert num2 to binary:
		int[] owner = new int[3];
		if (num2 == 0) {
			owner[0]=0;
			owner[1]=0;
			owner[2]=0;
		}

		else if (num2 == 1) {
			owner[0]=0;
			owner[1]=0;
			owner[2]=1;
		}

		else if (num2 == 2) {
			owner[0]=0;
			owner[1]=1;
			owner[2]=0;
		}

		else if (num2 == 3) {
			owner[0]=0;
			owner[1]=1;
			owner[2]=1;
		}

		else if (num2 == 4) {
			owner[0]=1;
			owner[1]=0;
			owner[2]=0;
		}

		else if (num2 == 5) {
			owner[0]=1;
			owner[1]=0;
			owner[2]=1;
		}

		else if (num2 == 6) {
			owner[0]=1;
			owner[1]=1;
			owner[2]=0;
		}

		else if (num2 == 7) {
			owner[0]=1;
			owner[1]=1;
			owner[2]=1;
		}


		//convert num3 to binary
		int[] group = new int[3];
		if (num3 == 0) {
			group[0]=0;
			group[1]=0;
			group[2]=0;
		}

		else if (num3 == 1) {
			group[0]=0;
			group[1]=0;
			group[2]=1;

		}

		else if (num3 == 2) {
			group[0]=0;
			group[1]=1;
			group[2]=0;
		}

		else if (num3 == 3) {
			group[0]=0;
			group[1]=1;
			group[2]=1;
		}

		else if (num3 == 4) {
			group[0]=1;
			group[1]=0;
			group[2]=0;
		}

		else if (num3 == 5) {
			group[0]=1;
			group[1]=0;
			group[2]=1;
		}

		else if (num3 == 6) {
			group[0]=1;
			group[1]=1;
			group[2]=0;
		}

		else if (num3 == 7) {
			group[0]=1;
			group[1]=1;
			group[2]=1;
		}

		//convert num4 to binary
		int[] others = new int[3];
		if (num4 == 0) {
			others[0]=0;
			others[1]=0;
			others[2]=0;
		}

		else if (num4 == 1) {
			others[0]=0;
			others[1]=0;
			others[2]=1;
		}

		else if (num4 == 2) {
			others[0]=0;
			others[1]=1;
			others[2]=0;
		}

		else if (num4 == 3) {
			others[0]=0;
			others[1]=1;
			others[2]=1;
		}

		else if (num4 == 4) {
			others[0]=1;
			others[1]=0;
			others[2]=0;
		}

		else if (num4 == 5) {
			others[0]=1;
			others[1]=0;
			others[2]=1;
		}

		else if (num4 == 6) {
			others[0]=1;
			others[1]=1;
			others[2]=0;
		}

		else if (num4 == 7) {
			others[0]=1;
			others[1]=1;
			others[2]=1;
		}


		//convert owner to letters
		char[] let1=new  char[3];
		if (owner[0]==1) {
			let1[0]='r';
		}
		else {
			let1[0]='-';
		}
		if (owner[1]==1) {
			let1[1]='w';
		}
		else {
			let1[1]='-';
		}
		if (owner[2]==1) {
			let1[2]='x';
		}
		else {
			let1[2]='-';
		}

		//convert group to letters
		char[] let2=new  char[3];
		if (group[0]==1) {
			let2[0]='r';
		}
		else {
			let2[0]='-';
		}
		if (group[1]==1) {
			let2[1]='w';
		}
		else {
			let2[1]='-';
		}
		if (group[2]==1) {
			let2[2]='x';
		}
		else {
			let2[2]='-';
		}

		//convert others to letters
		char[] let3=new  char[3];
		if (others[0]==1) {
			let3[0]='r';
		}
		else {
			let3[0]='-';
		}
		if (others[1]==1) {
			let3[1]='w';
		}
		else {
			let3[1]='-';
		}
		if (others[2]==1) {
			let3[2]='x';
		}
		else {
			let3[2]='-';
		}

		// four octal digit
		
				if (num1==1) {
					if (let1[2]=='x') {
						let1[2]='s';
					}	
				}

				if (num1==2) {
					if (let2[2]=='x') {
						let2[2]='s';
					}	
				}
				
				if (num1==4) {
					if (let3[2]=='x') {
						let3[2]='t';
					}	
				}
		System.out.print (owner[0]);
		System.out.print (owner[1]);
		System.out.print (owner[2]);
		System.out.print (" ");
		System.out.print (group[0]);
		System.out.print (group[1]);
		System.out.print (group[2]);
		System.out.print (" ");
		System.out.print (others[0]);
		System.out.print (others[1]);
		System.out.print (others[2]);
		System.out.print (" ");
		System.out.print ("and ");
		System.out.print (let1);
		System.out.print (" ");
		System.out.print (let2);
		System.out.print (" ");
		System.out.print (let3);
		return p;
	}
		//System.out.println (+owner +group +others +"and" +let1 + let2 + let3);
		//want to print owner + group + others and let1 + let2 +let3

		//parse the input
		//convert it to binary
		//make string that is first binary and parse that into an array (arr 1)
		//FOR LOOP
		//if array 1 at position 0 is zero, replace it with a -. else, replace it with an r. continue with this for other positions
		//if there is a 0,2, or 4 in position 1, then do nothing. if there is a 1 in position 1 and there is an x then change x to s 
		//if array 2 at position 0 is zero, replace it with a -. else, replace it with an r. continue with this for other positions
		// if there is a 0, 1, 4 in position 1, then do nothing. if there is a 2 in position 1 and there is an x then change x to s
		//continue with this
		//print owner + group + others "and" let1 + let2 + let3
	

	}


