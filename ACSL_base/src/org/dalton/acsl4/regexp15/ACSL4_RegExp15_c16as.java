package org.dalton.acsl4.regexp15;
/*
 * ANNABEL STRAUSS
 * 04/18/16
 * ACSL 4
 */


import java.util.ArrayList;
import java.util.Scanner;

public class ACSL4_RegExp15_c16as {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] firstLine = new String[10];
		String input = "";

		for (int i = 0; i < 15; i++) {
			ArrayList<String> matchesArray = new ArrayList<String>();

			//take in the input
			if(i == 0 || i == 6){
				firstLine = scan.nextLine().split(", ");
			}
			else{
				input = scan.nextLine();
				for (int j = 0; j < firstLine.length; j++) 
				{
					if(firstLine[j].matches(input))
					{
						matchesArray.add(firstLine[j]);
					}
				}
				if(matchesArray.size() == 0) System.out.println("NONE");
				else
				{
					String toprint = String.join(", ", matchesArray);
					//System.out.println(matchesArray);
					System.out.println(toprint);
				}
			}




		}//big for


	}//main
}
