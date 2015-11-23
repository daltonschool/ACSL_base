package org.dalton.acsl1.land14;
import java.util.Scanner;
import java.text.DecimalFormat;
public class ACSL1_Land14_EO {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			DecimalFormat df = new DecimalFormat(".##");
			DecimalFormat df2 = new DecimalFormat("00");
			String[] input = scan.nextLine().split(", ");
			String output = String.valueOf(calculate(input));
			String[] answer = output.split("\\.");
			String decimal = "." + answer[1];
			df.format(Double.parseDouble(decimal));
			double rounded = 60*Math.round(Double.parseDouble(decimal)*100.0)/100.0;
			double minutes = Math.round(rounded*1.0)/1.0;
			String[] realAnswer = String.valueOf(minutes).split("\\.");
			realAnswer[0] = df2.format(Double.parseDouble(realAnswer[0]));
			System.out.println(answer[0] + ":" + realAnswer[0]);
		}
		scan.close();
	}
	static double calculate(String[] input) {
		int A = 0;
		int B = 450;
		int C = 590;
		int D = 715;
		int E = 1080;
		int F = 1330;
		int G = 1490;
		int H = 1870;
		int J = 2105;
		int K = 2425;
		String x2s = input[0];
		int x2 = 0;
		if(x2s.equals("A")) x2 = A;
		else if(x2s.equals("B")) x2 = B;
		else if(x2s.equals("C")) x2 = C;
		else if(x2s.equals("D")) x2 = D;
		else if(x2s.equals("E")) x2 = E;
		else if(x2s.equals("F")) x2 = F;
		else if(x2s.equals("G")) x2 = G;
		else if(x2s.equals("H")) x2 = H;
		else if(x2s.equals("J")) x2 = J;
		else if(x2s.equals("K")) x2 = K;
		String x1s = input[1];
		int x1 = 0;
		if(x1s.equals("A")) x1 = A;
		else if(x1s.equals("B")) x1 = B;
		else if(x1s.equals("C")) x1 = C;
		else if(x1s.equals("D")) x1 = D;
		else if(x1s.equals("E")) x1 = E;
		else if(x1s.equals("F")) x1 = F;
		else if(x1s.equals("G")) x1 = G;
		else if(x1s.equals("H")) x1 = H;
		else if(x1s.equals("J")) x1 = J;
		else if(x1s.equals("K")) x1 = K;
		int distance = Math.abs(x1-x2);
		int t1 = 0;
		if(input[3].equals("AM") && Integer.parseInt(input[2]) == 12) t1 = 24;
		else if(input[3].equals("PM") && Integer.parseInt(input[2]) == 12) t1 = 12;
		else if(input[3].equals("AM")) t1 = Integer.parseInt(input[2]);
		else if(input[3].equals("PM")) t1 = Integer.parseInt(input[2]) + 12;
		int t2 = 0;
		if(input[5].equals("AM") && Integer.parseInt(input[4]) == 12) t2 = 24;
		else if(input[5].equals("PM") && Integer.parseInt(input[4]) == 12) t2 = 12;
		else if(input[5].equals("AM")) t2 = Integer.parseInt(input[4]);
		else if(input[5].equals("PM")) t2 = Integer.parseInt(input[4]) + 12;
		int v1 = Integer.parseInt(input[6]);
		int v2 = Integer.parseInt(input[7]);
		int difference = difference(t1, t2);
		//		System.out.println("distance = " + distance + " v2 = " + v2 + " difference = " + difference + " v1 = " + v1);
		double time = (double)(distance - v2*(difference))/(v1+v2);
		return time;
	}
	static int difference(int t1, int t2) {
		int d1 = t1-t2;
		int[] clock = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
		int d2 = 0;
		int i = t1;
		while(i != t2) {
			if(i != 24) i = clock[i];
			else i = clock[0];
			d2++;
		}
		if(d1 < d2) return d1;
		else return -d2;
	}
}