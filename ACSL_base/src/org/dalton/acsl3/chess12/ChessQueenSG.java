package org.dalton.acsl3.chess12;
import java.util.*;

//Sarah Gross

public class ChessQueenSG {
public static int[] parseInput(String input)
{
	String[] cutup = input.split(",");
	int[] toInts = new int[cutup.length-2];
	for(int i = 0; i<cutup.length-2; i++)
	{
		cutup[i]=cutup[i].replaceAll(" ","");
		toInts[i] = Integer.parseInt(cutup[i]);
		toInts[i] = toInts[i]-1;
	}
	return toInts;
}
public static int[][] fillBoard(int[] input)
{

	int[][] board = new int[8][8];

for (int i=0; i<input.length; i=i+2)
{
	board[input[i]][input[i+1]] = board[input[i]][input[i+1]] -100;
}
	return board;
}
public static int getPieceNum(String input)
{
	String[] cutup = input.split(",");
	return (cutup.length-2)/2;
}
public static void printBoard(int[][] board)
{
	for (int i=0; i<board.length; i++)
	{
		for (int j=0; j<board.length; j++)
		{
			System.out.print(board[i][j]);
		}
		System.out.println();
	}
}
public static int[][] countPossibilities(int[][] board, int[] pieceplaces)
{
	for(int k=0; k<pieceplaces.length; k=k+2)
	{
		/*for (int i=0; i<board.length; i++)
		{
			for (int j=0; j<board.length; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		*/
		
		for(int i=0; i<8; i++)
		{
			board[pieceplaces[k]][i] = board[pieceplaces[k]][i]+1;
		}
		for(int j=0; j<8; j++)
		{
			board[j][pieceplaces[k+1]] = board[j][pieceplaces[k+1]]+1;
		}
for(int row=0; row<8; row++)
{
	for(int col=0; col<8; col++)
		if (row+col == pieceplaces[k]+pieceplaces[k+1])
		{
			board[row][col] = board[row][col]+1;
		}
		else if(row-col == pieceplaces[k]-pieceplaces[k+1])
		{
			board[row][col] = board[row][col]+1;
		}
}

	}
	return board;
}
public static void printQP(int[][] board, int num)
{
	boolean found = false; 
	while(found == false)
	{
	for(int row=0; row<8; row++)
	{
		if(found == true)
		{
			break;
		}
		for(int col=0; col<8; col++)
		{	
			if(board[row][col]==num)
			{
				col = col+1;
				System.out.println(row+1 + ", " + col);
				found = true;
				break;
			}	
		}
		
	}
	if (found == false)
	{
		System.out.println("NONE");
		break;
	}
	}
}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<100; i++)
		{
		String input = scan.nextLine();
		printQP(countPossibilities(fillBoard(parseInput(input)), parseInput(input)), getPieceNum(input));
		//printBoard(fillBoard(parseInput(input)));
		//System.out.println(getPieceNum(input));
		}
	}

}
