package org.dalton.acsl1.scrabble13;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Abby Kasdin
 * The Dalton School
 * 3055
 */

public class ACSL1_Scrabble13_AK {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String [] user_input = scan.nextLine().split(", ");
		int count = 0;
	
	while(count < 5){	
		int total = 0;

		int op1 = 0;
		int op2 = 0;
		int op3 = 0;
		
		int l1 = 0;
		int l2 = 0;
		int l3 = 0;
		int l4= 0;
		

		//set initial values for letters
		l1 = initial(user_input[0], l1);
		l2 = initial(user_input[1], l2);
		l3 = initial(user_input[2], l2);
		l4 = initial(user_input[3], l4);

		String [] locations = scan.nextLine().split(", ");
		op1 = calculate(locations[0], locations[1], l1, l2, l3, l4, total);
		op2 = calculate(locations[2], locations[3], l1, l2, l3, l4, total);
		op3 = calculate(locations[4], locations[5], l1, l2, l3, l4, total);
		
		int [] options = {op1, op2, op3};
	
		Arrays.sort(options);
		System.out.println(options[2]);
		count ++;
	}	

	}//main

	public static int initial(String input, int l){
		if(input.equals("A") || input.equals("E")){
			l = 1;
		}
		if(input.equals("D") || input.equals("R")){
			l = 2;
		}
		if(input.equals("B") || input.equals("M")){
			l = 3;
		}
		if(input.equals("V") || input.equals("Y")){
			l = 4;
		}
		if(input.equals("J") || input.equals("X")){
			l = 8;
		}
		return l;

	}

	public static int calculate(String locations, String direction, int l1, int l2, int l3, int l4, int total) {
		int [] spots = new int[4];
		int loc = Integer.parseInt(locations);
		//set locations for letters
		if(direction.equals("H")){
			spots[0] = loc; 
			spots[1] = loc+1;
			spots[2] = loc+2;
			spots[3] = loc+3;
		}
		if(direction.equals("V")){
			spots[0] = loc; 
			spots[1] = loc+10;
			spots[2] = loc+20;
			spots[3] = loc+30;
		}
		l1 = l1*change(spots[0]);
		l2 = l2*change(spots[1]);
		l3 = l3*change(spots[2]);
		l4 = l4*change(spots[3]);
		total = l1 + l2 + l3 + l4;
		total = total*word(spots[3]);
		total = total*word(spots[2]);
		total = total*word(spots[1]);
		total = total*word(spots[0]);
		
		return total;
	}
	public static int change(int spot){
		int re = 1;
		if(spot == 3 || spot == 9 || spot == 15 || spot == 21 || spot == 27 || spot == 33 || spot == 39)
		{
			re = 2;
		}
		if(spot == 5 || spot == 10 || spot == 20 || spot == 25 || spot == 30 || spot == 35 || spot == 40)
		{
			re = 3;
		}
		return re;	
			
	}
	public static int word(int spot){
		int re = 1;
		if(spot == 7 || spot == 14 || spot == 28)
		{
			re = 2;
		}
		if(spot == 8 || spot == 16 || spot == 32 || spot == 24)
		{
			re = 3;
		}
		
		
		return re;
		
	}
	
}//class

