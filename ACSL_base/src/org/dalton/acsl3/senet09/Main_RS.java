package org.dalton.acsl3.senet09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * by Ryan Sit
 */

public class Main_RS {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		while (true)
		{
			String line[] = new String[3];
			line[0] = in.nextLine();
			line[1] = in.nextLine();
			line[2] = in.nextLine();
			
			String raw[] = line[0].split(", ");
			int blackSize = Integer.parseInt(raw[0]);
			int blacks[] = new int[blackSize];
			
			for (int i = 1; i <= blackSize; i++)
			{
				blacks[i-1] = Integer.parseInt(raw[i]);
			}
			raw = line[1].split(", ");
			int whiteSize = Integer.parseInt(raw[0]);
			int whites[] = new int[whiteSize];
			
			for (int i = 1; i <= whiteSize; i++)
			{
				whites[i-1] = Integer.parseInt(raw[i]);
			}
			
			Board b = new Board();
			b.assign(blacks, whites);
			
			int rods[] = new int[10];
			
			raw = line[2].split(", ");
			
			for (int i = 0; i < 10; i++)
			{
				rods[i] = Integer.parseInt(raw[i]);
			}
			
			int color = -1;
			int pos[] = new int[2];
			String result = "";
			
			for (int i = 0; i < 10; i++)
			{
				
				color++;
				color %= 2;
				
				if(color == 0)
				{
					result = "";
					pos[color] = b.move(color, rods[i]);
					//System.out.println("black "+ pos[color]);
				}
				else if (color == 1)
				{
					pos[color] = b.move(color, rods[i]);
					//System.out.println("white "+pos[color]);
					for (int k = 0; k < 2; k++)
					{
						if (k == 1)
						{
							result += ", ";
						}
						
						if (pos[k] == -1)
						{
							result += "DONE";
						}
						else if (pos[k] == -2)
						{
							result += "NO VALID MOVES";
						}
						else
						{
							if (k == 0)
								result += String.valueOf(b.sBlacks.get(pos[k]).pos);
							if (k == 1)
								result += String.valueOf(b.sWhites.get(pos[k]).pos);
						}
					}
					System.out.println(result);
				}
			}
	}
	}

}
class Board {
	
	public ArrayList<Pawn> sWhites = new ArrayList<Pawn>();
	public ArrayList<Pawn> sBlacks = new ArrayList<Pawn>();
	
	public Board()
	{
		//use assign for actual construction
	}
	
	public int search(ArrayList<Pawn> a, int k)
	{
		for (int i = 0; i < a.size(); i++)
		{
			if (a.get(i).pos == (k))
				return i;
		}
		return -1;
	}
	
	public int occupiedBy(int a)//0 = black, 1 = white, -1 empty
	{
		if (sBlacks.contains(new Pawn(a)))
		{
			//System.out.println("black at "+a);
			return 0;
		}
		else if (sWhites.contains(new Pawn(a)))
			return 1;
		return -1;
	}
	
	public void assign(int[] black, int[] white)
	{
		for (int i = 0; i < white.length; i++)
		{
			sWhites.add(new Pawn(white[i]));
		}
		for (int i = 0; i < black.length; i++)
		{
			sBlacks.add(new Pawn(black[i]));
		}
		
	}
	
