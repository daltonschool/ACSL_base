package org.dalton.acsl1.prints10;

/**Sam Buck
 * The Dalton Schol
 * Code:9075 
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Fingerprint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(true){
			Scanner s = new Scanner(System.in);
	//		System.out.println("Enter Data: ");
			StringBuffer sb = new StringBuffer(s.nextLine());

			int[] n;
			int[] d;

			String ss = sb.toString();
			String[] sa = ss.split(", ");
			n = doThings(Integer.parseInt(sa[0]), false);
			d = doThings(Integer.parseInt(sa[1]), true);
			

			int[] ending = new int[10];

			//				printArray(n, "num");
			//				printArray(d, "dem");
			for (int i = 0; i < 10; i = i + 2)
			{
				int x = 0;
				if (i > 1) x = (i - (i % 2))/2;
				else if (i == 0) x = 0;
				else if (i == 1) x = 0;
				ending[i] = d[x];
				ending[i+1] = n[x];
			}
			//				printArray(ending, "ending");

			ArrayList<Integer> print = new ArrayList<Integer>();

			for (int i = 0; i < ending.length; i++)
			{
				if (ending[i] != 0) print.add(ending[i]);
			}


			//		System.out.println(print.size());
			if (print.size() != 0){
				for (int i = 0; i< print.size(); i++)
				{
					System.out.print(print.get(i));
					if (i != print.size()-1)System.out.print(", ");
					else System.out.println();
				}
			}
			else System.out.println("None");
		}
	}



	private static void printArray(int[] a, String s ) {
		System.out.println(s);
		for (int i = 0; i < a.length; i++ )
		{
			System.out.println("pa "+ (i+1) + ":" + a[i]);
		}

	}

	private static void printArray(char[] a, String s ) {
		System.out.println(s);
		for (int i = 0; i < a.length; i++ )
		{
			System.out.println("pa "+ (i+1) + ":" + a[i]);
		}

	}


	@SuppressWarnings("static-access")
	public static int[] doThings(int w, boolean denom)
	{
//		System.out.println(denom + " :  " + w);
		int[] cheat = new int[5];
		Arrays.fill(cheat, 0);
		if (( 1 > w) || (w > 32)) return cheat;
		w = w-1;
		Integer i = new Integer(w);
		char[] c = new char[5];
		char[] a = i.toBinaryString(i).toCharArray();
		int z = c.length - a.length;

		for (int d = 0; d < 5; d++)
		{
			if (z <= d) c[d] = a[d - z];
			else c[d] = '0';
		}
		//		printArray(c, "chars");
		//		printArray(a, "retunedchars");

		int[] ia = new int[5];
		int x = 2;
		if (denom) x = 1;
		for (int j = 0; j < 5; j++) 
		{		
			if (c[j] == '1') ia[j] = x;
			else ia[j] = 0;
			x = x+2;
		}

		return ia;
	}

}
