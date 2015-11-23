package org.dalton.acsl2.search10;

/*
 * Darshan Desai
 * ASCL Competition 2
 */
import java.util.Scanner;
import java.util.Collections; 
import java.util.regex.*;
import java.util.Arrays;  
import java.util.List;  
import java.util.ArrayList;
public class Replacement 
{
	public static void main(String[] args) 
	{
		String input1, input2;
		String output="";
		Scanner scan= new Scanner(System.in);

		input1= scan.nextLine().trim();
		input1= input1.replace(" ", "");
		String[]inputone = input1.split(",");

		for (int f=0; f<5; f++)

		{
			input2=("    " +scan.nextLine()+ "    ");
			StringBuffer inputsb = new StringBuffer(input2);// makes the input2 into  a string buffer


			for(int i=4; i<input2.length(); i++)// for i less than input length minus four to account for padding, I++
			{
				if (inputsb.charAt(i-1)!='.')
				{
					if (inputsb.charAt(i)=='*')
					{   inputsb.replace(i,i+1, ".");
					inputsb.insert(i+1,"*");
					//System.out.println(inputsb);
					}
				}

			}
			for (int i=4; i<input2.length(); i++)
			{
				inputsb.toString().trim();

				if (inputsb.charAt(i)=='?')
				{
					inputsb.replace(i,i+1, ".");
					//System.out.println(inputsb);

				}
			}
			//System.out.println(inputsb);

			for (int g=0; g<inputone.length; g++)
			{
				Pattern x = Pattern.compile((inputsb.toString().trim()));			
				Matcher m = x.matcher((inputone[g]));
				boolean b = m.matches();

				if (b==true)
				{
					//System.out.println("Im true");
					output= output + inputone[g]+", ";
				}
				else if (b==false)
				{

				}

			}
			if (output!= "")
			{
				//output.toUpperCase();
				//System.out.println(output);
				System.out.println(output.substring(0,output.length()-2));
			}
			else 
			{
				System.out.println ("No Match");
			}
			output= "";
		}
	}
}