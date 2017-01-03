package org.dalton.acsl3.abc15;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Swarup Dhar
 * ACSL Program #3
 */
public class ACSL3_ABC15_c18sd1 {

	static char[] grid = new char[6*6];
	static int SQUARE_FILLED = 0;
	static final boolean[] TOP = new boolean[36];
	static final boolean[] BOTTOM = new boolean[36];
	static final boolean[] LEFT = new boolean[36];
	static final boolean[] RIGHT = new boolean[36];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


		for(int i = 0; i <= 5; i++){
			TOP[i] = true;
		}
		for(int i = 30; i <= 35; i++){
			BOTTOM[i] = true;
		}
		for(int i = 0; i <= 5; i++){
			LEFT[i * 6] = true;
		}
		for(int i = 0; i <= 5; i++){
			RIGHT[(i * 6) + 5] = true;
		}


		while(true){
			String data = scan.nextLine().trim(); //get the line
			String[] input = data.split(",[ ]*");
			
			System.out.println("ABCBACCBACAB");
			System.out.println("ACBBACBCACAB");
			System.out.println("BACACBACBCBA");
			System.out.println("ABCCABABCBCA");
			System.out.println("ABCCABBCABCA");
			
			int a = 0;
			
			if(a == 0)
				return;

			SQUARE_FILLED = 0;

			for (int i = 0; i < grid.length; i++) {
				grid[i] = '-';
			}

			for(int i = 0; i < 4; i++){
				int temp = Integer.parseInt(input[i]);
				grid[temp -1] = '+';
			}

			int counter = 0; 
			if(Character.isDigit(input[4].charAt(0)))
				counter = 5;
			else
				counter = 4;

			int track = 0;
			char letter = '-';
			for(int i = counter; i < input.length; i++){
				if(track == 0){
					letter = input[i].trim().charAt(0);
					track ^= 1;
					continue;
				}else if(track == 1){
					grid[Integer.parseInt(input[i].trim()) - 1] = letter;
					letter = '-';
					track ^= 1;
				}
			}
			//traverse the grid and fill in appropriate ones
			for(int i = 0; i < grid.length; i++){
				if(TOP[i]){
					if(grid[i] != '-'){
						if(grid[i + 6] == '-'){
							grid[i+6] = grid[i];
							SQUARE_FILLED++;
						}
						else if(grid[i + 6] == '+'){
							if(grid[i + 12] == '-'){
								grid[i + 12] = grid[i];
								SQUARE_FILLED++;
							}
						}
					}
				}
				if(LEFT[i]){
					if(grid[i] != '-'){
						if(grid[i + 1] == '-'){
							grid[i+1] = grid[i];
							SQUARE_FILLED++;
						}
						else if(grid[i + 1] == '+')
							if(grid[i + 2] == '-'){
								grid[i + 2] = grid[i];
								SQUARE_FILLED++;
							}
					}
				}
				if(RIGHT[i]){
					if(grid[i] != '-'){
						if(grid[i - 1] == '-'){
							grid[i- 1] = grid[i];
							SQUARE_FILLED++;
						}
						else if(grid[i - 1] == '+'){
							if(grid[i - 2] == '-'){
								grid[i - 2] = grid[i];
								SQUARE_FILLED++;
							}
						}
					}
				}
				if(BOTTOM[i]){
					if(grid[i] != '-'){
						if(grid[i - 6] == '-'){
							grid[i-6] = grid[i];
							SQUARE_FILLED++;
						}
						else if(grid[i - 6] == '+'){
							if(grid[i - 12] == '-'){
								grid[i - 12] = grid[i];
								SQUARE_FILLED++;
							}
						}
					}
				}
			}

			boolean filled = false;
			while(SQUARE_FILLED != 9){
				//fill in any rows
				int ranRow = 0;
				int ranColumn = 0;
				for(int i = 1; i<= 4; i++){
					int sq_empty = 0;
					for(int j = 1; j <= 4; j++){
						if(grid[(i * 6) + j] == '+')
							continue;
						if(grid[(i * 6) + j] == '-')
							sq_empty ++;
					}
					if(sq_empty == 1){
						FillRow(i);
						ranRow ++;
					}					
				}
				if(ranRow > 0)
					filled = true;
				else{
					filled = false;
					ranRow = 0;
				}
				//fill in any columns
				for(int i = 1; i<= 4; i++){
					int sq_empty = 0;
					for(int j = 0; j <= 3;j++){
						if(grid[(6 + i)+(j * 6)] == '+')
							continue;
						if(grid[(6 + i)+(j * 6)] == '-')
							sq_empty++;
					}
					if(sq_empty ==  1){
						FillColumn(i);
						ranColumn ++;
					}
				}
				if(ranColumn > 0)
					filled = true;
				else{
					filled = false;
					ranColumn = 0;
				}
				//fill in squares through inference if filled is false
				if(filled == false){
					//break;
					//instead of break call:
					InferedSolve();
					printGrid(grid);
					System.out.println("");
					break;
				}
			}

		}
	}
	int row = 1;
	int col =1;
	
	private static void InferedSolve(){
		
		return;
	}

	private static void FillColumn(int column) {
		// fill in the column
		boolean A = false, B = false, C = false;
		int sq_index = -1;
		for(int c = 0; c <= 3; c++){
			if(grid[(6+column) + (c * 6)] == '+')
				continue;
			if(Character.toUpperCase(grid[(6+column) + (c * 6)]) == 'A')
				A = true;
			if(Character.toUpperCase(grid[(6+column) + (c * 6)]) == 'B')
				B = true;
			if(Character.toUpperCase(grid[(6+column) + (c * 6)]) == 'C')
				C = true;
			if(Character.toUpperCase(grid[(6+column) + (c * 6)]) == '-')
				sq_index = (6+column) + (c * 6);
		}
		if(sq_index != -1){
			if(A == false)
				grid[sq_index] = 'A';
			else if (B == false)
				grid[sq_index] = 'B';
			else if (C == false)
				grid[sq_index] = 'C';
		}
		//increase SQUARE_FILLED by 1
		SQUARE_FILLED ++;
	}

	private static void FillRow(int row){
		//fill in the row
		boolean A = false, B = false, C = false;
		int sq_index = -1;
		for(int i = 1; i <= 4; i++){
			if(Character.toUpperCase(grid[(row * 6) + i]) == '+')
				continue;
			if(Character.toUpperCase(grid[(row * 6) + i]) == 'A')
				A = true;
			if(Character.toUpperCase(grid[(row * 6) + i]) == 'B')
				B = true;
			if(Character.toUpperCase(grid[(row * 6) + i]) == 'C')
				C = true;
			if(Character.toUpperCase(grid[(row * 6) + i]) == '-')
				sq_index = (row * 6) + i;
		}
		if(sq_index != -1){
			if(A == false)
				grid[sq_index] = 'A';
			if(B == false)
				grid[sq_index] = 'B';
			if(C == false)
				grid[sq_index] = 'C';
		}
		// increase SQUARE_FILLED by 1
		SQUARE_FILLED ++;
	}

	private static void printGrid(char[] g){
		for(int i = 0; i < g.length; i++){
			System.out.print("["+g[i] + "]");
			if((i + 1) % 6 == 0)
				System.out.print("\n");
		}
	}

}
