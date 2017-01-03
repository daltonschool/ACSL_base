package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ACSL1_chmod15_AM {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/chmod_DATA";
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
		String[] input = s.split(",[ ]*");

		int[] intinput = new int[4];

		int[] binary1 = new int[3];
		int[] binary2 = new int[3];
		int[] binary3 = new int[3];

		//move input from string array to int array
		for (int i = 0; i < input.length; i++) {
			intinput[i] = Integer.parseInt(input[i]);
		}

		//special permissions = intinput[0], conversions start at intinput[1]

		//if statements to the first octal digit of the input into binary
		if(intinput[1] == 0){
			binary1[0] = 0;
			binary1[1] = 0;
			binary1[2] = 0;
			for (int i = 0; i < binary1.length; i++) {
				System.out.print(binary1[i]);
			}
			System.out.print(" ");
		}
		if(intinput[1] == 1){
			binary1[0] = 0;
			binary1[1] = 0;
			binary1[2] = 1;
			for (int i = 0; i < binary1.length; i++) {
				System.out.print(binary1[i]);
			}
			System.out.print(" ");
		}
		if(intinput[1] == 2){
			binary1[0] = 0;
			binary1[1] = 1;
			binary1[2] = 0;
			for (int i = 0; i < binary1.length; i++) {
				System.out.print(binary1[i]);
			}
			System.out.print(" ");
		}
		if(intinput[1] == 3){
			binary1[0] = 0;
			binary1[1] = 1;
			binary1[2] = 1;
			for (int i = 0; i < binary1.length; i++) {
				System.out.print(binary1[i]);
			}
			System.out.print(" ");
		}
		if(intinput[1] == 4){
			binary1[0] = 1;
			binary1[1] = 0;
			binary1[2] = 0;
			for (int i = 0; i < binary1.length; i++) {
				System.out.print(binary1[i]);
			}
			System.out.print(" ");
		}
		if(intinput[1] == 5){
			binary1[0] = 1;
			binary1[1] = 0;
			binary1[2] = 1;
			for (int i = 0; i < binary1.length; i++) {
				System.out.print(binary1[i]);
			}
			System.out.print(" ");
		}
		if(intinput[1] == 6){
			binary1[0] = 1;
			binary1[1] = 1;
			binary1[2] = 0;
			for (int i = 0; i < binary1.length; i++) {
				System.out.print(binary1[i]);
			}
			System.out.print(" ");
		}
		if(intinput[1] == 7){
			binary1[0] = 1;
			binary1[1] = 1;
			binary1[2] = 1;
			for (int i = 0; i < binary1.length; i++) {
				System.out.print(binary1[i]);
			}
			System.out.print(" ");
		}

		//if statements to the second octal digit of the input into binary
		if(intinput[2] == 0){
			binary2[0] = 0;
			binary2[1] = 0;
			binary2[2] = 0;
			for (int i = 0; i < binary2.length; i++) {
				System.out.print(binary2[i]);
			}
			System.out.print(" ");
		}
		if(intinput[2] == 1){
			binary2[0] = 0;
			binary2[1] = 0;
			binary2[2] = 1;
			for (int i = 0; i < binary2.length; i++) {
				System.out.print(binary2[i]);
			}
			System.out.print(" ");
		}
		if(intinput[2] == 2){
			binary2[0] = 0;
			binary2[1] = 1;
			binary2[2] = 0;
			for (int i = 0; i < binary2.length; i++) {
				System.out.print(binary2[i]);
			}
			System.out.print(" ");
		}
		if(intinput[2] == 3){
			binary2[0] = 0;
			binary2[1] = 1;
			binary2[2] = 1;
			for (int i = 0; i < binary2.length; i++) {
				System.out.print(binary2[i]);
			}
			System.out.print(" ");
		}
		if(intinput[2] == 4){
			binary2[0] = 1;
			binary2[1] = 0;
			binary2[2] = 0;
			for (int i = 0; i < binary2.length; i++) {
				System.out.print(binary2[i]);
			}
			System.out.print(" ");
		}
		if(intinput[2] == 5){
			binary2[0] = 1;
			binary2[1] = 0;
			binary2[2] = 1;
			for (int i = 0; i < binary2.length; i++) {
				System.out.print(binary2[i]);
			}
			System.out.print(" ");
		}
		if(intinput[2] == 6){
			binary2[0] = 1;
			binary2[1] = 1;
			binary2[2] = 0;
			for (int i = 0; i < binary2.length; i++) {
				System.out.print(binary2[i]);
			}
			System.out.print(" ");
		}
		if(intinput[2] == 7){
			binary2[0] = 1;
			binary2[1] = 1;
			binary2[2] = 1;
			for (int i = 0; i < binary2.length; i++) {
				System.out.print(binary2[i]);
			}
			System.out.print(" ");
		}

		//if statements to the third octal digit of the input into binary
		if(intinput[3] == 0){
			binary3[0] = 0;
			binary3[1] = 0;
			binary3[2] = 0;
			for (int i = 0; i < binary3.length; i++) {
				System.out.print(binary3[i]);
			}
			System.out.print(" and ");
		}
		if(intinput[3] == 1){
			binary3[0] = 0;
			binary3[1] = 0;
			binary3[2] = 1;
			for (int i = 0; i < binary3.length; i++) {
				System.out.print(binary3[i]);
			}
			System.out.print(" and ");
		}
		if(intinput[3] == 2){
			binary3[0] = 0;
			binary3[1] = 1;
			binary3[2] = 0;
			for (int i = 0; i < binary3.length; i++) {
				System.out.print(binary3[i]);
			}
			System.out.print(" and ");
		}
		if(intinput[3] == 3){
			binary3[0] = 0;
			binary3[1] = 1;
			binary3[2] = 1;
			for (int i = 0; i < binary3.length; i++) {
				System.out.print(binary3[i]);
			}
			System.out.print(" and ");
		}
		if(intinput[3] == 4){
			binary3[0] = 1;
			binary3[1] = 0;
			binary3[2] = 0;
			for (int i = 0; i < binary3.length; i++) {
				System.out.print(binary3[i]);
			}
			System.out.print(" and ");
		}
		if(intinput[3] == 5){
			binary3[0] = 1;
			binary3[1] = 0;
			binary3[2] = 1;
			for (int i = 0; i < binary3.length; i++) {
				System.out.print(binary3[i]);
			}
			System.out.print(" and ");
		}
		if(intinput[3] == 6){
			binary3[0] = 1;
			binary3[1] = 1;
			binary3[2] = 0;
			for (int i = 0; i < binary3.length; i++) {
				System.out.print(binary3[i]);
			}
			System.out.print(" and ");
		}
		if(intinput[3] == 7){
			binary3[0] = 1;
			binary3[1] = 1;
			binary3[2] = 1;
			for (int i = 0; i < binary3.length; i++) {
				System.out.print(binary3[i]);
			}
			System.out.print(" and ");
		}

		//print r, w, x
		//print permissions for binary1
		for (int i = 0; i < binary1.length; i++) {
			if(i == 0 && binary1[i] == 1){
				System.out.print("r");
			}
			else if(i == 0 && binary1[i] == 0){
				System.out.print("-");
			}
			else if(i == 1 && binary1[i] == 1){
				System.out.print("w");
			}
			else if(i == 1 && binary1[i] == 0){
				System.out.print("-");
			}
			else if(i == 2 && binary1[i] == 1 && intinput[0] == 1){
				System.out.print("s ");
			}
			else if(i == 2 && binary1[i] == 1){
				System.out.print("x ");
			}
			else if(i == 2 && binary1[i] == 0){
				System.out.print("- ");
			}
		}

		//print permissions for binary2
		for (int i = 0; i < binary2.length; i++) {
			if(i == 0 && binary2[i] == 1){
				System.out.print("r");
			}
			else if(i == 0 && binary2[i] == 0){
				System.out.print("-");
			}
			else if(i == 1 && binary2[i] == 1){
				System.out.print("w");
			}
			else if(i == 1 && binary2[i] == 0){
				System.out.print("-");
			}
			else if(i == 2 && binary2[i] == 1 && intinput[0] == 2){
				System.out.print("s ");
			}
			else if(i == 2 && binary2[i] == 1){
				System.out.print("x ");
			}
			else if(i == 2 && binary2[i] == 0){
				System.out.print("- ");
			}
		}

		//print permissions for binary3
		for (int i = 0; i < binary3.length; i++) {
			if(i == 0 && binary3[i] == 1){
				System.out.print("r");
			}
			else if(i == 0 && binary3[i] == 0){
				System.out.print("-");
			}
			else if(i == 1 && binary3[i] == 1){
				System.out.print("w");
			}
			else if(i == 1 && binary3[i] == 0){
				System.out.print("-");
			}
			else if(i == 2 && binary3[i] == 1 && intinput [0] == 4){
				System.out.print("t ");
			}
			else if(i == 2 && binary3[i] == 1){
				System.out.print("x ");
			}
			else if(i == 2 && binary3[i] == 0){
				System.out.print("- ");
			}
		}
		return "";
	}
}
