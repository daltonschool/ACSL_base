package org.dalton.acsl1.scrabble13;

import java.util.Scanner;

/**
 * Ethan Zhou
 * Dalton School
 * 3055
 */

public class ACSL1_Scrabble13_EZ {

	public static void main(String[] args) {
		//Declarations
		Scanner scan = new Scanner(System.in);
		char[] word = new char[4];
		String locs[] = new String[6];
		int hiscore = 0;
		
		//Take in initial word
		word = scan.nextLine().replaceAll(", ","").toCharArray();

		for (int i = 0; i < 5; i++) {
			//Take in location set
			locs = scan.nextLine().split(", ");

			//Calculate score values of each set
			//Save highest score
			
			hiscore = calcScore(word, Integer.parseInt(locs[0]), locs[1]);
			if (calcScore(word, Integer.parseInt(locs[2]), locs[3]) > hiscore)
				hiscore = calcScore(word, Integer.parseInt(locs[2]), locs[3]);
			if (calcScore(word, Integer.parseInt(locs[4]), locs[5]) > hiscore)
				hiscore = calcScore(word, Integer.parseInt(locs[4]), locs[5]);

			System.out.println(hiscore);
		}
	}

	/**
	 * Calculates the score of the word, given a starting square and orientation
	 * Returns the score
	 */
	static int calcScore (char[] word, int start, String orient) {
		int total = 0;
		boolean dubword = false;
		boolean tripword = false;

		//Hard coded bonus tiles
		int[] dl = {3,9,15,21,27,33,39};
		int[] tl = {5,10,20,25,30,35,40};
		int[] DW = {7,14,28};
		int[] TW = {8,16,24,32};

		if (orient.equals("H")) {
			for (int i = 0; i < 4; i++) {
				if (isMember(start+i, dl)) total = total + valueOf(word[i])*2;
				else if (isMember(start+i, tl)) total = total + valueOf(word[i])*3;
				else if (isMember(start+i, DW)) {
					total = total + valueOf(word[i]);
					dubword=true;
				}
				else if (isMember(start+i, TW)) {
					total = total + valueOf(word[i]);
					tripword=true;
				}
				else total = total + valueOf(word[i]);
			}
		}

		else if (orient.equals("V")) {
			for (int i = 0; i < 4; i++) {
				if (isMember(start+(i*10), dl)) total = total + valueOf(word[i])*2;
				else if (isMember(start+(i*10), tl)) total = total + valueOf(word[i])*3;
				else if (isMember(start+(i*10), DW)) {
					total = total + valueOf(word[i]);
					dubword=true;
				}
				else if (isMember(start+(i*10), TW)) {
					total = total + valueOf(word[i]);
					tripword=true;
				}
				else total = total + valueOf(word[i]);
			}
		}

		if (dubword) total = total * 2;
		if (tripword) total = total * 3;

		return total;
	}

	/**
	 * Returns the plain score value of the letter
	 */
	static int valueOf (char input) {
		switch (input) {
		case 'A':
		case 'E': return 1;
		case 'D':
		case 'R': return 2;
		case 'B':
		case 'M': return 3;
		case 'V':
		case 'Y': return 4;
		case 'J':
		case 'X': return 8;
		default: return -99999;
		}
	}

	/**
	 * Sees if tile is a bonus tile
	 */
	static boolean isMember(int tile, int[] bonusset) {
		for (int i = 0; i < bonusset.length; i++)
			if (tile == bonusset[i]) return true;
		return false;
	}
}