//Eli Cahan
//The Dalton School
package org.dalton.acsl3.mancala10;

import java.util.Scanner;

public class Mancala1 
{
	public static int placeinitialize(String start)
	{
		int place = 0;
		if(start.equals("A"))
		{
			place = 6;
		}
		else if(start.equals("B"))
		{
			place = 13;
		}
		else if(Integer.parseInt(start) < 7) //if its below "A"
		{
			place = Integer.parseInt(start) - 1; //in the array, it's going to be one "spot" less than the input says it would be (array starts at 0)
		}
		else 
		{
			place = Integer.parseInt(start); //after "A" (6), everything is what it should be
		}
	//	System.out.println(place + " in fcn");
		return place;
	}
	public static void move()
	{
		int board[] = new int[14]; //thirteen spots, starting at 0 ending at 13 (B)
		int turncounter = 0;
		boolean play = true; //if the game's still going
		for(int i = 0; i < 13; i++) //fill the board at start (not 13 (B))
		{
			if(i != 6)
			{
				board[i] = 4; //set everything to 4 if it's not the "A" mancala
			}
			else
			{
				board[i] = 0; //A's 0
			}
		}
		while(play == true) //keep playing each turn as long as the game continues
		{
		//	System.out.println("What is your starting move spot, end view spot");
			Scanner input = new Scanner(System.in);
			String response[] = input.nextLine().split(","); //split data to 2 indiv vals
			String start = response[0].trim(); //take first val as string
			String end = response[1].trim();
			if((turncounter == 0) || (turncounter % 2 == 0)) //on even turns, it's player A's turn
			{
				player1move(start, board); 
				turncounter++; //track whose turn
				print(board, end);
				//System.out.println("turn counter: " + turncounter);
			}
			else if(turncounter % 2 == 1) //odd, player B
			{
				player2move(start, board);
				print(board, end);
				turncounter++;
			}
		}
	}
	public static int[] player1move(String start, int board[])
	{
		int place = placeinitialize(start); //setting the starting place to the value suitable to the array
		//System.out.println(place + "P");
		int counter = 1;
		int hand = board[place]; //where they get their hand of stones from
		board[place] = 0;  //removing those stones from there
		boolean turn = true; //if turn is still going
		while(turn == true)
		{
			while(hand != 0) //while there are still stones in the hand
			{
				if(((place + counter) == 13) || (place == 13)) //so it skips the drop into B
				{
				//	System.out.println("AT B");
					counter = 0; //skip 13 (B), go to 1
					place = 0;
				}
				else if(((place + counter) == 14) || (place == 14))
				{
					counter = 0; //skip 14 (which isnt a spot on the mancala board), go to 1
					place = 0;
				}
				else
				{
					board[place + counter] = board[place + counter] + 1; //drop one in
					hand = hand - 1; //take the dropped out of the hand
					//System.out.println(place);
					//System.out.println(counter);
					//System.out.println("placed one, amount at " + (place + counter) + ": " + board[place + counter]);
				//	System.out.println("amount in hand " + hand);
					counter++;
				}
			}
			if(hand == 0 && ((board[place + counter - 1] == 1) || board[place + counter - 1] == 4)) //THIS IS NEW TEST TEST TEST CANT TAKE FROM YOUR MANCALA TO EXTEND TURN
			{
				turn = false; //end the turn
			}
			else if(hand == 0 && ((place + counter - 1) == 6))
			{
				//System.out.println(place + counter + "PC");
			//	System.out.println(place + "P");
				turn = false;
			}
			else if((hand == 0) && !((board[place + counter - 1] == 1) || (board[place + counter - 1] == 4))) //as long as you can do a turn extension
			{
			//	System.out.println("IN");
				hand = board[place + counter - 1]; //hand is the number in that place
				board[place + counter - 1] = 0; //take the stones now in the hand from that place
			//	System.out.println("place: " + (place + counter - 1));
			//	System.out.println("hand " + hand);
				place = place + counter; //reset the place
				counter = 0; //so it goes to the next spot
				turn = true; //keep it going
			}
		}
		return board;
	}
	public static int[] player2move(String start, int board[])
	{
		int place = placeinitialize(start); //setting the starting place to the value suitable to the array
		//System.out.println(place + "P");
		int counter = 1;
		int hand = board[place]; //where they get their hand of stones from
		board[place] = 0;  //removing those stones from there
		boolean turn = true; //if turn is still going
		while(turn == true)
		{
			while(hand != 0) //while there are still stones in the hand
			{
				if(((place + counter) == 6) || (place == 6)) //so it skips the drop into A
				{
				//	System.out.println("AT A");
					counter = 0; //skip 6 (A), go to 1
					place = 7;
				}
				else if(((place + counter) == 14) || (place == 14))
				{
					counter = 0; //skip 14 (which isnt a spot on the mancala board), go to 1
					place = 0;
				}
				else
				{
					board[place + counter] = board[place + counter] + 1; //drop one in
					hand = hand - 1; //take the dropped out of the hand
					//System.out.println(place);
					//System.out.println(counter);
				//	System.out.println("placed one, amount at " + (place + counter) + ": " + board[place + counter]);
				//	System.out.println("amount in hand " + hand);
					counter++;
				}
			}
			if((hand == 0) && !((board[place + counter - 1] == 1) || (board[place + counter - 1] == 4))) //as long as you can do a turn extension
			{
				hand = board[place + counter - 1]; //hand is the number in that place
				board[place + counter - 1] = 0; //take the stones now in the hand from that place
				//System.out.println("place: " + (place + counter - 1));
				//System.out.println("hand " + hand);
				place = place + counter; //reset the place
				counter = 0; //so it goes to the next spot
				turn = true; //keep it going
			}
			else if(hand == 0 && ((place + counter - 1) == 13))
			{
				//System.out.println(place + counter + "PC");
			//	System.out.println(place + "P");
				turn = false;
			}
			else if(hand == 0 && ((board[place + counter - 1] == 1) || board[place + counter - 1] == 4))
			{
				turn = false; //end the turn
			}
		}
		return board;
	}
	public static void print(int board[], String end)
	{
		//int slot = Integer.parseInt(end);
		if(!(end.equals("A") || end.equals("B"))) //if its not one of those
		{
			int slot = Integer.parseInt(end);
			if(slot < 7)
			{
				System.out.println(board[slot - 1]);
			}
			else if(slot >= 7)
			{
				System.out.println(board[slot]);
			}
		}
		else if(end.equals("A"))
		{
			System.out.println(board[6]);
		}
		else if(end.equals("B"))
		{
			System.out.println(board[13]);
		}
	}
	public static void main(String[] args) 
	{
		move();

	}

}
