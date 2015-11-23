package org.dalton.acsl1.timesheets12;
import java.text.NumberFormat;
import java.util.Scanner;


public class ACSL1 {

	/**
	 * @param args
	 */

	/**
	 * Converts a char from there format into a number (the difference between any two is the number of half hours)
	 * @param c the char in the input
	 * @return a # such that the difference between any 2 is the number of half hours in between
	 */
	public static double hash(char c)
	{
		if(c=='1') return 1;
		else if(c=='2') return 2;
		else if(c=='3') return 3;
		else if(c=='4') return 4;
		else if(c=='5') return 5;
		else if(c=='6') return 6;
		else if(c=='7') return 7;
		else if(c=='8') return 8;
		else if(c=='9') return 9;
		else if(c=='A') return 10;
		else if(c=='B') return 11;
		else if(c=='C') return 12;
		else if(c=='D') return 13;
		else if(c=='E') return 14;
		else if(c=='F') return 15;
		else if(c=='G') return 16;
		else if(c=='H') return 17;
		else return -5083;
	}
	/**
	 * 
	 * @param loc The location the person is working at
	 * @param start The start time in their format
	 * @param end The end time in their format
	 * @param day The # day (Sunday=1, Saturday = 7)
	 * @param prevhours The # of hours worked in the week already
	 * @return An array of length 2 where the zeroth index is the amount payed for that day's work and the 1st index is the total amount of hours now worked for the week.
	 */
	public static double[] cost(double loc, char start, char end, int day, double prevhours)
	{
		double res = 0;
		double hours = (hash(end)-hash(start))/2;
		//		System.out.println("35" + start + " " + end + " " + hours + " PREV " + prevhours);
		if(100<=loc && loc<200)
		{

			for(double i = 0; i<hours; i+=.5)
			{	
				if(i+prevhours>=30) res+=2.5;
				res+=5;
			}

		}
		else if(200<=loc && loc<300)
		{
			for(double i = 0; i<hours; i+=.5)
			{
				if(i+prevhours>=40) res+=3.75;
				res+=3.75;
			}

		}
		else if(300<=loc && loc<400)
		{
			for(double i = 0; i<hours; i+=.5)
			{
				if(i+prevhours<20) res+=4.625;
				else res+=5.25;
			}
		}
		else if(400<=loc && loc<500)
		{
			for(double i = 0; i<hours; i+=.5)
			{
				if(day==1 ||day==7)res+=6.75;
				else res+=3.375;
			}
		}
		else if(500<=loc && loc<600)
		{
			for(double i = 0; i<hours; i+=.5)
			{
				if(i<6) res+=4;
				else res+=6;
			}
		}
		//		System.out.println("35" + start + " " + end + " " + hours + " PREV " + prevhours);
		double tot = hours+prevhours;
		//		System.out.println("82" + hours + " " + prevhours + " " + tot);
		return new double[] {res, tot};

	}

/**
 * Checks if the input String contains the search char
 * @param input A string to be looked through
 * @param search A char that input might contain
 * @return true if search is contained in input, otherwise false
 */
	public static boolean contains(String input, char search)
	{
		for(int i = 0; i<input.length(); i++)
		{
			if(input.charAt(i)==search) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double total = 0; //counter for the total amount of money
		double hours = 0; //counter for the total # of hours worked for the week
		double[] res; //array to get the result of the cost function
		Scanner scanner = new Scanner(System.in); 
		String[] inputs = new String[5]; //array to hold all 5 lines
		for(int i = 0; i<5; i++) inputs[i] = scanner.nextLine(); //fills inputs with the 5 lines

		for(int s = 0; s<5; s++) 
		{
			total = 0;
			hours = 0;
			String line = inputs[s];
			String[] chunks = line.split(", ");
			for(int i =1; i<chunks.length; i++)
			{

				String[] bounds = chunks[i].split(",");
				//			System.out.println("inputs " + Integer.parseInt(chunks[0])+ " " + bounds[0].charAt(0)+ " " + bounds[1].charAt(0)+ " " +i+ " " +hours +" " +  total);
				res = cost(Double.parseDouble(chunks[0]), bounds[0].charAt(0),bounds[1].charAt(0),i, hours);
				total+=res[0];
				//			System.out.println("total " + total);
				hours=res[1];
				//			System.out.println("hours" + hours);
			}
			String ans = format(total);
			System.out.println(ans);
		}
	}
	/**
	 * Formats the money into the form $19843.56
	 * @param total the total amount of money as a double
	 * @return The money formatted the way they want
	 */
	private static String format(double total) {
		String ans = String.valueOf(total);
		
		if(contains(ans, '.')) ans+="0000";
		else ans+= ".0000";
		if(Integer.parseInt(Character.toString(ans.charAt(ans.indexOf(".")+3)))>=5) total+=.01;
		ans = String.valueOf(total);
		if(contains(ans, '.')) ans+="0000";
		else ans+= ".0000";
		ans = "$" + ans.substring(0, ans.indexOf(".")+3);
		return ans;
	}
}
