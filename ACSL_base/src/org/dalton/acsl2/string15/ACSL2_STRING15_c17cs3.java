package org.dalton.acsl2.string15;
import java.io.ByteArrayInputStream;
import java.util.Scanner;


public class ACSL2_STRING15_c17cs3 {
	public static void main(String[] args) {
		
		String input = "1, 10, 4";
		Scanner scan = new Scanner(new ByteArrayInputStream(input.getBytes())); 
		scan.useDelimiter(",[ ]*");
		String exp = scan.next();
		int length = scan.nextInt();
		int decimal = scan.nextInt();
		String whole = null;
		String dec = null;
		String[] answer = new String[5];
		
		if (exp.contains("+")) {
			answer[0] = "+";
			whole = exp.substring(exp.charAt(1), exp.indexOf("."));
			dec = exp.substring(exp.indexOf("."), exp.charAt(exp.length()));
			for (int i = 0; i < length; i++) {
				
			}
		}
		else if (exp.contains("-")) {
			answer[0] = "-";
			whole = exp.substring(exp.charAt(1), exp.indexOf("."));
			dec = exp.substring(exp.indexOf("."), exp.charAt(exp.length()));
		}
		else {
			answer[0] = null;
			whole = exp.substring(exp.charAt(0), exp.indexOf("."));
			dec = exp.substring(exp.indexOf("."), exp.charAt(exp.length()));
		}
		
	}
}
