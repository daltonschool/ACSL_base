package org.dalton.acsl2.cells12;
/*
 * Name: Jemma Issroff
 * School: The Dalton School
 * Code: 3055
 * Date: Feb 2013
 */
import java.util.*;
public class CellsJI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<5; i++){
			String res = "";
			String input = scanner.nextLine();
			String[] in = input.split(",");
			String s = in[1].trim();
			if(in[0].charAt(0)=='D') res=sort(s.substring(0, 4))+sort(s.substring(0, 4))+" and "+sort(s.substring(4))+sort(s.substring(4));
			else if(in[0].charAt(0)=='A'){
				int n = Integer.parseInt(Character.toString(in[0].charAt(3)));
				res=s.substring(0, n)+sort(s.substring(0,n))+s.substring(n,s.length()-n);
			}
			else if(in[0].charAt(0)=='S'){
				int n = Integer.parseInt(Character.toString(in[0].charAt(8)));
				res=s.substring(n,s.length()-n)+s.substring(s.length()-n)+sort(s.substring(s.length()-n));
			}
			else if(in[0].charAt(0)=='U') res=sort(s.substring(4)) + sort(in[2].trim().substring(0, 4));
			else if(in[0].charAt(0)=='I') res=sort(s.substring(0,2)+s.substring(6))+sort(in[2].trim().substring(0, 2)+in[2].trim().substring(6));
			System.out.println(res);
		}
	}
	public static String sort(String old){
		char[] res = old.toCharArray();
		Arrays.sort(res);
		return new String(res);
	}
}