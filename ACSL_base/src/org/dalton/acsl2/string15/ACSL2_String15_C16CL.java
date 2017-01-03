package org.dalton.acsl2.string15;


import java.util.Scanner;

public class ACSL2_String15_C16CL {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			String[] inputs = scan.nextLine().split(", ");
			String[] num = inputs[0].split("\\.");
			if (num.length == 1) {
				num = new String[]{num[0], ""};
			}
			int length = Integer.parseInt(inputs[1]);
			int decimal = Integer.parseInt(inputs[2]);
			
			String response = "";
			if (num[0].charAt(0) == '+' || num[0].charAt(0) == '-') {
				response += num[0].charAt(0);
				num[0] = num[0].substring(1);
				length--;
			}
			// if(decimal > 0) decimal++;
			int frontLength = length - decimal;
			if(decimal > 0) frontLength--;
			//System.out.println(frontLength + ", " + length + ", " + decimal);
			
			if(decimal == 0) {
				int numToPrint = Integer.parseInt(num[0]);
				
				if (num[1].length() >= 1 && num[1].charAt(0) >= 48 + 5) {
					numToPrint++;
				}
				num[0] = "" + numToPrint;
			}
			
			if (frontLength < num[0].length()) {
				for(int j=0; j<frontLength; j++) {
					response += "#";
				}
				if(decimal > 0)
					response += ".";
				for(int j=0; j<decimal; j++) {
					response += "#";
				}
			} else {
				if (decimal > 0) {
					if (num[1].length() <= decimal) {
						for (int j = 0; j < frontLength - num[0].length(); j++) {
							response += "#";
						}
						response += num[0];
						response += ".";
						response += num[1];
						for (int j = 0; j < decimal - num[1].length(); j++) {
							response += "0";
						}
					} else {
						char[][] nchar = new char[][]{num[0].toCharArray(),
								num[1].toCharArray()};
						int c2 = nchar[1][decimal] - 48 - 5;
						if (c2 >= 0) {
							nchar[1][decimal - 1]++;
						}
						outer : for (int j = decimal - 1; j >= 0; j--) {
							if (nchar[1][j] >= 58) {
								nchar[1][j] = 48;
								if (j > 0)
									nchar[1][j - 1]++;
								else {
									nchar[0][nchar[0].length - 1]++;
									for (int k = nchar[0].length-1; k >= 0; k--) {
										if (nchar[0][k] >= 58) {
											nchar[0][k] = 48;
											if (k > 0)
												nchar[0][k - 1]++;
											else {
												num[0] = "1"
														+ new String(nchar[0]);
												break outer;
											}
										}
									}
									num[0] = new String(nchar[0]);
								}
							} else {
								break;
							}
						}
						
						num[1] = "";
						for (int j = 0; j < decimal; j++) {
							num[1] += nchar[1][j];
						}
						for (int j = 0; j < frontLength - num[0].length(); j++) {
							response += "#";
						}
						response += num[0] + "." + num[1];
						
					}
				} else {
					
					
					for (int j = 0; j < frontLength - num[0].length(); j++) {
						response += "#";
					}
					response += num[0];
				}
			}
			
			System.out.println(response);
		}
	}
}
