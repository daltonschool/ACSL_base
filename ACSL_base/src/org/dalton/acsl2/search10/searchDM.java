package org.dalton.acsl2.search10;

/*
David Mandelbaum
The Dalton School
Code: 9075
*/

import java.util.Scanner;
import java.util.regex.*;

class searchDM{

    public static void main(String[] args){

	Scanner in = new Scanner(System.in);
	String orig_input = in.nextLine();
	String[] inputs = new String[10];
	inputs = orig_input.split(", ");
	
	int i = 0;
	String input = "";
	String[] results = new String[10];
	int match_count = 0;
	int k = 0;
	int j = 0;
	for(i=0;i<5;i++){
	    match_count = 0;
	    input = in.nextLine();
	    //scrub input
	    StringBuffer input_sb = new StringBuffer(input);
	    for(j=0;j<input_sb.length();j++){
		if(input_sb.charAt(j) == '*'){
		    input_sb.insert(j,".");
		    j = j+1;
		}
		if(input_sb.charAt(j) == '?'){
		    input_sb.deleteCharAt(j);
		    input_sb.insert(j,".{1}");
		    j = j+2;
		}
	    }
	    for(k=0;k<10;k++){
		if(inputs[k].matches(input_sb.toString())){
		    results[match_count] = inputs[k];
		    match_count++;
		}
	    }
	    for(k=0;k<match_count;k++){
	    System.out.println(results[k]);
	    }
	}

    }
}