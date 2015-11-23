package org.dalton.acsl3.mancala10;

/**
 * Name:Caroline Cherston
 * School: The Dalton School
 * School Code: 9075
 * Date: March 15th, 2011 
 */
import java.util.Scanner;

public class MancalaCC {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		int[] board = new int[13]; 
		for(int x =1; x< 13; x++)
		{
			board[x] = 4;
		}	
		int A = 0;
		int B = 0;
		int round = 1;
		int player = 1; 
		int findBowl = 0; 
		
		while(round<6)
		{
			String [] in = new String[2];
			in = input.nextLine().split(","); 
			
			int startBowl = Integer.parseInt(in[0]);
			if(in[1].equals("A")){}
			else if(in[1].equals("B")){}
			else
			{
				findBowl = Integer.parseInt(in[1]); 
			}
			int stones = board[startBowl];
			board[startBowl] = 0; 
			int bucket = startBowl; 
			
			while(stones >= 1)
			{
				/**DEBUG 
				printBowls(board,A,B,stones); 
				String test = input.nextLine();
				**/
				if(bucket == 12)
				{
					bucket = 0; 
				}
				
				if(player == 1 && bucket+1 == 7)
				{
					stones = stones-1;
					A+=1; 
				}
				if(player == 2 && bucket+1 == 1)
				{
					stones = stones-1;
					B+=1; 
				}
				if(stones == 0)
				{
					break; 
				}
				
				if(board[bucket+1] == 3 && stones == 1)
				{
					board[bucket+1] = board[bucket+1] +1; 
					stones = stones-1; 
					break;
				}
				if(board[bucket+1] == 0 && stones == 1)
				{
					board[bucket+1] = board[bucket+1] +1; 
					stones = stones-1; 
					break;
				}
				
				
				board[bucket+1] = board[bucket+1] + 1;
				stones = stones-1; 
					
				if(stones == 0)
				{
					stones = board[bucket+1]; 
					board[bucket+1] = 0; 
				}
							
				bucket++; 				
				
			}
			
			if(player ==1)
			{
				player = 2;
			}
			else if(player == 2)
			{
				player = 1; 
			}
			
			if(in[1].equals("A"))
			{
				System.out.println(A);
			}
			else if(in[1].equals("B"))
			{
				System.out.println(B);
			}
			else 
			{
				System.out.println(board[findBowl]); 
			}
		
			round++; 
			
			
		}
	}
	
	static void printBowls(int[] board, int A, int B, int stones)
	{
		for(int x = 1; x<board.length; x++)
		{
			System.out.println("Stones in bucket " + x + " is: " + board[x]);
		}
		System.out.println("Stones in A is: " + A);
		System.out.println("Stones in B is: " + B);
		System.out.println("You are holding " + stones + " stones");
		
	}

}
