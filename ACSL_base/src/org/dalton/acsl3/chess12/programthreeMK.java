package org.dalton.acsl3.chess12;

import java.awt.Point;
import java.util.HashSet;
import java.util.Scanner;

//Maya Klabin

public class programthreeMK {

	final static int squaresize = 8;
	public static void main (String[] args)
	{
		int w = 0;
		while(w<5)
		{
			Scanner input = new Scanner(System.in);
			String [] raw = input.nextLine().split(", ");
			HashSet<Point> values = new HashSet<Point>();
			for (int i = 0; i < raw.length-2; i+=2) {
				values.add(new Point(Integer.parseInt(raw[i]) -1, Integer.parseInt(raw[i+1])-1));
			}
			printSpot(values);
			w++;
		}
	}
	
	private static void printSpot(HashSet<Point> values)
	{
		for(int x = 0; x < squaresize; x++)
		{
			for(int y = 0; y < squaresize; y++)
			{
				if(gridValues(x,y,values))
				{
					System.out.println((x+1)+", "+(y+1));
					return;
				}
			}
		}
		System.out.println("NONE");
	}
	private static boolean gridValues (int j, int k, HashSet<Point> values)
	{
		HashSet<Point> values_copy = new HashSet<Point>(values);
		for(int y = k+1; y < squaresize; y++) 
		{
			if(values_copy.contains(new Point(j,y)))
			{
				values_copy.remove(new Point(j,y));
			}
		}
		for(int y = k-1; y >= 0; y--) 
		{
			if(values_copy.contains(new Point(j,y)))
			{
				values_copy.remove(new Point(j,y));
			}
		}
		for(int x = j+1; x < squaresize; x++) 
		{
			if(values_copy.contains(new Point(x,k)))
			{
				values_copy.remove(new Point(x,k));
			}
		}
		for(int x = j-1; x >= 0; x--) 
		{
			if(values_copy.contains(new Point(x,k)))
			{
				values_copy.remove(new Point(x,k));
			}
		}
		int offset;
		for(offset = -1; j + offset >= 0 && k + offset >= 0; offset--) 
		{
			if(values_copy.contains(new Point(j+offset,k+offset)))
			{
				values_copy.remove(new Point(j+offset,k+offset));
			}
		}
		for(offset = 1; j + offset < squaresize && k + offset < squaresize; offset++) 
		{
			if(values_copy.contains(new Point(j+offset,k+offset)))
			{
				values_copy.remove(new Point(j+offset,k+offset));
			}		
		}
		for(offset = -1; j + offset >= 0 && k - offset < squaresize; offset--) 
		{
			if(values_copy.contains(new Point(j+offset,k-offset)))
			{
				values_copy.remove(new Point(j+offset,k-offset));
			}		
		}
		for(offset = 1; j + offset < squaresize && k - offset >= 0; offset++) 
		{
			if(values_copy.contains(new Point(j+offset,k-offset)))
			{
				values_copy.remove(new Point(j+offset,k-offset));
			}		
		}
		return values_copy.size() == 0;
	}
}

