package org.dalton.acsl2.format13;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.StringBuilder;
import java.math.RoundingMode;

/*
 * Samuel Stone
 * ACSL Program 2 (Print Formatting)
 * The Dalton School
 * School Code: 3305
 */

public class ACSL2_Format13_SS
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 50; i++) 
		{
			String user_input = sc.nextLine();
			//Splits FORMAT string and value
			String[] inputs = user_input.split(", ");

			//Take in user data
			String format_info = inputs[0];
			String num_string = inputs[1];
			double num = Double.parseDouble(inputs[1]);

			/*
			 * The following are conditions of what to do for each type of input.
			 * They are exclusive (only one condition can take effect at once).
			 */
			if(format_info.contains("*$"))
			{
				System.out.println(asterisk_dollar(format_info, num));
			}
			else if(format_info.contains("$") && !format_info.contains("*"))
			{
				System.out.println(dollars(format_info, num));
			}
			else if(format_info.contains("E"))
			{
				System.out.println(scientific_notation(format_info, num));
			}
			else if(format_info.contains(","))
			{
				System.out.println(commas(format_info, (int)num));
			}
			else if(format_info.contains(".") && !format_info.contains("$") && !format_info.contains("E"))
			{
				System.out.println(decimals(format_info, num));	
			}
			else
			{
				System.out.println(standard_field(format_info, num_string));
			}

		}

	}


	private static String decimals(String format_info, double num)
	{
		char[] difference_numstring = new char[format_info.split("\\.")[0].length() - String.valueOf(num).split("\\.")[0].length()]; //Finds difference in post decimals between number itself and formatting string
		StringBuffer asterisks_buffer = new StringBuffer();
		String string_asterisks_added = "";
		
		for (int i = 0; i < difference_numstring.length; i++) 
		{
			string_asterisks_added = asterisks_buffer.append("*").toString();
		}
		
		String beginning_part = String.valueOf(num).split("\\.")[0];
		beginning_part += ".";//Adds a decimal after the split point of the number

		String post_decimal_added = beginning_part;
		post_decimal_added += String.valueOf(num).split("\\.")[1];//Does the part after the decimal

		DecimalFormat formatter = new DecimalFormat("#." + new String(new char[(format_info.split("\\.")[1]).length()]).replace("\0", "0")); //Correct decimal formatting (puts in 0's for each digit) 
		formatter.setRoundingMode(RoundingMode.HALF_UP); //Rounding mode is half down by default

		StringBuffer decimals = new StringBuffer(string_asterisks_added); //String buffer = leading asterisks + pre-decimal + '.' + post-decimal
		decimals.append(formatter.format(Double.parseDouble(post_decimal_added)).toString());

		String answer = decimals.toString(); //Convert back to string and return
		return answer;
	}


	private static String scientific_notation(String format_info, double number) 
	{
		StringBuffer add_zeroes = new StringBuffer(); //Empty buffer to add zeroes

		for (int i = 0; i < format_info.length()-2; i++) //Add zeroes to be used in formatting because of & in format input
		{
			add_zeroes.append('0');
		}

		DecimalFormat scinote = new DecimalFormat("0." + add_zeroes + "E0");  //Correct decimal format
		String answer = scinote.format(number);  //Format and return
		return answer;
	}


	public static StringBuffer dollars (String format, double number)
	{
		//Mandates that there are 2 digits after decimals
		DecimalFormat dollars = new DecimalFormat("#########.##");
		//Rounding mode / 2 digits
		dollars.setRoundingMode(RoundingMode.HALF_UP);
		dollars.setMinimumFractionDigits(2);
		//Format correctly
		String decimals_added = dollars.format(number);
		//Create buffer
		StringBuffer num_buff = new StringBuffer(decimals_added);
		//Just add a dollar sign at the start
		num_buff.insert(0, "$");
		//Return answer
		return num_buff;
	}
	
	private static String asterisk_dollar(String format_info, double num) 
	{
		char[] number_post_decimal = new char[(format_info.split("\\.")[1]).length()];
		DecimalFormat asterisks_formatting = new DecimalFormat("#." + new String(number_post_decimal).replace("\0", "0")); //Establishes the correct decimal format
		asterisks_formatting.setRoundingMode(RoundingMode.HALF_UP); //Need correct rounding

		char[] difference_between_post_decimal = new char[format_info.split("\\.")[0].length() - String.valueOf(num).split("\\.")[0].length()-2]; //Finds the difference between lengths post decimal of the FORMAT and the number
		StringBuffer asterisked = new StringBuffer(new String(difference_between_post_decimal).replace("\0", "*") + "$"); //Adds the asterisks where they are needed

		asterisked.append(String.valueOf(num).split("\\.")[0] + ".");//Adds the number and decimal point to the buffer
		asterisked.append(asterisks_formatting.format(Double.parseDouble("." + String.valueOf(num).split("\\.")[1])).split("\\.")[1]); //Formats and appends the post decimal part correctly 
		String answer = asterisked.toString(); //Converts to string
		return answer; //Returns answer
	}


	private static String commas(String format_info, int number) 
	{
		//Decimal format with commas
		DecimalFormat comma_formatter = new DecimalFormat("#,###"); 
		//Get length without ampersands
		int length_amps_removed = format_info.replaceAll("[^"+ '&' +"]", "").length(); 
		//Create char array of length: (formatting with non-ampersands minus length MINUS number length) 
		char[] replace_for_asterisks = new char[length_amps_removed - String.valueOf(number).length()]; 
		//Add asterisks to fill the length needed to fill
		StringBuilder asterisks = new StringBuilder(new String(replace_for_asterisks));
		//Convert to string and return
		String answer = asterisks.append(comma_formatter.format(number)).toString();
		return answer;
	}

	static String standard_field(String format_info, String number) 
	{
		//Create a buffer
		StringBuffer answer = new StringBuffer();
		//Append the number
		answer.append(number);
		//Add asterisks before you get to the number
		for (int i = 0; i < format_info.length() - number.length(); i++) 
		{
			answer.insert(0, "*");
		}
		//Return the answer as a string
		return answer.toString();
	}


}//Close program
