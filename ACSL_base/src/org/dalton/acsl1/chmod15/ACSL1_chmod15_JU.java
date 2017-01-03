package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Julia Udell
/*Test Data:
 * 4, 1, 2, 5   001 010 011 and --x -w- -wt
 * 	1, 2, 3, 4  010 011 100 and -w- -wx r-- 
	0, 2, 3, 6  010 011 110 and -w- -wx rw- 
	2, 1, 3, 5  001 011 101 and --x -ws r-x 			
 */

public class ACSL1_chmod15_JU {

	public static void main(String[] args) throws IOException {
		//declarations 
		Scanner scan;
		String filein = "testdata/chmodTest";
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			//switch to regular terminal input
			scan = new Scanner(System.in);
		}

		//main loop:
		String answer = null; 
		while(scan.hasNext()) {
			answer = solve(scan.nextLine());
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}

		fop.flush();
		fop.close();
		scan.close();
	}

	public static String solve(String s) { 
		String input = s;
		String[] data = input.split(", ");
		int zero = Integer.parseInt(data[0]);
		int one = Integer.parseInt(data[1]);
		int two = Integer.parseInt(data[2]);
		int three = Integer.parseInt(data[3]);

		String[] first = new String[3];
		String[] second = new String[3];
		String[] third = new String[3];

		if(one == 0){
			System.out.print("000 ");
			first[0] = "-";
			first[1] = "-";
			first[2] = "-";
		}
		if(one == 1){
			System.out.print("001 ");
			first[0] = "-";
			first[1] = "-";
			first[2] = "x";
		}
		if(one == 2){
			System.out.print("010 ");
			first[0] = "-";
			first[1] = "w";
			first[2] = "-";
		}
		if(one == 3){
			System.out.print("011 ");
			first[0] = "-";
			first[1] = "w";
			first[2] = "x";
		}
		if(one == 4){
			System.out.print("100 ");
			first[0] = "r";
			first[1] = "-";
			first[2] = "-";
		}
		if(one == 5){
			System.out.print("101 ");
			first[0] = "r";
			first[1] = "-";
			first[2] = "x";
		}
		if(one == 6){
			System.out.print("110 ");
			first[0] = "r";
			first[1] = "w";
			first[2] = "-";
		}
		if(one == 7){
			System.out.print("111 ");
			first[0] = "r";
			first[1] = "w";
			first[2] = "x";
		}
		if(two == 0){
			System.out.print("000 ");
			second[0] = "-";
			second[1] = "-";
			second[2] = "-";
		}
		if(two == 1){
			System.out.print("001 ");
			second[0] = "-";
			second[1] = "-";
			second[2] = "x";
		}
		if(two == 2){
			System.out.print("010 ");
			second[0] = "-";
			second[1] = "w";
			second[2] = "-";
		}
		if(two == 3){
			System.out.print("011 ");
			second[0] = "-";
			second[1] = "w";
			second[2] = "x";
		}
		if(two == 4){
			System.out.print("100 ");
			second[0] = "r";
			second[1] = "-";
			second[2] = "-";
		}
		if(two == 5){
			System.out.print("101 ");
			second[0] = "r";
			second[1] = "-";
			second[2] = "x";
		}
		if(two == 6){
			System.out.print("110 ");
			second[0] = "r";
			second[1] = "w";
			second[2] = "-";
		}
		if(two == 7){
			System.out.print("111 ");
			second[0] = "r";
			second[1] = "w";
			second[2] = "x";
		}
		if(three == 0){
			System.out.print("000" + " and ");
			third[0] = "-";
			third[1] = "-";
			third[2] = "-";
		}
		if(three == 1){
			System.out.print("001" + " and ");
			third[0] = "-";
			third[1] = "-";
			third[2] = "x";
		}
		if(three == 2){
			System.out.print("010" + " and ");
			third[0] = "-";
			third[1] = "w";
			third[2] = "-";
		}
		if(three == 3){
			System.out.print("011" + " and ");	
			third[0] = "-";
			third[1] = "w";
			third[2] = "x";
		}
		if(three == 4){
			System.out.print("100" + " and ");
			third[0] = "r";
			third[1] = "-";
			third[2] = "-";
		}
		if(three == 5){
			System.out.print("101" + " and ");
			third[0] = "r";
			third[1] = "-";
			third[2] = "x";
		}
		if(three == 6){
			System.out.print("110" + " and ");	
			third[0] = "r";
			third[1] = "w";
			third[2] = "-";
		}
		if(three == 7){
			System.out.print("111" + " and ");
			third[0] = "r";
			third[1] = "w";
			third[2] = "x";
		}
		//special cases 
		if(zero == 0){
			System.out.print(first[0] + first[1] + first[2] + " " + second[0] + second[1] + second [2] + " " + third[0] + third[1] + third [2]);
		}
		if(zero == 1){
			if(one == 1 || one == 3 || one == 5 || one == 7){
				System.out.print(first[0] + first[1] + "s" + " " + second[0] + second[1] + second [2] + " " + third[0] + third[1] + third [2]);	
			}
			else{
				System.out.print(first[0] + first[1] + first[2] + " " + second[0] + second[1] + second [2] + " " + third[0] + third[1] + third [2]);
			}
		}
		if(zero == 2){
			if(two == 1 || two == 3 || two == 5 || two == 7){
				System.out.print(first[0] + first[1] + first[2] + " " + second[0] + second[1] + "s" + " " + third[0] + third[1] + third [2]);	
			}
			else{
				System.out.print(first[0] + first[1] + first[2] + " " + second[0] + second[1] + second [2] + " " + third[0] + third[1] + third [2]);
			}
		}
		if(zero == 4){
			if(three == 1 || three == 3 || three == 5 || three == 7){
				System.out.print(first[0] + first[1] + first[2] + " " + second[0] + second[1] + second [2] + " " + third[0] + third[1] + "t");	
			}
			else{
				System.out.print(first[0] + first[1] + first[2] + " " + second[0] + second[1] + second [2] + " " + third[0] + third[1] + third [2]);
			}
		}

		return " ";
	}

}
