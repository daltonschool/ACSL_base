package org.dalton.acsl1.timesheets12;
/*
 * Taylor Wright
 * 2013
 * ACSL 1
 * 
 * School Code: 3055
 * The Dalton School
 * 
 **/

import java.util.Scanner;
import java.text.NumberFormat;

//import java.util.Arrays;

public class ACSL12013TW
{

	public static void main(String[] args) 
	{

		Scanner keyboard = new Scanner(System.in);
		String []times = new String [17];
		//String begin="";
		//String end="";
		double start=0;
		double stop=0;
		double hours=0;
		double money=0;
		int location =0;
		int fiveLessThan=0;
		int fiveGreaterThan=0;
		NumberFormat format =  NumberFormat.getCurrencyInstance();

	//	for (int i=0; i<17; i++)//makes the table that holds the hours
	//	{
	//		times [1][i]= Double.toString(9 + i*.5);

	//	}
		times [0] = "1";
		times [1] = "2";
		times [2] = "3";
		times [3] = "4";
		times [4] = "5";
		times [5] = "6";
		times [6] = "7";
		times [7] = "8";
		times [8] = "9";
		times [9] = "A";
		times [10] = "B";
		times [11] = "C";
		times [12] = "D";
		times [13] = "E";
		times [14] = "F";
		times [15] = "G";
		times [16] = "H";

		for (int i=0; i<5; i++)//takes in the data
		{
			String [] data = new String[8];
			String input = keyboard.nextLine();

			data = input.split(", ");
			location = Integer.parseInt(data[0]);
			for (int x=0; x<7; x++)
			{
				String [] temp= new String [2];
				temp=data[x+1].split(",");
				
			//	for (int y=0; y<2; y++)
			//	{
			//		System.out.println("temp:"+temp[y]);
			//	}

				for (int z=0; z<17; z++)
				{
					if (times[z].equals(temp[0]))
					{
						start = z;
					}
					if (times[z].equals(temp[1]))
					{
						stop = z;
					}	
					if (location >= 500)
					{
						if (stop-start>6)
						{
							fiveGreaterThan++;
						}
						if (stop-start<=6)
						{
							fiveLessThan++;
						}
					}
					if (location >= 400 && location < 500)
					{
						if (data[x+1]==data[1] || data[x+1]==data[7])
						{
							stop = stop*2;
							start = start*2;
						}
					}
				}
				hours = hours + (stop - start);
			}

			if (location >= 100 && location <200)
			{
				if (hours <= 30)
				{
					money = hours * 10;
				}

				else if (hours > 30)
				{
					money = hours * 10 + (hours - 30) * 15;
				}
				System.out.println(format.format(money));

				hours=0;
				money =0;
			}

			else if (location >= 200 && location <300)
			{
				money = hours * 7.50;

				if (hours>40)
				{
					money = money + hours*7.5 +(hours-40) * 15.00;
				}

				else if (hours<=40)
				{
					money = money + hours*7.5;
				}
				System.out.println(format.format(money));

				hours =0;
				money =0;
			}

			else if (location >=300 & location <400)
			{
				money = hours * 9.25;

				if (hours>20)
				{
					money = money + (hours-20)*10.5 + 20*9.25 ;
				}

				else if (hours<=20)
				{
					money = money + hours*9.25 ;
				}
				System.out.println(format.format(money));

				hours =0;
				money =0;
			}

			else if (location >= 400 && location <500)
			{
				money=money+hours*6.75;
				System.out.println(format.format(money));

				hours=0;
				money =0;
			}

			else if(location >= 500)
			{
				money = money+(hours-fiveGreaterThan*6)*12+fiveGreaterThan*6*8;
				System.out.println(format.format(money));

				hours=0;
				money =0;
			}
		}
	}
}
