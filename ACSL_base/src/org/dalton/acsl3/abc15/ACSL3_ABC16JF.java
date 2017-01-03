package org.dalton.acsl3.abc15;
import java.util.Scanner;


public class ACSL3_ABC16JF {
	public static void main(String[] args){
		int place1 =0;
		int place2 =0;
		int place3 =0;
		int place4 =0;
		int number =0;
		char char1 = 'c';
		Scanner scan = new Scanner(System.in);
		
		String input;
		String[] data;

		//take the input
		input = scan.nextLine();

		//break up the input
		data = input.split(", ");

		//split parse data into different 
		place1 =Integer.parseInt(data[0]);
		place2 =Integer.parseInt(data[1]);
		place3 =Integer.parseInt(data[2]);
		place4 =Integer.parseInt(data[3]);
		
//		char1 =Character.parseChar(data[4]);
//		
//		char c = s.charAt(0);
	}
}
