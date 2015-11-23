package org.dalton.acsl4.numble13;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class ACSL4_Numble13_PC {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String[] location = scan.nextLine().split(", ");

		String [] strings_one = new String[7];
		String [] strings_two = new String[7];
		String [] strings_three = new String[7];

		for (int i = 0; i < strings_one.length; i++) {
			strings_one = location[0].split("(?!^)");
			strings_two = location[1].split("(?!^)");
			strings_three = location[2].split("(?!^)");
		}

		for (int s = 0; s < 5; s++) {

			ArrayList<Integer> horz = new ArrayList<Integer>();
			ArrayList<Integer> ver_one = new ArrayList<Integer>();
			ArrayList<Integer> ver_two = new ArrayList<Integer>();

			for (int i = 0; i < 7; i++) {
				horz.add(Integer.parseInt(strings_one[i]));
				ver_one.add(Integer.parseInt(strings_two[i]));
				ver_two.add(Integer.parseInt(strings_three[i]));
			}

			String [] parts = scan.nextLine().split(", ");
			int length_one = Integer.parseInt(parts[0]);
			int length_two = Integer.parseInt(parts[1]);
			int length_three = Integer.parseInt(parts[2]);
			int cross_one = Integer.parseInt(parts[3]);
			int cross_two = Integer.parseInt(parts[4]);

			ArrayList<Integer> hor_sol = new ArrayList<Integer>();
			ArrayList<Integer> vone_sol = new ArrayList<Integer>();
			ArrayList<Integer> vtwo_sol = new ArrayList<Integer>();
			boolean v1_check = false;
			boolean v2_check = false;
			boolean hor1_check = false;
			boolean hor2_check = false;
			for (int i = 0; i < ver_one.size(); i++) {
				if(ver_one.get(i) == cross_one && v1_check == false)
				{
					ver_one.remove(i);
					v1_check = true;
				}
			}

			for (int j = 0; j < ver_two.size(); j++) {
				if(ver_two.get(j) ==cross_two && v2_check == false)
				{
					ver_two.remove(j);
					v2_check = true;
				}
			}

			for (int j = 0; j < parts.length; j++) {
				if(horz.get(j) == cross_one && hor1_check == false)
				{
					horz.remove(j);
					hor1_check = true;
				}
				if(horz.get(j) == cross_two && hor2_check == false)
				{
					horz.remove(j);
					hor2_check = true;
				}
			}

			//first sort
			int target_sum = 60;
			SortPC get = new SortPC();

			while(hor_sol.size() < 1)
			{
				hor_sol = get.populateSubset(horz, 0, horz.size(), target_sum-cross_one-cross_two, length_one-2);
				target_sum-=5;
			}
			hor_sol.add(cross_one);
			hor_sol.add(cross_two);

			//second sort
			target_sum = 60;
			SortPC get2 = new SortPC();

			while(vone_sol.size() < 1)
			{
				vone_sol = get2.populateSubset(ver_one, 0, ver_one.size(), target_sum-cross_one, length_two-1);
				target_sum-=5;
			}
			vone_sol.add(cross_one);

			//third sort
			target_sum = 60;
			SortPC get3 = new SortPC();

			while(vtwo_sol.size() < 1)
			{
				vtwo_sol = get3.populateSubset(ver_two, 0, ver_two.size(), target_sum-cross_two, length_three-1);
				target_sum-=5;
			}
			vtwo_sol.add(cross_two);

			Collections.sort(vtwo_sol);
			Collections.sort(vone_sol);
			Collections.sort(hor_sol);
			Collections.reverse(vone_sol);
			Collections.reverse(vtwo_sol);
			Collections.reverse(hor_sol);

			SortPC.n_print(hor_sol, vone_sol, vtwo_sol, cross_one, cross_two); 
		}
	}
}


class SortPC {

	/** modified from stack overflow (http://codereview.stackexchange.com/questions/36214/find-all-subsets-of-an-int-array-whose-sums-equal-a-given-target)*/
	private Stack<Integer> stack = new Stack<Integer>();

	/** Store the sum of current elements stored in stack */
	private int sumInStack = 0;
	boolean once = false;
	static Integer[][] n_board; 

	ArrayList<Integer> elements = new ArrayList<Integer>();

