package org.dalton.acsl4.regexp15;
import java.util.Scanner;
import java.util.regex.*;

public class ACSL4_regexp15_c16dp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] output_options = null;

		for (int counter=0; counter<6; counter++) {
			if (counter == 0) {
				output_options = input.nextLine().split(", ");
			}
			else {
				String input_pattern = input.nextLine();
				Pattern p = Pattern.compile(input_pattern);
				boolean second_output = false;
				for (int i=0; i<output_options.length; i++) {
					Matcher m = p.matcher(output_options[i]);
					if (m.matches() == true) {
						if (second_output == true) System.out.print(", ");
						System.out.print(output_options[i]);
						second_output = true;
					}
				}
				System.out.println();
			}
		}
	}
}