package org.dalton.acsl3.senet09;

/*Author: Ivo Crnkovic-Rubsamen
 * School: The Dalton School
 * School Code: Unknown
 * Changelog: None
 */
import java.util.*;
public class senet {
	public static String [] board = new String [36];
	public static boolean changed = false;
	public static boolean debug = false;
	public static String black_one = "";
	public static String white_one = "";
	public static String [] who_cant_move = new String [20];
	public static void wipe ()
	{
		for(int i = 0; i < who_cant_move.length; i++)
		{
			who_cant_move[i] = "*";
		}
	}
	public static String find_places (String black_one, String white_one)
	{
		int black_place = 0;
		int white_place = 0;
		String black_final = "";
		String white_final = "";
		boolean found_black = false;
		boolean found_white = false;
		for (int i = 1; i < board.length; i++)
		{
			if (board[i].equals(black_one))
			{
				black_place = i;
				found_black = true;
				if (debug)
				System.out.println("Got into the Black");
			}
		}
		for (int i = 1; i < board.length; i++)
		{
			if (board[i].equals(white_one))
			{
				white_place = i;
				found_white = true;
				if (debug)
				System.out.println("Got into the White");
			}
		}
		
		if (found_black == false)
		black_final = "DONE";
		else
		black_final = "" + black_place;
		if (found_white == false)
		white_final = "DONE";
		else
		white_final = "" + white_place;
		
		if(black_one.equals("99"))
		black_final = "NO VALID MOVES";
		
		if(white_one.equals("99"))
		white_final = "NO VALID MOVES";
		
		
		
		return (black_final + ", " + white_final);
	}
	public static void stepthrough (String color, int [] rolls, int rollnum)
	{
		int place = 0;
		int move = 0;
		move = who_moves(color, rolls[rollnum]);
		if (debug)
		System.out.println("this is the move " + move);
		if (move != 99)
		{
			move_piece(move, rolls[rollnum], color);
		}
		else
		{
			if (color.equals("b"))
			black_one = "99";
			else
			white_one = "99";
		}
		if (debug)
		print_board();
		end_state_check();
		if (debug)
		print_board();
		wipe();
	}
	public static void print_board ()
	{
		for (int i = 1; i < board.length; i++)
		{
			System.out.print(board[i] + " ");
		}
		System.out.println("");
	}
	public static void end_state_check ()
	{
		String temp = "";
		if (!(board[27].equals("*")))
		{
			if (changed)
			{
				if (board[27].substring(0,1)!= board[15].substring(0, 1))
				{
					temp = board[15];
					board[15] = board[27];
					board[27] = temp;
				}
			}
		}
		for (int i = 31; i < board.length; i++)
		{
			board[i] = "*";
		}
	}
	public static boolean check_if_in_array (String query)
	{
		for (int i = 0; i < who_cant_move.length; i++)
		{
			if (debug)
			System.out.println("We got in here with an I value of " + i);
			if (who_cant_move[i].equals(query))
			{
				return true;
			}
		}
		return false;
	}
	public static void add_to_end_of_array (String query)
	{
		boolean gogo = true;
		if (debug)
		System.out.println("This is who_cant_move.length: " + who_cant_move.length);
		for (int i = 0; i < who_cant_move.length && gogo; i++)
		{
			if (debug)
			System.out.println("Got in here with I as: " + i);
			if (who_cant_move[i].equals("*"))
			{
				who_cant_move[i] = query;
				gogo = false;
			}
		}
		if (debug)
		{
			for (int i = 0; i < who_cant_move.length; i++)
			{
				System.out.println(who_cant_move[i]);
			}
		}
	}
	public static int who_moves (String color, int roll)
	{
		for (int i = 31; i >= 0; i--)
		{
			if (debug)
			System.out.println("we got in here with an I value of " + i);
			if (board[i].substring(0, 1).equals(color))
			{
				if (debug)
				System.out.println("we got in here with an I value of " + i);
				if (check_if_in_array( board[i]) == false)
				{
					if (board[i + roll].substring(0,1) == color)
					{	
						add_to_end_of_array (board[i]);
						return who_moves (color, roll);
					}
					else if (i + roll == 30 && (!(board[30].equals("*"))))
					{
						add_to_end_of_array (board[i]);
						return who_moves (color, roll);
					}
					else if (27 <= i && i <= 29 && i + roll != 31)
					{
						add_to_end_of_array (board[i]);
						return who_moves (color, roll);
					}
					else
					{
						return i;
					}
				}
			}
		}
		return 99;
	}
	public static void move_piece (int piece_position, int roll, String color)
	{
		int destination = roll + piece_position;
		if (piece_position < 26 && (destination) > 26)
		{
			destination = 26;
		}
		String temp = "";
		temp = board[destination];
		board[destination] = board[piece_position];
		board[piece_position] = temp;
		if (color.equals("b"))
			black_one = board[destination];
		else
			white_one = board[destination];
		
		if (destination == 27)
		{
			changed = true;
		}
	}
	public static void main(String[] args)
	{
		int move = 0;
		for (int i = 0; i < board.length; i++)
		{
			board[i] = "*";
		}
		for (int i = 0; i < who_cant_move.length; i++)
		{
			who_cant_move[i] = "*";
		}
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String [] split_input = input.split(", ");
		for (int i = 1; i < split_input.length; i++)
		{
			board[Integer.parseInt(split_input[i])] = ("b" + i); 
		}
		input = in.nextLine();
		split_input = input.split(", ");
		for (int i = 1; i < split_input.length; i++)
		{
			board[Integer.parseInt(split_input[i])] = ("w" + i); 
		}
		int [] rolls = new int [10];
		input = in.nextLine();
		split_input = input.split(", ");
		for (int i = 0; i < split_input.length; i++)
		{
			rolls[i] = Integer.parseInt(split_input[i]); 
		}
		if (debug)
		print_board();
		if (debug)
		System.out.print("these are the rolls: ");
		for (int i = 0; i < rolls.length; i++)
		{
			if (debug)
			System.out.print(rolls[i] + " ");
		}
		if (debug)
		System.out.println("");
		stepthrough ("b", rolls, 0);
		stepthrough ("w", rolls, 1);
		System.out.println(find_places(black_one, white_one));
		stepthrough ("b", rolls, 2);
		stepthrough ("w", rolls, 3);
		System.out.println(find_places(black_one, white_one));
		stepthrough ("b", rolls, 4);
		stepthrough ("w", rolls, 5);
		System.out.println(find_places(black_one, white_one));
		stepthrough ("b", rolls, 6);
		stepthrough ("w", rolls, 7);
		System.out.println(find_places(black_one, white_one));
		stepthrough ("b", rolls, 8);
		stepthrough ("w", rolls, 9);
		System.out.println(find_places(black_one, white_one));
	}
}