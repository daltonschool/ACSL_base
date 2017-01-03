package org.dalton.acsl3.abc15;



import java.util.ArrayList;
import java.util.Scanner;

public class ACSL3_ABC15_C16CL {
	
	public static final int SIZE = 4;
	public static final int SIZE_2 = SIZE * SIZE;
	public static final int SIZE_3 = SIZE * SIZE * SIZE;
	
	public static void main(String[] args) {
		
		long nano;
		
		Scanner scan = new Scanner(System.in);
		for(int zzz=0; zzz<5; zzz++) {
			String[] inputs = scan.nextLine().split(", ");
			nano = System.nanoTime();
			int[][] puzzle = new int[4][4];
			for(int i=0; i<4; i++) {
				int plus = Integer.parseInt(inputs[i]) - 1;
				puzzle[plus % 6 - 1][plus / 6 - 1] = 4;
			}
			for(int i=5; i<inputs.length; i+=2) {
				int piece = inputs[i].charAt(0) - 'A' + 1;
				int number = Integer.parseInt(inputs[i+1]);
				
				if(number <= 5) {
					int column = number - 2;
					if(puzzle[column][0] != 4) puzzle[column][0] = piece;
					else puzzle[column][1] = piece;
				}else if(number >= 32) {
					int column = number - 32;
					if(puzzle[column][3] != 4) puzzle[column][3] = piece;
					else puzzle[column][2] = piece;
				}else if(number % 6 == 1) {
					int row = number / 6 - 1;
					if(puzzle[0][row] != 4) puzzle[0][row] = piece;
					else puzzle[1][row] = piece;
				}else {
					int row = number / 6 - 2;
					if(puzzle[3][row] != 4) puzzle[3][row] = piece;
					else puzzle[2][row] = piece;
				}
			}
			
//			for(int i=0; i<4; i++) {
//				for(int j=0; j<4; j++) {
//					System.out.print(puzzle[j][i] + " ");
//				}
//				System.out.println();
//			}
			
			ExactCover cover = convert(puzzle);
			ArrayList<ArrayList<ExactCover.Node>> solutions = cover.dancingLinks();
			
			int[][] solved = puzzle.clone();
			
			for (ArrayList<ExactCover.Node> solution : solutions) {
				for (ExactCover.Node entry : solution) {
					int row = entry.row / SIZE_2;
					int column = (entry.row % SIZE_2) / SIZE;
					int value = entry.row % SIZE + 1;

					solved[row][column] = value;
				}
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(solved[j][i] != 4)
					System.out.print((char)(solved[j][i] + 'A' - 1));
				}
			}
			System.out.println();
			
			System.out.println(System.nanoTime() - nano);
		}
	}
	
	public static ExactCover convert(int[][] puzzle) {
		ExactCover cover = new ExactCover(SIZE_3, SIZE_2 * 3); // 3 constraints

		// Rows
		for (int r = 0; r < SIZE; r++) {
			// Columns
			for (int c = 0; c < SIZE; c++) {
				// Nums
				for (int n = 0; n < SIZE; n++) {
					int matrow = r * SIZE_2 + c * SIZE + n;

					// Constraint: one number in each square
					cover.matrix[r * SIZE + c][matrow] = true;

					// Constraint: one number of each type in each row
					cover.matrix[SIZE_2 + r * SIZE + n][matrow] = true;

					// Constraint: one number of each type in each column
					cover.matrix[2 * SIZE_2 + c * SIZE + n][matrow] = true;

					// Constraint: one number of each type in each box
					// NOT FOR THIS ACSL
					//int b = r / BOX_SIZE * BOX_SIZE + c / BOX_SIZE;
					//cover.matrix[3 * SIZE_2 + b * SIZE + n][matrow] = true;
				}
			}
		}

		cover.setupNodes();

		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (puzzle[r][c] > 0 && puzzle[r][c] < SIZE + 1) {
					int row = r * SIZE_2 + c * SIZE + puzzle[r][c] - 1;
					if(!cover.coverRow(row)) return null;
				}
			}
		}

		return cover;
	}
	
	public static class ExactCover {
		public boolean[][] matrix;
		
		private ArrayList<ArrayList<Node>> solutions;
		private ArrayList<Node> currentSolution;
		
		public Node root = null;
		
		public int max_solutions = 1;

		public ExactCover(int rows, int columns) {
			matrix = new boolean[columns][rows];
			
			for(int i=0; i<columns; i++) {
				for(int j = 0; j < rows; j++) {
					matrix[i][j] = false;
				}
			}
		}
		
		public void printSols() {
			dancingLinks();
			
			for(ArrayList<Node> solution : solutions) {
				System.out.println("NEW SOLUTION::::::");
				for(Node entry : solution) {
					System.out.println("ROW: " + entry.row);
				}
				System.out.println();
			}
		}
		
		public void printSol() {
			System.out.println("NEW SOLUTION::::::");
			for (Node entry : currentSolution) {
				System.out.println("ROW: " + entry.row);
			}
			System.out.println();
		}
		
		public void setupNodes() {
			//printMat();
			root = new Node();

			// Set up column headers
			for (int c = 0; c < matrix.length; c++) {
				ColumnNode column = new ColumnNode();
				column.row = -1;
				column.left = root.left;
				column.right = root;
				column.right.left = column;
				column.left.right = column;
		
				for (int r = 0; r < matrix[c].length; r++) {
					if (matrix[c][r]) {
						column.validEntries++;
					}
				}
			}
		
			// Fill in row headers + rest of nodes
			for (int r = 0; r < matrix[0].length; r++) {
				Node rowNode = new Node();
				rowNode.row = r;
				
				rowNode.down = root;
				rowNode.up = root.up;
				rowNode.up.down = rowNode;
				rowNode.down.up = rowNode;
				
				int c = 0;
				for (Node column = root.right; column != root; column = column.right, c++) {
					if (matrix[c][r]) {
						Node newNode = new Node();
						
						newNode.row = r;
						
						newNode.column = (ColumnNode) column;
						
						newNode.up = column.up;
						newNode.down = column;
						newNode.up.down = newNode;
						newNode.down.up = newNode;
		
						newNode.right = rowNode;
						newNode.left = rowNode.left;
						newNode.right.left = newNode;
						newNode.left.right = newNode;
					}
				}
			}
		}
		
		public void printMat() {
			for(int i=0; i<matrix[0].length; i++) {
				for(int j=0; j<matrix.length; j++) {
					if(matrix[j][i]) {
						System.out.print("1 ");
					}else {
						System.out.print("0 ");
					}
				}
				System.out.println();
			}
		}
		
		public void printNodes() {
			for(Node row = root.down; row != root; row = row.down) {
				System.out.println("ROW " + row.row);
			}
		}

		public ArrayList<ArrayList<Node>> dancingLinks() {
			
			solutions = new ArrayList<ArrayList<Node>>();
			currentSolution = new ArrayList<Node>();
			
			search();
			
			return solutions;
		}
		
		private void search() {
			if(root.right == root) {
				solutions.add((ArrayList<Node>) currentSolution.clone());
				//this.printSol();
				//System.out.println("Found Solution");
				return;
			}
			ColumnNode column = pickNextColumn(root);
			cover(column);
			

			for (Node row = column.down; row != column; row = row.down) {
				currentSolution.add(row);
				
				for (Node rightNode = row.right; rightNode != row; rightNode = rightNode.right) {
					if(rightNode.column != null)
						cover(rightNode);
				}
				if(solutions.size() < max_solutions)
					search();

				currentSolution.remove(row);

				for (Node leftNode = row.left; leftNode != row; leftNode = leftNode.left) {
					if(leftNode.column != null)
						uncover(leftNode);
				}
			}

			uncover(column);
		}
		
		public boolean coverRow(int r) {
			Node row = root.down;
			for(;row != root; row = row.down) {
				if(row.row == r) {
					break;
				}
			}
			if(row == root) {
				System.out.println("ROW INVALID");
				return false;
			}
			
			if(row.right.covered) {
				return false;
			}
			
			for (Node rightNode = row.right; rightNode != row; rightNode = rightNode.right) {
				cover(rightNode);
			}
			
			return true;
		}

		public void cover(ColumnNode column) {
			
			column.right.left = column.left;
			column.left.right = column.right;

			for (Node row = column.down; row != column; row = row.down) {
				for (Node rightNode = row.right; rightNode != row; rightNode = rightNode.right) {
					if(rightNode.column != null && rightNode.covered == false) {
						rightNode.up.down = rightNode.down;
						rightNode.down.up = rightNode.up;
						rightNode.column.validEntries--;
						rightNode.covered = true;
					}
				}
			}
		}
		
		public void cover(Node node) {
			if(node.column != null)
				cover(node.column);
		}
		
		public void uncover(ColumnNode column) {

			for (Node row = column.up; row != column; row = row.up) {
				for (Node leftNode = row.left; leftNode != row; leftNode = leftNode.left) {
					if(leftNode.column != null && leftNode.covered == true) {
						leftNode.up.down = leftNode;
						leftNode.down.up = leftNode;
						leftNode.column.validEntries++;
						
						leftNode.covered = false;
					}
				}
			}
			
			column.right.left = column;
			column.left.right = column;
		}
		
		public void uncover(Node node) {
			if(node.column != null)
				uncover(node.column);
		}

		private ColumnNode pickNextColumn(Node root) {
			ColumnNode ret = (ColumnNode) root.right;
			int min = ret.validEntries;
			for (Node node = root.right.right; node != root; node = node.right) {
				ColumnNode c = (ColumnNode) node;
				if (c.validEntries < min) {
					min = c.validEntries;
					ret = c;
				}
			}
			
			//System.out.println(min);

			return ret;
		}

		class Node {
			Node left;
			Node right;
			Node up;
			Node down;
			
			ColumnNode column;
			
			int row;
			
			boolean covered = false;

			public Node() {

				this.right = this.left = this.up = this.down = this;
			}
		}

		class ColumnNode extends Node {
			int validEntries = 0;
		}
	}
}
