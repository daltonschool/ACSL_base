package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ACSL1_chmod15_MW {
	public static void main(String[] args){

		String input = "0,5,2,6";
		Scanner scan = new Scanner(new ByteArrayInputStream(input.getBytes())); 
		scan.useDelimiter(",[ ]*");
		int[] mod = new int[4];
		int permissions = mod[0];

		while(scan.hasNext()){

			//char c = scan.next().charAt(0);
			//int num = c-'a';
			//mod[num%mod.length]++;


			int p = scan.nextInt();

			String binaryString = Integer.toBinaryString(p);

			if(permissions == 0){
				if(binaryString == "000"){
					System.out.println("---");
				}
				if(binaryString == "001"){
					System.out.println("--x");
				}
				if(binaryString == "010"){
					System.out.println("-w-");
				}
				if(binaryString == "011"){
					System.out.println("-wx");
				}
				if(binaryString == "100"){
					System.out.println("r--");
				}
				if(binaryString == "101"){
					System.out.println("r-x");
				}
				if(binaryString == "110"){
					System.out.println("rw-");
				}
				if(binaryString == "111"){
					System.out.println("rwx");
				}
			}

			System.out.print(binaryString + " ");

		}


	}
}