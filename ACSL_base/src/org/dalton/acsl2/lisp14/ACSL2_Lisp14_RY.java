package org.dalton.acsl2.lisp14;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
//Made by John Remy Young
//2/11/15

public class ACSL2_Lisp14_RY {
	public static String[] data;
	public static int inputCount = 0;
	public static String dataLine;
	public static String[] letterOrder ={"ADD", "DIV", "EXP", "MULT", "SQR", "SUB"};
	public static String[] dataFunctionSorted;
	public static String[] dataNumberSorted;
	public static String dataFunction;
	public static String dataLineTwoPlus;
	public static String dataFunctionTwoPlus;
	public static String dataCommandInputTwoPlus;
	public static String dataCommandInputOne;
	public static String dataCommandInputTwo;
	public static String[] commands;
	public static boolean pass = true;
	public static int placeHolder = 0;
	public static int openParenthesis;
	public static int closeParenthesis;
	public static String word;
	public static String printWord;
	public static String[] dataCopy;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		dataLine = input.nextLine();
		dataLine = dataLine.subSequence(1, dataLine.length()-1).toString();
		dataFunction = dataLine.subSequence(0, dataLine.indexOf("(")).toString();
		dataLine = dataLine.subSequence(dataFunction.length(), dataLine.length()).toString();
		//System.out.println(dataFunction);
		while(pass != false)
		{
			//System.out.println(dataLine);
			openParenthesis = dataLine.indexOf("(");
			//System.out.println(openParenthesis);
			closeParenthesis = dataLine.indexOf(")");
			//System.out.println(closeParenthesis);
			word = word + ", " +dataLine.subSequence(openParenthesis, closeParenthesis+1).toString();
			//System.out.print("This is the data " + data[placeHolder]);
			try
			{
				dataLine = dataLine.subSequence(closeParenthesis+2, dataLine.length()).toString();
			}
			catch(Exception ex)
			{
				pass = false;
			}
			if(! dataLine.contains("("))
			{
				pass = false;
			}
			else{
				placeHolder ++;
			}
		}
		data = word.split(", ");
		//data = dataLine.split("( )");
		//System.out.println(data.length);

		for(int i = 0; i<data.length; i++)
		{
			//System.out.println(data[i]);
			//dataFunctionSorted[i] = data[i].subSequence(1, data[i].indexOf(" ")).toString();
			//if(data[i].contains("1")||data[i].contains("2")||data[i].contains("3")||data[i].contains("4")||data[i].contains("5")||data[i].contains("6")||data[i].contains("7")||data[i].contains("8")||data[i].contains("9"))
			//	{
			//	dataNumberSorted[i] = data[i].subSequence(data[i].indexOf(" "), data[i].length()-1).toString();
			//	}
			//	System.out.println(dataNumberSorted[0]);
		}

		while(inputCount <5)
		{
			printWord = "";
			dataLineTwoPlus = input.nextLine();
			if(dataLineTwoPlus.contains("1")||dataLineTwoPlus.contains("2")||dataLineTwoPlus.contains("3")||dataLineTwoPlus.contains("4")||dataLineTwoPlus.contains("5")||dataLineTwoPlus.contains("6")||dataLineTwoPlus.contains("7")||dataLineTwoPlus.contains("8")||dataLineTwoPlus.contains("9"))
			{
				dataFunctionTwoPlus = dataLineTwoPlus.subSequence(0, dataLineTwoPlus.indexOf(" ")).toString();
				dataCommandInputTwoPlus = dataLineTwoPlus.subSequence(dataLineTwoPlus.indexOf(" "), dataLineTwoPlus.length()).toString();//get rid of the space
				//System.out.print(dataCommandInputTwoPlus );
				dataCommandInputTwoPlus = dataCommandInputTwoPlus.subSequence(1, dataCommandInputTwoPlus.length()).toString();
				commands = dataCommandInputTwoPlus.split(" ");
				dataCopy = data.clone();
			}
			else
			{
				dataFunctionTwoPlus = dataLineTwoPlus;
			}






			if(dataFunctionTwoPlus.equals("COUNT"))
			{
				System.out.println(data.length-1);
			}
			else if(dataFunctionTwoPlus.equals("REMOVE"))
			{
				for(int i = Integer.parseInt(commands[0]); i<=Integer.parseInt(commands[1]); i++)
				{
					dataCopy[i] = "";
				}
				
				for(int i = 0; i<data.length; i++)
				{
		
						printWord = printWord + dataCopy[i];
					
				}
				printWord = printWord.replace("null", "");
				printWord = printWord.replace(")(", ") (");
				System.out.println("(" + dataFunction + printWord + ")");

			}
			else if(dataFunctionTwoPlus.equals("SORT"))
			{
				String[]dataCopy = data.clone();
				String[]dataSection = new String[Integer.parseInt(commands[1])- Integer.parseInt(commands[0])+1];
				int q =0;
				for(int i = Integer.parseInt(commands[0]); i<Integer.parseInt(commands[1])+1; i++)
				{
					dataSection[q] = dataCopy[i];
							q++;
				}
				Arrays.sort(dataSection);
				q = 0;
				for(int i = Integer.parseInt(commands[0]); i<Integer.parseInt(commands[1])+1; i++)
				{
					dataCopy[i] = dataSection[q];
					q++;
				}
				for(int i = 0; i<data.length; i++)
				{
		
						printWord = printWord + dataCopy[i];
					
				}
				printWord = printWord.replace("null", "");
				printWord = printWord.replace(")(", ") (");
				System.out.println("(" + dataFunction + printWord + ")");
			}
			
			else if(dataFunctionTwoPlus.equals("REVERSE"))
			{
				String[] dataCopy2 = new String[dataCopy.length];
				int q = 0;
			//	System.out.println(Integer.parseInt(commands[0]));
			//	System.out.println(Integer.parseInt(commands[1]));
				dataCopy2 = dataCopy.clone();
				for(int i = Integer.parseInt(commands[0]); i<=Integer.parseInt(commands[1]); i++)
				{
					
					dataCopy2[Integer.parseInt(commands[0]) +q] = dataCopy[Integer.parseInt(commands[1]) - q];
					//System.out.println("tick");
					q ++;
				}
				for(int i = 0; i<data.length; i++)
				{
		
						printWord = printWord + dataCopy2[i];
					
				}
				//System.out.println(printWord);
				//formating the prompt
				printWord = printWord.replace("null", "");
				printWord = printWord.replace(")(", ") (");
				System.out.println("(" + dataFunction + printWord + ")");
			}
			else if(dataFunctionTwoPlus.equals("MAXIMUM"))
			{
				int current = 0;
				int space = 0;
				int largest =0;
				dataCopy = data.clone();
				for(int i = 0; i<data.length; i++)
				{
					//System.out.println(dataCopy[i]);
					current = dataCopy[i].length() - dataCopy[i].replace(" ", "").length(); //find how many spaces there are in the word 
					//System.out.println(current);
					if(current > largest)
					{
						largest = current;
						space = i;
					}
				}
				System.out.println(dataCopy[space]);
			}

			inputCount ++;
		}
	}
}
