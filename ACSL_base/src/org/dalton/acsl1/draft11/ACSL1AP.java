package org.dalton.acsl1.draft11;
import java.util.*;

public class ACSL1AP {
	/**
	 * Alex Pong ('11-'12)
	 * Dalton
	 * 9075
	 */
	public static int LOOPS = 10;
	public static void main(String[] args) {

		double[][] salary = new double [10][2];
		double[][] years = new double [10][2];
		double[][] guarantee = new double [10][2];
		double[] salPer16Game =  new double[10];
		double[] salPer18Game = new double [10];
		double[] annualSalary = new double[10];
		double[] expectedValuePer16Game = new double [10];
		double[] expectedValuePer18Game = new double [10];

		Scanner input = new Scanner(System.in);
		System.out.println("Input: ");
		//take in the data
		for(int x = 0; x<LOOPS; x++)
		{
			String in = input.nextLine(); //take the input
			String numbers[] = in.split(", ");//split on the comma space

			years[x][0] = Double.parseDouble(numbers[0]);
			years[x][1]=x;
			salary[x][0] = Double.parseDouble(numbers[1]);
			salary[x][1]=x;
			guarantee[x][0] = Double.parseDouble(numbers[2]);
			guarantee[x][1]=x;
		}
		//do some sorting and calculation
		for(int x = 0; x<LOOPS; x++)
		{
			salPer16Game[x] = salPerGame(salary[x][0],years[x][0],16);
			salPer18Game[x] = salPerGame(salary[x][0],years[x][0],18);
			annualSalary[x] = salPerYear(salary[x][0], years[x][0]);
			expectedValuePer16Game[x] = expectedVal(years[x][0], 16, salary[x][0],guarantee[x][0]);
			expectedValuePer18Game[x] = expectedVal(years[x][0], 18, salary[x][0],guarantee[x][0]);
		}
		//important! if you do theCopy = expectedValuePer16Game gets sorted too when you call Arrays.sort() for some reason.
		double[] theCopy = Arrays.copyOf(expectedValuePer16Game, expectedValuePer16Game.length);

		//FINAl OUTPUT
		System.out.println("1. "+(int)(Math.round(range(salPer16Game)*1E6)));
		System.out.println("2. "+(int)(Math.round(midrange(salPer18Game)*1E6)));		
		System.out.println("3. "+(int)Math.round(highestExpected(expectedValuePer16Game)*1E6)+ " by #" + indexOf(theCopy, highestExpected(expectedValuePer16Game)));
		System.out.println("4. "+(int)(Math.round(averageExpected(expectedValuePer18Game)*1E6)));
		System.out.println("5. "+(int)(Math.round(median(annualSalary)*1E6)));
	}
	public static double averageExpected(double[]expectedValue)
	{
		double total = 0;
		for (int i = 0; i < expectedValue.length; i++) {
			total = total + expectedValue[i];
		}
		return total/10d;
	}
	public static double highestExpected(double[] expectedValue)
	{		
		Arrays.sort(expectedValue);
		return expectedValue[9];
	}
	public static int indexOf(double[] values, double toFind)
	{
		for (int i = 0; i < values.length; i++) {
			if (values[i] == toFind) return(i+1);
		}
		return -1;
	}
	public static double salPerGame(double salary, double years, int games)
	{
		return salary/years/games;
	}
	public static double salPerYear(double salary, double years)
	{
		return salary/years;
	}
	public static double median(double[]salary)
	{
		Arrays.sort(salary);
		return (salary[4] + salary[5])/2;
	}
	public static double expectedVal(double length, int games, double value, double guarantee)
	{
		double chance = .03;
		if (games==18) chance = .03375;
		return (1d-(length)*(chance))*(value)+(length)*(chance)*(guarantee);
	}
	public static double range(double[] salarypergame)
	{
		Arrays.sort(salarypergame);
		return salarypergame[9] - salarypergame[0];
	}
	public static double midrange(double[] salarypergame)
	{
		Arrays.sort(salarypergame);
		return (salarypergame[9] + salarypergame[0])/2;
	}
}

