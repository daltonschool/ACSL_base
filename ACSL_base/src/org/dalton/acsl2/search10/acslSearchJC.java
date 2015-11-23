package org.dalton.acsl2.search10;
import java.util.Scanner;
import java.util.*;
import java.util.regex.*;
/*
 * Jake Cahan
 * The Dalton School
 * 9075
 */
public class acslSearchJC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String response = in.nextLine();
		String data[] = response.split(", ");
		for(int i = 0; i<5; i++) //DOES 5 OPERATIONS
		{
			String operation = in.next();
			String matchresults = "";
			boolean entered = false;
			operation = operation.replaceAll("\\]", "]{1}");
			operation = operation.replaceAll("\\?", ".{1}");
			operation = operation.replaceAll("\\*", ".*");
			for(int x = 0; x<10; x++) //loops thru all of LINE 1 = INPUT DATA
			{
				Pattern pattern;
				Matcher matcher;
				pattern = Pattern.compile(operation);
				matcher = pattern.matcher(data[x]);
				if(matcher.matches() == true)
				{
					matchresults = matchresults + data[x] + ", ";
					entered = true;
				}
				if(x == 9)
				{
					if(entered == true)
					{
						StringBuffer output = new StringBuffer(matchresults);
						output = output.delete(output.length()-2, output.length()-1);
						System.out.println(output); //OFFICIAL OUTPUT
					}
					else
					{
						System.out.println("No Match");
					}
				} //closes if x == 9
			}//closes for x
		} //closes for i
	}//closes main 
}//closes acslSearch 