/** Anne Madoff
 * The Dalton School
 * ACSL
 * 9010
 * */

package org.dalton.acsl4.stacks09;

import java.util.Scanner;

public class acslStacksAndQueues {static //opens class
	int howmany = 0;
	public static String sbGoesToString(StringBuffer rowarray)
	{//opens public static String arrayGoesToString
		String convertedString = "";//declares new string
		for (int i = 0; i < rowarray.length(); i++) 
		{//opens for
			if(i == rowarray.length()-1)
			{
				convertedString = convertedString + rowarray.charAt(i);
			}
			else
			{
			convertedString = convertedString + rowarray.charAt(i)+ ", ";//parses array to string
			}
		}//closes for
		return convertedString;//returns array as string
	}//closes public static String arrayGoesToString

	
	public static void whatCommand(String[] lineArray, StringBuffer letters, int index, int counter)
	{
		if(lineArray[index].substring(0, 3).equals("SWH"))
		{
			if(lineArray[0].equals("S"))
			{
				lineArray[0] = "Q";
			}

			else
			{
				lineArray[0] = "S";
			}

			sOrQ(lineArray);
		}
		
		else if(lineArray[index].substring(0, 4).equals("POPS"))
		{
			for(int i = 0; i<Integer.parseInt(lineArray[index].substring(5)); i++)
			{
				letters.deleteCharAt(letters.length()-1);
			}
		}

		else if(lineArray[index].substring(0, 4).equals("POPQ"))
		{
			for(int i = 0; i<Integer.parseInt(lineArray[index].substring(5)); i++)
			{
				letters.deleteCharAt(0);
			}
		}

		else if(lineArray[index].substring(0,3).equals("PSH"))
		{
			letters.append(lineArray[index].substring(4));
		}

		else if(lineArray[index].substring(0,3).equals("DUP"))
		{
			String whatAdd = "";

			for(int i = 0; i<Integer.parseInt(lineArray[index].substring(4)); i++)
			{
				whatAdd = whatAdd + letters.charAt(i);
			}

			letters.append(whatAdd);
		}

		else if(lineArray[index].substring(0,3).equals("SWP"))
		{
			String endOne = "";
			String endTwo = "";

			for(int i = 0; i<Integer.parseInt(lineArray[index].substring(4)); i++)
			{
				endOne = endOne + letters.charAt(i);
			}

			for(int i = (letters.length()-Integer.parseInt(lineArray[index].substring(4))); i<letters.length(); i++)
			{
				endTwo = endTwo + letters.charAt(i);
			}

			for(int i = (letters.length()-Integer.parseInt(lineArray[index].substring(4))); i<letters.length()+1; i++)
			{
				letters.deleteCharAt(letters.length()-1);
			}

			for(int i = 0; i<endOne.length(); i++)
			{
				letters.deleteCharAt(0);
			}

			letters.append(endOne);
			letters.insert(0, endTwo);

		}

	

		else if(lineArray[index].substring(0, 3).equals("CRC"))
		{
			String moved = "";
			if(lineArray[0].equals("Q"))
			{
				for(int i = 0; i<Integer.parseInt(lineArray[index].substring(4)); i++)
				{
					moved = moved + letters.charAt(i);
				}

				for(int i = 0; i<moved.length(); i++)
				{
					letters.deleteCharAt(0);
				}

				letters.append(moved);
			}

			else
			{
				for(int i = (letters.length()-Integer.parseInt(lineArray[index].substring(4))); i<letters.length(); i++)
				{
					moved = moved + letters.charAt(i);
				}

				for(int i = (letters.length()-Integer.parseInt(lineArray[index].substring(4))-1); i<letters.length()+1; i++)
				{
					letters.deleteCharAt(letters.length()-1);
				}

				letters.insert(0, moved);
			}

		}

		else if(lineArray[index].substring(0, 3).equals("INS"))
		{
			if(lineArray[0].equals("S"))
			{
				int offset = Integer.parseInt(lineArray[index].substring(4,5));
				letters.insert((letters.length()-offset)+1, lineArray[index].substring(6));
			}

			else
			{
				letters.insert(Integer.parseInt(lineArray[index].substring(4,5))-1, lineArray[index].substring(6));
			}
		}

		else if(lineArray[index].substring(0, 3).equals("PIN"))
		{
				letters.insert(0,lineArray[index].substring(4));
		}

		else if(lineArray[index].substring(0, 5).equals("SRT a"))
		{
			char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			int[] numerical = new int[letters.length()];
			String sorted = "";

			int n = 0;

			for(int i = 0; i<letters.length(); i++)
			{
				for(int j = 0; j<alphabet.length; j++)
				{
					if(letters.charAt(i)==alphabet[j])
					{
						numerical[n] = j;
					}
				}
				n++;
			}

			int temp = 0;
			for(int i =0; i<numerical.length-1; i++)
			{
				for(int j=0; j<numerical.length-1; j++)
				{
					if(numerical[j]>numerical[j+1])
					{
						temp = numerical[j];
						numerical[j] = numerical[j+1];
						numerical[j+1] = temp;
					}
				}
			}

			for(int k = 0; k<numerical.length; k++)
			{
				sorted = sorted + alphabet[numerical[k]];
			}

			letters.replace(0, letters.length(), sorted);
		}

		else if(lineArray[index].substring(0, 5).equals("SRT d"))
		{
			char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			int[] numerical = new int[letters.length()];
			String sorted = "";

			int n = 0;

			for(int i = 0; i<letters.length(); i++)
			{
				for(int j = 0; j<alphabet.length; j++)
				{
					if(letters.charAt(i)==alphabet[j])
					{
						numerical[n] = j;
					}
				}
				n++;
			}

			int temp = 0;
			for(int i =0; i<numerical.length-1; i++)
			{
				for(int j=0; j<numerical.length-1; j++)
				{
					if(numerical[j]>numerical[j+1])
					{
						temp = numerical[j];
						numerical[j] = numerical[j+1];
						numerical[j+1] = temp;
					}
				}
			}

			for(int k = 0; k<numerical.length; k++)
			{
				sorted = sorted + alphabet[numerical[k]];
			}

			letters.replace(0, letters.length(), sorted);
			letters.reverse();
		}

		else if(lineArray[index].substring(0, 3).equals("PRT"))
		{
			if(lineArray[0].equals("Q"))
			{
				StringBuffer sb = new StringBuffer(letters.substring(0,Integer.parseInt(lineArray[index].substring(4))));
				System.out.println(counter + ". " + sbGoesToString(sb));
			}

			else
			{
				StringBuffer sb = new StringBuffer(letters.substring(letters.length()-Integer.parseInt(lineArray[index].substring(4)), letters.length()));
				System.out.println(counter + ". " + sbGoesToString(sb));
			}
		}

		else
		{
			//System.out.println("Error: No command matched. Index = " + index);
		}
	}

