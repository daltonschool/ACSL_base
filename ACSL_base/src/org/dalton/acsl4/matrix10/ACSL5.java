package org.dalton.acsl4.matrix10;

/**
 * Name: Caroline Cherston
 * School: The Dalton School
 * School Code: 9075
 * Date: April 23rd, 2011
 */

import java.util.ArrayList;
import java.util.Scanner;


public class ACSL5 {

	public static void main(String[] args) {
		int count = 1;
		while(count<6)
		{
		Scanner input = new Scanner(System.in);
		String Input = input.nextLine();
		
		String[] users = Input.split(", "); 
		
		ArrayList<Integer> x = new ArrayList<Integer>(); 
		x = convertToNum(users[1]); 
		
		if(x.size()%2 != 0)
		{
			x.add(27); 
		}
	
		int a = Integer.parseInt(users[2]);
		int b = Integer.parseInt(users[3]);
		int c = Integer.parseInt(users[4]);
		int d = Integer.parseInt(users[5]);
		
	
		if(users[0].equals("E"))
		{
		ArrayList<Integer> storing = new ArrayList<Integer>(); 
		
		for(int z= 0; z<x.size(); z+=2)
		{
			int result = x.get(z)*a+x.get(z+1)*b; 
			int result2 = x.get(z)*c+x.get(z+1)*d;
			storing.add(result);
			storing.add(result2); 
		}
		
		
		
		ArrayList<Character> encodedReturn = new ArrayList<Character>(); 
		
		for(int i =0; i<storing.size(); i++)
		{
			int num = storing.get(i)+64; 
			if(num>=91)
			{
				num = ((num-64)%27)+64; 
			}
			char letter = (char) num; 
			if(num == 64)
			{
				letter = ' '; 
			}
			encodedReturn.add(letter); 
		}
		for(int z =0; z<encodedReturn.size();z++)
		{
			System.out.print(encodedReturn.get(z));
		}
		}
	

		if(users[0].equals("D"))
		{
			ArrayList<Integer> store = new ArrayList<Integer>(); 
			
			for(int z =0; z<x.size(); z+=2)
			{
				int t = a*d-b*c; 
				int result = (d/t)*x.get(z)+ (-1*b/t)*x.get(z+1);
				int result2 = (-1*c/t)*x.get(z) + (a/t)*x.get(z+1); 
				if(result < 0)
				{
					result = result + 270;
				}
				if(result2 < 0)
				{
					result2 = result2 + 270; 
				}
				store.add(result);
				store.add(result2); 
			}
			
			ArrayList<Character> decodedReturn = new ArrayList<Character>(); 
			
			
			for(int i =0; i<store.size(); i++)
			{
				int num = store.get(i)+64; 
				if(num>=91)
				{
					num = ((num-64)%27)+64; 
				}
				char letter = (char) num; 
				if(num == 64)
				{
					letter = ' '; 
				}
				decodedReturn.add(letter); 
			}
			for(int z =0; z<decodedReturn.size();z++)
			{
				System.out.print(decodedReturn.get(z));
			}
		}
		count++; 
		}	
		
	}

	static ArrayList<Integer> convertToNum(String x)
	{
		ArrayList<Integer> returning = new ArrayList<Integer>(); 
		int num = 0;
		for(int i=0; i<x.length(); i++)
		{
			if(x.charAt(i) == ' ')
			{
				num = 27; 
			}
			else
			{
				num = (int)x.charAt(i) -64; 
			}
			returning.add(num); 
		}
		return returning; 
	}
	
}
