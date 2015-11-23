package org.dalton.acsl1.prints10;

/**
 * @author Johnny Kruger
 * The Dalton School
 * Code: 9075
 */
import java.util.Scanner;
public class Fingerprints
{
	public static void main(String[] Args)
	{
		for (int i=0; i<5; i++)
		{
		Scanner in = new Scanner (System.in);
		String input = in.nextLine();
		int index = input.indexOf(",");
		int a = Integer.parseInt(input.substring(0, index).trim());
		int b = Integer.parseInt(input.substring(index+1).trim());
		String evenReturn = "";
		String oddReturn = "";
		a=a-1;
		b=b-1;
		if (a>0 && a<32)
			evenReturn=EvenMethod(a);
		if (b>0 && b<32)
			oddReturn=OddMethod(b);
		if ((b<1 || b>31) && (a<1 || a>31))
			System.out.println("None");
		else 
			System.out.println((evenReturn + oddReturn).substring(0, (evenReturn + oddReturn).length()-2));
		}
		}

	public static String EvenMethod(int even)
	{
		String evenString = "";

		if (even-16>=0)
		{
			even=even-16;
			evenString += "2, "; 
		}
		if (even-8>=0)
		{
			even=even-8;
			evenString += "4, "; 
		}
		if (even-4>=0)
		{
			even=even-4;
			evenString += "6, "; 
		}
		if (even-2>=0)
		{
			even=even-2;
			evenString += "8, "; 
		}
		if (even-1>=0)
		{
			even=even-1;
			evenString += "10, "; 
		}
		return evenString;
	}
	
	public static String OddMethod(int odd)
	{
		String oddString = "";

		if (odd-16>=0)
		{
			odd=odd-16;
			oddString += "1, "; 
		}
		if (odd-8>=0)
		{
			odd=odd-8;
			oddString += "3, "; 
		}
		if (odd-4>=0)
		{
			odd=odd-4;
			oddString += "5, "; 
		}
		if (odd-2>=0)
		{
			odd=odd-2;
			oddString += "7, "; 
		}
		if (odd-1>=0)
		{
			odd=odd-1;
			oddString += "9, "; 
		}
		return oddString;
	}
}
