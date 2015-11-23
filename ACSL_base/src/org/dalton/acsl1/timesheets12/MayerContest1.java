package org.dalton.acsl1.timesheets12;

/**
 * Name: Alex Mayer
 * School: The Dalton school
 * School Code: 3055
 */

import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math.*;

public class MayerContest1 {
	public static void main(String[] args) {

		int runprogram= 0;
		Scanner keyboard = new Scanner(System.in);

		while (runprogram < 5) {
			
		double[] timesheet = new double[15];
		double salary = 0;
		
		//Reads input, makes it into an array
		String[] input = keyboard.nextLine().split(",");

		//Trims lead and lagging spaces, then puts converts it into an hour and puts it in the timesheet area
		for (int i = 0; i<input.length; i++)
		{
			input[i] = input[i].trim();

			if (input[i].equals("1"))
				timesheet[i]=9.0;

			else if (input[i].equals("2")) 
				timesheet[i]=9.5;
			else if (input[i].equals("3")) 
				timesheet[i]=10.0;
			else if (input[i].equals("4")) 
				timesheet[i]=10.5;
			else if (input[i].equals("5")) 
				timesheet[i]=11.0;
			else if (input[i].equals("6"))
				timesheet[i]=11.5;
			else if (input[i].equals("7"))
				timesheet[i]=12.0;
			else if (input[i].equals("8")) 
				timesheet[i]=12.5;
			else if (input[i].equals("9")) 
				timesheet[i]=1.0;
			else if (input[i].equals("A")) 
				timesheet[i]=1.5;
			else if (input[i].equals("B")) 
				timesheet[i]=2.0;
			else if (input[i].equals("C")) 
				timesheet[i]=2.5;
			else if (input[i].equals("D")) 
				timesheet[i]=3.0;
			else if (input[i].equals("E")) 
				timesheet[i]=3.5;
			else if (input[i].equals("F")) 
				timesheet[i]=4.0;
			else if (input[i].equals("G")) 
				timesheet[i]=4.5;
			else if (input[i].equals("H")) 
				timesheet[i]=5.0;
			else timesheet[i]=Double.parseDouble(input[i]);
		}


		//LOCATIONS 100-199
		if (Integer.parseInt(input[0])<200) {

			if (hoursWeek(timesheet)<=30) {
				salary = hoursWeek(timesheet) * 10;
			}

			else if (hoursWeek(timesheet) > 30)
			{
				double overtime = hoursWeek(timesheet) - 30;
				salary = 300 + (overtime * 15);
			}

		}

		//LOCATIONS 200-299
		else if (Integer.parseInt(input[0])>199 && Integer.parseInt(input[0])<300) {

			if (hoursWeek(timesheet)<=40) {
				salary = hoursWeek(timesheet) * 7.5;
			}

			else if (hoursWeek(timesheet) > 40)
			{
				double overtime = hoursWeek(timesheet) - 40;
				salary = 300 + (overtime * 15);
			}

		}

		//LOCATIONS 300-399
		else if (Integer.parseInt(input[0])>299 && Integer.parseInt(input[0])<400) {
			if (hoursWeek(timesheet)<=20) {
				salary = hoursWeek(timesheet) * 9.25;
			}

			else if (hoursWeek(timesheet) > 20)
			{
				double overtime = hoursWeek(timesheet) - 20;
				salary = 185 + (overtime * 10.50);
			}

		}

		//LOCATIONS 400-499
		else if (Integer.parseInt(input[0])>399 && Integer.parseInt(input[0])<500) {

			salary = (hoursDay(timesheet, 1) + hoursDay(timesheet, 13)) * 13.5 + hoursWorkweek(timesheet)*6.75;

		}

		//LOCATIONS 500-599
		else if (Integer.parseInt(input[0])>499 && Integer.parseInt(input[0])<=599) {

			for (int i = 1; i<14;)
			{
				if (hoursDay(timesheet, i) <= 6) salary = salary + hoursDay(timesheet, i)*8;

				else if (hoursDay(timesheet, i) >= 6) salary = salary + 48 + (hoursDay(timesheet, i) - 6)*12;

				i = i+2;
			}

		}

	
		salary  = Math.ceil(salary*100)/100; //rounds up to hundredth place

		/* DecimalFormat was found here: http://www.java-forums.org/advanced-java/4130-rounding-double-two-decimal-places.html
		 * 
		 * After poking around on the internet, I realized I had to change # to 0 because # won't display a zero in the decimal place. 
		 * 0 is a placeholder for all digits, so it won't display nothing.
		 */
		DecimalFormat money = new DecimalFormat("$0.00");

		System.out.println(money.format(salary));

		runprogram++;
		
		}//while
		
		
	}//main

	public static double hoursDay(double[] timesheet, int day)
	{
		double res = 0;

		//if the first hour is a double digit, and the second hour is a single digit
		if (timesheet[day]>= 9 && timesheet[day]<=12.5 && timesheet[day+1] >= 1 && timesheet[day+1]<=5) 
			res = (12 - timesheet[day]) + timesheet[day+1];

		else
			res = timesheet[day+1] - timesheet[day];

		return res;
	}//hoursDay

	public static double hoursWeek(double[] timesheet)
	{
		double res = 0;

		for (int i=1; i<14;)
		{
			res = res + hoursDay(timesheet, i);
			i = i + 2;
		}

		return res;
	}//hoursWeek

	public static double hoursWorkweek(double[] timesheet) {
		double res = 0;

		for (int i=3; i<12;) {
			res = res + hoursDay(timesheet, i);
			i = i + 2;
		}

		return res;


	}//hoursWorkweek

}//class
