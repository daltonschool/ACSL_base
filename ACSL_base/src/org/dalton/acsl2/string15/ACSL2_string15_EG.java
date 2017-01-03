package org.dalton.acsl2.string15;

import java.util.*;
import java.math.*;
public class ACSL2_string15_EG {
	public static void main(String[] args) {
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			String inputString[] = input.split(", ");
			int length = Integer.parseInt(inputString[1]);
			int decimal = Integer.parseInt(inputString[2]);
			double firstHalf;
			double secondHalf;
			int leftover;
			int secondover;
			boolean minus = false;
			boolean plus = false;
			//System.out.println(inputString[0]);
			if(inputString[0].contains("-"))
			{
				//	System.out.println("hi5");
				minus = true;
				inputString[0] = inputString[0].substring(1);
			}
			if(inputString[0].contains("+"))
			{
				//	System.out.println("hi6");
				plus = true;
				inputString[0] = inputString[0].substring(1);
			}
			String numberString[] = inputString[0].split("\\.");
			firstHalf = Integer.parseInt(numberString[0]);
			secondHalf = Integer.parseInt(numberString[1]);
			leftover = length - numberString[0].length();
			//			if(leftover < 0 && decimal == 0)
			//			{
			//				System.out.println("hi");
			//				if(minus==true||plus==true)
			//				{
			//				firstHalf = (double)firstHalf/(Math.pow(10,-(leftover-1)));
			//				System.out.println(firstHalf);
			//				firstHalf = Math.round(firstHalf);
			//				System.out.println(firstHalf);
			//				firstHalf = firstHalf*(Math.pow(10,-(leftover-1)));
			//				System.out.println(firstHalf);
			//				if(minus == true)
			//				{
			//					System.out.print("-"+firstHalf);
			//				}
			//				else if(plus == true)
			//				{
			//					System.out.print("+"+firstHalf);
			//				}
			//				}
			//				else
			//				{
			//				firstHalf = (double)firstHalf/(Math.pow(10,-(leftover)));
			//				System.out.println(firstHalf);
			//				firstHalf = Math.round(firstHalf);
			//				System.out.println(firstHalf);
			//				//firstHalf = firstHalf*(Math.pow(10,-(leftover)));
			//				System.out.println((int)firstHalf);
			//				}
			//				
			//			}
			if(numberString[1].length()>=decimal&&leftover-1>=decimal&&plus==false&&minus==false)
			{
				//	System.out.println("hi2");
				secondover = numberString[1].length() - decimal;
				secondHalf = (double)secondHalf/(Math.pow(10,(secondover)));
				//	System.out.println(secondHalf);
				secondHalf = Math.round(secondHalf);
				//	System.out.println(secondHalf);
				//firstHalf = firstHalf*(Math.pow(10,-(leftover)));
				//	System.out.println((int)secondHalf);
				for (int i = 0; i < leftover-decimal-1; i++) {
					System.out.print("#");
				}
				System.out.print((int)firstHalf+"."+(int)secondHalf);

			}
			else if(numberString[1].length()>=decimal&&(leftover-2)>=decimal)
			{
				//	System.out.println("hi3");
				secondover = numberString[1].length() - decimal;
				secondHalf = (double)secondHalf/(Math.pow(10,(secondover)));
				//System.out.println(secondHalf);
				secondHalf = Math.round(secondHalf);
				//	System.out.println(secondHalf);
				//firstHalf = firstHalf*(Math.pow(10,-(leftover)));
				//	System.out.println((int)secondHalf);

				if(plus==true)
				{
					for (int i = 0; i < leftover-decimal-2; i++) {
						System.out.print("#");
					}
					System.out.print("+"+(int)firstHalf+"."+(int)secondHalf);
				}
				else
				{
					for (int i = 0; i < leftover-decimal-2; i++) {
						System.out.print("#");
					}
					System.out.print("-"+(int)firstHalf+"."+(int)secondHalf);
				}

			}
			else 
			{
				//	System.out.println("hi4");
				for (int i = 0; i < length-decimal-1; i++) 
				{
					System.out.print("#");
				}
				System.out.print(".");
				for (int i = 0; i < decimal; i++) 
				{
					System.out.print("#");
				}


			}

			System.out.println();
		}
	}
}
