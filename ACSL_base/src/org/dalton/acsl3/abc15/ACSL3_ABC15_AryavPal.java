package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ACSL3_ABC15_AryavPal {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/aryavtes";
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
		char[] solution = new char[12];
		String solved;
		int count = 0;
		String[] input = parse(s);
		char[][] arr = buildArr(input);
		fill(arr);
		fill(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i>0 && i<5 && j>0 && j<5 && arr[i][j]!='+') {
					solution[count] = (char) (arr[i][j] - 32);
					count++;
				}
			}
		}
		solved = new String(solution);
		return (solved);
	}
	static String[] parse(String s) {
		String[] data = s.split(",[ ]*");
		return data;
	}
	static int[] packagePlus(String[] input){
		int[] plus = new int[4];
		for (int i = 0; i < 4; i++) {
			plus[i] = Integer.parseInt(input[i]);
		}
		return plus;
	}
	static int[] packageLoc(String[] input, int num){
		int[] loc = new int[num];
		int j = 0;
		for (int i = 6; i < input.length; i=i+2) {
			loc[j] = Integer.parseInt(input[i]);
			j++;
		}
		return loc;
	}
	static char[] packageRest(String [] input, int num){
		char[] rest = new char[num];
		int j = 0;
		for (int i = 5; i < input.length -1; i=i+2) {
			rest[j] = input[i].charAt(0);
			j++;
		}
		return rest;
	}
	static int row(int i){
		int row;
		if(i%6==0) row = i/6 -1;
		else row = (i/6);
		return row;
	}
	static int col(int i){
		int col = i%6-1;
		if(col==-1) col = 5;
		return col;
	}
	static void insertPlus(int plus, char[][] arr){
		int row = row(plus);
		int col = col(plus);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(i == row && j == col) arr[i][j] = '+';
			}
		}
	}
	static void insertRest(int loc, char letter, char[][] arr){
		int row = row(loc);
		int col = col(loc);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i == row && j == col) arr[i][j] = letter;
				if(arr[i][j]  != 'A'&&arr[i][j]  != 'B'&&arr[i][j]  != 'C'&&arr[i][j]  != '+') arr[i][j] = '_';
			}
		}
		fill(arr);
	}
	static void fill(char[][] board){
		//fill the givens
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == 'A' || board[i][j] =='B' || board[i][j] == 'C') {
					if(j==0) {
						if(board[i][j+1]!='+') board[i][j+1] = (char) (board[i][j] + 32);
						else board[i][j+2] = (char) (board[i][j] + 32);
					}
					if(j==5) {
						if(board[i][j-1]!='+') board[i][j-1] = (char) (board[i][j] + 32);
						else board[i][j-2] = (char) (board[i][j] + 32);
					}
					if(i==0) {
						if(board[i+1][j]!='+') board[i+1][j] = (char) (board[i][j] + 32);
						else board[i+2][j] = (char) (board[i][j] + 32);
					}
					if(i==5) {
						if(board[i-1][j]!='+') board[i-1][j] = (char) (board[i][j] + 32);
						else board[i-2][j] = (char) (board[i][j] + 32);
					}
				}
			}
		}
		//check next space (row and column)
		//check full?
		//repeat
		int counter = 0;
		while(counter<500) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if(i>0 && i<5 && j>0 && j<5 && board[i][j]  != 'A'&&board[i][j]  != 'B'&&board[i][j]  != 'C'&& board[i][j]  != 'a'&&board[i][j]  != 'b'&&board[i][j]  != 'c'&&board[i][j]  != '+') {
						if(intuitiveFill(board, i, j)==0)board[i][j] = 'a';
						if(intuitiveFill(board, i, j) == 1)board[i][j] = 'b';
						if(intuitiveFill(board, i, j) == 2)board[i][j] = 'c';
					}
				}
			}
			counter++;
		}
	}
	static int intuitiveFill(char[][] board, int row, int col) {
		boolean[] arr = new boolean[3];
		int count = 0;
		//check row
		for (int i = 0; i < board.length; i++) {
			if(board[row][i] == 'a' || board[row][i] == 'b' || board[row][i] == 'c') arr[board[row][i] - 97] = true;
		}
		//check col
		for (int i = 0; i < board.length; i++) {
			if(board[i][col] == 'a' || board[i][col] == 'b' || board[i][col] == 'c') arr[board[i][col] - 97] = true;
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==false)  count++;
		}
		if(count==1) {
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]==false) return i;
			}
		}
		return 3;
	}
	static char[][] buildArr(String[] input){
		char[][] abc = new char[6][6];
		int[] plus = packagePlus(input);
		int[] loc = packageLoc(input, Integer.parseInt(input[4]));
		char[] rest = packageRest(input, Integer.parseInt(input[4]));
		for (int i = 0; i < plus.length; i++) {
			insertPlus(plus[i], abc);
		}
		for (int i = 0; i < rest.length; i++) {
			insertRest(loc[i], rest[i], abc);
		}
		return abc;
	}
}
