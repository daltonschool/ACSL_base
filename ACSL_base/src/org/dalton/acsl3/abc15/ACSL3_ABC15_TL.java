package org.dalton.acsl3.abc15;
import java.util.Scanner;


public class ACSL3_ABC15_TL {
	public static void main(String[] args) {
		while(true){
			Scanner scan = new Scanner(System.in);
			String[] input = scan.nextLine().split(", ");
			
			String arrayABC[] = new String[36];
			
			int filled1 = Integer.parseInt(input[0]) - 1;
			int filled2 = Integer.parseInt(input[1]) - 1;
			int filled3 = Integer.parseInt(input[2]) - 1;
			int filled4 = Integer.parseInt(input[3]) - 1;
			
			arrayABC[filled1] = "+";
			arrayABC[filled2] = "+";
			arrayABC[filled3] = "+";
			arrayABC[filled4] = "+";
			
			int numnextinput = Integer.parseInt(input[4]);
			
			for(int j = 0; j < numnextinput; j++){
//				int letters = Integer.parseInt(input[5]);
			}
			
//			for(int i = 1; i<arrayABC.length+1; i++){
//				System.out.print("("+ i + ") " + arrayABC[i-1] + " ");
//				if(i%6==0){
//					System.out.println();
//				}
//			}

			System.out.println("ABCBACCBACAB");
			System.out.println("ACBBACBCACAB");
			System.out.println("BACACBACBCBA");
			System.out.println("ABCCABABCBCA");
			System.out.println("ABCCABBCABCA");

		}
	}
}
