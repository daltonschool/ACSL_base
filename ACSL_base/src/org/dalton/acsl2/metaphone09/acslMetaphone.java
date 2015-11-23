/**
 * Anne Madoff
 * The Dalton School
 * School Code: 9010
 */

package org.dalton.acsl2.metaphone09;

import java.util.Scanner;

public class acslMetaphone {

	public static StringBuffer transformMe(StringBuffer buf)
	{
		StringBuffer converted = new StringBuffer(buf);
		Boolean step2 = true;
		Boolean step3 = true;

		//Step 1
		if((converted.charAt(1)=='A' && converted.charAt(2)=='E') || (converted.charAt(1)=='G' && converted.charAt(2)=='N') || (converted.charAt(1)=='K' && converted.charAt(2)=='N') || (converted.charAt(1)=='P' && converted.charAt(2)=='N') || (converted.charAt(1)=='W' && converted.charAt(2)=='R'))
		{
			converted.deleteCharAt(1);
		}

		if(converted.charAt(1)== 'X')
		{
			converted.replace(1, 2, "S");
		}

		if(converted.charAt(1)=='W' && converted.charAt(2) == 'H')
		{
			converted.deleteCharAt(2);
		}

		//Step 2
		step2Loop: while(step2)
		{
			if(converted.charAt(converted.length()-2)== 'B' && converted.charAt(converted.length()-3)== 'M')
			{
				converted.deleteCharAt(converted.length()-2);
				continue step2Loop;
			}

			for(int pos =2; pos<converted.length()-3; pos++)
			{
				if((converted.charAt(pos)=='C' && converted.charAt(pos-1) == 'S' && converted.charAt(pos+1)=='I') ||( converted.charAt(pos)=='C' && converted.charAt(pos-1) == 'S' && converted.charAt(pos+1)=='Y'))
				{
					converted.deleteCharAt(pos);
					continue step2Loop;
				}
			}

			for(int pos =1; pos<converted.length()-2; pos++)
			{
				if((converted.charAt(pos)== 'C' && converted.charAt(pos+1) == 'I' && converted.charAt(pos+2) == 'A') || (converted.charAt(pos)== 'C' && converted.charAt(pos+1) == 'H') || (converted.charAt(pos)== 'C' && converted.charAt(pos+1) == 'I') || (converted.charAt(pos)== 'C' && converted.charAt(pos+1) == 'E') ||(converted.charAt(pos)== 'C' && converted.charAt(pos+1) == 'Y' ))
				{
					converted.replace(pos, pos+1, "X");
					continue step2Loop;
				}
			}

			for(int pos =1; pos<converted.length(); pos++)
			{
				if(converted.charAt(pos)== 'C')
				{
					converted.replace(pos, pos+1, "K");
					continue step2Loop;
				}
			}

			for(int pos =0; pos<converted.length()-3; pos++)
			{
				if(converted.charAt(pos) == 'D' && converted.charAt(pos+1) == 'G' && converted.charAt(pos+2) == 'E' ||converted.charAt(pos) == 'D' && converted.charAt(pos+1) == 'G' && converted.charAt(pos+2) == 'Y' || converted.charAt(pos) == 'D' && converted.charAt(pos+1) == 'G')
				{
					converted.replace(pos, pos+1, "J");
					continue step2Loop;
				}
			}

			for(int pos =1; pos<converted.length()-1; pos++)
			{
				if(converted.charAt(pos) == 'D')
				{
					converted.replace(pos, pos+1, "T");
					continue step2Loop;
				}
			}

			for(int pos =1; pos<converted.length()-2; pos++)
			{
				if(converted.charAt(pos) == 'G' && ((converted.charAt(pos-1) == 'A' || converted.charAt(pos-1) == 'E' || converted.charAt(pos-1) == 'I' || converted.charAt(pos-1) == 'O' || converted.charAt(pos-1) == 'U') && !(converted.charAt(pos+1) == 'A' || converted.charAt(pos+1) == 'E' || converted.charAt(pos+1) == 'I' || converted.charAt(pos+1) == 'O' || converted.charAt(pos+1) == 'U')))
				{
					converted.deleteCharAt(pos);
					continue step2Loop;
				}
			}

			for(int pos =1; pos<converted.length()-2; pos++)
			{
				if(converted.charAt(pos) == 'G' && (converted.charAt(pos+1) == 'I' || converted.charAt(pos+1) == 'E' || converted.charAt(pos+1) == 'Y') && converted.charAt(pos-1) != 'G')
				{
					converted.replace(pos, pos+1, "J");
					continue step2Loop;
				}
			}

			for(int pos =1; pos<converted.length()-1; pos++)
			{
				if(converted.charAt(pos) == 'G')
				{
					converted.replace(pos, pos+1, "K");
					continue step2Loop;
				}
			}

			for(int pos =1; pos<converted.length()-1; pos++)
			{
				if((converted.charAt(pos)=='H' && (converted.charAt(pos-1) == 'A' || converted.charAt(pos-1) == 'E' || converted.charAt(pos-1) == 'I' || converted.charAt(pos-1) == 'O' || converted.charAt(pos-1) == 'U') && !(converted.charAt(pos+1) == 'A' || converted.charAt(pos+1) == 'E' || converted.charAt(pos+1) == 'I' || converted.charAt(pos+1) == 'O' || converted.charAt(pos+1) == 'U')) || (converted.charAt(pos) == 'H' && (converted.charAt(pos-1) == 'C' || converted.charAt(pos-1) == 'S' || converted.charAt(pos-1) == 'P' || converted.charAt(pos-1) == 'T' || converted.charAt(pos-1) == 'G')))
				{
					converted.deleteCharAt(pos);
					continue step2Loop;
				}
			}

			for(int pos =1; pos<converted.length()-3; pos++)
			{
				if(converted.charAt(pos)=='P' && converted.charAt(pos+1) == 'H')
				{
					converted.replace(pos, pos+1, "F");
					continue step2Loop;
				}
			}

			for(int pos =1; pos<converted.length()-1; pos++)
			{
				if(converted.charAt(pos) == 'Q')
				{
					converted.replace(pos, pos+1, "K");
					continue step2Loop;
				}
			}

			for(int pos= 1; pos<converted.length()-3; pos++)
			{
				if((converted.charAt(pos) == 'S' && converted.charAt(pos+1) == 'H') || converted.charAt(pos) == 'S' && (converted.charAt(pos+1) == 'I' && (converted.charAt(pos+2) == 'O' || converted.charAt(pos+2) == 'A')))
				{
					converted.replace(pos,pos+1,"X");
					continue step2Loop;
				}
			}

			for(int pos= 0; pos<converted.length()-3; pos++)
			{
				if(converted.charAt(pos) == 'T' && converted.charAt(pos+1) == 'I' && (converted.charAt(pos+2)== 'A' || converted.charAt(pos+2) == 'O'))
				{
					converted.replace(pos, pos+1, "X");
					continue step2Loop;
				}
			}

			for(int pos= 1; pos<converted.length()-1; pos++)
			{
				if(converted.charAt(pos) == 'V')
				{
					converted.replace(pos, pos+1, "F");
					continue step2Loop;
				}
			}

			for(int pos= 1; pos<converted.length()-2; pos++)
			{
				if(converted.charAt(pos) == 'W' && !(converted.charAt(pos+1) == 'A' || converted.charAt(pos+1) == 'E' || converted.charAt(pos+1) == 'I' || converted.charAt(pos+1) == 'O' || converted.charAt(pos+1) == 'U'))
				{
					converted.deleteCharAt(pos);
					continue step2Loop;
				}
			}

			for(int pos= 1; pos<converted.length()-1; pos++)
			{
				if(converted.charAt(pos) == 'Y' && !(converted.charAt(pos+1) == 'A' || converted.charAt(pos+1) == 'E' || converted.charAt(pos+1) == 'I' || converted.charAt(pos+1) == 'O' || converted.charAt(pos+1) == 'U'))
				{
					converted.deleteCharAt(pos);
					continue step2Loop;
				}
			}

			for(int pos= 1; pos<converted.length()-1; pos++)
			{
				if(converted.charAt(pos) == 'Z')
				{
					converted.replace(pos, pos+1, "S");
					continue step2Loop;
				}
			}

			boolean bool = true;
			repeatyLetterLoop: while(bool)
			{
				for(int k =1; k<converted.length()-1; k++)
				{
					if(converted.charAt(k) == converted.charAt(k+1))
					{
						converted.deleteCharAt(k+1);
						continue repeatyLetterLoop;
					}
				}
				bool = false;
			}
			
			step2= false;
		}//closes step 2 while

		//Step 3
		vowelCheckLoop: while(step3)
		{
			for(int i =0; i<converted.length(); i++)
			{
				if(converted.charAt(i)=='A' || converted.charAt(i)=='E' || converted.charAt(i)=='I' || converted.charAt(i)=='O' || converted.charAt(i)=='U')
				{
					converted.deleteCharAt(i);
					continue vowelCheckLoop;
				}
			}
			step3 = false;
		}
		//Final return statement	
		return converted;
	}	

	public static void main(String[] args) 
	{//opens main

		Scanner input = new Scanner(System. in);

		System.out.println("Please type a string of letters without any spaces.");

		StringBuffer one = new StringBuffer(" " + input.nextLine().toUpperCase() + " ");

		System.out.println("Please type a string of letters without any spaces.");

		StringBuffer two = new StringBuffer(" " + input.nextLine().toUpperCase() + " ");

		System.out.println("Please type a string of letters without any spaces.");

		StringBuffer three = new StringBuffer(" " + input.nextLine().toUpperCase() + " ");

		System.out.println("Please type a string of letters without any spaces.");

		StringBuffer four = new StringBuffer(" " + input.nextLine().toUpperCase() + " ");

		System.out.println("Please type a string of letters without any spaces.");

		StringBuffer five = new StringBuffer(" " + input.nextLine().toUpperCase() + " ");

		System.out.println("1. " + transformMe(one));
		System.out.println("2. " + transformMe(two));
		System.out.println("3. " + transformMe(three));
		System.out.println("4. " + transformMe(four));
		System.out.println("5. " + transformMe(five));

	}

}