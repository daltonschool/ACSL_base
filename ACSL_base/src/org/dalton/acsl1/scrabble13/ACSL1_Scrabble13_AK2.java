package org.dalton.acsl1.scrabble13;
/**
 * Aleksandar Kiprovski
 * The Dalton School
 * #3305
 */
import java.util.*;
public class ACSL1_Scrabble13_AK2{
	public static int letterValue(String letter) // getting the values for each letter
	{
		int value = 0;
		if(letter.equals("A")|| letter.equals("E")) value = 1;
		else if(letter.equals("D")|| letter.equals("R")) value = 2;
		else if(letter.equals("B")|| letter.equals("M")) value = 3;
		else if(letter.equals("V")|| letter.equals("Y")) value = 4;
		else if(letter.equals("J")|| letter.equals("X")) value = 8;
		return value;
	}
	public static int letterMultiplier(int place) // getting the letter multiplier for each space
	{
		int mult = 1;
		if(place%5== 0) mult = 3;
		if(place%3 == 0 && !(place%2 == 0)) mult = 2;
		return mult;
	}
	public static int wordMultiplier(int place) // getting the word multiplier for each space
	{
		int mult = 1;
		if(place%7 == 0 && !(place == 35) && !(place==21)) mult = 2;
		if(place%8 == 0 && !(place == 40)) mult = 3;
		return mult;
	}
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in); //declarations
		String[] input = new String[3];
		String temp = keyboard.nextLine();
		input = temp.split(", ");
		int points = 0;
		int tot = 0;
		int count = 0;
		int[] allPoints = new int[5];
		while(count<5)
		{
			String[] startPoint = keyboard.nextLine().split(", ");
			for(int i = 0; i<6; i+=2)
			{
				int firstStart = Integer.parseInt(startPoint[i]);
				if(startPoint[i+1].equals("H"))
				{
					points = ((letterValue(input[0]) * letterMultiplier(firstStart)) + (letterValue(input[1]) * letterMultiplier(firstStart+1)) + (letterValue(input[2]) * letterMultiplier(firstStart+2)) + (letterValue(input[3]) * letterMultiplier(firstStart+3)));
					tot = points*wordMultiplier(firstStart)*wordMultiplier(firstStart+1)*wordMultiplier(firstStart+2)*wordMultiplier(firstStart+3);
					allPoints[i] = tot;
				}
				if(startPoint[i+1].equals("V"))
				{
					points = ((letterValue(input[0]) * letterMultiplier(firstStart)) + (letterValue(input[1]) * letterMultiplier(firstStart+10)) + (letterValue(input[2]) * letterMultiplier(firstStart+20)) + (letterValue(input[3]) * letterMultiplier(firstStart+30)));
					tot = points*wordMultiplier(firstStart)*wordMultiplier(firstStart+10)*wordMultiplier(firstStart+20)*wordMultiplier(firstStart+30);
					allPoints[i] = tot;
				}
			}
			int max = allPoints[0];
			for ( int i = 1; i < allPoints.length; i++) 
			{
				if ( allPoints[i] > max) 
				{
					max = allPoints[i];
				}
			}
			count ++;
			System.out.println(max);
		}
	}
}