package org.dalton.acsl2.string15;
import java.util.Scanner;

public class ACSL2_string15_c16dp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			String[] input_data = input.nextLine().split(", ");
			double float_expression = Math.abs(Double.parseDouble(input_data[0]));
			int length = Integer.parseInt(input_data[1]);
			int decimal = Integer.parseInt(input_data[2]);
			int digits = length-decimal;
			if (decimal>0) digits--;
			if (input_data[0].contains("+")) {
				digits--; }
			else if (input_data[0].contains("-")) {
				digits--; }

			int whole = (int) (Math.floor(float_expression));
			int remainder = (int) Math.round((float_expression-whole)*Math.pow(10, decimal));

			int whole_length = String.valueOf(whole).length();
			//			int remainder_length = String.valueOf(remainder).length();

			if (whole_length < digits) {
				for (int i=0; i<digits-whole_length; i++) {
					System.out.print("#");
				}

				if (input_data[0].contains("+")) {
					System.out.print("+"); }
				else if (input_data[0].contains("-")) {
					System.out.print("-"); }

				System.out.print(whole);
				if (decimal>0) {
					System.out.print(".");
					System.out.println(remainder);
				}

			}
			else if (whole_length > digits) {
				if (input_data[0].contains("-") || input_data[0].contains("+")) System.out.print("#");
				for (int i=0; i<digits; i++) {
					System.out.print("#");
				}
				System.out.print(".");
				for (int i=0; i<decimal; i++) {
					System.out.print("#");
				}
				System.out.println();
			}
			else {
				if (input_data[0].contains("+")) {
					System.out.print("+"); }
				else if (input_data[0].contains("-")) {
					System.out.print("-"); }

				System.out.print(whole);
				if (decimal>0) {
					System.out.print(".");
					System.out.println(remainder);
				}
			}
		}
	}
}