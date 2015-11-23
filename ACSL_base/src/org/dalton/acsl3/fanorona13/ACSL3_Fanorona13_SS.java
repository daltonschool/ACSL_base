package org.dalton.acsl3.fanorona13;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Samuel Stone
 * ACSL Program 3 (ACSL Fanorona) Senior Division 2013-2014
 * The Dalton School
 * School Code: 3305
 */


public class ACSL3_Fanorona13_SS 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 20; i++) //Loop to take multiple user inputs 
		{

			ArrayList<Integer> solutions = new ArrayList<Integer>(); 

			String user_input = scan.nextLine();
			String[] split_input = user_input.split(", ");
			int[] split_ints = new int[split_input.length];
			for (int j = 0; j < split_input.length; j++) 
			{
				split_ints[j] = Integer.parseInt(split_input[j]);
			}

			//Num white pieces
			int num_whites = split_ints[0];
			//Num blqck pieces
			int num_blacks = split_ints[num_whites+1];

			//Arrays of white and black piece spots
			int[] white_pieces = new int[num_whites];
			int[] black_pieces = new int[num_blacks];

			for (int j = 0; j < num_whites; j++) 
			{
				white_pieces[j] = split_ints[j+1];
			}

			for (int j = 0; j < num_blacks; j++) 
			{
				black_pieces[j] = split_ints[j+num_whites+2];
			}


			for (int piece_loop = 0; piece_loop < white_pieces.length; piece_loop++) 
			{
				for (int moves_loop = 0; moves_loop < possible_moves(white_pieces[piece_loop]).length; moves_loop++) 
				{ 
					int forward_spot = possible_moves(white_pieces[piece_loop])[moves_loop];//The spot where piece would go from a forward move
					int backward_spot = 2*white_pieces[piece_loop] - possible_moves(white_pieces[piece_loop])[moves_loop]; //The spot where a piece would go directly backwards from a forward move
					int difference_from_forward_spot = forward_spot - white_pieces[piece_loop];//The difference from a forward move to the original move (eg. 5 for up/down, 1 for left/right, varied for diagonal)

					//Backwards rule 1 checks that you are 1 forward move away from a black piece, so moving away makes sense and would actually capture a piece

					boolean backwards_rule1 = false;

					for (int j = 0; j < black_pieces.length; j++) //Loop through black pieces
					{
						if (black_pieces[j] == forward_spot) //If the forward move is a black piece
						{
							backwards_rule1 = true;
						}
					}

					//Backwards rule 2 checks that there are no pieces, black or white, behind you before you can move backwards.

					boolean backwards_rule2 = true;

					for (int j = 0; j < black_pieces.length; j++) //Loop through black pieces 
					{
						if(black_pieces[j] == backward_spot)//If there is a black piece behind you
						{
							backwards_rule2 = false;
						}
					}

					for (int k = 0; k < white_pieces.length; k++) //Loop through white pieces
					{
						if(white_pieces[k] == backward_spot) //If there is a white piece behind you
						{
							backwards_rule2 = false;
						}
					}

					//Backwards rule 3 makes sure that the spot where a backwards move "should" take you is actually valid - refers to the hardcoded possible moves method, which 
					//basically saves me from edge cases

					boolean backwards_rule3 = false;

					for (int j = 0; j < possible_moves(white_pieces[piece_loop]).length; j++) //Loop through possible moves from your spot
					{
						if(possible_moves(white_pieces[piece_loop])[j] == backward_spot) //If the "backwards move" is a legal move and stays on board, condition is satisfied!
						{
							backwards_rule3 = true;
						}
					}

					//This forwards rule makes sure that there is no piece in the forward moves spot (do not need to check anything other edge cases because forward spot is directly
					//Taken from the hardcoded "possible spots" method...

					boolean forwards_rule1 = true;

					for (int j = 0; j < black_pieces.length; j++) 
					{
						if(black_pieces[j] == forward_spot)
						{
							forwards_rule1 = false;
						}
					}
					for (int k = 0; k < white_pieces.length; k++) 
					{
						if(white_pieces[k] == forward_spot)
						{
							forwards_rule1 = false;
						}
					}

					//Makes sure that backwards conditions are satisfied before moving backwards
					if(backwards_rule1 == true && backwards_rule2 == true && backwards_rule3 == true)
					{
						boolean unbroken_capture = true;

						while(unbroken_capture == true)
						{
							//Tests possibility of a move to another spot
							boolean possible_second_move = false;

							for (int j = 0; j < possible_moves(forward_spot).length; j++)//Loop through possible moves from the forward spot 
							{
								if(possible_moves(forward_spot)[j] == forward_spot+difference_from_forward_spot)//If the 2nd move in front is good
								{
									possible_second_move = true;//Allow it to happen
								}
							}

							if(possible_second_move == false)//If not, 
							{
								unbroken_capture = false; //You know no more of an unbroken line will be possible
							}


							//Assume no black capturable
							boolean black_capturable = false;

							for (int j = 0; j < black_pieces.length; j++) //Loop through black pieces 
							{
								if(black_pieces[j] == forward_spot) //If there is a black piece in the forward spot
								{
									black_capturable = true; //Then it is capturable (because this is within the away move loop)
								}
							}

							if(black_capturable == true) //Add it if it is capturable
							{
								for (int j = 0; j < black_pieces.length; j++) //Loop through black pieces
								{
									if(black_pieces[j] == forward_spot) //Where the black piece is in the spot of the forward move
									{
										solutions.add(black_pieces[j]); //Add the black piece to the solution
									}
								}
							}

							else 
							{
								unbroken_capture = false; //If not capturable, then uncapturable, obviously
							}


							forward_spot += difference_from_forward_spot; //Automatically continues the loop down an unbroken line, and keeps rechecking whether the above hold true at each new spot
						} 
					} //Close the "backwards move" loop


					//Forwards move loop

					else if(forwards_rule1 == true) //Only happens when no piece at forward_spot
					{
						boolean unbroken_capture = true;

						while(unbroken_capture == true)
						{
							boolean possible_second_move = false;

							for (int j = 0; j < possible_moves(forward_spot).length; j++)//Loop through possible moves from the forward spot 
							{
								if(possible_moves(forward_spot)[j] == forward_spot+difference_from_forward_spot)//If the 2nd move in front is good
								{
									possible_second_move = true;//Allow it to happen
								}
							}

							//If no possible second move, need to break immediately, or else problems ensue (phantom 2nd moves)
							if(possible_second_move == false)
								break;


							//Makes the forward spot another jump forward, simply because for a forward capture, you will be capturing the piece 2 spots away, instead of 1
							forward_spot += difference_from_forward_spot; 

							//Assume no black capturable
							boolean black_capturable = false;

							for (int j = 0; j < black_pieces.length; j++) //Loop through black pieces 
							{
								if(black_pieces[j] == forward_spot) //If there is a black piece in the forward spot
								{
									black_capturable = true; //Then it is capturable (because this is within the away move loop)
								}
							}


							//If capturable, add to solutions.
							if(black_capturable == true)
							{
								for (int j = 0; j < black_pieces.length; j++) //Loop through black pieces
								{
									if(black_pieces[j] == forward_spot) //Where the black piece is in the spot of the forward move
									{
										solutions.add(black_pieces[j]); //Add the black piece to the solution
									}
								}
							}



							//Otherwise, just end the loop
							else 
							{
								unbroken_capture = false;
							}
						}

					}


					//There will be only one solution, so can just break once the solution is found
					if(!solutions.isEmpty())
						break;

				}//Same as above 
				if(!solutions.isEmpty())
					break; 
			}


			//If there are any solutions, print them.
			if(!solutions.isEmpty())
			{
				int num_answers = solutions.size()-1;
				for (int answer = 0; answer < num_answers; answer++) 
				{
					System.out.print(solutions.get(answer) + "," + " ");
				}
				System.out.println(solutions.get(num_answers));
			}
			//If there are no solutions, print "NONE" by rule.
			else 
			{
				System.out.println("NONE");
			}

		} // close 5x user input loop

	} //Close main


	/**
	 * possible_moves method
	 * @param spot - where the spot is that you need possible moves from
	 * @return integer array of the spots where you can move to
	 */
	public static int[] possible_moves(int spot)
	{
		if(spot == 1) //Possible moves from spot 1
		{
			return new int[]{2, 6, 7}; 
		}

		else if (spot == 2) //Possible moves from spot 2, etc....
		{
			return new int[]{1, 3, 7}; 
		}

		else if (spot == 3)
		{
			return new int[]{2, 4, 7, 8, 9}; 
		}

		else if (spot == 4)
		{
			return new int[]{3, 5, 9}; 
		}

		else if (spot == 5)
		{
			return new int[]{4, 9, 10}; 
		}

		else if (spot == 6)
		{
			return new int[]{1, 7, 11}; 
		}

		else if (spot == 7)
		{
			return new int[]{1, 2, 3, 6, 8, 11, 12, 13}; 
		}

		else if (spot == 8)
		{
			return new int[]{3, 7, 9, 13}; 
		}

		else if (spot == 9)
		{
			return new int[]{3, 4, 5, 8, 10, 13, 14, 15};
		}

		else if (spot == 10)
		{
			return new int[]{5, 9, 15}; 
		}

		else if (spot == 11)
		{
			return new int[]{6, 7, 12, 16, 17}; 
		}

		else if (spot == 12)
		{
			return new int[]{7, 11, 13, 17}; 
		}

		else if (spot == 13)
		{
			return new int[]{7, 8, 9, 12, 14, 17, 18, 19}; 
		}

		else if (spot == 14)
		{
			return new int[]{9, 13, 15, 19}; 
		}

		else if (spot == 15)
		{
			return new int[]{9, 10, 14, 20, 19}; 
		}

		else if (spot == 16)
		{
			return new int[]{11, 17, 21}; 
		}

		else if (spot == 17)
		{
			return new int[]{11, 12, 13, 16, 18, 21, 22, 23}; 
		}

		else if (spot == 18)
		{
			return new int[]{13, 17, 19, 23}; 
		}

		else if (spot == 19)
		{
			return new int[]{13, 14, 15, 18, 20, 23, 24, 25}; 
		}

		else if (spot == 20)
		{
			return new int[]{15, 19, 25}; 
		}

		else if (spot == 21)
		{
			return new int[]{16, 17, 22}; 
		}

		else if (spot == 22)
		{
			return new int[]{17, 21, 23}; 
		}

		else if (spot == 23)
		{
			return new int[]{17, 18, 19, 22, 24}; 
		}

		else if (spot == 24)
		{
			return new int[]{19, 23, 25}; 
		}

		else if (spot == 25)
		{
			return new int[]{19, 20, 24}; 
		}

		return new int[]{}; //Return all possible moves
	}

} // Close program