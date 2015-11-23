package org.dalton.acsl2.lisp14;
/* Liam Glass
 * The Dalton School
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class ACSL2_Lisp14_LG {
	public static String revEntries(String s){
		String ret = "";
		int i1 = s.indexOf(' ');
		int i2 = s.indexOf(')');
		ret = s.substring(0, i1+1);
		String[] nums = s.substring(i1+1, i2).split(" ");
		int [] nnums = new int [nums.length];
		for (int i = 0; i < nums.length; i++) {
			nnums[i] = Integer.parseInt(nums[i]);
		}
		for (int k = 0; k < nnums.length/2; k++) {
            int temp = nnums[k];
            nnums[k] = nnums[nnums.length-(1+k)];
            nnums[nnums.length-(1+k)] = temp;
          }
		for (int i = 0; i < nnums.length; i++) {
			if(i<nnums.length-1){
				ret += nnums[i];
				ret+= " ";
			}
			else ret += nnums[i];
		}
		ret += ")";
		return ret;
	}
	public static String max(ArrayList<String>le){
		String ret = "uh oh";
		int [] m = new int[le.size()];
		for (int i = 1; i < le.size(); i++) {
			for (int j = 0; j < le.get(i).length()-1; j++) {
				if(le.get(i).charAt(j) >= 48 && le.get(i).charAt(j) <= 57 && (le.get(i).charAt(j+1) == ' ' || le.get(i).charAt(j+1) == ')')){
					m[i]++;
				}
			}
		}
		int ind = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(m[j]>m[ind]){
					ind = j;
				}
			}
		}
		ret = le.get(ind);
		return ret;
	}
	public static void sort(ArrayList<String> le, int i1, int i2){
		ArrayList<String>temp = (ArrayList<String>) le.clone();
		for (int j = i1; j < i2+1; j++) {
			for (int i = i1; i < i2+1; i++) {
				if(le.get(j).charAt(1)>le.get(i).charAt(1)){
					Collections.swap(temp, j, i);
				}
			}
		}
		printAl(temp);
	}
	public static void remove(ArrayList<String> le, int i1, int i2){
		ArrayList<String>temp = (ArrayList<String>) le.clone();
		int c = 0;
		for (int i = i1; i < i2+1; i++) {
			temp.remove(i-c);
			c++;
		}
		printAl(temp);
	}
	public static void printAl(ArrayList<String> le){
		System.out.print(le.get(0).substring(0, le.get(0).indexOf(' ')) + " ");
		for (int i = 1; i < le.size(); i++) {
			if(i != le.size()-1){
				System.out.print(le.get(i) +" ");
			}
			else System.out.print(le.get(i));
		}
		System.out.println(")");
	}
	public static void reverse(ArrayList<String> le, int i1, int i2){
		ArrayList<String>temp = (ArrayList<String>) le.clone();
		int h1 = i1;
		int h2 = i2;
		while(i1!=i2 && i1<i2){
			Collections.swap(temp, i1, i2);
			i1++;
			i2--;
		}
		for (int i = h1; i < h2+1; i++) {
			temp.set(i,revEntries(temp.get(i)));
		}
		printAl(temp);
	}
	public static int count(ArrayList<String> le){
		int r = 0;
		for (int i = 1; i < le.size(); i++) {
			r++;
		}
		return r;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String lisp_inp = scan.nextLine();
		String opp_inp;
		ArrayList <String> lispy = new ArrayList();
		lispy.clear();
		lispy.add(lisp_inp);
		int s = -1;
		int e = -1;
		for (int i = 1; i < lisp_inp.length(); i++) {
			if(lisp_inp.charAt(i) == '(') s = i;
			else if(lisp_inp.charAt(i) == ')') e = i;
			if(s > 0 && e > 0){
				lispy.add(lisp_inp.substring(s, e+1));
				s = 0;
				e = 0;
			}
		}
		String [] inps = new String[3];
		for (int j = 0; j < 5; j++) {
			opp_inp = scan.nextLine();
			if(opp_inp.equalsIgnoreCase("COUNT")) System.out.println(count(lispy));//count
			else if (opp_inp.equalsIgnoreCase("MAXIMUM")) System.out.println(max(lispy));//max
			else {
				inps = opp_inp.split(" ");
				if(inps[0].equalsIgnoreCase("SORT")) sort(lispy,Integer.parseInt(inps[1]), Integer.parseInt(inps[2]));//sort
				else if(inps[0].equalsIgnoreCase("REVERSE")) reverse(lispy,Integer.parseInt(inps[1]), Integer.parseInt(inps[2]));//reverse
				else remove(lispy,Integer.parseInt(inps[1]), Integer.parseInt(inps[2]));//remove
			}
		}
		scan.close();
	}
}