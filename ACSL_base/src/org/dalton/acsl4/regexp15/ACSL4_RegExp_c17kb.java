package org.dalton.acsl4.regexp15;
import java.util.Scanner;

public class ACSL4_RegExp_c17kb {
	public static void main (String[] args){
		//taking in first input
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		if(input.contains("#, ")){
			input = input.replace("#, ", "");
		}
		else if(input.contains("#")){
			input = input.replace("#", "");
		}
		System.out.println(input);

		String [] inputarr = input.split(",[ ]*");
		String letters0 = inputarr[0];
		String letters1 = inputarr[1];
		String letters2 = inputarr[2];
		String letters3 = inputarr[3];
		String letters4 = inputarr[4];
		String letters5 = inputarr[5];
		String letters6 = inputarr[6];
		String letters7 = inputarr[7];
		String letters8 = inputarr[8];


		for(int a = 0; a < 5; a++){
			String valids = scan.nextLine();

			String tobeprinted = "";
			if(letters0.matches(valids)){
				tobeprinted = tobeprinted + letters0 + ", ";
			}
			if(letters1.matches(valids)){
				tobeprinted = tobeprinted + letters1 + ", ";
			}
			if(letters2.matches(valids)){
				tobeprinted = tobeprinted + letters2 + ", ";
			}
			if(letters3.matches(valids)){
				tobeprinted = tobeprinted + letters3 + ", ";
			}
			if(letters4.matches(valids)){
				tobeprinted = tobeprinted + letters4 + ", ";
			}
			if(letters5.matches(valids)){
				tobeprinted = tobeprinted + letters5 + ", ";
			}
			if(letters6.matches(valids)){
				tobeprinted = tobeprinted + letters6 + ", ";
			}
			if(letters7.matches(valids)){
				tobeprinted = tobeprinted + letters7 + ", ";
			}
			if(letters8.matches(valids)){
				tobeprinted = tobeprinted + letters8 + ", ";
			}

			else if(!letters0.matches(valids) && 
					!letters1.matches(valids) &&
					!letters2.matches(valids) &&
					!letters3.matches(valids) &&
					!letters4.matches(valids) &&
					!letters5.matches(valids) &&
					!letters6.matches(valids) &&
					!letters7.matches(valids) &&
					!letters8.matches(valids)
					){
				System.out.println("NONE");

			}
			tobeprinted = tobeprinted.substring(0, tobeprinted.length() - 2);
			System.out.println(tobeprinted);

		}//for a

	}//main

}//class