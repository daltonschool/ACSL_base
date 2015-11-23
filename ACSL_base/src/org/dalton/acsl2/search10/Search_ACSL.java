package org.dalton.acsl2.search10;

/**
 * Tyler Wojak
 * 
 * The Dalton School
 * 
 * 9075
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.StringBuffer;
public class Search_ACSL 
{
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		String data = input.nextLine();
		String[] datarray = data.split(", ");
		for(int i = 0; i< 5; i++)
		{
			int flag = 0;	
			String in = input.nextLine();
			compare(in, datarray);
			for(int j = 0; j < printer.size(); j ++)
			{
				System.out.print(printer.get(j) + ", ");
			}
			for (int k = 0; k < printer.size(); k++)
			{
				if(printer.get(k) != (""))
				{
					flag ++;
				}	
				else
				{
					flag = flag;
				}	
			}	
			if( flag == 0)
			{
				System.out.println("no match");
			}
			printer.clear();
		}	 	
	}
	public static String converter(String in)
	{
		String Tyler;
		String returner = "";
		Tyler = in.replace('?','.');
		StringBuffer Tyler1 = new StringBuffer();
		Tyler1.append(Tyler);
		for(int i = 0; i < Tyler1.length(); i++)
		{
			if(Tyler1.charAt(i) == '*')
			{
				Tyler1 = Tyler1.insert(i,".");
				i++;
			}		
		}
		returner = Tyler1.toString();
		return returner;
	}
	static ArrayList<String> printer = new ArrayList<String>();
	public static String compare(String in, String [] datarray)
	{
		 Pattern p = Pattern.compile(converter(in));
		 for(int i=0; i< 10; i++)
		 {
			 Matcher m = p.matcher(converter(datarray[i])); 
			 boolean b = m.matches();
			 if(b==true)
			 { 
				String response=(datarray[i]);
				printer.add(response);
			 }
			 else
			 {
				 System.out.print("");
			 }
		 }
		 return in;
	}
}
