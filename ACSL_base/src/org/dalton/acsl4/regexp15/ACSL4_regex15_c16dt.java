package org.dalton.acsl4.regexp15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ACSL4_regex15_c16dt {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String out = "";

		String[] exp = scan.nextLine().split(",[ ]*");

		boolean matched = false;

		String s;
		
		while(true) {
			
			out = "";
			matched = false;
			
			try {
				s = scan.nextLine();
			} catch (NoSuchElementException e) {
				break;
			}

			for (int j = 0; j < exp.length; j++) {
				
				//System.out.println(exp[j]);
				
				if (exp[j].equals("#")) {
					if("".matches(s)) {
						out += (exp[j] + ", ");
						matched = true;
					}
				}
				else if (exp[j].matches(s)) {
					out += (exp[j] + ", ");
					matched = true;
				}
			}

			if (!matched) System.out.println("NONE");
			else System.out.println(out.substring(0, out.length()-2));
			


		}



	}
}
