package org.dalton.acsl1.scrabble13;
import java.util.Scanner;


/**
 * 
 * @author Adam J. Stern
 * The Dalton School
 * #3305
 *
 */

public class ACSL1_Scrabble13_AS {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(", ");
		int[] wordValue = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			if (input[i].contains("A") || input[i].contains("E")){
				wordValue[i] = 1;
			}
			else if (input[i].contains("D") || input[i].contains("R")){
				wordValue[i] = 2;
			}
			else if (input[i].contains("B") || input[i].contains("M")){
				wordValue[i] = 3;
			}
			else if (input[i].contains("V") || input[i].contains("Y")){
				wordValue[i] = 4;
			}
			else if (input[i].contains("J") || input[i].contains("X")){
				wordValue[i] = 8;
			}
		}
		String[] board = new String[40];
		for (int i = 0; i < board.length; i++) {
			board[i] = "1"; //1 = No Modifier
		}
		for (int i = 2; i < board.length; i = i+6) {
			board[i] = "2"; //2 = Double Letter
		}
		for (int i = 4; i < board.length; i = i+5) {
			while (board[i] == "1"){
				board[i] = "3"; //3 = Triple Letter
			}
		}
		for (int i = 6; i < board.length; i = i+7) {
			while (board[i] == "1"){
				board[i] = "4"; //4 = Double Word
			}
		}
		for (int i = 7; i < board.length; i = i+8) {
			while (board[i] == "1"){
				board[i] = "6"; //6 = Triple Word
			}
		}

		while(1>0) {
			String[] position = scan.nextLine().split(", "); //Takes the coordinates
			int bestScore = 0;
			for (int j = 0; j < position.length; j++) {
				int place = Integer.parseInt(position[j].toString());//Initial position
				j++; // Because lazy
				int holder = j;
				int counter = 0; //For wordValue
				int multiplyer = 1;
				int score = 0;
				if (position[holder].contains("H")){
					for (int i = place-1; i < place+3; i++) {
						if (Integer.parseInt(board[i].toString()) < 4){
							score = score + (Integer.valueOf(wordValue[counter]) * Integer.parseInt(board[i].toString()));
							counter++;
						}
						else if (board[i] == "4"){
							multiplyer = multiplyer * 2;
							score = score + Integer.valueOf(wordValue[counter]);
							counter++;
						}
						else {
							multiplyer = multiplyer * 3;
							score = score + Integer.valueOf(wordValue[counter]);
							counter++;
						}
					}
					score = score*multiplyer;
					if (score > bestScore){
						bestScore = score;
					}
				}
				else {
					for (int i = place-1; i < place+30; i = i+10) {
						if (Integer.parseInt(board[i].toString()) < 4){
							score = score + (Integer.valueOf(wordValue[counter]) * Integer.parseInt(board[i].toString()));
							counter++;
						}
						else if (board[i] == "4"){
							multiplyer = multiplyer * 2;
							score = score + Integer.valueOf(wordValue[counter]);
							counter++;
						}
						else {
							multiplyer = multiplyer * 3;
							score = score + Integer.valueOf(wordValue[counter]);
							counter++;
						}
					}
					score = score*multiplyer;
					if (score > bestScore){
						bestScore = score;
					}
				}
			}
			System.out.println(bestScore);
		}
	}
}
