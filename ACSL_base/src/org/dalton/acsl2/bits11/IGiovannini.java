package org.dalton.acsl2.bits11;


import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;


public class IGiovannini{

	public static void main(String[] args) 
	{
		//need to take first number of each line and make that the length of the array
		//need to make each subsequent number one row of the array

		int times = 0;
		String input = "";
		Scanner scan = new Scanner(System.in);

		while (times < 5)
		{				
			//System.out.println("enter line of data:");
			input = scan.nextLine();

			String input1_array[] = input.split(", ");
		
			//separating each entry in a line into digits and putting them in an array
			int real_array[][] = new int [Integer.parseInt(input1_array[0])][(input1_array[1]).length()];
			//System.out.println("input1_array[1]" + input1_array[1]);
			//System.out.println("input1_array[2]" + input1_array[2]);
		
			//filling out all of the array
			for(int rownumber = 0; rownumber<Integer.parseInt(input1_array[0]); rownumber++)
			{
				char row[] = input1_array[rownumber+1].toCharArray();
				//going through each row
				for (int column = 0; column<(input1_array[1]).length(); column++)
				{
					//System.out.println("line 60");

					real_array[rownumber][column] = Character.digit(row[column], 10);
					//System.out.println(Character.digit(row[column], 10));
				}
			}

			boolean containsone = false;
			String output = "";

			for(int column=0; column<input1_array[1].length(); column++)
			{
				//System.out.println("in for loop");
				//determines whether there is a one in the column

				//System.out.println("the length of real_array is: " + real_array.length);

				for(int i=0; i<real_array.length; i++) //rownumbers
				{	
					//System.out.println("105");
					//System.out.println(real_array[column][i]);

					if(real_array[i][column] == 1)
					{
						//System.out.println("there is a one in column = " + column);
						containsone = true;
					}
				}

				//if there is a one in the column
				if(containsone == true)
				{
					//System.out.println("containsone == true for column " + column);
					for(int i = 0; i<real_array.length; i++)
					{
						real_array[i][column] = -(real_array[i][column]);
						//System.out.println("making all ones negative for column " + column + "and row " +i);

					}

					int sum = 0;
					for(int i = 0; i<real_array.length; i++)
					{
						if(real_array[i][column]==0)
						{
							sum = sum + 1;
						}
						else
						{
							sum = sum + (real_array[i][column]);
						}
						//System.out.println("sum is now " + sum);
					}
					if(sum == 0)
					{
						//System.out.println("sum equaled 0");
						output = output + "*";
					}
					if(sum<0)
					{
						//System.out.println("sum equaled < 0");
						output = output + "1";
					}
				}
				//if there is no one in the column
				if(containsone == false)
				{
					//System.out.println("there is no one in column = " + column);
					//System.out.println("output before adding zero is " + output);
					output = output + "0";
				}
				
				containsone = false;

			}
			double asterixes=0; 
			//counting the number of asterixes in output
			for(int i=0;i<output.length(); i++)
			{
				if(output.charAt(i)=='*')
				{
					asterixes++;
				}
			}
			
			if(asterixes==0)
			{
				//System.out.println("no asterixes");
			}
			
			//output will be NONE if not only the given strings are represented by output
			if(asterixes!=0 && Math.pow(2, asterixes) != Double.parseDouble(input1_array[0]))
			{
				output = "NONE";
			}
			times++;
			System.out.println(times + ". " + output);

			
		}

	}

}

