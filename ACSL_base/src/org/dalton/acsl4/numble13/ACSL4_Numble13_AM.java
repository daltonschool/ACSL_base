package org.dalton.acsl4.numble13;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * ACSL 4 Program. 
 * 3305 
 * 
 * @author Andrew M.
 * @version 1.0 
 */
public class ACSL4_Numble13_AM { 
	static int cross_one;
	static int cross_two; 
	static int[] word_lengths;  

	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); 
		String raw_input = input.nextLine(); 
		String[] tiles = raw_input.trim().split(", "); 
		word_lengths = new int[3];
		for (int bigloop = 0; bigloop < 5; bigloop++) {
			String[] data = input.nextLine().split(", ");
			for (int ii = 0; ii < word_lengths.length; ii++) 
				word_lengths[ii] = Integer.valueOf(data[ii].trim());

			ArrayList<List<Integer>> inputs = new ArrayList<List<Integer>>(); 
			cross_one = Integer.valueOf(data[3].trim()); 
			cross_two = Integer.valueOf(data[4].trim()); 
			inputs.clear(); 
			inputs.add(new ArrayList<Integer>());
			inputs.add(new ArrayList<Integer>()); 
			inputs.add(new ArrayList<Integer>()); 
			
			List<String> horf = new ArrayList<String>(); 
			List<String> veronef = new ArrayList<String>(); 
			List<String> vertwof = new ArrayList<String>();

			for (int ii = 0; ii < tiles[1].length(); ii++) 
				inputs.get(1).add(Integer.valueOf(tiles[1].trim().charAt(ii) + "")); 
			ArrayList<ArrayList<Integer>> integers = new ArrayList<ArrayList<Integer>>();
			integers.clear();
			for (int ii = 0; ii < tiles[0].length(); ii++) 
				inputs.get(0).add(Integer.valueOf(tiles[0].trim().charAt(ii) + "")); 
			integers.add(new ArrayList<Integer>()); 
			integers.add(new ArrayList<Integer>()); 
			int index = 0; 
			integers.add(new ArrayList<Integer>()); 

			for (int ii = 0; ii < tiles[2].length(); ii++) 
				inputs.get(2).add(Integer.valueOf(tiles[2].charAt(ii) + "")); 

			ArrayList<List<List<String>>> perms = new ArrayList<List<List<String>>>(); 
			perms.clear(); 

			perms.add(PermuteAM.permutations(inputs.get(0), index)); 
			for (List<String> l : perms.get(0)) 
				if(PermuteAM.sum(l) > PermuteAM.sum(horf) && (PermuteAM.sum(l) % 5 == 0) && l.get(0).split(",").length == word_lengths[0] && l.get(0).contains(""+cross_one) && l.get(0).contains(""+cross_two)) 
					horf = l; 
			
			perms.add(PermuteAM.permutations(inputs.get(1), index)); 
			for (List<String> l : perms.get(1)) 
				if(PermuteAM.sum(l) > PermuteAM.sum(veronef) && (PermuteAM.sum(l) % 5 == 0) && l.get(0).split(",").length == word_lengths[1] && l.get(0).contains(""+cross_one)) 
					veronef = l; 
			
			perms.add(PermuteAM.permutations(inputs.get(2), index)); 
			for (List<String> l : perms.get(2)) 
				if(PermuteAM.sum(l) > PermuteAM.sum(vertwof) && (PermuteAM.sum(l) % 5 == 0) && l.get(0).split(",").length == word_lengths[2] && l.get(0).contains(""+cross_two)) 
					vertwof = l; 
			try {
				for (int ii = 0; ii < horf.get(index).split(",").length; ii++) 
					integers.get(0).add(Integer.valueOf(horf.get(0).split(",")[ii] + "")); 
				for (int ii = 0; ii < veronef.get(index).split(",").length; ii++) 
					integers.get(1).add(Integer.valueOf(veronef.get(0).split(",")[ii] + "")); 
				for (int ii = 0; ii < vertwof.get(index).split(",").length; ii++) 
					integers.get(2).add(Integer.valueOf(vertwof.get(0).split(",")[ii] + "")); 
				for (int ii = 0; ii < integers.size(); ii++) 
					Collections.sort(integers.get(ii)); 
				scrabbleprint(integers.get(0), integers.get(1), integers.get(2));
			}
			catch(Exception e) { }
		}
	}

	public static void scrabbleprint(ArrayList<Integer> hoz, ArrayList<Integer> v1, ArrayList<Integer> v2){
		int above = 0, below = 0; 
		//reverse the lists in descending order
		Collections.reverse(hoz); 
		Collections.reverse(v1);
		Collections.reverse(v2);

		if(v2.size() - v2.indexOf(cross_two) < v1.size() - v1.indexOf(cross_one))
			below = v1.size() - v1.indexOf(cross_one) - 1; 
		else 
			below = v2.size() - v2.indexOf(cross_two) - 1; 
		if(v1.indexOf(cross_one) > v2.indexOf(cross_two))
			above = v1.indexOf(cross_one); 
		else 
			above = v2.indexOf(cross_two);
		int rowNum = (above+below); //add 1 for horizontal string
		rowNum ++; //add 1 for horizontal row 

		String[][] game = new String[rowNum][hoz.toArray().length]; 
		for (int ii = 0; ii < game.length; ii++) 
			for (int jj = 0; jj < game[0].length; jj++) 
				game[ii][jj] = "_"; //_ for empty 
		int v2_start_y = above-v2.indexOf(cross_two), v1_start_y = above-v1.indexOf(cross_one); 

		for (int ii = 0; ii < v1.size(); ii++) 
			game[v1_start_y+ii][hoz.indexOf(cross_one)] = String.valueOf(v1.get(ii)); 
		for (int ii = 0; ii < v2.size(); ii++) 
			game[v2_start_y+ii][hoz.indexOf(cross_two)] = String.valueOf(v2.get(ii)); 
		for (int ii = 0; ii < hoz.size(); ii++) 
			game[above][ii] = hoz.get(ii) + "" ; 
		PermuteAM.print(game); 
	}
}