	public static void sOrQ(String[] lineArray)
	{
		if(lineArray[0].equals("S"))
		{
			for(int i = 1; i<lineArray.length; i++)
			{
				if(lineArray[i].length()>3&&lineArray[i].substring(0, 4).equals("POPQ"))
				{
					lineArray[i]= "POPS "+ lineArray[i].substring(5);
				}

				else if(lineArray[i].substring(0, 3).equals("POP"))
				{
					lineArray[i]= "POPS "+ lineArray[i].substring(4);
				}

			}
		}

		if(lineArray[0].equals("Q"))
		{
			for(int i = 1; i<lineArray.length; i++)
			{
				if(lineArray[i].length()>3&&lineArray[i].substring(0, 4).equals("POPS"))
				{
					lineArray[i]= "POPQ "+ lineArray[i].substring(5);
				}

				else if(lineArray[i].substring(0, 3).equals("POP"))
				{
					lineArray[i]= "POPQ "+ lineArray[i].substring(4);
				}


			}
		}

	}

	public static void process(String[] lineArray)
	{
		howmany++;
		StringBuffer letters = new StringBuffer("ABCDE");

		sOrQ(lineArray);

		for(int i =1; i<lineArray.length; i++)
		{
			whatCommand(lineArray, letters, i, howmany);
		}

	}

	public static void main(String[] args) 
	{//opens main

		Scanner input = new Scanner(System. in);

		System.out.println("Please enter line one.");
		StringBuffer input1 = new StringBuffer(input.nextLine());
		for(int j=0; j<input1.length()-3; j++)
		{
			if(input1.substring(j,j+3).equals("INS"))
			{
				input1.deleteCharAt(j+6);
			}
		}
		String[] line1 = input1.toString().split(", ");//parses string of elements to 1-D matrix of elements

		System.out.println("Please enter line two.");
		StringBuffer input2 = new StringBuffer(input.nextLine());
		for(int g=0; g<input1.length()-3; g++)
		{
			if(input2.substring(g,g+3).equals("INS"))
			{
				input2.deleteCharAt(g+6);
			}
		}
		String[] line2 = input2.toString().split(", ");//parses string of elements to 1-D matrix of elements

		System.out.println("Please enter line three.");
		StringBuffer input3 = new StringBuffer(input.nextLine());
		for(int l=0; l<input3.length()-3; l++)
		{
			if(input3.substring(l,l+3).equals("INS"))
			{
				input3.deleteCharAt(l+6);
			}
		}
		String[] line3 = input3.toString().split(", ");//parses string of elements to 1-D matrix of elements

		System.out.println("Please enter line four.");
		StringBuffer input4 = new StringBuffer(input.nextLine());
		for(int x=0; x<input4.length()-3; x++)
		{
			if(input4.substring(x,x+3).equals("INS"))
			{
				input4.deleteCharAt(x+6);
			}
		}
		String[] line4 = input4.toString().split(", ");//parses string of elements to 1-D matrix of elements

		System.out.println("Please enter line five.");
		StringBuffer input5 = new StringBuffer(input.nextLine());
		for(int z=0; z<input5.length()-3; z++)
		{
			if(input5.substring(z,z+3).equals("INS"))
			{
				input5.deleteCharAt(z+6);
			}
		}
		String[] line5 = input5.toString().split(", ");//parses string of elements to 1-D matrix of elements

		process(line1);
		process(line2);
		process(line3);
		process(line4);
		process(line5);

	}//closes main
}//closes class
