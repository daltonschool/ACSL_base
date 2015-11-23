package org.dalton.acsl3.grid11;

import java.util.Scanner;
/**
 * Name: Caroline Cherston
 * School: The Dalton School
 * School Code: 3055
 */

public class ACSLGridCC {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String userInput1 = scan.nextLine();
		String[] blocked = userInput1.split(", ");
		boolean [] boxes = new boolean[35];
		for(int i = 0; i< boxes.length; i++)
		{
			boxes[i] = true;
		}

		for(int x=1; x< blocked.length; x++)
		{
			boxes[Integer.parseInt(blocked[x])-1] = false;  
		}

		for(int z=0; z<5; z++)
		{
			Scanner input = new Scanner(System.in);
			int piece = input.nextInt();

			switch(piece){
			case 1:
				System.out.println(pieceOne(boxes));
				if(pieceOne(boxes) != "NONE")
					boxes[Integer.parseInt(pieceOne(boxes))-1] = false;
				break;
			case 2:
				System.out.println(pieceTwo(boxes));
				if(pieceTwo(boxes) != "NONE")
				{
					int value2 = Integer.parseInt(pieceTwo(boxes));
					boxes[value2 - 1] = false;
					boxes[value2 + 4] = false;
				}
				break;
			case 3:
				System.out.println(pieceThree(boxes));
				if(pieceThree(boxes) != "NONE")
				{
					int value3 = Integer.parseInt(pieceThree(boxes));
					boxes[value3] = false;
					boxes[value3 - 1] = false;
				}
				break;
			case 4:
				System.out.println(pieceFour(boxes));
				if(pieceFour(boxes) != "NONE")
				{
					int value4 = Integer.parseInt(pieceFour(boxes));
					boxes[value4 - 1] = false;
					boxes[value4 + 4] = false;
					boxes[value4 + 5] = false;
				}
				break;
			case 5:
				System.out.println(pieceFive(boxes));
				if(pieceFour(boxes) != "NONE")
				{
					int value5 = Integer.parseInt(pieceFive(boxes));
					boxes[value5 - 1] = false;
					boxes[value5] = false;
					boxes[value5 + 4] = false;
				}
				break;
			}
		}
	}
	public static String pieceOne(boolean [] boxes)
	{
		for(int x=0; x<boxes.length; x++)
		{
			if(boxes[x] == true)
			{
				if(searchColumn(x,boxes) == true)
					return Integer.toString(x+1);
			}
		}
		return "NONE";

	}
	public static String pieceTwo(boolean [] boxes)
	{
		for(int x=0; x< 30; x++)
		{

			if(boxes[x] == true && boxes[x+5] == true)
			{
				if(searchColumn(x, boxes) == true)
					return Integer.toString(x+1);
			}
		}
		return "NONE";
	}
	public static String pieceThree(boolean [] boxes)
	{
		for(int x=0; x<boxes.length; x++)
		{
			if((x+1)%5 == 0)
			{
			}
			else if(boxes[x] == true && boxes[x+1] == true)
			{
				if(searchColumn(x, boxes) == true && searchColumn(x+1, boxes) == true)
					return Integer.toString(x+1);
			}
		}
		return "NONE";
	}
	public static String pieceFour(boolean [] boxes)
	{
		for(int x=0; x<30; x++)
		{
			if((x+1)%5 == 0)
			{
			}

			else if(boxes[x] == true && boxes[x+5] == true && boxes[x+6] == true)
			{
				if(searchColumn(x, boxes) == true && searchColumn(x+6, boxes) == true)
					return Integer.toString(x+1);
			}
		}
		return "NONE";
	}
	public static String pieceFive(boolean [] boxes)
	{
		for(int x=0; x<30; x++)
		{
			if((x+1)%5 == 0){}
			else if(boxes[x] == true && boxes[x+5] == true && boxes[x+1] == true)
			{
				if(searchColumn(x, boxes) == true && searchColumn(x+1, boxes) == true)
					return Integer.toString(x+1);
			}
		}
		return "NONE";
	}
	public static boolean searchColumn(int x, boolean[] boxes)
	{
		while(x<35)
		{
			if(boxes[x] == false)
			{
				return false;
			}
			x += 5;
		}
		return true;
	}
}