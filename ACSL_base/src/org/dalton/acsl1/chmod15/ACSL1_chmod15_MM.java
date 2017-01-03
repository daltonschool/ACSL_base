package org.dalton.acsl1.chmod15;
/*
 * Author: Meredith Manson
 * Program: ACSL 1
 * Given Test Data:
 * 1. 0, 5, 2, 6 -> 101 010 110 and r-x -w- rw-
 * 2. 1, 7, 3, 0 -> 111 011 000 and rws -wx ---
 * 3. 2, 4, 1, 5 -> 100 001 101 and r-- --s r-x
 * 4. 4, 2, 3, 4 -> 010 011 100 and -w- -wx r--
 * 5. 4, 5, 6, 7 -> 101 110 111 and r-x rw- rwt
 * 
 */

import java.util.Arrays;
import java.util.Scanner;


public class ACSL1_chmod15_MM {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (true){

			String[] input = s.nextLine().split(", ");
			int size = input.length; 
			int permissiondata = 0;
			if(input[0]!=(" ")){
				permissiondata = Integer.parseInt(input[0]);
			}
			String firstnum = "";
			String secondnum = "";
			String thirdnum = "";
			String [] perm1 = new String[3];
			String [] perm2 = new String[3];
			String [] perm3 = new String[3];
			String permission1 = "";
			String permission2 = "";
			String permission3 = "";

			if (size!=4){
				System.out.println("Invalid Input");
			}
			else if (permissiondata==3 || permissiondata>4){
				System.out.println("Invalid Input");
			}

			else if (input[0]==(" ")){
				System.out.println("Invalid Input");
			}

			else{
				firstnum = OctalFunction(Integer.parseInt(input[1]));
				secondnum = OctalFunction(Integer.parseInt(input[2]));
				thirdnum = OctalFunction(Integer.parseInt(input[3]));

				perm1 = Permission(firstnum).split("");
				perm2 = Permission(secondnum).split("");
				perm3 = Permission(thirdnum).split("");

				if((permissiondata==1)&&(perm1[2].equals("x"))){
					perm1[2]="s";
				}
				if((permissiondata==2)&&(perm2[2].equals("x"))){
					perm2[2]="s";
				}
				if((permissiondata==4)&&(perm3[2].equals("x"))){
					perm3[2]="t";
				}

				permission1 = Converter(perm1);
				permission2 = Converter(perm2);
				permission3 = Converter(perm3);

				System.out.println(firstnum + " " + secondnum + " " + thirdnum + " and " + permission1 + " " + permission2 + " " + permission3);

			}//close else 

		}//close while

	}//close main

	public static String OctalFunction(int x){
		String num = "";

		if (x==0){
			num = "000";
		}
		else if (x==1){
			num = "001";
		}
		else if (x==2){
			num = "010";
		}
		else if (x==3){
			num = "011";
		}
		else if (x==4){
			num = "100";
		}
		else if (x==5){
			num = "101";
		}
		else if (x==6){
			num = "110";
		}
		else if (x==7){
			num = "111";
		}

		return num;
	}

	public static String Permission(String x){
		String perm = "";

		if (x.equals("000")){
			perm = "---";
		}
		else if (x.equals("001")){
			perm = "--x";
		}
		else if (x.equals("010")){
			perm = "-w-";
		}
		else if (x.equals("011")){
			perm = "-wx";
		}
		else if (x.equals("100")){
			perm = "r--";
		}
		else if (x.equals("101")){
			perm = "r-x";
		}
		else if (x.equals("110")){
			perm = "rw-";
		}
		else if (x.equals("111")){
			perm = "rwx";
		}

		return perm;

	}

	public static String Converter(String[] x){
		String converted = "";
		for (int i = 0; i < x.length; i++) {
			converted = converted + x[i];
		}

		return converted;
	}

}//close pgm