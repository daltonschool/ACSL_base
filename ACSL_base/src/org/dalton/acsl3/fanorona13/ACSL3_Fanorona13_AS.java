/*Allegra Simon 
 * The Dalton School 
 * 3055
 */
package org.dalton.acsl3.fanorona13;

import java.util.Scanner;

public class ACSL3_Fanorona13_AS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		for (int i=0; i<5; i++)
		{
			int[][] output = new int[9][9];
			for(int k=0; k<9; k++)
			{
				for(int j=0; j<9; j++)
				{
					output[k][j]=0;
				}
			}// end fill output board FINAL

			String data = scan.nextLine();
			String[] input = data.split(", "); 
			int[][] board = fillBoard(input);
			output = findMovesOddTowards(board, output);
			output = findMovesOddAway(board, output);
			output = findMovesEvenTowards(board,output);
			output = findMovesEvenAway(board, output);
			String answer = formatOutput(output);
			System.out.println(answer);
		}
	}// END MAIN
	public static int[][] fillBoard (String[] input)
	{
		int[][] board = new int [9][9];
		for(int i=0; i<7; i++)
		{
			board[i][i]=0;
		}
		for (int i=1; i<Integer.parseInt(input[0])+1; i++)
		{
			int row = (int) Math.ceil(Double.parseDouble(input[i])/5)+1;
			int col = 1+ Integer.parseInt(input[i])%5;
			if(Integer.parseInt(input[i])%5 ==0)
			{
				col = 6;
			}
			board[row][col]=1;
		}

		for (int i =Integer.parseInt(input[0])+2; i<input.length; i++ )
		{
			int row = (int) Math.ceil(Double.parseDouble(input[i])/5)+1;
			//System.out.println("52:" + input[i]);
			int col = 1+ Integer.parseInt(input[i])%5;
			if(Integer.parseInt(input[i])%5 ==0)
			{
				col = 6;
			}
			board[row][col]=2;
		}
		return board;
	}// end fillbaord

	public static int[][] findMovesOddTowards (int[][] board, int[][] output)
	{
		for (int i=0; i<7; i++)
		{
			for (int j=0; j<7; j++)
			{
				if(board[i][j]==2)
				{
					if((i+j)%2 == 0)// if its on an odd square
					{

						if(board[i+1][j]==0 && board[i+2][j]==1)// odd up towards
						{
							output[i][j]=9;// captured 
							if(board[i-1][j]==2)
							{
								output[i-1][j]=9;
								if(board[i-2][j]==2)
								{
									output[i-2][j]=9;
								}
							}
						}// end odd up towards

						if(board[i-1][j-1]==0&&board[i-2][j-2]==1)
						{
							output[i][j]=9;
							if(board[i+1][j+1]==2)
							{
								output[i+1][j+1]=9;
								if(board[i+2][j+2]==2)
								{
									output[i+2][j+2]=9;
								}
							}
						}// end diagonal to the right towards

						if (board[i][j-1]==0 && board[i][j-2]==1 )
						{
							output[i][j]=9;
							if(board [i][j+1]==2)
							{
								output[i][j+1]=9;
								if(board[i][j+2]==2)
								{
									output[i][j+2]=9;
								}
							}
						}// end horiztonal right 
						if (board[i+1][j+1]==0 && board[i+2][j+2]==1)
						{
							output[i][j]=9;
							if(board[i-1][j-1] ==2)
							{
								output[i-1][j-1]=9;
								{
									if(board[i-2][j-2]==2)
									{
										output[i-2][j-2]=9;
									}
								}
							}
						}// end diagonal down right 
						if (board[i-1][j]==0 && board[i-2][j]==1)
						{
							output[i][j]=9;
							if(board[i+1][j]==2)
							{
								output[i+1][j]=9;
								if(board[i+2][j]==2)
								{
									output[i+2][j]=9;
								}
							}
						}// end down vertical 

						if(board[i+1][j-1]==0 && board[i+2][j-2]==1)
						{
							output[i][j]=9;
							if(board[i-1][j+1]==2)
							{
								output[i-1][j+1]=9;
								if (board[i-2][j+2]==2)
								{
									output[i-2][j-2]=9;
								}
							}
						}// end down left diagonal

						if(board[i][j+1]==0 && board[i][j+2]==1)
						{
							output[i][j]=9;
							if(board[i][j-1]==2)
							{
								output[i][j-1]=9;
								if(board[i][j-2]==2)
								{
									output[i][j-2]=9;
								}
							}
						}// end horizontal left

						if(board[i-1][j+1]==0 && board[i-2][j+2]==1)
						{
							output[i][j]=9;
							if(board[i+1][j-1]==2)
							{
								output[i+1][j-1]=9;
								if(board[i+2][j-2]==2)
								{
									output[i+2][j-2]=9;
								}
							}
						}// end diagonal up left 

					}// end if on odd square
				}// end if black
			}// end go thru j

		}// end go thru i
		return output;
	}// end find moves odd 

	public static int[][] findMovesOddAway (int[][] board, int[][] output)
	{
		for(int i=0; i<7; i++)
		{
			for (int j=0; j<7; j++)
			{
				if(board[i][j]==2)
				{
					if((i+j)%2==0)
					{
						if(i-2>1 && board[i-1][j]==1 && board[i-2][j]==0)
						{
							output[i][j]=9;
							if(board[i+1][j]==2)
							{
								output[i+1][j]=9;
								if(board[i+2][j]==2)
								{
									output[i+2][j]=9;
								}
							}
						}// end up
						if(i-2>1&& j+2<7 && board[i-1][j+1]==1 && board[i-2][j+2]==0)
						{
							output[i][j] =9;
							if(board[i+1][j-1]==2)
							{
								output [i+1][j-1]=9;
								if(board[i+2][j-2]==2)
								{
									output[i+2][j-2]=9;
								}
							}
						}// end up diagonal right


						if(j+2<7 && board[i][j+1]==1 && board[i][j+2]==0)
						{
							output[i][j]=9;
							if(board[i][j-1]==2)
							{
								output[i][j-1]=9;
								if(board[i][j-2]==2)
								{
									output[i][j-2]=9;
								}
							}
						}// end horizontal right 

						if(j+2<7 && i+2<7 &&board[i+1][j+1]==1 && board[i+2][j+2]==0)
						{
							output[i][j]=9;
							if(board[i-1][j-1]==2)
							{
								output[i-1][j-1]=9;
								if(board[i-2][j-2]==2)
								{
									output[i-2][j-2]=9;
								}
							}
						}// end diagonal down 

						if(i+2<7 && board[i+1][j]==1 && board[i+2][j]==0)
						{
							output[i][j]=9; 
							if(board[i-1][j]==2)
							{
								output[i-1][j]=9;
								if(board[i-2][j]==2)
								{
									output[i-2][j]=9;
								}
							}
						}// end down 

						if(i+2<7 && j-2>1 &&board[i+1][j-1]==1 && board[i+2][j-2]==0)
						{
							output[i][j]=9;
							if(board[i-1][j+1]==2)
							{
								output[i-1][j+1]=9;
								if(board[i-2][j+2]==2)
								{
									output[i-2][j+2]=9;
								}
							}
						}// end diagonal left down 

						if (j-2>1 &&board[i][j-1]==1 && board[i][j-2]==0)
						{
							output[i][j]=9;
							if(board[i][j+1]==2)
							{
								output[i][j+1]=9;
								if(board[i][j+2]==2)
								{
									output[i][j+2]=9;
								}
							}
						}// end horizontal left

						if( i-2>1&& j-2>1 && board[i-1][j-1]==1 && board[i-2][j-2]==0)
						{
							output[i][j]=9;
							if(board[i+1][j+1]==2)
							{
								output[i+1][j+1]=9;
								if(board[i+2][j+2]==2)
								{
									output[i+2][j+2]=9;
								}
							}
						}// end diagonal up left

					}// end if odd
				}// end if black
			}// end 2nd for
		}// end first for



		return output;
	}
	public static int[][] findMovesEvenTowards (int[][] board, int[][] output)
	{
		for (int i=0; i<7; i++)
		{
			for (int j=0; j<7; j++)

			{
				if(board[i][j]==2)
				{
					if((i+j)%2 != 0)

						if(board[i-1][j]==0 && board[i-2][j]==1)// odd up towards
						{
							output[i][j]=9;// captured 
							if(board[i+1][j]==2)
							{
								output[i+1][j]=9;
								if(board[i+2][j]==2)
								{
									output[i+2][j]=9;
								}
							}
						}// end odd up towards
					if (board[i][j+1]==0 && board[i][j+2]==1 )
					{
						output[i][j]=9;
						if(board [i][j-1]==2)
						{
							output[i][j-1]=9;
							if(board[i][j-2]==2)
							{
								output[i][j-2]=9;
							}
						}
					}// end horizontal right
					if (board[i+1][j]==0 && board[i+2][j]==1)
					{
						output[i][j]=9;
						if(board[i-1][j]==2)
						{
							output[i-1][j]=9;
							if(board[i-2][j]==2)
							{
								output[i-2][j]=9;
							}
						}
					}// end down vertical 

					if(board[i][j-1]==0 && board[i][j-2]==1)
					{
						output[i][j]=9;
						if(board[i][j+1]==2)
						{
							output[i][j+1]=9;
							if(board[i][j+2]==2)
							{
								output[i][j+2]=9;
							}
						}
					}// end horizontal left
				}// end if black
			}// end go thru j
		}// end go thru i
		return output;
	}

	public static int[][] findMovesEvenAway(int[][] board, int [][]output)
	{
		for (int i=0; i<7; i++)
		{
			for (int j=0; j<7; j++)
			{
				if(board[i][j]==2)
				{
					if((i+j)%2 != 0)	
					{  
						if(i-2>1 && board[i-1][j]==1 && board[i-2][j]==0)
						{
							output[i][j]=9;
							if(board[i+1][j]==2)
							{
								output[i+1][j]=9;
								if(board[i+2][j]==2)
								{
									output[i+2][j]=9;
								}
							}
						}// end up

						if(j+2<7 && board[i][j+1]==1 && board[i][j+2]==0)
						{
							output[i][j]=9;
							if(board[i][j-1]==2)
							{
								output[i][j-1]=9;
								if(board[i][j-2]==2)
								{
									output[i][j-2]=9;
								}
							}
						}// end horizontal right 

						if(i+2<7 && board[i+1][j]==1 && board[i+2][j]==0)
						{
							output[i][j]=9; 
							if(board[i-1][j]==2)
							{
								output[i-1][j]=9;
								if(board[i-2][j]==2)
								{
									output[i-2][j]=9;
								}
							}
						}// end down 

						if (j-2>1 && board[i][j-1]==1 && board[i][j-2]==0)
						{
							output[i][j]=9;
							if(board[i][j+1]==2)
							{
								output[i][j+1]=9;
								if(board[i][j+2]==2)
								{
									output[i][j+2]=9;
								}
							}
						}// end horizontal left
					}// end if even 
				}// end if black 
			} // end first for
		}// end second for
		return output;
	}// end findmovesevenaway

	public static String formatOutput(int[][] board)
	{
		String output = "";
		for(int i=0; i<7; i++)
		{
			for(int j=0; j<7; j++)
			{
				if(board[i][j]==9)
				{
					int spot = (i-2)*5 + j-1;
					output = output + ", "+ spot;
				}
			}
		}
		StringBuffer outsb = new StringBuffer(output);
		outsb.delete(0,2);
		output = outsb.toString();

		if(output.equals(""))
		{
			output= "NONE";
		}
		return output;
	}


}// end program
