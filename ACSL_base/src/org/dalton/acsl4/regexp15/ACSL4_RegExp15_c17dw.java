package org.dalton.acsl4.regexp15;
import java.util.Scanner;
public class ACSL4_RegExp15_c17dw {
	private void main() {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String[] sin = str.split("[, ]+");
		int length = 0;
		for(int i = 0; i < 10; i++){
			if(sin[i].length()>length) length=sin[i].length();
		}
		char[][] cin = new char [10][length];
		for(int i = 0; i < 10; i++){
			char[] A = sin[i].toString().toCharArray();
			for(int j = 0; j < sin[i].length(); j++){
				cin[i][j] = A[j];
			}
		}
	}
}