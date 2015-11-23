package org.dalton.acsl1.land14;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * 
 * ACSL Contest 1<br>
 * <b>"Navigating ASCL Land"</b><br>
 * 12/13/14, Cal Lavicka, Dalton School
 * 
 * @author Cal Lavicka
 *
 */
public class ACSL1_Land14_CL {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		for (;;) {
			String input = scan.nextLine();

			String[] inputs = input.split(", ");

			int distance = distBetCities(inputs[0].charAt(0),
					inputs[1].charAt(0));

			int time1 = getTime(inputs[2], inputs[3]);
			int time2 = getTime(inputs[4], inputs[5]);

			int firstStart = getFirstStart(time1, time2);

			double rate1 = Double.parseDouble(inputs[6]);
			double rate2 = Double.parseDouble(inputs[7]);

			if (firstStart == 0) {
				int timeDif = time2 - time1;
				if(timeDif < 0) {
					timeDif += 24;
				}

				double headStart = rate1 * timeDif;
				if (headStart > distance) {
					double timeDouble = (double) distance / rate1;

					printTime(timeDouble);
					continue;
				}

				distance -= headStart;

				double combRate = rate1 + rate2;
				double timeDouble = (double) distance / combRate;

				printTime(timeDouble + timeDif);
				continue;
			} else {
				int timeDif = time1 - time2;
				if(timeDif < 0) {
					timeDif += 24;
				}

				double headStart = rate2 * timeDif;
				
				if (headStart > distance) {
					printTime(0);
					continue;
				}

				distance -= headStart;

				double combRate = rate1 + rate2;
				double timeDouble = (double) distance / combRate;

				printTime(timeDouble);
				continue;
			}
		}
	}

	public static int distBetCities(char city1, char city2) {
		return Math.abs(getLoc(city1) - getLoc(city2));
	}

	public static int getLoc(char city) {
		switch (city) {
		case 'A':
			return 0;
		case 'B':
			return 450;
		case 'C':
			return 590;
		case 'D':
			return 715;
		case 'E':
			return 1080;
		case 'F':
			return 1330;
		case 'G':
			return 1490;
		case 'H':
			return 1870;
		case 'J':
			return 2105;
		case 'K':
			return 2425;
		}

		return 0;
	}

	static int getFirstStart(int time1, int time2) {
		int dif = time1 - time2;
		if (dif < 0) {
			dif += 24;
		}
		if(dif < 12) {
			return 1;
		}

		return 0;
	}

	static int getTime(String hour, String period) {
		int time;
		if (period.equals("AM")) {
			time = Integer.parseInt(hour);
		} else {
			time = Integer.parseInt(hour) + 12;
		}

		if (time == 12) { // 12 AM
			time = 0;
		} else if (time == 24) { // 12 PM
			time = 12;
		}

		return time;
	}

	static void printTime(double time) {
		
		int minutes = (int)Math.round(time * 60);
		int hours = 0;
		while(minutes >= 60) {
			hours ++;
			minutes -= 60;
		}
		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setMinimumIntegerDigits(2);
		format.setMaximumIntegerDigits(2);
		System.out.println(hours + ":" + format.format(minutes));
	}
}
