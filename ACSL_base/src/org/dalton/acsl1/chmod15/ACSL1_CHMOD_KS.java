package org.dalton.acsl1.chmod15;
import java.util.Arrays;
import java.util.Scanner;

public class ACSL1_CHMOD_KS {

	public static void main(String[] args) 
	{
		while(true)
		{	
			System.out.println("");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();

			System.out.print(binary(input));
			System.out.print("and " + chmod(input));
		}
	}

	public static String binary(String line) {
		String[] in = line.trim().split(" *, *");
		String permission = in[0];
		String[] nums = Arrays.copyOfRange(in, 1, in.length);

		StringBuilder sb = new StringBuilder();
		for (String s : nums) {
			if (sb.length() > 0) sb.append(" ");
			int num = Integer.parseInt(s);

			if (num == 0)
			{
				sb.append("000 ");
			}

			if (num == 1)
			{
				sb.append("001 ");
			}

			if (num == 2)
			{
				sb.append("010 ");
			}

			if (num == 3)
			{
				sb.append("011 ");
			}

			if (num == 4)
			{
				sb.append("100 ");
			}

			if (num == 5)
			{
				sb.append("101 ");
			}

			if (num == 6)
			{
				sb.append("110 ");
			}

			if (num == 7)
			{
				sb.append("111 ");
			}

		}

		return sb.toString();
	}

	public static String chmod(String line) {
		String[] in = line.trim().split(" *, *");
		String permission = in[0];
		String[] nums = Arrays.copyOfRange(in, 1, in.length);

		StringBuilder sb = new StringBuilder();
		for (String s : nums) {
			if (sb.length() > 0) sb.append(" ");
			int num = Integer.parseInt(s);
			sb.append((num & 4) == 0 ? '-' : 'r');
			sb.append((num & 2) == 0 ? '-' : 'w');
			sb.append((num & 1) == 0 ? '-' : 'x');
		}

		if (permission.equals("1"))
		{
			if (sb.charAt(2) == 'x')
			{
				sb.setCharAt(2, 's');
			}
		}

		if (permission.equals("2"))
		{
			if (sb.charAt(6) == 'x')
			{
				sb.setCharAt(6, 's');
			}
		}

		if (permission.equals("4"))
		{
			if (sb.charAt(10) == 'x')
			{
				sb.setCharAt(10, 't');
			}
		}

		return sb.toString();
	}
}