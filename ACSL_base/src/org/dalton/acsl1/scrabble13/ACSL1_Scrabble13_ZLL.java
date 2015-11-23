package org.dalton.acsl1.scrabble13;
import java.util.*;
/**
 * Zachary Lehman-Ludwig
 * The Dalton School
 * #3305
 * ACSL Contest #1
 */
public class ACSL1_Scrabble13_ZLL {
	public static String[] board = {"n", "n", "DL", "n", "TL", "n", "DW", "TW", "DL", "TL", "n", "n", "n", "DW", "DL", "TW", "n", "n", "n", "TL",
		//1     2    3     4    5     6     7     8    9     10    11   12   13   14    15    16    17   18   19   20
		"DL", "n", "n", "TW", "TL", "n", "DL", "DW", "n", "TL", "n", "TW", "DL", "n", "TL", "n", "n", "n", "DL", "TL"};
	//21    22   23   24    25    26   27    28    29   30    31    32   33    34    35   36   37   38   39     40

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] InitialPoints = {0};
		int timesRan = 0;

		while (true) {
			String[] input = scan.nextLine().split(", "); //take and split data on commas

			if (timesRan == 0) { //if it's the first runthrough
				InitialPoints = assignInitialPoints(input);
				//System.out.println("Initial point assignments: " + Arrays.toString(InitialPoints)); TEST PASSED
				timesRan++;
			}

			else if (timesRan>0) { //if not first time running
				int round1 = 0;
				int round2 = 0;
				int round3 = 0;
				int startLoc = Integer.parseInt(input[0]);
				//System.out.println("startLoc: " + startLoc); TEST PASSED

				round1 = ScoreCalc (startLoc, input[1], InitialPoints); //for the first of three positions
				//System.out.println(round1);
				startLoc = Integer.parseInt(input[2]);
				round2 = ScoreCalc (startLoc, input[3], InitialPoints);
				//System.out.println(round2);
				startLoc = Integer.parseInt(input[4]);
				round3 = ScoreCalc (startLoc, input[5], InitialPoints);
				//System.out.println(round3);
				
				if (round1>=round2 && round1>=round3) {
					System.out.println(round1);
				}
				else if (round2>=round1 && round2>=round3) {
					System.out.println(round2);
				}
				else if (round3>=round2 && round3>=round2) {
					System.out.println(round3);
				}
			}
		}
	}

	public static int ScoreCalc(int startLoc, String s, int[] InitialPoints) {
		int wordsApplied = 0;
		if (s.equals("V")) { //if we're going vertically
			int[] numbersInvolved = verticalNumbersGen(startLoc);
			int[] lettersApplied = letterSpecials(numbersInvolved, InitialPoints);
			int sumOfLetters = lettersApplied[0] + lettersApplied[1] + lettersApplied[2] + lettersApplied[3];
			wordsApplied = wordSpecials(sumOfLetters, numbersInvolved);
		}

		else if (s.equals("H")) { //if we're going horizontally
			int[] numbersInvolved = HorizontalNumbersGen(startLoc);
			int[] lettersApplied = letterSpecials(numbersInvolved, InitialPoints);
			int sumOfLetters = lettersApplied[0] + lettersApplied[1] + lettersApplied[2] + lettersApplied[3];
			wordsApplied = wordSpecials(sumOfLetters, numbersInvolved);
		}
		return wordsApplied;
	}

	public static int wordSpecials (int x, int[] numbersInvolved) {
		for (int i = 0; i<4; i++) {
			if (board[numbersInvolved[i]-1].equals("DW")) {
				x *= 2;
			}
			if (board[numbersInvolved[i]-1].equals("TW")) {
				x *= 3;
			}
		}
		return x;
	}

	public static int[] letterSpecials(int[] numbersInvolved, int[] InitialPoints) { //give special letters their extra points
		int[] letterApplied = {0,0,0,0};
		for (int i = 0; i<4; i++) {
			letterApplied[i] = InitialPoints[i];
		}
		for (int i = 0; i<4; i++) { //loop through all positions
			if (board[numbersInvolved[i]-1].equals("DL")) {
				letterApplied[i] *= 2;
			}
			else if (board[numbersInvolved[i]-1].equals("TL")) {
				letterApplied[i] *= 3;
			}
		}
		return letterApplied;
	}

	public static int[] HorizontalNumbersGen(int x) { //returns the numbers of all relevant squares for horizontal boards
		int[] numbers = {x, x+1, x+2, x+3};
		return numbers;
	}

	public static int[] verticalNumbersGen (int x) { //returns the numbers of all relevant squares for vertical boards
		int[] numbers = {x, x+10, x+20, x+30};
		return numbers;
	}

	public static int[] assignInitialPoints(String[] input) {
		String[] ONEpoint = {"A", "E"}; //String arrays to hold the letters corresponding to each value
		String[] TWOpoint = {"D", "R"};
		String[] THREEpoint = {"B", "M"};
		String[] FOURpoint = {"V","Y"};
		String[] EIGHTpoint = {"J","X"};

		int iOnePointValue = 0; //ints to hold point value of the four letters
		int iTwoPointValue = 0;
		int iThreePointValue = 0;
		int iFourPointValue = 0;
		int[] eachLetterValue = {0,0,0,0};

		for (int i = 0; i<input.length; i++) { // assign all the one point letters their value
			if (Arrays.asList(ONEpoint).contains(input[i]) && i == 0) {
				iOnePointValue = 1;
			}
			if (Arrays.asList(ONEpoint).contains(input[i]) && i == 1) {
				iTwoPointValue = 1;
			}
			if (Arrays.asList(ONEpoint).contains(input[i]) && i == 2) {
				iThreePointValue = 1;
			}
			if (Arrays.asList(ONEpoint).contains(input[i]) && i == 3) {
				iFourPointValue = 1;
			}
			if (Arrays.asList(TWOpoint).contains(input[i]) && i == 0) { //assign all the two point letters their value
				iOnePointValue = 2;
			}
			if (Arrays.asList(TWOpoint).contains(input[i]) && i == 1) {
				iTwoPointValue = 2;
			}
			if (Arrays.asList(TWOpoint).contains(input[i]) && i == 2) {
				iThreePointValue = 2;
			}
			if (Arrays.asList(TWOpoint).contains(input[i]) && i == 3) {
				iFourPointValue = 2;
			}
			if (Arrays.asList(THREEpoint).contains(input[i]) && i == 0) { //assign all the three point letters their values
				iOnePointValue = 3;
			}
			if (Arrays.asList(THREEpoint).contains(input[i]) && i == 1) {
				iTwoPointValue = 3;
			}
			if (Arrays.asList(THREEpoint).contains(input[i]) && i == 2) {
				iThreePointValue = 3;
			}
			if (Arrays.asList(THREEpoint).contains(input[i]) && i == 3) {
				iFourPointValue = 3;
			}
			if (Arrays.asList(FOURpoint).contains(input[i]) && i == 0) { //assign all the four point letters their values
				iOnePointValue = 4;
			}
			else if (Arrays.asList(FOURpoint).contains(input[i]) && i == 1) {
				iTwoPointValue = 4;
			}
			else if (Arrays.asList(FOURpoint).contains(input[i]) && i == 2) {
				iThreePointValue = 4;
			}
			else if (Arrays.asList(FOURpoint).contains(input[i]) && i == 3) {
				iFourPointValue = 4;
			}
			if (Arrays.asList(EIGHTpoint).contains(input[i]) && i == 0) { //assign all the eight point letters their values
				iOnePointValue = 8;
			}
			if (Arrays.asList(EIGHTpoint).contains(input[i]) && i == 1) {
				iTwoPointValue = 8;
			}
			if (Arrays.asList(EIGHTpoint).contains(input[i]) && i == 2) {
				iThreePointValue = 8;
			}
			if (Arrays.asList(EIGHTpoint).contains(input[i]) && i == 3) {
				iFourPointValue = 8;
			}			
		}
		eachLetterValue[0] = iOnePointValue;
		eachLetterValue[1] = iTwoPointValue;
		eachLetterValue[2] = iThreePointValue;
		eachLetterValue[3] = iFourPointValue;

		//System.out.println(Arrays.toString(eachLetterValue)); TEST CODE
		return eachLetterValue;
	}
}
