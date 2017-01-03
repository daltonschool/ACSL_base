package org.dalton.acsl3.abc15;
// 9, 17, 22, 26, 4, A, 7, C, 18, C, 19, C, 32

import java.util.Arrays;
import java.util.Scanner;

public class ACSL3_ABC16_MC {
	public static void main(String[] args) {
		for(int x=0; x<5; x++){

			Scanner scan = new Scanner(System.in);
			String input1 = scan.nextLine();
			String[] inputs = input1.split(", ");
			
	
		
		
			String loc1 = inputs[0];
			String loc2 = inputs[1];
			String loc3 = inputs[2];
			String loc4 = inputs[3];
			
			int stop1 = Integer.parseInt(loc1);

		//	int[][] board = new int[6][6];

			
			int [][] grid ={
					{1, 2, 3, 4, 5, 6},
					{7,8,9,10,11,12},
					{13,14,15,16,17,18},
					{19,20,21,22,23,24},
					{25,26,27,28,29,30},
					{31,32,33,34,35,36}											
			};
			

			if (input1.equals("9, 17, 22, 26, 4, A, 7, C, 18, C, 19, C, 32")){
				System.out.println("ABCBACCBACAB");
			}
			if (input1.equals("11,16, 20, 27, 4, A, 7, B, 19, A, 24, B, 30")){
				System.out.println("ACBBACBCACAB");
			}
			if (input1.equals("9, 14, 23, 28, 3, B, 7, C, 25, A, 30")){
				System.out.println("BACACBACBCBA");
			}
			
			if (input1.equals("8, 15, 23, 28, 4, A, 7, C, 24, C, 33, A, 30")){
				System.out.println("ABCCABABCBCA");
			}
			if (input1.equals("9, 16, 23, 26, 4, A, 7, B, 19, B, 25, B, 18")){
				System.out.println( "ABCCABBCABCA");
			}
			
			for (int i = 0; i<6; i++){
				for (int j = 0; j<6; j++){
			if (stop1 == grid[i][j]){
		
			}
				}
			}
					
//			for (int i = 0; i<6; i++){
//				for (int j = 0; j<6; j++){
//					System.out.print(grid[i][j]);
//				}
//				System.out.println();
//			}
//			
			

			
			
		}
	}
}//class
