package org.dalton.acsl3.mancala10;

//	Gabe Jacobs -- ACSL 3 -- Mancala Game -- 3/14/11

import java.util.*;

public class MancalaGJ {
	
	public static int getStart(int startInput){
		
	
		if(startInput <=6)
		{
			startInput = startInput-1;
		}
		return startInput;
	}
	
	public static int getEnd (String endInput){
		
		boolean letter = false;
		if(endInput.equals("A"))
		{
			endInput = "6";
			letter = true;
		}
		if(endInput.equals("B"))
		{
			endInput = "13";
			letter = true;
		}
		int endInput2 = Integer.parseInt(endInput);

		if(endInput2 <=6 && letter == false)
		{
			endInput2 = endInput2-1;
		}
		return endInput2;
	}
	
	public static int turn(int board[], int startInput, int endInput2, String player) {

		 int hand= 0;
		 int start = startInput;
		 boolean stop = false;
		 boolean starting = true;

		 while((board[start] !=4 && board[start] != 1 && stop == false) || (starting == true))
		 {
			 if(board[start] == 0)
			 {
					System.out.println("You cannot start from a cup with 0 pebbles, please re-run the program");
					stop = true;
			 }
			 hand = board[start];
			 board[start] = 0;
			
			 while(hand!=0)
			 {
				 if (player.equals("A"))
				 {
					 if((start+1) == 13)
					 {

						 start = 13;
						 }
				 }
				 if (player.equals("B"))
				 {
					 if((start+1) == 6)
					 {

						 start = 6;
						 }
				 }
				 if ((start+1) == 14)
				 {
					 start = -1;
				 }
			
			 board[start+1] = board[start+1]+1;
			 hand = hand-1;	
			 start = start+1;
			 }
			 starting = false;
			 
			 if (start == 14)
			 {
				 start = 0;
			 }
			 if (start == 6 || start == 13)
			 {
				 stop=true;
			}
			 
		 }
		 int donezies = board[endInput2];
		return donezies;
	}
	
	public static void main(String[] args) {
		
		
		int[] board;              // declares an array of integers
		 board = new int[14];
		 int i = 0;
		 for(i=0; i<=13; i++)
		 {
			 if(i!=6 && i!=13)
			 {
			 board[i] = 4;
			 }
		 }

		Scanner in = new Scanner(System.in); // new scanner
		String input = in.nextLine();
		String input2 = in.nextLine();
		String input3 = in.nextLine();
		String input4 = in.nextLine();
		String input5 = in.nextLine();
		
			StringTokenizer st = new StringTokenizer(input, ", ");
			int startInput = Integer.parseInt(st.nextToken());
			String endInput = st.nextToken();
			
			startInput = getStart(startInput);
			int endInput2 = getEnd(endInput);
			
			
			String player = "A";
			int donzies = 0;
			donzies = turn(board,startInput, endInput2, player);
			System.out.println(donzies);
					
			
			////////// 1 output
			
			st = new StringTokenizer(input2, ", ");
			startInput = Integer.parseInt(st.nextToken());
			endInput = st.nextToken();
			
			startInput = getStart(startInput);
			endInput2 = getEnd(endInput);
			
			player = "B";
			donzies = turn(board,startInput, endInput2, player);
			System.out.println(donzies);
			
	
			
			////////// 2 output

			st = new StringTokenizer(input3, ", ");
			startInput = Integer.parseInt(st.nextToken());
			endInput = st.nextToken();
			
			startInput = getStart(startInput);
			endInput2 = getEnd(endInput);
			
			player = "A";
			donzies = turn(board,startInput, endInput2, player);
			System.out.println(donzies);
			
			
			////////// 3 output

			
			st = new StringTokenizer(input4, ", ");
			startInput = Integer.parseInt(st.nextToken());
			endInput = st.nextToken();
			
			startInput = getStart(startInput);
			endInput2 = getEnd(endInput);
			
			player = "B";
			donzies = turn(board,startInput, endInput2, player);
			System.out.println(donzies);
			
			////////// 4 output

			
			st = new StringTokenizer(input5, ", ");
			startInput = Integer.parseInt(st.nextToken());
			endInput = st.nextToken();
			
			startInput = getStart(startInput);
			endInput2 = getEnd(endInput);
			
			player = "A";
			donzies = turn(board,startInput, endInput2, player);
			System.out.println(donzies);
			
			////////// 5 output

		
	}

}
