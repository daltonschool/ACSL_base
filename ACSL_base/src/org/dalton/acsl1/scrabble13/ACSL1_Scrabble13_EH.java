package org.dalton.acsl1.scrabble13;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Eric Helfgott
 * The Dalton School
 * 3055
 */

public class ACSL1_Scrabble13_EH {

	public static int[] getValue(String[] word)
	{
		int[] values = new int[word.length];

		for(int i=0;i<word.length;i++)
		{
			if(word[i].equals("A") || word[i].equals("E")) values[i] = 1;
			else if(word[i].equals("D") || word[i].equals("R")) values[i] = 2;
			else if(word[i].equals("B") || word[i].equals("M")) values[i] = 3;
			else if(word[i].equals("V") || word[i].equals("Y")) values[i] = 4;
			else if(word[i].equals("J") || word[i].equals("X")) values[i] = 8;
		}
		return values;
	}
	
	public static int HorizontalScore(int loc, int[] value, int[][] board)
	{
		int row = 0;
		int col = 0;
		int sum = 0;
		boolean double_word = false;
		boolean triple_word = false;

		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(board[i][j] == loc)
				{
					row = i;
					col = j;	
				}
			}
		}

		for(int a=0;a<value.length;a++)
		{
			if(board[row][col+a]%3 == 0 && board[row][col+a]%2 != 0) value[a] *= 2;	
			else if(board[row][col+a]%5 == 0 && board[row][col+a]%3 != 0) value[a] *= 3;
			else if(board[row][col+a]%7 == 0 && board[row][col+a]%3 != 0 && board[row][col+a]%5 != 0) double_word = true;
			else if(board[row][col+a]%8 == 0 && board[row][col+a]%7 != 0 && board[row][col+a]%5 != 0) triple_word = true;
			
			sum += value[a];
		}
		
		if(double_word) sum *= 2;
		if(triple_word) sum *= 3;
		
		return sum;
	}

	public static int VerticalScore(int loc, int[] value, int[][] board)
	{
		int row = 0;
		int col = 0;
		int sum = 0;
		boolean double_word = false;
		boolean triple_word = false;

		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(board[i][j] == loc)
				{
					row = i;
					col = j;	
				}
			}
		}

		for(int a=0;a<value.length;a++)
		{
			if(board[row+a][col]%3 == 0 && board[row+a][col]%2 != 0) value[a] *= 2;
			else if(board[row+a][col]%5 == 0 && board[row+a][col]%3 != 0) value[a] *= 3;
			else if(board[row+a][col]%7 == 0 && board[row+a][col]%3 != 0 && board[row+a][col]%5 != 0) double_word = true;
			else if(board[row+a][col]%8 == 0 && board[row+a][col]%7 != 0 && board[row+a][col]%5 != 0) triple_word = true;
			sum += value[a];
		}

		if(double_word) sum *= 2;
		if(triple_word) sum *= 3;

		return sum;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[][] board = new int[4][10];
		int x = 1;

		String word[] = scan.nextLine().split(", ");	
		int[] values = getValue(word);

		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<10;j++)
			{
				board[i][j] = x;
				x++;
			}
		}

		for(int i=0;i<5;i++)
		{
			int[] sums = new int[3];
			String data[] = scan.nextLine().split(", ");	

			
			if(data[1].equals("H")) sums[0] = HorizontalScore(Integer.parseInt(data[0]),values, board);
			else sums[0] = VerticalScore(Integer.parseInt(data[0]),values, board);
			
			values = getValue(word);
			
			if(data[3].equals("H")) sums[1] = HorizontalScore(Integer.parseInt(data[2]),values, board);
			else sums[1] = VerticalScore(Integer.parseInt(data[2]),values, board);
			
			values = getValue(word);
			
			if(data[5].equals("H")) sums[2] = HorizontalScore(Integer.parseInt(data[4]),values, board);
			else sums[2] = VerticalScore(Integer.parseInt(data[4]),values, board);
			
			values = getValue(word);

			Arrays.sort(sums);
			System.out.println(sums[2]);
		}
	}
}