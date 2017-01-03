package org.dalton.acsl3.abc15;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class ACSL3_abc15_NO {

	public static void main(String[] args) throws IOException {
		
		int i = 0;
		
		try {
			Scanner in = new Scanner(new File("data.in"));
			while(in.hasNext()) {
				System.out.println((++i) + ". " + solve(in.nextLine()));
			}
		} catch(Exception e) {
			
			Scanner in = new Scanner(System.in);
			while(in.hasNext()) {
				System.out.println((++i) + ". " + solve(in.nextLine()));
			}
		}

		


	}

	public static String solve(String line) {
		long startTime = System.nanoTime();

		line = line.replaceAll(" ", "");
		line = line.substring(line.indexOf(".")+1);

		//System.out.println(line);
		char[][] grid6 = new char[6][6];
		for(int i = 0; i < grid6.length; i++) {
			Arrays.fill(grid6[i], '_');
		}



		String[] parts = line.split(",");

		for(int i = 0; i < 4; i++) {
			int val = Integer.parseInt(parts[i]);
			//System.out.println(val);
			grid6[(val-1)/6][(val-1)%6] = '*';
		}

		int numNext = Integer.parseInt(parts[4]);

		for(int i = 5; i < numNext*2+5; i+=2) {
			char c = parts[i].charAt(0);
			int loc = Integer.parseInt(parts[i+1]);

			grid6[(loc-1)/6][(loc-1)%6] = c;
		}

		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if(grid6[i][j] != '_' && grid6[i][j] != '*') {
					if(j == 0) {
						for(int k = 1; k < 5; k++) {
							if(grid6[i][k] == '_') {
								swap(grid6, i, j, i, k);
							}
						}
					}
					if(j == 5) {
						for(int k = 5; k > 0; k--) {
							if(grid6[i][k] == '_') {
								swap(grid6, i, j, i, k);
							}
						}
					}
					if(i == 0) {
						for(int k = 1; k < 5; k++) {
							if(grid6[k][j] == '_') {
								swap(grid6, k, j, k, j);
							}
						}
					}
					if(i == 5) {
						for(int k = 5; k > 0; k--) {
							if(grid6[k][j] == '_') {
								swap(grid6, k, j, k, j);
							}
						}
					}
				}
			}
		}

		char[][] grid4 = new char[4][4];

		for(int i = 0; i < 4; i ++) {
			for(int j = 0; j < 4; j++) {
				grid4[i][j] = grid6[i+1][j+1];
			}
		}


		sedoku(grid4);


		String res = "";

		for(char[] arr : grid4) {
			for(char c : arr) {
				if(c!='*') {
					res += c;
				}
			}
		}

		//System.out.println(System.nanoTime() - startTime);
		
		return res;
	}

	public static void sedoku(char[][] grid) {

		long startTime = System.nanoTime();
		
		while(!solved(grid)) {	
			
			if(System.nanoTime() - startTime > Math.pow(10, 7)) {
				return;
			}
				
			//check horizontals
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(grid[i][j] != '_')
						continue;
					String vertPoss = findPoss(new char[]{grid[0][j], grid[1][j], grid[2][j], grid[3][j]});
					String horPoss = findPoss(grid[i]);

					char res = intersect(vertPoss, horPoss);

					if(res != 'N') {
						grid[i][j] = res;
					}
				}
			}


		}
	}

	static char intersect(String s1, String s2) {
		HashSet<Character> h1 = new HashSet<Character>(), h2 = new HashSet<Character>();
		for(int i = 0; i < s1.length(); i++)                                            
		{
			h1.add(s1.charAt(i));
		}
		for(int i = 0; i < s2.length(); i++)
		{
			h2.add(s2.charAt(i));
		}
		h1.retainAll(h2);
		Character[] res = h1.toArray(new Character[0]);

		if(res.length > 1) {
			return 'N';
		}
		else {
			return res[0];
		}
	}

	static String findPoss(char[] arr) {
		String poss = "";

		if(!in(arr, 'A')) {
			poss += 'A';
		}
		if(!in(arr, 'B')) {
			poss += 'B';
		}
		if(!in(arr, 'C')) {
			poss += 'C';
		}

		return poss;
	}

	static char findMissing(char[] arr) {

		boolean hasA = false;
		boolean hasB = false;
		boolean hasC = false;

		for(char c : arr) {
			if(c == 'A')
				hasA = true;
			if(c == 'B')
				hasB = true;
			if(c == 'C')
				hasC = true;
		}

		if(!hasA) {
			return 'A';
		}
		if(!hasB) {
			return 'B';
		}
		if(!hasC)
			return 'C';
		return 'X';
	}

	static boolean in(char[] arr, char c) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == c)
				return true;
		}
		return false;
	}

	static boolean solved(char[][] grid) {
		for(char[] c1 : grid) {
			for(char c : c1) {
				if(c == '_')
					return false;
			}
		}
		return true;
	}
	public static void swap(char[][] grid, int i1, int j1, int i2, int j2) {
		char tmp = grid[i1][j1];
		grid[i1][j1] = grid[i2][j2];
		grid[i2][j2] = tmp;
	}

	public static void print(char[][] c) {
		for(char[] c1 : c) {
			for(char c2 : c1) {
				System.out.print(c2 + " ");
			}
			System.out.println();
		}
	}
	public static void print(char[] c) {
		for(char c1 : c) {
			System.out.print(c1 + " ");
		}
		System.out.println();
	}

}
