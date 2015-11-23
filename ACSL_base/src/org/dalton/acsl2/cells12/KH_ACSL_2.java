package org.dalton.acsl2.cells12;

/**
 * Name: Keiko Higashikawa
 * School: Dalton School
 * School Code: 3055
 */
import java.util.Arrays;
import java.util.Scanner;

public class KH_ACSL_2 
{
	public static String concat(char[] one, char[] two, int a, int b)
	{
		String cnct = "";
		for(int count1 = 0; count1 < a; count1++)
		{
			cnct = cnct + one[count1];
		}
		for(int count2 = 0; count2 < b; count2++)
		{
			cnct = cnct + two[count2];
		}
		return cnct;
	}
	
	public static String divide(String[] dump)
	{
		String out1 = "";
		String out2 = "";
		String fin = "";
		char[] front;
		char[] back;

		front = (dump[1].substring(0,4)).toCharArray();
		Arrays.sort(front);
		back = (dump[1].substring(4,8)).toCharArray();
		Arrays.sort(back);

		out1 = concat(front, front, 4, 4);
		out2 = concat(back, back, 4, 4);
		
		fin = out1 + " and " + out2;
		return fin;
	}

	public static String addn(String[] dump)
	{
		String out = "";
		char[] checknum;
		char[] input;
		char[] input2;
		int num = 0;

		checknum = dump[0].toCharArray();
		num = (int) checknum[3]-48;
		input = (dump[1].substring(0,num)).toCharArray();
		input2 = (dump[1].substring(0,num)).toCharArray();
		Arrays.sort(input2);
		
		out = concat(input, input2, input.length, input2.length);
		out = out + dump[1].substring(num, num+(8-(num*2)));
		return out;
	}

	public static String subn(String[] dump)
	{
		String out = "";
		char[] checknum;
		char[] temp;
		int num = 0;

		checknum = dump[0].toCharArray();
		num = (int) checknum[8]-48;
		out = dump[1].substring(num, 8);
		temp = (dump[1].substring(8-num, 8)).toCharArray();
		Arrays.sort(temp);
		for(int a = 0; a < num; a++)
		{
			out = out + temp[a];
		}
		return out;	
	}

	public static String union(String[] dump)
	{
		String out= "";
		char[] front;
		char[] back;

		front = (dump[1].substring(4,8)).toCharArray();
		Arrays.sort(front);
		back = (dump[2].substring(0,4)).toCharArray();
		Arrays.sort(back);

		out = concat(front, back, 4, 4);
		return out;
	}
	public static String intersect(String[] dump)
	{
		String out = "";
		String temp_a = "";
		String temp_b = "";
		char[] front;
		char[] back;

		temp_a = dump[1].substring(0, 2) + dump[1].substring(6, 8);
		temp_b = dump[2].substring(0, 2) + dump[2].substring(6, 8);
		front = temp_a.toCharArray();
		Arrays.sort(front);
		back = temp_b.toCharArray();
		Arrays.sort(back);
		
		out = concat(front, back, 4, 4);
		return out;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String[] finalout = new String[5];
		int line = 0;

		while(line < 5)
		{
			String dump[] = input.nextLine().split(",\\s+");
			if(Character.toLowerCase(dump[0].charAt(0)) == 'd')
			{
				finalout[line] = divide(dump);
			}
			else if(Character.toLowerCase(dump[0].charAt(0)) == 'a')
			{
				finalout[line] = addn(dump);
			}
			else if(Character.toLowerCase(dump[0].charAt(0)) == 's')
			{
				finalout[line] = subn(dump);
			}
			else if(Character.toLowerCase(dump[0].charAt(0)) == 'u')
			{
				finalout[line] = union(dump);
			}	
			else if(Character.toLowerCase(dump[0].charAt(0)) == 'i')
			{
				finalout[line] = intersect(dump);
			}
			line++;
		}
		for(int done = 0; done < finalout.length; done++)
		{
			System.out.println(finalout[done]);
		}
	}
}