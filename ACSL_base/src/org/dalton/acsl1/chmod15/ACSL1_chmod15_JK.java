package org.dalton.acsl1.chmod15;
import java.util.Scanner;

/**********
 * Name: Jamie Konigsberg
 * Purpose: Complete ACSL 1
 * Date: 1/4/16
 */

public class ACSL1_chmod15_JK {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		for(int i = 0; i<5; i++)
		{
			String[] input = s.nextLine().split(", ");
			int[]input1 = new int[input.length];
			for(int j = 0; j < input.length; j++) {
				input1[j] = Integer.parseInt(input[j]);
			}
			
			for(int k = 1; k<input1.length; k++)
			{
				if(input1[k] == 0)
				{
					System.out.print("000 ");
				}
				else if(input1[k] == 1)
				{
					System.out.print("001 ");
				}
				else if(input1[k] == 2)
				{
					System.out.print("010 ");
				}
				else if(input1[k] == 3)
				{
					System.out.print("011 ");
				}
				else if(input1[k] == 4)
				{
					System.out.print("100 ");
				}
				else if(input1[k] == 5)
				{
					System.out.print("101 ");
				}
				else if(input1[k] == 6)
				{
					System.out.print("110 ");
				}
				else if(input1[k] == 7)
				{
					System.out.print("111 ");
				}						
			}
			System.out.print("and ");
			
			for(int l = 1; l<input1.length; l++)
			{
				if(input1[l] == 0)
				{
					System.out.print("--- ");
				}
				else if(input1[l] == 1)
				{
					if(input1[0] == 1 && l == 1)
					{
					  System.out.print("--s ");
					}
					else if(input1[0] == 2 && l == 2)
					{
					  System.out.print("--s ");
					}
					else if(input1[0] == 4 && l == 3)
					{
					  System.out.print("--t ");
					}
					else
					{
						System.out.print("--x ");
					}
				}
				else if(input1[l] == 2)
				{
					System.out.print("-w- ");
				}
				else if(input1[l] == 3)
				{
					if(input1[0] == 1 && l == 1)
					{
					  System.out.print("-ws ");
					}
					else if(input1[0] == 2 && l == 2)
					{
					  System.out.print("-ws ");
					}
					else if(input1[0] == 4 && l == 3)
					{
					  System.out.print("-wt ");
					}
					else
					{
						System.out.print("-wx ");
					}
				}
				else if(input1[l] == 4)
				{
					System.out.print("r-- ");
				}
				else if(input1[l] == 5)
				{
					if(input1[0] == 1 && l == 1)
					{
					  System.out.print("r-s ");
					}
					else if(input1[0] == 2 && l == 2)
					{
					  System.out.print("r-s ");
					}
					else if(input1[0] == 4 && l == 3)
					{
					  System.out.print("r-t ");
					}
					else
					{
						System.out.print("r-x ");
					}
				}
				else if(input1[l] == 6)
				{
					System.out.print("rw- ");
				}
				else 
				{
					if(input1[0] == 1 && l == 1)
					{
					  System.out.print("rws ");
					}
					else if(input1[0] == 2 && l == 2)
					{
					  System.out.print("rws ");
					}
					else if(input1[0] == 4 && l == 3)
					{
					  System.out.print("rwt ");
					}
					else
					{
						System.out.print("rwx ");
					}
				}		
			}
			System.out.println();
		}
	}
}