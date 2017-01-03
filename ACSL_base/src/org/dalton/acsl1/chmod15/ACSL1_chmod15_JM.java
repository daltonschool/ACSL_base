package org.dalton.acsl1.chmod15;
import java.util.Scanner;

public class ACSL1_chmod15_JM {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What special permission number: 0, 1, 2, or 4?");
		int specialpermission = scan.nextInt();
		System.out.println("What first digit in the octal number?");
		int octalone = scan.nextInt();
		String binaryone = Integer.toBinaryString(octalone);
		if (binaryone.length() == 1) {
			binaryone = "00" + Integer.toBinaryString(octalone);
		}
		if (binaryone.length() == 2) {
			binaryone = "0" + Integer.toBinaryString(octalone);
		}
		System.out.println("What second digit in the octal number?");
		int octaltwo = scan.nextInt();
		String binarytwo = Integer.toBinaryString(octaltwo);
		if (binarytwo.length() == 1) {
			binarytwo = "00" + Integer.toBinaryString(octaltwo);
		}
		if (binarytwo.length() == 2) {
			binarytwo = "0" + Integer.toBinaryString(octaltwo);
		}
		System.out.println("What third digit in the octal number?");
		int octalthree = scan.nextInt();
		String binarythree = Integer.toBinaryString(octalthree);
		if (binarythree.length() == 1) {
			binarythree = "00" + Integer.toBinaryString(octalthree);
		}
		if (binarythree.length() == 2) {
			binarythree = "0" + Integer.toBinaryString(octalthree);
		}
		System.out.println("The binary value is: " + binaryone + " " + binarytwo + " " + binarythree);

		
		if(specialpermission == 0) {
			if(binaryone == "000") {
				String lettersone =  "---";
				System.out.println(lettersone + " ");
			}
			else if(binaryone == "001") {
				String lettersone =  "--x";
				System.out.println(lettersone + " ");
			}
			else if(binaryone == "010") {
				String lettersone =  "-w-";
				System.out.println(lettersone + " ");
			}
			else if(binaryone == "011") {
				String lettersone =  "-wx";
				System.out.println(lettersone + " ");
			}
			else if(binaryone == "100") {
				String lettersone =  "r--";
				System.out.println(lettersone + " ");
			}
			else if(binaryone == "101") {
				String lettersone =  "r-x";
				System.out.println(lettersone + " ");
			}
			else if(binaryone == "110") {
				String lettersone =  "rw-";
				System.out.println(lettersone + " ");
			}
			else if(binaryone == "111") {
				String lettersone =  "rwx";
				System.out.println(lettersone + " ");
			}
			else if(binarytwo == "000") {
				String letterstwo =  "---";
				System.out.print(letterstwo + " ");
			}
			else if(binarytwo == "001") {
				String letterstwo =  "--x";
				System.out.print(letterstwo + " ");
			}
			else if(binarytwo == "010") {
				String letterstwo =  "-w-";
				System.out.print(letterstwo + " ");
			}
			else if(binarytwo == "011") {
				String letterstwo =  "-wx";
				System.out.print(letterstwo + " ");
			}
			else if(binarytwo == "100") {
				String letterstwo =  "r--";
				System.out.print(letterstwo + " ");
			}
			else if(binarytwo == "101") {
				String letterstwo =  "r-x";
				System.out.print(letterstwo + " ");
			}
			else if(binarytwo == "110") {
				String letterstwo =  "rw-";
				System.out.print(letterstwo + " ");
			}
			else if(binarytwo == "111") {
				String letterstwo =  "rwx";
				System.out.print(letterstwo + " ");
			}
			else if(binarythree == "000") {
				String lettersthree =  "---";
				System.out.print(lettersthree);
			}
			else if(binarythree == "001") {
				String lettersthree =  "--x";
				System.out.print(lettersthree);
			}
			else if(binarythree == "010") {
				String lettersthree =  "-w-";
				System.out.print(lettersthree);
			}
			else if(binarythree == "011") {
				String lettersthree =  "-wx";
				System.out.print(lettersthree);
			}
			else if(binarythree == "100") {
				String lettersthree =  "r--";
				System.out.print(lettersthree);
			}
			else if(binarythree == "101") {
				String lettersthree =  "r-x";
				System.out.print(lettersthree);
			}
			else if(binarythree == "110") {
				String lettersthree =  "rw-";
				System.out.print(lettersthree);
			}
			else if(binarythree == "111") {
				String lettersthree =  "rwx";
				System.out.print(lettersthree);
			}
		}
		if(specialpermission == 1) {
			if(binaryone == "000") {
				//String lettersone = "";
			}
			if(binaryone == "001") {

			}
			if(binaryone == "010") {

			}
			if(binaryone == "011") {

			}
			if(binaryone == "100") {

			}
			if(binaryone == "101") {

			}
			if(binaryone == "110") {

			}
			if(binaryone == "111") {

			}
		}
		if(specialpermission == 2) {
			if(binaryone == "000") {

			}
			if(binaryone == "001") {

			}
			if(binaryone == "010") {

			}
			if(binaryone == "011") {

			}
			if(binaryone == "100") {

			}
			if(binaryone == "101") {

			}
			if(binaryone == "110") {

			}
			if(binaryone == "111") {

			}
		}
		if(specialpermission == 4) {
			if(binaryone == "000") {

			}
			if(binaryone == "001") {

			}
			if(binaryone == "010") {

			}
			if(binaryone == "011") {

			}
			if(binaryone == "100") {

			}
			if(binaryone == "101") {

			}
			if(binaryone == "110") {

			}
			if(binaryone == "111") {

			}
		}
	}
}
