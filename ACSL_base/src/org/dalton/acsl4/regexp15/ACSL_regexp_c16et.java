package org.dalton.acsl4.regexp15;
import java.util.Scanner;
import java.util.regex.Pattern;
public class ACSL_regexp_c16et {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		String [] input = temp.split(", ");
		for(int x=0; x<5; x++) {
			String reg = scan.nextLine();
			String[] matches = new String[input.length];
			int matchnum = 0;
			for(int i=0; i<input.length; i++){
				if(Pattern.matches(reg, input[i])==true){
					matches[matchnum]=input[i];
					matchnum++;
				}
			}
			if(matchnum>0){
				for(int i=0; i<matchnum; i++){
					if(i<matchnum-1) System.out.print(matches[i] + ", ");
					else System.out.println(matches[i]);
				}
			}
			else if(matchnum==0) System.out.println("NONE");
		}
	}
}