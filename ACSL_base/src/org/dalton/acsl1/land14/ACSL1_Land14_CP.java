package org.dalton.acsl1.land14;
/**
 * Cortland Perry
 * The Dalton School
 */
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.math.RoundingMode;

public class ACSL1_Land14_CP {

	public static void main(String[] args) {
		
		int[] distancefroma = new int[]{0,450,590,715,1080,1330, 1490,1870,2105,2425};
		
		
		
		for(int i = 0; i < 5; i++){
		DecimalFormat df = new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.DOWN);
		
		
		Scanner input = new Scanner(System.in);
		int firsttraveler = 0;
		int secondtraveler = 0;
		int time1 = 0;
		int time2 = 0;
		double speed1 = 0;
		double speed2 = 0;
		String[] line = input.nextLine().split(", ");
		//for(int k = 0; k < 8; k++){
		//	System.out.println(line[k]);
		//}
		for(int j = 0; j < 2; j++){
			if(line[j].toCharArray()[0] == 'B'){
				if(j == 0){
				firsttraveler = 1;
				}
				if(j == 1){
				secondtraveler = 1;
				}
			}
			else if(line[j].toCharArray()[0] == ('C')){
				if(j == 0){
				firsttraveler = 2;
				}
				if(j == 1){
				secondtraveler = 2;
				}
			}
			else if(line[j].toCharArray()[0] == 'D'){
				if(j == 0){
				firsttraveler = 3;
				}
				if(j == 1){
				secondtraveler = 3;
				}
			}
			else if(line[j].toCharArray()[0] == 'E'){
				if(j == 0){
				firsttraveler = 4;
				}
				if(j == 1){
				secondtraveler = 4;
				}
			}
			else if(line[j].toCharArray()[0] == 'F'){
				if(j == 0){
				firsttraveler = 5;
				}
				if(j == 1){
				secondtraveler = 5;
				}
			}
			else if(line[j].toCharArray()[0] == 'G'){
				if(j == 0){
				firsttraveler = 6;
				}
				if(j == 1){
				secondtraveler = 6;
				}
			}
			else if(line[j].toCharArray()[0] == 'H'){
				if(j == 0){
				firsttraveler = 7;
				}
				if(j == 1){
				secondtraveler = 7;
				}
			}
			else if(line[j].toCharArray()[0] == 'J'){
				if(j == 0){
				firsttraveler = 8;
				}
				if(j == 1){
				secondtraveler = 8;
				}
			}
			else if(line[j].toCharArray()[0] == 'K'){
				if(j == 0){
				firsttraveler = 9;
				}
				else if(j == 1){
				secondtraveler = 9;
				}
			}
		}
		
				
		
		
		
		if(line[3].equals("AM")){//MAKE 12 AM and PM correct!
			if(Integer.parseInt(line[2]) == 12){
				time1 = 0;
			}
			else{
			time1 = Integer.parseInt(line[2]);
			}
		}
		else{
			if(Integer.parseInt(line[2]) == 12){
				time1 = 12;
			}
			else{
			time1 = Integer.parseInt(line[2]) + 12;
			}
		}
		
		
		
		if(line[5].equals("AM")){
			if(Integer.parseInt(line[4]) == 12){
				time2 = 0;
			}
			else{
			time2 = Integer.parseInt(line[4]);
			}
		}
		else{
			if(Integer.parseInt(line[4]) == 12){
				time2 = 12;
			}
			else{
			time2 = Integer.parseInt(line[4]) + 12;
			}
		}
		speed1 = Double.parseDouble(line[6]);
		speed2 = Double.parseDouble(line[7]);
		//END OF READING DATA
		
		
		
		double distance = Math.abs(distancefroma[firsttraveler] - distancefroma[secondtraveler]);	//distance between the two starting spots
		boolean didastart = false;
		boolean didbstart = false;
		double[] timefirst = new double[2];
		int[] timesecond = new int[2];

		if(distance == 0){
			
		}
		else{
		if(time1 < time2){
			if((24-time2)+ time1 <= Math.abs(time1-time2)){	//if the time is overlapping from pm into am
				timesecond[0] = timesecond[0] + Math.abs(24-time2+time1)*60;
				distance = distance - speed2*Math.abs(24-time2+time1);
				didbstart = true;

			}
			else{
			
			
			timefirst[0] = timefirst[0] + Math.abs(time1-time2)*60;
			distance = 	distance - speed1*Math.abs(time1-time2);
			didastart = true;
			}
		}
		
		else if(time1 > time2){
			if(24-time1 + time2 <= Math.abs(time1-time2)){	//if the time is overlapping from pm into am
			timefirst[0] = timefirst[0] + Math.abs(24-time1 + time2)*60;
			distance = distance - (speed1*Math.abs(24-time1 + time2));	
			didastart = true;
			}
			else{
			timesecond[0] = timesecond[0] + Math.abs(time2-time1)*60;
			distance = distance - (speed2*Math.abs(time2-time1));
			didbstart = true;
			}
		}
		}
		boolean jeff = false;
		if(distance <= 0){
			jeff = true;
			if(didastart == true){
				timefirst[0] = (Math.abs(distancefroma[firsttraveler] - distancefroma[secondtraveler])/speed1)*60;
			}
			else if(didbstart == true){
				timefirst[0] = 0;

			}
			distance = 0;

		}
		else{
		double rate = speed2+speed1;	//the total rate that they are going together
		timefirst[0] = timefirst[0] + (distance/rate)*60;	//time in minutes
		
		}
		
		String hours = df.format(timefirst[0]/60);	//finding the hours (while rounding down)
		df.setRoundingMode(RoundingMode.HALF_UP);	//rounding
		String minutes = df.format(timefirst[0]%60);	//finding the minutes
		
		String zero = "0";	//formatting
		if(minutes.length() == 1){
			zero = zero + minutes;
			minutes = zero;
		}
		
		if(jeff == true && didastart == false){
			System.out.println("0:00");
		}
		else{
			System.out.println(hours + ":" + minutes);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		}
		

	}

}
