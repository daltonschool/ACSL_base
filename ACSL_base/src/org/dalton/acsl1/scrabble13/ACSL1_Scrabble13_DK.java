package org.dalton.acsl1.scrabble13;
import java.util.*;
/**
 * Deven Kirschenbaum
 * The Dalton School
 * #3305
 */
public class ACSL1_Scrabble13_DK {
	public static int[] value (String[] letter_input)
	{
		int[] letter_value = new int[4];
		for (int i = 0; i < letter_input.length; i++) {
			if(letter_input[i].equals("A") || letter_input[i].equals("E"))letter_value[i] = 1;
			if(letter_input[i].equals("D") || letter_input[i].equals("R"))letter_value[i] = 2;
			if(letter_input[i].equals("B") || letter_input[i].equals("M"))letter_value[i] = 3;
			if(letter_input[i].equals("V") || letter_input[i].equals("Y"))letter_value[i] = 4;
			if(letter_input[i].equals("J") || letter_input[i].equals("X"))letter_value[i] = 8;
		}
		return letter_value;
	}
	public static int total_val(int[] letter_value, int[] position)
	{
		int[] mult_3 = {3,9,15,21,27,33,39};
		int[] mult_5 = {5,10,20,25,30,35,40};
		int[] mult_7 = {7,14,28};
		int[] mult_8 = {8,16,24,32};
		for (int i = 0; i < mult_3.length; i++) for (int j = 0; j < position.length; j++) if(position[j] == mult_3[i]) letter_value[j] = letter_value[j]*2;
		for (int i = 0; i < mult_5.length; i++) for (int j = 0; j < position.length; j++) if(position[j] == mult_5[i]) letter_value[j] = letter_value[j]*3;
		for (int i = 0; i < position.length; i++) {
			for (int j = 0; j < mult_7.length; j++) {
				if(position[i] == mult_7[j])
				{
					letter_value[0] = (letter_value[0]+letter_value[1]+letter_value[2]+letter_value[3])*2;
					letter_value[1] = 0;
					letter_value[2] = 0;
					letter_value[3] = 0;
				}
			}
		}
		for (int i = 0; i < mult_8.length; i++) {
			for (int j = 0; j < position.length; j++) {
				if(position[j] == mult_8[i])
				{
					letter_value[0] = (letter_value[0]+letter_value[1]+letter_value[2]+letter_value[3])*3;
					letter_value[1] = 0;
					letter_value[2] = 0;
					letter_value[3] = 0;
				}
			}
		}
		int total_value = letter_value[0]+letter_value[1]+letter_value[2]+letter_value[3];
		return total_value;
	}
	public static int[] direction(int position, String direction)
	{
		int[] position_num = new int[4];
		position_num[0] = position;
		if(direction.equals("H"))for (int i = 1; i < position_num.length; i++) position_num[i] = position_num[i-1]+1;
		if(direction.equals("V"))for (int i = 1; i < position_num.length; i++) position_num[i] = position_num[i-1]+10;
		return position_num;
	}
	public static void main(String[] args) {
		Scanner total_input = new Scanner (System.in);
		String[] input = total_input.nextLine().replaceAll("\\s","").split(",");
		while(true)
		{
			int[] letter_val = new int[4];
			String[] pos_input = total_input.nextLine().replaceAll("\\s","").split(",");
			int[] position_length1 = direction(Integer.parseInt(pos_input[0].trim()), pos_input[1].trim());
			int[] position_length2 = direction(Integer.parseInt(pos_input[2]), pos_input[3]);
			int[] position_length3 = direction(Integer.parseInt(pos_input[4]), pos_input[5]);
			int[] values = new int[3];
			letter_val = value(input);
			values[0] = total_val(letter_val, position_length1);
			letter_val = value(input);
			values[1] = total_val(letter_val, position_length2);
			letter_val = value(input);
			values[2] = total_val(letter_val, position_length3);
			Arrays.sort(values);
			System.out.println(values[2]);
		}
	}
}


