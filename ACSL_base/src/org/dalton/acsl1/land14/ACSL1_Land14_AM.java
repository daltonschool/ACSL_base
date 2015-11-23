package org.dalton.acsl1.land14;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Name: Andrew Milich 
 * School: The Dalton School 
 * Code: 3055 
 */
public class ACSL1_Land14_AM {
	//A, C, 1, PM, 2, PM, 50, 60

	//A: 0, 0 
	//B: 450, 0
	//C: 590, 0
	//D: 715, 0
	//E: 1080, 0
	//F: 1330, 0 
	//G: 1490, 0
	//H: 1870, 0
	//J: 2105, 0
	//K: 2425, 0 

	static HashMap<String, Integer>  locs = new HashMap<String, Integer>(); 

	public static void main(String[] args) throws ParseException{
		locs.put("A", 0);
		locs.put("B", 450); 
		locs.put("C", 590); 
		locs.put("D", 715); 
		locs.put("E", 1080); 
		locs.put("F", 1330); 
		locs.put("G", 1490); 
		locs.put("H", 1870); 
		locs.put("J", 2105); 
		locs.put("K", 2425); 

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); 
		String town_0 = ""; 
		String town_1 = ""; 
		int time_0 = 0; 
		int time_1 = 0; 
		double speed_0 = 0; 
		double speed_1 = 0; 

		for (int ii = 0; ii < 5; ii++) {
			try{
				String raw_input = input.nextLine(); 
				String[] data = raw_input.split(", "); 
				town_0 = data[0]; 
				town_1 = data[1]; 

				time_0 = Integer.parseInt(data[2]); 
				time_1 = Integer.parseInt(data[4]); 
				String a_1 = data[3]; 
				String a_2 = data[5]; 

				SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
				SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");

				Date date_1 = parseFormat.parse(time_0 + ":00 " + a_1);
				Date date_2 = parseFormat.parse(time_1 + ":00 " + a_2);
				/*System.out.println(displayFormat.format(date_1).toString());
				System.out.println(displayFormat.format(date_2).toString());*/

				time_0 = Integer.parseInt(displayFormat.format(date_1).toString().substring(0, 2)); 
				time_1 = Integer.parseInt(displayFormat.format(date_2).toString().substring(0, 2));

				speed_0 = Double.parseDouble(data[6]); 
				speed_1 = Double.parseDouble(data[7]); 

				double d = getDist(town_0, town_1); 
				double dt = diff(time_0, time_1); 
				//System.out.println(d);
				//System.out.println("DT: " + dt);
				if(town_0.equals(town_1)){
					//TODO: keep this print for same city 
					System.out.println("0:00");
					continue; 
				}
				double trav_1 = (d - speed_1*dt)/(speed_0+speed_1); 
				//System.out.println(trav_1);
				if(trav_1 < 0){
					trav_1 = 0; 
				}

				if(dt < 0 && speed_0*Math.abs(dt) >= d){
					//System.out.println("Gets there before time difference");
					trav_1 = d/speed_0; 
				}

				double dec = (trav_1 - Math.floor(trav_1)); 
				double hours = trav_1 - dec; 
				double minutes = Math.round(dec*60); 
				//System.out.println(minutes);
				//System.out.println(hours);
				DecimalFormat df = new DecimalFormat("00");
				//TODO: keep this print 
				System.out.println(df.format(hours)+":"+df.format(minutes));
			}
			catch(Exception e){
				System.out.println("Error: please insert next piece of data.");
				//e.printStackTrace(); //GET RID OF THIS
			}
		}
	}

	public static double diff(double t_0, double t_1){
		double difference = t_0 - t_1; //difference 
		//System.out.println("T0: " + t_0 + " T1: " + t_1);
		if(Math.abs(t_0 - t_1) > 12){
			//in this situation, the bigger time left first (first day) 
			if(t_0 > t_1){
				//person 1 left first 
				t_0 -= 24; 
				difference = t_0 - t_1; 
			}
			else {
				//person 2 left first 
				t_1 -= 24; 
				difference = t_0 - t_1; 
			}
		}
		//System.out.println("Diff: " + difference);
		return difference; 
	}

	public static double getDist(String c1, String c2){
		double dist = 0; 
		dist = Math.abs(locs.get(c2) - locs.get(c1)); 
		//System.out.println("The distance is " + dist);
		return (dist); 
	}
}
