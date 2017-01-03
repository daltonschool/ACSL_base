package org.dalton.acsl2.string15;
import java.util.Scanner;
public class ACSL2_string15_c17mf {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		String[][] input = { scan.nextLine().split(", "), scan.nextLine().split(", "), scan.nextLine().split(", "), scan.nextLine().split(", "), scan.nextLine().split(", ")};
		for(int i = 0; i < 5; i++) {
		boolean pos = false;
		int decis = (input[i][0].substring(input[i][0].indexOf("."), input[i][0].length())).length()-1;
		if((input[i][0].toCharArray())[0] == '+') pos = true; 
		STR(Float.parseFloat(input[i][0]), Integer.parseInt(input[i][1]), Integer.parseInt(input[i][2]), pos, input[i][0].toCharArray().length, decis); 
		}
	}
	public static String STR(float flo, int length_w, int dig, boolean pos, int length_a, int decis) {
		if(pos == true) System.out.print("+");
		if(length_w > length_a) {
		for(int i = 0; i < (length_w-length_a) + 1; i++) System.out.print("#");		}
		if((dig <= decis) && ((length_a - decis + dig) == length_w)) System.out.print(String.format("%." + (dig) + "f", flo));
		else  {
				for(int i = 0; i < (length_w - dig); i++) System.out.print("#");
				System.out.print(".");
				for(int i = 0; i < dig; i++) System.out.print("#");
			}
		System.out.println("");
		return null;
	}
}