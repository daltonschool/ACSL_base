package org.dalton.acsl4.numble13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ACSL4_Numble13_DA {
	/*
	 * Name: Dillon Azzam
	 * School: The Dalton School
	 * Code: 3305
	 * 
	 * 
	 * 
	 * Permutations.java derived from Robert Sedgewick and Kevin Wayne's Princeton site:
	 * http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
	 * Copyright C 2000-2010, Robert Sedgewick and Kevin Wayne. 
	 */
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String charStringsList=scan.nextLine();

		String charStringOne = charStringsList.split(", ")[0];
		String charStringTwo = charStringsList.split(", ")[1];
		String charStringThree = charStringsList.split(", ")[2];

		char[] wordCharArrayOne=charStringOne.toCharArray();
		char[] wordCharArrayTwo=charStringTwo.toCharArray();
		char[] wordCharArrayThree=charStringThree.toCharArray();

		int[] wordIntArrayOne = new int[wordCharArrayOne.length];
		int[] wordIntArrayTwo = new int[wordCharArrayTwo.length];
		int[] wordIntArrayThree = new int[wordCharArrayThree.length];

		for(int i=0; i<wordCharArrayOne.length; i++)
		{
			wordIntArrayOne[i] = Integer.parseInt(String.valueOf(wordCharArrayOne[i]));
		}

		for(int i=0; i<wordCharArrayTwo.length; i++)
		{
			wordIntArrayTwo[i] = Integer.parseInt(String.valueOf(wordCharArrayTwo[i]));
		}

		for(int i=0; i<wordCharArrayThree.length; i++)
		{
			wordIntArrayThree[i] = Integer.parseInt(String.valueOf(wordCharArrayThree[i]));
		}

		Arrays.sort(wordIntArrayOne);
		Arrays.sort(wordIntArrayTwo);
		Arrays.sort(wordIntArrayThree);

		for(int i = 0; i < wordIntArrayOne.length / 2; i++)
		{
			int temp = wordIntArrayOne[i];
			wordIntArrayOne[i] = wordIntArrayOne[wordIntArrayOne.length - i - 1];
			wordIntArrayOne[wordIntArrayOne.length - i - 1] = temp;
		}

		for(int i = 0; i < wordIntArrayTwo.length / 2; i++)
		{
			int temp = wordIntArrayTwo[i];
			wordIntArrayTwo[i] = wordIntArrayTwo[wordIntArrayTwo.length - i - 1];
			wordIntArrayTwo[wordIntArrayTwo.length - i - 1] = temp;
		}

		for(int i = 0; i < wordIntArrayThree.length / 2; i++)
		{
			int temp = wordIntArrayThree[i];
			wordIntArrayThree[i] = wordIntArrayThree[wordIntArrayThree.length - i - 1];
			wordIntArrayThree[wordIntArrayThree.length - i - 1] = temp;
		}

		/*
		System.out.println(Arrays.toString(wordIntArrayOne));
		System.out.println(Arrays.toString(wordIntArrayTwo));
		System.out.println(Arrays.toString(wordIntArrayThree));
		*/

		for(int inputNumber=0; inputNumber<5; inputNumber++)
		{
			String inputCommand=scan.nextLine();
			int wordOneLength = Integer.parseInt(inputCommand.split(", ")[0]);
			int wordTwoLength = Integer.parseInt(inputCommand.split(", ")[1]);
			int wordThreeLength = Integer.parseInt(inputCommand.split(", ")[2]);

			int firstCrossingInt = Integer.parseInt(inputCommand.split(", ")[3]);
			int secondCrossingInt = Integer.parseInt(inputCommand.split(", ")[4]);

			String sortedWordOneString = Arrays.toString(wordIntArrayOne).substring(1,  Arrays.toString(wordIntArrayOne).length()-1).replace(", ", "");
			String sortedWordTwoString = Arrays.toString(wordIntArrayTwo).substring(1,  Arrays.toString(wordIntArrayTwo).length()-1).replace(", ", "");
			String sortedWordThreeString = Arrays.toString(wordIntArrayThree).substring(1,  Arrays.toString(wordIntArrayThree).length()-1).replace(", ", "");
			
			PermutationsDA perms = new PermutationsDA();
			ArrayList<String> wordOnePermutations = perms.perm1(sortedWordOneString);
			ArrayList<String> wordTwoPermutations = perms.perm1(sortedWordTwoString);
			ArrayList<String> wordThreePermutations = perms.perm1(sortedWordThreeString);
			
			String wordOneFinal = getFinalString(wordOnePermutations, wordOneLength);
			wordOneFinal = moveZerosIfNeeded(wordOneFinal);
			
			String wordTwoFinal = getFinalString(wordTwoPermutations, wordTwoLength);
			wordTwoFinal = moveZerosIfNeeded(wordTwoFinal);
			
			String wordThreeFinal = getFinalString(wordThreePermutations, wordThreeLength);
			wordThreeFinal = moveZerosIfNeeded(wordThreeFinal);
			
			/*
			System.out.println(wordOneFinal);
			System.out.println(wordTwoFinal);
			System.out.println(wordThreeFinal);
			*/
			
			int firstCrossingPlaceWordOne = 0;
			for(int i=0; i<wordOneFinal.length(); i++)
			{
				if(Integer.parseInt(String.valueOf(wordOneFinal.charAt(i)))==firstCrossingInt)
				{
					firstCrossingPlaceWordOne = i;
					break;
				}
			}
			int firstCrossingPlaceWordTwo = 0;
			for(int i=0; i<wordTwoFinal.length(); i++)
			{
				if(Integer.parseInt(String.valueOf(wordTwoFinal.charAt(i)))==firstCrossingInt)
				{
					firstCrossingPlaceWordTwo = i;
					break;
				}
			}
			
			int secondCrossingPlaceWordOne = 0;
			for(int i=0; i<wordOneFinal.length(); i++)
			{
				if(Integer.parseInt(String.valueOf(wordOneFinal.charAt(i)))==secondCrossingInt)
				{
					secondCrossingPlaceWordOne = i;
					break;
				}
			}
			int secondCrossingPlaceWordThree = 0;
			for(int i=0; i<wordThreeFinal.length(); i++)
			{
				if(Integer.parseInt(String.valueOf(wordThreeFinal.charAt(i)))==secondCrossingInt)
				{
					secondCrossingPlaceWordThree = i;
					break;
				}
			}
			
			int matrixHeight = 0;
			int matrixWidth = wordOneFinal.length();
			
			matrixHeight = (Math.max(firstCrossingPlaceWordTwo, secondCrossingPlaceWordThree))+(Math.max((wordTwoFinal.length()-firstCrossingPlaceWordTwo), (wordThreeFinal.length()-secondCrossingPlaceWordThree)));
			
			char[][] matrix = new char[matrixHeight][matrixWidth];//Rows, Columns
			
			for(int row=0; row<matrixHeight; row++)
			{
				for(int column = 0; column<matrixWidth; column++)
				{
					matrix[row][column]=' ';
				}
			}
			
			int wordOneRow = Math.max(firstCrossingPlaceWordTwo, secondCrossingPlaceWordThree);
			for(int column = 0; column<matrixWidth; column++)
			{
				matrix[wordOneRow][column] = wordOneFinal.charAt(column); 
			}
			
			int wordTwoTop = wordOneRow-firstCrossingPlaceWordTwo;
			int wordTwoEnd = (wordTwoTop+wordTwoFinal.length());
			for(int row = wordTwoTop; row<wordTwoEnd; row++)
			{
				matrix[row][firstCrossingPlaceWordOne] = wordTwoFinal.charAt(row-wordTwoTop);
			}
			
			int wordThreeTop = wordOneRow-secondCrossingPlaceWordThree;
			int wordThreeEnd = (wordThreeTop+wordThreeFinal.length());
			for(int row = wordThreeTop; row<wordThreeEnd; row++)
			{
				matrix[row][secondCrossingPlaceWordOne] = wordThreeFinal.charAt(row-wordThreeTop);
			}
			
			print(matrix);
		}
	}
	
	public static String moveZerosIfNeeded(String finalWord)
	{
		if((finalWord.charAt(finalWord.length()-2) =='0')&&(finalWord.charAt(finalWord.length()-1) =='0'))
		{
			finalWord =  "0"+finalWord.substring(0, (finalWord.length()-1));
		}
		
		return finalWord;
	}
	
	public static String getFinalString(ArrayList<String> permutations, int wordLength)
	{
		for(String element:permutations)
		{
			String trimmedElement = element.substring(0, wordLength);
			if(isMultOfFive(trimmedElement.toCharArray()))
			{//Check if has more than 2 0's???
				return trimmedElement;
			}
		}
		return null;
	}

	public static boolean isMultOfFive(char[] numbers)
	{
		int sum = 0;
		for(char num:numbers)
		{
			sum+=Integer.parseInt(String.valueOf(num));
		}

		if(sum%5==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void print(char[][] matrix)
	{
		for(int row=0; row<matrix.length; row++)
		{
			for(int column=0; column<matrix[row].length; column++)//Go through each place
			{
				System.out.print(matrix[row][column]);//Print place
			}
			System.out.print("\n");//Print out new line
		}
		System.out.println();
	}

}

class PermutationsDA {

	ArrayList<String> possibilities = new ArrayList<String>();
	// print N! permutation of the characters of the string s (in order)
	public ArrayList<String> perm1(String s) { 
		possibilities = new ArrayList<String>();
		perm1("", s); 
		return possibilities;
	}
	private void perm1(String prefix, String s) {
		int N = s.length();
		if (N == 0) possibilities.add(prefix);
		else {
			for (int i = 0; i < N; i++)
				perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
		}
	}
	// swap the characters at indices i and j
	private static void swap(char[] a, int i, int j) {
		char c;
		c = a[i]; a[i] = a[j]; a[j] = c;
	}
}
