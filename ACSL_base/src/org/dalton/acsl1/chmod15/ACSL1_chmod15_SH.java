package org.dalton.acsl1.chmod15;


import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author sholland
 * ACSL - 2015-2016 - Contest #1 - ACSL CHMOD
 * 0, 5, 2, 6		101 010 110 and r-x -w- rw-
 * 1, 7, 3, 0		111 011 000 and rws -wx ---
 * 2, 4, 1, 5		100 001 101 and r-- --s r-x
 * 4, 2, 3, 4		010 011 100 and -w- -wx r--
 * 4, 5, 6, 7		101 110 111 and r-x rw- rwt
 */

public class ACSL1_chmod15_SH {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int counter = 0; counter < 5; counter++) {
			String[] raw_input = scan.nextLine().split(", ");				//scan and split input
			String bin1 = binConverter(Integer.parseInt(raw_input[1]));		//convert 2nd octal digit to binary
			String bin2 = binConverter(Integer.parseInt(raw_input[2]));		//convert 3rd octal digit to binary
			String bin3 = binConverter(Integer.parseInt(raw_input[3]));		//convert 4th octal digit to binary
			System.out.println(bin1 + " " + bin2 + " " + bin3 + " and " + permConverter((bin1 + bin2 + bin3), raw_input[0]));	//output
		}
	}

	/**
	 * convert from octal to binary
	 * @param 1-character octal number
	 * @return 3-character binary number
	 */
	public static String binConverter(int input) {
		DecimalFormat df = new DecimalFormat("000");	//format leading zero's
		double result = 0;

		/* */if(input==0) result = 0;
		else if(input==1) result = 1;
		else if(input==2) result = 10;
		else if(input==3) result = 11;
		else if(input==4) result = 100;
		else if(input==5) result = 101;
		else if(input==6) result = 110;
		else if(input==7) result = 111;
		return df.format(result);
	}

	/**
	 * create permissions based on a binary number
	 * @param bin_converted the binary number
	 * @return read/write/execute permissions
	 */
	public static String permConverter(String bin_converted, String special) {
		char[] bin = bin_converted.toCharArray();									//9-digit binary number
		char[] result = {'-', '-', '-', ' ', '-', '-', '-', ' ', '-', '-', '-'};	//blank permissions
		String output = "";

		if(bin[0]=='1') result[0] = 'r';	//set permissions (r = read, w = write, x = execute)
		if(bin[1]=='1') result[1] = 'w';	
		if(bin[2]=='1') result[2] = 'x';
		if(bin[3]=='1') result[4] = 'r';
		if(bin[4]=='1') result[5] = 'w';
		if(bin[5]=='1') result[6] = 'x';
		if(bin[6]=='1') result[8] = 'r';
		if(bin[7]=='1') result[9] = 'w';
		if(bin[8]=='1') result[10]= 'x';

		/* */if(special.equals("1") && result[2]=='x') result[2] = 's';		//if first digit is 1 and owner can execute, then x becomes s
		else if(special.equals("2") && result[6]=='x') result[6] = 's';		//if first digit is 2 and group can execute, then x becomes s
		else if(special.equals("4") && result[10]=='x') result[10] = 't';	//if first digit is 4 and other can execute, then x becomes t

		for (int i = 0; i < result.length; i++) output += result[i];		//format the output
		return output;
	}
}