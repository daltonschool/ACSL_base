package org.dalton.acsl1.prints10;
import java.util.Scanner;
public class ACSL1 {
	/**
	 * Alex Pong 
	 * Dalton
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(int x = 0; x<5; x++)
		{
			String answer = "";
			System.out.println("Input: ");
			String in = input.nextLine();
			String numbers[] = in.split(",");	
			int even = Integer.parseInt(numbers[0].trim())-1;
			int odd = Integer.parseInt(numbers[1].trim())-1;

			while (even >0) //loop until no more possibilities
			{	
				if(even >=16) {
					answer= answer+"2, ";
					even=even-16;
				}
				else if(even >=8) {
					answer= answer+"4, ";
					even=even-8;
				}
				else if(even >=4) {
					answer= answer+"6, ";
					even=even-4;
				}
				else if(even >=2) {
					answer= answer+"8, ";
					even=even-2;
				}
				else if(even >=1) {
					answer= answer+"10, ";
					even=even-1;
				}
			}
			while (odd>0)
			{
				if(odd >=16) {
					answer= answer+"1, ";
					odd=odd-16;
				}

				else if(odd >=8) {
					answer= answer+"3, ";
					odd=odd-8;
				}
				else if(odd >=4) {
					answer= answer+"5, ";
					odd=odd-4;
				}
				else if(odd >=2) {
					answer= answer+"7, ";
					odd=odd-2;
				}
				else if(odd >=1) {
					answer= answer+"9, ";
					odd=odd-1;
				}
			}
			if(answer.equals("")) {
				System.out.println("None.");
			}
			else
				System.out.println(answer.substring(0,answer.length()-2));
		}
		System.out.println("Done.");
	}
}

