/*
 *  Tom Delaney
 *	ACSL Program 1
 *	12/15/2010
 *	Dalton School
 *	School Code: 9075
 *
 */
package org.dalton.acsl1.prints10;
import java.util.*;
public class PGRatio1 {

	static int[] oddpair = new int[17];
	static int[] evenpairs = new int[17];

	public static void initializeArrays(){
		int j=9;
		int c = 10;
		for(int i=1; i<=16; i = 2*i) {
			oddpair[i] = j;
			evenpairs[i] = c;
			c -=2;
			j -=2;
		}
	}//end initializeArrays

	public static String fingerprints(String input){
		int even = Integer.parseInt((input.split(", ")[0])) - 1;
		int odd = Integer.parseInt((input.split(", ")[1])) - 1;
		String[] temp = new String[20];
		int temp2counter = 0;
		String result = "";
		temp = (findFingers(odd, result, 0, oddpair) + findFingers(even, result, 0, evenpairs)).split(","); 
		int[] temp2 = new int[temp.length];

		for(int i=0;i<temp.length;i++){
			if(temp[i].length() > 0){
				temp2[temp2counter] = Integer.parseInt(temp[i]);
				temp2counter++;
			}
		}
		Arrays.sort(temp2);
		for(int i=0; i<temp2.length; i++){
			if(temp2[i] != 0)
				if(i != temp2.length - 1) result = result + temp2[i] + ", ";
				else result = result + temp2[i];
		}
		if((findFingers(odd, result, 0, oddpair) + findFingers(even, result, 0, evenpairs)).equals("")) return "None";
		return result;
	}//end fingerprints

	public static String findFingers(int total, String result, double powof2, int[] oddpairs){
		if(total == 0) return "";
		if(total/2 < 1){
			result = result + oddpairs[(int)Math.pow(2, powof2)] + ",";
			return result;
		}
		if(total%2 == 1) 
			result = result + oddpairs[(int)Math.pow(2, powof2)] + ",";
		return findFingers(total/2, result, powof2 + 1, oddpairs);
	}//end findfingers

	public static void main(String[] args){
		initializeArrays();
		String input;
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 5; i++){
			input = in.nextLine();
			System.out.println(fingerprints(input));
		}
	}//end main
}//end class
