package org.dalton.acsl4.numble13;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class ACSL4_Numble13_AW {

	/* 
	 * Alexa Wojak
	 * The Dalton School
	 * 3305
	 */

	public static int factorial (int n)
	{
		int result = 1;
		for (int i = 1; i < n+1; i++) {
			result = result * i;
		}
		return result;
	}

	public static int choose_num (int n, int k)
	{
		return (factorial(n)/(factorial(k)*factorial(n-k)));
	}

	public static int [] sorter (int[] word)
	{
		Arrays.sort(word);
		int [] temp_one = new int [word.length];
		for (int i = 0; i < temp_one.length; i++) {
			temp_one[word.length-1-i] = word[i];
		}
		for (int j = 0; j < temp_one.length; j++) {
			word[j] = temp_one[j];
		}


		int [] temp = new int [word.length];
		if(word[word.length-1] == 0&& word[word.length-2] == 0)
		{
			temp[0] = 0;
			for (int i = 1; i < temp.length; i++) {
				temp[i] = word[i-1];
			}
			for (int i = 0; i < temp.length; i++) {
				word[i] = temp[i];
			}
		}
		return word;
	}

	//arrays all the perms and their sums
	public static int [][] perms (int [] word, int num)
	{
		int [][] combs = new int [choose_num(7,num)][num+1];

		List<Integer> ints = new ArrayList<Integer>();
		String str_temp = new String();

		for (int i = 0; i < word.length; i++) {
			ints.add(word[i]);
		}

		int counter = 0;
		final List<List<String>> allSubsets = PowersetAW.powerSet(ints, 0);    
		for (List<String> subsets : allSubsets) {
			for (int i = 0; i < subsets.size(); i++) {
				str_temp = subsets.get(i);
				//System.out.println(str_temp);

				if((str_temp.length() == 1 && num == 1) || (((str_temp.length()+1)/2) == num))
				{
					for (int j = 0; j < str_temp.length(); j+=2) {
						combs[counter][j/2] = Integer.parseInt(str_temp.substring(j,j+1));
					}
					counter ++;
				}
			}
		}

		for (int i = 0; i < combs.length; i++) {
			for (int j = 0; j < combs[0].length; j++) {
			}
		}

		int last = 0;
		for (int i = 0; i < combs.length; i++) {
			last = 0;
			for (int j = 0; j < num; j++) {
				last += combs[i][j];
			}
			combs[i][num] = last;
		}
		return combs;
	}

	//finds the word with the highest sum that also mods
	public static int [] pick (int [][] combs)
	{
		int[] word = new int [combs[0].length-1];
		int sum = 0;
		for (int i = 0; i < combs.length; i++) {
			if(combs[i][combs[0].length-1] > sum && combs[i][combs[0].length-1]%5==0)
			{
				sum = combs[i][combs[0].length-1];
				for (int j = 0; j < word.length; j++) {
					word[j] = combs[i][j];
				}
			}
		}
		return word;
	}

	//arranges the words into a board
	public static int[][] arrange (int[] one, int [] two, int[] three, int[] info)
	{
		int above = 0;
		int below = 0;

		for (int i = 0; i < two.length; i++) {
			if (two[i] == info[3]) {
				above = i;
				below = two.length-above-1;
				break;
			}
		}
		for (int i = 0; i < three.length; i++) {
			if(three[i] == info[4])	{
				if(i>above){
					above = i;
				}
				if(three.length-i-1 > below){
					below = three.length-i-1;
				}
				break;
			}
		}
		int [][] board = new int [below+above+1][one.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = -1;
			}
		}
		for (int i = 0; i < one.length; i++) {
			board[above][i] = one[i]; 
		}
		int temp_use_a = 0;
		int temp_use_b = 0;

		//two
		for (int i = 0; i < one.length; i++) {
			if(one[i] == info[3]) {
				temp_use_a = i;
				break;
			}
		}
		for (int i = 0; i < two.length; i++) {
			if(two[i] == info[3]) {
				temp_use_b = i;
				break;
			}
		}
		for (int i = 0; i < two.length; i++) {
			board[above-temp_use_b+i][temp_use_a] = two[i];
		}

		//three
		for (int i = 0; i < one.length; i++) {
			if(one[i] == info[4] && i!=temp_use_a) {
				temp_use_a = i;
				break;
			}
		}
		for (int i = 0; i < three.length; i++) {
			if(three[i] == info[4]) {
				temp_use_b = i;
				break;
			}
		}

		for (int i = 0; i < three.length; i++) {
			board[above-temp_use_b+i][temp_use_a] = three[i];
		}

		return board;
	}

	public static void print (int [][] board)
	{
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] != -1) System.out.print(board[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	public static void main (String [] args)
	{

		Scanner input = new Scanner(System.in);
		String stuff = input.nextLine();
		String [] data = stuff.split(", ");

		//parse the words into ints
		//sort the words into numerical order
		int [] one = new int [7];
		int [] two = new int [7];
		int [] three = new int [7];

		for (int i = 0; i <7; i++) {
			one[i] = Integer.parseInt(data[0].substring(i, i+1));
			two[i] = Integer.parseInt(data[1].substring(i, i+1));
			three[i] = Integer.parseInt(data[2].substring(i, i+1));
		}

		int counter = 0;

		while(counter < 5)
		{
			stuff = input.nextLine();
			String [] info_str = stuff.split(", ");
			int [] info = new int [5];
			for (int i = 0; i < info_str.length; i++) {
				info[i] = Integer.parseInt(info_str[i]);
			}

			int [] word_one = new int [info[0]];
			int [] word_two = new int [info[1]];
			int [] word_three = new int [info[2]];

			word_one = pick(perms(one, info[0]));
			word_two = pick(perms(two, info[1]));
			word_three = pick(perms(three, info[2]));

			word_one = sorter(word_one);
			word_two = sorter(word_two);
			word_three = sorter(word_three);			
			
			print(arrange(word_one, word_two, word_three, info));

			counter++;
		}

	}//main

}//class

class PowersetAW {

    public static void main(String[] args) {
     //   final List<List<String>> allSubsets = powerSet(Arrays.asList(1, 2, 3, 4), 0);
       // for (List<String> subsets : allSubsets) {
         //   System.out.println(subsets);
        //}
    }

    static List<List<String>> powerSet(final List<Integer> values, int index) {
        if (index == values.size()) {
            return new ArrayList<>();
        }
        int val = values.get(index);
        List<List<String>> subset = powerSet(values, index + 1);
        List<List<String>> returnList = new ArrayList<>();
        returnList.add(Arrays.asList(String.valueOf(val)));
        returnList.addAll(subset);
        for (final List<String> subsetValues : subset) {
            for (final String subsetValue : subsetValues) {
                returnList.add(Arrays.asList(val + "," + subsetValue));
            }
        }
        return returnList;
    }
}
