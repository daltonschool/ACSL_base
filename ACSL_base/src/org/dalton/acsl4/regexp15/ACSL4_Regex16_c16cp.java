package org.dalton.acsl4.regexp15;
import java.util.Scanner;


public class ACSL4_Regex16_c16cp {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		String regexes = input.nextLine();
		String output = "";
		while(true){
			String[] data = regexes.split(",[ ]*");
			String regex = input.nextLine();
			for(int i = 0; i < data.length; i++){
				if(data[i].matches(regex) == true){
					output = output + data[i];
					output = output + ", ";
				}
			}
			output = output.substring(0, output.length()-2);
			System.out.println(output);
			output = "";
		}
		
	}
}
