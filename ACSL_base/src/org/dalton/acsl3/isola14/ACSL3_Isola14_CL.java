package org.dalton.acsl3.isola14;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL3_Isola14_CL {

	public static final int BLANK = 0, PLUS = 1, CROSS = 2, WALL = 3;

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		for (int time = 0; time < 5; time++) {
			String input = scan.nextLine();

			Point plus = new Point(), cross = new Point();

			int[][] board = parseBoard(input, plus, cross);

			//printBoard(board);

			// Find all empties around the plus

			ArrayList<Point> empties = new ArrayList<Point>();
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (i == 0 && j == 0)
						continue;
					int x = plus.x + i, y = plus.y + j;
					try {
						if (board[x][y] == BLANK)
							empties.add(new Point(x, y));
					} catch (IndexOutOfBoundsException e) { // Expected to get
															// these
					}
				}
			}

			//System.out.println(empties);

			// Draw a line through the empties

			Point dir = null;
			boolean none = false;

			for (Point p : empties) {

				Point newDir = getDir(cross, p);

				if (newDir == null) {
					none = true;
					break;
				} else {
					if (dir == null) {
						dir = newDir;
					} else if (!newDir.equals(dir)) {
						none = true;
						break;
					}
				}
			}
			
			// No line through empties; no possible path
			if (none) {
				System.out.println("NONE");
			} else {
				// Copy the empties to prevent concurrent modification
				ArrayList<Point> emptCopy = (ArrayList<Point>) empties.clone();
				ArrayList<Point> removed = new ArrayList<Point>();

				int px = cross.x, py = cross.y;

				for (;;) {
					px += dir.x;
					py += dir.y;
					
					// Check for hitting outer walls
					if(px < 0 || px >= 7 || py < 0 || py >= 7) break;

					if (board[px][py] != BLANK) {
						break;
					}else {
						for(Point p : emptCopy) {
							if(p.x == px && p.y == py) {
								empties.remove(p);
							}
						}
						
						removed.add(new Point(px, py));
					}
				}

				if (!empties.isEmpty()) {
					// Path is blocked and uncompleted
					System.out.println("NONE");
				} else {
					
					// Print solution
					StringBuilder builder = new StringBuilder();
					
					for(int i=0; i<removed.size(); i++) {
						if(i != 0) builder.append(", ");
						Point p = removed.get(i);
						builder.append(p.x * 7 + p.y + 1);
					}
					
					System.out.println(builder.toString());
				}
			}
		}

		scan.close();
	}

	private static Point getDir(Point p1, Point p2) {
		int dx = p2.x - p1.x;
		int dy = p2.y - p1.y;

		if (Math.abs(dx) == Math.abs(dy)) {
			return new Point(dx / Math.abs(dx), dy / Math.abs(dy));
		} else if (dx == 0) {
			return new Point(0, dy / Math.abs(dy));
		} else if (dy == 0) {
			return new Point(dx / Math.abs(dx), 0);
		}

		return null;
	}

	private static void printBoard(int[][] board) {
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = 0; j < board[i].length; j++) {
				switch (board[i][j]) {
				case BLANK:
					System.out.print("1 ");
					break;
				case PLUS:
					System.out.print("+ ");
					break;
				case CROSS:
					System.out.print("x ");
					break;
				case WALL:
					System.out.print("0 ");
					break;
				}
			}
			System.out.println();
		}
	}

	public static int[][] parseBoard(String input, Point pluspt, Point crosspt) {
		String[] inputs = input.split(", ");
		int[] nums = new int[inputs.length - 3];
		int plus = Integer.parseInt(inputs[0]) - 1;
		int cross = Integer.parseInt(inputs[1]) - 1;
		for (int i = 2; i < inputs.length - 1; i++) {
			nums[i - 2] = Integer.parseInt(inputs[i]) - 1;
		}

		int[][] board = new int[7][7];
		pluspt.setLocation(plus / 7, plus % 7);
		crosspt.setLocation(cross / 7, cross % 7);
		board[pluspt.x][pluspt.y] = PLUS;
		board[crosspt.x][crosspt.y] = CROSS;
		for (int i = 0; i < nums.length; i++) {
			board[nums[i] / 7][nums[i] % 7] = WALL;
		}
 
		return board;
	}
}
