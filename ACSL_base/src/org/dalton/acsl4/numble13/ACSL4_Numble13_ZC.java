package org.dalton.acsl4.numble13;

import java.util.*;
/**
 * Zachary Caldarola
 * The Dalton School
 * 3055
 * the methods permutations, permutation, and swap were taken from http://bit.ly/QvoJvt
 */
public class ACSL4_Numble13_ZC {
	public static ArrayList<int[]> permutations(int[] a) {
		ArrayList<int[]> ret = new ArrayList<int[]>();
		permutation(a, 0, ret);
		return ret;
	}
	public static void permutation(int[] arr, int pos, ArrayList<int[]> list){
		if(arr.length - pos == 1)
			list.add(arr.clone());
		else
			for(int i = pos; i < arr.length; i++){
				swap(arr, pos, i);
				permutation(arr, pos+1, list);
				swap(arr, pos, i);
			}
	}
	public static void swap(int[] arr, int pos1, int pos2){
		int h = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = h;
	}
	public static void convert(ArrayList<int[]> nums, String a){
		int holder[] = new int[7];
		for(int i = 0; i<a.length(); i++) holder[i] = Integer.parseInt(a.split("")[i+1]);
		nums.add(holder);
	}
	public static void add(ArrayList<ArrayList<Integer>> real, ArrayList<int[]> change){
		for(int i = 0; i<change.size(); i++) {real.add(new ArrayList<Integer>()); for(int j = 0; j<7; j++) real.get(i).add(change.get(i)[j]);}
		change.clear();
	}
	public static void check5(ArrayList<ArrayList<Integer>> a, int size){
		ArrayList<ArrayList<Integer>> hold = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i< a.size(); i++){
			ArrayList<Integer> b = new ArrayList<Integer>(sizeChange(a.get(i), size));
			if(sum(b)%5 == 0) hold.add(b);
		}
		a.clear();
		for(int i = 0; i<hold.size(); i++) a.add(hold.get(i));
	}
	public static List<Integer> sizeChange(ArrayList<Integer> a, int size){
		return a.subList(0, size);
	}
	public static int sum(ArrayList<Integer> a){
		int sum = 0;
		order(a);
		for(int j = 0; j<a.size(); j++) sum += a.get(j);
		return sum;
	}
	public static void largest(ArrayList<ArrayList<Integer>> a){
		int best = 0;
		while(a.size()>1){
			best = Math.max(sum(a.get(0)), sum(a.get(1)));
			if(best == sum(a.get(0))) a.remove(1);
			else a.remove(0);
		}
	}
	public static void order(ArrayList<Integer> a){
		Collections.sort(a, Collections.reverseOrder());
		if(a.get(a.size()-2) == 0){
			a.add(0, 0);
			a.remove(a.size()-2);
		}
	}
	public static int[][] end(ArrayList<Integer> one, ArrayList<Integer> two, ArrayList<Integer> three, int p1, int p2){
		int spot1 = two.indexOf(p1), spot2 = three.indexOf(p2), x = 1, place1 = one.indexOf(p1), place2 = one.indexOf(p2), max= Math.max(two.indexOf(p1), three.indexOf(p2));
		x+= max;
		x+= Math.max(two.size()-two.indexOf(p1)-1, three.size()-1-three.indexOf(p2));
		int end[][] = new int[x][one.size()];
		for(int i=0; i<end.length; i++) {for(int j=0; j<end[0].length;j++) end[i][j] = -1;}
		for(int i=0; i<one.size(); i++) end[max][i] = one.get(i);
		for(int i=0; i<two.size(); i++) end[i+Math.abs(max-spot1)][place1] = two.get(i);
		for(int i=0; i<three.size(); i++) end[i+Math.abs(max-spot2)][place2] = three.get(i);
		return end;
	}
	public static void p(int[][] x)
	{
		for(int i = 0; i<x.length; i++)
		{
			for(int j = 0; j<x[0].length; j++){
				if(x[i][j]!=(-1))System.out.print(x[i][j] + " ");
				else System.out.print("  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String param[] = {};
		ArrayList<int[]> nums = new ArrayList<int[]>();
		ArrayList<int[]> holder = new ArrayList<int[]>();
		String[] hold = input.nextLine().split(", ");
		convert(nums, hold[0]); convert(nums, hold[1]); convert(nums, hold[2]);
		ArrayList<ArrayList<Integer>> first = new ArrayList<ArrayList<Integer>>(), second = new ArrayList<ArrayList<Integer>>(), third = new ArrayList<ArrayList<Integer>>();
		holder = permutations(nums.get(0)); add(first, holder);
		holder = permutations(nums.get(1)); add(second, holder);
		holder = permutations(nums.get(2)); add(third, holder);
		for(int i=0; i<5; i++){
			param = input.nextLine().split(", ");
			ArrayList<ArrayList<Integer>> one = new ArrayList<ArrayList<Integer>>(), two = new ArrayList<ArrayList<Integer>>(), three = new ArrayList<ArrayList<Integer>>();
			one.addAll(first); two.addAll(second); three.addAll(third);
			if(Integer.parseInt(param[0]) != 7) {check5(one, Integer.parseInt(param[0]));}
			if(Integer.parseInt(param[1]) != 7) {check5(two, Integer.parseInt(param[1]));}
			if(Integer.parseInt(param[2]) != 7) {check5(three, Integer.parseInt(param[2]));}
			largest(one); largest(two); largest(three);
			order(one.get(0)); order(two.get(0)); order(three.get(0));
			p(end(one.get(0), two.get(0), three.get(0), Integer.parseInt(param[3]), Integer.parseInt(param[4])));
			one.clear(); two.clear(); three.clear();

//			9768014, 6874514, 9655532
//			7, 7, 5, 7, 6
//			6, 5, 3, 6, 9 
//			5, 6, 4, 6, 9 
//			4, 5, 4, 8, 6 
//			6, 6, 4, 4, 6
		}
	}
}
