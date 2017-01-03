package org.dalton.acsl2.string15;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.*;


public class ACSL2_String15_CW {
	
	public static void main(String[] args) {
	int q = 0;
	//declarations
		while(q<5)
		{
			Scanner scan = new Scanner(System.in);
			String userinput;
			String float_expression = "";
			int length = 0;
			int decimal = 0;
			String accounter;
			double prepare = 0.00;
			String correctformat = "";
			boolean sign = false;
			boolean positive = false;
			boolean negative = false;
			String lenn = "";
			String gr8 = "";
			//take in the numbers, separate them into float_expression, length, decimal
			userinput = scan.nextLine();
			String [] inputs = userinput.split("\\s*,\\s*");
			float_expression = inputs[0];
			if(float_expression.charAt(0) == '+' || float_expression.charAt(0) == '-')
			{
				accounter = float_expression.substring(1);
				sign = true;
				if(float_expression.charAt(0) == '+')
				{
					positive = true;
				}
				if(float_expression.charAt(0) == '-')
				{
					negative = true;
				}
			}
			else
			{
				accounter = float_expression;
			}
			prepare = Double.parseDouble(accounter);
			length = Integer.parseInt(inputs[1]);
			decimal = Integer.parseInt(inputs[2]);
			correctformat = roundedMethod(accounter, float_expression, prepare, length, decimal);
			lenn = lengthMethod(accounter, prepare, length, decimal, correctformat, sign, negative, positive);
			gr8 = greaterMethod(accounter, prepare, length, decimal, correctformat, float_expression);
			if(correctformat.length()==length || (sign == true && correctformat.length()+1==length))
			{
				if(positive==true)
				{
					System.out.println("+" + correctformat);
				}
				else if(negative==true)
				{
					System.out.println("-" + correctformat);
				}
				else if (sign == false)
				{
				System.out.println(correctformat);
				}
			}
			else if(correctformat.length()>length)
			{
				System.out.println(gr8);
			}
			else if(correctformat.length()<length)
			{
				/*
				if(sign==true)
				{
					lenn.substring(0);
				}
				*/
				//QUESTION: DOES A SIGN IN THE FRONT GET RID OF A NUMBER SIGN??
			System.out.println(lenn);
			}
			q++;
		}

	}
	
	public static String roundedMethod(String accounter, String float_expression, double prepare, int length, int decimal)
	{
		String rounded ="";
		int word = decimal;
		String pattern;
		String num = accounter;
		String [] first;
		if(decimal==0)
		{
			pattern = "0";
		}
		else
		{
		pattern = "0.";
		}
		first = num.split("\\.");
		while(word>0)
		{
			pattern = pattern + "0";
			word--;
		}
		DecimalFormat df = new DecimalFormat(pattern);
		//if(float_expression.charAt(0) !='-')
		//{
		int n;
		if(first !=null)
		{
		n = first[0].length();
		}
		else
		{
			n = num.length();
		}
		if(float_expression.length()!=length && decimal != first[1].length())
		{
			if(Character.getNumericValue(accounter.charAt(pattern.length() + (n-1)))>=5)
			{
			df.setRoundingMode(RoundingMode.UP);
			rounded = df.format(prepare);
			}
			else if (Character.getNumericValue(num.charAt(pattern.length()+(n-1)))<5)
			{
				df.setRoundingMode(RoundingMode.FLOOR);
				rounded = df.format(prepare);
			}
		}
		else
		{
			rounded = accounter;
		}
		

		//}
		/*
		else if(float_expression.charAt(0) == '-')
		{
			if(Character.getNumericValue(accounter.charAt(pattern.length()+1))>=7 && Character.getNumericValue(accounter.charAt(pattern.length()+2))>=5)
			{
				df.setRoundingMode(RoundingMode.UP);
				rounded = df.format(prepare);
			}
			else
			{
				df.setRoundingMode(RoundingMode.FLOOR);
				rounded = df.format(prepare);
			}
		}
		*/
		
		return rounded;
	}
	
	public static String lengthMethod(String accounter, double prepare, int length, int decimal, String correctformat, boolean sign, boolean negative, boolean positive)
	{
		String lengths = "";
		int pd = 0;
		String lengthhelper = "";
		if(correctformat.length() < length)
		{
			pd = Math.abs(correctformat.length()-length);
			if(sign==true)
			{
				pd--;
				if(negative==true)
				{
				lengthhelper="-";
				}
				if(positive==true)
				{
					lengthhelper="+";
				}
			}
			while(pd>0)
			{
				lengthhelper = lengthhelper + "#";
				pd--;
			}
			lengths = lengthhelper + correctformat;
		}
		return lengths;
	}
	
	public static String greaterMethod(String accounter, double prepare, int length, int decimal, String correctformat, String float_expression)
	{
		String greater = "";
		int y = 0;
		int gr9 = (int)prepare;
		String temp = gr9 + "";
		//int tempp = temp.length();
		int tempp = 0;
		if(float_expression.charAt(1) == '-' || float_expression.charAt(1) == '+')
		{
			greater = greater + '-';
			tempp--;
		}
		while(tempp<length-(decimal+1))
		{
			greater=greater+"#";
			tempp++;
		}

		if(decimal !=0)
		{
		greater = greater + ".";
		}
		while(y<decimal)
		{
			greater = greater + "#";
			y++;
		}
		
		/*
		String greater = "";
		correctformat.replaceAll("0", "#");
		correctformat.replaceAll("1", "#");
		correctformat.replaceAll("2", "#");
		correctformat.replaceAll("3", "#");
		correctformat.replaceAll("4", "#");
		correctformat.replaceAll("5", "#");
		correctformat.replaceAll("6", "#");
		correctformat.replaceAll("7", "#");
		correctformat.replaceAll("8", "#");
		correctformat.replaceAll("9", "#");
		*/
		return greater;
	}
}
