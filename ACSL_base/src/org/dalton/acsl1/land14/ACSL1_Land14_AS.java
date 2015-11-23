package org.dalton.acsl1.land14;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * Alexandra Schein
 * The Dalton School
 */


/*test data:
 * A, C, 1, PM, 2, PM, 50, 60
 * A, D, 9, AM, 1, PM, 50, 60
 * B, E, 5, PM, 3, PM, 50, 60
 * C, F, 11, PM, 2, AM, 50, 60
 * E, K, 10, AM, 12, PM, 65, 55
 *////
public class ACSL1_Land14_AS {
	public static void main(String args[]){
		
		for(int i = 0; i<5; i++){
		Scanner input = new Scanner(System.in);
		String dataIn = input.nextLine();
		String[] data = dataIn.split(", ");
		String output = "";
		//(String X, String Y, int h1, String spec1, int h2, String spec2, int V1, int V2)
		String X = data[0];
		String Y = data[1];
		int h1 = Integer.parseInt(data[2]);
		String spec1 = data[3];
		int h2 = Integer.parseInt(data[4]);
		String spec2 = data[5];
		int V1 = Integer.parseInt(data[6]);
		int V2 = Integer.parseInt(data[7]);
		
		output = theWork(X, Y, h1, spec1, h2, spec2, V1, V2);
		
		System.out.println(output);
		};

	}//close main

