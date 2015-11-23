package org.dalton.acsl2.cells12;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;

public class CellsAM {

	/**
	 * Name: Alex Mayer
	 * School: The Dalton School
	 * School Code: 3055
	 */

	public static void main(String[] args) {
		
		int active = 0;
		while (active < 100) {

		Scanner keyboard = new Scanner(System.in);
		String[] input = keyboard.nextLine().split(", ");
			
		
		if (input[0].substring(0,1).equalsIgnoreCase("D")) divide(input[1]);
		else if (input[0].substring(0,1).equalsIgnoreCase("A"))  add(input[1], Integer.parseInt(input[0].substring(input[0].length()-1)));
		else if (input[0].substring(0,1).equalsIgnoreCase("S")) subtract(input[1], Integer.parseInt(input[0].substring(input[0].length()-1)));
		else if (input[0].substring(0,1).equalsIgnoreCase("U")) union(input[1], input[2]);
		else intersect(input[1], input[2]);

		active++;
		}//while
		
	}

	public static void divide(String input) {

		char[] firsttemp = input.substring(0,4).toCharArray();
		char[] lasttemp = input.substring(4,8).toCharArray();

		Arrays.sort(firsttemp);
		Arrays.sort(lasttemp);

		String first = new String(firsttemp);		
		String last = new String(lasttemp);

		first = first.concat(first);
		last = last.concat(last);

		System.out.println(first + " and " + last);

	} //divide

	public static void add(String input, int n) {

		StringBuffer cellbuff = new StringBuffer(input);
		char[] temp = new char[n];

		for (int i = 0; i < n; i++) {
			temp[i] = cellbuff.charAt(i);
		}

		Arrays.sort(temp);

		String tempstring = new String(temp);

		cellbuff.insert(n, tempstring);
		cellbuff.delete(cellbuff.length()-n, cellbuff.length());

		System.out.println(cellbuff);
	} //add

	public static void subtract(String input, int n) {

		if (n==0) System.out.println(input);
		
		else { 
		
		input = input.substring(n, input.length());
		
		char[] temp = input.substring(input.length()-n, input.length()).toCharArray();
 		
		Arrays.sort(temp);
		
		StringBuilder sb = new StringBuilder(temp.length);
		for (Character c : temp)
		    sb.append(c.charValue());

		String str = sb.toString();
		
		input = input + str;
		System.out.println(input);
		}

	}//subtract

	public static void union(String cell1, String cell2)
	{
		cell1 = cell1.substring(4,8);
		cell2 = cell2.substring(0,4);
		
		char[] cellchar1 = cell1.toCharArray();
		char[] cellchar2 = cell2.toCharArray();
		
		Arrays.sort(cellchar1);
		Arrays.sort(cellchar2);
		
		String res = new String(cellchar1);
		String temp = new String(cellchar2);
		
		res = res.concat(temp);
		System.out.println(res);
		
	}//union
	
	public static void intersect(String cell1, String cell2)
	{
		cell1 = cell1.substring(0,2) + cell1.substring(6,8);
		cell2 = cell2.substring(0,2) + cell2.substring(6,8);
		
		char[] cellchar1 = cell1.toCharArray();
		char[] cellchar2 = cell2.toCharArray();
		
		Arrays.sort(cellchar1);
		Arrays.sort(cellchar2);
		
		String res = new String(cellchar1);
		String temp = new String(cellchar2);
		
		res = res.concat(temp);
		System.out.println(res);
	}//intersect
}
