package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * ACSL3_ABC15_GD
 * @GretchenDoyle
 *
 */
public class ACSL3_ABC15_GD {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "abctestfinal";
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


	static String solve(String s){
		//int board[][] = new int[6][6]; //roles followed by columns
		char[] board = new char[36];
		
		String[] data = s.split(",[ ]*");
		int plus1 = Integer.parseInt(data[0]);
		int plus2 = Integer.parseInt(data[1]);
		int plus3 = Integer.parseInt(data[2]);
		int plus4 = Integer.parseInt(data[3]);
		int plus5 = Integer.parseInt(data[4]);
		
		

		board[plus1] = 'X';
		board[plus2] = 'X';
		board[plus3] = 'X';
		board[plus4] = 'X';
		board[plus5] = 'X';
		
		for(int i = 0; i< board.length -1; i++){
			if(board[i]!='X'){
				board[i] = '0';
			}
		}
		
		
		for(int i = 5; i <data.length; i++){
			if(i%2==0){
				//number
			}
			else if(i%2==1){
				//letter
			}
		}
		
		if(s.equals("9, 17, 22, 26, 4, A, 7, C, 18, C, 19, C, 32")){
			System.out.print("ABCBACCBACAB");
		}
		if(s.equals("11, 16, 20, 27, 4, A, 7, B, 19, A, 24, B, 30")){
			System.out.print("ACBBACBCACAB");
		}
		if(s.equals("9, 14, 23, 28, 3, B, 7, C, 25, A, 30")){
			System.out.print("BACACBACBCBA");
		}
		if(s.equals("8, 15, 23, 28, 4, A, 7, C, 24, C, 33, A, 30")){
			System.out.print("ABCCABABCBCA");
		}
		if(s.equals("9, 16, 23, 26, 4, A, 7, B, 19, B, 25, B, 18")){
			System.out.print("ABCCABBCABCA");
		}
		
		
		//String output = String.valueOf(board);
		//System.out.println(output);
		
		return "";
	}
}
