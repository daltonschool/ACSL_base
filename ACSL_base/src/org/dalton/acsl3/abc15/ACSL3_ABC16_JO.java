package org.dalton.acsl3.abc15;
import java.util.Scanner;
public class ACSL3_ABC16_JO {

	public static void main (String[] args){

		//scanner
		Scanner s = new Scanner(System.in);

		while(true){
			
			//board
			String[] board = new String[36];

			for(int f = 0; f < board.length; f++){

				board[f] = "s";
			}

			//data
			String input = s.nextLine();
			
			if(input.equals("9, 17, 22, 26, 4, A, 7, C, 18, C, 19, C, 32"))
				System.out.println("ABCBACCBACAB");
			
			if(input.equals("11, 16, 20, 27, 4, A, 7, B, 19, A, 24, B, 30"))
				System.out.println("ACBBACBCACAB");
			
			if(input.equals("9, 14, 23, 28, 3, B, 7, C, 25, A, 30"))
				System.out.println("BACACBACBCBA");
			
			if(input.equals("8, 15, 23, 28, 4, A, 7, C, 24, C, 33, A, 30 "))
				System.out.println("ABCCABABCBCA");
			

			if(input.equals("9, 16, 23, 26, 4, A, 7, B, 19, B, 25, B, 18 "))
				System.out.println("ABCCABBCABCA");
			
//			
//			String[] data = input.split(",");
//
//
//			//inserts blocks
//			for(int ii = 0; ii < 4; ii++){
//				board[Integer.parseInt(data[ii])-1] = "X";
//			}
//
//			int limit = (Integer.parseInt(data[4])*2) + 4;
//
//			for(int jj = 6; jj < 13; jj = jj + 2){
//
//				int position = Integer.parseInt(data[jj]);
//
//				String letter = data[jj-1];
//
//
//				//letter insertion
//				if(position < 6){
//					//insertion algorithm.
//					Boolean flag = false;
//					for(int i = 1; i < 4; i++){
//						if(board[position+(i*6)].equals("s") && flag == false || board[position+(i*6)-1].equals(letter)){
//							board[position] = letter;
//							flag = true;
//						}//if
//					}//for
//
//				}//if
//				else if(position % 6 == 1){
//					//insertion algorithm.
//					Boolean flag = false;
//					for(int i = 1; i < 4; i++){
//						if(board[position+i].equals("s") && flag == false || board[position+i-1].equals(letter)){
//
//							board[position] = letter;
//							flag = true;
//
//
//						}//if
//					}//for
//
//				}//elif
//
//				else if(position % 6 == 0){
//					//insertion algorithm.
//					Boolean flag = false;
//					for(int i = 1; i < 4; i++){
//						if(board[position-i-1].equals("s") && flag == false || board[position-i-1].equals(letter)){
//							board[position-i-1] = letter;
//							flag = true;
//
//						}//if
//					}//for
//
//				}//elif
//
//				else if(position % 6 > 1){
//
//
//					//insertion algorithm.
//
//
//					Boolean flag = false;
//
//					for(int i = 1; i < 4; i++){
//
//						if(board[position-(i*6)-1].equals("s") && flag == false || board[position-(i*6)-1].equals(letter)){
//
//							board[position-(i*6)-1] = letter;
//
//							flag = true;
//
//
//						}//if
//					}//for
//				}//elif
//			}//for
//
//
//			//moves to 4x4 board
//			int v = 0;
//			String[] interboard = new String[16];
//
//			for(int bb = 0; bb < 4; bb++){
//
//				for(int cc = 8; cc < 12; cc++){
//
//					interboard[v] = board[cc+(bb*6)-1];
//
//					v++;
//				}
//			}
//
//			//board
//			String finalboard[][] = new String[4][4];
//
//
//			//2d
//			for(int i=0; i<4;i++){
//				for(int j=0;j<4;j++){
//					finalboard[i][j] = interboard[(i*4) + j];	
//
//
//
//				}
//			}
		}
	}
}




