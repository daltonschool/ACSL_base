package org.dalton.acsl3.isola14;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;


public class ACSL3_Isola14_EG {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			String scanOrig = scan.nextLine();
			String[]stringInput = scanOrig.split(", ");
			int [] input = new int[stringInput.length];
			for (int i = 0; i < stringInput.length; i++) {
				input[i] = converter(stringInput)[i];
			}
			if(path(boardGen(converter(stringInput)), converter(stringInput), "up") == false && path(boardGen(converter(stringInput)), converter(stringInput), "down") == false&&path(boardGen(converter(stringInput)), converter(stringInput), "left") == false && path(boardGen(converter(stringInput)), converter(stringInput), "right") == false&&path(boardGen(converter(stringInput)), converter(stringInput), "diagul") == false&&path(boardGen(converter(stringInput)), converter(stringInput), "diagur") == false&& path(boardGen(converter(stringInput)), converter(stringInput), "diagdl") == false&&path(boardGen(converter(stringInput)), converter(stringInput), "diagdr") == false)
			{
				System.out.println("NONE");
			}
		}
		//answer(input[0], input[1], boardGen(converter(stringInput)));
		//boardGen(converter(stringInput));
	}
	static int[][] boardGen(int[] input)
	{
		boolean contains = false;
		int[][] board = new int[][]
				{
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{ 0, 1, 2, 3, 4, 5, 6, 7, 0},
				{ 0, 8, 9, 10, 11, 12, 13, 14, 0},
				{ 0, 15, 16, 17, 18, 19, 20, 21, 0},
				{ 0, 22, 23, 24, 25, 26, 27, 28, 0},
				{ 0, 29, 30, 31, 32, 33, 34, 35, 0},
				{ 0, 36, 37, 38, 39, 40, 41, 42, 0},
				{ 0, 43, 44, 45, 46, 47, 48, 49, 0},
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				};

		int value = 1;
		for (int i = 0; i < board.length; i++) // start from bottom
		{
			for (int j = 0; j < board.length; j++) 
			{
				for (int z = 2; z < input.length; z++)
				{
					if (board[i][j] == input[z]) // if anything of the array is equal to value
					{
						board[i][j] = 0; // set the number = 0 (boundry)
						contains = true;
					}
				}
				if (input[0] == board[i][j])
				{
					board[i][j] = 50; // show placement of one piece +
					contains = true;
				}
				if (input[1] == board[i][j])
				{
					board[i][j] = 51; // other piece x
					contains = true;
				}

				contains = false;
			}
		}

		return (board);
	}
	static int[] converter(String[] stringInput)
	{
		int[] input = new int[stringInput.length];
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(stringInput[i]); // convert String to Int while copying
		}
		return(input);
	}

	static int row (int place)
	{
		int Row = 0;
		if(place <= 7) Row = 1;
		else if(place <= 14) Row = 2;
		else if(place <= 21) Row = 3;
		else if(place <= 28) Row = 4;
		else if(place <= 35) Row = 5;
		else if(place <= 42) Row = 6;
		else if(place <= 49) Row = 7;
		return Row;	
	}
	static int col (int place)
	{
		int col = 0;
		if(place%7 == 1) col = 1;
		else if(place%7 == 2) col = 2;
		else if(place%7 == 3) col = 3;
		else if(place%7 == 4) col = 4;
		else if(place%7 == 5) col = 5;
		else if(place%7 == 6) col = 6;
		else if(place%7 == 0) col = 7;
		return col;
	}

	static boolean path (int[][] board, int[] input, String type) // bashes until finds one that works
	{
		int row = row(input[1]);
		int col = col(input[1]);
		//System.out.println(board[row+1][col]);

		int i = 0;
		boolean poss = false;
		//up
		if(type.equals("up"))
		{
			int[] path = new int [10];

			while(board[row+1][col]!=0&&board[row+1][col]!=50)
			{

				//System.out.println(path[i]);
				//System.out.println(board[row+1][col]);
				path[i] = board[row+1][col];
				board[row+1][col]=0;
				//System.out.println(path[i]);
				//System.out.println(path[i]);
				row++;
				i++;
				poss = true;	
			}
			if(poss == true)
			{
				board[row][col]=0;
			}
			if (checker(board, input[0]) == true)
			{
				for (int j = 0; j < path.length; j++) {
					if(path[j]!=0)
					{
						if(path[j+1]!=0){
							System.out.print(path[j] + ", ");
						}
						else
						{
							System.out.print(path[j]);
						}
					}
				}
				return true;
			}
		}

		//down
		else if(type.equals("down"))
		{
			int[] path = new int [10];
			board[row][col]=0;
			while(board[row-1][col]!=0&&board[row-1][col]!=50)
			{
				path[i]=board[row-1][col];
				board[row-1][col]=0;
				row--;
				i++;
				poss = true;
			}
			if(poss == true)
			{
				board[row][col]=0;
			}
			if (checker(board, input[0]) == true)
			{

				for (int j = 0; j < path.length; j++) {
					if(path[j]!=0)
					{
						if(path[j+1]!=0){
							System.out.print(path[j] + ", ");
						}
						else
						{
							System.out.print(path[j]);
						}
					}
				}
				return true;
			}
		}
		//left
		else if(type.equals("left"))
		{
			int[] path = new int [10];
			board[row][col]=0;
			while(board[row][col-1]!=0&&board[row][col-1]!=50)
			{
				path[i]=board[row][col-1];
				board[row][col-1]=0;
				col--;
				i++;
				poss = true;
			}
			if(poss == true)
			{
				board[row][col]=0;
			}
			if (checker(board, input[0]) == true)
			{
				for (int j = 0; j < path.length; j++) {
					if(path[j]!=0)
					{
						if(path[j+1]!=0){
							System.out.print(path[j] + ", ");
						}
						else
						{
							System.out.print(path[j]);
						}
					}
				}
				return true;
			}
		}
		//right
		else if(type.equals("right"))
		{
			int[] path = new int [10];
			board[row][col]=0;
			while(board[row][col+1]!=0&&board[row][col+1]!=50)
			{
				path[i]=board[row][col+1];
				board[row][col+1]=0;
				col++;
				i++;
				poss = true;
			}
			if(poss == true)
			{
				board[row][col]=0;
			}
			if (checker(board, input[0]) == true)
			{
				for (int j = 0; j < path.length; j++) {
					if(path[j]!=0)
					{
						if(path[j+1]!=0){
							System.out.print(path[j] + ", ");
						}
						else
						{
							System.out.print(path[j]);
						}
					}
				}
				return true;
			}
		}
		//diagul
		else if(type.equals("diagul"))
		{
			int[] path = new int [10];
			board[row][col]=0;
			while(board[row+1][col-1]!=0&&board[row+1][col-1]!=50)
			{
				path[i]=board[row+1][col-1];
				board[row+1][col-1]=0;
				col--;
				row++;
				i++;
				poss = true;
			}
			if(poss == true)
			{
				board[row][col]=0;
			}
			if (checker(board, input[0]) == true)
			{
				for (int j = 0; j < path.length; j++) {
					if(path[j]!=0)
					{
						if(path[j+1]!=0){
							System.out.print(path[j] + ", ");
						}
						else
						{
							System.out.print(path[j]);
						}
					}
				}
				return true;
			}

		}
		//diagur
		else if(type.equals("diagur"))
		{
			int[] path = new int [10];
			board[row][col]=0;
			while(board[row+1][col+1]!=0&&board[row+1][col+1]!=50)
			{
				path[i]=board[row+1][col+1];
				board[row+1][col+1]=0;
				col++;
				row++;
				i++;
				poss = true;
			}
			if(poss == true)
			{
				board[row][col]=0;
			}
			if (checker(board, input[0]) == true)
			{
				for (int j = 0; j < path.length; j++) {
					if(path[j]!=0)
					{
						if(path[j+1]!=0){
							System.out.print(path[j] + ", ");
						}
						else
						{
							System.out.print(path[j]);
						}
					}
				}
				return true;
			}
		}
		//diagdl
		else if(type.equals("diagdl"))
		{
			int[] path = new int [10];
			board[row][col]=0;
			while(board[row-1][col-1]!=0&&board[row-1][col-1]!=50)
			{
				path[i]=board[row-1][col-1];
				board[row-1][col-1]=0;
				col--;
				row--;
				i++;
				poss = true;
			}
			if(poss == true)
			{
				board[row][col]=0;
			}
			if (checker(board, input[0]) == true)
			{
				for (int j = 0; j < path.length; j++) {
					if(path[j]!=0)
					{
						if(path[j+1]!=0){
							System.out.print(path[j] + ", ");
						}
						else
						{
							System.out.print(path[j]);
						}
					}
				}
				return true;
			}

		}
		//diagdr
		else if(type.equals("diagdr"))
		{
			int[] path = new int [10];
			board[row][col]=0;
			while(board[row-1][col+1]!=0&&board[row-1][col+1]!=50)
			{
				path[i]=board[row-1][col+1];
				board[row-1][col+1]=0;
				col++;
				row--;
				i++;
				poss = true;
			}
			if(poss == true)
			{
				board[row][col]=0;
			}
			if (checker(board, input[0]) == true)
			{
				for (int j = 0; j < path.length; j++) {
					if(path[j]!=0)
					{
						if(path[j+1]!=0){
							System.out.print(path[j] + ", "); //formatting
						}
						else
						{
							System.out.print(path[j]);
						}
					}
				}
				return true;
			}

		}

		return false;

	}
	static boolean checker(int[][] board, int piece) // checks feasability
	{

		//up
		if(board[row(piece)+1][col(piece)]== 0 && board[row(piece)-1][col(piece)]== 0 && board[row(piece)][col(piece)-1]== 0 && board[row(piece)][col(piece)+1]== 0 && board[row(piece)+1][col(piece)-1]== 0&& board[row(piece)+1][col(piece)+1]== 0&& board[row(piece)-1][col(piece)-1]== 0&& board[row(piece)-1][col(piece)+1]== 0) // checks if feasable
		{
			return true;
		}
		else
		{
			return false;
		}
		//down
		//left
		//right
		//diagul
		//diagur
		//diagdl
		//diagdr
	}

}

