package org.dalton.acsl1.chmod15;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ACSL1_chmod15_OG {
	
	void usingScanner() {
		String input = "testdata/oliverchmodtest";
		Scanner scan = new Scanner(new ByteArrayInputStream(input.getBytes())); 
		scan.useDelimiter(",[ ]*");
		int size = scan.nextInt();
		String type = scan.next();
		int age = scan.nextInt();
		double weight = scan.nextDouble();
	}
	
	
	
	Scanner scan;
	int num;

	void getVal() {

		System.out.println("");
		scan = new Scanner(System.in);

		System.out.println("");
		num = Integer.parseInt(scan.nextLine(), 8);
	}

	void convert() {

		String binary = Integer.toBinaryString(num);

		System.out.println("" + binary);
	}
}

class MainClass {

	public static void main(String args[]) {

		ACSL1_chmod15_OG obj = new ACSL1_chmod15_OG();

		obj.getVal();
		obj.convert();
	}
}
