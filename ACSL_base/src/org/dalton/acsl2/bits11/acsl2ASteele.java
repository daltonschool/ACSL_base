package org.dalton.acsl2.bits11;

import java.util.Scanner;


public class acsl2ASteele{

	/**
	 * Annelise Steele
	 * Junior
	 * The Dalton School
	 */
	public static void main(String[] args)

	{
		Scanner input = new Scanner(System.in);
		String numbers = "";
		String data[];
		String result = "";
		int counter= 0;
		int pos=0;
		int end=1;
		int wholeloop = 0;

		while(wholeloop<5)
		{	
			numbers = input.nextLine();
			data = numbers.split(",");
			pos =0;
			end=1;
			result="";
			counter = 0;
			
			for(int a = 0; a < data[1].length(); a++)
			{
				boolean regionMatches = true;
				for(int i=2; i <data.length; i++)
				{

					if(data[1].substring(a,a+1).equals(data[i].substring(a,a+1))) //substr(through digits)
					{

					}
					else
					{
						regionMatches = false;
					}
				}	
				if(regionMatches == true)
				{
					result += data[1].substring(a, a+1);
				}
				if(regionMatches == false)
				{
					result += "*";

				}
			}

			for(int i=0; i <result.length(); i++)
			{	
				if(result.substring(pos,end).equals("*"))	
				{
					counter++;
				}
				pos++;
				end++;
			}	

			if(counter==1 && data[0].equals("2"))
			{
				System.out.println(result);
			}
			else if(counter==2&& data[0].equals("4"))
			{
				System.out.println(result);
			}
			else if(counter==3&& data[0].equals("8"))
			{
				System.out.println(result);
			}
			else //if all conditions are false that has to be true
			{
				System.out.println("NONE");
			}
			
			wholeloop++;
		}//while
	
	}//main	
}//pgm
