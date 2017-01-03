package org.dalton.acsl4.regexp15;
import java.util.Scanner;

/**********
 * Name: Jamie Konigsberg
 * Purpose: Complete ACSL4
 * Date: 04/18/16
 */

public class ACSL4_REGEXP15_JK {

	public static void main(String[] args)
	{	 
		Scanner s = new Scanner(System.in); //declare scanner to take in input 
		String [] values = s.nextLine().split(", ");
		for(int i = 0; i < 5; i++)
		{
			boolean tf = true;
			String potentials = s.nextLine();
			String results = "";
			String alternative = "";
			for(int j = 0; j < values.length; j++)
			{
				if(potentials.equals("#"))
				{
					if(values[j].equals("#"))
					{
						results = results + "#" + ", ";
						tf = false;
					}
				}
				else
				{
					if(values[j].equals("#"))
					{
						if(alternative.matches(potentials))
						{
							results = results + "#" + ", ";
							tf = false;
						}		
					}
					else if(values[j].matches(potentials))
					{
						results = results + values[j] + ", ";
						tf = false; 
					}
				}
			}
			if(tf == true)
			{
				System.out.println("NONE");
			}
			else if(results.contains(",")) 
			{
				results = results.substring(0, results.length()-2);
				System.out.println(results);
			}
		}
	}
}