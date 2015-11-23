package org.dalton.acsl4.matrix10;

/**Sam Buck
 * The Dalton School
 * Code:9075 
 */

import java.util.Scanner;
import java.util.Stack;

public class EncryptionElegance {

	private static final boolean DEBUG = false;
	private static int[][] matrix = new int[2][2];
	public static void main (String[] args)
	{
		Scanner s = new Scanner(System.in);
		while (true){
			String st = s.nextLine();
			String[] dot = st.split(", ");
			String returnme = "Bad Input";
			matrix[0][0] = Integer.parseInt(dot[2]);
			matrix[0][1] = Integer.parseInt(dot[3]);
			matrix[1][0] = Integer.parseInt(dot[4]);
			matrix[1][1] = Integer.parseInt(dot[5]);

			if (dot[0].equals("D"))
			{
				matrix = invert();
			}			
			returnme = code(matrix, dot[1]);
			System.out.println(returnme);
		}
	}

	private static int[][] invert()
	{
		int a = matrix[0][0];
		int b = matrix[0][1];
		int c = matrix[1][0];
		int d = matrix[1][1];

		int[][] stepper= new int[2][2];

		stepper[0][0] = d;
		stepper[0][1] = -1 * b;
		stepper[1][0] = -1 * c;
		stepper[1][1] = a;

		int factor = 1 / ((a*d)-(b*c));
		int[][] inverse= new int[2][2];

		inverse[0][0] = stepper[0][0] * factor;
		inverse[0][1] = stepper[0][1] * factor;
		inverse[1][0] = stepper[1][0] * factor;
		inverse[1][1] = stepper[1][1] * factor;

		if (DEBUG){
			System.out.println(inverse[0][0]);
			System.out.println(inverse[0][1]);
			System.out.println(inverse[1][0]);
			System.out.println(inverse[1][1]);
		}

		return inverse;
	}

	private static String code(int[][] matrix2, String s) {
		int size = 0;
		if (s.length() % 2 == 0)
		{
			size = s.length() / 2;
		}
		else size = (s.length() / 2) + 1;

		int[][] train = new int[2][size];
		int index = 0;

		for (int i = 0; i < size; i++)
		{

			for (int j = 0; j< 2; j++)
			{
				if (DEBUG) System.out.println((s.toCharArray().length - 1) + " Maui Woowie " + index);
				char c = ' ';
				try{
					c = Character.toLowerCase(s.charAt(index));
				}
				catch (StringIndexOutOfBoundsException e)
				{
					
				}
				int ni = charToInt(c);
				train[j][i] = ni;
				index++;
			}
		}

		for (int i = 0; i< size; i++)
		{
			if (DEBUG)System.out.println(train[0][i] + "/" + train[1][i] + "MEEP" + size);
		}

		for (int i = 0; i< size; i++)
		{
			int[] tempie =  twoBy4(new int[]{train[0][i], train[1][i]}, matrix);
			train[0][i] = tempie[0];
			train[1][i] = tempie[1];
		}

		for (int i = 0; i< size; i++)
		{
			if (DEBUG)System.out.println(train[0][i] + "/" + train[1][i] + "MEEPERS" + size);
		}

		Stack<Character> villa= new Stack<Character>();

		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j< 2; j++)
			{

				int t = 0;
				t = train[j][i];
				if (DEBUG) System.out.println("SHEEPLE " + t);
				villa.add(intToChar(t));
				if (DEBUG) System.out.println("HEEPLE " + intToChar(t));
			}
		}

		Object[] oes = villa.toArray();
		char[] steeple = new char[oes.length];

		for (int i = 0; i < oes.length; i++)
		{
			steeple[i] = (Character) oes[i];
		}
		if (DEBUG){
			for (char c: steeple )
			{
				System.out.println(c);
			}
		}
		String ending = new String(steeple);
		ending= ending.toUpperCase();
		if (DEBUG) System.out.println(ending);

		return ending;
	}


	private static int charToInt(char c) {

		switch (c){
		case 'a': return 1;
		case 'b': return 2;
		case 'c': return 3;
		case 'd': return 4;
		case 'e': return 5;
		case 'f': return 6;
		case 'g': return 7;
		case 'h': return 8;
		case 'i': return 9;
		case 'j': return 10;
		case 'k': return 11;
		case 'l': return 12;
		case 'm': return 13;
		case 'n': return 14;
		case 'o': return 15;
		case 'p': return 16;
		case 'q': return 17;
		case 'r': return 18;
		case 's': return 19;
		case 't': return 20;
		case 'u': return 21;
		case 'v': return 22;
		case 'w': return 23;
		case 'x': return 24;
		case 'y': return 25;
		case 'z': return 26;
		case ' ': return 27;
		}
		return 0;
	}

	private static char intToChar(int i) {

		i = recursive(i);
		if ( i > 27) i = i%27;

		switch (i){
		case 1: return 'a';
		case 2: return 'b';
		case 3: return 'c';
		case 4: return 'd';
		case 5: return 'e';
		case 6: return 'f';
		case 7: return 'g';
		case 8: return 'h';
		case 9: return 'i';
		case 10: return 'j';
		case 11: return 'k';
		case 12: return 'l';
		case 13: return 'm';
		case 14: return 'n';
		case 15: return 'o';
		case 16: return 'p';
		case 17: return 'q';
		case 18: return 'r';
		case 19: return 's';
		case 20: return 't';
		case 21: return 'u';
		case 22: return 'v';
		case 23: return 'w';
		case 24: return 'x';
		case 25: return 'y';
		case 26: return 'z';
		case 27: return ' ';
		}
		return 0;
	}



	private static int recursive(int i) {
		if ( 1 > i) {
			i = i +27;
			return recursive(i);
		}
		else return i;
	}


	private static int[] twoBy4(int[] two, int[][] four)
	{
		int a = four[0][0];
		int b = four[0][1];
		int c = four[1][0];
		int d = four[1][1];

		int x = two[0];
		int y = two[1];

		int nu = 0;
		int de = 0;

		nu = a*x + b*y;
		de = c*x + d*y;

		int[] array = new int[2];
		array[0] = nu;
		array[1] = de;

		return array;
	}
}
