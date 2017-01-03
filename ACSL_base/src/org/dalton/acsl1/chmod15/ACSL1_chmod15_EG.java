package org.dalton.acsl1.chmod15;
//http://codescracker.com/java/program/java-program-convert-octal-to-binary.htm

import java.util.*;
public class ACSL1_chmod15_EG {
	public static void main(String[] args) {
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			String inputString[] = input.split(", ");
			int inputInt[] = new int[4];
			int[][] multi = new int[4][];
			char[][] multi2 = {{'r','w','x'},{'r','w','x'},{'r','w','x'}};
			multi[0] = new int[1];
			multi[1] = new int[3];
			multi[2] = new int[3];
			multi[3] = new int[3];
			for (int i = 0; i < inputString.length; i++) {
				inputInt[i] = Integer.parseInt(inputString[i]);
			}
			multi[0][0] = inputInt[0];
			for (int i = 1; i < multi.length; i++) {
				multi[i] = Oct(inputInt[i]);
			}
			for (int i = 1; i < 4; i++) {
				for (int j = 0; j < multi[i].length; j++) {
					System.out.print(multi[i][j]);

				}
				System.out.print(" ");
			}
			System.out.print("and ");
		//	System.out.println(multi[0][0]);
			if(multi[0][0] == 1)
			{
				multi2[0][2] = 's';
			}
			
			else if(multi[0][0] == 2)
			{
				//System.out.println(multi[1][2]);
				multi2[1][2] = 's';
			}
			else if(multi[0][0] == 4)
			{
				multi2[2][2] = 't';
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(multi[i+1][j]==0)
					{
						multi2[i][j] = '-';
					}
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(multi2[i][j]);

				}
				System.out.print(" ");
			}
			System.out.println();
		}

	}
	static int[] Oct(int x)
	{
		
		int returnr[] = new int[3];

		if(x == 1)
		{
			returnr[0] = 0;
			returnr[1] = 0;
			returnr[2] = 1;
		}
		else if(x == 2)
		{
			returnr[0] = 0;
			returnr[1] = 1;
			returnr[2] = 0;
		}
		else if(x == 3)
		{
			returnr[0] = 0;
			returnr[1] = 1;
			returnr[2] = 1;
		}
		else if(x == 4)
		{
			returnr[0] = 1;
			returnr[1] = 0;
			returnr[2] = 0;
		}
		else if(x == 5)
		{
			returnr[0] = 1;
			returnr[1] = 0;
			returnr[2] = 1;
		}
		else if(x == 6)
		{
			returnr[0] = 1;
			returnr[1] = 1;
			returnr[2] = 0;
		}
		else if(x == 7)
		{
			returnr[0] = 1;
			returnr[1] = 1;
			returnr[2] = 1;
		}
		


		return (returnr);

	}
}
