package org.dalton.acsl2.search10;
import java.util.Scanner;
import java.util.regex.*;
/**Josh Ginzberg, ACSL #2, February 12 2011 (end of 3rd Day)
 */
public class ACSL_Search_Contest2
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String userinput = "";
		userinput = in.nextLine(); //take input
		String[] firstLine = userinput.split(", "); //gives array of strings -- the data we're working on

		//System.out.println(firstLine[7]); DEBUGGED and the userinput/split works
		String[] nextInput = new String[5]; //create array for inputs 2-6

		for(int i = 0; i < 5; i++) //the user's search instructions to be matched
		{
			String answers = ""; 	 //create new String variable for searched items

			userinput = in.nextLine(); //take input
			userinput = userinput.replaceAll("\\?", ".{1}"); //three regex replace functions
			userinput = userinput.replaceAll("\\*", ".*");   //backslashes needed to prevent java.util.regex PatternSyntaxException
			userinput = userinput.replaceAll("\\[a-b]", "[a-b]{1}"); //these cover the five "example" functions given

			for(int j = 0; j < 10; j++)
			{
				Pattern pat;	//Pattern (regex)
				Matcher mat;	//Matcher (regex)
				pat = Pattern.compile(userinput); //gives a pattern to match
				mat = pat.matcher(firstLine[j]); //match to data (1st input)

				if(mat.matches() == true) //if matched
				{
					answers = answers + firstLine[j] + ", "; //add more to the string. Comma and space ensures that output reads correctly
				}
			}
			StringBuffer result = new StringBuffer(answers); //convert to StringBuffer
			
			if(result.length() == 0)
			{
				nextInput[i] = "0"; //this is for "No Match"
			}
			else
			{
				result = result.delete(result.length()-2, result.length()-1); //delete the comma and space at the end of the StringBuffer
				String str = result.toString(); //convert back to string
				nextInput[i] = str; //this if we have a match
			}
		}
		for(int k = 0; k < 5; k++) //this loop ensures that the order of input and output remains "pure"
		{
			if(nextInput[k].equals("0")) //the No Match condition
			{
				System.out.println("No Match");
			}
			else
			{
				System.out.println(nextInput[k]); //output
			}
		}
	}
}