package org.dalton.acsl1.prints10;

/*
 * Noah Levy
 * ACSL Program 1
 * 12/15/10
 * Dalton School
 * School Code: 9075
 */
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class ACSL1_Whorl {

	private final static int WhorlFingers[][] = {{10,9,8,7,6,1,2,3,4,5} , {1,1,2,2,4,16,16,8,8,4}};
	private static ArrayList<Integer> answers = new ArrayList<Integer>();
	private static ArrayList<Integer> answers2 = new ArrayList<Integer>();
	private static Scanner scan = new Scanner(System.in);
	private static final boolean debug = false;
	public static void main(String[]args)
	{


		for(int i = 0; i < 5; i++)
		{
			System.out.print(i+1 +". ");
			operate();
			if(debug)
			{
				System.out.println("Using Binary Method: " + form(answers));
				System.out.println("Using Stoopid Method: " + form(answers2));
				System.out.println("done");
			}
			if(!debug)
			{
				System.out.println(form(answers));
			}

		}
		

	}
	private static String form(ArrayList<Integer> AnswerList)
	{
		Integer ia[] = new Integer[AnswerList.size()];
		ia = AnswerList.toArray(ia);
		Arrays.sort(ia);
		String answer = Arrays.toString(ia);
		String withoutbrackets = answer.substring(1, answer.length() - 1);
		if(withoutbrackets.equals(""))
		{
			return "None";
		}
		return (withoutbrackets + "\n");

	}
	private static void operate()
	{
		answers.clear();
		answers2.clear();

		String tempArray[] = new String[2];
		String choice = scan.nextLine(); //new String = choice
		tempArray = choice.split(", ");

		tempArray[1].trim();
		tempArray[0].trim();

		int first = Integer.parseInt(tempArray[0]);
		int second = Integer.parseInt(tempArray[1]);

		int topvaleven = first - 1;
		int bottomvalodd = second - 1;

		answers.addAll(binaryStrategy(topvaleven, true));
		answers.addAll(binaryStrategy(bottomvalodd, false));
		if(debug)
		{
		answers2.addAll(breakdown(topvaleven, true));
		answers2.addAll(breakdown(bottomvalodd, false));
		}


	}
	private static ArrayList<Integer> binaryStrategy(int value, boolean eveness)
	{
		int initialnum = 1;
		if(eveness)
		{
			initialnum = 2;
		}
		ArrayList<Integer> soln = new ArrayList<Integer>();
		String BinaryVer = Integer.toBinaryString(value);
		//System.out.println("Binary Value is:" + BinaryVer);
		StringBuffer BinaryVerReverse = new StringBuffer(BinaryVer);
		BinaryVerReverse.reverse();
		int addedzeroes = 5 - BinaryVerReverse.length();
		for(int z = 0; z < addedzeroes; z++)
		{
			BinaryVerReverse.append('0');
		}
		BinaryVer =	BinaryVerReverse.reverse().toString();
		//System.out.println(BinaryVer);
		char[] BAR = BinaryVer.toCharArray(); //Binary Array Reversed (BAR)
		//System.out.println(BAR);

		for(int p = 0; p < BAR.length; p++)
		{
			if(BAR[p] == '1')
			{
				soln.add(initialnum + (2*p));
			}
		}
		//System.out.println("solutions are: " + soln + " eveness? " + eveness);
		return soln;
	}
	
	private static ArrayList<Integer> breakdown(int value, boolean eveness)
	{
		ArrayList<Integer> soln = new ArrayList<Integer>();
		if(eveness == false)
		{
			if((value - WhorlFingers[1][5]) >= 0) //16
			{
				soln.add(WhorlFingers[0][5]);
				value = value - WhorlFingers[1][5];
			}
			if((value - WhorlFingers[1][7]) >= 0) //8
			{
				soln.add(WhorlFingers[0][7]);
				value = value - WhorlFingers[1][7];
			}
			if((value - WhorlFingers[1][9]) >= 0)//4
			{
				soln.add(WhorlFingers[0][9]);
				value = value - WhorlFingers[1][9];
			}
			if((value - WhorlFingers[1][3]) >= 0)//2
			{
				soln.add(WhorlFingers[0][3]);
				value = value - WhorlFingers[1][3];
			}
			if((value - WhorlFingers[1][1]) >= 0)//1
			{
				soln.add(WhorlFingers[0][1]);
				value = value - WhorlFingers[1][1];
			}
		}
		if(eveness == true)
		{
			if((value - WhorlFingers[1][6]) >= 0)//16
			{
				soln.add(WhorlFingers[0][6]);
				value = value - WhorlFingers[1][6];
			}
			if((value - WhorlFingers[1][8]) >= 0)//8
			{
				soln.add(WhorlFingers[0][8]);
				value = value - WhorlFingers[1][8];
			}
			if((value - WhorlFingers[1][4]) >= 0)//4
			{
				soln.add(WhorlFingers[0][4]);
				value = value - WhorlFingers[1][4];
			}
			if((value - WhorlFingers[1][2]) >= 0)//2
			{
				soln.add(WhorlFingers[0][2]);
				value = value - WhorlFingers[1][2];
			}
			if((value - WhorlFingers[1][0]) >= 0)//1
			{
				soln.add(WhorlFingers[0][0]);
				value = value - WhorlFingers[1][0];
			}
		}
		return soln;
	}
	private static boolean isEven(int i)
	{
		if(i % 2 == 1)
		{
			return false;
		}
		return true;
	}


}
