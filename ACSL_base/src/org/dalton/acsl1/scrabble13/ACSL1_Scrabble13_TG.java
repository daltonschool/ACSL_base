package org.dalton.acsl1.scrabble13;

import java.util.Scanner;

/*Tejashree S. Gopal
 *The Dalton School
 *#3055
 */

public class ACSL1_Scrabble13_TG {
	public static int[] values (String[] word) //method for calculating the values of the letters
	{
		int[] wordint = new int[word.length];
		for (int i = 0; i < word.length; i++) {
			if ((word[i].equals("A")) || (word[i].equals("E"))) {wordint[i] = 1;}
			else if ((word[i].equals("D")) || (word[i].equals("R"))) {wordint[i] = 2;}
			else if ((word[i].equals("B")) || (word[i].equals("M"))) {wordint[i] = 3;}
			else if ((word[i].equals("V")) || (word[i].equals("Y"))) {wordint[i] = 4;}
			else if ((word[i].equals("J")) || (word[i].equals("X"))) {wordint[i] = 8;}
		}
		return wordint;
	}

	public static void theMove (String[] move, int[] values) //basically all the work to calculate the move
	{
		int [][] total = new int [3][(values.length)+1]; //creates an empty array
		int u = 0;
		for (int i = 1; i < move.length; i+=2) {
			int x = (Integer.parseInt(move[i-1]));
			if (move[i].equals("H"))
			{
				total[u][0] = letterscore((x), values[0]);
				total[u][1] = letterscore((x+1), values[1]);
				total[u][2] = letterscore((x+2), values[2]);
				total[u][3] = letterscore((x+3), values[3]);
				total[u][4] = total[u][0] +total[u][1] + total[u][2] + total[u][3];
				total[u][4] = wordscore(x, total[u][4]);
				total[u][4] = wordscore((x+1), total[u][4]);
				total[u][4] = wordscore((x+2), total[u][4]);
				total[u][4] = wordscore((x+3), total[u][4]);
				u++;
			}
			else if (move[i].equals("V"))
			{
				total[u][0] = letterscore((x), values[0]);
				total[u][1] = letterscore((x+10), values[1]);
				total[u][2] = letterscore((x+20), values[2]);
				total[u][3] = letterscore((x+30), values[3]);
				total[u][4] = total[u][0] + total[u][1] + total[u][2] + total[u][3];
				total[u][4] = wordscore(x, total[u][4]);
				total[u][4] = wordscore((x+10), total[u][4]);
				total[u][4] = wordscore((x+20), total[u][4]);
				total[u][4] = wordscore((x+30), total[u][4]);
				u++;
			}
		}
		if (total[0][4] > total[1][4] && total[0][4]> total[2][4]) {System.out.println(total[0][4]);}
		else if (total[1][4] > total[0][4] && total[1][4]> total[2][4]) {System.out.println(total[1][4]);}
		else if (total[2][4] > total[1][4] && total[2][4]> total[0][4]) {System.out.println(total[2][4]);}
		else if (total[0][4] == total[1][4]) {System.out.println(total[0][4]);}
		else if (total[0][4] == total[2][4]) {System.out.println(total[0][4]);}
		else if (total[1][4] == total[2][4]) {System.out.println(total[1][4]);}
		else {System.out.println(total[0][4]);}
	} 

	public static int letterscore (int x, int val) //changing letter scores
	{
		int value = val;
		if (x%3 == 0 && (x/3)%2==1) {value = val*2;}
		else if (x%5==0) {value = val*3;}
		else {}
		return value;
	}

	public static int wordscore (int x, int total) //changing word scores
	{
		int newval = total;
		if (x == 7 || x == 14 || x == 28){newval = total*2;}
		else if (x == 8 || x == 16 || x == 24 || x == 32) {newval = total*3;}
		else {}
		return newval;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] word = scan.nextLine().split(", ");
		String[] move1 = scan.nextLine().split(", ");
		String[] move2 = scan.nextLine().split(", ");
		String[] move3 = scan.nextLine().split(", ");
		String[] move4 = scan.nextLine().split(", ");
		String[] move5 = scan.nextLine().split(", ");

		int [] valuearray = values(word);
		theMove(move1, valuearray);
		theMove(move2, valuearray);
		theMove(move3, valuearray);
		theMove(move4, valuearray);
		theMove(move5, valuearray);
	}//main
}//class
