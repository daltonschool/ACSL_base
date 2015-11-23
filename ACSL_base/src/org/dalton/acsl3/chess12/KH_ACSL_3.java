package org.dalton.acsl3.chess12;

/**
 * Name: Keiko Higashikawa
 * School: Dalton School
 * School Code: 3055
 */
import java.util.Arrays;
import java.util.Scanner;

public class KH_ACSL_3 
{
	public static void range(int[][] board, String piece)
	{
		int row = Integer.parseInt(piece)/10 - 1;
		int col = Integer.parseInt(piece)%10 - 1;

		for(int a = 0; a<8; a++)
		{
			board[row][a]= board[row][a] + 1;//left-right places
			board[a][col]= board[a][col] + 1;//up-down places
		}
		for(int b = 0; b<8; b++)//diagonals
		{
			if(row+b<8 && col+b<8)
			{
				board[row+b][col+b]=board[row+b][col+b] + 1;
			}
			if(row-b>=0 && col-b>=0)
			{
				board[row-b][col-b]=board[row-b][col-b] + 1;
			}
			if(row-b>=0 && col+b<8)
			{
				board[row-b][col+b]=board[row-b][col+b] + 1;
			}
			if(row+b<8 && col-b>=0)
			{
				board[row+b][col-b]=board[row+b][col-b] + 1;
			}
			else{}
		}

		board[row][col] = 0;
	}
	public static String search(int[][] board, int piecenum)
	{
		String out = "NONE";
		for(int r = 0; r < 8;r++)
		{
			for(int c = 0; c < 8; c++)
			{
				if(board[r][c]==piecenum)
				{
					out=Integer.toString((r+1)*10 + (c+1));
					r=8;
					c=8;
				}
				else{}
			}
		}
		return out;
	}
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String[] finalout = new String[5];
		int line = 0;
		while (line<5)
		{
			String dump[] = input.nextLine().split(",\\s+");
			String[] piecelist = new String[(dump.length-2)/2];
			int listcount = 0;

			int[][] board = new int[8][8];
			for(int r = 0; r < 8;r++)
			{
				for(int c = 0; c < 8; c++)
				{
					board[r][c] = 0;
				}
			}
			for(int count = 0; count<dump.length-3; count=count+2)
			{
				piecelist[listcount] = dump[count] + dump[count+1]; 
				listcount ++;
			}
			for(int a = 0; a<piecelist.length; a++)
			{
				range(board, piecelist[a]);
			}
			finalout[line] = search(board, piecelist.length);
			line++;
		}
		for(int done = 0; done < finalout.length; done++)
		{
			if(finalout[done].equals("NONE"))
			{
				System.out.println(finalout[done]);
			}
			else
			{
				System.out.println(finalout[done].charAt(0) + ", " + finalout[done].charAt(1));
			}
		}
	}
}
