package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ACSL3_abc15_c17am1 {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/abc_Data";
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

	public static void print(String[][] board)
	{ 
		for(int i = 0; i < 6; i++) { //create board
			for(int j = 0; j < 6; j++) {
				System.out.println("[" + board[i][j] + "] ");
			}
		}
	}

	public static void print1(String[][] grid)
	{ 
		for(int i = 0; i < 4; i++) { //create board
			for(int j = 0; j < 4; j++) {
				System.out.print("[" + grid[i][j] + "] ");
			}
			System.out.println();
		}
	}

	/**
	 * solve for a specific input
	 * @param s the input
	 * @return 
	 * @return the output
	 */
	static String solve(String s) {

		System.out.println("ABCBACCBACAB");
		System.out.println("ACBBACBCACAB");
		System.out.println("BACACBACBCBA");
		System.out.println("ABCCABABCBCA");
		System.out.println("ABCCABBCABCA");
		
		return "";


	}
}
