package org.dalton.acsl2.string15;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 
 * @author Alexis Harris
 * ACSL 2 String
 * 
 */

public class ACSL2_string15_AH {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
		
		String[]input = new String[3];
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine().split(", "); //this works
		
		String correctDecimals = decimals(input[0], input[2]);
		
		if(input[0].contains("+"))
		{
			correctDecimals = "+" + correctDecimals;
		}
		
		String correctLegnth = legnth(correctDecimals, input[1]);
		
		System.out.println(correctLegnth);
		
		}
	}
	
	public static String legnth(String input, String legnth)
	{
		String adjustedL = input;
		int desiredL = Integer.parseInt(legnth);
		String corrected = "";
		
		if(adjustedL.length() > desiredL)
		{
			//need to cut from the front (not the back bc end up loosing decimal
			
			for (int i = adjustedL.length()-desiredL; i < desiredL+(adjustedL.length()-desiredL); i++) {
				if(adjustedL.charAt(i) == '.')
				{
					corrected = corrected + ".";
				}
				else
				{
					corrected = corrected + "#";
				}
			}
		}
		
		else if(adjustedL.length() < desiredL)
		{
			for (int i = 0; i < desiredL; i++) {
				if(i < desiredL-adjustedL.length())
				{
					corrected = "#" + corrected;
				}
			}
			
			corrected = corrected + input;
		}
		
		else
		{
			corrected = input;
		}
		
		
		return corrected;
		 
	}
	
	public static String decimals(String input, String decimals)
	{
		float correctL = Float.parseFloat(input);
		int legnth = Integer.parseInt(decimals);
		
		BigDecimal bd = new BigDecimal(Float.toString(correctL));
		bd = bd.setScale(legnth, BigDecimal.ROUND_HALF_UP);       
        
		String adjustedLen = bd.toString();
		
		return adjustedLen;
	}

}
