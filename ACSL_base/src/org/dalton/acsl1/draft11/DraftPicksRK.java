/**
 * Draft Picks program for ACSL 2011-2012
 * 
 * @author Russell Kaplan
 * School: Dalton
 * Code: 3055
 */
package org.dalton.acsl1.draft11;

import java.util.Arrays;
import java.util.Scanner;

public class DraftPicksRK {
	
	final static int INPUT_SIZE = 10;
	final static int DATA_PER_INPUT = 3;
	
	public static void main(String[] args) {
		
		//IO plumbing:
		Scanner sc = new Scanner(System.in);
		double[][] data = new double[INPUT_SIZE][DATA_PER_INPUT];
		String[] tempRaw = new String[data[0].length];
		double[] tempParsed = new double[data[0].length];
		for (int i = 0; i < data.length; i++) {
			tempRaw = sc.nextLine().split(", ");
			for(int j = 0; j < tempRaw.length; j++) {
				tempParsed[j] = Double.parseDouble(tempRaw[j]);
			}
			System.arraycopy(tempParsed, 0, data[i], 0, tempParsed.length);
		}
		
		rangeSalary(data);
		midrangeSalary(data);
		highestExpectedVal(data);
		avgExpectedVal(data);
		medianAnnualSalary(data);
	}
	
	public static void rangeSalary(double[][] data) {
		double[] salaries = new double[data.length];
		for(int i = 0; i < data.length; i++) {
			salaries[i] = salaryPerGame(data[i][0], data[i][1], 16);
		}
		Arrays.sort(salaries);
		
		long range = round( (salaries[salaries.length-1] - salaries[0]) * 1000000 );
		System.out.println("1. " + range);
	}
	
	public static void midrangeSalary(double[][] data) {
		double[] salaries = new double[data.length];
		for(int i = 0; i < data.length; i++) {
			salaries[i] = salaryPerGame(data[i][0], data[i][1], 18);
		}
		Arrays.sort(salaries);
		
		long midrange = round( (salaries[0] + salaries[salaries.length-1]) * 1000000 / 2 );
		System.out.println("2. " + midrange);
	}
	
	public static void highestExpectedVal(double[][] data) {
		double[] expectedVals = new double[data.length];
		for(int i = 0; i < data.length; i++) {
			expectedVals[i] = expectedValue(data[i][0], 16, data[i][1], data[i][2]);
		}
		
		int indexOfMax = 0;
		for(int i = 1; i < expectedVals.length; i++) {
			if(expectedVals[i] > expectedVals[indexOfMax]) indexOfMax = i;
		}
		
		long value = round(expectedVals[indexOfMax] * 1000000);
		int pick = indexOfMax + 1;
		System.out.println("3. " + value + " by #" + pick);
	}
	
	public static void avgExpectedVal(double[][] data) {
		double[] expectedVals = new double[data.length];
		for(int i = 0; i < data.length; i++) {
			expectedVals[i] = expectedValue(data[i][0], 18, data[i][1], data[i][2]);
		}
		
		double sum = 0;
		for(double d : expectedVals) {
			sum += d;
		}
		
		long average = round(sum * 1000000 / expectedVals.length);
		System.out.println("4. " + average);
	}
	
	public static void medianAnnualSalary(double[][] data) {
		double[] annualSals = new double[data.length];
		
		for(int i = 0; i < data.length; i++) {
			annualSals[i] = data[i][1] / data[i][0]; //value / years
		}
		Arrays.sort(annualSals);
		
		long median = round((annualSals[4] + annualSals[5]) * 1000000 / 2);
		System.out.println("5. " + median);
	}
	
	public static long round(double d) {
		return Math.round(d);
	}
	
	public static double salaryPerGame(double contractLength, double contractValue, double games) {
		return (contractValue / contractLength) / games;
	}
	
	public static double expectedValue(double contractLength, double games, double contractValue,
			double guarantee) {
		double injuryProbability = games == 16 ? .03 : .03375;
		return ((1 - (contractLength * injuryProbability)) * contractValue) + (contractLength * injuryProbability * guarantee);
	}
}
