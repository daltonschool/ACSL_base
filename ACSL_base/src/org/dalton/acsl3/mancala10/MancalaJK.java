package org.dalton.acsl3.mancala10;
/**
 * @author Johnny Kruger
 * March/2011
 * The Dalton School: 9072
 */
import java.util.Scanner;

public class MancalaJK {
	public int[] board;
	public int position;
	public char player;

	public static void main(String[] args)
	{
		MancalaJK game = new MancalaJK();
		Scanner in = new Scanner(System.in);
		int[] results = new int[5];
		char player = 'Z';
		for(int i = 0; i < 5; i++)
		{
			if(i%2 == 0)
				player = 'A';
			else
				player = 'B';
			String input = in.nextLine();
			int commaPos = input.indexOf(',');
			int position = Integer.parseInt(input.substring(0, commaPos).trim());
			String location = input.substring(commaPos+1).trim();
			game.update(position, player);
			game.move();
			results[i] = game.getStonesAt(location);
		}

		for(int i = 0; i<5; i++)
			System.out.println(results[i]);
	}

	public MancalaJK() {
		board = new int[14];
		for(int i = 0; i<board.length; i++)
			if(i!= 0 && i != 7)
				board[i] = 4;
	}
	public void update(int position, char player) {
		if(position>6)
			position++;
		this.position = position;
		this.player = player;
	}
	public int getStonesAt(String location) {
		int toLook = -1;
		if(location.equals("A"))
			toLook = 7;
		else if(location.equals("B"))
			toLook = 0;
		else
		{
			int tmp = Integer.parseInt(location);
			if(tmp > 6)
				tmp++;
			toLook = tmp;
		}
		return board[toLook];
	}

	public void move() {
		if(position==0 || position==7 || position >= board.length)
			return;
		int stones = board[position];
		int current = position;
		board[position] = 0;
		for(int i = 0; i < stones; i++)
		{
			current = (current + 1)%14;

			if((player == 'A' && current ==0) || (player == 'B' && current == 7))
				current++;
			board[current]++;
		}
		if(board[current] == 1 || board[current] == 4)
			return;
		position = current;
		move();
	}
}