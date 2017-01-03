package org.dalton.acsl1.chmod15;
import java.util.Scanner;

public class ACSL1_chmod15_DP {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] binaryForm = new int[3][3];
		char[][] permission = new char[3][3];

		for (int i=0; i<5; i++) {
			String[] input_data = input.nextLine().split(", ");
			int special = Integer.parseInt(input_data[0]);
			int user = Integer.parseInt(input_data[1]);
			int group = Integer.parseInt(input_data[2]);
			int others = Integer.parseInt(input_data[3]);

			binaryForm[0][2] = user % 2;
			binaryForm[0][1] = ((user - binaryForm[0][2])/2) % 2;
			binaryForm[0][0] = user/4;

			binaryForm[1][2] = group % 2;
			binaryForm[1][1] = ((group - binaryForm[1][2])/2) % 2;
			binaryForm[1][0] = group/4;

			binaryForm[2][2] = others % 2;
			binaryForm[2][1] = ((others - binaryForm[2][2])/2) % 2;
			binaryForm[2][0] = others/4;

			//			System.out.print((i+1) + ". ");

			for (int j=0; j<3; j++) {
				for (int k=0; k<3; k++) {
					System.out.print(binaryForm[j][k]);
					if (k==0) {
						if (binaryForm[j][k] == 1) permission[j][k] = 'r';
						else permission[j][k] = '-';
					}
					else if (k==1) {
						if (binaryForm[j][k] == 1) permission[j][k] = 'w';
						else permission[j][k] = '-';
					}
					else {
						if (binaryForm[j][k] == 1) {
							if (j<=1 && special==j+1) permission[j][k] = 's';
							else if (j==2 && special==4) permission[j][k] = 't';
							else permission[j][k] = 'x';
						}
						else permission[j][k] = '-';
					}
				}
				System.out.print(" ");
			}
			System.out.print("and");
			for (int j=0; j<3; j++) {
				System.out.print(" ");
				for (int k=0; k<3; k++) {
					System.out.print(permission[j][k]);
				}
			}
			if (i<4) System.out.println();
		}
	}
}
