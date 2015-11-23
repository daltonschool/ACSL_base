package org.dalton.acsl1.draft11;
/**
 * Name: Caroline Cherston
 * School Code: 9075
 * School: The Dalton School 
 * Date: December 13th, 2011
 * Other: NOTES ON INPUT: enter input line 1, hit the enter key. enter input line 2, hit the enter key, etc. 
 * 
 */

import java.util.Arrays;
import java.util.Scanner;


public class ACSL1CC {

	public static void main(String[] args) {

	
		Scanner scanner = new Scanner(System.in); 
		double [][] Values = new double [10][3];
		
		for(int h=0; h<10; h++)
		{
			String [] UserInput = new String [3];
			UserInput = scanner.nextLine().split(","); 
			
			Values[h][0] = Double.parseDouble(UserInput[0]);
			Values[h][1] = Double.parseDouble(UserInput[1]);
			Values[h][2] = Double.parseDouble(UserInput[2]); 
			
		}
		
		System.out.println(String.format("%.0f",rangeSalaries(Values))); 
		System.out.println(String.format("%.0f", midrangeSalaries(Values))); 
		System.out.println(highestExpected(Values)); 
		System.out.println(String.format("%.0f", avgExpected(Values))); 
		System.out.println(String.format("%.0f", medianAnnualSalary(Values))); 

	}
	
	public static double rangeSalaries(double [][] userInput)
	{
		double range = 0;
		double [] Salaries = new double [10];
		for(int k=0; k<userInput.length; k++)
		{
			Salaries[k] = ((userInput[k][1]*1000000)/userInput[k][0])/16; 
		}
		Arrays.sort(Salaries);
		
		return range = Salaries[Salaries.length-1] -Salaries[0];	
		
	}
	
	public static double midrangeSalaries(double [][] userInput)
	{
		double midrange =0;
		double [] Salaries = new double[10];
		for(int k=0; k<userInput.length; k++)
		{
			Salaries[k] = ((userInput[k][1]*1000000)/userInput[k][0])/18; 
		}
		
		Arrays.sort(Salaries); 
		return midrange = (Salaries[0] + Salaries[Salaries.length-1])/2;
	}
	
	public static String highestExpected(double [][] userInput)
	{
		double E1 = 0;
		double E2 = 0; 
		int draft = 0; 
		for(int k=0; k<userInput.length; k++)
		{
			E1 = (1-(userInput[k][0]*.03))*(userInput[k][1]*1000000)+((userInput[k][0]*.03)*userInput[k][2]*1000000); 
			
			if(E1>E2)
			{
				E2 = E1; 
				draft = k+1; 
			}
		}
				
		return String.format("%.0f",E2) + " by #" + draft; 
	}
	public static double avgExpected(double [][] userInput)
	{
		double total =0;
		double E =0;
		double avgExpected =0;
		for(int k=0; k<userInput.length; k++)
		{
			E = (1-(userInput[k][0]*.03375))*(userInput[k][1]*1000000)+((userInput[k][0]*.03375)*userInput[k][2]*1000000); 
			total += E; 
		}
		return avgExpected = total/10; 
	}
	
	public static double medianAnnualSalary(double [][] userInput)
	{
		double median =0;
		double [] AnnualSalaries = new double[10];
		for(int k=0; k<userInput.length; k++)
		{
			AnnualSalaries[k] = userInput[k][1]*1000000/userInput[k][0]; 
		}
		
		Arrays.sort(AnnualSalaries); 
		return median = (AnnualSalaries[4] + AnnualSalaries[5])/2;
		
	}
	
}
