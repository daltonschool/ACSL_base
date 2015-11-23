package org.dalton.acsl1.scrabble13;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Name: Andrew Milich 
 * School: The Dalton School
 * Code: 3305 
 */

public class ACSL1_Scrabble13_AM {
	static int[] dls = new int[] {3, 9, 15, 21, 27, 33, 39}; //double letter tiles
	static int[] tls = new int[] {5, 10, 20, 25, 30, 35, 40}; //triple letter tiles
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in) ;
		HashMap<String, Integer> values = new HashMap<String, Integer>(); //map from letter to score 
		int[] dw = new int[] {7, 14, 28}; //double word tiles 
		int[] tw = new int[] {8, 16, 24, 32}; //triple word tiles 
		int score = 0, max_score = 0; //scores 
		String[] letters = input.nextLine().split(",");  
		values.put("A", 1); //put in letter values 
		values.put("E", 1);
		values.put("D", 2);
		values.put("R", 2);
		values.put("B", 3);
		values.put("M", 3);
		values.put("V", 4);
		values.put("Y", 4);
		values.put("J", 8);
		values.put("X", 8);
		for (int i = 0; i < letters.length; i++)
			letters[i] = letters[i].trim(); //get rid of white space
		for (int ll = 0; ll < 5; ll++) { //5 lines of locations 
			score = 0; 
			max_score = 0; 
			String[] locations = input.nextLine().split(", "); //individual locations 
			int startTile = 0; 
			int[] locs = new int[4]; //locations of 4 letters 
			for (int ii = 0; ii < 3; ii++) { //3 separate locations for each word 
				startTile = Integer.parseInt(locations[2*ii]);
				if(locations[2*ii + 1].contains("H")) { //if horizontal  
					startTile = Integer.parseInt(locations[2*ii]); 
					locs[0] = startTile; //horizontal - all tiles are consecutive 
					locs[1] = startTile + 1; 
					locs[2] = startTile + 2;
					locs[3] = startTile + 3;
				}
				else if (locations[2*ii + 1].contains("V")){ //if vertical 
					startTile = Integer.parseInt(locations[2*ii]); 
					locs[0] = startTile; //vertical - tiles are above each other 
					locs[1] = startTile + 10; 
					locs[2] = startTile + 20;
					locs[3] = startTile + 30;
				}
				for (int jj = 0; jj < 4; jj++) 
					score += values.get(letters[jj])*letMult(locs[jj]); //add score 
				for (int jj = 0; jj < locs.length; jj++) {
					if(checkIn(locs[jj], tw)) //if triple word 
						score *= 3; 
					if(checkIn(locs[jj], dw)) //if double word
						score *= 2; 
				}
				if(score > max_score)
					max_score = score; //new highest score 
				score = 0;
			}
			System.out.println(max_score);
		}
	}
	public static int letMult(int tile){ //letter multiplier (if double or triple letter score) 
		if(checkIn(tile, dls))
			return 2; 
		if(checkIn(tile, tls))
			return 3; 
		return 1; 
	}
	public static boolean checkIn(int num, int[] array){ //checks if a particular value is in an array 
		for (int i = 0; i < array.length; i++) {
			if(array[i] == num) 
				return true; //value is in array 
		}
		return false; 
	}
}
