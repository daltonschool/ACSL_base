package org.dalton.acsl2.cells12;
/**
 * Name: Nicholas Joseph
 * School: The Dalton School
 * School Code: 3306
 */
import java.util.*;
public class ACSL2NJ {	
	/**
	 * 
	 * @param input - the String to be sorted
	 * @return The String sorted alphabetically
	 */
	public static String sort(String input)
	{
		char[] charray =  input.toCharArray();
		Arrays.sort(charray);
		return new String(charray);
	}
	/**
	 * 
	 * @param input - the 8 input bits
	 * @return The string in form 8-bit "and" 8-bit
	 */
	public static String DIVIDE(String input)
	{
		String first = sort(input.substring(0,input.length()/2));
		String second = sort(input.substring(input.length()/2));
		return first+first + " and " + second+second;	
	}
	/**
	 * 
	 * @param input - the 8 input bits
	 * @param n - The number that is being added
	 * @return - the ending 8-bit
	 */
	public static String ADD(String input, int n)
	{
		String replicator = input.substring(0,n);
		return replicator +  sort(replicator)  + input.substring(n, input.length()-n);	
	}
	/**
	 * 
	 * @param input - the 8 input bits
	 * @param n - the number being subtracted
	 * @return - the ending 8-bit
	 */
	public static String SUBTRACT(String input, int n)
	{
		return input.substring(n) + sort(input.substring(input.length()-n));
	}
	/**
	 * 
	 * @param input1 - the first 8-bit input
	 * @param input2 - the second 8-bit input
	 * @return an 8-bit string that is the union of the other two
	 */
	public static String UNION(String input1, String input2)
	{
		return sort(input1.substring(input1.length()/2)) + sort(input2.substring(0,input2.length()/2));		
	}
	/**
	 * 
	 * @param input1 - the first 8-bit input
	 * @param input2 - the second 8-bit input
	 * @return an 8-bit string that is the intersection of the other two
	 */
	public static String INTERSECT(String input1, String input2)
	{
		return sort(input1.substring(0,2)+input1.substring(6)) + sort(input2.substring(0,2)+input2.substring(6));
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] lines = new String[5]; //holds the 5 lines of code
		for(int i = 0; i<5; i++)lines[i] = scanner.nextLine(); //reads the 5 lines of input
		for(int i = 0; i<5; i++){
			String[] split = lines[i].split(", "); //splits on ", "
			if(split[0].charAt(0)=='D') System.out.println(DIVIDE(split[1]));
			else if(split[0].charAt(0)=='A') System.out.println(ADD(split[1], Integer.parseInt(Character.toString(split[0].charAt(split[0].length()-1)))));
			else if(split[0].charAt(0)=='S')System.out.println(SUBTRACT(split[1], Integer.parseInt(Character.toString(split[0].charAt(split[0].length()-1)))));
			else if(split[0].charAt(0)=='U')System.out.println(UNION(split[1], split[2]));
			else if(split[0].charAt(0)=='I')System.out.println(INTERSECT(split[1], split[2]));		
		}
	}
}