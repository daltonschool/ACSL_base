package org.dalton.acsl2.metaphone09;
import java.util.Scanner;

public class Main {

	public static boolean checkVowel(String in){
		boolean result = false;
		if(in.contains("A") || in.contains("E") || in.contains("I") || in.contains("O") || in.contains("U")){
			result = true;
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//get input and put it into StringBuffer array
		Scanner in = new Scanner(System.in);
		String input2 = "";
		StringBuffer[] ip = new StringBuffer[5];
		System.out.println("Please enter strings 1-5.");
		int i = 0;
		for(i=0;i<5;i++){
		input2 = in.nextLine();
		ip[i] = new StringBuffer(input2);
		ip[i].append("   ");
		}
		
		//make the modifications
		for(i=0;i<5;i++){
	
			//step 1: change beginnings
			if(ip[i].substring(0, 2).contains("AE") || ip[i].substring(0,2).contains("GN") || ip[i].substring(0,2).contains("KN") || ip[i].substring(0,2).contains("PN") || ip[i].substring(0,2).contains("WR"))
				ip[i].delete(0, 1);
				
			else if(ip[i].substring(0,1).contains("X"))
				ip[i].replace(0, 1, "S");
			
			else if(ip[i].substring(0,2).contains("WH"))
				ip[i].replace(0, 2, "W");
			
			//step 2: an absurd amount of replacements
			boolean stop = false;
			bigloop: while(!stop){
				int j = 0;

				for(j=0;j<ip[i].length();j++){	
				
					//rule #1: B -> B unless at the end of a word after an M, as in "DUMB", then the B is dropped
					if(j>=1 && ip[i].substring(j,j+1).contains("B") && ip[i].substring(j-1,j).contains("M")){
						ip[i].delete(j, j+1);
						continue bigloop;
					}
					
					//rule #2: C -> dropped if in SCI or SCY
					if(j >= 1 && j<= ip[i].length()-3 && ip[i].substring(j,j+1).contains("C") && ip[i].substring(j-1,j).contains("S") && (ip[i].substring(j+1,j+2).contains("I") || ip[i].substring(j+1,j+2).contains("Y"))){
						ip[i].delete(j,j+1);
						continue bigloop;
					}
					
					//rule #3: C -> X if in CIA, CH, CI, CE or CY
					if(j<= ip[i].length()-3 && ip[i].substring(j,j+1).contains("C") && (ip[i].substring(j+1,j+3).contains("IA") || ip[i].substring(j+1,j+2).contains("H") || ip[i].substring(j+1,j+2).contains("I") || ip[i].substring(j+1,j+2).contains("E") || ip[i].substring(j+1,j+2).contains("Y"))){
						ip[i].replace(j, j+1, "X");
						continue bigloop;
					}
					
					//rule #4: C -> K otherwise
					if(ip[i].substring(j,j+1).contains("C")){
						ip[i].replace(j, j+1, "K");
						continue bigloop;
					}
					
					//rule #5: D -> J if in DGE, DGY, or DG
					if(j<= ip[i].length()-3 && ip[i].substring(j,j+1).contains("D") && (ip[i].substring(j+1,j+3).contains("GE") || ip[i].substring(j+1,j+3).contains("GY") || ip[i].substring(j+1,j+2).contains("G"))){
						ip[i].replace(j,j+1,"J");
						continue bigloop;
					}
					
					//rule #6: D -> T otherwise
					if(ip[i].substring(j,j+1).contains("D")){
						ip[i].replace(j, j+1, "T");
						continue bigloop;
					}
					
					//rule #7: G -> dropped if after a vowel and no vowel follows
					if(j >= 1 && j <= ip[i].length()-2 && ip[i].substring(j,j+1).contains("G") && checkVowel(ip[i].substring(j-1,j)) && !checkVowel(ip[i].substring(j+1,j+2))){
						ip[i].delete(j,j+1);
						continue bigloop;
					}
					
					//rule #8: G -> J if before I, E, or Y and if not part of a double G
					if(ip[i].substring(j,j+1).contains("G") && !ip[i].substring(j+1,j+2).contains("G") && (ip[i].substring(j+1,j+2).contains("I") || ip[i].substring(j+1,j+2).contains("E") || ip[i].substring(j+1,j+2).contains("Y"))){
						ip[i].replace(j,j+1,"J");
						continue bigloop;
					}
					
					//rule #9: G -> K otherwise
					if(ip[i].substring(j,j+1).contains("G")){
						ip[i].replace(j,j+1,"K");
						continue bigloop;
					}
					
					//rule #10: H -> dropped if after a vowel and no vowel follows or after C, S, P, T or G
					if(j >= 1 && j < ip[i].length()-2 && ip[i].substring(j,j+1).contains("H") && ((checkVowel(ip[i].substring(j-1,j)) && !checkVowel(ip[i].substring(j+1,j+2))) || (ip[i].substring(j-1,j).contains("C") || ip[i].substring(j-1,j).contains("S") || ip[i].substring(j-1,j).contains("P") || ip[i].substring(j-1,j).contains("T") || ip[i].substring(j-1,j).contains("G")))){
						ip[i].delete(j,j+1);
						continue bigloop;
					}
					
					//rule #11: P -> F if before H
					if(j >= 2 && j < ip[i].length()-3 && ip[i].substring(j-2,j-1).contains("P") && ip[i].substring(j-1,j).contains("H")){
						ip[i].replace(j-2,j-1,"F");
						continue bigloop;
					}
					
					//rule #12: Q -> K always
					if(ip[i].substring(j,j+1).contains("Q")){
						ip[i].replace(j,j+1,"K");
						continue bigloop;
					}
					
					//rule #13: S -> X if before an H or in SIO or SIA
					if(j < ip[i].length()-3 && ip[i].substring(j,j+1).contains("S") && (ip[i].substring(j+1,j+3).contains("IO") || ip[i].substring(j+1,j+3).contains("IA"))){
						ip[i].replace(j,j+1,"X");
						continue bigloop;
					}
					
					//rule #14: T -> X if in TIA or TIO
					if(j < ip[i].length()-3 && ip[i].substring(j,j+1).contains("T") && (ip[i].substring(j+1,j+3).contains("IA") || ip[i].substring(j+1,j+3).contains("IO"))){
						ip[i].replace(j, j+1, "X");
						continue bigloop;
					}
					
					//rule #15: V -> F always
					if(ip[i].substring(j,j+1).contains("V")){
						ip[i].replace(j,j+1,"F");
						continue bigloop;
					}
					
					//rule #16: W -> dropped if not followed by a vowel
					if(j < ip[i].length()-1 && ip[i].substring(j,j+1).contains("W") && !checkVowel(ip[i].substring(j+1,j+2))){
						ip[i].delete(j,j+1);
						continue bigloop;
					}
					
					//rule #17: Y -> dropped if not followed by a vowel
					if(j < ip[i].length()-1 && ip[i].substring(j,j+1).contains("Y") && !checkVowel(ip[i].substring(j+1,j+2))){
						ip[i].delete(j,j+1);
						continue bigloop;
					}
					
					//rule #18: Z -> S always
					if(ip[i].substring(j,j+1).contains("Z")){
						ip[i].replace(j,j+1,"S");
						continue bigloop;
					}
					
					
					
					//rule #19: multiple letters - keep just the first occurrence
					if(j < ip[i].length()-1 && ip[i].substring(j,j+1).contains(ip[i].substring(j+1,j+2))){
						ip[i].delete(j+1,j+2);
						continue bigloop;
					}
					
				}
				
				for(j=0;j<ip[i].length();j++){
					if(checkVowel(ip[i].substring(j,j+1))){
						ip[i].delete(j,j+1);
					}
				}
				for(j=0;j<ip[i].length();j++){
					if(checkVowel(ip[i].substring(j,j+1))){
						ip[i].delete(j,j+1);
					}
				}
				for(j=0;j<ip[i].length();j++){
					if(checkVowel(ip[i].substring(j,j+1))){
						ip[i].delete(j,j+1);
					}
				}
				
				stop = true;
			}
			//print output
			System.out.println(ip[i].toString());
			
		}
		
	}

}
