package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ACSL3_abc15 {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/abc16";
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

	final static int A = 1, B = 2, C = 3, X = 5;
	
	/**
	 * solve for a specific input
	 * @param s the input
	 * @return the output
	 */
	static String solve(String s) {
		String[] ns = s.split(", ?");
		int[][] board = new int[6][6];
		
		int i = 0;
		// Add in roadblocks
		for (; i < 4; i++) {
			int var = Integer.parseInt(ns[i]);
			board[r(var)][c(var)] = X;
		}
		int n = Integer.parseInt(ns[4]);

		// Add in clues
		for (i=5; i < 5+n*2; i+=2) {
			int letter = (int) ns[i].charAt(0) - 'A' + 1;
			
			int pos = Integer.parseInt(ns[i+1]);
			board[r(pos)][c(pos)] = letter;
		}
		
		// Use clues to populate board with what we know
		for(int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				int clue = board[row][col];
				if (clue > 0 && clue < 4) {
					if (row == 0) {
						int j;
						for (j = 1; j < board.length-1; j++)
							if (board[j][col] != 5) break;
						
						board[j][col] = clue;
					}
					if (row == board.length-1) {
						int j;
						for (j = row-1; j > 0; j--)
							if (board[j][col] != 5) break;
						board[j][col] = clue;
					}
					if (col == 0) {
						int j;
						for (j = 1; j < board[0].length-1; j++)
							if (board[row][j] != 5) break;
						
						board[row][j] = clue;
					}
					if (col == board[0].length-1) {
						int j;
						for(j = col-1; j > 0; j--)
							if (board[row][j] != 5) break;
						
						board[row][j] = clue;
					}
					
				}
			}
		}
		// Fill in rest of board
		boolean notFinished = true;
		while(notFinished) { // while there's still blank spaces
			notFinished = false;
			for (int row = 1; row < board.length-1; row++) {
				for (int col = 1; col < board[0].length-1; col++) {
					if (board[row][col] == 0) { // when we get to a blank space
						notFinished = true;
						board[row][col] = solveSquare(row, col, board);
					}
				}
			}
		}
		// generate solution string
		StringBuffer soln = new StringBuffer();
		for (int row = 1; row < board.length-1; row++)
			for (int col = 1; col < board[0].length-1; col++) {
				int x = board[row][col];
				soln.append(x==A?'A' :x==B?'B' :x==C?'C' :"");
			} 
		return soln.toString();
	}
	
	static int contains(char c, char[] A) {
		for (int i = 0; i < A.length; i++)
			if (A[i] == c) return i;
		return -1;
	}
	
	static int solveSquare(int rx, int cx, int[][] b) {
		boolean ba = false;
		boolean bb = false;
		boolean bc = false;
		
		// Look for any letters in the row.
		for (int i = 1; i < b[rx].length-1; i++) {
			switch( b[rx][i]) {
			case A:
				ba = true;
				break;
			case B:
				bb = true;
				break;
			case C:
				bc = true;
				break;
			}
		}
		// look for any letters in the column.
		for (int i = 1; i < b.length-1; i++) {
			switch( b[i][cx]) {
			case A:
				ba = true;
				break;
			case B:
				bb = true;
				break;
			case C:
				bc = true;
				break;
			}
		}
		/* 
		 * if there are two different letters in the related row and column,
		 * we have enough information to determine the contents of this square.
		 * If there is a C in the row and a A in the column, then that one must be a B,
		 * Because if it was a C it would be 2 Cs in a row, or if it was an A then 
		 * 2 As in the column
		 */
		if (ba && bb) return C;
		if (bb && bc) return A;
		if (bc && ba) return B;
		
		return 0;
	}
	
	static int c(int num) {
		return (num-1) % 6;
	}
	static int r(int num) {
		return (int)Math.floor((num-1)/6);
	}
}
