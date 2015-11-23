package org.dalton.acsl1.scrabble13;
/*
 * Elias Stengel-Eskin
 * The Dalton School 
 * #3055
 */
import java.util.Arrays;
import java.util.Scanner;
public class ACSL1_Scrabble13_ESE {
	public static void main(String[] args)
	{

		//ints

		String[] board2 = new String[40];

		//take the input
		Scanner scan = new Scanner(System.in);
		String[] input = new String[6];
		for (int i = 0; i < input.length; i++) {
			input[i] = scan.nextLine();
		}
		//the word
		String[] firstLine = input[0].split(", ");
		//the lines of coordinates
		for (int b = 0; b < 5; b++) {

			String[] secondLine = input[b+1].split(", "); // works
			int[] largest = new int[6];

			//place the word on the board

			//parse the first line of coordinates

			for(int t = 0; t < secondLine.length; t=t+2)
			{

				int startSpot = Integer.parseInt(secondLine[t])-1;//works

				String orient = secondLine[t+1]; //works
				//System.out.println("Orient is "+ orient);
				//place the first letter onto the board
				board2[startSpot] = firstLine[0];

				//if horizontally oriented
				if(orient.equals("H"))
				{
					//fill in the rest of the letters
					for (int j = 1; j < firstLine.length; j++) {
						board2[startSpot + j] = firstLine[j];
						//System.out.println("firstline = " + firstLine[j]);

					}
				}
				//if vertically oriented
				if(orient.equals("V"))
				{
					for (int j = 1; j < firstLine.length; j++) {
						board2[startSpot + j*10] = firstLine[j];
						//System.out.println("firstline = " + firstLine[j]);


					}
				}

				//compare to the board to get scores
				int counter = 0;


				boolean doubleWord = false;
				boolean tripleWord = false;

				for (int i = 0; i < board2.length; i++) {
					//booleans
					boolean doubleLetter = false;
					boolean tripleLetter = false;
					int num = i + 1;

					int letterScore = 0;	
					if(board2[i] != null && !board2[i].isEmpty())
					{
						//start with base letter score
						if(board2[i].equals("A") || board2[i].equals("E")) letterScore = 1;
						else if(board2[i].equals("D") || board2[i].equals("R")) letterScore = 2;
						else if(board2[i].equals("B") || board2[i].equals("M")) letterScore = 3;
						else if(board2[i].equals("V") || board2[i].equals("Y")) letterScore = 4;
						else if(board2[i].equals("J") || board2[i].equals("X")) letterScore = 8;

						//is it on a double/triple letter?
						if(num == 3 || num == 9 || num == 15 ||num == 21 ||num == 27 ||num == 33 ||num == 39) doubleLetter = true;
						else doubleLetter = false;

						if(num == 5 || num == 10 || num == 20 || num == 25 || num == 30 || num == 35 || num == 40) tripleLetter = true;
						else tripleLetter = false;

						//is it on a double/triple word?
						if(num == 7 || num == 14 || num == 28) doubleWord = true;
						
					//	System.out.println(doubleWord);
						if(num == 8 || num == 16 || num == 24 || num == 32) tripleWord = true;
						
					//	System.out.println(tripleWord + " tripleWord");
						//calculate result
						//letters
						if(doubleLetter == true) letterScore = letterScore*2;
						if(tripleLetter == true) letterScore = letterScore*3;
					//	System.out.println("letterScore = " + letterScore+ " @ " + num);
						counter+=letterScore;
						//works
						board2[i] = null;

					}
				}
				if(doubleWord)
				{
					counter = counter *2;
				}
				if(tripleWord)
				{
					counter = counter * 3;
				}
				else;
				
				largest[t] = counter;
				
			}
			Arrays.sort(largest);
			System.out.println(largest[5]);
		}
	}
}
