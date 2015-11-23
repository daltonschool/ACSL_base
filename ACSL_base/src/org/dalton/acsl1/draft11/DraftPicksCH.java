package org.dalton.acsl1.draft11;
/**
 * Caroline Haas
 * School Code: 3055
 * The Dalton School
 */

import java.util.Arrays;
import java.util.Scanner;

public class DraftPicksCH {

	public static void main(String[] args) {
		String[]  valuesString=new String[3];
		double[][] values = new double[10][3];
		Scanner input=new Scanner(System.in);
		for(int i=0; i<10; i++)
		{
			String row=input.nextLine();
			valuesString=row.split(",");
			for(int j=0; j<3; j++) values[i][j]=Double.parseDouble(valuesString[j]);
		}
		 
		double[] salary1=salaryArray(16, values);
		double range=range(salary1);
		System.out.println("1. " + Math.round(range*1000000));
		
		double[] salary2=salaryArray(18, values);
		double midRange=midRange(salary2);
		System.out.println("2. " + Math.round(midRange*1000000));
		
		double[][] expected = new double[10][1];//calculating highest expected value, and who has that value
		for(int i=0; i<10; i++) expected[i][0]=calcExpect(values[i], 16);
		double highest=expected[0][0];
		double playerHighest=1;
		for(int i=0; i<9; i++)
		{
			if(expected[i+1][0]>highest)
			{	
				highest=expected[i+1][0];
				playerHighest=i+2;
			}
		}
		System.out.println("3. " + Math.round(highest*1000000) + " by #" + playerHighest);
		
		double avgEx=avgEx(values, 18);
		System.out.println("4. " + Math.round(avgEx*1000000));
		
		double medianSalary=medianSalary(values);
		System.out.println("5. " + Math.round(medianSalary*1000000));
	}

	public static double[] salaryArray(int games, double[][] values)//creates sorted array of only salaries
	{
		double[] salary=new double[10];
		for(int i=0; i<10; i++) salary[i]=values[i][1]/values[i][0]/games;
		Arrays.sort(salary);
		return salary;
	}
	
	public static double range(double[] salary)//calculates range
	{return Math.abs(salary[9]-salary[0]);}
	
	public static double midRange(double[] salary)//calculates midRange
	{return (Math.abs(salary[9]+salary[0])/2);}
	
	public static double calcExpect(double[] row, int games)//calculates expected value
	{
		double injury=0;
		if(games==16) injury=.03;
		else if(games==18) injury=.03375;
		double E=((1-(row[0]*injury))*row[1])+(row[0]*injury*row[2]);
		return E;
	}
	
	public static double avgEx(double[][] values, int games)//calculates the average expected value
	{
		double total=0;
		for(int i=0; i<10; i++) total=total+calcExpect(values[i], games);
		return total/10;
	}
	
	public static double medianSalary(double[][] values)//calculates the median yearly salary
	{
		double[] salary=new double[10];
		for(int i=0; i<10; i++) salary[i]=values[i][1]/values[i][0];
		Arrays.sort(salary);
		return (salary[4] + salary[5])/2;
	}
}