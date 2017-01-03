package org.dalton.acsl1.chmod15;

import java.util.Scanner;
public class ACSL_chmod15_EC {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int rounds =0; rounds<10; rounds++){
			String input = scan.nextLine();
			String[] splitArray = input.split(", ");
			char special = '0';
			String binaryprint = "";
			String letterprint = "";
			//convert to binary
			for (int i = 0; i<4; i++){
				if (i ==0){
					if (splitArray[0].equalsIgnoreCase("0")) special = '0';
					if (splitArray[0].equalsIgnoreCase("1")) special = '1';
					if (splitArray[0].equalsIgnoreCase("2")) special = '2';
					if (splitArray[0].equalsIgnoreCase("4")) special = '4';
				}
				else {
					if (splitArray[i].equalsIgnoreCase("0")){
						binaryprint = binaryprint.concat("000 "); letterprint= letterprint.concat("--- ");
					}
					else if (splitArray[i].equalsIgnoreCase("1")){
						binaryprint = binaryprint.concat("001 "); letterprint= letterprint.concat("--x ");
					}
					else if (splitArray[i].equalsIgnoreCase("2")){
						binaryprint = binaryprint.concat("010 "); letterprint= letterprint.concat("-w- ");
					}
					else if (splitArray[i].equalsIgnoreCase("3")){
						binaryprint = binaryprint.concat("011 "); letterprint= letterprint.concat("-wx ");
					}
					else if (splitArray[i].equalsIgnoreCase("4")){
						binaryprint = binaryprint.concat("100 "); letterprint= letterprint.concat("r-- ");
					}
					else if (splitArray[i].equalsIgnoreCase("5")){
						binaryprint = binaryprint.concat("101 "); letterprint= letterprint.concat("r-x ");
					}
					else if (splitArray[i].equalsIgnoreCase("6")){
						binaryprint = binaryprint.concat("110 "); letterprint= letterprint.concat("rw- ");
					}
					else if (splitArray[i].equalsIgnoreCase("7")){
						binaryprint = binaryprint.concat("111 "); letterprint= letterprint.concat("rwx ");		
					}
				}
			}
			if (special == '0' ){
				System.out.println(binaryprint + "and " + letterprint);
			}
			if (special == '1' ){
				StringBuffer sb = new StringBuffer(letterprint);
				if (sb.charAt(2) == 'x'){
					sb.replace(2, 3, "s");
				}
				letterprint = sb.toString();
				System.out.println(binaryprint + "and " + letterprint);
			}
			if (special == '2' ){
				StringBuffer sb = new StringBuffer(letterprint);
				if (sb.charAt(6) == 'x'){
					sb.replace(6, 7, "s");
				}
				letterprint = sb.toString();
				System.out.println(binaryprint + "and " + letterprint);
			}
			if (special == '4'){
				StringBuffer sb = new StringBuffer(letterprint);
				if (sb.charAt(10) == 'x'){
					sb.replace(10, 11, "t");
				}
				letterprint = sb.toString();
				System.out.println(binaryprint + "and " + letterprint);
			}
		}
	}
}