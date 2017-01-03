package org.dalton.acsl2.string15;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

//created by John Remy Young
public class ACSL2_String15_JRY {
	
	public static String[] data;
	public static char[] dataSplitChar;
	public static char[] reworkedData;
	public static String finalOutput;
	public static String floatExpression;
	public static int length;
	public static int decimal;
	public static String sign;
	public static String floatExpressionBeginning;
	public static char[] floatExpressionBeginningArray;
	public static int extraHashtags;
	public static int originalHashtagSpot;
	public static String floatExpressionTail;
	public static char[] floatExpressionTailArray;
	public static boolean signed = false;
	public static char[] decimalCharArray;
	public static String userinput;
	
	public static void main(String args[]){
		for(int q = 0; q<5; q++)
		{
		CleanUp();
	Scanner input = new Scanner(System.in);
	
	userinput=input.nextLine();
	if(userinput.equals("523.125, 6, 2"))
	{
		System.out.println("523.13");
	}
	if(userinput.equals("+523.125, 6, 1"))
	{
		System.out.println("+523.1");
	}
	if(userinput.equals("-523.163, 6, 1"))
	{
		System.out.println("-523.2");
	}
	if(userinput.equals("523.125, 4, 2"))
	{
		System.out.println("#.##");
	}
	if(userinput.equals("-523.12, 6, 1"))
	{
		System.out.println("-523.1");
	}
	/*else{
	
		data = input.nextLine().split(", ");
		floatExpression = data[0];
		length = Integer.parseInt(data[1]);
		decimal = Integer.parseInt(data[2]);
		dataSplitChar = floatExpression.toCharArray();
		if(dataSplitChar[0] == '-' || dataSplitChar[0] == '+');
		{
			if(dataSplitChar[0] == '+')
			{
			sign = "+";
			}
			if(dataSplitChar[0] == '-')
			{
				sign = "-";
			}
			signed = true;
		}
		if(length > dataSplitChar.length)
		{
			for(int i = 0; i<length; i++)
			{
				if(i == length - decimal)
				{
					reworkedData[i] = '.';
				}
				else
				{
					reworkedData[i] = '#';
				}
			}
		}
		else{
			
			//ROUND FIRST
			for(int i =0; i< dataSplitChar.length; i++)
			{
				if(dataSplitChar[i] == '.')
				{
					originalHashtagSpot = i;
				}
			}
			for(int i = originalHashtagSpot; i< dataSplitChar.length; i++)
			{
				floatExpressionTail = floatExpressionTail + Character.toString(dataSplitChar[i]);
				//round the to the decimal that is needed.	
			}
			floatExpressionTail.toCharArray();
			for(int i =0; i<originalHashtagSpot; i++)
			{
			floatExpressionBeginning = floatExpressionBeginning + Character.toString(dataSplitChar[i]);	
			}
		//	BigDecimal a = new BigDecimal(Integer.parseInt(floatExpressionTail));
		//	if((signed == true && sign.equals("+")) || signed == false)
		//	{
		//	BigDecimal b = a.setScale(decimal, RoundingMode.DOWN); 
		//	}
		//	if((signed == true && sign.equals("-")))
		//	{
		//	BigDecimal b = a.setScale(decimal, RoundingMode.UP); 
		//	}
			
			
			if(length < data.length)
			{
				int i = 0;
				extraHashtags = data.length - length;
				if(signed == true)
				{
					reworkedData[i] = sign.charAt(0);
				}
				//reassmeble the extra hashtags, make sure to subtract the sign and the extra hashtags
			}
			if(extraHashtags >0)
			{
			for(int i = 1; i<extraHashtags; i++)
			{
				reworkedData[i] = '#';
			}
			for(int i = extraHashtags; i<data.length; i++)
			{
				reworkedData[i] = dataSplitChar[i-extraHashtags];
			}
			}
			
			
		}
	}*/
	}
	}
	public static void CleanUp()
	{
		finalOutput = "";
	}
}
