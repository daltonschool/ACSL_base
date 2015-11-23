package org.dalton.acsl1.prints10;

/* ASCL 1
 * Whorl
 * Darshan Desai
 * 
 * 
 * 
 * 
 */
import java.util.Scanner;

public class Darshan_Whorl 

{
	public static void main(String args[]) 
	{
		for (int k=0; k<5; k++)
		{
			String input;
			Scanner scan = new Scanner(System.in);
			String output= "";
			boolean evennone= false;
			boolean oddnone= false;
			System.out.println("Please enter the Primary Group Ratio," +
			"\nusing a comma to separate the numerator and denominator");

			input= scan.nextLine();
			String[]b = input.split(",");


			int int1 = Integer.parseInt(b[0].trim())-1;//even integer

			//System.out.println(b[0] +" "+ b[1]);
			if (int1>32)//quite possibly unnecessarily...
			{
				output= output+ "The top number is too high and  ";
			}
			else if(int1>=1)
			{
				if (int1>=16)
				{	
					//System.out.println("Greater than 16");
					//set finger 2
					//System.out.println("Finger 2");
					//System.out.println(int1);

					output= output +"2, ";
					int1= int1-16; 
				}
				if (int1>=8)
				{ 
					//System.out.println("Remainder is greater than 8");
					//set finger 4
					//System.out.println("Finger 4");
					//System.out.println(int1);

					output= output +"4, ";
					int1=int1-8; 
				}
				if (int1>=4)
				{
					//System.out.println("Remainder 2 is greater than 4");
					//set finger 6
					//System.out.println("Finger 6");
					//System.out.println(int1);

					output= output +"6, ";
					int1=int1-4; 
				}
				if (int1>=2)
				{
					//System.out.println("Remainder 3 is greater than 2");
					//set finger 8
					//System.out.println("Finger 8");
					//System.out.println(int1);

					output= output +"8, ";
					int1=int1-2; 
				}
				if (int1>=1)
				{
					//System.out.println("Remainder 4 is greater than 1");
					//set finger 10
					//System.out.println("Finger 10");
					//System.out.println(int1);

					output= output +"10, ";
					int1=int1-1; 

				}
			}
			else
			{
				//System.out.println("None");
				evennone=true;




			}

			int int2 = Integer.parseInt(b[1].trim())-1;
			if(int2>32)
			{
				output= output+ "The bottom number is too high  "  ;
			}
			else if (int2>=1)
			{
				if (int2>=16)
				{	
					//System.out.println("Greater than 16");
					//set finger 1
					//System.out.println("Finger 1");
					//System.out.println(int2);

					output= output +"1, ";
					int2= int2-16; 
				}
				if (int2>=8)
				{ 
					//System.out.println("Remainder is greater than 8");
					//set finger 3
					//System.out.println("Finger 3");
					//System.out.println(int2);

					output= output +"3, ";
					int2=int2-8; 
				}
				if (int2>=4)
				{
					//System.out.println("Remainder 2 is greater than 4");
					//set finger 5
					//System.out.println("Finger 5");
					//System.out.println(int2);

					output= output +"5, ";
					int2=int2-4; 
				}
				if (int2>=2)
				{
					//System.out.println("Remainder 3 is greater than 2");
					//set finger 7
					//System.out.println("Finger 7");
					//System.out.println(int2);

					output= output +"7, ";
					int2=int2-2; 
				}
				if (int2>=1)
				{
					//System.out.println("Remainder 4 is greater than 1");
					//set finger 9
					//System.out.println("Finger 9");
					//System.out.println(int1);

					output= output +"9, ";
					int1=int1-1; 
				}
			}

			else
			{
				//System.out.println("None");
				oddnone=true;

				if (evennone && oddnone == true)
				{
					output="None  ";
				}
			}


			System.out.println(output.substring(0, output.length()-2));

		}

	}

}
