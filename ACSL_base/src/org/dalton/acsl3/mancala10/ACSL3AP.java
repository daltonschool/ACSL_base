package org.dalton.acsl3.mancala10;
import java.util.Scanner;

/**
 * @author Alex Pong
 * Dalton
 * 9075
 */

public class ACSL3AP {

	public static int pointer;
	public static int[] board = new int[14];
	public static void DropStones(boolean player)
	{
		int counter = board[pointer];
		board[pointer]=0;
		for (int x = counter; x>0;x--){	
			if (player ==true){
				if(pointer+1 == 13){
					pointer =0;
				}
				else{
					pointer++;
				}
			}
			else if (player ==false){
				if(pointer+1 == 6){
					pointer +=2;
				}
				else if (pointer == 13){
					pointer = 0;
				}
				else
				{
					pointer++;
				}
			}
			board[pointer] ++;
			counter--;
		}
	}
	public static int convertInput(String index)
	{
		if (index.equals("A"))
		{
			return 6;
		}
		else if (index.equals("B") )
		{
			return 13;
		}
		int indexInt = 0;
		try{
			indexInt = Integer.parseInt(index);
		}
		catch (Exception e){
		}
		if (indexInt < 6)
		{
			return indexInt-1;
		}
		else if (indexInt>=6 )
		{
			return indexInt;
		}
		else
		{
			return -1;
		}
	}
	public static void main(String[] args) 
	{
		boolean player = true;
		boolean escape=false;
		int turn = 1;
		Scanner input = new Scanner(System.in);
		for (int x = 0;x<6;x++){
			board[x]=4;
		}
		for (int x=7;x<13;x++){
			board[x]=4;
		}
		for(int x = 0;x<5;x++)
		{
			if(turn % 2 == 1)
			{
				player = true;
			}
			else
			{ 
				player = false;
			}
			String in = input.nextLine(); //take the input
			String[] data = in.split(", ");//split on the comma-space!
			pointer = convertInput(data[0]);
			while (!escape)
			{
				DropStones(player);
				if(board[pointer]==4 )
				{
					escape = true;
					//System.out.println("escaped due to: amount of stones(4) in: " + pointer);
				}
				else if(board[pointer]==1 )
				{
					escape = true;
					//System.out.println("escaped due to: amount of stones(1)in: " + pointer);
				}
				else if(pointer ==6 &&player)
				{
					escape = true;
					//System.out.println("escaped due to: landing in home mancala (A)");
				}
				else if(pointer ==13 &&!player){
					escape = true;
					//System.out.println("escaped due to: landing in home mancala (B)");
				}
			}
			System.out.println(board[convertInput(data[1])]);
			escape = false;
			turn ++;
		}
	}
}
