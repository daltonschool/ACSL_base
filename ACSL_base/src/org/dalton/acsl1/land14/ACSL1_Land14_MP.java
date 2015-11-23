package org.dalton.acsl1.land14;
import java.text.DecimalFormat;
import java.util.Scanner;

/* ACSL Contest #1
 * 
 * Author: Meet Patel
 * School: The Dalton School
 * Test:
 * A, C, 1, PM, 2, PM, 50, 60
A, D, 9, AM, 1, PM, 50, 60
B, E, 5, PM, 3, PM, 50, 60
C, F, 11, PM, 2, AM, 50, 60
E, K, 10, AM, 12, PM, 65, 55
 */
public class ACSL1_Land14_MP {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] data = new String[5];
		DecimalFormat df = new DecimalFormat("00");

		//just read the data
		for (int i = 0; i < 5; i++) { 
			data[i] = input.nextLine();
		}

		//split the data and call the functions
		for (int m = 0; m < 5; m++) {
			if (distance(data[m].split(", ")[0].charAt(0),data[m].split(", ")[1].charAt(0))==0) {
				System.out.println("0:00");
			}
			else{
				double ans = meetingPoint(Double.parseDouble(data[m].split(", ")[6]), Double.parseDouble(data[m].split(", ")[7]), timeDiff(Integer.parseInt(data[m].split(", ")[2]),data[m].split(", ")[3],Integer.parseInt(data[m].split(", ")[4]),data[m].split(", ")[5]), distance(data[m].split(", ")[0].charAt(0),data[m].split(", ")[1].charAt(0)));

				System.out.print((int)ans + ":");
				//System.out.println(String.format("%.2g%n", (ans-(int)ans)*60));
				System.out.println(df.format((ans-(int)ans)*60));
				//System.out.println("Ans: " + ans);
				//System.out.println("Distance: " + distance(data[m].split(", ")[0].charAt(0),data[m].split(", ")[1].charAt(0)));
			}
		}
	}
	public static int distance(char cityA, char cityB) {
		int res = 0;
		int city1 = (int)Math.min((int)cityA, (int)cityB) -65;
		int city2 = (int)Math.max((int)cityA, (int)cityB) -65;		

		if (city1 > 7) city1--;
		if (city2 > 7) city2--;
		//System.out.println(city1 + " " + city2);
		int[] cities = {450, 140, 125, 365, 250, 160, 380, 235, 320};

		for (int i = city1; i < (city2); i++) {
			res += cities[i];
		}

		if(city1-city2 == 0) {
			res = 0;
		}

		return res;
	}
	public static double timeDiff(int t1, String p1, int t2, String p2) {
		//math doesn't work yet: doesn't go from 24->0
		if (t1==12 && p1.equals("AM")) t1=t1%12;
		if (t2==12 && p2.equals("AM")) t2=t2%12;
		if (p1.equals("PM") && t1!=12) t1+=12;
		if (p2.equals("PM") && t2!=12) t2+=12;
		//possible take out the absolute value and have +/- sign in final calc
		double res = t2-t1;
		if(res>12) res = -(24-res);
		else if (res<-12) res = 24+res;
		//System.out.println("T1 " + t1+ " T2 " + t2);
		//System.out.println(res);
		return res;
	}
	public static double meetingPoint(double vel1, double vel2, double timeDiff, int dist) {
		double res = (dist+(timeDiff*vel2))/((vel1+vel2));
		//System.out.println((timeDiff*vel2));
		return res;
	}

}
