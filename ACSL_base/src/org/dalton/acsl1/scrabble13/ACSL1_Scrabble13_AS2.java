/*Allegra Simon 
 * The Dalton School 
 * 3055
 */package org.dalton.acsl1.scrabble13;
import java.util.Scanner;
public class ACSL1_Scrabble13_AS2 {
	public static void main(String[] args)
	{
		int val1=0;// value from game 1
		int val2=0;//value from game 2
		int val3=0;// value from game 3
		Scanner scan = new Scanner(System.in);
		String wordinput= scan.nextLine();
		StringBuffer wordsb = new StringBuffer(wordinput);
		wordsb.deleteCharAt(1);//get rid of commas
		wordsb.deleteCharAt(1);
		wordsb.deleteCharAt(2);
		wordsb.deleteCharAt(2);
		wordsb.deleteCharAt(3);
		wordsb.deleteCharAt(3);//get rid of commas
		char[]wordchar = wordsb.toString().toCharArray();
		int[]lvals = charValues(wordchar);// convert letters into their values ---- THIS WORKS 

		for (int z=0; z<5; z++)
		{ int[]board = new int[41];// the board
		for (int i=0; i<41; i++)// put zeros in the board
		{
			board[i]=0;
		}

		String pos = scan.nextLine();// take in where to start and direction
		String[] data= pos.split("[, ]+");
		String[] dir = new String[3];//the three directions
		int[] startp = new int[3];//the three starting positions
		startp[0] = Integer.parseInt(data[0]);
		startp[1] = Integer.parseInt(data[2]);
		startp[2]= Integer.parseInt(data[4]);
		dir[0]=data[1];
		dir[1] =data[3];
		dir[2]=data[5];

		val1= gameVal(startp[0], dir[0], lvals,board);

		for (int i=0; i<41; i++)// put zeros in the board
		{
			board[i]=0;
		}
		val2 = gameVal(startp[1], dir[1], lvals, board);
		for (int i=0; i<41; i++)// put zeros in the board
		{
			board[i]=0;
		}
		val3= gameVal(startp[2], dir[2], lvals, board);
		int best = bestPlay(val1, val2, val3);
		System.out.println(best);
		}
	}// end main


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


		}// endwhile

		return charvalues;
	}// end char values

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
	}// end fill board

	public static int bestPlay (int val1, int val2, int val3)
	{
		int best=0;
		if(val1>val2|| val1==val2)
		{
			best = val1;
		}
		else if (val1<val2|| val1==val2)
		{
			best = val2;
		}
		if (best<val3)
		{
			best=val3;
		}
		return best;

	}
}