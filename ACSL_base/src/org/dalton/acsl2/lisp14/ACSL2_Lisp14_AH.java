package org.dalton.acsl2.lisp14;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Anna Hirschorn
 * Dalton School
 * 3055
 */
public class ACSL2_Lisp14_AH 
{
	public static String[] sublists;
	
	public static void print(String[] copy)
	{
		System.out.print("(");
		System.out.print(copy[0]);

		for (int i = 1; i < copy.length; i++) 
		{
			if(!copy[i].equals("")) System.out.print(" ("+copy[i]+")");		
		}
		System.out.print(")");
	}

	public static void count()
	{
		System.out.println(sublists.length-1);
	}
	public static void remove(int bound1, int bound2)
	{
		String[] copy = sublists.clone();
		for (int i = bound1; i <= bound2; i++) 
		{
			copy[i]="";
		}
		print(copy);
		
	}
	public static void sort(int bound1, int bound2)
	{		
		String[] copy = sublists.clone();
		Arrays.sort(copy, bound1, bound2+1);
		print(copy);
	}
	public static void reverse(int bound1, int bound2)
	{
		String[] copy = sublists.clone();

		System.out.print("(");
		System.out.print(copy[0]);
	
		for (int j = 1; j < copy.length; j++) 
		{
			if(j==bound1){

				for ( int i = bound2 ; i >= bound1 ; i-- )
				{
					System.out.print(" ("+copy[i]+")");	
				}
			}
			else if(j>bound1 && j<=bound2) continue;
			else System.out.print(" ("+copy[j]+")");
		}

		System.out.print(")");
	}
	public static void max()
	{
		String[] amounts;
		int top=0;

		for (int i = 1; i < sublists.length; i++) 
		{
			amounts=sublists[i].split(" ");
			if(amounts.length>top)
			{
				top=i;
			}
		}
		System.out.println("("+sublists[top]+")");	
	}

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		String data = scan.nextLine();
		sublists = data.split(" \\(");
		for (int i = 0; i < sublists.length; i++) 
		{
			sublists[i]=sublists[i].replace("(","");
			sublists[i]=sublists[i].replace(")","");
		}
		/*
		for (int i = 0; i < sublists.length; i++) {
			System.out.println(sublists[i]);
		}
		*/

		for (int i = 0; i < 5; i++) 
		{
			String instruct = scan.nextLine();

			if(instruct.startsWith("C"))
			{
				count();
			}
			else if(instruct.startsWith("S"))
			{	
				String[] para = instruct.split(" ");
				int bound1 = Integer.parseInt(para[1]);
				int bound2 = Integer.parseInt(para[2]);
				sort(bound1, bound2);	
			}
			else if(instruct.startsWith("M"))
			{
				max();
			}
			else if(instruct.contains("REM"))
			{	
				String[] para = instruct.split(" ");
				int bound1 = Integer.parseInt(para[1]);
				int bound2 = Integer.parseInt(para[2]);
				remove(bound1, bound2);
			}
			else
			{
				String[] para = instruct.split(" ");
				int bound1 = Integer.parseInt(para[1]);
				int bound2 = Integer.parseInt(para[2]);
				reverse(bound1, bound2);
			}	
			/*
			for (int k = 0; k < sublists.length; k++) {
				System.out.println(sublists[k]);
			}
			*/
		}
	}
}
