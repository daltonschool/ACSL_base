package org.dalton.acsl1.scrabble13;

import java.util.Scanner;

public class ACSL1_Scrabble13_SM 
/* Sonia Mittal
 * The Dalton School
 * 3055
 */

/* ACSL
 * Create an array (4x10)
 * Place = (jx10)+(i+1) --> (i,j)
 * Make one method for "is it a multiple of __" and then one for calculations (put onto game board) and one for which
 	value is the best one
 * (21/3)%2=1 
 */

{
	public static void main (String args[])
	{
		Scanner scan = new Scanner(System.in);
		int total1 = 0;
		int total2 = 0;
		int total3 = 0;
		String data = scan.nextLine();
		StringBuffer data_bf = new StringBuffer(data);
		data_bf.deleteCharAt(1);
		data_bf.deleteCharAt(1);
		data_bf.deleteCharAt(2);
		data_bf.deleteCharAt(2);
		data_bf.deleteCharAt(3);
		data_bf.deleteCharAt(3);

		char[]words = data_bf.toString().toCharArray();
		int[]letters = charValues(words);

		for (int j=0; j<5; j++)
		{ 
			int[]board = new int[41];
			for (int i=0; i<41; i++)
			{
				board[i]=0;
			}

			String pos = scan.nextLine(); //position
			String[] input= pos.split("[, ]+");
			String[] dir = new String[3];
			int[] startp = new int[3];
			startp[0] = Integer.parseInt(input[0]);
			startp[1] = Integer.parseInt(input[2]);
			startp[2]= Integer.parseInt(input[4]);
			dir[0]=input[1];
			dir[1] =input[3];
			dir[2]=input[5];

			total1= gameVal(startp[0], dir[0], letters,board);

			for (int i=0; i<41; i++)
			{
				board[i]=0;
			}
			total2 = gameVal(startp[1], dir[1], letters, board);
			for (int i=0; i<41; i++)
			{
				board[i]=0;
			}
			total3= gameVal(startp[2], dir[2], letters, board);
			int best = bestPlay(total1, total2, total3);
			System.out.println(best);
		}		
	}
	public static int [] charValues (char[] letters)
	{
		int [] charvalues = new int[4];
		for (int i=0; i<4; i++)
		{
			if (letters[i] == 'A' ||letters[i] =='E')
			{
				charvalues[i]=1;
			}
			if (letters[i] == 'D' ||letters[i] =='R')
			{
				charvalues[i]=2;
			}
			if (letters[i] == 'B' ||letters[i] =='M')
			{
				charvalues[i]=3;
			}
			if (letters[i] == 'V' ||letters[i] =='Y')
			{
				charvalues[i]=4;
			}
			if (letters[i] == 'J' ||letters[i] =='X')
			{
				charvalues[i]=8;
			}
		}

		return charvalues;
	}

	public static int gameVal (int startp, String dir, int[] lvals, int[]board)
	{
		int gameval=0;
		if (dir.equals("H"))
		{
			int letloc =0;
			for (int i = startp; i<startp+4; i++)
			{
				board[i] = lvals[letloc];

				letloc++;
			}
		}

		if(dir.equals("V"))
		{
			int letloc=0;
			for (int i=startp; i<startp+31; i=i+10)
			{
				board[i]=lvals[letloc];
				letloc++;
			}
		}
		gameval = lvals[0]+lvals[1]+lvals[2]+lvals[3];
		for(int i=3; i<40; i=i+6)
		{
			if (board[i] != 0)
			{
				gameval = gameval+board[i];
			}
		}
		for (int i=5; i<41; i=i+5)
		{
			if(i%3 != 0 && board[i]!=0)
			{
				gameval = gameval+ board[i]+board[i];
			}
		}
		for (int i=7; i<36; i=i+7)
		{
			if (i%3!=0 && i%5!=0 && board[i]!=0)
			{
				gameval= gameval+gameval;
			}
		}
		for (int i=8; i<41; i=i+8)
		{
			if ((i%2==0||i%3!=0) && i%5!=0 && i%7!=0 && board[i]!=0)
			{
				gameval= gameval+gameval+gameval;
			}
		}

		return gameval;
	}
	public static int bestPlay (int total1, int total2, int total3)
	{
		int best=0;
		if(total1>total2||total1==total2)
		{
			best = total1;
		}
		else if (total1<total2|| total1==total2)
		{
			best = total2;
		}
		if (best<total3)
		{
			best=total3;
		}
		return best;

	}
}