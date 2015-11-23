package org.dalton.acsl2.search10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class ACSLSolution {
	private static String[] searchterms = new String[10];
	private static final boolean debug = false;
	private static final boolean setSearchterms = true; //for normal functionarlity this is ON
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		String ginormoString;
		if(setSearchterms)
		{
			ginormoString = scan.nextLine();
		}
		if(!setSearchterms)
		{
			ginormoString = "2BELLS, T4LLS, FALLS, DOL3LS, DUL7LS, DOLLIES, BELLY, BELLIES, TELLY, DELL";
		}
		searchterms = ginormoString.split(", ");
		if(debug)
		{
			System.out.println("Enter Your SearchTerms");
			System.out.println("Hello and welcome to your parser \u003F \u005B \u005D \u002A");
		}	
		if(debug)
		{
			for(int i = 0; i < searchterms.length; i++ )
			{

				System.out.println(searchterms[i]);

			}System.out.println(searchterms.length);
		}

		for(int p = 0; p < 5; p++)
		{
			PrintArrayList(result(scan.nextLine()));

		}



		// REMEMBER TO PRINT NO MATCH NOT NULL HEY YOU!
	}
	private static ArrayList<String> result(String parseMe)
	{

		StringBuffer pM = new StringBuffer(parseMe);

		//parseMe.

		/*

		Pattern findQuestionArgs = Pattern.compile("\u003F");
		Matcher fQ = findQuestionArgs.matcher(parseMe); // matches any single character

		Pattern findStarArgs = Pattern.compile("\u002A");
		Matcher fS = findStarArgs.matcher(parseMe); //matches and  or more characters
		 */
		//Pattern findBracketArgs = Pattern.compile("\005B.-.\005D");
		//Matcher fB = findBracketArgs.matcher(input); //Matches a single digit in the range a to b inclusiv
		StringBuffer newRegexExpression = new StringBuffer();
		for(int i = 0; i < pM.length(); i++ )
		{
			//Matcher fb = findBracketArgs.matcher(pM.substring(i, i+5));

			if(pM.charAt(i) == '?')
			{
				newRegexExpression.append(".");
			}
			else if(pM.charAt(i) == '*')
			{
				newRegexExpression.append(".*");
			}
			/*
			else if(pM.charAt(i) == '[')
			{

				String insideBracks = pM.substring(i, i+5);
				int a = insideBracks.charAt(1);
				int b = insideBracks.charAt(3);

				newRegexExpression.append(pM.substring(i, i+5));
			}
			 */
			else
			{
				newRegexExpression.append(pM.charAt(i));
			} //else
		} //for
		if(debug) 
		{
			System.out.println(newRegexExpression);
		}
		ArrayList<String> answers = new ArrayList<String>();
		Pattern createdPattern = Pattern.compile(newRegexExpression.toString(), Pattern.CASE_INSENSITIVE);
		boolean noMatch = true;
		for(int c = 0; c < searchterms.length; c++)
		{
			Matcher createdMatch = createdPattern.matcher(searchterms[c]);
			if(createdMatch.matches())
			{
				answers.add(searchterms[c]);
				noMatch = false;
			}
		}
		if(noMatch)
		{
			answers.add("No Match");
		}
		return answers;
	}
	private static void PrintArrayList(ArrayList<String> poop)
	{
		for(int i = 0; i < poop.size(); i++)
		{
			if(i != 0)
			{
				System.out.print(", ");
			}
			System.out.print(poop.get(i));
		}
		System.out.println("");
	}
}
