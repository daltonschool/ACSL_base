package org.dalton.acsl2.string15;
import java.util.Arrays;
import java.util.Scanner;


public class ACSL2_String15_C17CO {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		scan.useDelimiter(",[ ]*");

		//get input
		int l=0;
		while (l < 5) {
			System.out.println("Type in input: ");

			String data[] = scan.nextLine().split(", ");
			String substr = Arrays.toString(data);

			String[] piece = substr.split(", ");
			System.out.println("the first piece is: " + piece[0]);
			String floatexp = piece[0];
			String lengthfloat = piece[1];
			StringBuffer buf = new StringBuffer(lengthfloat);
		



		}

		//length



		//			System.out.println("length: " + length);
		//			length = length.valueOf(length);
		//			//S
		//			StringBuffer lengthbuf = new StringBuffer(length);

		//length of floating expression


		//System.out.println("the length of the length is; " + length.length());
		//if(floatexp.length()<length.length()) {


	}



}


