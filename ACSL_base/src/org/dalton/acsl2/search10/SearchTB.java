package org.dalton.acsl2.search10;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.StringBuffer;
/**
 * 
 *Thomas Bernstein
 *
 *The Dalton School
 *
 *9075
 */

public class SearchTB
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		String[] datax = data.split(", ");
		StringBuffer[] data1 = new StringBuffer[10];
		for(int i = 0; i<10; i++)
		{
			data1[i] = new StringBuffer(datax[i]);
		}
		for(int i = 0; i<5; i++)
		{
			String output = "";
			data=input.nextLine();
			int x = data.length();
			StringBuffer data0 = new StringBuffer(data);
			for(int a = 0; a<x; a++)
			{
				if(data.charAt(a)=='*')
				{
					data0.insert(a, '.');
					a++;
					x++;
				}
				else if(data0.charAt(a)=='?')
				{
					data0.setCharAt(a, '.');
				}
				data = data0.toString();
			}
			for(int a = 0; a<10; a++)
			{
				if(Pattern.matches(data, data1[a]))
				{
					output = output+ data1[a] + ", ";
				}
			}
			if(output!="")
			{
				System.out.println(output);
			}
			else
			{
				System.out.println("No Match");
			}
		}
	}
}