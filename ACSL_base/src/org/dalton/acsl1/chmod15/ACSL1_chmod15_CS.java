package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Casey Schneider
 * Test data: 
 *
 */

public class ACSL1_chmod15_CS {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 

		for (int i = 0; i < 5; i++) 
		{
			
			String input = scan.nextLine();
			String[] data = input.split(",[ ]*");
			int special = Integer.parseInt(data[0]);
			int first = Integer.parseInt(data[1]);
			int second = Integer.parseInt(data[2]);
			int third = Integer.parseInt(data[3]);

			String[] octals = new String[3];
			String[] letters = new String[3];

			if (first == 0) {octals[0] = "000"; letters[0] = "---";}
			else if (first == 1) {
				if (special==1) {
					octals[0] = "001"; 
					letters[0] = "--s";
				}
				else {
					octals[0] = "001"; 
					letters[0] = "--x";
				}
			}
			else if (first == 2) {octals[0] = "010"; letters[0] = "-w-";}
			else if (first == 3) {
				if (special==1) {
					octals[0] = "011";
					letters[0] = "-ws";
				}
				else {
					octals[0] = "011";
					letters[0] = "-wx";
				}
			}
			else if (first == 4) {octals[0] = "100"; letters[0] = "r--";}

			else if (first == 5) {
				if (special==1) {
					octals[0] = "101";
					letters[0] = "r-s";
				}
				else {
					octals[0] = "101";
					letters[0] = "r-x";
				}
			}
			else if (first == 6) {octals[0] = "110"; letters[0] = "rw-";}

			else if (first == 7) {
				if (special==1) {
					octals[0] = "111";
					letters[0] = "rws";
				}
				else {
					octals[0] = "111";
					letters[0] = "rwx";
				}
			}

			if (second == 0) {octals[1] = "000"; letters[1] = "---";}
			else if (second == 1) {
				if (special==2) {
					octals[1] = "001"; letters[1] = "--s";
				}
				else {
					octals[1] = "001"; letters[1] = "--x";
				}
			}
			else if (second == 2) {octals[1] = "010"; letters[1] = "-w-";}
			else if (second == 3) {
				if (special==2) {
					octals[1] = "011"; letters[1] = "-ws";
				}
				else {
					octals[1] = "011"; letters[1] = "-wx";
				}
			}

			else if (second == 4) {octals[1] = "100"; letters[1] = "r--";}
			else if (second == 5) {
				if (special==2) {
					octals[1] = "101"; letters[1] = "r-s";
				}
				else {
					octals[1] = "101"; letters[1] = "r-x";
				}
			}
			else if (second == 6) {octals[1] = "110"; letters[1] = "rw-";}
			else if (second == 7) {
				if (special==2) {
					octals[1] = "111"; letters[1] = "rws";
				}
				else {
					octals[1] = "111"; letters[1] = "rwx";
				}
			}

			if (third == 0) {octals[2] = "000"; letters[2] = "---";}
			else if (third == 1) {
				if (special==4) {
					octals[2] = "001"; letters[2] = "--t";
				}
				else {
					octals[2] = "001"; letters[2] = "--x";
				}
			}
			else if (third == 2) {octals[2] = "010"; letters[2] = "-w-";}
			else if (third == 3) {
				if (special==4) {
					octals[2] = "011"; letters[2] = "-wt";
				}
				else {
					octals[2] = "011"; letters[2] = "-wx";
				}
			}
			else if (third == 4) {octals[2] = "100"; letters[2] = "r--";}
			else if (third == 5) {
				if (special==4) {
					octals[2] = "101"; letters[2] = "r-t";
				}
				else {
					octals[2] = "101"; letters[2] = "r-x";
				}
			}
			else if (third == 6) {octals[2] = "110"; letters[2] = "rw-";}
			else if (third == 7) {
				if (special==4) {
					octals[2] = "111"; letters[2] = "rwt";
				}
				else {
					octals[2] = "111"; letters[2] = "rwx";
				}
			}
			for (int j = 0; j < octals.length; j++) {
				System.out.print(octals[j] + " ");
			}
			System.out.print("and");
			for (int l = 0; l < letters.length; l++) {
				System.out.print(" " + letters[l]);
			}
			System.out.println();
		}
	}
}
