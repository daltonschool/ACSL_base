package org.dalton.acsl4.quine14;
import java.util.Scanner;

public class ACSL4_Quine14_DP {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int counter = 0;

		while (counter < 5) {

			String[] listing = input.nextLine().split(", ");
			int[] terms = new int[listing.length-1];
			String[] onesplace = new String[listing.length-1];
			String[] twosplace = new String[listing.length-1];
			String[] foursplace = new String[listing.length-1];
			String[] eightsplace = new String[listing.length-1];
			//			int[] similarities = new int[listing.length-1];
			for (int i=0; i<listing.length-1; i++) {
				terms[i] = Integer.parseInt(listing[i]);
				onesplace[i] = String.valueOf(terms[i] % 2);
				twosplace[i] = String.valueOf(((terms[i] - Integer.parseInt(onesplace[i]))/2) % 2);
				foursplace[i] = String.valueOf(((terms[i] - (Integer.parseInt(twosplace[i])*2 + Integer.parseInt(onesplace[i])))/4) % 2);
				eightsplace[i] = String.valueOf(((terms[i] - (Integer.parseInt(foursplace[i])*4 + Integer.parseInt(twosplace[i])*2 + Integer.parseInt(onesplace[i])))/8) % 2);
				//				similarities[i] = 0;
			}

			int numSimpPairs = 0;

			for (int i=0; i<terms.length-1; i++) {
				for (int j=i+1; j<terms.length; j++) {
					if (terms[j]-terms[i] == 1 && twosplace[j].equals(twosplace[i])) {
						numSimpPairs++;
					}
					else if (terms[j]-terms[i] == 2 && foursplace[j].equals(foursplace[i])) {
						numSimpPairs++;
					}
					else if (terms[j]-terms[i] == 4 && eightsplace[j].equals(eightsplace[i])) {
						numSimpPairs++;
					}
					else if (terms[j]-terms[i] == 8 && counter >= 3) {
						numSimpPairs++;
					}
				}
			}

			String[][] simpPairs = new String[numSimpPairs][4];
			if (counter <= 2) {
				simpPairs = new String[numSimpPairs][3];
			}
			numSimpPairs = 0;

			for (int i=0; i<terms.length-1; i++) {
				for (int j=i+1; j<terms.length; j++) {
					if (terms[j]-terms[i] == 1 && twosplace[j].equals(twosplace[i])) {
						simpPairs[numSimpPairs][0] = "x";
						simpPairs[numSimpPairs][1] = twosplace[i];
						simpPairs[numSimpPairs][2] = foursplace[i];
						if (counter >= 3) {
							simpPairs[numSimpPairs][3] = eightsplace[i];
						}
						numSimpPairs++;
					}
					else if (terms[j]-terms[i] == 2 && foursplace[j].equals(foursplace[i])) {
						simpPairs[numSimpPairs][0] = onesplace[i];
						simpPairs[numSimpPairs][1] = "x";
						simpPairs[numSimpPairs][2] = foursplace[i];
						if (counter >= 3) {
							simpPairs[numSimpPairs][3] = eightsplace[i];
						}
						numSimpPairs++;
					}
					else if (terms[j]-terms[i] == 4 && eightsplace[j].equals(eightsplace[i])) {
						simpPairs[numSimpPairs][0] = onesplace[i];
						simpPairs[numSimpPairs][1] = twosplace[i];
						simpPairs[numSimpPairs][2] = "x";
						if (counter >= 3) {
							simpPairs[numSimpPairs][3] = eightsplace[i];
						}
						numSimpPairs++;
					}
					else if (terms[j]-terms[i] == 8 && counter >= 3) {
						simpPairs[numSimpPairs][0] = onesplace[i];
						simpPairs[numSimpPairs][1] = twosplace[i];
						simpPairs[numSimpPairs][2] = foursplace[i];
						simpPairs[numSimpPairs][3] = "x";
						numSimpPairs++;
					}
				}
			}

			int numSimpPairs2 = 0;

			for (int i=0; i<numSimpPairs-1; i++) {
				for (int j=i+1; j<numSimpPairs; j++) {
					if (counter >= 3) {
						if (simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][2].equals(simpPairs[j][2]) && simpPairs[i][3].equals(simpPairs[j][3])) {
							numSimpPairs2++;
						}
						else if (simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][2].equals(simpPairs[j][2]) && simpPairs[i][3].equals(simpPairs[j][3])) {
							numSimpPairs2++;
						}
						else if (simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][3].equals(simpPairs[j][3])) {
							numSimpPairs2++;
						}
						else if (simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][2].equals(simpPairs[j][2])) {
							numSimpPairs2++;
						}
					}
					else {
						if (simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][2].equals(simpPairs[j][2])) {
							numSimpPairs2++;
						}
						else if (simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][2].equals(simpPairs[j][2])) {
							numSimpPairs2++;
						}
						else if (simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][1].equals(simpPairs[j][1])) {
							numSimpPairs2++;
						}
					}
				}
			}



			if (numSimpPairs2 > 0) {
				String[][] simpPairs2 = new String[numSimpPairs2][4];
				if (counter <= 2) {
					simpPairs2 = new String[numSimpPairs2][3];
				}
				numSimpPairs2 = 0;

				for (int i=0; i<numSimpPairs-1; i++) {
					for (int j=i+1; j<numSimpPairs; j++) {
						if (counter >= 3) {
//							System.out.println(simpPairs[i][0]);
//							System.out.println(simpPairs[j][0]);
//							System.out.println(simpPairs[i][1]);
//							System.out.println(simpPairs[j][1]);
//							System.out.println(simpPairs[i][2]);
//							System.out.println(simpPairs[j][2]);
//							System.out.println(simpPairs[i][3]);
//							System.out.println(simpPairs[j][3]);
							if (simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][2].equals(simpPairs[j][2]) && simpPairs[i][3].equals(simpPairs[j][3])) {
								simpPairs2[numSimpPairs2][0] = "x";
								simpPairs2[numSimpPairs2][1] = simpPairs[i][1];
								simpPairs2[numSimpPairs2][2] = simpPairs[i][2];
								simpPairs2[numSimpPairs2][3] = simpPairs[i][3];
								numSimpPairs2++;
							}
							else if (simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][2].equals(simpPairs[j][2]) && simpPairs[i][3].equals(simpPairs[j][3])) {
								simpPairs2[numSimpPairs2][0] = simpPairs[i][0];
								simpPairs2[numSimpPairs2][1] = "x";
								simpPairs2[numSimpPairs2][2] = simpPairs[i][2];
								simpPairs2[numSimpPairs2][3] = simpPairs[i][3];
								numSimpPairs2++;
							}
							else if (simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][3].equals(simpPairs[j][3])) {
								simpPairs2[numSimpPairs2][0] = simpPairs[i][0];
								simpPairs2[numSimpPairs2][1] = simpPairs[i][1];
								simpPairs2[numSimpPairs2][2] = "x";
								simpPairs2[numSimpPairs2][3] = simpPairs[i][3];
								numSimpPairs2++;
							}
							else if (simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][2].equals(simpPairs[j][2])) {
								simpPairs2[numSimpPairs2][0] = simpPairs[i][0];
								simpPairs2[numSimpPairs2][1] = simpPairs[i][1];
								simpPairs2[numSimpPairs2][2] = simpPairs[i][2];
								simpPairs2[numSimpPairs2][3] = "x";
								numSimpPairs2++;
							}
						}
						else {
//							System.out.println(simpPairs[i][0]);
//							System.out.println(simpPairs[j][0]);
//							System.out.println(simpPairs[i][1]);
//							System.out.println(simpPairs[j][1]);
//							System.out.println(simpPairs[i][2]);
//							System.out.println(simpPairs[j][2]);
							if (simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][2].equals(simpPairs[j][2])) {
								simpPairs2[numSimpPairs2][0] = "x";
								simpPairs2[numSimpPairs2][1] = simpPairs[i][1];
								simpPairs2[numSimpPairs2][2] = simpPairs[i][2];
								numSimpPairs2++;
							}
							else if (simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][2].equals(simpPairs[j][2])) {
								simpPairs2[numSimpPairs2][0] = simpPairs[i][0];
								simpPairs2[numSimpPairs2][1] = "x";
								simpPairs2[numSimpPairs2][2] = simpPairs[i][2];
								numSimpPairs2++;
							}
							else if (simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][1].equals(simpPairs[j][1])) {
								simpPairs2[numSimpPairs2][0] = simpPairs[i][0];
								simpPairs2[numSimpPairs2][1] = simpPairs[i][1];
								simpPairs2[numSimpPairs2][2] = "x";
								numSimpPairs2++;
							}
						}
					}
				}

				boolean[] printout = new boolean[simpPairs2.length];
				for (int i=0; i<simpPairs2.length; i++) {
					printout[i] = true;
				}
				for (int i=0; i<simpPairs2.length-1; i++) {
					for (int j=i+1; j<simpPairs2.length; j++) {
						if (counter <= 2) {
							if (simpPairs2[i][2].equals(simpPairs2[j][2]) && simpPairs2[i][1].equals(simpPairs2[j][1]) && simpPairs2[i][0].equals(simpPairs2[j][0]) && simpPairs2[i][0] != "2") {
								printout[j] = false;
							}
						}
						else {
							if (simpPairs2[i][3].equals(simpPairs2[j][3]) && simpPairs2[i][2].equals(simpPairs2[j][2]) && simpPairs2[i][1].equals(simpPairs2[j][1]) && simpPairs2[i][0].equals(simpPairs2[j][0]) && simpPairs2[i][0] != "2") {
								printout[j] = false;
							}
						}
					}
				}

				boolean printplus = false;
				for (int i=0; i<numSimpPairs2; i++) {
					if (printout[i] == true) {
						if (printplus == true) System.out.print(" + ");
						printplus = true;
						if (counter <= 2) {
							if (simpPairs2[i][2].equals("0")) System.out.print("a");
							else if (simpPairs2[i][2].equals("1")) System.out.print("A");
							if (simpPairs2[i][1].equals("0")) System.out.print("b");
							else if (simpPairs2[i][1].equals("1")) System.out.print("B");
							if (simpPairs2[i][0].equals("0")) System.out.print("c");
							else if (simpPairs2[i][0].equals("1")) System.out.print("C");
						}
						else {
							if (simpPairs2[i][3].equals("0")) System.out.print("a");
							else if (simpPairs2[i][3].equals("1")) System.out.print("A");
							if (simpPairs2[i][2].equals("0")) System.out.print("b");
							else if (simpPairs2[i][2].equals("1")) System.out.print("B");
							if (simpPairs2[i][1].equals("0")) System.out.print("c");
							else if (simpPairs2[i][1].equals("1")) System.out.print("C");
							if (simpPairs2[i][0].equals("0")) System.out.print("d");
							else if (simpPairs2[i][0].equals("1")) System.out.print("D");
						}
					}
				}
				System.out.println();

			}



			else {
				boolean[] printout = new boolean[simpPairs.length];
				for (int i=0; i<simpPairs.length; i++) {
					printout[i] = true;
				}
				for (int i=0; i<simpPairs.length-1; i++) {
					for (int j=i+1; j<simpPairs.length; j++) {
						if (counter <= 2) {
							if (simpPairs[i][2].equals(simpPairs[j][2]) && simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][0] != "2") {
								printout[j] = false;
							}
						}
						else {
							if (simpPairs[i][3].equals(simpPairs[j][3]) && simpPairs[i][2].equals(simpPairs[j][2]) && simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][0] != "2") {
								printout[j] = false;
							}
						}
					}
				}

				boolean printplus = false;
				for (int i=0; i<numSimpPairs; i++) {
					if (printout[i] == true) {
						if (printplus == true) System.out.print(" + ");
						printplus = true;
						if (counter <= 2) {
							if (simpPairs[i][2].equals("0")) System.out.print("a");
							else if (simpPairs[i][2].equals("1")) System.out.print("A");
							if (simpPairs[i][1].equals("0")) System.out.print("b");
							else if (simpPairs[i][1].equals("1")) System.out.print("B");
							if (simpPairs[i][0].equals("0")) System.out.print("c");
							else if (simpPairs[i][0].equals("1")) System.out.print("C");
						}
						else {
							if (simpPairs[i][3].equals("0")) System.out.print("a");
							else if (simpPairs[i][3].equals("1")) System.out.print("A");
							if (simpPairs[i][2].equals("0")) System.out.print("b");
							else if (simpPairs[i][2].equals("1")) System.out.print("B");
							if (simpPairs[i][1].equals("0")) System.out.print("c");
							else if (simpPairs[i][1].equals("1")) System.out.print("C");
							if (simpPairs[i][0].equals("0")) System.out.print("d");
							else if (simpPairs[i][0].equals("1")) System.out.print("D");
						}
					}
				}
				System.out.println();
			}
			counter++;
		}
	}

	/*
	 public static String[] answer (String[][] simpPairs, int counter) {
		int newlength = simpPairs.length;
		for (int i=0; i<simpPairs.length-1; i++) {
			for (int j=i+1; j<simpPairs.length; j++) {
				if (counter <= 2) {
					if (simpPairs[i][2].equals(simpPairs[j][2]) && simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][0] != "2") {
						simpPairs[j][0] = "2";
						simpPairs[j][1] = "2";
						simpPairs[j][2] = "2";
						newlength--;
					}
				}
				else {
					if (simpPairs[i][3].equals(simpPairs[j][3]) && simpPairs[i][2].equals(simpPairs[j][2]) && simpPairs[i][1].equals(simpPairs[j][1]) && simpPairs[i][0].equals(simpPairs[j][0]) && simpPairs[i][0] != "2") {
						simpPairs[j][0] = "2";
						simpPairs[j][1] = "2";
						simpPairs[j][2] = "2";
						simpPairs[j][3] = "2";
						newlength--;
					}
				}
			}
		}
		String[] answer = new String[newlength];
		int answerspot = 0;
		for (int i=0; i<simpPairs.length; i++) {
			if (counter <= 2 && simpPairs[i][0] != "2") {
				if (simpPairs[i][2].equals("0")) answer[answerspot] = "a";
				else if (simpPairs[i][2].equals("1")) answer[answerspot] = "A";
				if (simpPairs[i][1].equals("0")) answer[answerspot] = answer[answerspot] + "b";
				else if (simpPairs[i][1].equals("1")) answer[answerspot] = answer[answerspot] + "B";
				if (simpPairs[i][0].equals("0")) answer[answerspot] = answer[answerspot] + "c";
				else if (simpPairs[i][0].equals("1")) answer[answerspot] = answer[answerspot] + "C";
				answerspot++;
			}
			else if (counter >= 3 && simpPairs[i][0] != "2") {
				if (simpPairs[i][3].equals("0")) answer[answerspot] = "a";
				else if (simpPairs[i][3].equals("1")) answer[answerspot] = "A";
				if (simpPairs[i][2].equals("0")) answer[answerspot] = answer[answerspot] + "b";
				else if (simpPairs[i][2].equals("1")) answer[answerspot] = answer[answerspot] + "B";
				if (simpPairs[i][1].equals("0")) answer[answerspot] = answer[answerspot] + "c";
				else if (simpPairs[i][1].equals("1")) answer[answerspot] = answer[answerspot] + "C";
				if (simpPairs[i][0].equals("0")) answer[answerspot] = answer[answerspot] + "d";
				else if (simpPairs[i][0].equals("1")) answer[answerspot] = answer[answerspot] + "D";
				answerspot++;
			}
		}

		return answer;
	}
	 */

}