package org.dalton.acsl2.string15;
import java.util.Scanner;
import java.math.BigDecimal;
public class ACSL2_STRING15_C16EO {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			String input = scan.nextLine();
			String[] inputArr = input.split(", ");
			String output = BigDecimal.valueOf(Double.parseDouble(inputArr[0])).setScale(Integer.parseInt(inputArr[2]), BigDecimal.ROUND_HALF_UP).toString();
			if(inputArr[0].charAt(0) == '+') output = '+' + output;
			while(output.length() < Integer.parseInt(inputArr[1])) output = "#" + output;
			if(output.length() > Integer.parseInt(inputArr[1])) for(int j = 0; j < output.length(); j++) if(output.charAt(j) != '.') output = output.replace(output.charAt(j), '#');
			while(output.length() > Integer.parseInt(inputArr[1])) output = output.replaceFirst("#", "");
			System.out.println(output);
		}
		scan.close();
	}
}
