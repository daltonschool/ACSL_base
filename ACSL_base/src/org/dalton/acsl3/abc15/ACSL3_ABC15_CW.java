package org.dalton.acsl3.abc15;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
public class ACSL3_ABC15_CW {
	
	public static void main(String[] args) {
		
		/* variable declarations for main */
		Scanner in = new Scanner(System.in); // user Input scanner
		boolean[][] grid = new boolean[6][6]; // 7 x 5 grid to fit (true = full)
		String[] line1; // input line 1, split at commas
		LinkedList<Integer> squaresFilled; // filled grid squares from line 1
		Integer currentSquare; // index of current grid square
		int cross1;
		int cross2;
		int cross3;
		int cross4;

		// get list of filled squares from user
		squaresFilled = new LinkedList<Integer>();
		line1 = in.nextLine().split(", ");
		cross1 = Integer.parseInt(line1[0]);
		cross2 = Integer.parseInt(line1[1]);
		cross3 = Integer.parseInt(line1[2]);
		cross4 = Integer.parseInt(line1[3]);
		for (String rawStr : line1) {
			squaresFilled.add(cross1);
			squaresFilled.add(cross2);
			squaresFilled.add(cross3);
			squaresFilled.add(cross4);
		}
		//squaresFilled.removeFirst(); // fixed-length array size? FTS

		// fill each grid square listed by the user
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				currentSquare = new Integer(gridIndex(row, col));
				if (squaresFilled.contains(currentSquare)) {
					grid[row][col] = true;
					squaresFilled.remove(currentSquare);
				} else {
					grid[row][col] = false;
				}
			}
		}
		

		// repeat processing phase for input lines 0-6
		for (int i = 0; i <= 6; i++) {
			grid = addToGrid(Integer.parseInt(in.nextLine().trim()), grid);
//			printGrid(grid); // print out grid after each phase (comment out)
		}
	}

	// adds X pattern to lowest index in grid, prints index, & returns new grid
	
	private static boolean[][] addToGrid(int pattern, boolean[][] grid) {

		/* variable declarations for addToGrid */
		int baseIndex = 36; // lowest index X pattern can occupy
		int row, col; // row and column of baseIndex in grid
		LinkedList<Integer> dropSpots; // all possible drop spots for pattern
		dropSpots = new LinkedList<Integer>();

		// find base index for X pattern 1 or 2
		if (pattern == 1 || pattern == 2) {
			for (int i = 0; i < 6; i++) {
				dropSpots.add(new Integer(dropSpot1(i, grid)));
			}
			Collections.sort(dropSpots);
			baseIndex = dropSpots.getFirst().intValue();
		}

		// find base index for X pattern 3 or 5
		else if (pattern == 3 || pattern == 5) {
			for (int i = 0; i < 4; i++) {
				dropSpots.add(new Integer(dropSpotRow(2, i, grid)));
			}
			Collections.sort(dropSpots);
			baseIndex = dropSpots.getFirst().intValue();
		}

		// find base index for pattern 4
		else if (pattern == 4) {
			for (int i = 0; i < 4; i++) {
				dropSpots.add(new Integer(dropSpotGamma(i, grid)));
			}
			Collections.sort(dropSpots);
			baseIndex = dropSpots.getFirst().intValue();
		}


			// fill grid square at base index of newly added X pattern
			row = gridRow(baseIndex);
			col = gridCol(baseIndex);
			grid[row][col] = true;

			// fill grid square above base index for two-row X patterns
			if (pattern == 2 || pattern == 4 || pattern == 5) {
				grid[row - 1][col] = true;
			}

			// fill grid square right of base index for two-col-base X patterns
			if (pattern == 3 || pattern == 5) {
				grid[row][col + 1] = true;
			}

			// fill grid square above-right base index for X pattern 4
			if (pattern == 4) {
				grid[row - 1][col + 1] = true;
			}

			// print base index of newly added X pattern to user
			System.out.println(new Integer(baseIndex));
		

		// return the grid with given X pattern added
		return grid;
	}
	

	// returns the numeric index (1-35) of a given row and column of the grid
	private static int gridIndex(int row, int col) {
		assert (row >= 0 && row <= 6 && col >= 0 && col <= 4);
		return ((6 - row) * 5) + col + 1;
	}

	// returns the grid row (0-6) containing the given numeric index
	private static int gridRow(int index) {
		assert (index >= 1 && index <= 35);
		while (index % 5 != 0) {
			index++;
		}
		return 7 - (index / 5);
	}

	// returns the grid column (0-4) containing the given numeric index
	private static int gridCol(int index) {
		assert (index >= 1 && index <= 35);
		return (index + 4) % 5;
	}

	// returns the index to which a single X will drop in the given column
	private static int dropSpot1(int col, boolean[][] grid) {
		assert (col >= 0 && col <= 4);
		int index = col + 36;
		while (index >= 6 && !grid[gridRow(index - 5)][gridCol(index - 5)]) {
			index -= 5;
		}
		return index;
	}

	// returns the index to which a row of n X's will drop in the given column
	private static int dropSpotRow(int n, int col, boolean[][] grid) {
		LinkedList<Integer> singleSpots = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			singleSpots.add(new Integer(dropSpot1(col + i, grid) - i));
		}
		Collections.sort(singleSpots);
		return singleSpots.getLast().intValue();
	}

	// returns the index to which X pattern 4 will drop in the given column
	private static int dropSpotGamma(int col, boolean[][] grid) {
		int topSpot = dropSpotRow(2, col, grid) - 5;
		int botSpot = dropSpot1(col, grid);
		if (topSpot > botSpot) {
			return topSpot;
		} else {
			return botSpot;
		}
	}

}
