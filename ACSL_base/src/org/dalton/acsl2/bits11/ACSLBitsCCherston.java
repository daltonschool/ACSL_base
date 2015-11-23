package org.dalton.acsl2.bits11;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Name: Caroline Cherston
 * School: Dalton
 * School Code: 3055
 */
public class ACSLBitsCCherston {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in); 

		for(int i=0; i<5; i++)
		{
			String input = scan.nextLine(); 
			boolean match = true; 
			int starCount = 0; 
			String[] userInput = input.split(", ");  	
			ArrayList<Character> result = new ArrayList<Character>();

			for(int p=0; p<userInput[1].length(); p++)
			{
				for(int n=1; n<userInput.length-1; n++)
				{
					if(userInput[1].charAt(p) != userInput[n+1].charAt(p))
						match = false; 
				}
				if(match == true)
					result.add(userInput[1].charAt(p));
				else
				{
					result.add('*');
					starCount++;
				}
				match = true; 
			}

			if(Math.pow(2,starCount) == Integer.parseInt(userInput[0]))
			{	
				for(int j=0; j < result.size(); j++)
				{
					System.out.print(result.get(j));
				}
			}
			else
				System.out.println("NONE");
		}
	}
}
