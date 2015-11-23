package org.dalton.acsl4.numble13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.text.StyledEditorKit.ForegroundAction;
/**@Author Matt Cohen
 * The Dalton School
 * 3055
 */

public class ASCL4_Numble13_MC {

	public static void main(String[] args) {
		int loop = 1;
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String [] numbers = input.split(", ");
		while (loop == 1){
			String para = scan.nextLine();
			String [] params = para.split(", ");
			String [] choice = chooser(numbers[0], numbers[1], numbers[2], Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]));
			sPrint(choice, Integer.parseInt(params[3]), Integer.parseInt(params[4]));
		}
	}

	public static void sPrint(String [] args, int a, int b){
		int aSpace = args[1].indexOf(a+48);
		int bSpace = args[2].indexOf(b+48);
		int aCol = args[0].indexOf(a+48);
		int bCol = args[0].indexOf(b+48);
		char printArray [][] = new char [Math.max(aSpace, bSpace)+Math.max(args[1].length()-aSpace, args[2].length()-bSpace)][args[0].length()];
		for (int i = 0; i < printArray.length; i++) {
			for (int j = 0; j < printArray[i].length; j++) {
				printArray[i][j] = ' ';}}
		//System.out.println(aSpace + " + " + bSpace);
		if (aSpace > bSpace || aSpace == bSpace){
			for (int i = 0; i < args[1].length(); i++) {
				printArray[i][aCol] = args[1].charAt(i);}
			for (int i = 0; i < args[2].length(); i++) {
				printArray[aSpace-bSpace+i][bCol] = args[2].charAt(i);}
			for (int i = 0; i < args[0].length(); i++) {
				printArray[aSpace][i] = args[0].charAt(i);}}
		else {
			for (int i = 0; i < args[1].length(); i++) {
				printArray[bSpace-aSpace+i][aCol] = args[1].charAt(i);}
			for (int i = 0; i < args[2].length(); i++) {
				printArray[i][bCol] = args[2].charAt(i);}
			for (int i = 0; i < args[0].length(); i++) {
				printArray[bSpace][i] = args[0].charAt(i);}}
		for (int i = 0; i < printArray.length; i++) {
			for (int j = 0; j < printArray[i].length; j++) {
				System.out.print(printArray[i][j]);
			}
			System.out.println();		
		}
		System.out.println();
	}

	public static String [] chooser (String a, String b, String c, int aa, int bb, int cc){
		String [] choice = new String [3];
		choice [0] = highest(a, aa);
		choice [1] = highest(b, bb);
		choice [2] = highest(c, cc);
		return choice;	}

	public static String highest (String starter, int param){
		ArrayList<String> als = permutation(starter);
		Collections.sort(als);
		for (int i = als.size()-1; i > -1; i--) {
			if (starter.charAt(starter.length()-1) == 48 && starter.charAt(starter.length()-2) == 48 && starter.charAt(starter.length()-3) == 48){}
			else{
				if(countAdder(als.get(i), param)%5 == 0){
					starter = als.get(i).substring(0, param);
					i = -2;}}}
		if (starter.charAt(starter.length()-1) == 48 && starter.charAt(starter.length()-2) == 48){
			starter = "0" + starter.substring(0,starter.length()-1);	}
		return starter;}

	public static int countAdder (String digits, int param) {
		int count = 0;
		for (int i = 0; i < param; i++) {
			count = count -48 + Integer.valueOf((digits.charAt(i)));}
		return count;}

	//taken from: http://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
	public static ArrayList<String> permutation(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s.length() == 1) {
			res.add(s);
		} else if (s.length() > 1) {
			int lastIndex = s.length() - 1;
			String last = s.substring(lastIndex);
			String rest = s.substring(0, lastIndex);
			res = merge(permutation(rest), last);}
		return res;}
	public static ArrayList<String> merge(ArrayList<String> list, String c) {
		ArrayList<String> res = new ArrayList<String>();
		for (String s : list) {
			for (int i = 0; i <= s.length(); ++i) {
				String ps = new StringBuffer(s).insert(i, c).toString();
				res.add(ps);}}
		return res;}
}