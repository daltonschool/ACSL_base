package org.dalton.acsl3.abc15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author Cortland Perry
 *
 */
public class ACSL3_ABC15_c16cp {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		

		while(true){
			char[] board = new char[36];
			char[][] fin = new char[4][4];
			boolean x = true;
			String output = "";
			String[] data = input.nextLine().split(",[ ]*");
			int letters = Integer.parseInt(data[4]);
			int[] positions = new int[letters];
			for(int i = 0; i < board.length; i++){
				board[i] = '0';
			}
			for(int i = 0; i < 4; i++){	//entering in the filled spaces
				board[Integer.parseInt(data[i])-1] = '#';
			}

			for(int i = 0; i < 2*letters; i = i +2){	//taking the A,B,C, and then putting them in their positions on the tiny board
				char value = data[5+i].toCharArray()[0];	
				int pos = Integer.parseInt(data[6+i]);

				if(pos > 6 && pos < 31){	//if it is at left or right of board
					if(Integer.parseInt(data[6+i])%6 == 1){
						if(board[pos] == '#') board[pos+1] = value;
						else board[pos] = value;					
					}
					else{
						if(board[pos-2] == '#') board[pos-3] = value;
						else board[pos-2] = value;		
					}
				}
				else{		//if it is at top or bottom of board
					if(pos < 6){
						if(board[pos+5] == '#') board[pos+11] = value;
						else board[pos+5] = value;
					}
					else{
						if(board[pos-7] == '#') board[pos-13] = value;
						else board[pos-7] = value;
					}
				}
			}


			for(int i = 0; i < board.length; i++){  //NOW TAKE THE BOARD, AND TURN TO THE 4x4
				if(7 <= i && i <= 10) fin[0][i-7] = board[i]; 	
				else if(13 <= i && i <= 16) fin[1][i-13] = board[i];
				else if(19 <= i && i <= 22) fin[2][i-19] = board[i];
				else if(25 <= i && i <= 28) fin[3][i-25] = board[i];

			}

			//System.out.println(Arrays.deepToString(fin));		
			
			
			while(x == true){	//solving the problem
				for(int i = 0; i < 4; i++){
					for(int j = 0; j < 4; j++){
						findAvailability(fin, i, j);
					}
				}
				int count = 0;
				for (int i = 0; i < 4; i++) {
					for(int j = 0; j < 4; j++){
						if (fin[i][j] == '0') count++;
					}
				}	
				if(count == 0){
					x = false;
				}
			}
			//System.out.println(Arrays.deepToString(fin));
			for (int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++){
					if (fin[i][j] != '#') output = output + fin[i][j];
				}
			}
			System.out.println(output);
		}




	}
	public static void findAvailability(char[][] fin, int pos1, int pos2){
		ArrayList<Character> conflicts = new ArrayList<Character>();
		int counter = 0;
		char[] possible = {'A', 'B', 'C'};

		if(fin[pos1][pos2] == '0'){

			for(int i = 0; i < 4; i++){
				if(fin[pos1][i] != '0' && fin[pos1][i] != '#') conflicts.add(fin[pos1][i]);
			}
			for(int i = 0; i < 4; i++){
				if(fin[i][pos2] != '0' && fin[i][pos2] != '#') conflicts.add(fin[i][pos2]);
			}

			if(conflicts.contains('A')) counter ++;
			if(conflicts.contains('B')) counter ++;
			if(conflicts.contains('C')) counter ++;

			if(counter == 2){
				if(conflicts.contains('A') == false) fin[pos1][pos2] = 'A';
				else if(conflicts.contains('B') == false) fin[pos1][pos2] = 'B';
				else fin[pos1][pos2] = 'C';	
			}		
		}
	}



}


