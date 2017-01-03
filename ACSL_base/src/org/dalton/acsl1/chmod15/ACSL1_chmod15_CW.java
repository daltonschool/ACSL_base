package org.dalton.acsl1.chmod15;
/*
 * Charlotte Watts
 * ACSL CHMOD
 * 
 */

import java.util.Scanner;
public class ACSL1_chmod15_CW {
	
	public static void main(String[] args)
	{
		//declarations
		int x = 0;
		//for(int i = 0; i < 2048; i++)
		while(x<5)
		{
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String dig1 = String.valueOf(input.charAt(0));
		String dig2 = String.valueOf(input.charAt(3));
		String dig3 = String.valueOf(input.charAt(6));
		String dig4 = String.valueOf(input.charAt(9));
		int digg1 = Integer.parseInt(dig1);
		//int digg2 = Integer.parseInt(dig2);
		//int digg3 = Integer.parseInt(dig3);
		//int digg4 = Integer.parseInt(dig4);
		String binary2 = "";
		String binary3 = "";
		String binary4 = "";
		int dec2 = 0;
		int dec3 = 0;
		int dec4 = 0;
		String permission1 = "";
		String permission2 = "";
		String permission3 = "";
		
		
	
	//convert from octal to binary
		
		dec2 = Integer.parseInt(dig2, 8);
		dec3 = Integer.parseInt(dig3, 8);
		dec4 = Integer.parseInt(dig4, 8);
		
		binary2 = Integer.toBinaryString(dec2);
		binary3 = Integer.toBinaryString(dec3);
		binary4 = Integer.toBinaryString(dec4);
		if(binary2.length() ==2)
		{
			binary2 = "0" + binary2;
		}
		else if(binary2.length()==1)
		{
			binary2 = "00" + binary2;
		}
		
		if(binary3.length() ==2)
		{
			binary3 = "0" + binary3;
		}
		else if(binary3.length()==1)
		{
			binary3 = "00" + binary3;
		}
		if(binary4.length() ==2)
		{
			binary4 = "0" + binary4;
		}
		else if(binary4.length()==1)
		{
			binary4 = "00" + binary4;
		}
		
		//permissions
		//first digit is 0
		if(digg1==0)
		{
			if(binary2.charAt(0)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(0)=='1')
			{
				permission1 = permission1 + "r";
				
			}
			if(binary2.charAt(1)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(1)=='1')
			{
				permission1 = permission1 + "w";
				
			}
			if(binary2.charAt(2)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(2)=='1')
			{
				permission1 = permission1 + "x";
				
			}
			
			if(binary3.charAt(0)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(0)=='1')
			{
				permission2 = permission2 + "r";
				
			}
			if(binary3.charAt(1)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(1)=='1')
			{
				permission2 = permission2 + "w";
				
			}
			if(binary3.charAt(2)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(2)=='1')
			{
				permission2 = permission2 + "x";
				
			}
			
			if(binary4.charAt(0)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(0)=='1')
			{
				permission3 = permission3 + "r";
				
			}
			if(binary4.charAt(1)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(1)=='1')
			{
				permission3 = permission3 + "w";
				
			}
			if(binary4.charAt(2)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(2)=='1')
			{
				permission3 = permission3 + "x";
				
			}
			
			
		}
		else if(digg1==1)
		{
			if(binary2.charAt(0)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(0)=='1')
			{
				permission1 = permission1 + "r";
				
			}
			if(binary2.charAt(1)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(1)=='1')
			{
				permission1 = permission1 + "w";
				
			}
			if(binary2.charAt(2)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(2)=='1')
			{
				permission1 = permission1 + "s";
				
			}
			
			if(binary3.charAt(0)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(0)=='1')
			{
				permission2 = permission2 + "r";
				
			}
			if(binary3.charAt(1)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(1)=='1')
			{
				permission2 = permission2 + "w";
				
			}
			if(binary3.charAt(2)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(2)=='1')
			{
				permission2 = permission2 + "x";
				
			}
			
			if(binary4.charAt(0)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(0)=='1')
			{
				permission3 = permission3 + "r";
				
			}
			if(binary4.charAt(1)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(1)=='1')
			{
				permission3 = permission3 + "w";
				
			}
			if(binary4.charAt(2)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(2)=='1')
			{
				permission3 = permission3 + "x";
				
			}
			
		}
		else if(digg1 == 2)
		{
			if(binary2.charAt(0)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(0)=='1')
			{
				permission1 = permission1 + "r";
				
			}
			if(binary2.charAt(1)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(1)=='1')
			{
				permission1 = permission1 + "w";
				
			}
			if(binary2.charAt(2)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(2)=='1')
			{
				permission1 = permission1 + "x";
				
			}
			
			if(binary3.charAt(0)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(0)=='1')
			{
				permission2 = permission2 + "r";
				
			}
			if(binary3.charAt(1)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(1)=='1')
			{
				permission2 = permission2 + "w";
				
			}
			if(binary3.charAt(2)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(2)=='1')
			{
				permission2 = permission2 + "s";
				
			}
			
			if(binary4.charAt(0)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(0)=='1')
			{
				permission3 = permission3 + "r";
				
			}
			if(binary4.charAt(1)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(1)=='1')
			{
				permission3 = permission3 + "w";
				
			}
			if(binary4.charAt(2)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(2)=='1')
			{
				permission3 = permission3 + "x";
				
			}
		}
		else if(digg1==4)
		{
			if(binary2.charAt(0)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(0)=='1')
			{
				permission1 = permission1 + "r";
				
			}
			if(binary2.charAt(1)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(1)=='1')
			{
				permission1 = permission1 + "w";
				
			}
			if(binary2.charAt(2)=='0')
			{
				permission1 = permission1 + "-";
				
			}
			else if(binary2.charAt(2)=='1')
			{
				permission1 = permission1 + "x";
				
			}
			
			if(binary3.charAt(0)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(0)=='1')
			{
				permission2 = permission2 + "r";
				
			}
			if(binary3.charAt(1)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(1)=='1')
			{
				permission2 = permission2 + "w";
				
			}
			if(binary3.charAt(2)=='0')
			{
				permission2 = permission2 + "-";
				
			}
			else if(binary3.charAt(2)=='1')
			{
				permission2 = permission2 + "x";
				
			}
			
			if(binary4.charAt(0)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(0)=='1')
			{
				permission3 = permission3 + "r";
				
			}
			if(binary4.charAt(1)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(1)=='1')
			{
				permission3 = permission3 + "w";
				
			}
			if(binary4.charAt(2)=='0')
			{
				permission3 = permission3 + "-";
				
			}
			else if(binary4.charAt(2)=='1')
			{
				permission3 = permission3 + "t";
				
			}
		}
		
		
		//print
		System.out.println(binary2 + " " + binary3 + " " + binary4 + " and " + permission1 + " " + permission2 + " " + permission3);
		
		x++;
		}
	
		
	
	}
}
