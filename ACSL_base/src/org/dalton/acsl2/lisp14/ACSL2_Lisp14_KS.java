package org.dalton.acsl2.lisp14;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class ACSL2_Lisp14_KS 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);			//takes the values in 
		char[] manipulatethisstring;
		int parenthesislevel = 0;
		boolean sublist = false;
		String[] sublists; 
		int numsublists = 0;
		int startsublistindex = 0;
		int finalsublistindex = 0;
		boolean finalindexfound = false;
		String[] parts = null;

		manipulatethisstring = scan.nextLine().toCharArray();

		for (int i = 0; i < manipulatethisstring.length; i++)
		{
			if (manipulatethisstring[i] == '(')
			{
				parenthesislevel++;
			}
			if (parenthesislevel == 2)
			{
				startsublistindex = i;
				sublist = true;
				break;
			}
		}

		for (int j = 0; j < manipulatethisstring.length; j++)
		{
			if (manipulatethisstring[j] == ')')
			{
				numsublists++;
			}
		}
		numsublists = numsublists - 1;

		while (finalindexfound == false)
		{
			for (int m = 0; m < manipulatethisstring.length; m++)
			{
				if (manipulatethisstring[m] == ')' && manipulatethisstring[m-1] == ')')
				{
					finalsublistindex = m;
					finalindexfound = true;
					//break;
				}
			}
		}

		if (sublist == true)
		{
			String subliststring = new String(manipulatethisstring, startsublistindex, finalsublistindex-startsublistindex);

			//System.out.println(subliststring);
			parts = subliststring.split("(?<=\\))" + " ");

			//System.out.println(parts[0]);
			//System.out.println(parts[1]);
			//System.out.println(parts[2]);
			//System.out.println(parts[3]);
			//System.out.println(parts[4]);
		}

		String input = "";
		int i = 1;
		while(true) 
		{
			System.out.println(" ");				//parsing to separate each component part into variables
			input = scan.nextLine();
			String[] parsed = input.split(" ");

			//String delims = " ";
			//String[] parsed = input.split(delims);

			String operator = parsed[0];

			if (parsed.length == 3)
			{
				int operandone = Integer.parseInt(parsed[1]);
				int operandtwo = Integer.parseInt(parsed[2]);

				if (operator.equals("SORT") == true)
				{
					for (int a = 0; a < startsublistindex; a++)
					{
						System.out.print(manipulatethisstring[a]);
					}
					sort(parts, operandone, operandtwo);		
					for (int b = finalsublistindex; b < manipulatethisstring.length; b++)
					{
						System.out.print(manipulatethisstring[b]);
					}
				}
				else if (operator.equals("REVERSE") == true)
				{
					for (int c = 0; c < startsublistindex; c++)
					{
						System.out.print(manipulatethisstring[c]);
					}
					reverse(parts, operandone, operandtwo);  		
					for (int d = finalsublistindex; d < manipulatethisstring.length; d++)
					{
						System.out.print(manipulatethisstring[d]);
					} 		
				}
				else if (operator.equals("REMOVE") == true)
				{
					for (int a = 0; a < startsublistindex; a++)
					{
						System.out.print(manipulatethisstring[a]);
					}
					remove(parts, operandone, operandtwo);		
					for (int b = finalsublistindex; b < manipulatethisstring.length; b++)
					{
						System.out.print(manipulatethisstring[b]);
					}
				}
			}

			if (operator.equals("COUNT") == true)
			{
				count(parts);
			}

			if (operator.equals("MAXIMUM") == true)
			{
				maximum(parts);
			}
		}

	}

	static void sort(String[] manipulatethis, int start, int finish)
	{	
		String[] sorted = new String[finish-start+1];

		int j = 0;
		for (int i = start - 1; i < finish; i++) 		//filling the array that must be sorted
		{
			sorted[j] = manipulatethis[i];
			j++;
		}

		Arrays.sort(sorted);	//sorting the array

		for (int k = 0; k < start - 1; k++)
		{
			System.out.print(manipulatethis[k] + " ");
		}

		for (int l = 0; l < sorted.length; l++)
		{
			if (l + start == manipulatethis.length)
			{
				System.out.print(sorted[l]);
			}
			else
			{
				System.out.print(sorted[l] + " ");
			}
		}

		for (int z = finish; z < manipulatethis.length; z++)
		{
			if (z == manipulatethis.length-1)
			{
				System.out.print(manipulatethis[z]);
			}
			else 
			{
				System.out.print(manipulatethis[z] + " ");
			}
		}
	}

	static void reverse(String[] manipulatethis, int start, int finish)
	{
		String[] reversethis = new String[finish-start+1];

		int j = 0;
		for (int i = start - 1; i < finish; i++) 		//filling the array that must be sorted
		{
			reversethis[j] = manipulatethis[i];
			j++;
		}

		Collections.reverse(Arrays.asList(reversethis));

		for (int k = 0; k < start - 1; k++)
		{
			System.out.print(manipulatethis[k] + " ");
		}
		
		for (int l = 0; l < reversethis.length; l++)
		{
			//String[] parsed = reversethis[l].split(" ");

			String delims = "[ )]+";
			String[] parsed = reversethis[l].split(delims);

			String[] parsethis = new String[parsed.length-1];
			for (int m = 1; m < parsed.length; m++)
			{	
				parsethis[m-1] = parsed[m];
			}

			//System.out.println(Arrays.asList(parsethis));

			Collections.reverse(Arrays.asList(parsethis));
			
			System.out.print(reversethis[l] = parsed[0]);
			for (int n = 0; n < parsethis.length; n++)
			{
				System.out.print(" " + parsethis[n]);				//prints reversed strand of inputted array
			}
			if (l + start == manipulatethis.length)
			{
				System.out.print(")");
			}
			else
			{
				System.out.print(") ");
			}
			
			//System.out.println(Arrays.toString(parsethis));
			//System.out.print(reversethis[l]);
		}
		for (int z = finish; z < manipulatethis.length; z++)
		{
			if (z == manipulatethis.length - 1)
			{
				System.out.print(manipulatethis[z]);
			}
			else 
			{
				System.out.print(manipulatethis[z] + " ");
			}
		}
	}

	static void count(String[] manipulatethis)
	{
		System.out.println(manipulatethis.length);	
	}

	static void remove(String[] manipulatethis, int start, int finish)
	{
		String[] finalprint = new String[manipulatethis.length-(finish-start+1)];

		//System.out.println(start);
		for (int i = 0; i < start - 1; i++)
		{
			finalprint[i] = manipulatethis[i];
		}

		//System.out.println(finish+1);
		for (int j = finish; j < manipulatethis.length; j++)
		{
			//System.out.println("here: " + manipulatethis[j]);
			finalprint[start-1] = manipulatethis[j];
			start++;
		}

		for (int k = 0; k < finalprint.length; k++)
		{
			if (k == finalprint.length-1)
			{
				System.out.print(finalprint[k]);
			}
			else
			{
				System.out.print(finalprint[k] + " ");
			}
		}
	}

	static void maximum(String[] manipulatethis)
	{
		String s = manipulatethis[0];
		int numarguments = s.replaceAll("\\D ", "").length();
		int index = 0;

		for (int i = 1; i < manipulatethis.length; i++)
		{
			String g = manipulatethis[i];

			if (g.replaceAll("\\D ", "").length() > numarguments)
			{
				numarguments = g.replaceAll("\\D ", "").length();
				index = i;
			}
		}

		System.out.println(manipulatethis[index]);
	}

}