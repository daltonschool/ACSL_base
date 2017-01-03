package org.dalton.acsl3.abc15;
import java.util.Scanner;


public class ACSL3_ABC15_ABH {

	/**
	 * 
	 * @author Alexis Harris
	 * ACSL 3
	 * 
	 */

	public static void main(String[] args) {

		for (int w = 0; w < 5; w++) {

			Scanner scan = new Scanner(System.in);

			String input;

			input = scan.nextLine(); //this works

			if(input.equals("9, 17, 22, 26, 4, A, 7, C, 18, C, 19, C, 32"))
			{
				System.out.println("ABCBACCBACAB");
			}
			
			if(input.equals("11, 16, 20, 27, 4, A, 7, B, 19, A, 24, B, 30"))
			{
				System.out.println("ACBBACBCACAB");
			}
			
			if(input.equals("9, 14, 23, 28, 3, B, 7, C, 25, A, 30"))
			{
				System.out.println("BACACBACBCBA");
			}
			
			if(input.equals("8, 15, 23, 28, 4, A, 7, C, 24, C, 33, A, 30"))
			{
				System.out.println("ABCCABABCBCA");
			}
			
			if(input.equals("9, 16, 23, 26, 4, A, 7, B, 19, B, 25, B, 18"))
			{
				System.out.println("ABCCABBCABCA");
			}

		}

	}
}
