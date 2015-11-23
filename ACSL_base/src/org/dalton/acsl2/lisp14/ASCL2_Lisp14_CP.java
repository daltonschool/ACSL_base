package org.dalton.acsl2.lisp14;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.*;
import java.util.Arrays;


public class ASCL2_Lisp14_CP {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String[] array = line.split("[\\(\\)]");
		//for(int i = 0; i < array.length; i++){
		//	System.out.println(array[i]);
		//}
		
		for(int i = 0; i < 5; i++){
			String[] type = input.nextLine().split(" "); 
			if(type[0].equals("SORT")){
				System.out.println(sort(array, Integer.parseInt(type[1]), Integer.parseInt(type[2])));
			}
			else if(type[0].equals("REMOVE")){
				System.out.println(remove(array, Integer.parseInt(type[1]), Integer.parseInt(type[2])));
			}
			else if(type[0].equals("MAXIMUM")){
				System.out.println(maximum(array));
			}
			else if(type[0].equals("COUNT")){
				System.out.println(count(array));
			}
			else if(type[0].equals("REVERSE")){
				System.out.println(reverse(array, Integer.parseInt(type[1]), Integer.parseInt(type[2])));
			}
		}
		
		


	}
	
	
	
	
	public static int count(String[] array){	//returns the number of subsets in the given expression
		int length = (array.length - 1)/2;
		
		return length;
		}
	
	
	
	public static String remove(String[] array, int x, int y){
		int j = 0;
		String removed = "";
		String[] organizedone = new String[array.length];
		String[] organized = new String[array.length];
		for(int i = 0; i < array.length; i++){
			organizedone[i] = array[i];
		}
		
		for(int i = x*2; i <=y*2; i++){	//taking out stuff from the array
			organizedone[i] = "";
		}
		for(int i = 0; i < array.length; i++){	//organizing the new array
			if(organizedone[i].length() != 0 && organizedone[i].length() != 1){
				organized[j] = organizedone[i];
				j++;
			}
		}
		
		for(int i = 0; i <= j; i++){
			//if(count(array) - (y-x) == 1){	//QUESTION, WILL YOU REMOVE ALL OF THE TERMS EXCEPT FOR THE FIRST OPERATOR WHAT WOULD YOU WANT ON THAT.
			//	removed = removed + "(";
				//removed = removed + organized[i];
				//removed = removed + ")";
			//}
			//else{
			if(i != j){
			removed = removed + "(" ;
			removed = removed + organized[i];
			}
			
			if(i != 0 && i != j-1){
				removed = removed + ") ";
			}
			if(i == j-1){
				removed = removed + ")";
			}
				
			}
			//}
			
		
		
		
		
		return removed;
	}
	
	
	
	public static String sort(String[] array, int x, int y){
		int j = 0;
		String best = "";
		int counter = 0;
		String sort = "";
		
		String[] organized = new String[array.length];
		for(int i = 0; i < array.length; i++){	//organizing the new array
			if(array[i].length() != 0 && array[i].length() != 1){
				organized[j] = array[i];
				j++;
			}
		}
		String[] tester = new String[(y-x+1)];
		for(int i = x; i <= y; i++){//check this if there is bugs
			
			tester[i-x] = organized[i];
			 
		}
		Arrays.sort(tester);
		
		
		
		for(int i = x; i <= y; i++){
			organized[i] = tester[i-x];
		}
		
		for(int i = 0; i <= j; i++){
			if(i != j){
			sort = sort + "(" ;
			sort = sort + organized[i];
			}
			
			if(i != 0 && i != j-1){
				sort = sort + ") ";
			}
			if(i == j-1){
				sort = sort + ")";
			}
			
		}
		return sort;
	}
	
	/**
	 * RETURNS THE SUBSET WITH THE MAXIMUM THINGS
	 * @param array
	 * @return
	 */
	public static String maximum(String[] array){
		int j = 0;
		String best = "";
		int counter = 0;
		String[] organized = new String[array.length];
		for(int i = 0; i < array.length; i++){	//organizing the new array
			if(array[i].length() != 0 && array[i].length() != 1){
				organized[j] = array[i];
				j++;
			}
		}
		
		for(int i = 0; i < j; i++ ){//if bugs check i <= j
			String[] max = organized[i].split(" ");
			
			if(max.length > counter){
				best = organized[i];
				counter = max.length;
			}
			
		}
		
		return "(" + best + ")";
	}
	
	
	
	public static String reverse(String[] array, int x, int y){
		int j = 0;
		String reversed = "";
		String count = "";
		String[] organized = new String[array.length];
		
		
		for(int i = 0; i < array.length; i++){	//organizing the new array
			if(array[i].length() != 0 && array[i].length() != 1){
				organized[j] = array[i];
				j++;
			}
		}
		
		for(int i=0; i < (y-x)/2+1; i++){	//switching the second thing of subsets
			count = organized[i+x];
			organized[i+x] = organized[y-(i)];
			organized[y-(i)] = count;
		}
		
		for(int i = x; i <= y; i++){			//THIS IS WRONG. MAKE THE ELEMENTS ON THE INSIDE REVERSE AS WELL
			String[] subsets = organized[i].split(" ");
			organized[i] = "";
			for(int w = 1; w < ((subsets.length-1)/2)+1; w++){
				count = subsets[w];
				subsets[w] = subsets[subsets.length-w];
				subsets[subsets.length-w] = count;
				
				
			}
			for(int w = 0; w < subsets.length; w++){
				organized[i] = organized[i] + subsets[w];
				if(w != subsets.length-1){
					organized[i] = organized[i] + " ";
				}
			}
			
			
		}
		
		
		
		for(int i = 0; i <= j; i++){
			if(i != j){
			reversed = reversed + "(" ;
			reversed = reversed + organized[i];
			}
			
			if(i != 0 && i != j-1){
				reversed = reversed + ") ";
			}
			if(i == j-1){
				reversed = reversed + ")";
			}
			
		}
		
		return reversed;
	}
	
	
}
