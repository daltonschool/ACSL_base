package org.dalton.acsl2.format13;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
public class ACSL2_Format13_HS {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = new String[2];
		for (int i = 0; i < 5; i++) {
			input = scan.nextLine().split(", ");
			String format = input[0];
			String value = input[1];
			if (format.indexOf("E")>=0) value = eRule(format, value);
			else if(format.indexOf(".")>=1) value = decField(format,value);
			else if(format.indexOf(",")>=1) value = commaField(format, value);
			else value = charField(format, value);
			if(format.indexOf("*$")>=0) value = starRule(value);
			else if(format.indexOf("$")>=0) value = cashRule(value);
			System.out.println(value);
		}
	}
	public static String charField(String format, String value){
		int fieldLength = format.length();
		int valueLength = value.length();
		String stars = "";
		for (int f = 0; f < (fieldLength-valueLength); f++) {stars = stars+ "*";}
		String fin = stars + value;
		return fin;
	}
	public static String commaField(String format, String value){
		String result = value;
		if (value.length() <= 3) return value; // If the original value has 3 value or  less it returns that value
		for (int i = 0; i < (value.length() - 1) / 3; i++) {
			int commaPos = value.length() - 3 - (3 * i); // comma position in each cicle
			result = result.substring(0, commaPos) + "," + result.substring(commaPos);
		}
		format = format.replace("&", "#").replace("$", "").replace(",", "").replace("*", "").replace(".", "");
		int fieldLength = format.length();
		int valueLength = value.length();
		String stars = "";
		for (int f = 0; f < (fieldLength-valueLength); f++) {stars = stars+ "*";}
		return stars + result;
	}
	public static String decField(String format, String value){
		format = format.replace("&", "#").replace("$", "").replace(",", "").replace("*", "").replace(",", "");

		format = format.split("\\.")[0] + "." + format.split("\\.")[1].replace("#", "0");

		DecimalFormat myFormatter = new DecimalFormat(format);
		String first = charField(format.split("\\.")[0], myFormatter.format(Double.parseDouble(value)).split("\\.")[0]);
		myFormatter.setRoundingMode(RoundingMode.HALF_UP);
		String second = myFormatter.format(Double.parseDouble(value)).split("\\.")[1];
		return first+ "." + second;
	}
	public static String cashRule(String value){
		value = value.replace("*", "").replace(" ", "");
		return "$" + value;
	}
	public static String starRule(String value){
		if((value.indexOf("*")>=0))
		{
			value = value.substring(0, value.lastIndexOf("*") + 1) + "$" + value.substring(value.lastIndexOf("*") + 1, value.length());
		}
		return value;
	}
	public static String eRule(String format, String value){
		format = format.replace("&", "0").replace("$", "").replace(",", "").replace("*", "").replace(",", "");
		format = format.substring(0,1) + "." + format.substring(1, format.length()) + "0";
		DecimalFormat myFormatter = new DecimalFormat(format);
		myFormatter.setRoundingMode(RoundingMode.HALF_UP);
		value = myFormatter.format(Double.parseDouble(value));
		return value;	
	}
}