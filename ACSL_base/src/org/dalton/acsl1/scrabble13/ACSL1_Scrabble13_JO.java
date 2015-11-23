/*
 * Author: Jan Tuzlic Offermann
 * The Dalton School
 * 3055
 */
package org.dalton.acsl1.scrabble13;
import java.util.Scanner;
import java.lang.Math;
public class ACSL1_Scrabble13_JO {


	public static void main(String[] args)
	{
		String[] inputs = new String[6];
		Scanner scan = new Scanner(System.in);

 // first line, result is array of letters (like char array but String)
		//big loop where everything happens: go through each line and print output at last line of loop
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = scan.nextLine();
			String[] word = inputs[0].split(", ");
			if (i > 0)
			{
				String[] input_single = inputs[i].split(", ");
				int answer = 0;
				int score1 = 0; //scores: will be filled below
				int score2 = 0;
				int score3 = 0;

				//go through each option
				for (int j = 0; j < 3; j++) {
					String[] selection = new String[2]; //create selection, a pair of start position and direction
					selection[0] = input_single[2*j];
					selection[1] = input_single[2*j+1];

					//create array of positions
					int[] positions = new int[4];
					char[] selection0_char = selection[0].toCharArray();
					if (selection0_char.length == 1) positions[0] = Character.getNumericValue(selection0_char[0]);
					else
					{
						for (int k = 0; k < selection0_char.length; k++) {
							positions[0] += (Character.getNumericValue(selection0_char[k])*Math.pow(10, (selection0_char.length - k - 1)));
						}
					}
					if (selection[1].equals("H")) 
					{
						for (int k = 1; k < positions.length; k++) {
							positions[k]= positions[k-1]+1;
						}

					}
					else if (selection[1].equals("V"))
					{
						for (int k = 1; k < positions.length; k++) {
							positions[k] = positions[k-1]+10;
						}
					}

					//determine score for each position
					if (j == 0) score1 = Score(word, positions);
					else if (j == 1) score2 = Score(word, positions);
					else if (j == 2) score3 = Score(word, positions);
				}

			
				answer = Math.max(score1, Math.max(score2, score3));
				System.out.println(answer);
			}
		}
	}

	public static int Score(String[] word, int[] positions)
	{
		int answer = 0;
		int score_tmp = 0;
		boolean double_word = false;
		boolean triple_word = false;

		for (int i = 0; i < positions.length; i++) {
			score_tmp = 0;
			if (word[i].equals("A") || word[i].equals("E")) score_tmp = 1;
			else if (word[i].equals("D") || word[i].equals("R")) score_tmp = 2;
			else if (word[i].equals("B") || word[i].equals("M")) score_tmp = 3;
			else if (word[i].equals("V") || word[i].equals("Y")) score_tmp = 4;
			else if (word[i].equals("J") || word[i].equals("X")) score_tmp = 8;

			if (positions[i]%3 == 0 && positions[i]%2 != 0) score_tmp *= 2;
			else if (positions[i]%5 == 0) score_tmp *= 3;
			else if (positions[i]%7 == 0) double_word = true;

			//				if (positions[i]%3 != 0) double_word = true;
			//				else if (positions[i]%3 ==0 || positions[i]%2 == 0) double_word = true;

			else if (positions[i]%8 == 0) triple_word = true; //above precautions unnecessary because of nature of elseif, should read up!
			answer = answer + score_tmp;

			//System.out.println("Position " + positions[i] + ", Letter " + word[i] + ", score_tmp " + score_tmp);
		}
		//System.out.println("Double word " + double_word + ", Triple word " + triple_word);
		if (double_word == true) answer *= 2;
		if (triple_word == true) answer *= 3;
		//System.out.println("Answer = " + answer);

		return answer;
	}
}
