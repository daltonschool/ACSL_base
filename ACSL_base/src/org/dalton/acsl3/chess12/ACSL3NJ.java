package org.dalton.acsl3.chess12;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//bug on first test input
//Nick Joseph

public class ACSL3NJ {

	/**
	 * @param args
	 */
	/**
	 * 
	 * @param a - any number
	 * @return the tens digit of that number
	 */
	public static int tens(int a)
	{
		if(a<10) return 0; //if the number is less than 10 it returns zero
		else return Integer.parseInt(Character.toString(String.valueOf(a).charAt(String.valueOf(a).length()-2)));
	}
	/**
	 * 
	 * @param a
	 * @return
	 */
	public static int ones(int a)
	{
		return a%10;
	}
	public static ArrayList<Integer> intersect(ArrayList<Integer> one, ArrayList<Integer> two)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i<one.size(); i++) 
		{
			if(two.contains(one.get(i))) 
			{
				res.add(one.get(i));
			}
		}
		return res;
	}
	public static ArrayList<Integer> targets(int queen)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = -8; i<8; i++) 
		{
			res.add(queen+10*i);
		}
		for(int i = 1; i<9; i++)
		{
			res.add(queen-queen%10 + i);
		}
		for(int i = 0; tens(queen+11*i)<=8 && ones(queen+11*i)<=8; i++)
		{
			res.add(queen+11*i);
		}
		for(int i = 0; tens(queen+11*i)>0 && ones(queen+11*i)>0; i--)
		{
			res.add(queen+11*i);
		}
		for(int i = 0; tens(queen+9*i)<=8 && ones(queen+9*i)>0; i++)
		{
			res.add(queen+9*i);
		}
		for(int i = 0; tens(queen+9*i)>0 && ones(queen+9*i)<=8; i--)
		{
			res.add(queen+9*i);
		}
		return res;
	}
	public static String location(ArrayList<Integer> pieces)
	{
		ArrayList<Integer> board = new ArrayList<Integer>();
		for(int i = 1; i<=8; i++)
		{
			for(int j = 1; j<=8; j++)
			{
				board.add(Integer.parseInt(String.valueOf(i)+String.valueOf(j)));
			}
		}
		for(int i = 0; i<pieces.size(); i++)
		{
			for(int j = 0; j<board.size(); j++)
			{
				if(pieces.get(i)==board.get(j)) 
				{
					board.remove(j); 
					j--;
				}
			}
		}
		ArrayList<Integer> remaining = board;
		for(int i = 0; i<pieces.size(); i++) remaining = intersect(targets(pieces.get(i)), remaining);
		Collections.sort(remaining);
		if(remaining.size()==0) return "NONE";
		else return String.valueOf((remaining.get(0)-remaining.get(0)%10)/10) + ", " + String.valueOf(remaining.get(0)%10);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = new String[5];
		ArrayList<Integer> pieces = new ArrayList<Integer>();
		for(int i = 0; i<5; i++)
		{
			input[i] = scanner.nextLine();
			String[] split = input[i].split(", ");
			for(int j = 0; !split[j].equals("0")||!split[j+1].equals("0"); j+=2) pieces.add(10*Integer.parseInt(split[j])+Integer.parseInt(split[j+1]));
			System.out.println(location(pieces));
			pieces = new ArrayList<Integer>();
		}
	}
}