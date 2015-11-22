package org.dalton.golf09;
/**
 * Author: Ivo Crnkovic-Rubsamen
 * School: The Dalton School
 * School Code: 333580
 * Acsl Contest Program 1
 * 
**/
import java.util.*;
public class GolfICR {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String raw_data[] = new String [9];
		String[] raw_array = new String[4];
		int parvalue = 0;
		int player_a_score_total = 0;
		int player_b_score_total = 0;
		int player_c_score_total = 0;
		int player_d_score_total = 0;
		int player_a_score = 0;
		int player_b_score = 0;
		int player_c_score = 0;
		int player_d_score = 0;
		int player_a_wins = 0;
		int player_b_wins = 0;
		int player_c_wins = 0;
		int player_d_wins = 0;
		int all_scores[] = new int [37];
		
		for (int i = 0; i < 9; i++)
		{
			raw_data[i] = in.nextLine();
		}
		for (int counter = 0; counter < 9; counter++)
		{
			raw_array = raw_data[counter].split(",");
			player_a_score = Integer.parseInt(raw_array[0]);
			all_scores[(counter * 4)] = player_a_score;
			player_b_score = Integer.parseInt(raw_array[1]);
			all_scores[(counter * 4) + 1] = player_b_score;
			player_c_score = Integer.parseInt(raw_array[2]);
			all_scores[(counter * 4) + 2] = player_c_score;
			player_d_score = Integer.parseInt(raw_array[3]);
			all_scores[(counter * 4) + 3] = player_d_score;
			player_a_score_total += Integer.parseInt(raw_array[0]);
			//System.out.println(player_a_score_total);
			player_b_score_total += Integer.parseInt(raw_array[1]);
			player_c_score_total += Integer.parseInt(raw_array[2]);
			player_d_score_total += Integer.parseInt(raw_array[3]);
			if (player_a_score < player_b_score && player_a_score < player_c_score && player_a_score < player_d_score)
			{
				player_a_wins++;
			}
			else if (player_b_score < player_a_score && player_b_score < player_c_score && player_b_score < player_d_score)
			{
				player_b_wins++;
			}
			else if (player_c_score < player_a_score && player_c_score < player_b_score && player_c_score < player_d_score)
			{
				player_c_wins++;
			}
			else if (player_d_score < player_a_score && player_d_score < player_b_score && player_d_score < player_c_score)
			{
				player_d_wins++;
			}
			//System.out.println(player_a_wins + " , " + player_b_wins + " , " + player_c_wins + " , " + player_d_wins + " , ");
		}
		if (player_b_score_total < 36)
		{
			parvalue = 36 - player_b_score_total;
			System.out.println(parvalue + " under par");
		}
		else if (player_b_score_total > 36)
		{
			parvalue = player_b_score_total - 36;
			System.out.println(parvalue + " over par");
		}
		else
		{
			System.out.println("par");
		}
		if (player_a_score_total < 36)
		{
			parvalue = 36 - player_a_score_total;
			System.out.println(parvalue + " under par");
		}
		else if (player_a_score_total > 36)
		{
			parvalue = player_a_score_total - 36;
			System.out.println(parvalue + " over par");
		}
		else
		{
			System.out.println("par");
		}
		String str_holder = "";
		int holder = 0;
		int [] temp = new int [5];
		String [] names = new String [5];
		temp[0] = player_a_score_total;
		temp[1] = player_b_score_total;
		temp[2] = player_c_score_total;
		temp[3] = player_d_score_total;
		temp[4] = 99;
		names[0] = "A";
		names[1] = "B";
		names[2] = "C";
		names[3] = "D";
		names[4] = "lol";
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (temp[j] > temp[j+1])
				{
					holder = temp[j];
					temp[j] = temp[j+1];
					temp[j+1] = holder;
					str_holder = names[j];
					names[j] = names[j+1];
					names[j+1] = str_holder;
				}
			}
		}
		if (names[0].equals("A"))
		{
			System.out.println(player_a_wins);
		}
		else if(names[0].equals("B"))
		{
			System.out.println(player_b_wins);
		}
		else if(names[0].equals("C"))
		{
			System.out.println(player_c_wins);
		}
		else if(names[0].equals("D"))
		{
			System.out.println(player_d_wins);
		}
		
		for (int i = 0; i < 4; i++)
		{
			if (i <3)
			{
				System.out.print(names[i] + ",");
			}
			else
			{
				System.out.println(names[i]);
			}
		}
		
		all_scores[36] = 99;
		for (int i = 0; i < 36; i++)
		{
			for (int j = 0; j < 36; j++)
			{
				if (all_scores[j] > all_scores[j+1])
				{
					holder = all_scores[j];
					all_scores[j] = all_scores[j+1];
					all_scores[j+1] = holder;
				}
			}
		}
		for (int i = 0; i < 37; i++)
		{
			//System.out.println(all_scores[i] + " , ");
		}
		double median = 0;
		median = ((double)(all_scores[17] + all_scores[18]))/2;
		if (median % 1 > 0)
		{
			System.out.println(median);
		}
		else
		{
			System.out.println((all_scores[17] + all_scores[18])/2);
		}
	}
}
