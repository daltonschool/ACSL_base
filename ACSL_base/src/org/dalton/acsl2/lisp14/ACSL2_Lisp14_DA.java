package org.dalton.acsl2.lisp14;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.event.ListSelectionEvent;


public class ACSL2_Lisp14_DA
{
	/*
	 * Name: Dillon Azzam
	 * School: The Dalton School
	 * Code: 3305
	 * 
	 */
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		final String lispInputRaw=scan.nextLine();
		String processedLispInput=lispInputRaw.substring(1, lispInputRaw.length()-1).replace(")","");
		
		Boolean isSublist=false;
		String[] lispElements=processedLispInput.split("\\(");
		String initialElement=lispElements[0];
		final String[] sublists=Arrays.copyOfRange(lispElements, 1, lispElements.length);
		
		for(int i=0; i<sublists.length; i++)
		{
			sublists[i]=sublists[i].trim();
		}
		
//		System.out.println(lispInputRaw);
//		System.out.println(processedLispInput);
//		System.out.println(Arrays.toString(sublists));
		
		for(int i=0; i<5; i++)
		{
			String command=scan.nextLine().toUpperCase();
			String[] commandElements=command.split(" ");
			if(commandElements[0].contains("COUNT"))
			{
				System.out.println(count(sublists));
			}
			else if(commandElements[0].contains("MAXIMUM"))
			{
				System.out.println("("+maximum(sublists)+")");
			}
			else if(commandElements[0].contains("SORT"))
			{
				System.out.println("("+initialElement+sort(sublists, Integer.parseInt(commandElements[1]), Integer.parseInt(commandElements[2]))+")");
			}
			else if(commandElements[0].contains("REMOVE"))
			{
				System.out.println("("+initialElement+remove(sublists, Integer.parseInt(commandElements[1]), Integer.parseInt(commandElements[2]))+")");
			}
			else if(commandElements[0].contains("REVERSE"))
			{
				System.out.println("("+initialElement+reverse(sublists, Integer.parseInt(commandElements[1]), Integer.parseInt(commandElements[2]))+")");
			}
		}
	}
	
	public static String count(String[] sublists)
	{
		return Integer.toString(sublists.length);
	}
	
	public static String maximum(String[] sublists)
	{
		int longestIndex=0;
		int longestLength=0;
		
		for(int i=0; i<sublists.length; i++)
		{
			String[] sublistElements=sublists[i].split(" ");
			sublistElements=Arrays.copyOfRange(sublistElements, 1, sublistElements.length);
			if(sublistElements.length>longestLength)
			{
				longestIndex=i;
				longestLength=sublistElements.length;
			}
		}
		
		return sublists[longestIndex];
	}
	
	public static String sort(String[] sublists, int startIndex, int endIndex)
	{
		String[] sortedSublists=sublists.clone();
		Arrays.sort(sortedSublists, startIndex-1, endIndex);
		
		String sortedSublistsString="";
		for(String sublist:sortedSublists)
		{
			sortedSublistsString+="("+sublist+") ";
		}
		sortedSublistsString=sortedSublistsString.trim();
		
		return sortedSublistsString;
	}
	
	public static String remove(String[] sublists, int startIndex, int endIndex)
	{
		String[] sublistsCopy=sublists.clone();
		String remainingSublistsString="";
		for(String sublist:Arrays.copyOfRange(sublistsCopy, 0, startIndex-1))
		{
			remainingSublistsString+="("+sublist+") ";
		}
		
		for(String sublist:Arrays.copyOfRange(sublistsCopy, endIndex, sublistsCopy.length))
		{
			remainingSublistsString+="("+sublist+") ";
		}
		
		remainingSublistsString=remainingSublistsString.trim();
		
		return remainingSublistsString;
	}
	
	public static String reverse(String[] sublists, int startIndex, int endIndex)
	{
		String[] sublistsCopy=sublists.clone();
		String reversedSublistsString="";
		List<String> reversedList=Arrays.asList(Arrays.copyOfRange(sublistsCopy, startIndex-1, endIndex));
		Collections.reverse(reversedList);
		for(String sublist:Arrays.copyOfRange(sublistsCopy, 0, startIndex-1))
		{
			reversedSublistsString+="("+sublist+") ";
		}
		for (String sublist:reversedList)
		{
			reversedSublistsString+="("+sublist+") ";
		}
		for(String sublist:Arrays.copyOfRange(sublistsCopy, endIndex, sublistsCopy.length))
		{
			reversedSublistsString+="("+sublist+") ";
		}
		
		reversedSublistsString=reversedSublistsString.trim();
		
		return reversedSublistsString;
	}
	
}
