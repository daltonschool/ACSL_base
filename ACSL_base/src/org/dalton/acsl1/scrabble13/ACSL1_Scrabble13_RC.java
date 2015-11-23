package org.dalton.acsl1.scrabble13;
import java.util.Scanner;

public class ACSL1_Scrabble13_RC {

	/*Author: Richard Chen
	 *School: The Dalton School (Code = 3055)
	 */
	static int multiplier = 1;

	public static int [] conversion (String [] input) //WORKS
	{
		int [] letterValues = new int[4]; //[] [] [] []

		for (int i = 0; i < input.length; i++)
		{
			if (input[i].equals("A")||input[i].equals("E")) letterValues[i] = 1; //A or E -> 1
			else if (input[i].equals("D")||input[i].equals("R")) letterValues[i] = 2; //D or R -> 2
			else if (input[i].equals("B")||input[i].equals("M")) letterValues[i] = 3; //B or M -> 3
			else if (input[i].equals("V")||input[i].equals("Y")) letterValues[i] = 4; //V or Y -> 4
			else letterValues[i] = 8; //J or X -> 8
		}
		return letterValues;
	}

	public static int [] mod (String start) //21H -> 0 WORKS
	{
		int [] position = new int[4]; //[] [] [] [] -> [1] [2] [3] [4]
		int [] positionValues = new int [4]; //[1] [2] [3] [4] -> [1] [1] [2] [1]
		int x = Integer.parseInt(start.substring(0, start.length()-1)); //number the word starts on

		if (start.substring(start.length()-1, start.length()).equals("H")) //horizontal
		{
			position[0] = x;
			position[1] = x+1;
			position[2] = x+2;
			position[3] = x+3;
		}
		else //vertical
		{
			position[0] = x;
			position[1] = x+10;
			position[2] = x+20;
			position[3] = x+30;
		}

		for (int i = 0; i < position.length; i++)
		{
			if (position[i] % 3 == 0 && position[i] % 2 != 0) positionValues[i] = 2;
			else if (position[i] % 5 == 0) positionValues[i] = 3;
			else if (position[i] % 7 == 0) 
			{
				multiplier = multiplier * 2; 
				positionValues[i] = 1;
			}
			else if (position[i] % 8 == 0) 
			{
				multiplier = multiplier * 3;
				positionValues[i] = 1;
			}
			else positionValues[i] = 1;
		}
		return positionValues;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//System.out.println("enter word:");
		int [] ndata = conversion(scan.nextLine().toUpperCase().split("[, ]+")); //-> [8][1][4][1]
		int [] inputFV = new int [4];

		for (int i = 0; i <5; i++) //for each line of test code
		{
		//	System.out.println("enter record:");
			String [] positionLine = scan.nextLine().toUpperCase().split("[, ]+");
			String [] position = new String [3];
			position[0] = positionLine[0] + positionLine[1];
			position[1] = positionLine[2] + positionLine[3];
			position[2] = positionLine[4] + positionLine[5];

			for (int x = 0; x < position.length; x++) //for each position
			{
				int [] modValues = mod(position[x]);
				inputFV[x] = multiplier*(modValues[0]*ndata[0]+modValues[1]*ndata[1]+modValues[2]*ndata[2]+modValues[3]*ndata[3]);
				multiplier = 1;
			}
			if (inputFV[0]>inputFV[1]&&inputFV[0]>inputFV[2]) System.out.println(inputFV[0]);
			else if (inputFV[1]>inputFV[0]&&inputFV[1]>inputFV[2]) System.out.println(inputFV[1]);
			else System.out.println(inputFV[2]);
		}
	}
}