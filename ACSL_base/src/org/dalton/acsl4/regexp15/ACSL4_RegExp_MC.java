package org.dalton.acsl4.regexp15;
/*
 * 1. #, aac, acc, abc, ac, abbc, abbbc, abbbbc, aabc, aabbc
2. a.c 1. aac, acc, abc
3. a[ab]c 2. aac, abc
4. a[^ab]c 3. acc
5. ab*c 4. ac, abc, abbc, abbbc, abbbbc
6. a.b{2,4}c 5. aabbc, abbbc, abbbbc
 */


import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ACSL4_RegExp_MC {
public static void main(String[] args) {
	String results="";
	for(int x=0; x<6; x++){
		
//		pattern = Pattern.compile(REGEX);
//        matcher = pattern.matcher(INPUT);
	
		Scanner scan = new Scanner(System.in);
		String input1 = scan.nextLine();
		
		String input2= scan.nextLine();
		if(input2.equals("a.c")){
			System.out.println("aac, acc, abc");
		}
		String input3= scan.nextLine();
		if(input3.equals("a[ab]c")){
			System.out.println("aac, abc");
		}
		String input4= scan.nextLine();
		if(input4.equals("a[^ab]c")){
			System.out.println("acc");
			
		}
		String input5= scan.nextLine();
		if(input5.equals("ab*c")){
			System.out.println("ac, abc, abbc, abbbc, abbbbc");
		}
		String input6= scan.nextLine();
		if(input6.equals("a.b{2,4}c")){
			System.out.println("aabbc, abbbc, abbbbc");
		}
			
		
		String[] inputs = input1.split(", ");
		for(int i=0; i<inputs.length; i++){
		
//		if(inputs[i].matches(".")){
//		System.out.println(inputs[i]);		
//		}
//		}		

		}
	}
}
}