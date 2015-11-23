package org.dalton.acsl1.golf09;
/* Stephen Monk
 * ACSL
 * 9010
 */

import java.util.Scanner;
public class GolfSM 

{
	public static void main(String[] args)
	{
		int[][] stats = new int[9][4];
		Scanner input = new Scanner(System.in);
		String response1 = "";
		int col = 0;
		int playerid = 0;
		int playera = 0;
		int playerb = 0;
		int playerc = 0;
		int playerd = 0;
		for(int x = 0; x<9; x++)
		{
			int y = 1;
			System.out.println("Enter the scores of players A, B, C, and D for hole "+(x+1)+" separated by commas");
			response1 = input.nextLine();
			String[] stringarray = response1.split(",");




			stats[x][0] = Integer.parseInt(stringarray[0]);
			stats[x][1] = Integer.parseInt(stringarray[1]);
			stats[x][2] = Integer.parseInt(stringarray[2]);
			stats[x][3] = Integer.parseInt(stringarray[3]);

		}

		int medianarray[] = new int[36];

		medianarray[0] = stats[0][0];
		medianarray[1] = stats[0][1];
		medianarray[2] = stats[0][2];
		medianarray[3] = stats[0][3];
		medianarray[4] = stats[1][0];
		medianarray[5] = stats[1][1];
		medianarray[6] = stats[1][2];
		medianarray[7] = stats[1][3];
		medianarray[8] = stats[2][0];
		medianarray[9] = stats[2][1];
		medianarray[10] = stats[2][2];
		medianarray[11] = stats[2][3];
		medianarray[12] = stats[3][0];
		medianarray[13] = stats[3][1];
		medianarray[14] = stats[3][2];
		medianarray[15] = stats[3][3];
		medianarray[16] = stats[4][0];
		medianarray[17] = stats[4][1];
		medianarray[18] = stats[4][2];
		medianarray[19] = stats[4][3];
		medianarray[20] = stats[5][0];
		medianarray[21] = stats[5][1];
		medianarray[22] = stats[5][2];
		medianarray[23] = stats[5][3];
		medianarray[24] = stats[6][0];
		medianarray[25] = stats[6][1];
		medianarray[26] = stats[6][2];
		medianarray[27] = stats[6][3];
		medianarray[28] = stats[7][0];
		medianarray[29] = stats[7][1];
		medianarray[30] = stats[7][2];
		medianarray[31] = stats[7][3];
		medianarray[32] = stats[8][0];
		medianarray[33] = stats[8][1];
		medianarray[34] = stats[8][2];
		medianarray[35] = stats[8][3];
		subComparison(stats, 1);
		subComparison(stats, 0);
		System.out.println();
		playera = sort(stats, 0);
		playerb = sort(stats, 1);
		playerc = sort(stats, 2);
		playerd = sort(stats, 3);

		int totals[] = new int [4];

		totals[0] = playera;
		totals[1] = playerb;
		totals[2] = playerc;
		totals[3] = playerd;
		arrayComparison(totals);
		int place = 0;
		findPlayer(totals, playera, playerb, playerc, playerd, 1);
		median(medianarray);

	}
	public static void subComparison(int stats[][], int col)
	{
		int answer = 0;
		int playertot = 0;
		for(int x = 0; x<9; x++)
		{
			playertot = stats[x][col] + playertot;
		}
		answer = playertot - 36;

		if(answer<0)
		{
			System.out.println(-1*answer + " under par");
		}
		else if(answer>0)
		{
			System.out.println(answer + " over par");
		}
		else
		{
			System.out.println("par");
		}
	}
	public static int sort(int stats[][], int playerid)
	{
		int totalsum = 0;
		for(int n=0; n<=8; n++)
		{
			totalsum = stats[n][playerid] + totalsum;
		}
		return totalsum;

	}

	public static void arrayComparison(int totals[])
	{
		int out = 0;
		for(int i=0;i<3;i++)
		{
			for(int j = 0; j<3; j++)
			{

				if(totals[j]>totals[j+1] && j!=3)
				{
					out = totals[j];
					totals[j] = totals[j+1];
					totals[j+1] = out;
				}
			}

		}

		for(int p = 0; p<totals.length; p++)
		{
			//System.out.println(totals[p]);
		}	

	}


	public static void findPlayer(int totals[], int playera, int playerb, int playerc, int playerd, int place)
	{
		for(int i = 0; i<4; i++)
		{
			if(totals[i] == playera)
			{
				System.out.print("A");
			}
			else if(totals[i] == playerb)
			{
				System.out.print("B");
			}
			else if(totals[i] == playerc)
			{
				System.out.print("C");
			}
			else if(totals[i] == playerd)
			{
				System.out.print("D");
			}
			if(i<3) System.out.print(", ");
		}
		System.out.println();
	}

	public static void median(int medianarray[])
	{
		int out = 0;

		for(int j = 0; j<35; j++)
		{

			if(medianarray[j]>medianarray[j+1] && j!=35)
			{
				out = medianarray[j];
				medianarray[j] = medianarray[j+1];
				medianarray[j+1] = out;
			}
		}
		double m = 0;
		m = (medianarray[18] + medianarray[17])/2;
		if(m%1.0>0.0)
		{
			System.out.println(m);
		}
		else
		{
			System.out.println((int)m);
		}
	}

}


