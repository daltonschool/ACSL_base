package org.dalton.acsl1.draft11;
/*Darshan Desai
// ACSL 1
9075 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DraftPicksDD {
	static ArrayList<Double> col1 = new ArrayList<Double>(), col2 = new ArrayList<Double>(), col3 = new ArrayList<Double>(), dup1 = new ArrayList<Double>();
	static ArrayList<Double> e16 =  new ArrayList<Double>(),  e18= new ArrayList<Double>();

	public static void main(String[]args){
		for (int a=0; a<10; a++){
			String inputArray[]= new Scanner(System.in).nextLine().split(", ");
			col1.add(Double.parseDouble(inputArray[0]));
			col2.add(Double.parseDouble(inputArray[1]));
			col3.add(Double.parseDouble(inputArray[2]));
			dup1.add(col2.get(a)/col1.get(a));
		}
		Collections.sort(dup1);

		double avgE18 = 0.0;
		int pickNum=0;

		for (int c=0; c<col1.size(); c++){
			e18.add(eCalc(col1.get(c), (.03375), col2.get(c), col3.get(c)));
			double e16Value=eCalc(col1.get(c), (.03), col2.get(c), col3.get(c));
			avgE18+= e18.get(c);
			
			Collections.sort(e16);
			
			if (c==0)
				e16.add(e16Value);

			if (e16Value>e16.get(0)) {
				e16.remove(0);
				e16.add(e16Value);
				pickNum= c;
			}		
		}	
		System.out.println(syso((  ((dup1.get(dup1.size()-1))/16)    -  ((dup1.get(0)/16)))*1000000));
		System.out.println(syso((  ((dup1.get(dup1.size()-1))/18) +  ((dup1.get(0))/18))/2 *1000000));
		System.out.println(syso(((( (e16.get(0)))*1000000))) + " by #" + (pickNum+1));
		System.out.println(syso(avgE18*100000));
		System.out.println(syso((( dup1.get(4) + dup1.get(5) ) /2)*1000000));
	}
	public static double eCalc (double contractLength, double injury, double value, double guarantee){
		return ((1-(contractLength*injury))*value + (contractLength*injury*guarantee));
	}
	public static String outputCommas(String output){  
		if(output.length() < 4) return output;   
		return outputCommas(output.substring(0,(output.length() - 3))) + "," + output.substring(output.length() - 3, output.length());  
	}  
	public static String syso (double o){
		return (outputCommas(Integer.toString((int) Math.round(o))));
	}
}