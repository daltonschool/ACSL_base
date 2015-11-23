package org.dalton.acsl1.land14;
/**
 * 
 * @author Emma Weinert 

 * School: The Dalton School
 * School Code: 3305
 * 
 * ACSL Distance Land
 * 	Competition #1
 *
 */

import java.util.*;
import java.math.*;
import java.text.*;

public class ACSL1_Land14_EW {
	public static void calculate(String[] info){
		char city1;
		char city2;
		String[] time1;
		String[] time2;
		double speed1;
		double speed2;
		int distance = 0;
		int distance1 = 450; //A-B
		int distance2 = 140; //B-C
		int distance3 = 125; //C-D
		int distance4 = 365; //D-E
		int distance5 = 250; //E-F
		int distance6 = 160; //F-G
		int distance7 = 380; //G-H
		int distance8 = 235; //H-J
		int distance9 = 320; //J-K

		//get the cities out of the first array
		city1 = info[0].toString().charAt(0);
		city2 = info[1].toString().charAt(0);
		
		//calculate the distances		
		if (city1 == 'A' && city2 == 'B' || city1 == 'B' && city2 == 'A') distance = distance1;
		else if (city1 == 'A' && city2 == 'C'|| city1 == 'C' && city2 == 'A') distance = distance1 + distance2;
		else if (city1 == 'A' && city2 == 'D'|| city1 == 'D' && city2 == 'A') distance = distance1 + distance2 + distance3;
		else if (city1 == 'A' && city2 == 'E'|| city1 == 'E' && city2 == 'A') distance = distance1 + distance2 + distance3 + distance4;
		else if (city1 == 'A' && city2 == 'F'|| city1 == 'F' && city2 == 'A') distance = distance1 + distance2 + distance3 + distance4 + distance5;
		else if (city1 == 'A' && city2 == 'G'|| city1 == 'H' && city2 == 'A') distance = distance1 + distance2 + distance3 + distance4 + distance5+ distance6;
		else if (city1 == 'A' && city2 == 'H'|| city1 == 'G' && city2 == 'A') distance = distance1 + distance2 + distance3 + distance4 + distance5 + distance6 + distance7;
		else if (city1 == 'A' && city2 == 'J'|| city1 == 'J' && city2 == 'A') distance = distance1 + distance2 + distance3 + distance4 + distance5 + distance6 + distance7 + distance8;
		else if (city1 == 'A' && city2 == 'K'|| city1 == 'K' && city2 == 'A') distance = distance1 + distance2 + distance3 + distance4 + distance5 + distance6 + distance7 + distance8 + distance9;
		else if (city1 == 'B' && city2 == 'C'|| city1 == 'C' && city2 == 'B') distance = distance2;
		else if (city1 == 'B' && city2 == 'D'|| city1 == 'D' && city2 == 'B') distance = distance2 + distance3;
		else if (city1 == 'B' && city2 == 'E'|| city1 == 'E' && city2 == 'B') distance = distance2 + distance3 + distance4;
		else if (city1 == 'B' && city2 == 'F'|| city1 == 'F' && city2 == 'B') distance = distance2 + distance3 + distance4 + distance5;
		else if (city1 == 'B' && city2 == 'G'|| city1 == 'G' && city2 == 'B') distance = distance2 + distance3 + distance4 + distance5 + distance6;
		else if (city1 == 'B' && city2 == 'H'|| city1 == 'J' && city2 == 'B') distance = distance2 + distance3 + distance4 + distance5 + distance6 + distance7;
		else if (city1 == 'B' && city2 == 'J'|| city1 == 'J' && city2 == 'B') distance = distance2 + distance3 + distance4 + distance5 + distance6 + distance7 + distance8;
		else if (city1 == 'B' && city2 == 'K'|| city1 == 'K' && city2 == 'B') distance = distance2 + distance2 + distance4 + distance5 + distance6 + distance7 + distance8 + distance9;
		else if (city1 == 'C' && city2 == 'D'|| city1 == 'D' && city2 == 'C') distance = distance3;
		else if (city1 == 'C' && city2 == 'E'|| city1 == 'E' && city2 == 'C') distance = distance3 + distance4;
		else if (city1 == 'C' && city2 == 'F'|| city1 == 'F' && city2 == 'C') distance = distance3 + distance4 + distance5;
		else if (city1 == 'C' && city2 == 'G'|| city1 == 'G' && city2 == 'C') distance = distance3 + distance4 + distance5 + distance6;
		else if (city1 == 'C' && city2 == 'H'|| city1 == 'H' && city2 == 'C') distance = distance3 + distance4 + distance5 + distance6 + distance7;
		else if (city1 == 'C' && city2 == 'J'|| city1 == 'J' && city2 == 'C') distance = distance3 + distance4 + distance5 + distance6 + distance7 + distance8;
		else if (city1 == 'C' && city2 == 'K'|| city1 == 'K' && city2 == 'C') distance = distance3 + distance4 + distance5 + distance6 + distance7 + distance8 + distance9;
		else if (city1 == 'D' && city2 == 'E'|| city1 == 'E' && city2 == 'D') distance = distance4;
		else if (city1 == 'D' && city2 == 'F'|| city1 == 'F' && city2 == 'D') distance = distance4 + distance5;
		else if (city1 == 'D' && city2 == 'G'|| city1 == 'G' && city2 == 'D') distance = distance4 + distance5 + distance6;
		else if (city1 == 'D' && city2 == 'H'|| city1 == 'H' && city2 == 'D') distance = distance4 + distance5 + distance6 + distance7;
		else if (city1 == 'D' && city2 == 'J'|| city1 == 'J' && city2 == 'D') distance = distance4 + distance5 + distance6 + distance7 + distance8;
		else if (city1 == 'D' && city2 == 'K'|| city1 == 'K' && city2 == 'D') distance = distance4 + distance5 + distance6 + distance7 + distance8 + distance9;	
		else if (city1 == 'E' && city2 == 'F'|| city1 == 'F' && city2 == 'E') distance = distance5;
		else if (city1 == 'E' && city2 == 'G'|| city1 == 'G' && city2 == 'E') distance = distance5 + distance6;
		else if (city1 == 'E' && city2 == 'H'|| city1 == 'H' && city2 == 'E') distance = distance5+ distance6 + distance7;
		else if (city1 == 'E' && city2 == 'J'|| city1 == 'J' && city2 == 'E') distance = distance5 + distance6 + distance7 + distance8;
		else if (city1 == 'E' && city2 == 'K'|| city1 == 'K' && city2 == 'E') distance = distance5 + distance6 + distance7 + distance8 + distance9;		
		else if (city1 == 'F' && city2 == 'G'|| city1 == 'G' && city2 == 'F') distance = distance6;
		else if (city1 == 'F' && city2 == 'H'|| city1 == 'H' && city2 == 'F') distance = distance6 + distance7;
		else if (city1 == 'F' && city2 == 'J'|| city1 == 'J' && city2 == 'F') distance = distance6 + distance7 + distance8;
		else if (city1 == 'F' && city2 == 'K'|| city1 == 'K' && city2 == 'F') distance = distance6 + distance7 + distance8 + distance9;		
		else if (city1 == 'G' && city2 == 'H'|| city1 == 'H' && city2 == 'G') distance = distance7;
		else if (city1 == 'G' && city2 == 'J'|| city1 == 'J' && city2 == 'G') distance = distance7 + distance8;
		else if (city1 == 'G' && city2 == 'K'|| city1 == 'K' && city2 == 'G') distance = distance7 + distance8 + distance9;		
		else if (city1 == 'H' && city2 == 'J'|| city1 == 'J' && city2 == 'H') distance = distance8;
		else if (city1 == 'H' && city2 == 'K'|| city1 == 'K' && city2 == 'H') distance = distance8 + distance9;			
		else if (city1 == 'J' && city2 == 'K'|| city1 == 'K' && city2 == 'J') distance = distance9;
		
		//declarations
		time1 = Arrays.copyOfRange(info, 2, 4);
		time2 = Arrays.copyOfRange(info, 4, 6);
		int Time1;
		int Time2 ;
		int difference = 0;
		int firsttime = 0;
		Time1 = Integer.parseInt(time1[0]);
		Time2 = Integer.parseInt(time2[0]);
		speed1 = Double.parseDouble(info[6]);
		speed2 = Double.parseDouble(info[7]);
		DecimalFormat df = new DecimalFormat("##.00");
		df.setRoundingMode(RoundingMode.HALF_UP);

		if ((time1[1].equalsIgnoreCase(time2[1])) && Time1!=12 && Time2!=12){
			difference = Math.abs(Time1 - Time2);
			firsttime = Math.min(Time1, Time2);
		}//if
		else if(time1[1].equalsIgnoreCase(time2[1])){
			if(Time1==12){
				difference = (Time2+12) - Time1;
				firsttime = Time1;
			}//if
			else if(Time2==12){
				difference = (Time1+12) - Time2;
				firsttime = Time2;
			}//else if
		}//else if		
		else {
			if(time1[1].equalsIgnoreCase("AM")){
				if(Time1>Time2 && Time1!=12 && Time2!=12){
					difference = (12-Time1) + Time2;
					firsttime = Math.max(Time1, Time2);
				}//if
				else if(Time2>Time1 && Time1!=12 && Time2!=12){
					difference = (12 - Time2) + Time1;
					firsttime = Math.max(Time1, Time2);
				}//else if
				else if(Time1==12){
					difference = 12-Time2;
					firsttime = Math.min(Time1, Time2);
				}//else if
				else if(Time2==12){
					difference = 12-Time1;	
					firsttime = Math.min(Time1, Time2);
				}//else if
			}//if
			else if(time1[1].equalsIgnoreCase("PM")){
				if(Time1>Time2 && Time1!=12 && Time2!=12){
					difference = (12-Time1) + Time2;
					firsttime = Math.max(Time1, Time2);
				}//if
				else if(Time2>Time1 && Time1!=12 && Time2!=12){
					difference = (12 - Time2) + Time1;
					firsttime = Math.max(Time1, Time2);
				}//else if
				else if(Time1==12){
					difference = 12-Time2;
					firsttime = Math.min(Time1, Time2);
				}//else if
				else if(Time2==12){
					difference = 12-Time1;
					firsttime = Math.min(Time1, Time2);
				}//else if
			}//if
		}//else

		double disttot = 0;
		if(firsttime == Time1) disttot = distance - (speed1 * difference);
		else disttot = distance - (speed2 * difference);
		double speedtot = speed1+speed2;
		double timetrav = disttot/speedtot;
		String timetravtot = df.format(timetrav);
		String before = "";
		String after = "";
		for(int i=0; i<timetravtot.length(); i++){
			if(timetravtot.charAt(i) == '.'){
				before = timetravtot.substring(0, i);
				after = timetravtot.substring(i, timetravtot.length());
				break;
			}//if
		}//for	
		double percentage = Double.parseDouble(after);
		double percentage1 = percentage*60.0;
		StringBuffer sbr = new StringBuffer(String.valueOf(percentage1));
		for(int i=0; i<sbr.length(); i++){
			if(sbr.charAt(i) == '.' && i==1){
				sbr.deleteCharAt(i);
				sbr.insert(0, '0');
				break;
			}//if
			else if(sbr.charAt(i) == '.'){
				sbr.deleteCharAt(i);
				break;
			}//else if
		}//for
		sbr = sbr.insert(0, '.');
		StringBuffer sbr1 = new StringBuffer(before);
		sbr1 = sbr1.append(sbr.toString());
		String response = "";
		double answer = Double.parseDouble(sbr1.toString());
		if(firsttime == Time1){
			answer = answer+difference;
			response = df.format(answer);
		}//if

		else response = df.format(answer);
		for(int i=0; i<response.length(); i++){
			if (response.charAt(i) == '.'){
				response = response.replace(".", ":");
				break;
			}//if
		}//for	
		System.out.println(response);
	}//calculate

	public static void main (String[] args){
		//declarations
		Scanner scan = new Scanner(System.in);
		String[] info;
		for (int i=0; i<5; i++){
			info = scan.nextLine().split(", ");
			calculate(info);
		}//for
	}//main
}//ACSL1_EW