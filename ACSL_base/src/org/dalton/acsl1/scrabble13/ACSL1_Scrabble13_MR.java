package org.dalton.acsl1.scrabble13;

import java.util.Arrays;
import java.util.Scanner;

public class ACSL1_Scrabble13_MR {
	/** Morris Reeves
	 *  The Dalton School
	 *  School Code: 3305
	 *  ACSL Contest 1: Scrabble
	 */

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int v1 = 0; int v2 = 0; int v3 = 0; int v4 = 0;	//letter values
		int va = 0; int vb = 0; int vc = 0; int vd = 0;
		int multiplier = 1;
		int[] total = new int[3];
		String[] loc = new String[6]; //holds: loc[0, 2, 4] start locations, loc[1, 3, 5] direction


		for(int i=0; i<6; i++) //READ IN LINES
		{
			String input = scan.nextLine();
			input = input.toLowerCase();
			//System.out.println(input);
			if(i==0) //FIRST LINE
			{
				v1 = getVal(input.charAt(0));
				v2 = getVal(input.charAt(3));
				v3 = getVal(input.charAt(6));
				v4 = getVal(input.charAt(9));
				//System.out.println(va + " " + vb + " " + vc + " " + vd);
			}
			else //OTHER LINES
			{
				loc = input.split(", ");
				//System.out.println(loc[0] + " " + loc[1] + " " + loc[2] + " " + loc[3] + " " + loc[4] + " " + loc[5]);
				for(int x=0; x<6; x+=2)
				{
					//System.out.println("value of x is " + x);
					if(loc[x+1].equals("h"))
					{
						va = boardVal(v1, Integer.parseInt(loc[x]));
						vb = boardVal(v2, Integer.parseInt(loc[x]) + 1);
						//System.out.println("vc: " + v3);
						vc = boardVal(v3, Integer.parseInt(loc[x]) + 2);
						vd = boardVal(v4, Integer.parseInt(loc[x]) + 3);
						multiplier = coefficient(Integer.parseInt(loc[x])) * coefficient(Integer.parseInt(loc[x]) + 1) * coefficient(Integer.parseInt(loc[x]) + 2) * coefficient(Integer.parseInt(loc[x]) + 3);
						//System.out.println("Multiplier: " + multiplier + " Va, vb, vc, vd: " + va + " "+ vb + " " + vc + " "+vd);
						total[x - (x/2)] = multiplier * (va + vb + vc + vd);
					}
					else if(loc[x+1].equals("v"))
					{
						va = boardVal(v1, Integer.parseInt(loc[x]));
						vb = boardVal(v2, Integer.parseInt(loc[x]) + 10);
						vc = boardVal(v3, Integer.parseInt(loc[x]) + 20);
						vd = boardVal(v4, Integer.parseInt(loc[x]) + 30);
						multiplier = coefficient(Integer.parseInt(loc[x])) * coefficient(Integer.parseInt(loc[x]) + 10) * coefficient(Integer.parseInt(loc[x]) + 20) * coefficient(Integer.parseInt(loc[x]) + 30);
						total[x - (x/2)] = multiplier * (va + vb + vc + vd);
					}
				}
				//System.out.println(total[0] + " " + total[1] + " " + total[2]);
				Arrays.sort(total);
				System.out.println(total[2]);	
			}
		}
	}

	static int getVal (char letter) //Get letter values
	{
		int val = 0;
		if(letter == 'a'||letter == 'e') val = 1;
		if(letter == 'd'||letter == 'r') val = 2;
		if(letter == 'b'||letter == 'm') val = 3;
		if(letter == 'v'||letter == 'y') val = 4;
		if(letter == 'j'||letter == 'x') val = 8;
		return val;
	}

	static int boardVal (int value, int square) //Get value of letter when placed on board
	{
		int boardval = value;
		if(square == 3||square == 9||square == 15||square == 21||square == 27||square == 33||square == 39) boardval = 2*value;
		if(square == 5||square == 10||square == 20||square == 25||square == 30||square == 35||square == 40) boardval = 3*value;
		return boardval;
	}

	static int coefficient (int square) //return 'coefficient' (x2 word, x3 word, x6)
	{
		int coeff = 1;
		if(square == 7||square == 14||square == 28) coeff = 2;
		if(square == 8||square == 16||square == 24||square == 32) coeff = 3;
		return coeff;
	}
}
