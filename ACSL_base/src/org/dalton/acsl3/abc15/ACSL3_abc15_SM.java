package org.dalton.acsl3.abc15;
import java.util.ArrayList;
import java.util.Scanner;


public class ACSL3_abc15_SM {
	
	public static String enter_x (String[] input, String[][] grid) //Conversion method
	{
		for (int i = 0; i < 4; i++) {
			int val = Integer.parseInt(input[i]);
			int row = val/6;
			int col = val%6; 
			grid[row][col] = "X";	
		}
		enter_hints(input, grid);
		return "";
	}  
	
	public static String enter_hints (String[] input, String[][] grid) //Conversion method
	{
		int clue = Integer.parseInt(input[4]);
		for (int i = 5; i < (5 + (2*clue)); i++) {
			int val = Integer.parseInt(input[i+1]);
			int row = val/6;
			int col = val%6; 
			grid[row][col] = input[i];
			if (col==0){ while(!grid[row][col].isEmpty()){  col+=1; }
				grid[row][col] = input[i];
			}
			else if (col==5){ while(!grid[row][col].isEmpty()){ col-=1; }
				grid[row][col] = input[i];
			}
			else if (row==0){ while(!grid[row][col].isEmpty()){ row+=1; }
				grid[row][col] = input[i];
			}
			else if (row==5){ while(!grid[row][col].isEmpty()){ row-=1; }
				grid[row][col] = input[i];
			}
			i+=2;
		}
		for (int i = 0; i<4; i++){
			for (int j = 0; j < 4; j++) {
				System.out.println(grid[i][j]);
			}
		}
		
		return "";
	}  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		while(scan.hasNext()) { 	
			//Declarations
			String[] input = scan.nextLine().split(", "); //stores input
			String[][] grid_2 = new String[6][6];
			enter_x(input, grid_2); 
		}
	}

}
