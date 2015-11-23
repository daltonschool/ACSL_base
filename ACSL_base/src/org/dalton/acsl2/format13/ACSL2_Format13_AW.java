package org.dalton.acsl2.format13;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

/* 
 * Alexa Wojak
 * The Dalton School
 * 3055
 */

/*possible issues
 * decimals with E 
 * rounding with E
 * rounding with decimal
*/

public class ACSL2_Format13_AW {

	//nothing class
	public static String padding(String[] data, String answer)
	{
		String pad = "";
		int counter = 0;
		for (int i = 0; i < data[0].length(); i++) {
			if(data[0].charAt(i) == '&') counter ++;
		}
		int other = 0;
		for (int i = 0; i < answer.length(); i++) {
			if(answer.charAt(i) == ',' || answer.charAt(i) == '.' || answer.charAt(i) == '$') other ++;
		}
		while((answer.length()+pad.length()-other) < counter) pad = pad + "*";
		return pad;
	}

	public static String nothing(DecimalFormat format, String[] data)
	{
		format.applyPattern("#");
		Double number = Double.parseDouble(data[1]);
		String answer = format.format(number);
		return answer;
	}

	public static String comma(DecimalFormat format, String[] data, String answer)
	{
		Double number = Double.parseDouble(answer);
		format.applyPattern("#,###");
		answer = format.format(number);
		return answer;
	}

	public static String decimal(DecimalFormat format, String[] data, String answer)
	{
		Double number = Double.parseDouble(answer);
		String pattern = "";
		int count = 0;
		for (int i = 0; i < data[0].length(); i++) {
			if(data[0].charAt(i) == '.') count = data[0].substring(i+1).length();
		}
		pattern = "#.";
		for (int i = 0; i < count; i++) {
			pattern = pattern + "0";
		}
		format.applyPattern(pattern);
		answer = format.format(number);	
		return answer;
	}

	public static String dollar(DecimalFormat format, String[] data, String answer)
	{
		answer = "$" + answer;
		return answer;
	}

	public static String e(DecimalFormat format, String[] data, String answer)
	{
		Double number = Double.parseDouble(answer);
		String pattern = "";
		int count = data[0].length() - 2;
		pattern = "0.";
		for (int i = 0; i < count; i++) {
			pattern = pattern + "0";
		}
		pattern = pattern + "E0";
		format.applyPattern(pattern);
		answer = format.format(number);
		return answer;
	}

	public static void main (String[] args)

	{	
		int counter = 0;
		String answer = "";
		boolean rule = false;
		boolean padding = true;
		while (counter < 5)
		{
			answer = "";
			rule = false;
			padding = true;
			//DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			//symbols.setZeroDigit ('*');
			DecimalFormat format = new DecimalFormat();
			format.setRoundingMode(RoundingMode.HALF_UP);
			//format.setDecimalFormatSymbols(symbols);

			Scanner input = new Scanner(System.in);
			String stuff = input.nextLine();
			String [] data = stuff.split(", ");
			answer = data[1];

			//if() comma, decimal, $, *$, E
			if(data[0].contains("."))
			{
				answer = decimal(format, data, answer);
				rule = true;
			}
			if(data[0].contains(","))
			{
				answer = comma(format, data, answer);
				rule = true;
			}
			if(data[0].charAt(0) == '$')
			{
				answer = dollar(format, data, answer);
				rule = true;
				padding = false;
			}
			if(data[0].charAt(0) == '*' && data[0].charAt(1) == '$')
			{
				answer = dollar(format, data, answer);
				rule = true;
			}
			if(data[0].contains("E"))
			{
				answer = e(format, data, answer);
				rule = true;
				padding = false;
			}
			if(rule == false) answer = nothing(format, data);
			if(padding == true) answer = padding(data, answer) + answer;			
			System.out.println(answer);
			counter++;
		}//while
	}//main
}//program
