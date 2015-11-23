package org.dalton.acsl1.land14;

import java.text.DecimalFormat;
import java.util.Scanner;


public class ACSL1_Land14_DA
{
	/*
	 * Name: Dillon Azzam
	 * School: The Dalton School
	 * Code: 3305
	 * 
	 */
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<5; i++)
		{
			String inputStringRaw=scan.nextLine();
			String[] inputStringArray = inputStringRaw.split(", ");

			//System.out.println(Arrays.toString(inputStringArray));

			String travOneStart = inputStringArray[0];
			int travOneSpeed = Integer.parseInt(inputStringArray[6]);
			int travOneDeparture = Integer.parseInt(inputStringArray[2]);
			travOneDeparture=get12HourTime(travOneDeparture, inputStringArray[3]);

			String travTwoStart = inputStringArray[1];
			int travTwoSpeed = Integer.parseInt(inputStringArray[7]);
			int travTwoDeparture = Integer.parseInt(inputStringArray[4]);
			travTwoDeparture=get12HourTime(travTwoDeparture, inputStringArray[5]);

			int distanceToTravel=DistanceBetweenCities(travOneStart, travTwoStart);

			/*
			System.out.println("Trav 1 Start: "+travOneStart);
			System.out.println("Trav 1 Speed: "+travOneSpeed);
			System.out.println("Trav 1 Departure Time: "+travOneDeparture);
			System.out.println("Trav 2 Start: "+travTwoStart);
			System.out.println("Trav 2 Speed: "+travTwoSpeed);
			System.out.println("Trav 2 Departure Time: "+travTwoDeparture);
			System.out.println("Travel Distance: "+distanceToTravel);
			*/
			
			if(distanceToTravel==0)
			{
				System.out.println("00:00");
			}
			else
			{
				double travOneTime = 0.0;

				double timeDifference = getTimeDifference(travOneDeparture, travTwoDeparture);
				//System.out.println("Time Difference: "+timeDifference);
				travOneTime = (distanceToTravel+(timeDifference*travTwoSpeed))/(travOneSpeed+travTwoSpeed);

				long travOneTimeHoursDouble;
				double travOneTimeMinutesDouble;

				// Get user input
				travOneTimeHoursDouble = (long) travOneTime;
				travOneTimeMinutesDouble = travOneTime - travOneTimeHoursDouble;
				travOneTimeMinutesDouble=travOneTimeMinutesDouble*60;
				//System.out.println("Integer part = " + travOneTimeHoursDouble);
				//System.out.println("Fractional part = " + travOneTimeMinutesDouble);

				DecimalFormat df = new DecimalFormat("00");
				System.out.println(df.format(travOneTimeHoursDouble)+":"+df.format(travOneTimeMinutesDouble));
				//System.out.println(travOneTime);
			}
		}


		// TODO Auto-generated method stub

	}

	public static int get12HourTime(int TwelveHourTime, String AmPm)
	{
		if(AmPm.equalsIgnoreCase("PM"))
		{
			if(TwelveHourTime==12)
			{
				return 12;
			}
			TwelveHourTime+=12;
		}
		else
		{
			if(TwelveHourTime==12)
				return 0;
		}
		return TwelveHourTime;
	}

	public static double getTimeDifference(int travOneDeparture, int travTwoDeparture)
	{
		double timeDifference = 0;
		timeDifference = travTwoDeparture - travOneDeparture;
		if(timeDifference>12)
		{
			timeDifference = -(24-timeDifference);
		}
		if(timeDifference<-12)
		{
			timeDifference=24+timeDifference;
		}
		return timeDifference;
	}

	public static int DistanceBetweenCities(String cityOne, String cityTwo)
	{
		String startCity = null;
		String endCity = null;

		if(cityOne.equals(cityTwo))
		{
			return 0;
		}

		if(cityOne.toCharArray()[0]<cityTwo.toCharArray()[0])
		{
			startCity=cityOne;
			endCity=cityTwo;
		}
		else if(cityTwo.toCharArray()[0]<cityOne.toCharArray()[0])
		{
			startCity=cityTwo;
			endCity=cityOne;
		}

		int distance = 0;
		while(!startCity.equals(endCity))
		{
			switch(startCity)
			{
			case "A":
				startCity="B";
				distance+=450;
				break;
			case "B":
				startCity="C";
				distance+=140;
				break;
			case "C":
				startCity="D";
				distance+=125;
				break;
			case "D":
				startCity="E";
				distance+=365;
				break;
			case "E":
				startCity="F";
				distance+=250;
				break;
			case "F":
				startCity="G";
				distance+=160;
				break;
			case "G":
				startCity="H";
				distance+=380;
				break;
			case "H":
				startCity="J";
				distance+=235;
				break;
			case "J":
				startCity="K";
				distance+=320;
				break;
			}
		}
		return distance;
	}
}
