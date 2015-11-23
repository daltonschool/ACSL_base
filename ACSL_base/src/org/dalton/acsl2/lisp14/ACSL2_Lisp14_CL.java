package org.dalton.acsl2.lisp14;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * ASCL program 2: LISP Expressions
 * 
 * @author Cal Lavicka
 *
 */
public class ACSL2_Lisp14_CL {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String expression = scan.nextLine();

		ArrayList<Sublist> sublists = new ArrayList<Sublist>();

		String[] lisps = expression.substring(1).split("\\(");

		String masterExpression = lisps[0].trim();

		for (int i = 1; i < lisps.length; i++) {
			String lisp = lisps[i].split("\\)")[0];

			String[] elements = lisp.split(" ");

			Sublist sublist = new Sublist();
			sublist.expression = elements[0];
			sublist.values = new int[elements.length - 1];

			for (int j = 1; j < elements.length; j++) {
				sublist.values[j - 1] = Integer.parseInt(elements[j]);
			}

			sublists.add(sublist);
		}

		for (int i = 0; i < 5; i++) {
			String input = scan.nextLine();

			String[] elements = input.split(" ");

			if (elements[0].equalsIgnoreCase("COUNT")) {
				System.out.println(sublists.size());
			} else if (elements[0].equalsIgnoreCase("REMOVE")) {
				int lowBound = Integer.parseInt(elements[1]) - 1;
				int highBound = Integer.parseInt(elements[2]) - 1;

				System.out.print("(" + masterExpression);
				for (int j = 0; j < sublists.size(); j++) {
					if (j < lowBound || j > highBound) {
						printSublist(sublists.get(j));
					}
				}

				System.out.println(")");
			} else if (elements[0].equalsIgnoreCase("SORT")) {
				int lowBound = Integer.parseInt(elements[1]) - 1;
				int highBound = Integer.parseInt(elements[2]) - 1;

				Sublist[] toSort = new Sublist[highBound - lowBound + 1];

				System.out.print("(" + masterExpression);
				for (int j = 0; j < sublists.size(); j++) {
					if (j < lowBound || j > highBound) {
						printSublist(sublists.get(j));
					} else {
						Sublist sublist = sublists.get(j);
						toSort[j - lowBound] = sublist;

						Sublist[] sorted = new Sublist[toSort.length];

						if (j == highBound) {
							pickloop: for (int picked = 0; picked < toSort.length; picked++) {
								for (int check = 0; check < picked; check++) {
									if (sorted[check].expression
											.compareToIgnoreCase(toSort[picked].expression) >= 0) {
										for(int replace = picked; replace > check; replace--) {
											sorted[replace] = sorted[replace-1];
										}
										
										sorted[check] = toSort[picked];
										continue pickloop;
									}
								}

								sorted[picked] = toSort[picked];
							}
						
							for(int k = 0; k < sorted.length; k++) {
								printSublist(sorted[k]);
							}
						}
					}
				}

				System.out.println(")");
			} else if (elements[0].equalsIgnoreCase("REVERSE")) {
				int lowBound = Integer.parseInt(elements[1]) - 1;
				int highBound = Integer.parseInt(elements[2]) - 1;

				System.out.print("(" + masterExpression);
				for (int j = 0; j < sublists.size(); j++) {
					if (j < lowBound || j > highBound) {
						printSublist(sublists.get(j));
					} else {
						reverseSublist(sublists.get(highBound - j + lowBound));
					}
				}

				System.out.println(")");
			} else if (elements[0].equalsIgnoreCase("MAXIMUM")) {
				Sublist maxSub = null;
				
				for (int j = 0; j < sublists.size(); j++) {
					if(maxSub == null || sublists.get(j).values.length > maxSub.values.length) {
						maxSub = sublists.get(j);
					}
				}

				System.out.print("(" + maxSub.expression);
				for (int n = 0; n < maxSub.values.length; n++) {
					System.out.print(" " + maxSub.values[n]);
				}
				System.out.println(")");
			}
		}
		
		scan.close();
	}
	
	public static void printSublist(Sublist sublist) {
		System.out.print(" ");
		System.out.print("(" + sublist.expression);
		for (int n = 0; n < sublist.values.length; n++) {
			System.out.print(" " + sublist.values[n]);
		}
		System.out.print(")");
	}
	
	public static void reverseSublist(Sublist sublist) {
		System.out.print(" ");
		System.out.print("(" + sublist.expression);
		for (int n = sublist.values.length-1; n >= 0; n--) {
			System.out.print(" " + sublist.values[n]);
		}
		System.out.print(")");
	}

	static class Sublist {

		String expression;
		int[] values;
	}
}
