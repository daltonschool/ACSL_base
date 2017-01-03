package org.dalton.acsl4.regexp15;


import java.util.Scanner;

public class ACSL4_RegExp15_CL {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] tests = scan.nextLine().split(", ");
		for(int n=0; n<5; n++) {
			String reg = scan.nextLine();
			String res = "";
			for(int i=0; i < tests.length; i++) {
				if(tests[i].equals("#")) {
					if("".matches(reg)) {
						res += "#, ";
					}
				}else {
					if(tests[i].matches(reg)) {
						res += tests[i] + ", ";
					}
				}
			}
			if(res.length() == 0) {
				System.out.println("NONE");
			}else {
				System.out.println(res.substring(0, res.length()-2));
			}
		}
	}
}
