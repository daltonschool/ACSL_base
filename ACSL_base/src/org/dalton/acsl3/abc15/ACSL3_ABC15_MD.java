package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ACSL3_ABC15_MD {

	public static void main(String[] args) throws IOException {

		//declarations:
		String filein = "testdata/maxwellpoop";
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

		String[][] grid = new String[6][6];
		String[][] solvingGrid = new String[4][4];

		String[] data = s.split(", ");

		String[] filledCells = Arrays.copyOfRange(data, 0, 4);
		String[] letteredCells = Arrays.copyOfRange(data, 5, data.length);

		int amount = letteredCells.length;

		String[][] letters = new String[amount/2][2];

		for (int i = 0; i < amount; i = i + 2){
			letters[i/2][0] = (letteredCells[i]);
			letters[i/2][1] = (letteredCells[i+1]);
		}


		for (int i = 0; i < 4; i++){
			int use = Integer.valueOf(filledCells[i])%6;
			use--;
			grid[Integer.valueOf(filledCells[i])/6][use] = "X";
		}

		for (int i = 0; i < amount; i = i + 2){

		}

		for (int i = 0; i < 4; i++){
			solvingGrid[i] = Arrays.copyOfRange(grid[i+1], 1 , 5);
		}

		solvingGrid = filler(letters, solvingGrid);
		solvingGrid = solvegrid(solvingGrid);
		
		String done = "";
		
		for (int c = 0; c < 4; c++){
			for (int r = 0; r < 4; r++){
				if (solvingGrid[c][r].charAt(0) != 'X') done = done.concat(solvingGrid[c][r]);
			}
		}
		
		return done;
	}

	static  String[][]  solvegrid(String[][] s){
		s = fillPossibilities(s);
		if (s[3][3].contains("done")){
			s[3][3] = s[3][3].substring(0, 1);
			return s;
		}
		
		s = ALGORITHM1(s);
		

		return solvegrid(s);
	}

	static String[][] fillPossibilities(String[][] s){
		int counter = 0;
		
		//fill'er'up
		for (int t = 0; t < 4; t++){
			for (int q = 0; q < 4; q++){
				if (s[t][q] != null && Character.isUpperCase(s[t][q].charAt(0))){
					//have a party
				}
				else {
					s[t][q] = "abc";
					counter++;
				}
			}
		}
		
		if (counter == 0){
			s[3][3] = s[3][3].concat("done");
			return s;
		}
		
		
		//fill it out for that row
		for (int column = 0; column < 4; column++){
			//fill it out for that column
			for (int row = 0; row < 4; row++){
				if (Character.isUpperCase(s[column][row].charAt(0)) && s[column][row].charAt(0) != 'X'){
					//get char
					String letter = s[column][row].toLowerCase();


					//remove possibilities in row and column

					//row remove
					for (int i = 0; i < 4; i++){
						if (s[column][i].contains(letter)){
							StringBuilder ohNOudidnt = new StringBuilder(s[column][i]);
							for (int b = 0; b < ohNOudidnt.length(); b++){
								if (ohNOudidnt.charAt(b) == letter.charAt(0)) ohNOudidnt.deleteCharAt(b);
							}
							s[column][i] = ohNOudidnt.toString();
						}
					}
					//column remove
					for (int i = 0; i < 4; i++){
						if (s[i][row].contains(letter)){
							StringBuilder ohNOudidnt = new StringBuilder(s[i][row]);
							for (int b = 0; b < ohNOudidnt.length(); b++){
								if (ohNOudidnt.charAt(b) == letter.charAt(0)) ohNOudidnt.deleteCharAt(b);
							}
							s[i][row] = ohNOudidnt.toString();
						}
					}
				}
				
			}
			
			
		}
		return s;

	}
	
	static String[][] ALGORITHM1(String[][] s){
		
		for (int c = 0; c < 4; c++){
			for (int r = 0; r < 4; r++){
				if (s[c][r].length() == 1) s[c][r] = s[c][r].toUpperCase();
			}
		}
		
		return s;
	}

	static String[][] filler(String[][] where, String[][] grid){



		for (int i = 0; i < where.length; i++){

			int n = Integer.parseInt(where[i][1]);

			//get each example, since I am lazy I am just hard coding 16
			
			if (n == 2){
				grid = down(where[i][0], 0, 0, grid);
			}
			
			if (n == 3){
				grid = down(where[i][0], 1 , 0, grid);
			}
			
			if (n == 4){
				grid = down(where[i][0], 2 ,0, grid);
			}
			
			if (n == 5){
				grid = down(where[i][0], 3 ,0, grid);
			}
			
			if (n == 7){
				grid = right(where[i][0], 0, 0, grid);
			}
			
			if (n == 13){
				grid = right(where[i][0], 0, 1, grid);
			}
			
			if (n == 19){
				grid = right(where[i][0],0, 2, grid);
			}
			
			if (n == 25){
				grid = right(where[i][0],0, 3, grid);
			}
			
			if (n == 12){
				grid = left(where[i][0], 3, 0, grid);
			}
			
			if (n == 18){
				grid = left(where[i][0], 3, 1, grid);
			}
			
			if (n == 24){
				grid = left(where[i][0], 3, 2, grid);
			}
			
			if (n == 30){
				grid = left(where[i][0], 3, 3, grid);
			}
			
			if (n == 32){
				grid = up(where[i][0], 0, 3, grid);
			}
			
			if (n == 33){
				grid = up(where[i][0], 1, 3, grid);
			}
			
			if (n == 34){
				grid = up(where[i][0], 2, 3, grid);
			}
		
			if (n == 35){
				grid = up(where[i][0], 3, 3, grid);
			}
		}


		return grid;
	}

	static String[][] left(String what, int row, int column , String[][] grid){

		if (grid[column][row] == null || grid[column][row].charAt(0) == what.charAt(0)) grid[column][row] = what;
		else return left(what, row-1, column, grid);
		return grid;

	}

   	static String[][] right(String what, int row, int column, String[][] grid){
   		
   		if (grid[column][row] == null || grid[column][row].charAt(0) == what.charAt(0)) grid[column][row] = what;
		else return right(what, row+1, column, grid);

		return grid;

	}	

	static String[][] up(String what, int row, int column, String[][] grid){
		
		if (grid[column][row] == null || grid[column][row].charAt(0) == what.charAt(0)) grid[column][row] = what;
		else return up(what, row, column-1, grid);
		
		return grid;

	}

	static String[][] down(String what, int row, int column, String[][] grid){

		if (grid[column][row] == null || grid[column][row].charAt(0) == what.charAt(0)) grid[column][row] = what;
		else return down(what, row, column+1, grid);

		return grid;

	}

}