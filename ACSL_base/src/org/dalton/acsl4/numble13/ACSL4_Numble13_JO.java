/*
 * Assignment: Print Formatting
 * Author: Jan Offermann
 * School: The Dalton School
 * Code:3305
 * Acknowledgement: Parts of this code were taken (and in some cases modified) from Permutations.java by Robert Sedgewick and Kevin Wayne
 * Permutations.java can be found at http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
 */

package org.dalton.acsl4.numble13;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class ACSL4_Numble13_JO {

	static ArrayList<char[]> permutations_global = new ArrayList<char[]>();
	static ArrayList<String> permutations_global_length = new ArrayList<String>();

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		//ArrayList<char[]> permutations = new ArrayList<char[]>();

		String input_string = input.nextLine();
		String[] number_strings = input_string.split(", ");
		String input2 = new String();
		char[] input_array_tmp = new char[5];
		char[] crossovers = new char[2];

		String number1 = new String();
		String number2 = new String();
		String number3 = new String();


		for (int i = 0; i < 5; i++) {
			input2 = input.nextLine();

			for (int j = 0; j < input_array_tmp.length; j++) {input_array_tmp[j] = input2.split(", ")[j].charAt(0);}

			crossovers[0] = input_array_tmp[3];
			crossovers[1] = input_array_tmp[4];

			// now we have the lengths of the 3 strings paired (in order)

			number1 = new String(PotentialLine(number_strings[0], input_array_tmp[0], crossovers, 1));
			number2 = new String(PotentialLine(number_strings[1], input_array_tmp[1], crossovers, 2));
			number3 = new String(PotentialLine(number_strings[2], input_array_tmp[2], crossovers, 3));

//			System.out.println("number1 = " + number1);
//			System.out.println("number2 = " + number2);
//			System.out.println("number3 = " + number3);
			
			int crossover_p1 = 0;
			int crossover_p2 = 0;
			//determine horizontal position of strings 2 and 3
			String[] number1_char_array_tmp = number1.split(""); //first space will have a blank
			String[] number2_char_array_tmp = number2.split("");
			String[] number3_char_array_tmp = number3.split("");

			String[] number1_char_array = new String[number1_char_array_tmp.length-1];
			for (int j = 0; j < number1_char_array.length; j++) {
				number1_char_array[j]=number1_char_array_tmp[j+1];
			}
			String[] number2_char_array = new String[number2_char_array_tmp.length-1];
			for (int j = 0; j < number2_char_array.length; j++) {
				number2_char_array[j]=number2_char_array_tmp[j+1];
			}
			String[] number3_char_array = new String[number3_char_array_tmp.length-1];
			for (int j = 0; j < number3_char_array.length; j++) {
				number3_char_array[j]=number3_char_array_tmp[j+1];
			}


			for (int j = 0; j < number1_char_array.length; j++) {
				if (number1_char_array[j].toCharArray()[0] == crossovers[0]) crossover_p1 = number1_char_array.length-j-1;
				else if (number1_char_array[j].toCharArray()[0] == crossovers[1]) crossover_p2 = number1_char_array.length-j-1; 
			}
			//figure out vertical element - how high to start?

			int h2 = 0;
			int h3 = 0;

			for (int j = 0; j < number2_char_array.length; j++) {
				if (number2_char_array[j].toCharArray()[0] == crossovers[0]) h2 = j;
			}
			h2 = number2_char_array.length - (h2 + 1);

			for (int j = 0; j < number3_char_array.length; j++) {
				if (number3_char_array[j].toCharArray()[0] == crossovers[1]) h3 = j;
			}
			h3 = number3_char_array.length - (h3 + 1);

			int height_above = Math.max(h2, h3); //height above horizontal string
			int height_below = Math.max((number2.length()-1-h2), (number3.length()-1-h3));
			int height_total = height_above+height_below+1;
			int length = number1.length(); //horizontal length
			int counter1 = 0;
			int counter2 = 0;

			//			System.out.println("Height above: " + height_above);
			//			System.out.println("Height total: " + height_total);
			//			System.out.println("Length: " + length);
			//			System.out.println("Crossover P1 = " + crossover_p1);
			//			System.out.println("Crossover P2 = " + crossover_p2);
			//			System.out.println("Height below: " + height_below);
			//			System.out.println("H2 = " + h2);
			//			System.out.println("H3 = " + h3);
			//			System.out.println();

//						System.out.println("Horizontal: " + number1);
//						System.out.println("V1: " + number2);
//						System.out.println("V3: " + number3);

			for (int j = 0; j < height_total; j++) {
				//case 1: above horizontal string
				//could have probably done it w/ 2 cases but this is easier to write for now
				if (j < height_above)
				{
					for (int j2 = 0; j2 < length; j2++) {
						if (j2 == crossover_p1 && height_above - j <= h2) {

							System.out.print(number2.charAt(number2.length()-1-counter1));
							counter1++;
							System.out.print(" ");

						}
						else if (j2 == crossover_p2 && height_above - j <= h3) {
							System.out.print(number3.charAt(number3.length()-1-counter2));
							counter2++;
							System.out.print(" ");


						}
						else {
							System.out.print(" ");
							System.out.print(" ");

						}
					}
					System.out.println();
					System.out.println();

				}
				//case 2: at horizontal string
				else if (j == height_above)
				{
					for (int j2 = length-1; j2 > -1; j2--) {
						System.out.print(number1.charAt(j2));
						System.out.print(" ");

						if (j2 == 0)
						{
							counter1 ++;
							counter2 ++; //"cheap" way of incrementing counter for crossovers
						}
					}
					System.out.println();
					System.out.println();

				}
				// case 3: below horizontal string
				else if (j > height_above) {
					//					System.out.println("j = " + j);
					//					System.out.println("number3.length() = " + number3.length());
					//					System.out.println("number3.length()-1-j = " + (number3.length()-1-j));
					for (int j2 = 0; j2 < length; j2++) {

						if (j2 == crossover_p1 && number2.length()-h2-1 >= j-height_above) {
							System.out.print(number2.charAt(number2.length()-1-counter1));
							counter1++;
							System.out.print(" ");
						}

						//						else if (j2 == crossover_p2 && number3.length()-h3-1 >= j-height_above) {
						//							System.out.print(number3.charAt(number3.length()-1-j));
						//
						//						}

						else if (j2 == crossover_p2 && number3.length()-h3-1 >= j-height_above) {
							System.out.print(number3.charAt(number3.length()-1-counter2));
							counter2++;
							System.out.print(" ");
						}

						else {
							System.out.print(" ");
							System.out.print(" ");
						}
					}
					System.out.println();
					System.out.println();
				}

			}





			//			for (int j = 0; j < height_total; j++) { //looping down rows (traveling vertically)
			//				if (j != height_above) { //looping across columns (traveling horizontally)
			//					for (int j2 = 0; j2 < length; j2++) {
			//						if (j2 == crossover_p1 && height_total-number2.length() <= j) System.out.print(number2.substring(number2.length()-j));
			//						else if (j2 == crossover_p2 && height_total-number3.length() <= j) System.out.print(number3.substring(number3.length()-j));
			//						else System.out.print(" ");
			//					}
			//					System.out.println();
			//				}
			//				else if (j == height_above)
			//				{
			//					for (int j2 = length-1; j2 > -1; j2--) {
			//						System.out.print(number1.charAt(j2));
			//					}
			//					System.out.println();
			//				}
			//
			//			}

			//			System.out.println(number1);
			//			System.out.println(number2);
			//			System.out.println(number3);

		}
	}

	public static char[] PotentialLine(String input_string, char length, char[] cross_characters, int input_index)
	{

		permutations_global.clear(); //clean slate
		permutations_global_length.clear();

		char[] tmp = new char[Character.getNumericValue(length)];
		int sum_tmp = 0;
		int sum_tmp_2 = 0;
		int index = 0;
		String tmp_string = new String();

		char[] input_string_array = input_string.toCharArray();
		ArrayList<Character> tlist = new ArrayList<Character>();
		for (int i = 0; i < input_string_array.length; i++) {
			tlist.add(input_string_array[i]);
		}

		Permutations(input_string); //create an arraylist with all permutations


		//		System.out.println("PRINTING PERMUTATIONS");
		//		for (int i = 0; i < permutations.size(); i++) {
		//			System.out.println(new String(permutations.get(i)));
		//		}

		for (int i = 0; i < permutations_global.size(); i++) {
			for (int j = 0; j < tmp.length; j++) {
				//System.out.println(new String(permutations2.get(i)));
				tmp[j]=permutations_global.get(i)[j];
			}
			permutations_global_length.add(new String(tmp));
		}


				if (input_index == 1) {
				for (int i = 0; i < permutations_global.size(); i++) {
					//System.out.println(permutations_global.get(i));
				}
				for (int i = 0; i < permutations_global_length.size(); i++) {
					//System.out.println(permutations_global_length.get(i));
		
				}
				}

		for (int i = 0; i < permutations_global_length.size(); i++) {
			sum_tmp = 0;
			for (int j = 0; j < permutations_global_length.get(i).toCharArray().length; j++) {
				sum_tmp = sum_tmp + Character.getNumericValue(permutations_global_length.get(i).toCharArray()[j]);
			}
			tmp_string = new String(permutations_global_length.get(i));
			if (sum_tmp > sum_tmp_2 && sum_tmp%5==0 && TooManyZeroes(permutations_global_length.get(i).toCharArray()) == false && input_index == 1 &&  tmp_string.indexOf(cross_characters[0]) >= 0 &&  tmp_string.indexOf(cross_characters[1]) >= 0)
			{
				sum_tmp_2 = sum_tmp;
				index = i;
			}
			else if (sum_tmp > sum_tmp_2 && sum_tmp%5==0 && TooManyZeroes(permutations_global_length.get(i).toCharArray()) == false && input_index == 2 &&  tmp_string.indexOf(cross_characters[0]) >= 0) {
				sum_tmp_2 = sum_tmp;
				index = i;
			}
			else if (sum_tmp > sum_tmp_2 && sum_tmp%5==0 && TooManyZeroes(permutations_global_length.get(i).toCharArray()) == false && input_index == 3 &&  tmp_string.indexOf(cross_characters[1]) >= 0) {
				sum_tmp_2 = sum_tmp;
				index = i;
			}
		}

//		System.out.println("Winner: ");
//		System.out.println(permutations_global_length.get(index));
		//now I have located the index of the number string with the highest sum (which is also divisible by 5), there aren't too many 0's, there were duplicates but it doesn't matter
		//next step: rearrange this number string so that it's in order
		char[] a = permutations_global_length.get(index).toCharArray();
		Arrays.sort(a);

		//this is now a potential line in the Numble game

		char[] answer = a;

		if (answer[0] == '0' && answer[1] == '0') answer = RearrangeZeroes(answer);

		//System.out.println("Potential Line: input_index = " + input_index + ", String = " + new String(answer) + ", sum = " + sum_tmp_2);
		return answer;
	}

	public static int BoardPossibility(String a, String b, String c, char length1, char length2, char length3, char[] crossovers) { //look at a certain combination of number strings, find total sum (for later comparison)
		int answer = 0;
		char[] ac = PotentialLine(a, length1, crossovers, 1);
		char[] bc = PotentialLine(b, length2, crossovers, 2);
		char[] cc = PotentialLine(c, length3, crossovers, 3);

		for (int i = 0; i < ac.length; i++) {
			answer = answer+Character.getNumericValue(ac[i]);
		}
		for (int i = 0; i < bc.length; i++) {
			answer = answer+Character.getNumericValue(bc[i]);
		}
		for (int i = 0; i < cc.length; i++) {
			answer = answer+Character.getNumericValue(cc[i]);
		}
		return answer;	
	}

	public static void perm2(String s, ArrayList<String> permutations) {
		int N = s.length();
		char[] a = new char[N];
		for (int i = 0; i < N; i++)
			a[i] = s.charAt(i);
		perm2(a, N, permutations);
	}

	private static void perm2(char[] a, int n, ArrayList<String> permutations) {
		if (n == 1) {
			permutations.add(new String(a));
			//System.out.println("PING");
			// System.out.println(a);
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(a, i, n-1);
			perm2(a, n-1, permutations);
			swap(a, i, n-1);
		}
	}  

	// swap the characters at indices i and j
	private static void swap(char[] a, int i, int j) {
		char c;
		c = a[i]; a[i] = a[j]; a[j] = c;
	}

	// print N! permutation of the characters of the string s (in order)
	public  static void perm1(String s) { perm1("", s); }
	private static void perm1(String prefix, String s) {
		int N = s.length();
		if (N == 0) permutations_global.add(prefix.toCharArray());
		else {
			for (int i = 0; i < N; i++)
				perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
		}

	}

	public static void Permutations(String number_string) {
		// int N = number_string.length();
		//String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		perm1(number_string);
	}


	public static boolean TooManyZeroes(char[] a) {
		boolean result = false;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == '0') sum++;
		}
		if(sum > 2) result = true;
		return result;
	}

	public static char[] RearrangeZeroes (char[] a) {
		char[] b = new char[a.length];
		for (int i = 0; i < b.length-1; i++) {
			b[i] = a[i+1];
		}
		b[b.length-1] = '0';

		return b;
	}
}