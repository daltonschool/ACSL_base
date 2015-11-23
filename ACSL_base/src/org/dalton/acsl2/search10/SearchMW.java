package org.dalton.acsl2.search10;

/**
 * Matthew Weinsier
 * 
 * The Dalton School
 * 
 * Code: 9075
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchMW 
{
	
	  public static String transformation(String in)
	    {
	        String Matt;
	        String display = "";
	        Matt = in.replace('?','.');
	        StringBuffer Matt1 = new StringBuffer();
	        Matt1.append(Matt);
	        for(int i = 0; i < Matt1.length(); i++)
	        {
	            if(Matt1.charAt(i) == '*')
	            {
	                Matt1 = Matt1.insert(i,".");
	                i++;
	            }        
	        }
	        display = Matt1.toString();
	        return display;
	    }
	    static ArrayList<String> output = new ArrayList<String>();
	    public static String compare(String in, String [] datax)
	    {
	         Pattern p = Pattern.compile(transformation(in));
	         for(int i=0; i< 10; i++)
	         {
	             Matcher m = p.matcher(transformation(datax[i])); 
	             boolean b = m.matches();
	             if(b==true)
	             { 
	                String response=(datax[i]);
	                output.add(response);
	             }
	             else
	             {
	                 System.out.print("");
	             }
	         }
	         return in;
	    }
	
	
    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();
        String[] datax = data.split(", ");
        for(int i = 0; i< 5; i++)
        {
            int catcher = 0;    
            String in = input.nextLine();
            compare(in, datax);
            for(int j = 0; j < output.size(); j ++)
            {
                System.out.print(output.get(j) + ", ");
            }
            for (int k = 0; k < output.size(); k++)
            {
                if(output.get(k) != (""))
                {
                    catcher ++;
                }    
                else
                {
                    catcher = catcher;
                }    
            }    
            if( catcher == 0)
            {
                System.out.println("no match");
            }
            output.clear();
        }         
    }
  
}

