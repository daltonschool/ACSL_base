package org.dalton.acsl3.fanorona13;
import java.util.ArrayList;
import java.util.Scanner;

public class ACSL3_Fanorona13_HS {
	public static void main(String[] args) {
		for (int z = 0; z < 5; z++) {
			//Initialization of Board
			Space[] board = new Space[25];
			for (int i = 0; i < board.length; i++) {
				board[i] = new Space(i+1);
				if (board[i].index == 1) board[i].connections = new int[] {2,6,7};
				else if (board[i].index == 2) board[i].connections = new int[] {1,3,7};
				else if (board[i].index == 3) board[i].connections = new int[] {2,4,7,8,9};
				else if (board[i].index == 4) board[i].connections = new int[] {3,5,9};
				else if (board[i].index == 5) board[i].connections = new int[] {4,9,10};
				else if (board[i].index == 6) board[i].connections = new int[] {1,7,11};
				else if (board[i].index == 7) board[i].connections = new int[] {1,2,3,6,8,11,12,13};
				else if (board[i].index == 8) board[i].connections = new int[] {3,7,9,13};
				else if (board[i].index == 9) board[i].connections = new int[] {3,4,5,8,10,13,14,15};
				else if (board[i].index == 10) board[i].connections = new int[] {5,9,15};
				else if (board[i].index == 11) board[i].connections = new int[] {6,7,12,16,17};
				else if (board[i].index == 12) board[i].connections = new int[] {7,11,13,17};
				else if (board[i].index == 13) board[i].connections = new int[] {7,8,9,12,14,17,18,19};
				else if (board[i].index == 14) board[i].connections = new int[] {9,13,15,19};
				else if (board[i].index == 15) board[i].connections = new int[] {9,10,14,19,20};
				else if (board[i].index == 16) board[i].connections = new int[] {11,17,21};
				else if (board[i].index == 17) board[i].connections = new int[] {11,12,13,16,18,21,22,23};
				else if (board[i].index == 18) board[i].connections = new int[] {17,19,23};
				else if (board[i].index == 19) board[i].connections = new int[] {13,14,15,18,20,23,24,25};
				else if (board[i].index == 20) board[i].connections = new int[] {15,19,25};
				else if (board[i].index == 21) board[i].connections = new int[] {16,17,22};
				else if (board[i].index == 22) board[i].connections = new int[] {17,21,23};
				else if (board[i].index == 23) board[i].connections = new int[] {17,18,19,22,24};
				else if (board[i].index == 24) board[i].connections = new int[] {19,23,25};
				else if (board[i].index == 25) board[i].connections = new int[] {19,20,24};
			}//ends initialization loop
			Scanner scan = new Scanner(System.in);

			String[] input = scan.nextLine().split(", ");
			for (int i = 1; i < Integer.parseInt(input[0])+1; i++) {			//initialization of white pieces
				board[Integer.parseInt(input[i])-1].color = "white";
			}

			for (int i = Integer.parseInt(input[0])+2; i < input.length; i++) {	//initialization of black pieces
				board[Integer.parseInt(input[i])-1].color = "black";
			}
			ArrayList<Integer> positions = new ArrayList<Integer>();
			//Check the connections of the white pieces
			boolean foundblack = false;
			int difference;
			int int1;
			int diff1;
			int diff2;
			for (int i = 0; i < board.length; i++) {								//goes through board
				if (board[i].color.equals("white"))
				{	
					for (int j = 0; j < board[i].connections.length; j++) {			//cycles through the connections of the white ones
						if(board[board[i].connections[j]-1].color.equals("empty"))	//finds if there is an empty space at the connections 
						{
							diff1 = board[board[i].connections[j]-1].index - board[i].index;
							for (int j2 = 0; j2 < board[(board[i].connections[j]-1)].connections.length; j2++) {
								int1 = board[(board[i].connections[j])-1].connections[j2]-1;
								diff2 = board[int1].index - board[board[i].connections[j]-1].index;
								if(board[int1].color.equals("black") && diff1 == diff2)
								{
									foundblack = true;
									positions.add(board[int1].index);
									difference = board[int1].index - board[board[i].connections[j]-1].index; //stores the difference between the white space and the empty space
									int x = board[int1].index + difference - 1;
									if(board[x].index>0 && board[x].index<26 && board[x].color.equals("black"))
									{
										positions.add(board[board[i].connections[j]-1+difference+difference].index);
										if(board[x + difference].index>0 && board[x + difference].index<26 && board[x+difference].color.equals("black"))
										{
											positions.add(board[x + difference].index);

										}
									}
									j2 = board[(board[i].connections[j]-1)].connections.length;

								}
							}//ends j2 for loop
						}
						if(foundblack == true) j = board[i].connections.length;;
					}//ends j for loop

				}

				if(foundblack == true) i = board.length;
			}//ends i loop
			//MOVING AWAY CHECK IF THERE IS A PIECE NEXT TO YOU AND THEN USE THE DIFFERENCE
			for (int i = 0; i < board.length; i++) {
				if(board[i].color.equals("white")){
					for (int j = 0; j < board[i].connections.length; j++) {
						difference = board[i].connections[j] - board[i].index;
						int1 = board[i].connections[j]-1; 
						//System.out.println(board[i-difference].color);
						if(i-difference>=0 && i-difference<25){
							if(board[int1].color.equals("black") && board[i-difference].color.equals("empty")){
								positions.add(board[i].connections[j]);
								for (int j2 = 1; j2 < 4; j2++) {
									if((int1 + (j2*difference))>=0 && (int1 + (j2*difference))<25)
									{
										if (board[int1 + (j2*difference)].color.equals("black")) {
											positions.add(board[int1 + (j2*difference)].index);
										}

									}
								}
							}
						}
					}
				}
			}

			String answer = "";
			for (int i = 0; i < positions.size(); i++) {
				answer = answer  + positions.get(i);
				if(i<positions.size()-1) answer = answer + (", ");
			}
			if(positions.size()==0)
			{
				answer = "NONE";
			}
			System.out.println(answer);
			positions.clear();
		}//ends for loop
	}//ends main
}//ends Fanorana Class
class Space{
	int index;
	int[] connections;
	String color = "empty";
	public Space(int i) {
		index = i;
	}
}
