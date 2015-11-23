package org.dalton.acsl2.format13;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ACSL2_Format13_MR {
/** Morris Reeves
 *  The Dalton School
 *  School Code: 3055
 *  ACSL Contest 2: Print Formatting
 */

	public static void main(String[] args) 
	{
		String[] string_value = new String[2]; //to store "string" and "value"
		String s; //string
		String v; //value
		int slength;
		int vlength;
		
		String input = "";
		String output = "";
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<5; i++) //READ IN 5 LINES
		{
			input = scan.nextLine();
			string_value = input.split(", "); //split by (", ")
			s = string_value[0];
			v = string_value[1];
			slength = s.length(); //variables assigned for later command abbreviation
			vlength = v.length();
			
			if(s.contains(",")) output = comma(v, slength, vlength); //Rule 2
			else if(s.charAt(0) == '$') output = dollar(s, v, s.substring(s.indexOf('.'), slength).length()); //Rule 5
			else if(s.substring(0, 2).equals("*$")) output = stardollar(v, s, slength, vlength, s.substring(s.indexOf('.'), slength).length()).toString(); //Rule 6
			else if(s.contains(".")) output = round(s, v, s.substring(s.indexOf('.'), slength).length()); //Rule 3 and 4
			else if(s.charAt(slength-1) == 'E')	output = expform(v, slength, vlength); //Rule 7
			else output = normal(v, slength, vlength).toString(); //Rule 1
			System.out.println(output);
		}
	}
	
	static StringBuffer normal(String v, int slength, int vlength) //Rule 1
	{
		StringBuffer norm = new StringBuffer();
		for(int i=0; i<slength-vlength; i++) norm.append('*');
		norm.append(v);
		return norm;
	}
	
	static String comma(String v, int slength, int vlength) //Rule 2
	{
		StringBuffer norm = new StringBuffer();
		for(int i=0; i<slength-vlength-1; i++) norm.append('*');
		norm.append(NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(v))); //formats into ---,---,--- number format
		return norm.toString();
	}
	
	static String round(String s, String v, int placestoround) //Rule 3 and 4
	{
		String rnd = "";
		StringBuffer argument = new StringBuffer(); //stores how many place values to round to (appended with zeros)
		StringBuffer leftpadding = new StringBuffer(); //stores left padding (appended with *)
		if(v.contains(".")) for(int i=0; i< (s.substring(0, s.indexOf(".")).length()) - (v.substring(0, v.indexOf(".")).length()); i++) leftpadding.append('*');
		else for(int i=0; i< (s.substring(0, s.indexOf(".")).length()) - v.length(); i++) leftpadding.append('*');
		for(int i=0; i<placestoround-1; i++) argument.append('0');
		DecimalFormat df = new DecimalFormat(leftpadding + "0." + argument);
		df.setRoundingMode(RoundingMode.HALF_UP);
		rnd = df.format(Double.parseDouble(v));
		return rnd;
	}
	static String dollar(String s, String v, int placestoround) //Rule 5
	{
		String dol = "";
		StringBuffer argument = new StringBuffer(); //stores how many place values to round to (appended with zeros)
		for(int i=0; i<placestoround-1; i++) argument.append('0');
		DecimalFormat df = new DecimalFormat("$0." + argument);
		df.setRoundingMode(RoundingMode.HALF_UP);
		dol = df.format(Double.parseDouble(v));
		return dol;
	}
	static String stardollar (String v, String s, int slength, int vlength, int placestoround) //Rule 6
	{
		String stard = "";
		StringBuffer argument = new StringBuffer(); //stores how many place values to round to (appended with zeros)
		StringBuffer leftpadding = new StringBuffer(); //stores left padding (appended with *)
		if(v.contains(".")) for(int i=0; i< (s.substring(0, s.indexOf(".")).length()) - (v.substring(0, v.indexOf(".")).length() + 2); i++) leftpadding.append('*');
		else for(int i=0; i< (s.substring(0, s.indexOf(".")).length()) - v.length() - 2; i++) leftpadding.append('*');
		leftpadding.append('$');
		for(int i=0; i<placestoround-1; i++) argument.append('0');
		DecimalFormat df = new DecimalFormat(leftpadding + "0." + argument);
		df.setRoundingMode(RoundingMode.HALF_UP);
		stard = df.format(Double.parseDouble(v));
		return stard;
	}
	static String expform (String v, int slength, int vlength) //Rule 7
	{
		String exp = "";
		StringBuffer argument = new StringBuffer();
		for(int i=0; i<(slength-2); i++) argument.append('0');
		DecimalFormat df = new DecimalFormat("0."+ argument + "E0"); 
		df.setRoundingMode(RoundingMode.HALF_UP);
		exp = df.format(Double.parseDouble(v));
		return exp;
	}
}

/*
static String zerod(String s, String v)
{
	String zd = "";
	StringBuffer argument = new StringBuffer(); //right zeros
	StringBuffer leftpadding = new StringBuffer(); //left stars
	for(int i=0; i< (s.substring(s.indexOf(".")).length()) - (v.substring(v.indexOf(".")).length()); i++) argument.append('0');
	for(int i=0; i<placestoround-1; i++) argument.append('0');
	DecimalFormat df = new DecimalFormat(leftpadding + "0." + argument);
	df.setRoundingMode(RoundingMode.HALF_UP);
	zd = df.format(Double.parseDouble(v));
	return zd;
}*/

//StringBuffer stard = new StringBuffer();
		//for(int i=0; i<(slength-vlength-2); i++) stard.append('*');
		//stard.append('$' + v);
		//return stard;

//else if(s.contains(".") && s.substring(s.indexOf('.'), slength).length() > v.substring(v.indexOf('.'), vlength).length()) output = zerod(s, v);
//else if(s.contains(".") && s.substring(s.indexOf('.'), slength).length() < v.substring(v.indexOf('.'), vlength).length()) output = round(s, v, s.substring(s.indexOf('.'), slength).length());