	public ArrayList<Integer> populateSubset(ArrayList<Integer> data, int fromIndex, int endIndex, int target_sum, int size) {
		boolean go = false;
		/*
		 * Check if sum of elements stored in Stack is equal to the expected
		 * target sum.
		 * 
		 * If so, call print method to print the candidate satisfied result.
		 */


		if(go == false)
		{

			@SuppressWarnings("unused")
			int index = 0;
			if (sumInStack == target_sum && stack.size() == size && once == false) {

				for (Integer i : stack) {
					if(stack.size() == size && go == false)
					{
						elements.add(i);
						index++;
					}
					index = 0;
					once = true;
				}
				go = true;

			}


			if(go == true)
			{
				fromIndex = 1000;
			}

			for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

				if (sumInStack + data.get(currentIndex) <= target_sum) {
					stack.push(data.get(currentIndex));
					sumInStack += data.get(currentIndex);

					/*
					 * Make the currentIndex +1, and then use recursion to proceed
					 * further.
					 */
					if(go == false)
					{
						populateSubset(data, currentIndex + 1, endIndex, target_sum, size);
					}
					sumInStack -= (Integer) stack.pop();
				}
			}
		}

		return elements;


	}

	public static void n_print(ArrayList<Integer> horz, ArrayList<Integer> vone_sol, ArrayList<Integer> vtwo_sol, int cross1, int cross2){
		ArrayList<StringBuilder> collumns = new ArrayList<StringBuilder>();
		for (int i = 0; i < horz.size(); i++) 
		{
			collumns.add(new StringBuilder("")); 
		}

		int top = 0, bottom = 0; 
		for (int i = 0; i < collumns.size(); i++) {
			if(i == horz.indexOf(cross1)){
				for (int j = 0; j < vone_sol.size(); j++) {
					collumns.get(i).append(vone_sol.get(j)); 
				}
			}
			else if(i == horz.indexOf(cross2)){
				for (int j = 0; j < vtwo_sol.size(); j++) 
				{
					collumns.get(i).append(vtwo_sol.get(j)); 
				}
			}
			else 
				collumns.get(i).append(horz.get(i)); 
		}

		if(vtwo_sol.indexOf(cross2) < vone_sol.indexOf(cross1)){
			top = vone_sol.indexOf(cross1); 
		}
		else {
			top = vtwo_sol.indexOf(cross2); 
		}
		if(vone_sol.size()-vone_sol.indexOf(cross1)+3>vtwo_sol.size()-vtwo_sol.indexOf(cross2) + 3){
			bottom = vone_sol.size() - vone_sol.indexOf(cross1); 
		}
		else {
			bottom = vtwo_sol.size() - vtwo_sol.indexOf(cross2); 
		}
		bottom --; 
		int uno_y = top, dos_y = top;

		n_board = new Integer[top+1+bottom][horz.size()]; 

		uno_y-= vone_sol.indexOf(cross1);
		dos_y-= vtwo_sol.indexOf(cross2);
		for (int i = 0; i < vtwo_sol.size(); i++) {
			n_board[i+dos_y][horz.indexOf(cross2)] = vtwo_sol.get(i); 
		}
		for (int i = 0; i < vone_sol.size(); i++) {
			n_board[i+uno_y][horz.indexOf(cross1)] = vone_sol.get(i); 
		}
		for (int i = 0; i < horz.size(); i++) {
			n_board[top][i] = horz.get(i); 
		}
		for (int i = 0; i < n_board.length; i++) {
			for (int j = 0; j < n_board[0].length; j++) {
				if(n_board[i][j] == null){
					n_board[i][j] = -1; 
				}
			}
		}

		for(int i = 0; i < n_board.length; i++){
			for(int j = 0; j < n_board[i].length; j++){
				if(n_board[i][j] != -1)
					System.out.print(n_board[i][j]);
				else 
					System.out.print(" ");
				if(j < n_board[i].length - 1) { 
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private void print(Stack<Integer> stack, int target_sum, int size) {
		StringBuilder sb = new StringBuilder();
		sb.append(target_sum).append(" = ");
		for (Integer i : stack) {
			if(stack.size() == size)
			{
				sb.append(i).append("+");
			}
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1).toString());

	}
}
