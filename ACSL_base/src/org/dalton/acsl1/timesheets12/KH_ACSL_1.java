package org.dalton.acsl1.timesheets12;

/**
 * Name: Keiko Emma Higashikawa
 * School: Dalton School
 * School Code: 3055
 */

import java.util.Arrays;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.*;

public class KH_ACSL_1 
{
	public static double conv(String symbol)
	{
		double time = 0;
		if(symbol.equals("1"))
		{
			time = 9;
		}
		if(symbol.equals("2"))
		{
			time = 9.5;
		}
		if(symbol.equals("3"))
		{
			time = 10;
		}
		if(symbol.equals("4"))
		{
			time = 10.5;
		}
		if(symbol.equals("5"))
		{
			time = 11;
		}
		if(symbol.equals("6"))
		{
			time = 11.5;
		}
		if(symbol.equals("7"))
		{
			time = 12;
		}
		if(symbol.equals("8"))
		{
			time = 12.5;
		}
		if(symbol.equals("9"))
		{
			time = 13;
		}
		if(symbol.equals("A"))
		{
			time = 13.5;
		}
		if(symbol.equals("B"))
		{
			time = 14;
		}
		if(symbol.equals("C"))
		{
			time = 14.5;
		}
		if(symbol.equals("D"))
		{
			time = 15;
		}
		if(symbol.equals("E"))
		{
			time = 15.5;
		}
		if(symbol.equals("F"))
		{
			time = 16;
		}
		if(symbol.equals("G"))
		{
			time = 16.5;
		}
		if(symbol.equals("H"))
		{
			time = 17;
		}
		return time;
	}
	public static double dayhours(String day)
	{
		double hours = 0;
		String codes[] = day.split(",");
		hours = conv(codes[1]) - conv(codes[0]);
		return hours;	
	}
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String[] finalout = new String[5];
		int line = 0;

		while(line < 5)
		{
			String dump[] = input.nextLine().split(",\\s+");

			if(100<=Double.parseDouble(dump[0]) && 199>=Double.parseDouble(dump[0]))
			{
				double totalhr = 0;
				double pay = 0;
				int counter = 1;
				DecimalFormat df = new DecimalFormat("#0.00");
				df.setRoundingMode(RoundingMode.HALF_UP);

				while(counter < dump.length)
				{
					totalhr = totalhr + dayhours(dump[counter]);
					counter++;
				}
				if(totalhr > 30)
				{
					pay = 30*10 + (totalhr - 30)*15;
				}
				else
				{
					pay = totalhr*10;
				}
				finalout[line] = df.format(pay);
			}

			else if(200<=Double.parseDouble(dump[0]) && 299>=Double.parseDouble(dump[0]))
			{
				double totalhr = 0;
				double pay = 0;
				int counter = 1;
				DecimalFormat df = new DecimalFormat("#0.00");
				df.setRoundingMode(RoundingMode.HALF_UP);

				while(counter < dump.length)
				{
					totalhr = totalhr + dayhours(dump[counter]);
					counter++;
				}
				if(totalhr > 40)
				{
					pay = 40*7.5 + (totalhr - 40)*15;
				}
				else
				{
					pay = totalhr*7.5;
				}
				finalout[line] = df.format(pay);
			}
			
			else if(300<=Double.parseDouble(dump[0]) && 399>=Double.parseDouble(dump[0]))
			{
				double totalhr = 0;
				double pay = 0;
				int counter = 1;
				DecimalFormat df = new DecimalFormat("#0.00");
				df.setRoundingMode(RoundingMode.HALF_UP);

				while(counter < dump.length)
				{
					totalhr = totalhr + dayhours(dump[counter]);
					counter++;
				}
				if(totalhr > 20)
				{
					pay = 20*9.25 + (totalhr - 20)*10.5;
				}
				else
				{
					pay = totalhr*9.25;
				}
				finalout[line] = df.format(pay);
			}

			else if(400<=Double.parseDouble(dump[0]) && 499>=Double.parseDouble(dump[0]))
			{
				double hr = 0;
				double wknd = 0;
				double pay = 0;
				int counter = 2;
				DecimalFormat df = new DecimalFormat("#0.00");
				df.setRoundingMode(RoundingMode.HALF_UP);

				while(counter < 7)
				{
					hr = hr + dayhours(dump[counter]);
					counter++;
				}
				wknd = dayhours(dump[1])+dayhours(dump[7]);
				pay = hr*6.75 + wknd*13.50;
				finalout[line] = df.format(pay);
			}

			else if(500<=Double.parseDouble(dump[0]) && 599>=Double.parseDouble(dump[0]))
			{
				double pay = 0;
				int counter = 1;
				DecimalFormat df = new DecimalFormat("#0.00");
				df.setRoundingMode(RoundingMode.HALF_UP);

				while(counter < dump.length)
				{
					if(dayhours(dump[counter])>6)
					{
						pay = pay + (dayhours(dump[counter])-6)*12 + 6*8;
					}
					else
					{
						pay = pay + dayhours(dump[counter])*8;
					}
					counter++;
				}
				finalout[line] = df.format(pay);
			}
			else
			{
				finalout[line] = "Error: Location not found";
			}
			line++;
		}
		for(int done = 0; done < finalout.length; done++)
		{
			System.out.println("$" + finalout[done]);
		}	
	}
}