class PermuteAM {
	//BEST powerset code (perfect) http://stackoverflow.com/questions/4640034/calculating-all-of-the-subsets-of-a-set-of-numbers
	static List<List<String>> permutations(final List<Integer> values, int ind) {
		if (ind == values.size()) 
			return new ArrayList<>();
			int thisVal = values.get(ind);
			List<List<String>> subset = permutations(values, ind + 1);
			List<List<String>> returnList = new ArrayList<>();
			returnList.add(Arrays.asList(String.valueOf(thisVal)));
			returnList.addAll(subset);
			for (final List<String> subsetValues : subset) 
				for (final String subsetValue : subsetValues) 
					returnList.add(Arrays.asList(thisVal + "," + subsetValue));
			return returnList;
	}

	//essentially http://stackoverflow.com/questions/16242733/sum-all-the-elements-java-arraylist but very simple 
	public static int sum(List<String> list){
		int tot = 0; 
		for(int ii = 0; ii < list.size(); ii ++){
			String str = list.get(ii); 
			String[] split = str.split(","); 
			for (int jj = 0; jj < split.length; jj++) {
				tot += Integer.valueOf(split[jj]); 
			}
		}
		return tot;
	}

	//http://stackoverflow.com/questions/16789504/printing-out-2d-array-elements-in-java 
	public static void print(String[][] plants){
		for (int ii = 0; ii < plants.length; ii++) 
			for (int jj = 0; jj < plants[0].length; jj++) 
				if(plants[ii][jj] == "_") 
					plants[ii][jj] = " "; //replace -'s with spaces to print 

		for(int ii = 0; ii < plants.length; ii++){
			for(int jj = 0; jj < plants[ii].length; jj++)
				System.out.print(plants[ii][jj] + " ");
			System.out.println();
		}
	}
}