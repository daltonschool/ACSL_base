package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ACSL3_ABC15_c17gg {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/TITLEYEAR";
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
		String[] parsed = s.split(",[ ]*");
		char[][] board = new char[4][4];
		for(int i = 0; i < 4; i++){
			if(Integer.parseInt(parsed[i]) < 12){
				board[0][Integer.parseInt(parsed[i])-8] = 'x';
			}
			else if(Integer.parseInt(parsed[i]) < 18){
				board[1][Integer.parseInt(parsed[i])-14] = 'x';
			}
			else if(Integer.parseInt(parsed[i]) < 24){
				board[2][Integer.parseInt(parsed[i])-20] = 'x';
			}
			else if(Integer.parseInt(parsed[i]) < 30){
				board[3][Integer.parseInt(parsed[i])-26] = 'x';
			}
			
		}
		for(int i = 6; i < 13; i=i+2){
			int row = (Integer.parseInt(parsed[i])-1)/6;
			System.out.println("I: " + Integer.parseInt(parsed[i]));
			System.out.println("ROW: "+ row);
		}
		
				 
		return s;
	}

}


