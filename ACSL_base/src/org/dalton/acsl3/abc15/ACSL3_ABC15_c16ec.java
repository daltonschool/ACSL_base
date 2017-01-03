package org.dalton.acsl3.abc15;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

//Hi Josh!

public class ACSL3_ABC15_c16ec {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		int[][] board = {{1,2,3,4,5,6}, {7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};
		int[][] grid2 = new int [6][6];
		int [][] grid3 = new int[4][4];

		for (int roundcount =0; roundcount<10; roundcount++){
			String input = scan.nextLine();
			String[] splitArray = input.split(", ");

			int [] filled = new int [4];
			for (int i= 0; i<4; i++){
				filled [i] = (int) Double.parseDouble(splitArray[i]);
			}
			String holder = splitArray[4];
			int numgiven = (int) Double.parseDouble(holder); 

			int counter =5;
			String [][] givenlocation1 = new String [numgiven][2];
			for (int i =0; i<numgiven;i++){
				for (int j=0; j<2;j++){
					givenlocation1 [i][j] = splitArray[counter];
					counter ++;
				}
			}
			int [][] givenlocation = new int [givenlocation1.length][givenlocation1[0].length];
			for (int i =0; i<numgiven;i++){
				if(givenlocation1 [i][0].equalsIgnoreCase("A")) givenlocation [i][0] = 2;
				if(givenlocation1 [i][0].equalsIgnoreCase("B")) givenlocation [i][0] = 5;
				if(givenlocation1 [i][0].equalsIgnoreCase("C")) givenlocation [i][0] = 11;
				givenlocation [i][1] = (int) Double.parseDouble(givenlocation1 [i][1]);
			}
			//making second grid
			for(int i=0; i<grid2.length; i++){
				for(int j=0; j<grid2[0].length; j++){
					for (int k=0; k<4;k++){
						if(board[i][j] == filled[k]){
							grid2[i][j] = 1;
							k=4;
						}
						else{
							grid2[i][j] = 0;
						}
					}
					for (int k=0; k<numgiven;k++){
						if(board[i][j]==givenlocation[k][1]){
							grid2[i][j] = givenlocation[k][0];
						}
					}

				}
			}//filling grid 2

			//transferring to 4x4
			for(int i=0; i<grid2.length; i++){
				for(int j=0; j<grid2[0].length; j++){
					if (grid2[i][j]== 1){}
					else if (grid2[i][j]==0) {}
					else{ //if its a letter (it will be outside) A = 2, B =5, C = 11, blank = 1
						if (board[i][j]==7||board[i][j]==13||board[i][j]==19||board[i][j]==25){
							//we are in the left most column so we need to move one column to the right (j+1)
							if(grid2[i][j+1]==1) grid2[i][j+2] = grid2[i][j];
							else grid2[i][j+1] = grid2[i][j];
							grid2[i][j] =0;
						}
						if (board[i][j]==12||board[i][j]==18||board[i][j]==24||board[i][j]==30){
							//we are in the right most column so we need to move one column to the left (j-1)
							if(grid2[i][j-1]==1) grid2[i][j-2] = grid2[i][j];
							else grid2[i][j-1] = grid2[i][j];
							grid2[i][j] =0;
						}
						if (board[i][j]==2||board[i][j]==3||board[i][j]==4||board[i][j]==5){
							//we are in the upper most row so we need to move one row down (i+1)
							if(grid2[i+1][j]==1) grid2[i+2][j] = grid2[i][j];
							else grid2[i+1][j] = grid2[i][j];
							grid2[i][j] =0;
						}
						if (board[i][j]==32||board[i][j]==33||board[i][j]==34||board[i][j]==35){
							//we are in the lower most row so we need to move one row up (i-1)
							if(grid2[i-1][j]==1) grid2[i-2][j] = grid2[i][j];
							else grid2[i-1][j] = grid2[i][j];
							grid2[i][j] =0;
						}//if cases
					}	//big else
				}//for columns
			}//for rows
			for(int i=1; i<grid2.length-1; i++){
				for(int j=1; j<grid2[0].length-1; j++){
					grid3[i-1][j-1] = grid2[i][j];
				}
			}
			boolean optionsleft = true;
			while (optionsleft==true){
				int [][] options = new int[4][4];
				boolean available = true;
				int testing =0;
				double zerocounter =0;

				//counting options
				for (int i =0;i<4;i++){
					for (int j=0;j<4;j++){
						available = true;
						if (grid3[i][j] !=0){
							options [i][j] =0;
						}
						else{
							//a = row, b = column
							options [i][j] =3;
							//check row and column for 2
							for (int round =0; round<3; round ++){
								if (round ==0) testing =2;
								if (round ==1) testing =5;
								if (round ==2) testing =11;
								for (int a = 0; a<4;a++){
									if(grid3[a][j] ==testing) available =false;
								}
								for (int b = 0; b<4;b++){
									if(grid3[i][b] ==testing) available =false;
								}
								if (available ==false) options[i][j] --;
								available = true;
							}
						}
					}
				}//options counter
				boolean [] optionopen = {true,true,true};

				for (int i =0;i<4;i++){
					for (int j=0;j<4;j++){
						if (options [i][j] ==1){
							//check row and column to see what option is
							for (int round =0; round<3; round ++){
								if (round ==0) testing =2;
								if (round ==1) testing =5;
								if (round ==2) testing =11;
								for (int a = 0; a<4;a++){
									if(grid3[a][j] ==testing) optionopen[round] =false;
								}
								for (int b = 0; b<4;b++){
									if(grid3[i][b] ==testing) optionopen[round] =false;
								}
							}
							if(optionopen[0]==true) grid3[i][j] =2;
							else if(optionopen[1]==true) grid3[i][j] =5;
							else if(optionopen[2]==true) grid3[i][j] =11;
						}
					}
				}//option 1 loop
				zerocounter = 0;
				for (int i =0;i<4;i++){
					for (int j=0;j<4;j++){
						if (options[i][j]==0) zerocounter++;
					}
				}
				if (zerocounter ==16) optionsleft = false;
			}
			for(int i=0; i<4; i++){
				for(int j=0; j<4; j++){
					if (grid3[i][j]==2)System.out.print("A");
					if (grid3[i][j]==5)System.out.print("B");
					if (grid3[i][j]==11)System.out.print("C");
				}
			}
			System.out.println();
		}
	}
}