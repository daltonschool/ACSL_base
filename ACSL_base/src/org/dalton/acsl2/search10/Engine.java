package org.dalton.acsl2.search10;

//GABE JACOBS - ACSL2 - 2/10/11

import java.util.*;
import java.util.Scanner;
import java.util.regex.*;

public class Engine {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in); // new scanner
		String answer = in.nextLine();
		StringTokenizer st = new StringTokenizer(answer, ", ");
		String[] words = new String[10];
		for (int n = 0; n < 10; n++) {
			String next = st.nextToken();
			words[n] = next;
		}
		String[] commands = new String[5];
		int u = 0;
		while (u < 5) {
			String command = in.nextLine();
			String command2 = command.replaceAll("\\?", ".{1}");
			String command3 = command2.replaceAll("\\*", ".*");
			commands[u] = command3;
			u++;
		}

		int p = -1;

		int q = -1;
		String[] output = new String[10];

		for (int y = 0; y < 6; y++) {

			if (p > 0) {
				String outputFinal = (Arrays.toString(output));
				outputFinal = outputFinal.replaceAll("\\[", "");
				outputFinal = outputFinal.replaceAll("\\]", "");
				outputFinal = outputFinal.replaceAll(", nulllll", "");
				outputFinal = outputFinal.replaceAll("nulllll, ", "");
				if(outputFinal.equals("nulllll"))
				{
					outputFinal = "No Match";
				}
				System.out.println(outputFinal);
			}
			p = -1;
			Arrays.fill(output, "nulllll");
			if (y < 5) {
				for (int n = 0; n < 10; n++) {
					p++;

					Pattern pattern;
					Matcher matcher;
					pattern = Pattern.compile(commands[y]);
					matcher = pattern.matcher(words[n]);
					if (matcher.matches()) {
						output[p] = words[n];
					}
					q++;
				}
			}
		}
	}
}