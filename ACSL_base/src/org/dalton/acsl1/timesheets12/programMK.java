package org.dalton.acsl1.timesheets12;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;


/* Name: Maya Klabin
 * School: Dalton School
 * School Code: 3055
 */

public class programMK
{
	public static void main(String[] args) 
	{
	
		int k = 0;
		//String[] results = new String[5];

		while(k<5)
		{
		String out = "";

			Scanner input = new Scanner(System.in);
			String[] raw = input.nextLine().split(", ");
			double[] data = new double[8];	
			data[0]= Double.parseDouble(raw[0]);
			for (int i = 1; i < raw.length; i++) {
				data[i]=daySums(raw[i]);
			}
			DecimalFormat form = new DecimalFormat("'$'0.00");
			form.setRoundingMode(RoundingMode.HALF_UP);
			
				if(data[0]<200){out=form.format(first(data));}
				else if (data[0]>199 & data[0]<300){out=form.format(second(data));}
				else if (data[0]>299 & data[0]<400){out=form.format(third(data));}
				else if (data[0]>399 & data[0]<500){out=form.format(fourth(data));}
				else if (data[0]>499 & data[0]<600){out=form.format(fifth(data));}
			
			System.out.println(out);
		k++;
		}
		
	}//main

	public static double daySums(String x)
	{
		double morn;
		double aft;
		double tot;
		char[] edit = x.toCharArray();


		morn = convert(edit[0]);
		aft = convert(edit[2]);
		tot=aft-morn;

		return tot;
	}

	public static double convert(char x)
	{
		double val=0;
		if(x == '1'){val = 9;}
		else if (x=='2'){val=9.5;}
		else if (x=='3'){val=10;}
		else if (x=='4'){val=10.5;}
		else if (x=='5'){val=11;}
		else if (x=='6'){val=11.5;}
		else if (x=='7'){val=12;}
		else if (x=='8'){val=12.5;}
		else if (x=='9'){val=13;}
		else if (x=='A'){val=13.5;}
		else if (x=='B'){val=14;}
		else if (x=='C'){val=14.5;}
		else if (x=='D'){val=15;}
		else if (x=='E'){val=15.5;}
		else if (x=='F'){val=16;}
		else if (x=='G'){val=16.5;}
		else if (x=='H'){val=17;}

		return val;
	}

	public static double weekSums(double[] x){

		double total=0;

		for (int i = 1; i < x.length; i++) 
		{
			total = total + x[i];
		}
		return total;
	}

	//100-199
	public static double first(double[] x)
	{
		double total = weekSums(x);
		double mathed;

		if(total<30)
		{
			mathed = total*10;
		}
		else
		{
			mathed = (total-30)*5 + total*10;
		}

		return mathed;
	}

	//200-299
	public static double second(double[] x)
	{
		double total = weekSums(x);
		double mathed;

		if (total<40)
		{
			mathed=total*7.5;
		}
		else
		{
			mathed = (total-40)*7.5 + total*7.5;
		}

		return mathed;
	}

	//300-399
	public static double third(double[] x)
	{
		double total = weekSums(x);
		double mathed;

		if (total<20)
		{
			mathed = total*9.25;
		}
		else
		{
			mathed = (total-20)*10.5 + 20*9.25;
		}

		return mathed;
	}

	//400-499
	public static double fourth(double[] x)
	{
		double satsun = x[1] + x[7];
		double otherwise = weekSums(x) - satsun;
		double total;

		total = satsun*13.5 + otherwise*6.75;
		return total;
	}

	//500-599
	public static double fifth(double[] x)
	{
		double total=0;
		double mathed;

		for (int i = 1; i < x.length; i++) {
			if(x[i]<6)
			{
				total = total + x[i]*8;
			}
			else
			{
				total = total + (x[i]-6)*12 + 48;
			}

		}

		return total;
	}
}
