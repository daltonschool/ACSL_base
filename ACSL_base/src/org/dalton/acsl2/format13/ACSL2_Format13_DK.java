package org.dalton.acsl2.format13;
import java.text.*;
import java.util.*;

/**
 * Deven Kirschenbaum
 * The Dalton School
 * #3305
 */

public class ACSL2_Format13_DK 
{
	public static String none(String command, String val) //done
	{
		String star = "";
		for (int i = 0; i < (command.length() - val.length()); i++)star+="*";
		val = star + val;
		return val;
	}
	public static String comma(String command, String val) //done
	{
		String stars = "";
		if(command.length() - val.length() == 1)val = NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(val));
		else if(command.length() - val.length() > 1)
		{
			if(command.length() - val.length()>1)for (int i = 0; i < (command.length() - val.length())-1; i++)stars+="*";
			val = stars + NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(val));
		}
		return val;
	}
	public static String decimal_greater(String command, String val) //done
	{
		int command_length = command.length()-1-command.indexOf(".");
		int val_length = val.length()-1-val.indexOf(".");
		int adding = command_length-val_length;
		for (int i = 0; i < adding; i++)val = val+0;
		int before_decimal = ((command.indexOf(".")-1) -(val.indexOf(".")-1));
		String star = "";
		if(((command.indexOf(".")-1) -(val.indexOf(".")-1) !=0 ))for (int i = 0; i < before_decimal; i++)star+="*";
		val = star+val;
		return val;
	}
	public static String decimal_less(String command, String val) //done
	{
		String zero = "";
		for (int i = 0; i < command.length()-command.indexOf(".")-1; i++)zero += "0";
		DecimalFormat df = new DecimalFormat("#." + zero);
		val = df.format(Double.parseDouble(val));
		int before_decimal = ((command.indexOf(".")-1) -(val.indexOf(".")-1));
		String star = "";
		if(((command.indexOf(".")-1) -(val.indexOf(".")-1) !=0 ))for (int i = 0; i < before_decimal; i++)star+="*";
		val = star+val;
		return val;
	}
	public static String dollar_sign_first(String command, String val) //done
	{
		DecimalFormat df = new DecimalFormat("#.00");
		val = df.format(Double.parseDouble(val));
		val = "$" + val;

		return val;
	}
	public static String dollar_sign_second(String command, String val, String original)//done
	{
		val = original;
		String star = "";
		for (int i = 0; i < (command.length()-1 - val.length()); i++)star+="*";
		val = star + val;
		return val;
	}
	public static String exponent(String command, String val) //done
	{
		int num_hashes = command.indexOf("E")-1;
		String zeroes = "";	
		for (int i = 0; i < num_hashes; i++)zeroes+="0";
		DecimalFormat df = new DecimalFormat("0." + zeroes + "E0");
		val = df.format(Double.parseDouble(val));	
		return val;
	}
	public static void main(String[] args) 
	{
		while(true)
		{
			Scanner total_input = new Scanner (System.in);
			String[] input = total_input.nextLine().split(", ");
			String mask_command = input[0];
			String value = input[1];
			int command_length = mask_command.length()-1-mask_command.indexOf(".");
			int val_length = value.length()-1-value.indexOf(".");
			int adding = command_length-val_length;
			String dollar_input = "";
			if(mask_command.contains(".")&&!value.contains(",") && mask_command.indexOf(",") == -1 && mask_command.indexOf("$") == -1 && mask_command.indexOf("E") == -1 && mask_command.indexOf("*") == -1)
			{
				value = decimal_less(mask_command, value);
			}
			else if(mask_command.indexOf(",") == -1 && mask_command.indexOf(".") == -1 && mask_command.indexOf("$") == -1 && mask_command.indexOf("E") == -1 && mask_command.indexOf("*") == -1)
			{
				value = none(mask_command, value);
			}
			else if(mask_command.contains(","))value = comma(mask_command, value);
			else if(mask_command.indexOf("$") == 0)value = dollar_sign_first(mask_command, value);	
			else if(mask_command.startsWith("*$"))
			{
				dollar_input = dollar_sign_first(mask_command, value);
				value = dollar_sign_second(mask_command, value, dollar_input);
			}
			else if(mask_command.contains("E"))value = exponent(mask_command, value);
			else if(adding>0)value = decimal_greater(mask_command, value);
			else if(adding<0)value = decimal_less(mask_command, value);
			System.out.println(value);
		}
	}
}
