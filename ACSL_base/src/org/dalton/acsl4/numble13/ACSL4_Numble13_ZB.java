package org.dalton.acsl4.numble13;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ACSL4_Numble13_ZB {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] split = input.split(", ");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		int c = Integer.parseInt(split[2]);

		String as = split[0];
		String bs = split[1];
		String cs = split[2];

		// loop though each of the 5 cases
		for (int i = 0; i < 5; i++) {
			String numbers = scan.nextLine();
			int lenH = Integer.parseInt(numbers.split(", ")[0]);
			int lenV1 = Integer.parseInt(numbers.split(", ")[1]);
			int lenV2 = Integer.parseInt(numbers.split(", ")[2]);

			int cross1 = Integer.parseInt(numbers.split(", ")[3]);
			int cross2 = Integer.parseInt(numbers.split(", ")[4]);

			ArrayList<String> aList = new ArrayList<String>();
			perm(as, aList, lenH);

			ArrayList<String> bList = new ArrayList<String>();
			perm(bs, bList, lenV1);

			ArrayList<String> cList = new ArrayList<String>();
			perm(cs, cList, lenV2);

			// loop through each of the lists and cull the bad ones
			String aMax = "";
			int max = 0;
			for (int j = 0; j < aList.size(); j++) {
				String str = aList.get(j);
				ArrayList<Character> chars = new ArrayList<Character>();
				for (char cha : str.toCharArray()) {
					chars.add(cha);
				}
				Collections.sort(chars, Collections.reverseOrder());
				if (aList.get(j).charAt(0) == '0') {
					if (!getStringRepresentation(chars).contains(
							aList.get(j).substring(1)))
						continue;
				} else if (!aList.get(j).equals(getStringRepresentation(chars)))
					continue;
				if (sumDigits(Integer.parseInt(aList.get(j))) % 5 != 0)
					continue;
				if (aList.get(j).contains("00"))
					continue;
				if (!aList.get(j).contains(String.valueOf(cross1)))
					continue;
				if (!aList.get(j).contains(String.valueOf(cross2)))
					continue;
				if (sumDigits(Integer.parseInt(aList.get(j))) > max) {
					max = sumDigits(Integer.parseInt(aList.get(j)));
					aMax = aList.get(j);
				}
			}

			String bMax = "";
			max = 0;
			for (int j = 0; j < bList.size(); j++) {
				String str = bList.get(j);
				ArrayList<Character> chars = new ArrayList<Character>();
				for (char cha : str.toCharArray()) {
					chars.add(cha);
				}
				Collections.sort(chars, Collections.reverseOrder());
				if (bList.get(j).charAt(0) == '0') {
					if (!getStringRepresentation(chars).contains(
							bList.get(j).substring(1)))
						continue;
				} else if (!bList.get(j).equals(getStringRepresentation(chars)))
					continue;
				if (sumDigits(Integer.parseInt(bList.get(j))) % 5 != 0)
					continue;
				if (bList.get(j).contains("00"))
					continue;
				if (!bList.get(j).contains(String.valueOf(cross1)))
					continue;
				if (sumDigits(Integer.parseInt(bList.get(j))) > max) {
					max = sumDigits(Integer.parseInt(bList.get(j)));
					bMax = bList.get(j);
				}
			}

			String cMax = "";
			max = 0;
			for (int j = 0; j < cList.size(); j++) {
				String str = cList.get(j);
				ArrayList<Character> chars = new ArrayList<Character>();
				for (char cha : str.toCharArray()) {
					chars.add(cha);
				}
				Collections.sort(chars, Collections.reverseOrder());
				if (cList.get(j).charAt(0) == '0') {
					if (!getStringRepresentation(chars).contains(
							cList.get(j).substring(1)))
						continue;
				} else if (!cList.get(j).equals(getStringRepresentation(chars)))
					continue;
				if (sumDigits(Integer.parseInt(cList.get(j))) % 5 != 0)
					continue;
				if (cList.get(j).contains("00"))
					continue;
				if (!cList.get(j).contains(String.valueOf(cross2)))
					continue;
				if (sumDigits(Integer.parseInt(cList.get(j))) > max) {
					max = sumDigits(Integer.parseInt(cList.get(j)));
					cMax = cList.get(j);
				}
			}

//			System.err.println(aMax);
//			System.err.println(bMax);
//			System.err.println(cMax);
//			
//			System.err.println("c1 "+ cross1);
//			System.err.println("c2 "+ cross2);
			
			int col1 = aMax.indexOf(Integer.toString(cross1));
			int col2 = aMax.indexOf(Integer.toString(cross2));
			
			
//			System.err.println("col1 "+ col1);
//			System.err.println("col2 "+ col2);
//			
			int hrow = Math.max(bMax.indexOf(Integer.toString(cross1)), cMax.indexOf(Integer.toString(cross2)));
//			System.err.println("hrow "+ hrow);
			
			int gridHeight = hrow + Math.max(bMax.length()-bMax.indexOf(Integer.toString(cross1))-1, cMax.length()-cMax.indexOf(Integer.toString(cross2))-1);
			//System.err.println("height "+ gridHeight);
			
			char[][] grid = new char[gridHeight+1][aMax.length()];
			
			
			for (char[] row : grid)
			    Arrays.fill(row, ' ');
			
			
			for (int k = 0; k < grid[0].length; k++) {
				grid[hrow][k] = aMax.charAt(k);
			}
			
			int c1Start = hrow - bMax.indexOf(Integer.toString(cross1));
			int c2Start = hrow - cMax.indexOf(Integer.toString(cross2));
			//System.err.println("c1Start "+ c1Start);
			//System.err.println("c2Start " + c2Start);
			
			for (int k = c1Start; k < c1Start+bMax.length(); k++) {
				grid[k][col1] = bMax.charAt(k-c1Start);
			}
			
			for (int k = c2Start; k < c2Start+cMax.length(); k++) {
					grid[k][col2] = cMax.charAt(k-c2Start);
			}
			
			
			pGrid(grid);
		}// end loop through cases

	}

	
	public static void pGrid(char matrix[][]) {
	    for (int row = 0; row < matrix.length; row++) {
	        for (int column = 0; column < matrix[row].length; column++) {
	            System.out.print(matrix[row][column] + " ");
	        }
	        System.out.println();
	    }
	}
	
	public static String getStringRepresentation(ArrayList<Character> list) {
		StringBuilder builder = new StringBuilder(list.size());
		for (Character ch : list) {
			builder.append(ch);
		}
		return builder.toString();
	}

	public static void perm(String s, ArrayList<String> aList, int MAX) {
		perm("", s, aList, MAX);
	}

	private static void perm(String prefix, String s, ArrayList<String> aList,
			int MAX) {
		int N = s.length();
		if (N == 0)
			aList.add(prefix.substring(0, MAX));
		else {
			for (int i = 0; i < N; i++)
				perm(prefix + s.charAt(i),
						s.substring(0, i) + s.substring(i + 1, N), aList, MAX);
		}

	}

	public static int sumDigits(int n) {
		String s = Integer.toString(n);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += Integer.parseInt(Character.toString(s.charAt(i)));
		}
		return res;
	}

	public static String reverse(String source) {
		int i, len = source.length();
		StringBuffer dest = new StringBuffer(len);

		for (i = (len - 1); i >= 0; i--)
			dest.append(source.charAt(i));
		return dest.toString();
	}

}
