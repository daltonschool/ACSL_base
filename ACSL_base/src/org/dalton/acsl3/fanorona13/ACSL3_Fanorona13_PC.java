package org.dalton.acsl3.fanorona13;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class ACSL3_Fanorona13_PC {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		for (int r = 0; r < 5; r++) {
			String[] location = scan.nextLine().split(", ");

			int white_num = Integer.parseInt(location[0]);
			PiecePC [] white_pieces = new PiecePC[white_num];
			for (int i = 0; i < white_pieces.length; i++) {

				white_pieces[i] = new PiecePC();		

			}
			PiecePC [] black_pieces = new PiecePC[location.length - white_num-2];

			for (int i = 0; i < black_pieces.length; i++) {
				black_pieces[i] = new PiecePC();		
			}

			for (int j = 1; j < white_num+1; j++) {
				white_pieces[j-1].position = Integer.parseInt(location[j]);
			}
			
			for (int j = 1; j < black_pieces.length+1; j++) {
				black_pieces[j-1].position = Integer.parseInt(location[j+white_num+1]);
			}		
			
			int[] black_sort = new int[black_pieces.length];
			for (int i = 0; i < black_sort.length; i++) {
				black_sort[i] = black_pieces[i].position;
			}
			Arrays.sort(black_sort);
			for (int i = 0; i < black_sort.length; i++) {
				black_pieces[i].position = black_sort[black_sort.length-i-1];
			}
			int[] white_sort = new int[white_pieces.length];
			for (int i = 0; i < white_sort.length; i++) {
				white_sort[i] = white_pieces[i].position;
			}
			Arrays.sort(white_sort);
			for (int i = 0; i < white_sort.length; i++) {
				white_pieces[i].position = white_sort[white_sort.length-i-1];
			}
			
			
			ArrayList <Integer> captures = new ArrayList<Integer>();
			ArrayList <Integer> full = new ArrayList<Integer>();

			for (int i = 0; i < black_pieces.length; i++) {
				full.add(black_pieces[i].position);
			}

			for (int i = 0; i < white_pieces.length; i++) {
				full.add(white_pieces[i].position); 
			}

			for (int i = 0; i < white_pieces.length; i++) {
				for (int j = 0; j < white_pieces[i].possible_moves(white_pieces[i].position).size(); j++) {
					for (int j2 = 0; j2 < black_pieces.length; j2++) {
						for (int k = 0; k < black_pieces[j2].possible_moves(black_pieces[j2].position).size(); k++) {

							if(white_pieces[i].possible_moves(white_pieces[i].position).get(j) == black_pieces[j2].possible_moves(black_pieces[j2].position).get(k) && (check(white_pieces[i].position, white_pieces[i].possible_moves(white_pieces[i].position).get(j), black_pieces[j2].position)) && !(full.contains(white_pieces[i].possible_moves(white_pieces[i].position).get(j))))
							{
								captures.add(black_pieces[j2].position);
								for (int k2 = 0; k2 < black_pieces.length; k2++) {
									if(check (white_pieces[i].possible_moves(white_pieces[i].position).get(j), black_pieces[j2].position, black_pieces[k2].position))
									{
										captures.add(black_pieces[k2].position);
										int a = j2;
										int b = k2;
										for (int l = 0; l < black_pieces.length; l++) {
											if(check (black_pieces[a].position, black_pieces[b].position, black_pieces[l].position))
											{
												captures.add(black_pieces[l].position);
												a = b;
												b = l;
											}
										}
									}
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < white_pieces.length; i++) {
				for (int j = 0; j < white_pieces[i].possible_moves(white_pieces[i].position).size(); j++) {
					for (int j2 = 0; j2 < black_pieces.length; j2++) {
						int dist = ( ((white_pieces[i].position - black_pieces[j2].position)));
						ArrayList <Integer> poss_list = new ArrayList<Integer>();

						for (int k = 0; k < white_pieces[i].possible_moves(white_pieces[i].position).size(); k++) {
							if(!(white_pieces[i].possible_moves(white_pieces[i].position).get(k) == black_pieces[j2].position))
							{

								poss_list.add(white_pieces[i].possible_moves(white_pieces[i].position).get(k));
							}

						}
						if(white_pieces[i].possible_moves(white_pieces[i].position).get(j) == black_pieces[j2].position && check((white_pieces[i].position + dist), white_pieces[i].position, black_pieces[j2].position) && !full.contains(white_pieces[i].position + (white_pieces[i].position-black_pieces[j2].position)) && poss_list.contains(white_pieces[i].position + dist))
						{
							int pos = black_pieces[j2].position;
							captures.add(black_pieces[j2].position);
							for (int k = 0; k < black_pieces.length; k++) {
								if(pos - dist == black_pieces[k].position)
								{
									captures.add(black_pieces[k].position);
									pos = black_pieces[k].position;
									k = -1;
								}
							}
						}
					}
				}
			}

			Set<Integer> s = new HashSet<Integer>(captures);
			if(captures.size() == 0)
			{
				System.out.println("NONE");
			}
			else
			{
				System.out.println(s.toString().replace("[", "").replace("]", ""));
			}
		}
	}

	public static boolean check (int a, int b, int c)
	{
		if(Math.abs(a-b) == Math.abs(b-c))
		{
			return true;
		}
		return false;
	}
}

class PiecePC {
int position;

	public ArrayList<Integer> possible_moves(int position)
	{
		ArrayList <Integer> possible_moves = new ArrayList<Integer>();
		if(position == 1)
		{
			possible_moves.add(position+1);
			possible_moves.add(position+5);
			possible_moves.add(position+6);
		}
		if(position == 5)
		{
			possible_moves.add(position-1);
			possible_moves.add(position+5);
			possible_moves.add(position+4);
		}
		
		if(position == 7 || position == 9 || position == 13 || position == 17 || position == 19)
		{
			possible_moves.add(position+1);
			possible_moves.add(position-1);
			possible_moves.add(position-4);
			possible_moves.add(position+4);
			possible_moves.add(position-6);
			possible_moves.add(position+6);
		}
		
		if(position == 2 || position == 3 ||position == 4 || position == 8 || position == 12 || position == 14 || position == 18 || position == 22 || position == 23 || position == 24)
		{
			possible_moves.add(position+1);
			possible_moves.add(position-1);
		}
		
		if(position == 2 || position == 3 || position == 4)
		{
			possible_moves.add(position+5);
		}
		
		if(position == 7 || position == 8 || position == 9 || position == 12 || position == 13 || position == 14 || position == 17 || position == 18 || position == 19)
		{
			possible_moves.add(position-5);
			possible_moves.add(position+5);
		}
		
		if(position == 22 || position == 22 || position == 23 || position == 24)
		{
			possible_moves.add(position-5);
		}
		
		if(position == 6 || position == 11 || position == 16 || position == 10 || position == 20 || position == 11 || position == 15)
		{
			possible_moves.add(position+5);
			possible_moves.add(position-5);
		}
		
		
		if(position == 6 || position == 16){
			possible_moves.add(position+1);
		}
		
		if(position == 10 || position == 20 || position == 15)
		{
			possible_moves.add(position-1);
		}
		
		
		
		if(position == 11)
		{
			possible_moves.add(position-4);
			possible_moves.add(position+6);
			possible_moves.add(position+1);
		}
		
		if(position == 15)
		{
			possible_moves.add(position-6);
			possible_moves.add(position+4);
		}
		
		if(position == 21)
		{
			possible_moves.add(position+1);
			possible_moves.add(position-5);
			possible_moves.add(position-4);
		}
		
		if(position == 25)
		{
			possible_moves.add(position-1);
			possible_moves.add(position-5);
			possible_moves.add(position-6);
		}
		
		if(position == 3)
		{
			possible_moves.add(position+4);
			possible_moves.add(position+6);
		}
		if(position == 23)
		{
			possible_moves.add(position-4);
			possible_moves.add(position-6);
		}
		
		return possible_moves;
	}
	
	
}