	static double calcDist(String X, String Y){
		double distance = 0;

		if((X.equals("A") && Y.equals("B")) || (X.equals("B") && Y.equals("A"))){
			distance = 450;
		}
		else if((X.equals("A") && Y.equals("C"))|| (X.equals("C") && Y.equals("A"))){
			distance = 590;
		}
		else if((X.equals("A") && Y.equals("D"))|| (X.equals("D") && Y.equals("A"))){
			distance = 715;
		}
		else if((X.equals("A") && Y.equals("E")) || (X.equals("E") && Y.equals("A"))){
			distance = 1080;
		}
		else if((X.equals("A") && Y.equals("F")) || (X.equals("F") && Y.equals("A"))){
			distance = 1330;
		}
		else if((X.equals("A") && Y.equals("G")) || (X.equals("G") && Y.equals("A"))){
			distance = 1490;
		}
		else if((X.equals("A") && Y.equals("H")) || (X.equals("H") && Y.equals("A"))){
			distance = 1870;
		}
		else if((X.equals("A") && Y.equals("J")) || (X.equals("J") && Y.equals("A"))){
			distance = 2105;
		}
		else if((X.equals("A") && Y.equals("K")) || (X.equals("K") && Y.equals("A"))){
			distance = 2425;
		}
		else if((X.equals("B") && Y.equals("C")) || (X.equals("C") && Y.equals("B"))){
			distance = 140;
		}
		else if((X.equals("B") && Y.equals("D")) || (X.equals("D") && Y.equals("B"))){
			distance = 265;
		}
		else if((X.equals("B") && Y.equals("E")) || (X.equals("E") && Y.equals("B"))){
			distance = 630;
		}
		else if((X.equals("B") && Y.equals("F")) || (X.equals("F") && Y.equals("B"))){
			distance = 880;
		}
		else if((X.equals("B") && Y.equals("G")) || (X.equals("G") && Y.equals("B"))){
			distance = 1040;
		}
		else if((X.equals("B") && Y.equals("H")) || (X.equals("H") && Y.equals("B"))){
			distance = 1420;
		}
		else if((X.equals("B") && Y.equals("J")) || (X.equals("J") && Y.equals("B"))){
			distance = 1655;
		}
		else if((X.equals("B") && Y.equals("K")) || (X.equals("K") && Y.equals("B"))){
			distance = 1975;
		}
		else if((X.equals("C") && Y.equals("D")) || (X.equals("D") && Y.equals("C"))){
			distance = 125;
		}
		else if((X.equals("C") && Y.equals("E")) || (X.equals("E") && Y.equals("C"))){
			distance = 490;
		}
		else if((X.equals("C") && Y.equals("F")) || (X.equals("F") && Y.equals("C"))){
			distance = 740;
		}
		else if((X.equals("C") && Y.equals("G")) || (X.equals("G") && Y.equals("C"))){
			distance = 900;
		}
		else if((X.equals("C") && Y.equals("H")) || (X.equals("H") && Y.equals("C"))){
			distance = 1280;
		}
		else if((X.equals("C") && Y.equals("J")) || (X.equals("J") && Y.equals("C"))){
			distance = 1515;
		}
		else if((X.equals("C") && Y.equals("K")) || (X.equals("K") && Y.equals("C"))){
			distance = 1835;
		}
		else if((X.equals("D") && Y.equals("E")) || (X.equals("E") && Y.equals("D"))){
			distance = 365;
		}
		else if((X.equals("D") && Y.equals("F")) || (X.equals("F") && Y.equals("D"))){
			distance = 615;
		}
		else if((X.equals("D") && Y.equals("G")) || (X.equals("G") && Y.equals("D"))){
			distance = 775;
		}
		else if((X.equals("D") && Y.equals("H")) || (X.equals("H") && Y.equals("D"))){
			distance = 1155;
		}
		else if((X.equals("D") && Y.equals("J")) || (X.equals("J") && Y.equals("D"))){
			distance = 1390;
		}
		else if((X.equals("D") && Y.equals("K")) || (X.equals("K") && Y.equals("D"))){
			distance = 1710;
		}
		else if((X.equals("E") && Y.equals("F")) || (X.equals("F") && Y.equals("E"))){
			distance = 250;
		}
		else if((X.equals("E") && Y.equals("G")) || (X.equals("G") && Y.equals("E"))){
			distance = 410;
		}
		else if((X.equals("E") && Y.equals("H")) || (X.equals("H") && Y.equals("E"))){
			distance = 790;
		}
		else if((X.equals("E") && Y.equals("J")) || (X.equals("J") && Y.equals("E"))){
			distance = 1025;
		}
		else if((X.equals("E") && Y.equals("K")) || (X.equals("K") && Y.equals("E"))){
			distance = 1345;
		}
		else if((X.equals("F") && Y.equals("G")) || (X.equals("G") && Y.equals("F"))){
			distance = 160;
		}
		else if((X.equals("F") && Y.equals("H")) || (X.equals("H") && Y.equals("F"))){
			distance = 540;
		}
		else if((X.equals("F") && Y.equals("J")) || (X.equals("J") && Y.equals("F"))){
			distance = 775;
		}
		else if((X.equals("F") && Y.equals("K")) || (X.equals("K") && Y.equals("F"))){
			distance = 1095;
		}
		else if((X.equals("E") && Y.equals("F")) || (X.equals("F") && Y.equals("E"))){
			distance = 250;
		}
		else if((X.equals("E") && Y.equals("G")) || (X.equals("G") && Y.equals("E"))){
			distance = 410;
		}
		else if((X.equals("E") && Y.equals("H")) || (X.equals("H") && Y.equals("E"))){
			distance = 790;
		}
		else if((X.equals("E") && Y.equals("J")) || (X.equals("J") && Y.equals("E"))){
			distance = 1025;
		}
		else if((X.equals("E") && Y.equals("K")) || (X.equals("K") && Y.equals("E"))){
			distance = 1345;
		}
		else if((X.equals("F") && Y.equals("G")) || (X.equals("G") && Y.equals("F"))){
			distance = 160;
		}
		else if((X.equals("F") && Y.equals("H")) || (X.equals("H") && Y.equals("F"))){
			distance = 540;
		}
		else if((X.equals("F") && Y.equals("J")) || (X.equals("J") && Y.equals("F"))){
			distance = 775;
		}
		else if((X.equals("F") && Y.equals("K")) || (X.equals("K") && Y.equals("F"))){
			distance = 1095;
		}
		else if((X.equals("G") && Y.equals("H")) || (X.equals("H") && Y.equals("G"))){
			distance = 380;
		}
		else if((X.equals("G") && Y.equals("J")) || (X.equals("J") && Y.equals("G"))){
			distance = 615;
		}
		else if((X.equals("G") && Y.equals("K")) || (X.equals("K") && Y.equals("G"))){
			distance = 935;
		}
		else if((X.equals("H") && Y.equals("J")) || (X.equals("J") && Y.equals("H"))){
			distance = 235;
		}
		else if((X.equals("H") && Y.equals("K")) || (X.equals("K") && Y.equals("H"))){
			distance = 555;
		}
		else if((X.equals("J") && Y.equals("K")) || (X.equals("K") && Y.equals("J"))){
			distance = 320;
		}

		return distance;
	}//close static calc dist

