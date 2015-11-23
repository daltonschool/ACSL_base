package org.dalton.acsl2.format13;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ACSL2_Format13_AM {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		for (int ii = 0; ii < 5; ii++) {
			String input = scan.nextLine(); 
			String string = input.split(", ")[0];
			double value = Double.parseDouble(input.split(", ")[1]); 
			StringBuffer buf = new StringBuffer(string);
			if(buf.indexOf(",") != -1){
				//System.out.println("comma");
				if(buf.indexOf("$") != -1){
					if(buf.indexOf("*") != -1) {
						System.out.println(commaField(string, (int)value, true, true));
					}
					else {
						System.out.println(commaField(string, (int)value, true, false));
					}
				}
				else 
					System.out.println(commaField(string, (int)value, false, true)); //STARS??? 
			}
			else if (buf.indexOf("E") != -1){
				//System.out.println("Sci not");
				System.out.println(sciNot(string, (int)value));
			}
			else if (buf.indexOf("*$") != -1){
				//System.out.println("Star dollar");
				System.out.println(starDollar(string, value));
			}
			else if (buf.indexOf("$") != -1){
				//System.out.println("add dollar"); 
				System.out.println(addDollar(string, value));
			}
			else if (buf.indexOf(".") != -1){
				//System.out.println("dec field");
				System.out.println(decField(string, value));
			}
			else {
				//System.out.println("Char field");
				System.out.println(charField(string, (int)value));
			}
		}
	}

	//NEEDS TO BE INT???
	public static String charField(String str, int val){
		StringBuilder done = new StringBuilder(); 
		int starNum = str.length() - String.valueOf(val).length(); 
		done.append(new String(new char[starNum]).replace("\0", "*")); 
		return done.append(String.valueOf(val)).toString();
	}

	//NEEDS TO BE INT???
	public static String commaField(String str, int val, boolean dollar, boolean stars){
		//comma rule
		DecimalFormat formatter; 
		if(dollar){
			formatter = new DecimalFormat("$#,###");
		}
		else {
			formatter = new DecimalFormat("#,###");
		}
		int starNum = str.replaceAll("[^"+ '&' +"]", "").length() - String.valueOf(val).length(); 
		StringBuilder addStars = new StringBuilder(); 
		formatter.setRoundingMode(RoundingMode.HALF_UP); 
		if(stars){
			addStars = new StringBuilder(new String(new char[starNum]).replace("\0", "*"));
			return addStars.append(formatter.format(val)).toString();  
		}
		return addStars.append(formatter.format(val)).toString();  
	}

	public static String decField(String str, double d){
		//1st decimal rule and 2nd decimal rule
		int stars = str.split("\\.")[0].length() - String.valueOf(d).split("\\.")[0].length();
		StringBuilder done = new StringBuilder(); 
		String star_str = new String(new char[stars]).replace("\0", "*"); 
		String beginning = String.valueOf(d).split("\\.")[0] + "."; 
		beginning += String.valueOf(d).split("\\.")[1]; 
		DecimalFormat formatter = new DecimalFormat("0." + new String(new char[(str.split("\\.")[1]).length()]).replace("\0", "0"));
		formatter.setRoundingMode(RoundingMode.HALF_UP); 
		//System.out.println("Beg: " + beginning);
		//System.out.println("Format: " + ("0." + new String(new char[(str.split("\\.")[1]).length()]).replace("\0", "0")));
		done = new StringBuilder(star_str + formatter.format(Double.parseDouble(beginning)).toString());  
		return done.toString(); 
	}

	//JUST ADD DOLLAR SIGN?
	public static String addDollar(String str, double val){
		DecimalFormat formatter = new DecimalFormat(); 
		if(str.split("\\.").length > 1)
			formatter = new DecimalFormat("$0." + new String(new char[(str.split("\\.")[1]).length()]).replace("\0", "0"));
		else 
			formatter = new DecimalFormat("$0");
		formatter.setRoundingMode(RoundingMode.HALF_UP); 
		return formatter.format(val); 
	}

	public static String starDollar(String str, double d){
		int stars = str.split("\\.")[0].length() - String.valueOf(d).split("\\.")[0].length();
		// -1 or -2???
		StringBuilder done = new StringBuilder(new String(new char[stars-2]).replace("\0", "*") + "$" + String.valueOf(d).split("\\.")[0] + "."); 
		DecimalFormat formatter = new DecimalFormat("#." + new String(new char[(str.split("\\.")[1]).length()]).replace("\0", "0"));
		formatter.setRoundingMode(RoundingMode.HALF_UP); 
		done.append(formatter.format(Double.parseDouble("." + String.valueOf(d).split("\\.")[1])).split("\\.")[1]); 
		return done.toString();
	}

	public static String sciNot(String str, int val){
		int and_num = str.replaceAll("[^"+ '&' +"]", "").length();
		String format = "0" + "." + new String(new String (new char[and_num-1]).replace("\0", "0")) + "E" + "0"; 
		//-2? 
		DecimalFormat formatter = new DecimalFormat(format);  
		formatter.setRoundingMode(RoundingMode.HALF_UP); //MUST ROUND HALF UP
		return formatter.format(val); 
	}

	private static String dec_field(String format_info, double num)
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
}
