package org.dalton.acsl2.string15;
import java.math.BigDecimal;
import java.util.Scanner;

public class ACSL2_STRING15_c17tv {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //declarations
		String i;
		String[] h;
		double data1;
		int data2;
		int data3;

		while (true){
			int plus = 0;
			i = scan.nextLine(); //gets input
			if (i.indexOf('+')>=0) plus=1; //if +
			h = i.split(", "); //splits up data
			data1 = Double.parseDouble(h[0]);; //gets the first part 523
			data2 = Integer.parseInt(h[1]); //gets the second part 6
			data3 = Integer.parseInt(h[2]); //gets the third part 2
			String x = data1+""; //makes new String
			double y = Double.parseDouble(x); //makes double
			x = ""+round(y, data3);	//rounds number
			if (plus == 1)x = "+" + x.substring(0, x.length()); //checks if +
			if(data3==0) x = x.substring(0, x.length()-2); //if data3 = 0
			if(data2>x.length()){	//gets length if too small replaces with #
				int times=data2-x.length();
				for (int j = 0; j < times; j++) {
					x = "#" + x.substring(0, x.length());
				}
			}
			if (x.length()>data2){ 		//gets length if it doesn't fit replaces all with #
				x = x.replaceAll("\\d", "#");
				x = x.substring(x.length()-data2, x.length());
			}		
			System.out.println(x);
		}
	}
	public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
		BigDecimal bigDecimal = new BigDecimal(value);
		bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint,
				BigDecimal.ROUND_HALF_UP);
		return bigDecimal.doubleValue();
	}
}