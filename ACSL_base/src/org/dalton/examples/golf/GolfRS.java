package org.dalton.examples.golf;
/*
 * ACSL Golf
 * by Ryan Sit
 * 
 * School Name: The Dalton School
 * School Code: 9010
 * 
 */

import java.util.Scanner;

public class GolfRS {
	
	public static void main (String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int data[][] = new int[9][4];
		int holes[] = {3,4,5,4,4,4,5,3,4};
		int totals[] = new int[4];
		
		int par = 0;
		
		for (int i = 0; i < holes.length; i++)
		{
			par += holes[i];
		}
		
		for (int i = 0; i < 9; i++)
		{
			String fun[] = in.nextLine().split(",");
			for (int k = 0; k < 4; k++)
			{
				data[i][k] = Integer.parseInt(fun[k]);
			}
		}
		
		for (int i = 0; i < 9; i++)
		{
			for (int k = 0; k < 4; k++)
			{
				totals[k] += data[i][k];
				//System.out.println("adding "+data[i][k]+" to "+k);
			}
		}
		
		int res = 0;
		//output 1
		
		if (totals[1] == par)
		{
			System.out.println("par");
		}
		else if (totals[1] < par)
		{
			System.out.println(par - totals[1]+" under par");
		}
		else if (totals[1] > par)
		{
			System.out.println(totals[1] - par+" over par");
		}
		
		//output 2
		if (totals[0] == par)
		{
			System.out.println("par");
		}
		else if (totals[0] < par)
		{
			System.out.println(par - totals[0]+" under par");
		}
		else if (totals[0] > par)
		{
			System.out.println(totals[0] - par+" over par");
		}
	
		//output 3
		int lowPlayer = 0;
		int low = 10000;
		for (int i = 0; i < 4; i++)
		{
			if (totals[i] < low)
			{
				low = totals[i];
				lowPlayer = i;
			}
		}
		//System.out.println("low player is "+lowPlayer);
		boolean lowFlag = true;
		res = 0;
		for (int i = 0; i < 9; i++)
		{
			lowFlag = true;
			for (int k = 0; k < 4; k++)
			{
				if (data[i][k] <= data[i][lowPlayer]&&k!=lowPlayer)
				{
					//System.out.println("beat by "+k+" on "+i);
					lowFlag = false;
				}
			}
			if (lowFlag)
				res++;
		}
		System.out.println(res);
		
		//output 4
		String arranged[] = {"A","B","C","D"};
		for (int i = 0; i < 3; i++)
		{
			for (int k = 0; k< 3; k++)
			{
				if (totals[k] > totals[k+1])
				{
					int out = totals[k];
					totals[k] = totals[k+1];
					totals[k+1] = out;
					String temp = arranged[k];
					arranged[k] = arranged[k+1];
					arranged[k+1] = temp;
				}
			}
		}
		for (int i = 0; i < arranged.length; i++)
		{
			if (i != 3)
			{
				System.out.print(arranged[i]+", ");
			}
			else
				System.out.print(arranged[i]);
		}
		System.out.println();
		
		//output 5
		int raw[] = new int[36];
		int count = 0;
		for (int i = 0; i < 9; i++)
		{
			for (int k = 0; k < 4; k++)
			{
				raw[count] = data[i][k];
				count++;
			}
		}
		
		for (int i = 0; i < 35; i++)
		{
			for (int k = 0; k < 35; k++)
			{
				if (raw[k] > raw[k+1])
				{
					int out = raw[k];
					raw[k] = raw[k+1];
					raw[k+1] = out;
				}
			}
		}
		double comp = raw[17]+raw[18];
		comp /=2;
		if (comp != (int)comp)
		{
			System.out.println(comp);
		}
		else
			System.out.println((int)comp);	
	}

}
