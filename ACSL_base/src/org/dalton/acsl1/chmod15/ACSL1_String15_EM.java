package org.dalton.acsl1.chmod15;
import java.util.Scanner;


public class ACSL1_String15_EM {
	public static void main(String[] args) {
		for(int j=0; j<5; j++){
			//declarations
			Scanner scan = new Scanner(System.in);
			String input;
			int length;
			int decimal;
			String[] inputarray = new String[3];

			//parse input
			input = scan.nextLine();
			inputarray = input.split(", ");
			length = Integer.parseInt(inputarray[1]);
			decimal = Integer.parseInt(inputarray[2]);
			char first=' ';
			if(inputarray[0].startsWith("+")){
				first = '+';
				length--;
			}if(inputarray[0].startsWith("-")){
				first = '-';
				length--;
			}
			//round double to right number of decimal places
			double firstterm = Double.parseDouble(inputarray[0]);
			double n = Math.abs(Math.round(firstterm*Math.pow(10, decimal))/Math.pow(10, decimal));

			String s = Double.toString(n);
			char[] output = new char[Integer.parseInt(inputarray[1])];
			if(s.length()<length){
				while(s.length()<length){
					String news = "#" + s;
					s = news;
					char[] wen = s.toCharArray();
					for (int i = 0; i < wen.length; i++) {
						if(first==' ') output[i] = wen[i];
						else output[i+1] = wen[i];
					}
				}

			}
			if(s.length()>length){
				char[] news = new char[length];
				for(int i=0; i<decimal; i++){
					news[length-1-i] = '#';
				}
				for(int i=0; i<length-1; i++){
					if(news[i+1]!='#') news[i]='#';
					else{
						news[i]='.';
						break;
					}
				}
				for (int i = 0; i < news.length; i++) {
					if(first==' ') output[i] = news[i];
					else output[i+1] = news[i];
				}
			}
			if(s.length()==length){
				char[] news = s.toCharArray();
				for (int i = 0; i < news.length; i++) {
					if(first==' ') output[i] = news[i];
					else output[i+1] = news[i];
				}
			}
			//add sign
			if(first!=' ') output[0] = first;
			//print output
			for(int i = 0; i<output.length; i++){
				System.out.print(output[i]);
			}
			System.out.println();
		}
	}
}
