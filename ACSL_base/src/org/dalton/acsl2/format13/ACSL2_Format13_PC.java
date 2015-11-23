package org.dalton.acsl2.format13;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ACSL2_Format13_PC {
	static int dec_point;
	static Scanner scan = new Scanner(System.in);
	static boolean check = false;
	static boolean check_value = false;

	public static void main(String[] args) {

		for (int j = 0; j < 5; j++) {
			check = false;
			check_value = false;
			String[] input = scan.nextLine().split(", ");
			StringBuffer string = new StringBuffer(input[0]);
			StringBuffer value = new StringBuffer(input[1]);
			
			for (int i = 0; i < string.length(); i++) {
				if(string.charAt(i) == '.')
				{
					check = true;
				}
			}
			
			for (int i = 0; i < value.length(); i++) {
				if(value.charAt(i) == '.')
				{
					check_value = true;
				}
			}
					
			if (input[0].contains(","))
			{
				value = comma (string, value);
			}
			
			if(string.charAt(0) == '$')
			{
				value = dollar (string, value);
			}
					
			if(string.charAt(0) == '*' && string.charAt(1) == '$')
			{
				value = star_dollar (string, value);
			}
			
			if(string.charAt(string.length()-1) == 'E'){
				value = E_format (string, value);
			}

			if(check == true && !(string.charAt(0) == '$') && !((string.charAt(0) == '*')) && !(string.charAt(string.length()-1) == 'E'))
			{
				value= decimal (string, value);
			}
			
			else if (!(string.charAt(0) == '$') && !(string.charAt(0) == '*'))
			{
				value = normal (string, value);
			}
			System.out.println(value);
		}
	}
	
	public static StringBuffer normal (StringBuffer string, StringBuffer value)
	{

		double offset = string.length() - value.length();
		
		for (int i = 0; i < offset; i++) {
			value.insert(0, "*");
		}
		return value;
	}
	
	public static StringBuffer comma (StringBuffer string, StringBuffer value)
	{
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == ',')
			{
				string.delete(i, i+1);
			}	
		}
		int length = value.length();
		value = normal(string, value);
		int length_final = value.length();
		for (int i = 0; i <	length; i++) {
			if(!(i==0) && i%3 == 0)
			{
			value.insert(length_final-(i), ",");
			}
		}
		
		return value;
	}
	
	
	public static StringBuffer decimal (StringBuffer string, StringBuffer value)
	{
		if(check_value == false)
		{
			value.insert(value.length(), '.');
			value.insert(value.length(), ' ');
		}
		String v = value.toString();
		String str = string.toString();
	
		double d = Double.parseDouble(v);
		int stars = str.split("\\.")[0].length() - String.valueOf(v).split("\\.")[0].length();

		StringBuilder finish = new StringBuilder(); 

		String start = String.valueOf(v).split("\\.")[0] + "."; 

		start += String.valueOf(v).split("\\.")[1]; 
		
		String string_star = new String(new char[stars]).replace("\0", "*"); 

		DecimalFormat d_format = new DecimalFormat("0." + new String(new char[(str.split("\\.")[1]).length()]).replace("\0", "0"));

		d_format.setRoundingMode(RoundingMode.HALF_UP);

		finish = new StringBuilder(string_star + d_format.format(Double.parseDouble(start)).toString());  
		
		String s = finish.toString();
		
		StringBuffer hold = new StringBuffer(s);
		return hold; 
	}
	
	
	public static StringBuffer dollar (StringBuffer string, StringBuffer value)
	{
		string.delete(0, 1);
		value = decimal (string, value);
		int find_star = 0;
		for (int i = 1; i < value.length()-1; i++) {
			if(value.charAt(i-1) == '*' && !(value.charAt(i+1) == '*'))
			{
				find_star = i;
			}
		}
		value.delete(0, find_star);
		value.insert(0, "$");
		string.insert(0, '$');
		return value;
	}
	
	public static StringBuffer star_dollar (StringBuffer string, StringBuffer value)
	{
		string.delete(0, 2);
		value = decimal (string, value);
		int last_star = 0;
		for (int i = 1; i < value.length()-1; i++) {
			if(value.charAt(i-1) == '*' && !(value.charAt(i) == '*'))
			{
				last_star = i;
			}
		}
		string.insert(0, "*$");
		//string.insert(0, '*');
		value.insert(last_star, '$');
		return value;
	}
	
	public static StringBuffer E_format (StringBuffer string, StringBuffer value){
		String v = value.toString();
		String s = string.toString();
	
		double val_d = Double.parseDouble(v);
		
		int and_count = s.replaceAll("[^"+ '&' +"]", "").length();
		String e_for = "0" + "." + new String(new String (new char[and_count-1]).replace("\0", "0")) + "E" + "0"; 
		
		DecimalFormat formatter = new DecimalFormat(e_for);  
		formatter.setRoundingMode(RoundingMode.HALF_UP); //CHECK THIS
		StringBuffer hold = new StringBuffer (formatter.format(val_d));
		return hold;
}

	
	
}