package org.dalton.acsl3.abc15;
import java.util.Scanner;

public class ACSL3_abc15_c16dp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			String[] input_data = input.nextLine().split(", ");

			int[] filled = new int[4];
			for (int i=0; i<4; i++) filled[i] = Integer.parseInt(input_data[i]);

			int first_found_num = Integer.parseInt(input_data[4]);

			int[][] first_found = new int[first_found_num][2];

			for (int i=0; i<first_found_num; i++) {
				char[] charArray = input_data[5+2*i].toCharArray();
				first_found[i][0] = (int) charArray[0] - 64;
				first_found[i][1] = Integer.parseInt(input_data[5+2*i+1]);
			}
			
			int[][][] abc_grid = new int[6][6][2];
			
			for (int i=0; i<6; i++) {
				for (int j=0; j<6; j++) {
					abc_grid[i][j][0] = j+6*i+1;
					for (int k=0; k<4; k++) if (filled[k] == abc_grid[i][j][0]) abc_grid[i][j][1] = 4;
					for (int k=0; k<first_found_num; k++) if (first_found[k][1] == abc_grid[i][j][0]) abc_grid[i][j][1] = first_found[k][0];
				}
			}
			
			if (abc_grid[0][1][1] > 0 && abc_grid[0][1][1] < 4) {
				if (abc_grid[1][1][1] == 4) abc_grid[2][1][1] = abc_grid[0][1][1];
				else abc_grid[1][1][1] = abc_grid[0][1][1];
			}
			if (abc_grid[0][2][1] > 0 && abc_grid[0][2][1] < 4) {
				if (abc_grid[1][2][1] == 4) abc_grid[2][2][1] = abc_grid[0][2][1];
				else abc_grid[1][2][1] = abc_grid[0][2][1];
			}
			if (abc_grid[0][3][1] > 0 && abc_grid[0][3][1] < 4) {
				if (abc_grid[1][3][1] == 4) abc_grid[2][3][1] = abc_grid[0][3][1];
				else abc_grid[1][3][1] = abc_grid[0][3][1];
			}
			if (abc_grid[0][4][1] > 0 && abc_grid[0][4][1] < 4) {
				if (abc_grid[1][4][1] == 4) abc_grid[2][4][1] = abc_grid[0][4][1];
				else abc_grid[1][4][1] = abc_grid[0][4][1];
			}
			
			if (abc_grid[5][1][1] > 0 && abc_grid[5][1][1] < 4) {
				if (abc_grid[4][1][1] == 4) abc_grid[3][1][1] = abc_grid[5][1][1];
				else abc_grid[4][1][1] = abc_grid[5][1][1];
			}
			if (abc_grid[5][2][1] > 0 && abc_grid[5][2][1] < 4) {
				if (abc_grid[4][2][1] == 4) abc_grid[3][2][1] = abc_grid[5][2][1];
				else abc_grid[4][2][1] = abc_grid[5][2][1];
			}
			if (abc_grid[5][3][1] > 0 && abc_grid[5][3][1] < 4) {
				if (abc_grid[4][3][1] == 4) abc_grid[3][3][1] = abc_grid[5][3][1];
				else abc_grid[4][3][1] = abc_grid[5][3][1];
			}
			if (abc_grid[5][4][1] > 0 && abc_grid[5][4][1] < 4) {
				if (abc_grid[4][4][1] == 4) abc_grid[3][4][1] = abc_grid[5][4][1];
				else abc_grid[4][4][1] = abc_grid[5][4][1];
			}
			
			if (abc_grid[1][0][1] > 0 && abc_grid[1][0][1] < 4) {
				if (abc_grid[1][1][1] == 4) abc_grid[1][2][1] = abc_grid[1][0][1];
				else abc_grid[1][1][1] = abc_grid[1][0][1];
			}
			if (abc_grid[2][0][1] > 0 && abc_grid[2][0][1] < 4) {
				if (abc_grid[2][1][1] == 4) abc_grid[2][2][1] = abc_grid[2][0][1];
				else abc_grid[2][1][1] = abc_grid[2][0][1];
			}
			if (abc_grid[3][0][1] > 0 && abc_grid[3][0][1] < 4) {
				if (abc_grid[3][1][1] == 4) abc_grid[3][2][1] = abc_grid[3][0][1];
				else abc_grid[3][1][1] = abc_grid[3][0][1];
			}
			if (abc_grid[4][0][1] > 0 && abc_grid[4][0][1] < 4) {
				if (abc_grid[4][1][1] == 4) abc_grid[4][2][1] = abc_grid[4][0][1];
				else abc_grid[4][1][1] = abc_grid[4][0][1];
			}
			
			if (abc_grid[1][5][1] > 0 && abc_grid[1][5][1] < 4) {
				if (abc_grid[1][4][1] == 4) abc_grid[1][3][1] = abc_grid[1][5][1];
				else abc_grid[1][4][1] = abc_grid[1][5][1];
			}
			if (abc_grid[2][5][1] > 0 && abc_grid[2][5][1] < 4) {
				if (abc_grid[2][4][1] == 4) abc_grid[2][3][1] = abc_grid[2][5][1];
				else abc_grid[2][4][1] = abc_grid[2][5][1];
			}
			if (abc_grid[3][5][1] > 0 && abc_grid[3][5][1] < 4) {
				if (abc_grid[3][4][1] == 4) abc_grid[3][3][1] = abc_grid[3][5][1];
				else abc_grid[3][4][1] = abc_grid[3][5][1];
			}
			if (abc_grid[4][5][1] > 0 && abc_grid[4][5][1] < 4) {
				if (abc_grid[4][4][1] == 4) abc_grid[4][3][1] = abc_grid[4][5][1];
				else abc_grid[4][4][1] = abc_grid[4][5][1];
			}
			
			int[][] abc_final_grid = new int[4][4];
			abc_final_grid[0][0] = abc_grid[1][1][1];
			abc_final_grid[0][1] = abc_grid[1][2][1];
			abc_final_grid[0][2] = abc_grid[1][3][1];
			abc_final_grid[0][3] = abc_grid[1][4][1];
			abc_final_grid[1][0] = abc_grid[2][1][1];
			abc_final_grid[1][1] = abc_grid[2][2][1];
			abc_final_grid[1][2] = abc_grid[2][3][1];
			abc_final_grid[1][3] = abc_grid[2][4][1];
			abc_final_grid[2][0] = abc_grid[3][1][1];
			abc_final_grid[2][1] = abc_grid[3][2][1];
			abc_final_grid[2][2] = abc_grid[3][3][1];
			abc_final_grid[2][3] = abc_grid[3][4][1];
			abc_final_grid[3][0] = abc_grid[4][1][1];
			abc_final_grid[3][1] = abc_grid[4][2][1];
			abc_final_grid[3][2] = abc_grid[4][3][1];
			abc_final_grid[3][3] = abc_grid[4][4][1];
			
			boolean do_again = true;
			while (do_again==true) {
				do_again = false;
				for (int i=0; i<4; i++) {
					for (int j=0; j<4; j++) {
						if (abc_final_grid[i][j] == 0) {
							boolean one = false;
							boolean two = false;
							boolean three = false;
							for (int a=0; a<4; a++) {
								if (abc_final_grid[a][j] == 1) one = true;
								if (abc_final_grid[a][j] == 2) two = true;
								if (abc_final_grid[a][j] == 3) three = true;
							}
							for (int a=0; a<4; a++) {
								if (abc_final_grid[i][a] == 1) one = true;
								if (abc_final_grid[i][a] == 2) two = true;
								if (abc_final_grid[i][a] == 3) three = true;
							}
							if (one == false && two == true && three == true) abc_final_grid[i][j] = 1;
							else if (one == true && two == false && three == true) abc_final_grid[i][j] = 2;
							else if (one == true && two == true && three == false) abc_final_grid[i][j] = 3;
							else do_again = true;
						}
					}
				}
			}
			
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					if (abc_final_grid[i][j] == 1) System.out.print("A");
					else if (abc_final_grid[i][j] == 2) System.out.print("B");
					else if (abc_final_grid[i][j] == 3) System.out.print("C");
				}
			}
			System.out.println();
			
		}
	}
}