package org.dalton.acsl1.prints10;

import java.util.Scanner;

public class ACSLContext1WHORL
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);




		int sumN = 0; //numerator sum
		int sumD = 0; //denominator sum

		for(int k = 0; k < 5; k++) //where k = is the number of input lines
		{
			int finger1 = 0;
			int finger2 = 0;
			int finger3 = 0;
			int finger4 = 0;
			int finger5 = 0; //numerator

			int finger6 = 0; //denominator
			int finger7 = 0;
			int finger8 = 0;
			int finger9 = 0;
			int finger10 = 0;
			String response = "";
			response = in.nextLine();
			String input[] = response.split(", ");

			if(input[0].equals("1") && input[1].equals("1"))
			{
				System.out.println("None");
			}

			else
			{
				String numerator[] = new String[5];
				String denominator[] = new String[5];	
				String fingers[] = new String[10];
				String alldata = "";
				int n = Integer.parseInt(input[0]);
				int d = Integer.parseInt(input[1]);
				sumN = n - 1; //numerator sum
				sumD = d - 1; //denominator sum

				for(int f = 0; f < 5; f++) //where f = number of fingers
				{
					if(sumN >= 16)
					{
						finger1 = 2;
						numerator[f] = Integer.toString(finger1);
						sumN = sumN - 16;
					}
					else if(sumN >= 8)
					{
						finger2 = 4;
						numerator[f] = Integer.toString(finger2);
						sumN = sumN - 8;
					}
					else if(sumN >= 4)
					{
						finger3 = 6;
						numerator[f] = Integer.toString(finger3);
						sumN = sumN - 4;
					}
					else if(sumN >= 2)
					{
						finger4 = 8;
						numerator[f] = Integer.toString(finger4);
						sumN = sumN - 2;
					}
					else if(sumN == 1)
					{
						finger5 = 10;
						numerator[f] = Integer.toString(finger5);
						sumN = sumN - 1;
					}

					if(sumD >= 16)
					{
						finger1 = 1;
						denominator[f] = Integer.toString(finger1);
						sumD = sumD - 16;
					}
					else if(sumD >= 8)
					{
						finger2 = 3;
						denominator[f] = Integer.toString(finger2);
						sumD = sumD - 8;
					}
					else if(sumD >= 4)
					{
						finger3 = 5;
						denominator[f] = Integer.toString(finger3);
						sumD = sumD - 4;
					}
					else if(sumD >= 2)
					{
						finger4 = 7;
						denominator[f] = Integer.toString(finger4);
						sumD = sumD - 2;
					}
					else if(sumD == 1)
					{
						finger5 = 9;
						denominator[f] = Integer.toString(finger5);
						sumD = sumD - 1;
					}
				}

				for(int x = 0; x < numerator.length; x++) //stuff numerator values into new array
				{
					if((numerator[x] != "0") && (numerator[x] != null))
					{
						alldata = alldata + numerator[x] + ",";
					}
				}
				for(int y = 0; y < denominator.length; y++) //stuff denominator values into new array
				{
					if((denominator[y] != "0") && (denominator[y] != null))
					{
						alldata = alldata + denominator[y] + ",";
					}
				}
				alldata = alldata.substring(0,alldata.length()-1);
				System.out.println(alldata);
			}
		}
	}
}