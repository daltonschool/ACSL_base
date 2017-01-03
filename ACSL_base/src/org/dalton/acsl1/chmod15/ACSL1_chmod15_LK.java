package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ACSL1_chmod15_LK {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/hashtestdata";
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
	/**
	 * solve for a specific input
	 * @param s the input
	 * @return the output
	 */
	static String solve(String s) {
		String input = s;
		Scanner scan = new Scanner(new ByteArrayInputStream(input.getBytes()));
		String [] data = input.split(",[ ]*");
		
		
		int owner = Integer.parseInt(data[1]);
		int group = Integer.parseInt(data[2]);
		int others = Integer.parseInt(data[3]);
		
		int[] octalarray = new int[scan.nextInt()];
		int[] binaryowner = new int [3];
		int[] binarygroup = new int [3];
		int[] binaryothers = new int [3];
		String [] permissionsowner = new String [3];
		String [] permissionsgroup = new String [3];
		String [] permissionsothers = new String [3];

		System.out.println(owner);
		System.out.println(group);
		System.out.println(others);

		for (int i = 0; i < octalarray.length; i++) {
			//owner
			if(octalarray[1] == 0){
				//print binary
				binaryowner [0] = 0;
				binaryowner [1] = 0;
				binaryowner [2] = 0;
				//print permissions
				permissionsowner [0] = "-";
				permissionsowner [1] = "-";
				permissionsowner [2] = "-";
			}
			else if(octalarray[1] == 1){
				binaryowner [0] = 0;
				binaryowner [1] = 0;
				binaryowner [2] = 1;

				permissionsowner [0] = "-";
				permissionsowner [1] = "-";
				permissionsowner [2] = "x";
			}
			else if(octalarray[1] == 2){
				binaryowner [0] = 0;
				binaryowner [1] = 1;
				binaryowner [2] = 0;

				permissionsowner [0] = "-";
				permissionsowner [1] = "w";
				permissionsowner [2] = "-";
			}
			else if(octalarray[1] == 3){
				binaryowner [0] = 0;
				binaryowner [1] = 1;
				binaryowner [2] = 1;

				permissionsowner [0] = "-";
				permissionsowner [1] = "w";
				permissionsowner [2] = "x";
			}
			else if(octalarray[1] == 4){
				binaryowner [0] = 1;
				binaryowner [1] = 0;
				binaryowner [2] = 0;

				permissionsowner [0] = "r";
				permissionsowner [1] = "-";
				permissionsowner [2] = "-";
			}
			else if(octalarray[1] == 5){
				binaryowner [0] = 1;
				binaryowner [1] = 0;
				binaryowner [2] = 1;

				permissionsowner [0] = "r";
				permissionsowner [1] = "-";
				permissionsowner [2] = "x";
			}
			else if(octalarray[1] == 6){
				binaryowner [0] = 1;
				binaryowner [1] = 1;
				binaryowner [2] = 0;

				permissionsowner [0] = "r";
				permissionsowner [1] = "w";
				permissionsowner [2] = "-";
			}
			else if(octalarray[1] == 7){
				binaryowner [0] = 1;
				binaryowner [1] = 1;
				binaryowner [2] = 1;

				permissionsowner [0] = "r";
				permissionsowner [1] = "w";
				permissionsowner [2] = "x";
			}
			else if(octalarray[0] == 1 && binaryowner [2] == 1){
				permissionsowner [2] = "s";
				
			}

		}
		for (int j = 0; j < octalarray.length; j++) {
			//group
			if(octalarray[2] == 0){
				//print binary
				binarygroup [0] = 0;
				binarygroup [1] = 0;
				binarygroup [2] = 0;
				//print permissions
				permissionsgroup [0] = "-";
				permissionsgroup [1] = "-";
				permissionsgroup [2] = "-";
			}
			else if(octalarray[2] == 1){
				binarygroup [0] = 0;
				binarygroup [1] = 0;
				binarygroup [2] = 1;

				permissionsgroup [0] = "-";
				permissionsgroup [1] = "-";
				permissionsgroup [2] = "x";
			}
			else if(octalarray[2] == 2){
				binarygroup [0] = 0;
				binarygroup [1] = 1;
				binarygroup [2] = 0;

				permissionsgroup [0] = "-";
				permissionsgroup [1] = "w";
				permissionsgroup [2] = "-";
			}
			else if(octalarray[2] == 3){
				binarygroup [0] = 0;
				binarygroup [1] = 1;
				binarygroup [2] = 1;

				permissionsgroup [0] = "-";
				permissionsgroup [1] = "w";
				permissionsgroup [2] = "x";
			}
			else if(octalarray[2] == 4){
				binarygroup [0] = 1;
				binarygroup [1] = 0;
				binarygroup [2] = 0;

				permissionsgroup [0] = "r";
				permissionsgroup [1] = "-";
				permissionsgroup [2] = "-";
			}
			else if(octalarray[2] == 5){
				binarygroup [0] = 1;
				binarygroup [1] = 0;
				binarygroup [2] = 1;

				permissionsgroup [0] = "r";
				permissionsgroup [1] = "-";
				permissionsgroup [2] = "x";
			}
			else if(octalarray[2] == 6){
				binarygroup [0] = 1;
				binarygroup [1] = 1;
				binarygroup [2] = 0;

				permissionsgroup [0] = "r";
				permissionsgroup [1] = "w";
				permissionsgroup [2] = "-";
			}
			else if(octalarray[2] == 7){
				binarygroup [0] = 1;
				binarygroup [1] = 1;
				binarygroup [2] = 1;

				permissionsgroup [0] = "r";
				permissionsgroup [1] = "w";
				permissionsgroup [2] = "x";
			}
			
			else if(octalarray[0] == 2 && binarygroup [2] == 1){
				permissionsgroup [2] = "s";
				
			}
		}
		
		
		for (int y = 0; y < octalarray.length; y++) {
			//otheres
			if(octalarray[3] == 0){
				//print binary
				binaryothers [0] = 0;
				binaryothers [1] = 0;
				binaryothers [2] = 0;
				//print permissions
				permissionsothers [0] = "-";
				permissionsothers [1] = "-";
				permissionsothers [2] = "-";
			}
			else if(octalarray[3] == 1){
				binaryothers [0] = 0;
				binaryothers [1] = 0;
				binaryothers [2] = 1;

				permissionsothers [0] = "-";
				permissionsothers [1] = "-";
				permissionsothers [2] = "x";
			}
			else if(octalarray[3] == 2){
				binaryothers [0] = 0;
				binaryothers [1] = 1;
				binaryothers [2] = 0;

				permissionsothers [0] = "-";
				permissionsothers [1] = "w";
				permissionsothers [2] = "-";
			}
			else if(octalarray[3] == 3){
				binaryothers [0] = 0;
				binaryothers [1] = 1;
				binaryothers [2] = 1;

				permissionsothers [0] = "-";
				permissionsothers [1] = "w";
				permissionsothers [2] = "x";
			}
			else if(octalarray[3] == 4){
				binaryothers [0] = 1;
				binaryothers [1] = 0;
				binaryothers [2] = 0;

				permissionsothers [0] = "r";
				permissionsothers [1] = "-";
				permissionsothers [2] = "-";
			}
			else if(octalarray[3] == 5){
				binaryothers [0] = 1;
				binaryothers [1] = 0;
				binaryothers [2] = 1;

				permissionsothers [0] = "r";
				permissionsothers [1] = "-";
				permissionsothers [2] = "x";
			}
			else if(octalarray[3] == 6){
				binaryothers [0] = 1;
				binaryothers [1] = 1;
				binaryothers [2] = 0;

				permissionsothers [0] = "r";
				permissionsothers [1] = "w";
				permissionsothers [2] = "-";
			}
			else if(octalarray[3] == 7){
				binaryothers [0] = 1;
				binaryothers [1] = 1;
				binaryothers [2] = 1;

				permissionsothers [0] = "r";
				permissionsothers [1] = "w";
				permissionsothers [2] = "x";
			}
			
			else if(octalarray[0] == 1 && binaryothers [2] == 1){
				permissionsothers [2] = "t";	
			}
			System.out.print(binaryowner);
			System.out.print(binarygroup);
			System.out.print(binaryothers);
			System.out.println("and");
			System.out.println(permissionsowner);
			System.out.println(permissionsgroup);
			System.out.println(permissionsothers);
		}
		return s;
	}
}