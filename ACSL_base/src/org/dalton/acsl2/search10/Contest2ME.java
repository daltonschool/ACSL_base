package org.dalton.acsl2.search10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.io.*;
//import java.lang.reflect.Array;
/**
 * Name: Maggie Ehrlich
 * School: The Dalton School
 * Code: 9075
 */

public class Contest2ME
{

	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		String input;
		input = scan.nextLine();
		String[]data = input.split(", ");
		//System.out.println(data[0]);
		

		for (int i=0; i<5; i++)
		{
			
			String in = scan.nextLine();
			
				finder(in, data);
				//output.add(response);
				for(int z=0; z<output.size(); z++)
				{
					
					System.out.print(output.get(z));
					if(z<output.size()-1)
					{				
					 System.out.print(", ");	
					}
				}
				output.clear();
				
			}
		//.finder(in, data[i]);
		//System.out.println(data[0]);

	}
	public static String switcher(String in)
	{
		String question=in.replace('?', '.');
		StringBuffer star = new StringBuffer();
		star.append(question);
		for(int i=0; i<star.length(); i++)
		{
			if(star.charAt(i)=='*')
			{
				star = star.insert(i,".");
				i++;
			}
		}
		String fstar = "";
		fstar = star.toString();
		return fstar;
		//return question;
		
	}
	
	static ArrayList<String> output = new ArrayList<String>();
	public static String finder(String in, String []data)
	{
		
		 Pattern p = Pattern.compile(switcher(in));
		 boolean isMatch=false;
		 for(int i=0; i<10; i++)
		 {
			 Matcher m = p.matcher(switcher(data[i])); 
			 boolean b = m.matches();
			 
			 if(b==true)
			 {
				String response=(data[i]);
				output.add(response);
				isMatch=true;
				//System.out.print(response);
			 }

		 }

		 if(!isMatch)
		 {
			 System.out.print("No Match");
		 }
		 return in;
	}
}
