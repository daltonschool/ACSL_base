package org.dalton.acsl2.string15;
import java.util.Scanner;

/**********
 * Name: Jamie Konigsberg
 * Purpose: Complete ACSL 2
 * Date: 2/9/16
 */

public class ACSL2_String15_JK {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		for(int i = 0; i<5; i++)
		{
			int possign = 0;
			int negsign = 0;
			String unsignedfloat = "";
			String[] input = s.nextLine().split(", ");
			int length = Integer.parseInt(input[1]);
			int numdecimals = Integer.parseInt(input[2]);
			String variable = input[0];
			String adjustedfloat = "";
			int adjustlength; 
			String greaterlength = "";
			
			if(variable.charAt(0) == '+' && variable.contains("."))		
			{
				possign = 1;
				unsignedfloat = variable.substring(1) + "0";
			}
			else if(variable.charAt(0) == '+' && !variable.contains("."))		
			{
				possign = 1;
				unsignedfloat = variable.substring(1);
			}
			else if(variable.charAt(0) == '-' && variable.contains("."))
			{
				negsign = 1;
				unsignedfloat = variable.substring(1) + "0";
			}
			else if(variable.charAt(0) == '-' && !variable.contains("."))
			{
				negsign = 1;
				unsignedfloat = variable.substring(1);
			}
			else if((variable.charAt(0) != '-' && variable.charAt(0) != '+') && variable.contains("."))
			{
				unsignedfloat = variable + "0";
			}
			else 
			{
				unsignedfloat = variable; 
			}
			
			float finalfloat = Float.parseFloat(unsignedfloat);
		
			String finfloat = String.format("%." + numdecimals + "f", finalfloat);

			if(negsign == 1) 
			{
				adjustedfloat = "-" + finfloat; 
			}
			else if(possign == 1)
			{
				adjustedfloat = "+" + finfloat;
			}
			else 
			{
				adjustedfloat = finfloat;
			}

			if(adjustedfloat.length() < length)
			{
				//if length is less than what we want
				adjustlength = length - adjustedfloat.length();
				while(adjustlength > 0)
				{
					adjustedfloat = "#" + adjustedfloat;
					adjustlength--;
				}
				System.out.println(adjustedfloat);
			}
			else if(adjustedfloat.length() > length)
			{
				//if length is greater than what we want
				if(numdecimals!= 0)
				{
					while(numdecimals > 0)
					{
						greaterlength = "#" + greaterlength;
						numdecimals--; 
						length--;
					}
					greaterlength = "." + greaterlength;
					while(length > 1)
					{
						greaterlength = "#" + greaterlength;
						length--;
					}
					System.out.println(greaterlength);
				}
				else 
				{
					while(length > 0)
					{
						greaterlength = "#" + greaterlength;
						length--;
					}
					System.out.println(greaterlength);
				}
			}
			else
			{
				System.out.println(adjustedfloat);
			}
		}
	}
}