	static String theWork(String X, String Y, int h1, String spec1, int h2, String spec2, int V1, int V2){
		String realTime = "";
		double newDist = 0;
		double timeDiff = 0;//difference between when people leave
		double speeds = V1+V2;//sum of the two speeds
		double x = 0;
		double decTime = 0;
		int first = 0;
		boolean diff = false;
		//find initial distance
		double initialDist = calcDist(X, Y);
		//find difference in time left
		if(spec1.equals(spec2) && h1!=12 && h2!=12){
			timeDiff = Math.abs(h1-h2);
			first = Math.min(h1, h2);
		}
		else if(!(spec1.equals(spec2)) && h1!=12 && h2!=12){
			int bigger = Math.max(h1,h2);
			int smaller = Math.min(h1,h2);
			timeDiff = 12-bigger+smaller;
			first = Math.max(h1, h2);
			diff = true;
		}
		//if 12 and diff
		else if((h1==12 || h2==12) && !(spec1.equals(spec2))){
			timeDiff = Math.abs(h1-h2);
			first = Math.min(h1, h2);
		}
		//if 12 and same
		else if((h1==12 || h2==12) && spec1.equals(spec2)){
			timeDiff = Math.abs(h1-h2);
			first = 12;
		}
		//figure out which traveler left first and calculate there spot when the other traveler leaves
		//if(first==h1 && !(h1==12) && !(h2==12)){//if first traveler leaves first
		if(first==h1){
			newDist=V1*timeDiff;
			x = initialDist-newDist;
			decTime = x/speeds;
			//store first digit of number
			String toString = "" + decTime;
			StringBuffer sb = new StringBuffer(toString);
			String hour = "";
			String aftDec = "";
			for(int i = 0; i<sb.length(); i++){
				if(sb.charAt(i)=='.'){
					hour = sb.substring(0, i);
					aftDec = sb.substring(i);
				}
			}//close for loop
			//turn aftDec into minutes
			double temp = Double.parseDouble(aftDec);
			double newAftDec = temp*60/100;
			StringBuffer sb1 = new StringBuffer(hour);
			//connect new aft dec to hour
			String temp1 = newAftDec + "";
			temp1 = temp1.substring(1);//gets rid off 0 before the decimal point
			StringBuffer sb2 = new StringBuffer();
			sb2 = sb1.append(temp1);
			toString = sb2.toString();
			double toFormat = Double.parseDouble(toString);
			double real = 0.0;
			if(diff=true){
				toFormat = toFormat + timeDiff;
			}
			String hourString = hour + "";
			String end = "";
			if(hour.length()==1){
				DecimalFormat df = new DecimalFormat("#.##");
				end = df.format(toFormat);
			}
			else if(hour.length()==2){
				DecimalFormat df = new DecimalFormat("##.##");
				end = df.format(toFormat);
			}
			//insert : instead of .
			end = end.replace('.', ':');

			realTime = end;

		}//close if
		//else if(first==h2 && !(h1==12) && !(h2==12)){//if second traveler leaves first
		else if(first==h2){
			newDist=V2*timeDiff;
			x = initialDist-newDist;
			decTime=x/speeds;
			//store first digit of number
			String toString = "" + decTime;
			StringBuffer sb = new StringBuffer(toString);
			String hour = "";
			String aftDec = "";
			for(int i = 0; i<sb.length(); i++){
				if(sb.charAt(i)=='.'){
					hour = sb.substring(0, i);
					aftDec = sb.substring(i);
				}
			}//close for loop
			//turnaftDec into minutes
			//aftDec = aftDec + "";
			double temp = Double.parseDouble(aftDec);
			double newAftDec = temp*60/100;
			StringBuffer sb1 = new StringBuffer(hour);
			//connect new aft dec to hour
			String temp1 = newAftDec + "";
			temp1 = temp1.substring(1);//gets rid off 0 before the decimal point
			StringBuffer sb2 = new StringBuffer();
			sb2 = sb1.append(temp1);
			toString = sb2.toString();
			double toFormat = Double.parseDouble(toString);
			String hourString = hour + "";
			String end = "";
			if(hour.length()==1){
				DecimalFormat df = new DecimalFormat("#.00");
				end = df.format(toFormat);
			}
			else if(hour.length()==2){
				DecimalFormat df = new DecimalFormat("##.00");
				end = df.format(toFormat);
			}
			//insert : instead of .
			end = end.replace('.', ':');

			realTime = end;

		}//close else if h2=first
		return realTime;
	}//close theWork
}//close class
