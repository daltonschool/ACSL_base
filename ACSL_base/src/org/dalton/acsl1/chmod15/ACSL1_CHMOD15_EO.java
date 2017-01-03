package org.dalton.acsl1.chmod15;


import java.util.Scanner;
public class ACSL1_CHMOD15_EO {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 100; i++) {
			String input = scan.nextLine();
			String[] inputArr = input.split(", ");
			String binA = String.format("%3s", Integer.toBinaryString(Integer.parseInt(inputArr[1]))).replace(' ', '0');
			String binB = String.format("%3s", Integer.toBinaryString(Integer.parseInt(inputArr[2]))).replace(' ', '0');
			String binC = String.format("%3s", Integer.toBinaryString(Integer.parseInt(inputArr[3]))).replace(' ', '0');
			char[] perA = new char[] {'r', 'w', 'x'};
			char[] perB = new char[] {'r', 'w', 'x'};
			char[] perC = new char[] {'r', 'w', 'x'};
			for(int j = 0; j < binA.length(); j++) {
				if(binA.charAt(j) == '0') perA[j] = '-';
				if(binB.charAt(j) == '0') perB[j] = '-';
				if(binC.charAt(j) == '0') perC[j] = '-';
			}
			System.out.println(inputArr[0]);
			if(inputArr[0].equals("1")) perA[2] = 's';
			else if(inputArr[0].equals("2")) perB[2] = 's';
			else if(inputArr[0].equals("4")) perC[2] = 't';
			System.out.println("" + binA + " " + binB + " " + binC + " and " + perA[0] + perA[1] + perA[2] + " " + perB[0] + perB[1] + perB[2] + " " + perC[0] + perC[1] + perC[2]);
		}
	}
}