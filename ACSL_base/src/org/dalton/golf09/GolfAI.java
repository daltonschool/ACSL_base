package org.dalton.golf09;

/*Alexander Iriza
 ACSL 09 Golf
 School: 9010
 */

import java.util.*;

public class GolfAI{

    static int[] players = {0,1,2,3};

    public static void main(String[] args){
	int par = 36;
	int[] straightScores = new int[36];
	String[] indivScores;
	Scanner in = new Scanner(System.in);
	int[][] scores = new int[4][9];
	int[] totalScores = {0,0,0,0};
	int aDiff, bDiff, numHolesWon, a, b, c, d;
	String input = "y", output4 = "", aString = "", bString = "";
	int[] sortedScores;
	String[] sortedPlayerLetters = new String[4];
	double median;
	boolean firstTime = true;
	
	while(!input.equalsIgnoreCase("n")){
	    if(!firstTime){
		System.out.println("Would you like to enter another set of data? (y/n)");
		input = in.nextLine();
	    }
	    
	    if(input.equalsIgnoreCase("y")){
		firstTime = false;
		aDiff = 0;
		bDiff = 0;
		numHolesWon = 0;
		median = 0;
		a = 0;
		b = 0;
		c = 0;
		d = 0;
		output4 = "";
		for(int i = 0; i < 4; i++){
		    totalScores[i] = 0;
		    players[i] = i;
		    sortedPlayerLetters[i] = "";
		}
		
		
		
		System.out.println("Please enter the nine lines of data, with values delimited by commas and no spaces");
		
		for(int i = 0; i < 9; i++){
		    input = in.nextLine();
		    indivScores=input.split(",");
		    for(int j = 0; j < 4; j++){
			straightScores[4*i+j] = Integer.parseInt(indivScores[j]);
			scores[j][i] = Integer.parseInt(indivScores[j]);
		    }
		}
		
		
		for(int i = 0; i < 9; i++){
		    totalScores[0] += scores[0][i];
		    totalScores[1] += scores[1][i];
		    totalScores[2] += scores[2][i];
		    totalScores[3] += scores[3][i];
		}
		
		aDiff = totalScores[0] - par;
		bDiff = totalScores[1] - par;
		
		if(aDiff == 0){
		    aString = "par";
		}
		if(bDiff == 0){
		    bString = "par";
		}
		if(aDiff > 0){
		    aString = aDiff + " over par";
		}
		if(bDiff > 0){
		    bString = bDiff + " over par";
		}
		if(aDiff < 0){
		    aString = Math.abs(aDiff) + " under par";
		}
		if(bDiff < 0){
		    bString = Math.abs(bDiff) + " under par";
		}
		System.out.println("************");
		System.out.println(bString);
		System.out.println(aString);
		
		sortedScores = sortTotalScores(totalScores);
		
		for(int i = 0; i < 9; i++){
		    a = scores[players[0]][i];
		    b = scores[players[1]][i];
		    c = scores[players[2]][i];
		    d = scores[players[3]][i];
		    
		    if((a < b)&&(a < c)&&(a < d)){
			numHolesWon++;
		    }
		    
		}
		
		System.out.println(numHolesWon);
		
		
		for(int i = 0; i < 4; i++){
		    sortedPlayerLetters[i] = sw(players[i]);
		}
		
		
		for(int i = 0; i < 4; i++){
		    if(i < 3){
			output4 = output4 + sortedPlayerLetters[i] + ", ";
		    }
		    if(i == 3){
			output4 = output4 + sortedPlayerLetters[i];
		    }
		} 
		
		System.out.println(output4);
		
		straightScores = sortScores(straightScores);
		
		median = (straightScores[17] + straightScores[18])/2.0;
		if(median == (int)median){
		    System.out.println((int)median);
		}
		else{
		    System.out.println(median);
		}
		System.out.println("************");
	    }
	}
	System.out.println("Bye!");
    }
		
    public static String sw(int input){
	String output = "";
	if(input == 0){
	    output = "A";
	}
	if(input == 1){
	    output = "B";
	}
	if(input == 2){
	    output = "C";
	}
	if(input == 3){
	    output = "D";
	}
	return output;
    }

    public static int[] sortScores(int[] input){
	int numFlips = 1;
	int temp;
	while(numFlips > 0){
	    numFlips = 0;
	    for(int i = 0; i < input.length - 1; i++){
		if(input[i] > input[i+1]){
		    numFlips++;
		    temp = input[i];
		    input[i] = input[i+1];
		    input[i+1] = temp;
		}
	    }
	}
	return input;
    }

    public static int[] sortTotalScores(int[] input){
	int[] output = new int[input.length];
	for(int i = 0; i < input.length; i++){
	    output[i] = input[i];
	}
	int numFlips = 1;
	int temp;
	while(numFlips > 0){
	    numFlips = 0;
	    for(int i = 0; i < input.length - 1; i++){
		if(output[i] > output[i+1]){
		    numFlips++;
		    temp = output[i];
		    output[i] = output[i+1];
		    output [i+1] = temp;
		    temp = players[i];
		    players[i] = players[i+1];
		    players[i+1] = temp;
		}
	    }
	}
	return output;
    }
}