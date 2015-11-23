package org.dalton.acsl2.bits11;
/*
 * Name:Johnny Kruger
 * School: Dalton
 * School Code: 3055
 */
import java.util.Scanner;
public class bitProgramJK {

	private final static int totalInputs = 5;
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		String result = "";
		for(int c = 0; c < totalInputs; c++)
		{
			String[] theInput = in.nextLine().split(", ");

			result = finalMatchup(createTable(theInput));
			if(isNONE(result, Integer.parseInt(theInput[0])))
				System.out.println("NONE");
			else
				System.out.println(result);
		}
	}
	private static String[] createTable(String[] data)
	{
		String[] converter = new String[data.length - 1];
		for(int i = 1; i < data.length; i++)
			converter[i - 1] = data[i];
		return converter;
	}
	private static String finalMatchup(String[] newTable)
	{
		String result =  "";
		for(int a = 0; a < newTable[0].length(); a++)
		{
			char theMatch = newTable[0].charAt(a);
			boolean matches = true;
			for(int b = 0; b < newTable.length; b++)
				if(newTable[b].charAt(a) != theMatch)
				{
					matches = false;
					break;
				}
			if(!matches)
				result += "*";
			else
				result += theMatch;
		}
		return result;
	}
	private static boolean isNONE(String output, int numberOf)
	{
		int other = 0;
		for(char i : output.toCharArray())
			if(i == '*')
				other++;
		if(((int) Math.pow(2, other)) == numberOf)
			return false;
		return true;
	}
}