package org.dalton.acsl4.regexp15;
import java.util.Scanner;
public class ACSL_RegExp15_KW {
	public static String[] strings;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		input=input.replace(",", "");
		strings = input.split("[' ']");
		solve(scan.nextLine());
		solve(scan.nextLine());
		solve(scan.nextLine());
		solve(scan.nextLine());
		solve(scan.nextLine());
		
	}
	public static void solve(String input){ 
		String answer = "";
		int answers = 0;
		for (int i = 1; i < strings.length; i ++){
		
			if (strings[i].matches(input)){
				answer = answer+strings[i]+",";
				answers++;
			}
		}
		if (answer.length()>0){
			answer = answer.substring(0, answer.length()-1);
			
			
			
			
		} else {
			answer = "NONE";
		}
		System.out.println(answer);
	}
	
}
