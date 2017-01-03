package org.dalton.acsl4.regexp15;
import java.util.Scanner;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Alexis Harris
 * ACSL 4 - Regular Expressions
 */

public class ACSL4_RegExp16_AH {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		input = input + ", " + "";
		
		String [] options = input.split(", ");
		
		for (int i = 0; i < 5; i++) {
			String regEx = scan.nextLine();
			String solutions = "";
			for (int j = 0; j < options.length; j++) {
				boolean match = Pattern.matches(regEx, options[j]);
				if(options[j].equals("#"))
				{
					match = false;
				}
				if(match == true)
				{
					solutions = solutions + options[j] + ", ";
				}
			}
			boolean matchEmpty = Pattern.matches(regEx, "");
			
			boolean hash = false;
			for (int j = 0; j < options.length; j++) {
				if(options[j].equals("#"))
				{
					hash = true;
				}
			}
			
			if(matchEmpty == true && hash == true)
			{
				solutions = solutions + "#" + ", ";
			}
			
			solutions = solutions.replaceAll(", $", "");

			if(solutions.length() == 0)
			{
				solutions = "NONE";
			}

			System.out.println(solutions);
		}
	}
}