	public int move(int color, int val)//returns the index of the pawn that was moved.  -1 if done, -2 for no valid moves, -3 if something is FATALLY wrong
	{
		//first thing we do is sort the arrays
		
		ArrayList<Pawn> blacks = (ArrayList<Pawn>) sBlacks.clone();
		ArrayList<Pawn> whites = (ArrayList<Pawn>) sWhites.clone();
		Collections.sort(blacks);
		Collections.sort(whites);
		
		int selector = 0; //selector tells us which pawn, cardinally, we're moving
		
	
		fun: while (color == 0)//black, trust me, we'll always return something
		{
			if (selector >= blacks.size())
			{
				return -2;
			}
			
			Pawn p = blacks.get(selector);
			
			int code = search(sBlacks, p.pos);
			//System.out.println(code);
			int loc = p.pos+val;
			
			if (loc > 26 && p.pos < 26)
			{
				loc = 26;
			}
			
			
			
			if (occupiedBy(loc) == 0 && loc !=30)//same color
			{
				selector++;
				continue fun;
			}
			else if (occupiedBy(loc) == 1 && loc != 30) //swap
			{
				sWhites.set(search(sWhites, loc), new Pawn(p.pos));
				sBlacks.set(code, new Pawn(loc));
			}
			if (loc == 27)
			{
				if (occupiedBy(15) == 0)//can't do swap
				{
					sBlacks.set(code, new Pawn(27));
					return code;
				}
				else if (occupiedBy(15) == 1)
				{
					
					sBlacks.set(code, new Pawn(15));
					sWhites.set(search(sWhites, 15), new Pawn(27));
					return code;
				}
				else
				{
					sBlacks.set(code, new Pawn(15));
					return code;
				}
			}
			else if (loc == 31)
			{
				sBlacks.remove(code);
				return -1;
			}
			else if (loc == 30)
			{
				if (search(whites, 30) != -1 || search(blacks, 30) != -1)
				{
					selector++;
					continue fun;
				}
				else
				{
					sBlacks.set(code, new Pawn(30));
					return code;
				}
			}
			else if (loc > 30)
			{
				selector++;
				continue fun;
			}
			else
			{
				sBlacks.set(code, new Pawn(loc));
				return code;
			}
		}
		
		fun: while(color == 1)
		{
			Pawn p = whites.get(selector);
			
			int code = search(sWhites, p.pos);
			//System.out.println(code);
			int loc = p.pos+val;
			
			if (loc > 26 && p.pos < 26)
			{
				loc = 26;
			}
			
			
			if (selector >= whites.size())
			{
				return -2;
			}
			else if (occupiedBy(loc) == 1 && loc !=30)//same color
			{
				selector++;
				continue fun;
			}
			else if (occupiedBy(loc) == 0 && loc != 30) //swap
			{
				//System.out.println("switching");
				sBlacks.set(search(sBlacks, loc), new Pawn(p.pos));
				sWhites.set(code, new Pawn(loc));
				return code;
			}
			if (loc == 27)
			{
				if (occupiedBy(15) == 1)//can't do swap
				{
					sWhites.set(code, new Pawn(27));
					return code;
				}
				else if (occupiedBy(15) == 0)
				{
					//System.out.println("crazy shit");
					sWhites.set(code, new Pawn(15));
					sBlacks.set(search(sBlacks, 15), new Pawn(27));
					return code;
				}
				else
				{
					sWhites.set(code, new Pawn(15));
					return code;
				}
			}
			else if (loc == 31) //left the board
			{
				sWhites.remove(code);
				return -1;
			}
			else if (loc == 30)
			{
				if (search(whites, 30) != -1 || search(blacks, 30) != -1)
				{
					selector++;
					continue fun;
				}
				else
				{
					sWhites.set(code, new Pawn(30));
					return code;
				}
			}
			else if (loc > 30)
			{
				selector++;
				continue fun;
			}
			else //normal move, no conditions met
			{
				sWhites.set(code, new Pawn(loc));
				return code;
			}
		}
		
		return -3;
	}
	

}
class Pawn implements Comparable {
	
	public int pos;
	
	public Pawn(int newPos)
	{
		pos = newPos;
	}

	@Override
	public int compareTo(Object arg0) {
		Pawn b = (Pawn) arg0;
		
		if (pos < b.pos)
			return 1;
		else if (pos > b.pos)
			return -1;
		else
			return 0;
	}
	
	@Override
	public boolean equals(Object arg0)
	{
		Pawn p = (Pawn) arg0;
		if (p.pos == pos)
			return true;
		return false;
	}
	
	@Override
	  public int hashCode() { return 0; }
}
