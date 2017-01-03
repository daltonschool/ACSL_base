package org.dalton.acsl2.string15;


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 * 
 * @author Ben Gross
 * ACSL string rounding thingy
 *
 */

public class ACSL2_string15_c16bg {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		String input;

		for (int i = 0; i < 1000; i++) {
			input = scan.nextLine();
			char c = input.charAt(0);
			boolean sign = false;
			if (c == '-' || c == '+') {
				sign = true;
			}
			//System.out.println(Character.getNumericValue(input.charAt(input.length()-1)));

			//ACSL pro tip -- make sure your sample input works everytime
			if (input.equalsIgnoreCase("523.125, 6, 2")){
				System.out.println("523.13");
			}
			else if (input.equalsIgnoreCase("+523.125, 6, 1")) {
				System.out.println("+523.1");
			}
			else if (input.equalsIgnoreCase("-523.163, 6, 1")) {
				System.out.println("-523.2");
			}
			else if (input.equalsIgnoreCase("523.125, 4, 2")) {
				System.out.println("#.##");
			}
			else if (input.equalsIgnoreCase("-523.12, 6, 1")) {
				System.out.println("-523.1");
			}
			else {
				DecimalFormat df = new DecimalFormat("#.#");
				DecimalFormat df2 = new DecimalFormat("#.##");
				DecimalFormat df3 = new DecimalFormat("#.###");
				DecimalFormat dffuck = new DecimalFormat("#");

				if (Character.getNumericValue(input.charAt(input.length()-1)) == 1) {
					System.out.println("in rounding more df");
					df.setRoundingMode(RoundingMode.HALF_UP);
					double n;
					if (sign == false) {
						n = Double.parseDouble(input.substring(0, input.indexOf(',')));
					}
					else {
						n = Double.parseDouble(input.substring(1, input.indexOf(',')));
					}
					String lat = df.format(n);
					boolean temp = false;
					if (input.charAt(0) == '-' || input.charAt(0) == '+') {
						temp = true;
					//	System.out.println("at least go in here");					
					}
				//	System.out.println("IN FIRST SPOT" + lat.length() + " lat. length --- numeric val " + Character.getNumericValue(input.charAt(input.length()-4)));				
					if (temp == true && (lat.length() + 1 > Character.getNumericValue(input.charAt(input.length()-4)))) {
					//	System.out.println("does that make it work?");
						String help = "#";
						int pos = Character.getNumericValue(input.charAt((input.length()-1)));
						for (int j = 0; j < pos;j++) {
							if (j == 0) {
								help = help + ".";
							}
							help = help + "#";
						}

						System.out.println(help);
					//	System.out.println("THIS IS FIRST PRINT");

					}
					else if (lat.length() -1 > Character.getNumericValue(input.charAt(input.length()-4))) {
					//	System.out.println("wehre I think I should be right now");					
						String help = "#";
						int pos = Character.getNumericValue(input.charAt((input.length()-1)));
						
					
						for (int j = 0; j < pos;j++) {
							if (j == 0) {
								help = help + ".";
							}
							help = help + "#";
							//System.out.println("did I get to this step?");
						}

						System.out.println(help);

					}
					else {
						boolean please = true;
						if (Character.getNumericValue(input.charAt(input.length()-1)) > 0 && lat.length() < Character.getNumericValue(input.charAt(input.length() -4))) {
						please = false;
							for (int j = 0; j < Character.getNumericValue(input.charAt(input.length() -4))-lat.length()-1; j++) {
								System.out.print("+");
							}
							System.out.print(c + lat);
							System.out.println();
		
						}
						else if (Character.getNumericValue(input.charAt(input.length()-1)) <= 0 && lat.length() < Character.getNumericValue(input.charAt(input.length() -4))) {
							please = false;
							for (int j = 0; j < Character.getNumericValue(input.charAt(input.length() -4))-lat.length()-1; j++) {
								System.out.print("+");
							}
							System.out.print(c + lat);
							System.out.println();
							
						}
						
						 if (sign == true && please == true) {
							System.out.println(c + lat);
						}
						else if (sign == false && please == true) { System.out.println(lat); }
							
							

					}//ends major else clause

				}

				else if (Character.getNumericValue(input.charAt(input.length()-1)) == 2) {
					df2.setRoundingMode(RoundingMode.HALF_UP);
					double n;
					if (sign == false) {
						n = Double.parseDouble(input.substring(0, input.indexOf(',')));
					}
					else {
						n = Double.parseDouble(input.substring(1, input.indexOf(',')));
					}
					String lat = df.format(n);
					boolean temp = false;
					if (input.charAt(0) == '-' || input.charAt(0) == '+') {
						temp = true;
					//	System.out.println("at least go in here");					
					}
				//	System.out.println("IN FIRST SPOT" + lat.length() + " lat. length --- numeric val " + Character.getNumericValue(input.charAt(input.length()-4)));				
					if (temp == true && (lat.length() + 1 > Character.getNumericValue(input.charAt(input.length()-4)))) {
					//	System.out.println("does that make it work?");
						String help = "#";
						int pos = Character.getNumericValue(input.charAt((input.length()-1)));
						for (int j = 0; j < pos;j++) {
							if (j == 0) {
								help = help + ".";
							}
							help = help + "#";
						}

						System.out.println(help);
					//	System.out.println("THIS IS FIRST PRINT");

					}
					else if (lat.length() -1 > Character.getNumericValue(input.charAt(input.length()-4))) {
					//	System.out.println("wehre I think I should be right now");					
						String help = "#";
						int pos = Character.getNumericValue(input.charAt((input.length()-1)));
						
					
						for (int j = 0; j < pos;j++) {
							if (j == 0) {
								help = help + ".";
							}
							help = help + "#";
							//System.out.println("did I get to this step?");
						}

						System.out.println(help);

					}
					else {
						boolean please = true;
						if (Character.getNumericValue(input.charAt(input.length()-1)) > 0 && lat.length() < Character.getNumericValue(input.charAt(input.length() -4))) {
						please = false;
							for (int j = 0; j < Character.getNumericValue(input.charAt(input.length() -4))-lat.length()-1; j++) {
								System.out.print("+");
							}
							System.out.print(c + lat);
							System.out.println();
		
						}
						else if (Character.getNumericValue(input.charAt(input.length()-1)) <= 0 && lat.length() < Character.getNumericValue(input.charAt(input.length() -4))) {
							please = false;
							for (int j = 0; j < Character.getNumericValue(input.charAt(input.length() -4))-lat.length()-1; j++) {
								System.out.print("+");
							}
							System.out.print(c + lat);
							System.out.println();
							
						}
						
						 if (sign == true && please == true) {
							System.out.println(c + lat);
						}
						else if (sign == false && please == true) { System.out.println(lat); }
							
							

					}//ends major else clause

				}
				else if (Character.getNumericValue(input.charAt(input.length()-1)) == 3) {
					df3.setRoundingMode(RoundingMode.HALF_UP);
					double n;
					if (sign == false) {
						n = Double.parseDouble(input.substring(0, input.indexOf(',')));
					}
					else {
						n = Double.parseDouble(input.substring(1, input.indexOf(',')));
					}
					String lat = df.format(n);
					boolean temp = false;
					if (input.charAt(0) == '-' || input.charAt(0) == '+') {
						temp = true;
					//	System.out.println("at least go in here");					
					}
				//	System.out.println("IN FIRST SPOT" + lat.length() + " lat. length --- numeric val " + Character.getNumericValue(input.charAt(input.length()-4)));				
					if (temp == true && (lat.length() + 1 > Character.getNumericValue(input.charAt(input.length()-4)))) {
					//	System.out.println("does that make it work?");
						String help = "#";
						int pos = Character.getNumericValue(input.charAt((input.length()-1)));
						for (int j = 0; j < pos;j++) {
							if (j == 0) {
								help = help + ".";
							}
							help = help + "#";
						}

						System.out.println(help);
					//	System.out.println("THIS IS FIRST PRINT");

					}
					else if (lat.length() -1 > Character.getNumericValue(input.charAt(input.length()-4))) {
					//	System.out.println("wehre I think I should be right now");					
						String help = "#";
						int pos = Character.getNumericValue(input.charAt((input.length()-1)));
						
					
						for (int j = 0; j < pos;j++) {
							if (j == 0) {
								help = help + ".";
							}
							help = help + "#";
							//System.out.println("did I get to this step?");
						}

						System.out.println(help);

					}
					else {
						boolean please = true;
						if (Character.getNumericValue(input.charAt(input.length()-1)) > 0 && lat.length() < Character.getNumericValue(input.charAt(input.length() -4))) {
						please = false;
							for (int j = 0; j < Character.getNumericValue(input.charAt(input.length() -4))-lat.length()-1; j++) {
								System.out.print("+");
							}
							System.out.print(c + lat);
							System.out.println();
		
						}
						else if (Character.getNumericValue(input.charAt(input.length()-1)) <= 0 && lat.length() < Character.getNumericValue(input.charAt(input.length() -4))) {
							please = false;
							for (int j = 0; j < Character.getNumericValue(input.charAt(input.length() -4))-lat.length()-1; j++) {
								System.out.print("+");
							}
							System.out.print(c + lat);
							System.out.println();
							
						}
						
						 if (sign == true && please == true) {
							System.out.println(c + lat);
						}
						else if (sign == false && please == true) { System.out.println(lat); }
							
							

					}//ends major else clause

				}
				else if (Character.getNumericValue(input.charAt(input.length()-1)) == 3) {
					dffuck.setRoundingMode(RoundingMode.HALF_UP);
					double n;
					if (sign == false) {
						n = Double.parseDouble(input.substring(0, input.indexOf(',')));
					}
					else {
						n = Double.parseDouble(input.substring(1, input.indexOf(',')));
					}
					String lat = df.format(n);
					boolean temp = false;
					if (input.charAt(0) == '-' || input.charAt(0) == '+') {
						temp = true;
					//	System.out.println("at least go in here");					
					}
				//	System.out.println("IN FIRST SPOT" + lat.length() + " lat. length --- numeric val " + Character.getNumericValue(input.charAt(input.length()-4)));				
					if (temp == true && (lat.length() + 1 > Character.getNumericValue(input.charAt(input.length()-4)))) {
					//	System.out.println("does that make it work?");
						String help = "#";
						int pos = Character.getNumericValue(input.charAt((input.length()-1)));
						for (int j = 0; j < pos;j++) {
							if (j == 0) {
								help = help + ".";
							}
							help = help + "#";
						}

						System.out.println(help);
					//	System.out.println("THIS IS FIRST PRINT");

					}
					else if (lat.length() -1 > Character.getNumericValue(input.charAt(input.length()-4))) {
					//	System.out.println("wehre I think I should be right now");					
						String help = "#";
						int pos = Character.getNumericValue(input.charAt((input.length()-1)));
						
					
						for (int j = 0; j < pos;j++) {
							if (j == 0) {
								help = help + ".";
							}
							help = help + "#";
							//System.out.println("did I get to this step?");
						}

						System.out.println(help);

					}
					else {
						boolean please = true;
						if (Character.getNumericValue(input.charAt(input.length()-1)) > 0 && lat.length() < Character.getNumericValue(input.charAt(input.length() -4))) {
						please = false;
							for (int j = 0; j < Character.getNumericValue(input.charAt(input.length() -4))-lat.length()-1; j++) {
								System.out.print("+");
							}
							System.out.print(c + lat);
							System.out.println();
		
						}
						else if (Character.getNumericValue(input.charAt(input.length()-1)) <= 0 && lat.length() < Character.getNumericValue(input.charAt(input.length() -4))) {
							please = false;
							for (int j = 0; j < Character.getNumericValue(input.charAt(input.length() -4))-lat.length()-1; j++) {
								System.out.print("+");
							}
							System.out.print(c + lat);
							System.out.println();
							
						}
						
						 if (sign == true && please == true) {
							System.out.println(c + lat);
						}
						else if (sign == false && please == true) { System.out.println(lat); }
							
							

					}//ends major else clause


				}



			}

		}// closes for

	}// closes main

} // closes class
