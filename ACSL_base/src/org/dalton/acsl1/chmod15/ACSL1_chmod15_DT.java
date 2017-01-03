package org.dalton.acsl1.chmod15;
/**
 * Daniel Tomlinson
 * 
 * 
 */


import java.util.Scanner;

public class ACSL1_chmod15_DT {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        while(true){
        	String s = String.format("%12s", Integer.toBinaryString(Integer.parseInt(scan.nextLine().replaceAll(",[ ]*", ""), 8))).replace(' ', '0');
        	StringBuilder key = new StringBuilder("rw" + ((s.charAt(2)=='1')?"s":"x") + " rw" + ((s.charAt(1)=='1')?"s":"x") + " rw" + ((s.charAt(0)=='1')?"t":"x"));
        	for (int i = 3; i < s.length(); i++) if (s.charAt(i) == '0') key.setCharAt((i>8)?i-1:(i>5)?i-2:i-3, '-');
        	System.out.println(s.substring(3,6) + " " + s.substring(6,9) + " " + s.substring(9,12) + " and " + key);
        }
    }
}