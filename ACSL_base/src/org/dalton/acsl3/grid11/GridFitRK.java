/**
 * GridFit program for ACSL 2011-2012
 * 
 * @author Russell Kaplan
 * School: Dalton
 * Code: 3055
 */

package org.dalton.acsl3.grid11;

import java.util.Scanner;

public class GridFitRK {
	
	final static int ROWS = 7;
	final static int COLS = 5;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] init = sc.nextLine().split(", ");
		int[] frontier = new int[] {5, 1, 2, 3, 4}; //lowest empty square in each column
		int temp;
		for(int i = 1; i < init.length; i++) {
			temp = Integer.parseInt(init[i]);
			if(temp + COLS > frontier[temp % COLS]) {
				frontier[temp % COLS] = temp + COLS;
			}
		}
		
//		System.out.println("Initial frontier:");
//		for(int i : frontier) System.out.print(i + " ");
//		System.out.println();
		
		for(int input = 0; input < 5; input++) {
			Piece p = new Piece(sc.nextInt());
			int min = Integer.MAX_VALUE;
			int curPlace;
			boolean fits;
			
			for(int i = p.legalInRightCol ? 0 : 1; i < frontier.length; i++) {
				for(curPlace = frontier[i]; curPlace <= ROWS*COLS; curPlace += COLS) {
					fits = true; //assume it fits, then try to find a contradiction
					for(int j = 0; j < p.spacefills.length; j++) {
						if(curPlace + p.spacefills[j] < frontier[(curPlace + p.spacefills[j]) % COLS] || curPlace + p.spacefills[j] > ROWS*COLS) {
							fits = false;
							break;
						}
					}
					if(fits && curPlace < min) min = curPlace;
				}
			}
			
			if(min != Integer.MAX_VALUE) {
				System.out.println(min);
				for(int i = 0; i < p.spacefills.length; i++) {
					frontier[(min + p.spacefills[i]) % COLS] = min + p.spacefills[i] + COLS;
				}
				
//				System.out.println("Frontier updated:");
//				for(int i : frontier) System.out.print(i + " ");
//				System.out.println();
			}
			else System.out.println("NONE");
		}
		
	}
}

class Piece {

	public int[] spacefills;
	public boolean legalInRightCol;
	
	public Piece(int id) {
		if(id == 1) spacefills = new int[] {0};
		else if(id == 2) spacefills = new int[] {0, 5};
		else if(id == 3) spacefills = new int[] {0, 1};
		else if(id == 4) spacefills = new int[] {0, 5, 6};
		else if(id == 5) spacefills = new int[] {0, 1, 5};
		
		for(int i = 0; i < spacefills.length; i++) {
			legalInRightCol = spacefills[i] % 5 != 1;
			if(!legalInRightCol) break;
		}
	}
}