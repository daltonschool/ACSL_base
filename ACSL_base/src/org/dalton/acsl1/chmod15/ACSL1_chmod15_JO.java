package org.dalton.acsl1.chmod15;

import java.util.Scanner;
public class ACSL1_chmod15_JO {
	public static void main(String[] args){
	while(true){
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine();
			String a = "";
			String[] input = s.split(" ");
			String[] binary = new String[4];
			String[] permissions = new String [4];
			for(int ii = 2; ii < 5; ii++){
				if(input[ii].substring(0,1).equals("0")){
					binary[ii-1] = "000";
					permissions[ii-1] = "---";	
				}else if(input[ii].substring(0,1).equals("1")){
					binary[ii-1] = "001";
					permissions[ii-1] = "--x";
				}else if(input[ii].substring(0,1).equals("2")){
					binary[ii-1] = "010";
					permissions[ii-1] = "-w-";
				}else if(input[ii].substring(0,1).equals("3")){
					binary[ii-1] = "011";
					permissions[ii-1] = "-wx";
				}else if(input[ii].substring(0,1).equals("4")){
					binary[ii-1] = "100";
					permissions[ii-1] = "r--";
				}else if(input[ii].substring(0,1).equals("5")){
					binary[ii-1] = "101";
					permissions[ii-1] = "r-x";
				}else if(input[ii].substring(0,1).equals("6")){
					binary[ii-1] = "110";
					permissions[ii-1] = "rw-";
				}else if(input[ii].substring(0,1).equals("7")){
					binary[ii-1] = "111";
					permissions[ii-1] = "rwx";	
				}
			}
			if(input[1].equals("2,") && permissions[1].substring(2).equals("x")){
				permissions[2] = permissions[1].substring(0,2) + "s";
			}
			if(input[1].equals("4,") && permissions[3].substring(2).equals("x")){
				permissions[3] = permissions[1].substring(0,2) + "t";
			}
			if(input[1].equals("1,") && permissions[1].substring(2).equals("x")){
				permissions[1] = permissions[1].substring(0,2) + "s";
			}
			for(int jj = 1; jj < 4; jj++){
				a = a + binary[jj] + " ";	
			}
			a = a + "and ";
			for(int jj = 1; jj < 4; jj++){
				a = a + permissions[jj] + " ";	
			}
			System.out.println(a);
		}
	}
}



