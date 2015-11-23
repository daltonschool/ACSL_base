package org.dalton.acsl2.lisp14;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class ACSL2_Lisp14_EC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String full = "";
		String [] command = new String [5];
//d
		full = scan.nextLine();
		full = full.replace('(', ',');
		full = method(full);

		//System.out.println(full);
		String [] parts = full.split(" ,");
		int number = parts.length;

		command[0] = scan.nextLine();
		command[1] = scan.nextLine();
		command[2] = scan.nextLine();
		command[3] = scan.nextLine();
		command[4] = scan.nextLine();

		for (int i = 0; i <5; i++){
			if (command[i].contains("COUNT")){
				System.out.println(count(full));
			}
			if (command[i].contains("REMOVE")){
				int start = 0;
				int end = 0;
				String [] smallparts = command[i].split(" ");
				start = Integer.parseInt(smallparts[1]);
				end = Integer.parseInt(smallparts[2]);
				System.out.println(remove(full, start, end));
			}
			if (command[i].contains("SORT")){
				int start = 0;
				int end = 0;
				String [] smallparts = command[i].split(" ");
				start = Integer.parseInt(smallparts[1]);
				end = Integer.parseInt(smallparts[2]);
				System.out.println(sort(full, start, end));
			}
			if (command[i].contains("REVERSE")){
				int start = 0;
				int end = 0;
				String [] smallparts = command[i].split(" ");
				start = Integer.parseInt(smallparts[1]);
				end = Integer.parseInt(smallparts[2]);
				System.out.println(reverse(full, start, end));
			}
			if (command[i].contains("MAXIMUM")){
				System.out.println("("+maximum(full));
			}

		} //closes for loop
	} //closes main


	//Print the number of sublists in the given expression.
	public static int count(String full){
		String [] parts = full.split(" ,");
		int numbersub = parts.length -1;
		return numbersub;
	}

	//Print the expression that results when the elements between the Jth and Kth sublists inclusive are eliminated. 
	// J and K will be positive integers in increasing order.
	public static String remove(String full, int start, int end){
		String remove = "";
		String [] parts = full.split(" ,");
		for (int i = 0; i <parts.length; i++){
			if (i <start || i> end){
				if (i>0) remove = remove.concat(" ,"+parts[i]);
				else remove = remove.concat(parts[i]);
			}
		}
		remove = remove.replace(',', '(');
		remove = remove.concat(")");
		return remove;
	}

	//Print the expression that results when the elements between the Jth and Kth sublists inclusive are sorted alphabetically based on their operation. J and K will be positive integers in increasing order.
	public static String sort(String full, int start, int end){
		String sort = "";
		String [] parts = full.split(" ,");
		String [] smallerparts = new String [(end-start)+1];
		for (int i = 0; i<smallerparts.length; i++){
			smallerparts[i] = " ,"+ parts [start+i];
		}
		Arrays.sort(smallerparts);
		for (int i = 0; i <parts.length; i++){
			if (i >=start && i<= end){
				sort = sort.concat(smallerparts[(i-start)]);
			}
			else{
				if (i>0) sort = sort.concat(" ,"+parts[i]);
				else sort = sort.concat(parts[i]);
			}
		}
		sort = sort.replace(',', '(');
		sort = sort.concat(")");
		return sort;
	}

	//Print the expression that results when the elements between the Jth and Kth sublists inclusive are reversed. J and K will be positive integers in increasing order.
	public static String reverse(String full, int start, int end){
		String reverse = "";
		String [] parts = full.split(" ,");
		int number = end-start;

		for (int j = start; j<= end; j++){
			parts[j] = method(parts[j]);
			String [] smallerparts = parts[j].split(" ");
			int number2 = smallerparts.length -2;
			parts[j] = "";
			for (int i = 0; i <smallerparts.length; i++){
				if (i >=1 && i<= smallerparts.length){
					parts[j] = parts[j].concat(" "+smallerparts[i+number2]);
					number2--;
					number2--;
				}
				else{
					if (i>0) parts[j] = parts[j].concat(" ,"+smallerparts[i]);
					else parts[j] = parts[j].concat(smallerparts[i]);
				}
			}
			parts[j] = parts[j].concat(")");
		}


		/**for (int j = start; j<= end; j++){
			smallerparts = parts[j].split(" ");
			number2 = smallerparts.length-1;
			for (int k = 1; k<smallerparts.length;k++){
				smallerparts[k] = smallerparts[k];
				number2 --;
				number2 --;
			} 	
			parts[j] = "";
			for (int a = 0; a < smallerparts.length-1; j++){
				parts[j] = parts[j].concat(" "+smallerparts[a]);
				System.out.println(a);
			}
		} **/

		for (int i = 0; i <parts.length; i++){
			if (i >=start && i<= end){
				reverse = reverse.concat(" ,"+parts[i+number]);
				number--;
				number--;
			}
			else{
				if (i>0) reverse = reverse.concat(" ,"+parts[i]);
				else reverse = reverse.concat(parts[i]);
			}
		}
		reverse = reverse.replace(',', '(');
		reverse = reverse.concat(")");
		return reverse;
	}


	//Print the sublist with the most arguments.
	public static String maximum(String full){
		String max = "";	
		int maxval = 0; //maximum value
		int location = 0; //location of the maximum value

		String [] parts = full.split(" ,");
		int [] nums = new int [parts.length];
		for (int i = 0; i<parts.length; i++){
			String [] smallerparts = parts[i].split(" ");
			nums[i] = smallerparts.length;
		}

		for (int i = 0; i <nums.length;i++){
			if (nums[i]>maxval){
				maxval = nums[i];
				location = i;
			}
		}
		max = parts[location];
		max = max.replace(',', '(');
		return max;
	}

	public static String method(String str) {
		return str.substring(0,str.length()-1);
	}



}
