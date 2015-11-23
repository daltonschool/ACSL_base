package org.dalton.acsl4.quine14;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Cal Lavicka
 * 
 * ACSL 4
 */

public class ACSL4_Quine14_CL {
	
/*
2, 6, -1
2, 3, 5, 7, -1
1, 3, 4, 5, 6, 7, -1
8, 9, 10, 11, 12, 14, 15, -1
9, 10, 11, 12, 13, 14, 15, -1

 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		// 3 DIGITS
		for(int test = 0; test < 3; test++) {
			String[] inputs = scan.nextLine().split(", ");
			
			int[] truths = new int[inputs.length - 1];
			for(int i=0; i<truths.length; i++) {
				truths[i] = Integer.parseInt(inputs[i]);
			}
			
			ArrayList<Binary>[] binaries = new ArrayList[4];
			
			for(int i=0; i<binaries.length; i++) {
				binaries[i]= new ArrayList<Binary>();
			}
			
			for(int truth : truths) {
				Binary binary = new Binary((truth & 4) != 0, (truth & 2) != 0, (truth & 1) != 0);
				
				binaries[binary.num].add(binary);
			}
			
			ArrayList<Pair>[] pairs = new ArrayList[3];
			
			for(int i=0; i<pairs.length; i++) {
				pairs[i] = new ArrayList<Pair>();
				
				for(Binary b1 : binaries[i]) {
					for(Binary b2 : binaries[i+1]) {
						Pair p = new Pair(b1, b2);
						if(p.valid) pairs[i].add(p); 
					}
				}
			}
			
			ArrayList<Quad>[] quads = new ArrayList[2];
			
			// Add quads
			for(int i=0; i<quads.length; i++) {
				quads[i] = new ArrayList<Quad>();
				
				for(Pair p1 : pairs[i]) {
					for(Pair p2 : pairs[i + 1]) {
						Quad q = new Quad(p1, p2);
						if(q.valid) quads[i].add(q); 
					}
				}
			}
			
			// Remove excess quads
			{
				ArrayList<Quad> toRemove = new ArrayList<Quad>();
				
				for(int i=0; i<quads.length; i++) {
					for(int j = 0; j < quads[i].size(); j++) {
						for(int k = j+1; k < quads[i].size(); k++) {
							if(quads[i].get(j).toString().equals(quads[i].get(k).toString())) {
								toRemove.add(quads[i].get(j));
								break;
							}
						}
					}
					
					for(Quad q : toRemove) {
						quads[i].remove(q);
					}
					
					toRemove.clear();
				}
			}
			
			boolean plus = false;
			
			for(ArrayList<Binary> list : binaries) {
				for(Binary b : list) {
					if(b.valid) {
						if(plus) System.out.print(" + ");
						System.out.print(b);
						plus = true;
					}
				}
			}
			
			for(ArrayList<Pair> list : pairs) {
				for(Pair p : list) {
					if(p.valid) {
						if(plus) System.out.print(" + ");
						System.out.print(p);
						plus = true;
					}
				}
			}
			
			for(ArrayList<Quad> list : quads) {
				for(Quad q : list) {
					if(q.valid) {
						if(plus) System.out.print(" + ");
						System.out.print(q);
						plus = true;
					}
				}
			}
			
			System.out.println();
		}
		
		// 4 DIGITS
		for(int test = 0; test < 2; test++) {
			String[] inputs = scan.nextLine().split(", ");
			
			int[] truths = new int[inputs.length - 1];
			for(int i=0; i<truths.length; i++) {
				truths[i] = Integer.parseInt(inputs[i]);
			}
			
			ArrayList<Binary>[] binaries = new ArrayList[5];
			
			for(int i=0; i<binaries.length; i++) {
				binaries[i]= new ArrayList<Binary>();
			}
			
			for(int truth : truths) {
				Binary binary = new Binary((truth & 8) != 0, (truth & 4) != 0, (truth & 2) != 0, (truth & 1) != 0);
				
				binaries[binary.num].add(binary);
			}
			
			ArrayList<Pair>[] pairs = new ArrayList[4];
			
			for(int i=0; i<pairs.length; i++) {
				pairs[i] = new ArrayList<Pair>();
				
				for(Binary b1 : binaries[i]) {
					for(Binary b2 : binaries[i+1]) {
						Pair p = new Pair(b1, b2);
						if(p.valid) pairs[i].add(p); 
					}
				}
			}
			
			ArrayList<Quad>[] quads = new ArrayList[3];
			
			// Add quads
			for(int i=0; i<quads.length; i++) {
				quads[i] = new ArrayList<Quad>();
				
				for(Pair p1 : pairs[i]) {
					for(Pair p2 : pairs[i + 1]) {
						Quad q = new Quad(p1, p2);
						if(q.valid) quads[i].add(q); 
					}
				}
			}
			
			// Remove excess quads
			{
				ArrayList<Quad> toRemove = new ArrayList<Quad>();
				
				for(int i=0; i<quads.length; i++) {
					for(int j = 0; j < quads[i].size(); j++) {
						for(int k = j+1; k < quads[i].size(); k++) {
							if(quads[i].get(j).toString().equals(quads[i].get(k).toString())) {
								toRemove.add(quads[i].get(j));
								break;
							}
						}
					}
					
					for(Quad q : toRemove) {
						quads[i].remove(q);
					}
					
					toRemove.clear();
				}
			}
			

			
			ArrayList<Eight>[] eights = new ArrayList[2];
			
			// Add eights
			for(int i=0; i<eights.length; i++) {
				eights[i] = new ArrayList<Eight>();
				
				for(Quad q1 : quads[i]) {
					for(Quad q2 : quads[i + 1]) {
						Eight e = new Eight(q1, q2);
						if(e.valid) eights[i].add(e); 
					}
				}
			}
			
			// Remove excess eights
			{
				ArrayList<Eight> toRemove = new ArrayList<Eight>();
				
				for(int i=0; i<eights.length; i++) {
					for(int j = 0; j < eights[i].size(); j++) {
						for(int k = j+1; k < eights[i].size(); k++) {
							if(eights[i].get(j).toString().equals(eights[i].get(k).toString())) {
								toRemove.add(eights[i].get(j));
								break;
							}
						}
					}
					
					for(Eight e : toRemove) {
						eights[i].remove(e);
					}
					
					toRemove.clear();
				}
			}
			
			// Print answers
			
			boolean plus = false;
			
			for(ArrayList<Binary> list : binaries) {
				for(Binary b : list) {
					if(b.valid) {
						if(plus) System.out.print(" + ");
						System.out.print(b);
						plus = true;
					}
				}
			}
			
			for(ArrayList<Pair> list : pairs) {
				for(Pair p : list) {
					if(p.valid) {
						if(plus) System.out.print(" + ");
						System.out.print(p);
						plus = true;
					}
				}
			}
			
			for(ArrayList<Quad> list : quads) {
				for(Quad q : list) {
					if(q.valid) {
						if(plus) System.out.print(" + ");
						System.out.print(q);
						plus = true;
					}
				}
			}
			
			for(ArrayList<Eight> list : eights) {
				for(Eight e : list) {
					if(e.valid) {
						if(plus) System.out.print(" + ");
						System.out.print(e);
						plus = true;
					}
				}
			}
			
			System.out.println();
		}
		
		scan.close();
	}
	
	public static class Binary {
		boolean[] bits;
		
		int num;
		
		boolean valid = true;
		
		public Binary(boolean... bits) {
			this.bits = bits;

			num = 0;
			for(int i=0; i<bits.length; i++) {
				if(bits[i]) num++;
			}
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			char aUp = 'A';
			char aDown = 'a';
			
			for(int i=0; i<bits.length; i++) {
				if(bits[i]) sb.append((char)(aUp + i));
				else sb.append((char)(aDown + i));
			}
			
			return sb.toString();
		}
	}
	
	public static class Pair {
		
		boolean bits[];
		
		int open;
		
		boolean valid = true;
		
		public Pair(Binary b1, Binary b2) {
			open = -1;
			
			this.bits = new boolean[b1.bits.length];
			
			for(int i=0; i<b1.bits.length; i++) {
				if(b1.bits[i] == b2.bits[i]) {
					this.bits[i] = b1.bits[i];
				}else {
					if(open != -1) {
						valid = false;
						return;
					}else {
						open = i;
					}
				}
			}
			
			b1.valid = false;
			b2.valid = false;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			char aUp = 'A';
			char aDown = 'a';
			
			for(int i=0; i<bits.length; i++) {
				if(i == open) continue;
				
				if(bits[i]) sb.append((char)(aUp + i));
				else sb.append((char)(aDown + i));
			}
			
			return sb.toString();
		}
	}
	
	public static class Quad {
		boolean bits[];
		
		// open1 < open2
		int open1;
		int open2;
		
		boolean valid = true;
		
		public Quad(Pair p1, Pair p2) {
			if(p1.open != p2.open) {
				valid = false;
				return;
			}
			open1 = -1;
			open2 = p1.open;
			
			this.bits = new boolean[p1.bits.length];
			
			for(int i=0; i<p1.bits.length; i++) {
				if(i == open2) continue;
				
				if(p1.bits[i] == p2.bits[i]) {
					this.bits[i] = p1.bits[i];
				}else {
					if(open1 != -1) {
						valid = false;
						return;
					}else {
						open1 = i;
					}
				}
			}
			
			if(open1 > open2) {
				int temp = open2;
				open2 = open1;
				open1 = temp;
			}
			
			p1.valid = false;
			p2.valid = false;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			char aUp = 'A';
			char aDown = 'a';
			
			for(int i=0; i<bits.length; i++) {
				if(i == open1 || i == open2) continue;
				if(bits[i]) sb.append((char)(aUp + i));
				else sb.append((char)(aDown + i));
			}
			
			return sb.toString();
		}
	}
	
	public static class Eight {
		boolean bits[];
		
		// open1 < open2 < open3
		int open1;
		int open2;
		int open3;
		
		boolean valid = true;
		
		public Eight(Quad q1, Quad q2) {
			if(q1.open1 != q2.open1 || q1.open2 != q2.open2) {
				valid = false;
				return;
			}
			open1 = -1;
			open2 = q1.open1;
			open3 = q1.open2;
			
			this.bits = new boolean[q1.bits.length];
			
			for(int i=0; i<q1.bits.length; i++) {
				if(i == open2 || i == open3) continue;
				
				if(q1.bits[i] == q2.bits[i]) {
					this.bits[i] = q1.bits[i];
				}else {
					if(open1 != -1) {
						valid = false;
						return;
					}else {
						open1 = i;
					}
				}
			}
			
			if(open1 > open2) {
				int temp = open2;
				open2 = open1;
				open1 = temp;
				
				if(open2 > open3) {
					temp = open3;
					open3 = open2;
					open2 = temp;
				}
			}
			
			q1.valid = false;
			q2.valid = false;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			char aUp = 'A';
			char aDown = 'a';
			
			for(int i=0; i<bits.length; i++) {
				if(i == open1 || i == open2 || i == open3) continue;
				if(bits[i]) sb.append((char)(aUp + i));
				else sb.append((char)(aDown + i));
			}
			
			return sb.toString();
		}
	}
}
