package org.dalton.acsl2.search10;

/**
 * Anne Madoff
 * The Dalton School
 * ACSL
 * 9075
 */

//in "exclusive" matches, will set found to true even if only substring is a match

import java.util.regex.*;
import java.util.Scanner;

public class acslSearchAM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		String[] allWords = in.nextLine().split(", ");

		String[] commands = new String[5];

		commands[0] = in.nextLine();
		commands[1] = in.nextLine();
		commands[2] = in.nextLine();
		commands[3] = in.nextLine();
		commands[4] = in.nextLine();

		for(int k=0; k<5; k++)
		{
			StringBuffer sb = new StringBuffer(commands[k]);
			//System.out.println("sb = "+ sb +" length sb = " + sb.length());
			for(int t=0; t<sb.length()-1; t++)
			{
				//System.out.println("k=" +k+ " t=" +t);
				if(sb.charAt(t)=='?')
				{
					sb.replace(t,t+1,".{1}");
					t+=3;

				}

				if(t==0&&sb.charAt(t)=='*')
				{
					sb.replace(t,t+1,".*");
					t+=1;
				}


				if(t!=0&&sb.charAt(t)=='*'&&sb.charAt(t-1)!='.')
				{
					sb.replace(t,t+1,".*");
					t+=1;
				}
			}

			//consider making this cleaner
			int counter = 0;
			while(counter<10)
			{
				for(int t =0; t<sb.length(); t++)
				{
					if(sb.charAt(t)=='*'&&sb.charAt(t-1)!='.')
					{
						sb.replace(sb.length()-1,sb.length(),".*");
					}

					if(sb.charAt(t)=='?')
					{
						sb.replace(t,t+1,".{1}");

					}
					
				}
				counter++;
			}

			//System.out.println("regex command = "+ sb);
			String output= "";
			boolean found = false;
			for(int i=0; i<allWords.length; i++)
			{
				/**Pattern pattern;
				Matcher matcher;
				pattern = Pattern.compile(sb.toString());
				matcher = pattern.matcher(allWords[i]);*/
				if(allWords[i].matches(sb.toString())) {
					//output = output + ", " + allWords[i];
					output = output + ", " + allWords[i];
					found = true;
				}

			}

			if(!found){
				System.out.println("No Match");
			}


			else{
				//System.out.println("pretrim = " + output);
				if(output.substring(output.length()-1).equals(" "))
				{
					output = output.substring(0,output.length()-2);
				}

				if(output.substring(0,1).equals(","))
				{
					output = output.substring(2,output.length());
				}

				System.out.println(output);
			}
		}

	}

	private static StringBuffer StringBuffer(String nextLine) {
		// TODO Auto-generated method stub
		return null;
	}

}
