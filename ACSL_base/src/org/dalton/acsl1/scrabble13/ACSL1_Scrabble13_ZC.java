//Zach Cohen
//The Dalton School: 3055
package org.dalton.acsl1.scrabble13;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL1_Scrabble13_ZC {

	public static void order(String letters, String input)
	{
		String data[] = letters.split(", ");
		String[] tiles = new String[4];
		tiles[0] = (data[0]);
		tiles[1] = (data[1]);
		tiles[2] = (data[2]);
		tiles[3] = (data[3]);

		int[] piece = new int[4];
		for (int i = 0; i < tiles.length; i++) {
			if(tiles[i].matches("A") == true || tiles[i].matches("E") == true)
			{
				piece[i] = 1;
			}
			else if(tiles[i].matches("D") == true || tiles[i].matches("R") == true)
			{
				piece[i] = 2;
			}
			else if(tiles[i].matches("B") == true || tiles[i].matches("M") == true)
			{
				piece[i] = 3;
			}
			else if(tiles[i].matches("V") == true || tiles[i].matches("Y") == true)
			{
				piece[i] = 4;
			}
			else if(tiles[i].matches("J") == true || tiles[i].matches("X") == true)
			{
				piece[i] = 8;
			}
		}
		pair(input, piece);
	}


	public static void pair(String input, int[] piece)
	{
		int[] answer = new int[3];
		String data[] = input.split(", ");
		int[] start = new int[3];
		String[] path = new String[3];

		start[0] = Integer.parseInt(data[0]);
		start[1] = Integer.parseInt(data[2]);
		start[2] = Integer.parseInt(data[4]);

		path[0] = data[1];
		path[1] = data[3];
		path[2] = data[5];

		int e = 0;
		for (int i = 0; i < 3; i++) {
			answer[i] = score(start[i], path[i], piece);
			for (int j = 0; j < 3; j++) {
				if(answer[i] > answer[e])
				{
					e =i;
				}
			}
		}
		System.out.println(answer[e]);
		
		
		
		
		

	}

	public static int score(double start, String path, int[] piece)
	{
		int score = 0;
		int count = 0;
		int square = 0;
		int[] a = new int[4];
		int b = 1;
		//for (int i = 0; i < 3; i++) //Goes through each starting location + direction
		{
			if(path.contains("V"))
			{
				for (int i = 0; i < 4; i++) {
					square = (int) (start + i*10);
					a[i] = 1;
					if(square%2 != 0 && square%3 == 0)
					{
						a[i] = 2;
					}
					else if(square%5 == 0)
					{
						a[i] = 3;
					}
					else if(square%7 == 0)
					{
						b = b *2;
						a[i] = 1;
					}
					else if(square%8 == 0)
					{
						b = b *3;
						a[i] = 1;
					}
				}
			}

			if(path.contains("H"))
			{
				for (int i = 0; i < 4; i++) {
					square = (int) (start + i);
					a[i] = 1;
					if(square%2 != 0 && square%3 == 0)
					{
						a[i] = 2;
					}
					else if(square%5 == 0)
					{
						a[i] = 3;
					}
					else if(square%7 == 0)
					{
						b = b *2;
						a[i] = 1;
					}
					else if(square%8 == 0)
					{
						b = b *3;
						a[i] = 1;
					}
				}
			}
			for (int i = 0; i < 4; i++) 
			{
				count = count + a[i]*piece[i];
			}
			score = count*b;
		}
		return score;
	}

	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		String letters = Scan.nextLine();
		for (int i = 0; i < 10; i++) {
		String input = Scan.nextLine();
		order(letters, input);
		}


	}

}
