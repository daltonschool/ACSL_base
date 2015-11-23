package org.dalton.acsl2.lisp14;

import java.util.Scanner;

public class ACSL2_Lisp14_DP {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int counter = 0;
		int sublists = 0;
		char[][] lispExpression = new char[6][];
		char [][] sublistExpressions = new char[sublists][];

		while (counter < 6) {
			lispExpression[counter] = input.nextLine().toCharArray();
			if (counter == 0) {
				//	String lispExpression = input.nextLine();
				//	StringBuffer buf = new StringBuffer(lispExpression);


				for (int i=1; i<lispExpression[counter].length-1; i++) {
					if (lispExpression[counter][i] == '(') {
						sublists++;
					}
				}
				int[] openPlacement = new int[sublists];
				int k=0;
				int[] closePlacement = new int[sublists];
				int j=0;
				for (int i=1; i<lispExpression[counter].length-1; i++) {
					if (lispExpression[counter][i] == '(') {
						openPlacement[k] = i;
						k++;
					}
					if (lispExpression[counter][i] == ')') {
						closePlacement[j] = i;
						j++;
					}
				}

				//	System.out.println(openPlacement[0]);
				//	System.out.println(closePlacement[0]);
				//	System.out.println(openPlacement[1]);
				//	System.out.println(closePlacement[1]);

				sublistExpressions = new char[sublists][];
				for (int i=0; i<sublists; i++) {
					sublistExpressions[i] = new char[closePlacement[i]-(openPlacement[i]+1)];
					for (int l=openPlacement[i]+1; l<closePlacement[i]; l++) {
						sublistExpressions[i][l-(openPlacement[i]+1)] = lispExpression[counter][l];
						//						System.out.print(lispExpression[counter][l]);
					}
				}

				//	System.out.println(sublistExpressions[1][1]);

			}
			else if (lispExpression[counter][0] == 'C' && lispExpression[counter][1] == 'O' && lispExpression[counter][2] == 'U' && lispExpression[counter][3] == 'N' && lispExpression[counter][4] == 'T') { // COUNT
				System.out.println(sublists);
			}
			else if (lispExpression[counter][0] == 'R' && lispExpression[counter][1] == 'E' && lispExpression[counter][2] == 'M' && lispExpression[counter][3] == 'O' && lispExpression[counter][4] == 'V' && lispExpression[counter][5] == 'E') { // REMOVE
				int[] jk = jk(lispExpression[counter]);
				System.out.print("(" + operator(lispExpression[0]));
				for (int i=0; i<jk[0]-1; i++) {
					System.out.print(" (" + String.valueOf(sublistExpressions[i]) + ")");
				}
				for (int i=jk[1]; i<sublists; i++) {
					System.out.print(" (" + String.valueOf(sublistExpressions[i]) + ")");
				}
				System.out.println(")");
			}
			else if (lispExpression[counter][0] == 'S' && lispExpression[counter][1] == 'O' && lispExpression[counter][2] == 'R' && lispExpression[counter][3] == 'T') { // SORT
				int[] jk = jk(lispExpression[counter]);
				System.out.print("(" + operator(lispExpression[0]));
				for (int i=0; i<jk[0]-1; i++) {
					System.out.print(" (" + String.valueOf(sublistExpressions[i]) + ")");
				}
				int[] alphabetize = new int[jk[1]-jk[0]+1];
				for (int i=jk[0]-1; i<jk[1]; i++) {
					alphabetize[i-jk[0]+1] = operatorNum2(sublistExpressions[i]);
				}
				for (int i=0; i<6; i++) {
					for (int j=0; j<alphabetize.length; j++) {
						if (alphabetize[j] == i) {
							System.out.print(" (" + String.valueOf(sublistExpressions[j+jk[0]-1]) + ")");
						}
					}
				}
				for (int i=jk[1]; i<sublists; i++) {
					System.out.print(" (" + String.valueOf(sublistExpressions[i]) + ")");
				}
				System.out.println(")");
			}
			else if (lispExpression[counter][0] == 'R' && lispExpression[counter][1] == 'E' && lispExpression[counter][2] == 'V' && lispExpression[counter][3] == 'E' && lispExpression[counter][4] == 'R' && lispExpression[counter][5] == 'S' && lispExpression[counter][6] == 'E') { // REVERSE
				int[] jk = jk(lispExpression[counter]);
				System.out.print("(" + operator(lispExpression[0]));
				for (int i=0; i<jk[0]-1; i++) {
					System.out.print(" (" + String.valueOf(sublistExpressions[i]) + ")");
				}
				for (int i=jk[1]-1; i>=jk[0]-1; i--) {
					System.out.print(" (" + reverse(String.valueOf(sublistExpressions[i])) + ")");
				}
				for (int i=jk[1]; i<sublists; i++) {
					System.out.print(" (" + String.valueOf(sublistExpressions[i]) + ")");
				}
				System.out.println(")");
			}
			else if (lispExpression[counter][0] == 'M' && lispExpression[counter][1] == 'A' && lispExpression[counter][2] == 'X' && lispExpression[counter][3] == 'I' && lispExpression[counter][4] == 'M' && lispExpression[counter][5] == 'U' && lispExpression[counter][6] == 'M') { // MAXIMUM
				int numMostSubs = 0;
				int mostSubs = 0;
				for (int i=0; i<sublists; i++) {
					int spaces=0;
					for (int j=0; j<sublistExpressions[i].length; j++) {
						if (sublistExpressions[i][j] == ' ') {
							spaces++;
						}
					}
					if (spaces > numMostSubs) {
						numMostSubs = spaces;
						mostSubs = i;
					}
				}
				System.out.println("(" + String.valueOf(sublistExpressions[mostSubs]) + ")");
			}
			counter++;
		}

	}

	public static String operator (char[] lispExpression) {
		String operator;
		if (lispExpression[1] == 'A') operator = "ADD";
		else if (lispExpression[1] == 'D') operator = "DIV";
		else if (lispExpression[1] == 'E') operator = "EXP";
		else if (lispExpression[1] == 'M') operator = "MULT";
		else if (lispExpression[1] == 'S' && lispExpression[2] == 'Q') operator = "SQR";
		else operator = "SUB";
		return operator;
	}

	public static int operatorNum (char[] lispExpression) {
		int operatorNum;
		if (lispExpression[1] == 'A') operatorNum = 0;
		else if (lispExpression[1] == 'D') operatorNum = 1;
		else if (lispExpression[1] == 'E') operatorNum = 2;
		else if (lispExpression[1] == 'M') operatorNum = 3;
		else if (lispExpression[1] == 'S' && lispExpression[2] == 'Q') operatorNum = 4;
		else operatorNum = 5;
		return operatorNum;
	}

	public static int operatorNum2 (char[] lispExpression) {
		int operatorNum;
		if (lispExpression[0] == 'A') operatorNum = 0;
		else if (lispExpression[0] == 'D') operatorNum = 1;
		else if (lispExpression[0] == 'E') operatorNum = 2;
		else if (lispExpression[0] == 'M') operatorNum = 3;
		else if (lispExpression[0] == 'S' && lispExpression[1] == 'Q') operatorNum = 4;
		else operatorNum = 5;
		return operatorNum;
	}
	
	public static String reverse (String normal) {
		String[] parts = normal.split(" ");
		String[] reverseParts = new String[parts.length];
		reverseParts[0] = parts[0];
		for (int i=1; i<parts.length; i++) {
			reverseParts[i] = parts[parts.length-i];
		}
		String reverse = "";
		for (int i=0; i<reverseParts.length; i++) {
			reverse = reverse + reverseParts[i];
			if (i != reverseParts.length-1) {
				reverse = reverse + " ";
			}
		}
		return reverse;
	}

	public static int[] jk (char[] lispExpression) {
		int[] jk = new int[2];
		String[] lines = String.valueOf(lispExpression).split(" ");

		jk[0] = Integer.parseInt(lines[1]);
		jk[1] = Integer.parseInt(lines[2]);

		return jk;
	}

}