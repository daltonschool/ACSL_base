package org.dalton.acsl1.prints10;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math.*;


/**
 * Name: Caroline Cherston
 * School: The Dalton School
 * School Code: 9075
 *
 */
public class WhorlACSL {
	public static void main(String[] args) {
		ArrayList<Integer> fingers = new ArrayList<Integer>(); 
		for(int counter = 1; counter < 6; counter++)
		{
			Scanner scanner = new Scanner(System.in); 
			int [] UserInput = new int[2]; 
			String input = scanner.nextLine(); 
			Scanner s = new Scanner(input).useDelimiter(", "); 
			UserInput[0] = s.nextInt()-1;
			UserInput[1]= s.nextInt()-1; 
			
			if(UserInput[0] == 0 && UserInput[1] == 0)
			{
				System.out.println("None"); 
			}
			
			for(int y=0; y<2; y++)
			{
				for(int x=4; x>-1; x = x - 1)
				{
					if(UserInput[y] >= Math.pow(2, x))
					{
						UserInput[y] = UserInput[y] - (int)Math.pow(2,x); 
						fingers.add((5-x)*2-y);
					}
					else{}
				}
			}
			
			print(fingers);
			fingers.clear();
		}
	}
	
	static void print(ArrayList<Integer> fingers)
	{
		for(int z=0; z < fingers.size(); z++)
		{					
			if(z == fingers.size()-1)
			{
				System.out.print(fingers.get(z) + "\n"); 
			}
			else if(z != fingers.size())
			{
				System.out.print(fingers.get(z) + ", ");
			}
		}
	}
}
