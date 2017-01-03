package org.dalton.acsl1.chmod15;

import java.util.Scanner;

/**
 * 
 * @author elimiller
 *
 */
public class ACSL1_chmod15_EM {
	public static void main(String[] args) {
		//declarations
		int count=0;
		while(count<5){
			count++;
			Scanner scan = new Scanner(System.in);
			String[] inputarray = new String[4];
			int[] data = new int[4];
			String input;
			input = scan.nextLine();
			//read input:
			//split up the data:
			inputarray = input.split(", ");
			for (int i = 0; i < data.length; i++) {
				data[i] = Integer.parseInt(inputarray[i]);
			}

			//octal number to binary
			int total = data[3] + data[2]*8 + data[1]*64;
			String binarystring = Integer.toBinaryString(total);
			char[] chararray = new char[9]; //make char array full of '0's
			for (int i = 0; i < chararray.length; i++) {
				chararray[i] = '0';
			}//fill char array with binary string
			for(int i = 0; i< binarystring.toCharArray().length; i++){
				chararray[9-binarystring.toCharArray().length+i] = binarystring.toCharArray()[i];
			}



			for (int i = 0; i < chararray.length; i++) {
				if(i>0&&i%3==0)System.out.print(" " + chararray[i]);
				else System.out.print(chararray[i]);
			}
			//binary number to corresponding char
			System.out.print(" and ");
			for (int i = 0; i < chararray.length; i++) {
				if(chararray[i]=='0') chararray[i] = '-';
				if(i%3==0&&chararray[i]=='1') chararray[i] = 'r';
				if(i%3==1&&chararray[i]=='1') chararray[i] = 'w';
				if(i%3==2&&chararray[i]=='1') chararray[i] = 'x';
				if(chararray[i]=='x'&&i==2&&data[0]==1) chararray[i]='s';
				if(chararray[i]=='x'&&i==5&&data[0]==2) chararray[i]='s';
				if(chararray[i]=='x'&&i==8&&data[0]==4) chararray[i]='t';
				if(i%3==0&&i>0) System.out.print(" " + chararray[i]);
				else System.out.print(chararray[i]);
			}
			System.out.println();
		}
	}
}
