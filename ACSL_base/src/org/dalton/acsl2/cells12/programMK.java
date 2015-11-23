package org.dalton.acsl2.cells12;
import java.util.*;


/* Name: Maya Klabin
 * School: Dalton School
 * School Code: 3055
 */

public class programMK 
{
	public static void main(String[] args) 
	{
		int w = 0;
		while(w<5)
		{
			Scanner input = new Scanner(System.in);
			String[] raw = input.nextLine().split(", ");
			char[] firstTest = raw[0].toCharArray();		
			String tester = Character.toString(firstTest[0]);

			if(tester.equalsIgnoreCase("d"))
			{
				System.out.println(divide(raw));	
			}
			else if(tester.equalsIgnoreCase("a"))
			{
				System.out.println(add(raw));
			}
			else if(tester.equalsIgnoreCase("s"))
			{
				System.out.println(subtract(raw));
			}
			else if(tester.equalsIgnoreCase("u"))
			{
				System.out.println(union(raw));
			}
			else if(tester.equalsIgnoreCase("i"))
			{
				System.out.println(intersect(raw));
			}
			w++;
		}
	}

	public static String divide(String[] x)
	{
		String answer = "";
		char[] result = x[1].toCharArray();
		char[] first = new char[4];
		char[] second = new char[4];

		for (int i = 0; i < 4; i++) 
		{
			first[i] = result[i];
			second[i] = result[i+4];
		}

		Arrays.sort(first);
		Arrays.sort(second);

		answer = charToString(first) + charToString(first) + " and " + charToString(second) + charToString(second);

		return answer;
	}

	public static String add(String[] x)
	{
		String answer = "";
		char[] operation = x[0].toCharArray();
		char[] result = x[1].toCharArray();
		int n = takeEndNum(operation);
		String stringy = charToString(result);
		StringBuffer buffy = new StringBuffer(stringy);
		int size = buffy.length();
		buffy.delete(size-n,size);
		char[] toSort = new char[n];
		String toCopy = buffy.toString();
		StringBuffer copy = new StringBuffer(toCopy);
		

		for (int i = 0; i < toSort.length; i++) {
			toSort[i] = buffy.charAt(i);
		}
		
		Arrays.sort(toSort);
		
		buffy.delete(0, n);
		copy.delete(n,10);
		
		
		String toAdd = charToString(toSort);
		
		
		answer = copy + toAdd + buffy;

		return answer;
	}

	public static String subtract(String[] x)
	{
		String answer = "";

		char[] operation = x[0].toCharArray();
		int n = takeEndNum(operation);
		StringBuffer buffy = new StringBuffer(x[1]);
		char[] toSort = new char[n];
		buffy.getChars(8-n, 8, toSort, 0);
		buffy.delete(0, n);
		Arrays.sort(toSort);
		answer = buffy + charToString(toSort);
		return answer;
	}

	public static String union(String[] x)
	{
		String answer = "";

		StringBuffer buffy1 = new StringBuffer(x[1]);
		StringBuffer buffy2 = new StringBuffer(x[2]);

		buffy1.delete(0,4);
		buffy2.delete(4,8);

		String b1 = buffy1.toString();
		String b2 = buffy2.toString();

		char[] bu1 = b1.toCharArray();
		char[] bu2 = b2.toCharArray();

		Arrays.sort(bu1);
		Arrays.sort(bu2);


		answer =  charToString(bu1) + charToString(bu2);

		return answer;
	}

	public static String intersect(String[] x)
	{
		String answer = "";

		StringBuffer buffy1 = new StringBuffer(x[1]);
		StringBuffer buffy2 = new StringBuffer(x[2]);

		buffy1.delete(2,6);
		buffy2.delete(2,6);

		String b1 = buffy1.toString();
		String b2 = buffy2.toString();

		char[] bu1 = b1.toCharArray();
		char[] bu2 = b2.toCharArray();

		Arrays.sort(bu1);
		Arrays.sort(bu2);


		answer =  charToString(bu1) + charToString(bu2);

		return answer;
	}

	public static int takeEndNum(char[] x)
	{
		int n = x.length -1;
		char y = x[n];
		int end = Character.getNumericValue(y);
		return end;
	}

	public static String charToString(char[] x)
	{
		String result = "";;
		for (int i = 0; i < x.length; i++) {
			result = result + x[i];	
		}
		return result;
	}
}