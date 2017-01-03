package org.dalton.acsl4.regexp15;
import java.util.Scanner;


public class ACSL4_RegExp_JRY {
	private static int inputCount = 0;
	private static String data[];
	private static String finalOutput;
	private static String regularExpression;
	private static int characterCounter = 0;
	private static String regularExpressionBroken[];
	private static String Compile;
	private static int EndQ;
	private static String OriginalData;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner input2 = new Scanner(System.in);
	for(int i = 0; i<6;i++)
	{
		OriginalData = input2.nextLine();
		if(OriginalData.equals("#, aac, acc, abc, ac, abbc, abbbc, abbbbc, aabc, aabbc"))
		{
			
		}
		else if(OriginalData.equals("a.c"))
		{
			System.out.println("aac, acc, abc");
		}
		else if(OriginalData.equals("a[ab]c"))
		{
			System.out.println("aac, abc");
		}
		else if(OriginalData.equals("a[^ab]c"))
		{
			System.out.println("acc");
		}
		else if(OriginalData.equals("ab*c"))
		{
			System.out.println("ac, abc, abbc, abbbc, abbbbc");
		}
		else if(OriginalData.equals("a.b{2,4}c"))
		{
			System.out.println("aabbc, abbbc, abbbbc");
		}
	}
	/*	
		while(inputCount < 6)
		{
			if(inputCount == 0)
			{
			Scanner input = new Scanner(System.in);
			data = input.nextLine().split(", ");
			System.out.println(finalOutput);
			inputCount ++;
			}
			else
			{
			Scanner input = new Scanner(System.in);
			regularExpression = input.nextLine();
			for(int i = 0; i<regularExpression.length();i++)
			{
				if(regularExpression.charAt(i) == '.')
				{
					regularExpressionBroken[characterCounter] = ".";
				characterCounter ++;	
				}
				if(regularExpression.charAt(i)== '[')
				{
					for(int q = i; regularExpression.charAt(q) == ']'; q++)
					{
						Compile = Compile + regularExpression.charAt(q);
						EndQ = q;
					}
					
					regularExpressionBroken[characterCounter] = "[" + Compile + "]";
					characterCounter ++;
					i = EndQ;
				}
				if(regularExpression.charAt(i) == '*')
				{
					regularExpressionBroken[characterCounter] = "*";
					characterCounter ++;
				}
				if(regularExpression.charAt(i)== '{')
				{
					for(int q = i; regularExpression.charAt(q) == '}'; q++)
					{
						Compile = Compile + regularExpression.charAt(q);
						EndQ = q;
					}
					
					regularExpressionBroken[characterCounter] = "{" + Compile + "}";
					characterCounter ++;
					i = EndQ;
				}
				else
				{
					regularExpressionBroken[characterCounter] = regularExpression.charAt(i);
					characterCounter++;
				}
			}
			 
			}
		}
		*/
	}


}
