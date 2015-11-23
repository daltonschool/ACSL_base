package org.dalton.acsl1.scrabble13;
import java.util.ArrayList;
import java.util.Scanner;
public class ACSL1_Scrabble13_MC {
	/**@Author Matt Cohen
	 * The Dalton School
	 * 3055
	 */
	public static int getPoints(String letter){
		int value = 0;
		if (letter.equals("A") || letter.equals("E")) value = 1;
		else if (letter.equals("D") || letter.equals("R")) value = 2;
		else if (letter.equals("B") || letter.equals("M")) value = 3;
		else if (letter.equals("V") || letter.equals("Y")) value = 4;
		else if (letter.equals("J") || letter.equals("X")) value = 8;
		return value;}
	public static String[][] placeWord (String [] word, String[][] board, String a, String b){
		String [][] boardx = new String [40][3];
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 3; j++) {
				boardx[i][j] = board[i][j];}	}
		int wordLetter = 0;
		if (b.equals("H")){
			for (int i = 0; i < boardx.length; i++) {
				if (i+1 == Integer.parseInt(a)){
					boardx[i][2] = word[wordLetter];
					wordLetter++;
					if (wordLetter == word.length) i = boardx.length;}
				else if (i+1 > Integer.parseInt(a)){
					boardx[i][2] = word[wordLetter];
					wordLetter++;
					if (wordLetter == word.length) i = boardx.length;	}	}	}	
		if (b.equals("V")){
			for (int i = 0; i < boardx.length; i++) {
				if (i+1 == Integer.parseInt(a)){

					boardx[i][2] = word[wordLetter];
					wordLetter++;
					if (wordLetter == word.length) i = boardx.length;
				}
				else if ((i+1)%10 == Integer.parseInt(a)){
					boardx[i][2] = word[wordLetter];
					wordLetter++;
					if (wordLetter == word.length) i = boardx.length;		}		}		}	
		return boardx;}
	public static int calcBoard (String[][] boardx){
		int value = 0;
		boolean doubleD = false;
		boolean tripleT = false;
		for (int i = 0; i < boardx.length; i++) {
			if (boardx[i][2].equals("0"));
			else{
				if (Integer.parseInt(boardx[i][1]) == 0){
					value = value + getPoints(boardx[i][2]);	}
				if (Integer.parseInt(boardx[i][1]) == 2){
					value = value + getPoints(boardx[i][2])*2;	}
				if (Integer.parseInt(boardx[i][1]) == 3){
					value = value + getPoints(boardx[i][2])*3;	}
				if (Integer.parseInt(boardx[i][1]) == 20){
					value = value + getPoints(boardx[i][2]);
					doubleD =true;}
				if (Integer.parseInt(boardx[i][1]) == 30){
					value = value + getPoints(boardx[i][2]);
					tripleT = true;		}	}	}
		if (doubleD) value = value*2;
		if (tripleT) value = value*3;
		return value;}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine().trim();
		String [] letters = input.split(", ");
		int greatest = 0;
		while(true){
			String [][] board= new String [40][3];
			for (int i = 0; i < board.length; i++) {
				board[i][0] = String.valueOf(i+1);
				if((i+1)%3 == 0 && (i+1)%2!=0) board[i][1] = String.valueOf(2);
				else if((i+1)%5 == 0) board[i][1] = String.valueOf(3);
				else if((i+1)%7 == 0) board[i][1] = String.valueOf(20);
				else if((i+1)%8 == 0) board[i][1] = String.valueOf(30);
				else board[i][1] = String.valueOf(0);
				board[i][2] = String.valueOf(0);}	
			input = scan.nextLine().trim();
			String [] coord = input.split(", "); 
			String[][] board1 = placeWord(letters, board, coord[0], coord[1]);
			String[][] board2 = placeWord(letters, board, coord[2], coord[3]);
			String[][] board3 = placeWord(letters, board, coord[4], coord[5]);
			greatest = calcBoard(board1);
			if (calcBoard(board2)>calcBoard(board1)) greatest = calcBoard(board2);
			if (calcBoard(board3)>calcBoard(board1)&&calcBoard(board3)>calcBoard(board2)) greatest = calcBoard(board3);
			System.out.println(greatest);	}	}	}
