package org.dalton.acsl1.draft11;

/*
 * Noah Levy
 * ACSL 2011-2012 Program 1
 * The Dalton School: 9075
 * 
 * 
 * 
 *	This is my ACSL 2011-2012 Program, it performs functions related to NFL Draft Picks
 *
    Copyright (C) 2011  Noah Levy

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see http://www.gnu.org/licenses/.
 */

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class DraftPickerNL {


	private static final double CHANCE_OF_INJURY_18 = .03375;
	private static final double CHANCE_OF_INJURY_16 = .03;
	private static Scanner scan  = new Scanner(System.in);

	private static double[][] parseInputs()
	{
		double[][] playuhs = new double[10][3];
		for(int i = 1; i <= 10; i++)
		{
			playuhs[i -1] = parseInput();
		}
		return playuhs;
	}
	private static double[] parseInput()
	{
		String s = scan.nextLine();
		s = s.replaceAll(" ",""); //remove whitespace
		String[] sarr = s.split(",");
		double[] playuh = new double[3];
		for(int d = 0; d < playuh.length; d++)
		{
			playuh[d] = Double.parseDouble(sarr[d]);
		}
		return playuh;
	}
	public static void main (String[]args)
	{
		//double[][]  playuhs = new double[3][10]; // 0 is years, 1 is contractValue, 2 is guaranteedValue

		//double[][] playuhs = {{5d,57.5d,30d},{6d,56.5d,29d},{6d,72d,34d},{6d,60d,26d},{5d,51d,23d},{5d,50d,21d},{5d,49d,19d},{5d,33.4d,17.177d},{5d,23d,15.6d},{5d,18.9d,13.8d}};

		//double[][] playuhs = {{5429d,1d,30d},{111d,20d,21.2d},{354d,18d,19d},{77d,9d,12d},{85d,19d,22d},{44d,13d,17.5d},{22d,22d,22d},{1d,5d,8d},{5d,92994d,35.386d},{4d,95d,8502d}};
	
		double[][] playuhs = parseInputs();
		System.out.println(millionz(diffHighLow(playuhs, false)));
		System.out.println(millionz(midRange(playuhs)));
		double[] highEV = highestExpectedValue(playuhs, false);
		System.out.println(millionz(highEV[0]) + " by #" + (int)Math.round(highEV[1]));
		System.out.println(millionz(averageExpectedValue(playuhs, true)));
		System.out.println(millionz(medianAnnualSalary(playuhs)));
	}
	private static String millionz(double arg)
	{
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(0);
		arg *= 10e5;
		return nf.format(arg);
	}
	private static double annualSalary(double contractValue, double years)
	{
		double annualSalary = contractValue/years;
		return annualSalary;
	}
	private static double annualSalary(double[] playuh)
	{
		return annualSalary(playuh[1], playuh[0]);
	}
	private static double salaryPerGame(double contractValue, double years, boolean is18Game)
	{
		if(!is18Game)
		{
			return annualSalary(contractValue, years)/ 16.0d;
		}
		else
		{
			return annualSalary(contractValue, years)/ 18.0d;
		}
	}
	private static double midRange(double[][] playuhs)
	{

		double[] highAndLow = rangeHighLow(playuhs, true);
		double average = (highAndLow[0] + highAndLow[1])/2d;
		return average;

	}
	private static double diffHighLow(double[][] playuhs, boolean is18Game)
	{
		double[] HL = rangeHighLow(playuhs, is18Game);
		double diff = HL[0] - HL[1];
		return diff;
	}
	private static double[] rangeHighLow(double[][] playuhs, boolean is18Game)
	{
		double highest = Double.MIN_VALUE;
		double lowest = Double.MAX_VALUE;
		double curSPG = 0;
		for(double[] darr : playuhs)
		{
			curSPG = salaryPerGame(darr[1], darr[0], is18Game);
			if(curSPG > highest)
			{
				highest = curSPG;
			}
			if(curSPG < lowest)
			{
				lowest = curSPG;
			}
		}
		double[] highAndLow = {highest, lowest};
		return highAndLow;
	}
	private static double expectedValue(double[] playuh, boolean is18Game)
	{
		return expectedValue(playuh[0], playuh[1], playuh[2], is18Game);
	}
	private static double expectedValue(double contractLength, double contractValue, double guarantee, boolean is18Game)
	{

		double E;
		if(is18Game)
		{
			E =  ( (1.0d - (contractLength)*(CHANCE_OF_INJURY_18))*(contractValue) + (contractLength)*(CHANCE_OF_INJURY_18)*(guarantee) );
		}
		else
		{
			E = ( (1.0d - (contractLength)*(CHANCE_OF_INJURY_16))*(contractValue) + (contractLength)*(CHANCE_OF_INJURY_16)*(guarantee) );
		}
		return E;
	}
	private static double averageExpectedValue(double[][] playuhs, boolean is18Game)
	{
		double average = 0;
		for(double[] darr : playuhs)
		{
			average += expectedValue(darr, is18Game);
		}
		average = average / (double)playuhs.length;
		return average;
	}
	private static double[] highestExpectedValue(double[][] playuhs, boolean is18Game)
	{
		double highest = Double.MIN_VALUE;
		double tempVal = 0;
		int playernum = -1;

		int curPlayer = 0;
		for(double[] darr : playuhs)
		{

			curPlayer ++;
			tempVal = expectedValue(darr, is18Game);
			if(tempVal > highest)
			{
				highest = tempVal;
				playernum = curPlayer;
			}
		}
		//System.out.println("high" + highest);
		double[] result = {highest, playernum};
		return result;
	}

	private static double medianAnnualSalary(double[][] playuhs)
	{
		double[] annualSalaries = new double[playuhs.length];

		for(int i = 0; i < playuhs.length; i++)
		{

			annualSalaries[i] = annualSalary(playuhs[i]);
			//System.out.println("--" + annualSalaries[i]);
		}
		Arrays.sort(annualSalaries);

		if (annualSalaries.length % 2 == 1)
			return annualSalaries[(annualSalaries.length+1)/2-1];
		else
		{
			double lower = annualSalaries[(annualSalaries.length)/2-1];
			double upper = annualSalaries[(annualSalaries.length)/2];

			return (lower + upper) / 2.0;
		}	

	}

}