package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ACSL3_ABC15_c16dt {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/ABC15---";
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

	static char[][] arr;

	/**
	 * solve for a specific input
	 * @param s the input
	 * @return the output
	 */
	static String solve(String s) {
		
		long time = System.nanoTime();

		String[] in = s.split(",[ ]*");
		
		arr = new char[6][6];

		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(in[i]);
			arr[row(n)][col(n)] = '+';
		}

		int idx;
		for (int i = 0; i < Integer.parseInt(in[4]); i++) {
			idx = 5 + i*2;
			char letter = in[idx].charAt(0);
			idx++;
			int n = Integer.parseInt(in[idx]);
			int row = row(n);
			int col = col(n);
			if (row == 0) {
				row++;
				while(arr[row][col] == '+') row++;
			}
			if (row == 5) {
				row--;
				while(arr[row][col] == '+') row--;
			}
			if (col == 0) {
				col++;
				while(arr[row][col] == '+') col++;
			}
			if (col == 5) {
				col--;
				while(arr[row][col] == '+') col--;
			}
			arr[row][col] = letter;
		}

//		for (int i = 1; i < 5; i++){
//			for (int j = 1; j < 5; j++) {
//				if (arr[i][j] == '\0') System.out.print("-");
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}

		
		boolean solved = false;
		while (!solved){
			solved = true;
			for (int i = 1; i < 5; i++) {
				for(int j = 1; j < 5; j++) {
					if (arr[i][j]=='\0') solved = false;
					if (arr[i][j]=='+') continue;
					char letter = solve(i, j);
					if (letter != '\0') arr[i][j] = letter;
				}
			}
			
		}
		
		


//		for (int i = 1; i < 5; i++){
//			for (int j = 1; j < 5; j++) {
//				if (arr[i][j] == '\0') System.out.print("-");
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}

		
		String out = "";
		
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				char l = arr[i][j];
				if (l!='+') out += l;
			}
		}
		
	//	System.out.println(System.nanoTime() - time);
		
		return out;
	}

	static int row(int idx) {
		return (idx-1)/6;
	}

	static int col(int idx) {
		return (idx-1)%6;
	}


	static char solve(int row, int col) {


		int a = 0;
		int b = 0;
		int c = 0;

		//columns
		for (int i = 1; i < 5; i++) {
			if (i == row) continue;
			if (arr[i][col] == 'A') a = 1;
			if (arr[i][col] == 'B') b = 1;
			if (arr[i][col] == 'C') c = 1;
		}

		// rows
		for (int i = 1; i < 5; i++) {
			if (i == col) continue;
			if (arr[row][i] == 'A') a = 1;
			if (arr[row][i] == 'B') b = 1;
			if (arr[row][i] == 'C') c = 1;
		}

		if (a+b+c == 2) {
			if (a == 0) return 'A';
			if (b == 0) return 'B';
			if (c == 0) return 'C';
		}
		return '\0';
	}

}
