package org.dalton.acsl2.bits11;

/**
 *Name: Jemma Issroff
 *School: The Dalton School
 *Number: 3095
 */
import java.util.ArrayList;
import java.util.Scanner;
public class BitsJIssroff {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String[][] input = new String[5][2];
		for(int i=0; i<5; i++){
			input[i]=scanner.nextLine().split(", ", 2);
		}
		for(int k=0; k<5; k++){
			String[] line = new String[Integer.parseInt(input[k][0])];
			line = input[k][1].split(", ");
			String[] n = new String[reduce(line).length];
			n=reduce(line);
			char[][] term = new char[Integer.parseInt(input[k][0])][n[0].length()];
			for(int r=0; r<Integer.parseInt(input[k][0]); r++){
				for(int c=0; c<n[0].length(); c++){
					term[r][c]=n[r].charAt(c);
				}
			}
			int counter=0;
			String t = output(term);
			for(int y=0; y<n[0].length(); y++){
				if(t.charAt(y)=='*') counter++;
			}
			if((Math.pow(2, counter)!=Integer.parseInt(input[k][0]))){
				System.out.println("NONE");
			}
			else System.out.println(t);
		}
	}
	private static String output(char[][] terms){
		String s ="";
		for(int c=0; c<terms[0].length; c++){
			boolean same = true;
			int digit=terms[0][c];
			for(int r=0; r<terms.length; r++){
				if((digit!=terms[r][c])&&(same)){
					s = s+"*";
					same = false;
				}
			}
			if(same) s = s + terms[0][c];
		}
		return s;
	}
	private static String[] reduce(String[] list){
		ArrayList<String> ret = new ArrayList<String>();
		for(int i=0; i<list.length; i++){
			ret.add(list[i]);
		}
		for(int i=0; i<ret.size(); i++){
			for(int k=i+1; k<ret.size(); k++){
				if(list[i]==list[k]){
					ret.remove(k);
				}
			}
		}
		String[] r = new String[ret.size()];
		for(int i=0;i<ret.size();i++){
			r[i]=ret.get(i);
		}
		return r;
	}
}