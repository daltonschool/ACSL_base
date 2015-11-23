package org.dalton.acsl1.draft11;

/**Name: Johnny Kruger
 * School Code: 3055
 */


import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DraftJK
{

	static double[] lengthOfContract = new double[10];
	static double[] valueOfContract = new double[10];
	static double[] guaranteeOfContract = new double[10];

	

	public static void main(String []args)
	{
		int one = 0;
		int two = 0;
		int threeA = 0;
		int threeB = 0;
		int four = 0;
		int five = 0;
		
		Scanner in = new Scanner(System.in);
		

		for(int i = 0; i < 10; i++)
		{
			String line = in.nextLine();
			StringTokenizer st = new StringTokenizer(line, ", ");
			
			lengthOfContract[i] = Double.parseDouble(st.nextToken());
			valueOfContract[i] = Double.parseDouble(st.nextToken());
			guaranteeOfContract[i] = Double.parseDouble(st.nextToken());
		}
		
		//PART 1
		double[] salariesPerGame = new double[10];
		
		for(int i = 0; i < 10; i++)
		{
			salariesPerGame[i] = valueOfContract[i] / lengthOfContract[i] / 16;
		}
		
		Arrays.sort(salariesPerGame);
		
		one = (int)((salariesPerGame[9] - salariesPerGame[0])*1000000);
		
		//PART 2
		for(int i = 0; i < 10; i++)
		{
			salariesPerGame[i] = valueOfContract[i] / lengthOfContract[i] / 18;
		}
		Arrays.sort(salariesPerGame);
		
		two = (int)((salariesPerGame[9] + salariesPerGame[0])/2 * 1000000);
		
		//PART 3
		double[] expectedValue = new double[10];
		for(int i = 0; i < 10; i++)
		{
			expectedValue[i] = ((1 - (lengthOfContract[i])* (.03)) * (valueOfContract[i]) + (lengthOfContract[i]) * (.03) * (guaranteeOfContract[i]));			
		}
		
		double bestExpected = -1;
		int bestsNumber = -1;
		
		for(int i = 0; i < 10; i++)
		{
			if(bestExpected < expectedValue[i])
			{
				bestExpected = expectedValue[i];
				bestsNumber = i;
			}
		}
		threeA = (int)(bestExpected * 1000000);
		threeB = bestsNumber + 1;
		
		//PART 4
		for(int i = 0; i < 10; i++)
		{
			expectedValue[i] = ((1 - (lengthOfContract[i])* (.03375)) * (valueOfContract[i]) + (lengthOfContract[i]) * (.03375) * (guaranteeOfContract[i]));			
		}
		
		double sum = 0;
		
		for(int i = 0; i < 10; i++)
			sum += expectedValue[i];
		four = (int)(sum/10 * 1000000);
		
		//PART 5
		double[] annualSalaries = new double[10];
		for(int i = 0; i < 10; i++)
		{
			annualSalaries[i] = valueOfContract[i] / lengthOfContract[i];
		}
		Arrays.sort(annualSalaries);
		five = (int)((annualSalaries[4] + annualSalaries[5]) / 2 * 1000000);
		
		System.out.println(one + "\n" + two + "\n" + threeA + " by #" + threeB + "\n" + four + "\n" + five);
		
	}

}