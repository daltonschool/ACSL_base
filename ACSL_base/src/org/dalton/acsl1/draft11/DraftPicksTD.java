package org.dalton.acsl1.draft11;

import java.util.*;
public class DraftPicksTD {

	/**
	 * Tom Delaney
	 * 
	 *  ACSL 2011-2012 Program 1
    	Copyright (C) 2011  Tom Delaney

    	This program is free software: you can redistribute it and/or modify
    	it under the terms of the GNU General Public License as published by
    	the Free Software Foundation, either version 3 of the License, or
    	(at your option) any later version.

    	This program is distributed in the hope that it will be useful,
    	but WITHOUT ANY WARRANTY; without even the implied warranty of
    	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    	GNU General Public License for more details.

    	You should have received a copy of the GNU General Public License
    	along with this program.  If not, see <http://www.gnu.org/licenses/>.
	 * 
	 * The Dalton School: 9075
	 */
	
	public static void main(String[] args) {
	
		double[][] inputs = new double[3][10];
		double[] expected_value_16s;
		double[] expected_value_18s;
		double[] salaries_game_16s;
		double[] salaries_game_18s;
		double[] yearly_salaries;
		inputs = readLines();
		expected_value_16s = findExpectedValue(inputs, true);
		expected_value_18s = findExpectedValue(inputs, false);
		salaries_game_16s = findSalariesPerGame(inputs, true);
		salaries_game_18s = findSalariesPerGame(inputs, false);
		yearly_salaries = yearlySalaries(inputs);
		System.out.println(rangeSPG16(salaries_game_16s));
		System.out.println(midRange18(salaries_game_18s));
		System.out.println(highestExpected16(expected_value_16s));
		System.out.println(averageExpected18(expected_value_18s));
		System.out.println(medianYearly(yearly_salaries));
		
	}
	
	private static int medianYearly(double[] input){
		double returns=0;
		int integer=0;
		Arrays.sort(input);
		returns = (1000000*(input[4]+input[5])/2);
		integer=(int)Math.round(returns);
		return integer;
	}

	private static int averageExpected18(double[] input){
		double total=0;
		double average=0;
		int integer=0;
		for (int i=0;i<input.length;i++) total+=input[i];
		average=total/10;
		average*=1000000;
		integer=(int)Math.round(average);
		return integer;
	}
	private static String highestExpected16(double[] input){
		double highest=0;
		int integer=0;
		int number=0;
		
		for (int i=0;i<input.length;i++){
			if(i>0){
				if(input[i] > highest){
					highest=input[i];
					number=i;
				}
			}
			else highest=input[i];
		}
		highest*=1000000;
		integer=(int)Math.round(highest);
		number+=1;
		return integer + " by #" + number;
	}
	
	private static int midRange18(double[] input){
		double returns=0;
		int integer=0;
		Arrays.sort(input);
		returns = (1000000*(input[9]+input[0]))/2;
		integer = (int)Math.round(returns);
		return integer;
	}
	private static int rangeSPG16(double[] input){
		double returns = 0;
		int integer = 0;
		Arrays.sort(input);
		returns = 1000000*(input[9]-input[0]);
		integer = (int)Math.round(returns);
		return integer;
	}
	
	private static double[] findSalariesPerGame(double[][] input, boolean num){
		int numgames=0;
		if(num) numgames=16;
		else numgames=18;
		double[] returns = new double[10];
		for (int i=0;i<10;i++) returns[i] = ((input[1][i])/input[0][i])/numgames;
		return returns;
	}

	private static double[] findExpectedValue(double[][] input, boolean numgames){
		double[] toreturn = new double[10];
		double injchance=0;
		if(numgames) injchance=.03;
		else injchance=.03375;
		for(int i=0;i<10;i++) toreturn[i] = (((1-(input[0][i])*injchance)*input[1][i]) + ((input[0][i])*(injchance)*(input[2][i])));
		return toreturn;
	}
	
	private static double[] yearlySalaries(double[][] input){
		double[] returns = new double[10];
		for (int i=0;i<10;i++) returns[i] = ((input[1][i])/input[0][i]);
		return returns;
	}

	private static double[][] readLines(){
		double[][] returns = new double[3][10];
		Scanner input = new Scanner(System.in);
		String line;
		String[] inputdata = new String[3];
		for(int i=0;i<10;i++){
			line = input.nextLine();
			inputdata = line.split(" , ");
			returns[0][i] = Double.parseDouble(inputdata[0]);
			returns[1][i] = Double.parseDouble(inputdata[1]);
			returns[2][i] = Double.parseDouble(inputdata[2]);
		}
		return returns;
	}

}
