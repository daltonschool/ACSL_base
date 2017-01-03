package org.dalton.acsl2.string15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Float;
/*Seneca Meeks
 * 
 */

public class ACSL2_STRING15_SM {

	public static StringBuilder rounding(StringBuilder s, float val, int dec, int req_length) //Rounding method
	{
		double div = (Math.pow(10, (double) dec)); 
		float round = Math.round(val * (Math.pow(10, (double) dec)));
		double fin_round = (round)/(div);  
		String fin_num = Double.toString(fin_round);
		s.append(fin_num); 
		viable(s, req_length);
		return s;
	}  
	
	public static StringBuilder viable(StringBuilder a, int req_length)
	{
		char[] space = new char[req_length - 1];
		Arrays.fill(space, '#');
		
		String r = a.toString();
		char[] nums = r.toCharArray(); 
		
		
		if((req_length-1) == a.length()){
			System.out.println(a);
			return a; 
		}
		
		else if((req_length-1) > a.length()){
			for (int i = space.length; i > 0; i--) {
				for (int j = nums.length; j > 0; j--) {
					space[i] = nums[j];  
				}
			}
			
			String output = new String(space);
			a.append(output);
			System.out.println(a);
			return a;
		}
		
		else{
			String output1 = new String(space);
			a.append(output1);
			System.out.println(a);
			return a; 
		}
		

	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		while(scan.hasNext()) { 	
			//Declarations
			String[] input = scan.nextLine().split(", "); //stores input
			String num = input[0]; 
			String[] num1 = num.split("+\\-"); 
			StringBuilder sign = new StringBuilder(""); 
			sign.append(num1[0]);
			Float val = Float.parseFloat(num1[1]);
			int req_length = Integer.parseInt(input[1]); 
			int dec_num = Integer.parseInt(input[2]);
			
			rounding(sign, val, dec_num, req_length);


		}

	}
}
