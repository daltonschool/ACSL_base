package org.dalton.acsl2.search10;

import java.util.ArrayList;
import java.util.Scanner;

public class Contest2try3 {

	/**
	 * Cara Haas
	 * The Dalton School
	 * 9075
	 * 
	 */

	public static void main(String[] args) {

		Contest2try3 contest=new Contest2try3();
		//taking in input
		Scanner takeIn = new Scanner(System.in);
		String[] inputs=new String[6];
		String[] line1=new String[10];

		for(int i=0; i<6; i++)
		{
			inputs[i]=takeIn.nextLine();
		}

		for(int i=0; i<10; i++)
		{
			line1=inputs[0].split(", ");
		}

		int counter=0;
		for(int i=1; i<6; i++)
		{
			ArrayList <String> matches=new ArrayList <String>();
			matches=contest.finding(inputs[i], line1);

			if(matches.size()==0)
			{
				System.out.println("No Match");
			}
			if(matches.size()!=0)
			{	
				for(int j=0; j<matches.size()-1; j++)
				{
					System.out.print(matches.get(j) + ", ");
				}
				System.out.print(matches.get(matches.size()-1));
				System.out.println("");
			}
			counter++;
		}
	}

	//methods

	public boolean longSteps(boolean tester, String[] tenWords, String word, int i, int wordPos, int j, int jMax, int wordPosMax)
	{
		boolean test=tester;
		while(j<tenWords[i].length() && wordPos<wordPosMax && j<jMax)
		{
			if(tenWords[i].charAt(j)==word.charAt(wordPos))
			{ 

			}
			else if(word.charAt(wordPos)==('?'))
			{
				if(!Character.isLetterOrDigit(tenWords[i].charAt(j)))
				{
					test=false;
				}
			}
			else if(word.charAt(wordPos)==('['))
			{
				ArrayList <Integer> values=new ArrayList <Integer>();
				int cara=Character.getNumericValue(word.charAt(wordPos+1));
				int limit=Character.getNumericValue(word.charAt(wordPos+3));
				for(int m=cara ; m<limit+1; m++)
				{
					values.add(m);
				}
				
				if(!Character.isDigit(tenWords[i].charAt(j)))
				{
					test=false;
				}
				else
				{
					if(!values.contains(Character.getNumericValue(tenWords[i].charAt(j))))
					{
						test=false;
					}
					else
					{
						wordPos=wordPos+4;
					}
				}
			}

			else
			{
				test=false;
			}
			j++;
			wordPos++;
		}

		return test;
	}

	public boolean containing(String word)
	{
		boolean returning=false;
		if(word.contains("["))
		{
			returning=true;
		}
		else if(word.contains("*"))
		{
			returning=true;
		}

		return returning;
	}

	public int changeLength(String word)
	{
		int newLength=word.length();
		for(int i=0; i<word.length(); i++)
		{
			if(word.charAt(i)=='[')
			{
				newLength=newLength-4;
			}
			else if(word.charAt(i)=='*')
			{
				newLength--;
			}
		}

		return newLength;
	}

	public ArrayList <String> finding(String word, String[] tenWords)
	{ 
		ArrayList <String> returning=new ArrayList <String>();
		for(int i=0; i<10; i++)
		{
			boolean test=true;

			int wordPos=0;
			int wordPosMax=word.length();
			int j=0;
			int jMax=tenWords[i].length();
			if(tenWords[i].length()<this.changeLength(word))
			{
				test=false;	
			}
			else if(word.charAt(0)==('*') && word.charAt(word.length()-1)==('*'))
			{	
				String newWord=word.substring(1, word.length()-1);
				int jCalc=0;
				int newLength=this.changeLength(newWord);
				for(int jMaxCalc=newLength; jMaxCalc<tenWords[i].length()+1; jMaxCalc++)
				{
					test=true;
					test=this.longSteps(test, tenWords, newWord, i, wordPos, jCalc, jMaxCalc, wordPosMax);	

					if(test==true)
					{
						returning.add(tenWords[i]);
						break;
					}

					jCalc++;
				}
				test=false;
			}
			else if(word.charAt(0)=='*') //do ends with
			{
				int newLength=this.changeLength(word);
				int jCalc=tenWords[i].length()-newLength;
				String newWord=word.substring(1, word.length());
				if(jCalc>=0)
				{	
					test=this.longSteps(test, tenWords, newWord, i, wordPos, jCalc, jMax, wordPosMax);
				}
			}

			else if(word.charAt(word.length()-1)=='*') //do start with
			{
				jMax=word.length();
				
				test=this.longSteps(test, tenWords, word, i, wordPos, j, jMax, wordPosMax);
			}

			else if(word.length()==tenWords[i].length()&& this.containing(word)==false)
			{
				test=this.longSteps(test, tenWords, word, i, wordPos, j, jMax, wordPosMax);
			}

			else if(word.contains("[")&& this.changeLength(word)==tenWords[i].length())
			{
				if(test==true)
				{
				}
			}
			else
			{
				test=false;
			}

			if(test==true)
			{
				returning.add(tenWords[i]);
			}
		}
		return returning;
	}
}