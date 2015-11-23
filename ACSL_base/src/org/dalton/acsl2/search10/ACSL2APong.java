package org.dalton.acsl2.search10;
import java.util.*; 
import java.util.regex.*;
/**
 * @author Alex Pong ('10-'11)
 * Dalton
 */
public class ACSL2APong {
	public static void main(String[] args) {
		ArrayList<String> stuff = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		String in = input.nextLine(); //take the input
		String[] data = in.split(", ");//split on the comma-space!
		for (int x = 0; x<data.length;x++){
			stuff.add(data[x]);
		}
		for(int x = 0; x<5; x++)
		{
			String answer = "";
			String indata = input.nextLine(); //take the input
			String searchterm = createReg(indata);
			ListIterator<String> litr = stuff.listIterator();
			while (litr.hasNext()) 
			{
				String lol = litr.next();
				if (Pattern.matches(searchterm, lol))
				{
					answer = answer + lol+ ", ";
				}
			}
			if (answer!="")
			{
				System.out.println(answer.substring(0,answer.length()-2));
			}
			else{
				System.out.println("No Match.");
			}
		}
	}
	public static String createReg(String indata)
	{
		String toReturn="";
		for (int z=0; z<indata.length();z++)
		{
			if (indata.charAt(z)=='?')
			{
				toReturn = toReturn + ".";
			}
			else if (indata.charAt(z)=='*')
			{
				toReturn = toReturn + ".*";
			}
			else 
			{
				toReturn = toReturn + indata.charAt(z);
			}	
		}
		return toReturn;
	}
}


