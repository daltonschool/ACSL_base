package org.dalton.acsl3.grid11;
import java.util.ArrayList;
import java.util.Scanner;

//cara haas


public class GridFitCH {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String intake=input.nextLine();
		String[] filled = intake.split(", ");
		int[] board = new int[35];
		int[] turns = new int[5];

		for(int i=1; i<filled.length; i++)
		{
			board[Integer.parseInt(filled[i])-1] =1 ;
		}

		for(int i=0; i<5; i++)
		{
			turns[i] = input.nextInt();
		}

		try {
			for(int i=0; i<5; i++)
			{
				if(turns[i]==1)
				{
					int[] spots=one(board);
					board=replaceBoard(board, spots);
				}
				else if(turns[i]==2)
				{
					int[] spots=two(board);
					board=replaceBoard(board, spots);
				}
				else if(turns[i]==3)
				{
					int[] spots=three(board);
					board=replaceBoard(board, spots);
				}
				else if(turns[i]==4)
				{
					int[] spots=four(board);
					board=replaceBoard(board, spots);
				}
				else if(turns[i]==5)
				{
					int[] spots=five(board);
					board=replaceBoard(board, spots);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}




	public static boolean aboveCheck(int[] board, int point) 
	{
		boolean works = true;
		for(int i=point; i<35; i=i+5)
		{
			if(board[i]==1)
			{
				works=false;
			}
		}

		return works;
	}

	public static int[] one(int[] board)
	{
		int[] ret = new int[3];
		for(int i=0; i<35; i++)
		{
			if(board[i]==0 && aboveCheck(board, i)==true)
			{
				ret[0]=i;
				break;
			}
			else ret[0]=100;
		}
		return ret;
	}

	public static int[] two(int[] board)
	{
		int[] ret = new int[3];
		for(int i=0; i<30; i++)
		{
			if(board[i]==0 && board[i+5] == 0 && aboveCheck(board, i)==true)
			{
				ret[0]=i;
				ret[1]=i+5;
				break;
			}
			else ret[0]=100;
		}
		return ret;
	}

	public static int[] three(int[] board)
	{
		int[] ret = new int[3];
		for(int i=0; i<34; i++)
		{
			if(i%5==4) i++;

			if(board[i]==0 && board[i+1] == 0 && aboveCheck(board, i)==true && aboveCheck(board, i+1)==true)
			{
				ret[0]=i;
				ret[1]=i+1;
				break;
			}
			else ret[0]=100;
		}
		return ret;
	}

	public static int[] four(int[] board)
	{
		int[] ret = new int[3];
		for(int i=0; i<29; i++)
		{
			if(i%5==4) i++;

			if(board[i]==0 && board[i+5] == 0 && board[i+6] == 0 && aboveCheck(board, i)==true && aboveCheck(board, i+6)==true)
			{
				ret[0]=i;
				ret[1]=i+5;
				ret[2]=i+6;
				break;
			}
			else ret[0]=100;
		}
		return ret;
	}

	public static int[] five(int[] board)
	{
		int[] ret = new int[3];
		for(int i=0; i<29; i++)
		{
			if(i%5==4) i++;

			if(board[i]==0 && board[i+1] == 0 && board[i+5] == 0 && aboveCheck(board, i)==true && aboveCheck(board, i+1)==true)
			{
				ret[0]=i;
				ret[1]=i+1;
				ret[2]=i+5;
				break;
			}
			else ret[0]=100;

		}
		return ret;
	}

	public static int[] replaceBoard(int[] board, int[] spots)
	{
		if(spots[0]==100) System.out.println("NONE");	
		else{
			for(int i=0; i<spots.length; i++)
			{
				board[spots[i]]=1;
			}
			System.out.println(spots[0]+1);
		}
		return board;
	}
}
