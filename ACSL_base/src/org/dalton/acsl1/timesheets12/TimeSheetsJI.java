package org.dalton.acsl1.timesheets12;
/*
 * Name: Jemma Issroff
 * School: The Dalton School
 * School Code: 3055
 * Date: Jan 2013
 */

import java.math.RoundingMode;
import java.text.*;
import java.util.*;
public class TimeSheetsJI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<5; i++){
			int number = Integer.parseInt(Character.toString(scanner.next().charAt(0)));
			String[] input = scanner.nextLine().trim().split(" ");
			double[] hours = totalHours(input);
			double res = money(number,hours);
			DecimalFormat df = new DecimalFormat("##0.00");
			df.setRoundingMode(RoundingMode.HALF_UP);
			System.out.println("$"+df.format(res));
		}
	}
	public static double[] totalHours(String[] input){
		double[] res = new double[input.length];
		for(int i=0; i<input.length; i++){
			String[] s = input[i].split(",");
			res[i] = (charToNum(s[1].charAt(0))-charToNum(s[0].charAt(0)))/2.0;
		}
		return res;
	}
	public static int charToNum(char c){
		if(c=='A'||c=='B'||c=='C'||c=='D'||c=='E'||c=='F'||c=='G'||c=='H')
			return (int)c-55;
		else return Integer.parseInt(Character.toString(c));
	}
	public static double money(int number, double[] hours){
		double sum = sumHours(hours);
		if(number==1){
			if(sum>30) return 300+(sum-30)*15;
			else return sum*10;
		}
		else if (number==2){
			if(sum>40) return 300+(sum-40)*15;
			else return sum*7.5;
		}
		//FIX THIS ONE
		else if (number==3){
			if(sum>20) return 185+(sum-20)*10.50;
			else return sum*9.25;
		}
		else if (number==4){
			double satsun=hours[0]+hours[6];
			return (satsun)*13.5+(sum-satsun)*6.75;
		}
		else if (number==5){
			double res = 0;
			for (int i=0; i<hours.length; i++){
				if(hours[i]>6) res+=48+(hours[i]-6)*12;
				else res+=hours[i]*8;
			}
			return res;
		}
		return -1;
	}
	public static double sumHours(double[] hours){
		double res=0;
		for(int i=0; i<hours.length; i++) res+=hours[i];
		return res;
	}

}
