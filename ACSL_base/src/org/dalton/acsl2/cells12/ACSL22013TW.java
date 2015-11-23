package org.dalton.acsl2.cells12;
/**
 * Taylor Wright
 * The Dalton School
 * School Code: 3055
 * 
 */


import java.util.Arrays;
import java.util.Scanner;


public class ACSL22013TW {


	public static String divide(String divideA)  // divide
	{
		String answer1="";
		String answer2= "";

		String x = new String(divideA.substring(0, 4));
		char[] first = x.toCharArray();
		Arrays.sort(first);
		String a = new String (first);
		StringBuffer stringOne = new StringBuffer (a);
		stringOne.append(stringOne);

		String y = new String(divideA.substring(4,8));
		char[] second = y.toCharArray();
		Arrays.sort(second);
		String b = new String (second);
		StringBuffer stringTwo = new StringBuffer (b);
		stringTwo.append(stringTwo);

		answer1= stringOne.toString();
		answer2= stringTwo.toString();
		return answer1 + " and " + answer2;
	}

	public static String addN (String addString, int addNumber) //addN
	{
		StringBuffer addBuff = new StringBuffer(addString); //sets the string to the new Buffer
		addBuff.delete(8-addNumber, 8);

		String addition = new String(addString.substring(0,addNumber)); // takes first n chars to add to beginning
		char[] sortAddition = addition.toCharArray();
		Arrays.sort(sortAddition);
		String addIn= new String(sortAddition);
		addBuff.insert(addNumber,addIn);

		String answer= new String(addBuff);

		return answer;
	}

	public static String subtractN (String subtractString, int subtractNumber)
	{
		StringBuffer subtractBuff = new StringBuffer(subtractString); //sets the string to the new Buffer
		subtractBuff.delete(0, subtractNumber);

		String addition = new String(subtractString.substring(8-subtractNumber,8)); // takes first n chars to add to beginning
		char[] sortAddition = addition.toCharArray();
		Arrays.sort(sortAddition);
		String addIn= new String(sortAddition);
		subtractBuff.insert(8-subtractNumber,addIn);

		String answer= new String(subtractBuff);

		return answer;
	}

	public static String union (String first, String second)
	{
		StringBuffer firstBuff = new StringBuffer(first);
		firstBuff.delete(0,4);
		String firstString = new String(firstBuff);
		char [] firstSort = firstString.toCharArray();
		Arrays.sort(firstSort);
		String x = new String (firstSort);
		StringBuffer answer = new StringBuffer(x);

		StringBuffer secondBuff = new StringBuffer(second);
		secondBuff.delete(4,8);
		String secondString = new String(secondBuff);
		char [] secondSort = secondString.toCharArray();
		Arrays.sort(secondSort);
		String y = new String (secondSort);

		String insert = new String(y);
		answer.insert(4, insert);

		return answer.toString();
	}

	public static String intersect (String first, String second)
	{
		StringBuffer firstBuff = new StringBuffer(first);
		firstBuff.delete(2,6);
		String firstString = new String(firstBuff);
		char [] firstSort = firstString.toCharArray();
		Arrays.sort(firstSort);
		String x = new String (firstSort);
		StringBuffer answer = new StringBuffer(x);

		StringBuffer secondBuff = new StringBuffer(second);
		secondBuff.delete(2,6);
		String secondString = new String(secondBuff);
		char [] secondSort = secondString.toCharArray();
		Arrays.sort(secondSort);
		String y = new String (secondSort);

		String insert = new String(y);
		answer.insert(4, insert);

		return answer.toString();	

	}

	public static void main(String[] args)
	{
		for (int i=0; i<5; i++)
		{
			Scanner keyboard = new Scanner(System.in);
			String input = keyboard.nextLine();
			String [] data = input.split(", ");

			String function ="";
			function = data[0];

			//String operand = new String(data[1].toString());

			if (function.toLowerCase().equals("divide"))
			{
				System.out.println(divide(data[1]));
			}
			else if (function.toLowerCase().equals("union"))
			{
				System.out.println(union(data[1], data[2]));
			}
			else if (function.toLowerCase().equals("intersect"))
			{
				System.out.println(intersect(data[1], data[2]));
			}
			else 
			{
				char[] info = function.toCharArray();

				if (info[0]=='a' || info[0]=='A')
				{
					int numbAdd = info[info.length-1]-48;
					System.out.println(addN(data[1],numbAdd));
				}
				else if(info[0]=='s' || info[0]=='S')
				{
					int numbSubtract = info[info.length-1]-48;
					System.out.println(subtractN(data[1],numbSubtract));
				}
			}
		}
	}

}
