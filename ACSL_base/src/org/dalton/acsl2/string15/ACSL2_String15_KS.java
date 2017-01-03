package org.dalton.acsl2.string15;
import java.util.Scanner;


public class ACSL2_String15_KS 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		while(true)
		{	
			String input = scan.nextLine();
			String[] in = input.trim().split(" *, *");
			
			int l = Integer.valueOf(in[1]);
			int d = Integer.valueOf(in[2]);
			
			System.out.print(STR(in[0], l, d));
		}
	}
	
	
	public static String STR(String input, int length, int decimal) 
	{
		int decimalposition = 0;
		int leftoverhashtags = 0;
		String rounded = "";
		int numhashtags = 0; 
		String output = "";
		int expectedlength = 0;
		String newstring = "";
		String roundednewstring = "";
		String roundedoriginput = "";
		
		//CASE 1
		decimalposition = input.indexOf('.');
		if (decimalposition+1+decimal > length)
		{
			output = ".";
			for (int i = 0; i < decimal; i++)
			{
				output = output + "#";
			}
			
			leftoverhashtags = length - output.length();
			
			for (int j = 0; j < leftoverhashtags; j++)
			{
				output = "#" + output;
			}
		}
		
		//CASE 2
		else if (length > input.length())
		{
			float incoming = Float.valueOf(input);
			
			//round incoming, convert incoming to string
			rounded = String.format("%." + decimal + "f", incoming);	
			
			numhashtags = length-rounded.length(); //find the length of that string
			output = rounded;
			for (int i = 0; i < numhashtags; i++)
			{
				output = "#" + output;
			}
		}
		
		//CASE 3
		else
		{
			if ((input.charAt(0) == '+') || (input.charAt(0) == '-'))
			{
				expectedlength = length - 1;
				newstring = input.substring(1);
				
				float incoming = Float.valueOf(newstring);
				
				roundednewstring = String.format("%." + decimal + "f", incoming);
				output = String.valueOf(input.charAt(0)) + roundednewstring;
			}
			
			else
			{
				float incoming = Float.valueOf(input);
				
				roundedoriginput = String.format("%." + decimal + "f", incoming);
				output = roundedoriginput;
			}
		}
		
		return output;
	}
}