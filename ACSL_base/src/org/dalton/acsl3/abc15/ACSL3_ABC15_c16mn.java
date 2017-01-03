package org.dalton.acsl3.abc15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ACSL3_ABC15_c16mn {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			String[][] grid = new String[6][6];
			gridSetter(grid);
			String[] input = scan.nextLine().split(", ");
			for (int i = 0; i < 4; i++) {
				//parsing double array values from grid position
				grid[Integer.valueOf(input[i])/6][Integer.valueOf(input[i])%6 - 1] = "X";
			}
			//placing initial letters on grid
			int counter = 0;
			for (int i = 6; i < input.length; i+=2) {
				if(Integer.valueOf(input[i]) < 7){
					int row = 1;
					if(grid[row][Integer.valueOf(input[i])-1].equals("X")) row++;
					grid[row][Integer.valueOf(input[i])-1] = input[i-1];
				}else if(Integer.valueOf(input[i])%6 == 1){
					int column = 1;
					if(grid[Integer.valueOf(input[i])/6][column].equals("X")) column++;
					grid[Integer.valueOf(input[i])/6][column] = input[i-1];
				}else if(Integer.valueOf(input[i])%6 == 0){
					int column = 4;
					if(grid[(Integer.valueOf(input[i])/6)-1][column].equals("X")) column--;
					grid[Integer.valueOf(input[i])/6-1][column] = input[i-1];
				}else if(Integer.valueOf(input[i]) > 30){
					int row = 4;
					if(grid[row][(Integer.valueOf(input[i])%6)-1].equals("X")) row--;
					grid[row][(Integer.valueOf(input[i])%6)-1] = input[i-1];
				}
			}
//			gridPrinter(gridConverter(grid));
//			System.out.println();
			grid = gridSolver(gridConverter(grid));
//			gridPrinter(grid);
//			System.out.println();
			System.out.println(gridToString(grid));
			
		}
	}
	public static String gridToString(String[][] grid){
		String result = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(!grid[i][j].equals("X") && !grid[i][j].equals("0")) result += grid[i][j];
			}
		}
		return result;
	}
	public static String[][] gridSolver(String[][] grid){
		if(gridChecker(grid)) return grid;
		for (int i = 0; i < grid.length; i++) {
			grid[i] = missingChecker(grid[i]);
		}
		String[] column = new String[grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < column.length; j++) {
				column[j] = grid[j][i];
			}
			column = missingChecker(column);
			for (int j = 0; j < column.length; j++) {
				grid[j][i] = column[j];
			}
		}
//		gridPrinter(grid);
//		System.out.println();
		grid = overlap(grid);
		return gridSolver(grid);
	}
	public static String[][] overlap(String[][] grid){
		String[][] columns = new String[grid.length][grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				columns[i][j] = grid[j][i];
			}
		}
		for (int i = 0; i < grid.length; i++) {
			List<Integer> numzeros = new ArrayList<Integer>();
			String letter = "";
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == "0"){
					numzeros.add(j);
				}
				if(!grid[i][j].equals("X") && !grid[i][j].equals("0")) letter = grid[i][j];
			}
			if(numzeros.size() == 2){
				for (int j = 0; j < numzeros.size(); j++) {
					if(Arrays.asList(columns[numzeros.get((j+1)%2)]).contains("A") && !Arrays.asList(columns[numzeros.get(j)]).contains("A") && !letter.equals("A")){
						grid[i][numzeros.get(j)] = "A";
						break;
					}else if(Arrays.asList(columns[numzeros.get((j+1)%2)]).contains("B") && !Arrays.asList(columns[numzeros.get(j)]).contains("B") && !letter.equals("B")){
						grid[i][numzeros.get(j)] = "B";
						break;
					}else if(Arrays.asList(columns[numzeros.get((j+1)%2)]).contains("C") && !Arrays.asList(columns[numzeros.get(j)]).contains("C") && !letter.equals("C")){
						grid[i][numzeros.get(j)] = "C";
						break;
					}	
				}
//				System.out.println("row overlap");
//				gridPrinter(grid);
//				System.out.println();
			}
		}
		for (int i = 0; i < grid.length; i++) {
			List<Integer> numzeros = new ArrayList<Integer>();
			String letter = "";
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[j][i] == "0") numzeros.add(j);
				letter = grid[j][i];
			}
			if(numzeros.size() == 2){
				for (int j = 0; j < numzeros.size(); j++) {
					if(Arrays.asList(grid[numzeros.get((j+1)%2)]).contains("A") && !Arrays.asList(grid[numzeros.get(j)]).contains("A") && !letter.equals("A")){
						grid[numzeros.get(j)][i] = "A";
						break;
					}else if(Arrays.asList(grid[numzeros.get((j+1)%2)]).contains("B") && !Arrays.asList(grid[numzeros.get(j)]).contains("B") && !letter.equals("B")){
						grid[numzeros.get(j)][i] = "B";
						break;
					}else if(Arrays.asList(grid[numzeros.get((j+1)%2)]).contains("C") && !Arrays.asList(grid[numzeros.get(j)]).contains("C") && !letter.equals("C")){
						grid[numzeros.get(j)][i] = "C";
						break;
					}	
				}
//				System.out.println("column overlap");
//				gridPrinter(grid);
//				System.out.println();
			}
		}
		return grid;
	}
	public static String[] missingChecker(String[] input){
		int letters = 'A' + 'B' + 'C' + 'X';
		int zerocount = 0;
		int place = 0;
		for (int i = 0; i < input.length; i++) {
			if(input[i] == "0"){
				zerocount ++;
				place = i;
			}
			else letters = letters - input[i].charAt(0);
		}
		if(zerocount == 1){
			char letter = (char) letters;
			input[place] = "" + letter;
			return input;
		}
		else return input;
	}
	public static boolean gridChecker(String[][] grid){
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j].equals("0")) return false;
			}
		}
		return true;
	}
	public static String[][] gridConverter(String[][] grid){
		String[][] result = new String[4][4];
		int k = 0;
		for (int i = 1; i < grid.length; i++) {
			int l = 0;
			if(i == grid.length - 1) break;
			for (int j = 1; j < grid[i].length; j++) {
				if(j == grid[i].length - 1) break;
				result[k][l] = grid[i][j];
				l++;
			}
			k++;
		}
		return result;
	}
	public static void gridSetter(String[][] grid){
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = "0";
			}
		}
	}
	public static void gridPrinter(String[][] grid){
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(" " + grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
