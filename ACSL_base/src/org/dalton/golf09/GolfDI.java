package org.dalton.golf09;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math.*;

public class GolfDI
{
	

	/**
	 * Daniel Issroff
	 * School #: 9010
	 * Dalton
	 *
	 */
	
	public static String winner(int player1, int player2, int player3, int player4)
	{
		String hole_winner = "";
		int [] scores = new int [4];
		
		scores[0] = player1;
		scores[1] = player2;
		scores[2] = player3;
		scores[3] = player4;
		
		Arrays.sort(scores);
		
		if(scores[0] == scores[1])
			{
			hole_winner = "none";
			}
		else
			{
			if (scores[0] == player1)
				{
				hole_winner = "A";
				}
			else if (scores[0] == player2)
				{
				hole_winner = "B";
				}
			else if (scores[0] == player3)
				{
				hole_winner = "C";
				}
			else if (scores[0] == player4)
				{
				hole_winner = "D";
				}
			}
		
		return hole_winner;
	}

	
	
	public static void main(String[] args) 
	{

		
		int [] player1 = new int [9];
		int [] player2 = new int [9]; 
		int [] player3 = new int [9];
		int [] player4 = new int [9];
		
		int score_par_player1 = 0;
		int score_total_player1 = 0;
		int score_par_player2 = 0;
		int score_total_player2 = 0;
		int score_par_player3 = 0;
		int score_total_player3 = 0;
		int score_par_player4 = 0;
		int score_total_player4 = 0;
		int [] total_scores = new int [4];
		int [] all_scores = new int [36];
		double median = 0.0;
		
		String position1 = "";
		String position2 = "";
		String position3 = "";
		String position4 = "";

		String winner_of_hole = "";
		int holes_won_player1 = 0; 
		int holes_won_player2 = 0; 
		int holes_won_player3 = 0; 
		int holes_won_player4 = 0; 
		int counter = 0;
		int index = 0;
		
		Scanner input = new Scanner(System.in);
		String user_input = "";
		
		
		while(index<9)
			{
			user_input = input.next();
			//System.out.println("user input: " + user_input);
			java.util.StringTokenizer st = new java.util.StringTokenizer(user_input,",");
			while(st.hasMoreTokens())
		    	{
				//System.out.println("counter: " + counter);
				
				player1[counter] = Integer.parseInt(st.nextToken());
				player2[counter] = Integer.parseInt(st.nextToken());
				player3[counter] = Integer.parseInt(st.nextToken());
				player4[counter] = Integer.parseInt(st.nextToken());
				
				winner_of_hole = winner(player1[counter], player2[counter], player3[counter], player4[counter]);
				//System.out.println("winner of hole: " + winner_of_hole);
				
				if(winner_of_hole.equalsIgnoreCase("A"))
					{
					holes_won_player1 = holes_won_player1 + 1;
					}
				else if(winner_of_hole.equalsIgnoreCase("B"))
					{
					holes_won_player2 = holes_won_player2 + 1;
					}
				else if(winner_of_hole.equalsIgnoreCase("C"))
					{
					holes_won_player3 = holes_won_player3 + 1;
					}
				else if(winner_of_hole.equalsIgnoreCase("D"))
					{
					holes_won_player4 = holes_won_player4 + 1;
					}
			
				
		    	}
			
			counter++;
			index++;
			}
		
		counter = 0;
		while(counter<9)
			{
			//System.out.println("player 1: " + player1[counter]);
			score_total_player1 = score_total_player1 + player1[counter];
			counter++;
			}
		counter = 0;
		while(counter<9)
			{
			//System.out.println("player 2: " + player2[counter]);
			score_total_player2 = score_total_player2 + player2[counter];
			counter++;
			}
		
		counter = 0;
		while(counter<9)
			{
			//System.out.println("player 3: " + player3[counter]);
			score_total_player3 = score_total_player3 + player3[counter];
			counter++;
			}
		
		counter = 0;
		while(counter<9)
			{
			//System.out.println("player 4: " + player4[counter]);
			score_total_player4 = score_total_player4 + player4[counter];
			counter++;
			}
		
		//Output #1
		score_par_player2 =  score_total_player2 - 36;  
		if (score_par_player2 < 0)
			{
			System.out.println(Math.abs(score_par_player2) + " under par");
			}
		if (score_par_player2 > 0)
			{
			System.out.println(Math.abs(score_par_player2) + " over par");
			}
		else if (score_par_player2 == 0)
			{
			System.out.println("par");
			}
		
		
		//Output #2
		score_par_player1 =  score_total_player1 - 36;  
		if (score_par_player1 < 0)
			{
			System.out.println(Math.abs(score_par_player1) + " under par");
			}
		else if (score_par_player1 > 0)
			{
			System.out.println(Math.abs(score_par_player1) + " over par");
			}
		else if (score_par_player1 == 0)
			{
			System.out.println("par");
			}
		
		
		//Output #3
		total_scores[0] = score_total_player1;
		total_scores[1] = score_total_player2;
		total_scores[2] = score_total_player3;
		total_scores[3] = score_total_player4;
		Arrays.sort(total_scores);
		
		
		
		if(total_scores[0] == score_total_player1)
			{
			System.out.println(holes_won_player1);
			}
		else if(total_scores[0] == score_total_player2)
			{
			System.out.println(holes_won_player2);
			}
		else if(total_scores[0] == score_total_player3)
			{
			System.out.println(holes_won_player3);
			}
		else if(total_scores[0] == score_total_player4)
			{
			System.out.println(holes_won_player4);
			}
		
		//Output #4
		
		
		if(total_scores[0] == score_total_player1)
			{
			position1 = "A";
			}
		else if(total_scores[0] == score_total_player2)
			{
			position1 = "B";
			}
		else if(total_scores[0] == score_total_player3)
			{
			position1 = "C";
			}
		else if(total_scores[0] == score_total_player4)
			{
			position1 = "D";
			}
		
		
		if(total_scores[1] == score_total_player1)
			{
			position2 = "A";
			}
		else if(total_scores[1] == score_total_player2)
			{
			position2 = "B";
			}
		else if(total_scores[1] == score_total_player3)
			{
			position2 = "C";
			}
		else if(total_scores[1] == score_total_player4)
			{
			position2 = "D";
			}
		
		
		if(total_scores[2] == score_total_player1)
			{
			position3 = "A";
			}
		else if(total_scores[2] == score_total_player2)
			{
			position3 = "B";
			}
		else if(total_scores[2] == score_total_player3)
			{
			position3 = "C";
			}
		else if(total_scores[2] == score_total_player4)
			{
			position3 = "D";
			}
		
		if(total_scores[3] == score_total_player1)
			{
			position4 = "A";
			}
		else if(total_scores[3] == score_total_player2)
			{
			position4 = "B";
			}
		else if(total_scores[3] == score_total_player3)
			{
			position4 = "C";
			}
		else if(total_scores[3] == score_total_player4)
			{
			position4 = "D";
			}
		
		System.out.println(position1 + "," + position2 + "," + position3 + "," + position4);
		
		
		
		
		//Output #5
		
		counter = 0;
		index = 0;
		while (counter < 9)
			{
			all_scores[index] = player1[counter];
			index++;
			counter++;
			}
		
		counter = 0;
		while (counter < 9)
		{
		all_scores[index] = player2[counter];
		index++;
		counter++;
		}
		
		counter = 0;
		while (counter < 9)
		{
		all_scores[index] = player3[counter];
		index++;
		counter++;
		}
		
		counter = 0;
		while (counter < 9)
		{
		all_scores[index] = player4[counter];
		index++;
		counter++;
		}
		
		Arrays.sort(all_scores);
		median = ((double)all_scores[17] + (double)all_scores[18])/2;
	
		
		if (((double)all_scores[17] + (double)all_scores[18]) % 2 == 0) 
			{
			System.out.println((int)median);
			//System.out.println("even");			
			}

		else if (((double)all_scores[17] + (double)all_scores[18]) % 2 != 0) 
			{
			System.out.println(median);
			//System.out.println("odd");
			}

		
		
		
		
	}

}
