package org.dalton.acsl4.regexp15;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ACSL4_RegExp15_c17tv { 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String i;
		String t2;
		String t3;
		String t4;
		String t5;
		String t6;
		String[] h;
		while(true){
			i = scan.nextLine();
			h = i.split(", ");
			t2 = scan.nextLine();
			t3 = scan.nextLine();
			t4 = scan.nextLine();
			t5 = scan.nextLine();
			t6 = scan.nextLine();
			ArrayList<ArrayList> rules = new ArrayList<ArrayList>(5);
			for (int j = 0; j < 5; j++) rules.add(new ArrayList<String>());
			for (int j = 0; j < h.length; j++) if(h[j].matches(t2)) rules.get(0).add(h[j]);
			for (int j = 0; j < h.length; j++) if(h[j].matches(t3)) rules.get(1).add(h[j]);
			for (int j = 0; j < h.length; j++) if(h[j].matches(t4)) rules.get(2).add(h[j]);
			for (int j = 0; j < h.length; j++) if(h[j].matches(t5)) rules.get(3).add(h[j]);
			for (int j = 0; j < h.length; j++) if(h[j].matches(t6)) rules.get(4).add(h[j]);
			for (int r = 0; r < 5; r++) {
				if (rules.get(r).size()==0) System.out.print("NONE");
				for (int j = 0; j < rules.get(r).size(); j++) {
					System.out.print(rules.get(r).get(j));
					if (!(j==rules.get(r).size()-1)) System.out.print(", ");
				}
				System.out.println();
			}
		}
	}
}