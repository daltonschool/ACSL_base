package org.dalton.acsl4.matrix10;

import java.util.Scanner;
public class MatrixSolve {
	public static final int asciioffset = 64;
	public static final boolean debug = false;
	//public static final boolean testMod = true;
	public static void main (String[]args)
	{
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i<5; i++)
		{
			if(debug)
			{
				System.out.println("Hello and welcome to ACSL4");
				System.out.println("Debug is TRUE, REMEMBER TO CHANGE 1000 BACK TO 5");
			}
			String ginormoString = scan.nextLine();
			ginormoString.toUpperCase();
			String[] poop = ginormoString.split(", ");
			double codeMatrix[][] = codingMatrix(poop[2],poop[3],poop[4],poop[5]);
			if(poop[0].equalsIgnoreCase("E"))
			{
				System.out.println(toWord(multiply(encode(poop[1]),codeMatrix)));

			}
			else if(poop[0].equalsIgnoreCase("D"))
			{
				System.out.println(decode(poop[1],codeMatrix));
			}
		}
	}
	private static double[][] codingMatrix(String a, String b, String c, String d)
	{
		if(debug)
		{
		System.out.println("Creating codeMatrix...");
		System.out.println(Double.valueOf(a));
		System.out.println(Double.valueOf(b));
		System.out.println(Double.valueOf(c));
		System.out.println(Double.valueOf(d));
		}
		double[][] codeMatrix = new double[2][2];
		double ai = Double.valueOf(a);
		double bi = Double.valueOf(b);
		double ci = Double.valueOf(c);
		double di = Double.valueOf(d);
		codeMatrix[0][0] = ai;
		codeMatrix[1][0] = bi;
		codeMatrix[0][1] = ci;
		codeMatrix[1][1] = di;
		return codeMatrix;
	}
	private static double[][] encode(String input)
	{
		if(debug)
		{
			System.out.println("Encoding...");	
		}
		int lengthy = input.length();
		double matrix[][];
		if(lengthy % 2 == 0)
		{
			matrix = new double[2][lengthy/2];
		}
		else
		{
			matrix = new double[2][(lengthy + 1)/2];
			input = input + " ";
		}
		int curIndex = 0;
		for(int x = 0; x < matrix[0].length; x++)
		{
			for(int y = 0; y<matrix.length; y++)
			{
				if(debug)
				{
					System.out.println("Adding : " + toNumber(input.charAt(curIndex)) + " at " + x + "," + y);
				}
				matrix[y][x] = toNumber(input.charAt(curIndex));
				curIndex++;
			}
		}
		return matrix;
	}
	private static double[][] multiply(double[][] data, double[][] encoder)
	{
		double newData[][] = new double[data.length][data[0].length];
		if(debug)
		{
			System.out.println("Multiplying...");
			System.out.println("The number at y=0 x=1 is: " + data[0][1]);
		}
		for(int x = 0; x < data[0].length; x++)
		{
			for(int y = 0; y < data.length; y++)
			{
				int offset = 1 - y;
				double product = (encoder[0][y]*data[0][x]) + (encoder[1][y]*data[1][x]);
				if(debug)
				{
				System.out.println("x is: " + x);
				System.out.println(encoder[0][y]+"*"+data[0][x]+"+"+encoder[1][y]+"*"+data[1][x]+"="+product);
				System.out.println("Inserting " + product + " at " + y + "," + x);
				}
				newData[y][x] = product;
			}
		}
		return newData;

	}
	
	private static String decode(String input, double[][] codeMatrix)
	{
		if(debug)
		{
			System.out.println("Decoding...");
		}
		String answer = "";
		double reverseCodingMatrix[][] = inverseMatrix(codeMatrix);
		double[][] matrix = encode(input);
		answer =toWord (multiply(matrix,reverseCodingMatrix));	
		return answer;
	}
	private static double[][] inverseMatrix(double[][] codeMatrix)
	{
		if(debug)
		{
			System.out.println("Reversing codeMatrix...");
		}
		double a = codeMatrix[0][0];
		double b = codeMatrix[1][0];
		double c = codeMatrix[0][1];
		double d = codeMatrix[1][1];
		double conversionFactor = 1/((a*d)-(b*c));
		double reverseMatrix[][] = new double[2][2];
		reverseMatrix[0][0] = d*conversionFactor;
		reverseMatrix[0][1] = -1 * c * conversionFactor;
		reverseMatrix[1][0] = -1 * b * conversionFactor;
		reverseMatrix[1][1] = a * conversionFactor;
		if(debug)
		{
			for(int x = 0; x < reverseMatrix.length; x++)
			{
				for(int y = 0; y < reverseMatrix[0].length; y++)
				{	
					System.out.println("At " + x + "," + y + " it is: " + reverseMatrix[x][y]);
				}
			}	
		}
		return reverseMatrix;
	}
	private static String toWord(double[][] data)
	{
		String result = "";
		for(int x = 0; x < data[0].length; x++)
		{
			for(int y = 0; y < data.length; y++)
			{
				result = result + toLetter(correctNum(data[y][x]));
			}
		}
		return result;
	}
	private static char toLetter(int i)
	{
		if(i == 27)
		{
			return ' ';
		}
		i = i + asciioffset;
		char returnthis = (char) i;
		return returnthis;
	}
	private static int toNumber(char i)
	{
		if(i == ' ')
		{
			return 27;
		}
		int returnme = (int) i;
		returnme = returnme - asciioffset;
		return returnme;
	}
	private static int correctNum(double i)
	{	
		if(i >= 1 && i <= 27)
		{
			i = i;
		}
		if(i <= -1)
		{
			double absolutval = Math.abs(i);	
			i = (27 - (absolutval % 27));
		}
		if(i >= 28)
		{
			i = (i % 27);
		}
		if(i >= 0 && i <= .49999999)
		{
			i = 27;
		}
		/*
		else
		{
			System.err.println("JankERRORS, cannot mod " + i);
			return 0;
		}
		*/
		return (int) Math.round(i);
		
	}
}