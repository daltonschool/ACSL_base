package org.dalton.acsl3.abc15;
import java.util.Scanner;

/**********
 * Name: Jamie Konigsberg
 * Purpose: Complete ACSL_3
 * Date: 03/04/16
 */

public class ACSL3_ABC15_JK {

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in); //declare scanner to take in input 
		for(int i = 0; i<5; i++)
		{
			boolean checker = false; 
			boolean fullchecker = false;
			int[][] board = new int[][]{

					{ 1,   2,  3,  4,  5,  6,},
					{ 7,   8,  9, 10, 11, 12,},
					{ 13, 14, 15, 16, 17, 18,},
					{ 19, 20, 21, 22, 23, 24,},
					{ 25, 26, 27, 28, 29, 30,},
					{ 31, 32, 33, 34, 35, 36,},
			};
			String[] input = s.nextLine().split(", ");

			int[]filledcells = new int[4];
			for(int j = 0; j < filledcells.length; j++) {
				filledcells[j] = Integer.parseInt(input[j]);
			}

			String[]foundletters = new String[input.length-4];
			for(int k = 4; k <input.length; k++)
			{
				foundletters[k-4] = input[k];
			}

			for(int m = 0; m < filledcells.length; m++)
			{
				if(filledcells[m] == 8)
				{
					board[1][1] = 0;
				}
				else if(filledcells[m] == 9)
				{
					board[1][2] = 0;
				}
				else if(filledcells[m] == 10)
				{
					board[1][3] = 0;
				}
				else if(filledcells[m] == 11)
				{
					board[1][4] = 0;
				}
				else if(filledcells[m] == 14)
				{
					board[2][1] = 0;
				}
				else if(filledcells[m] == 15)
				{
					board[2][2] = 0;
				}
				else if(filledcells[m] == 16)
				{
					board[2][3] = 0;
				}
				else if(filledcells[m] == 17)
				{
					board[2][4] = 0;
				}
				else if(filledcells[m] == 20)
				{
					board[3][1] = 0;
				}
				else if(filledcells[m] == 21)
				{
					board[3][2] = 0;
				}
				else if(filledcells[m] == 22)
				{
					board[3][3] = 0;
				}
				else if(filledcells[m] == 23)
				{
					board[3][4] = 0;
				}
				else if(filledcells[m] == 26)
				{
					board[4][1] = 0;
				}
				else if(filledcells[m] == 27)
				{
					board[4][2] = 0;
				}
				else if(filledcells[m] == 28)
				{
					board[4][3] = 0;
				}
				else if(filledcells[m] == 29)
				{
					board[4][4] = 0;
				}
			}	

			for(int t = 2; t<foundletters.length; t = t+2)
			{
				int letterplacement; 
				int whichletter = 0; 

				if(foundletters[t-1].equals("A"))
				{
					whichletter = 101; 
				}
				else if(foundletters[t-1].equals("B"))
				{
					whichletter = 107; 
				}
				else if(foundletters[t-1].equals("C"))
				{
					whichletter = 112; 
				}

				letterplacement = Integer.parseInt(foundletters[t]);

				if(letterplacement == 2)
				{
					board[0][1] = whichletter;
					if(board[1][1] == 8)
					{
						board[1][1] = whichletter;
					}
					else
					{
						board[2][1] = whichletter;
					}
				}
				else if(letterplacement == 3)
				{
					board[0][2] = whichletter;
					if(board[1][2] == 9)
					{
						board[1][2] = whichletter;
					}
					else
					{
						board[2][2] = whichletter;
					}
				}
				else if(letterplacement == 4)
				{
					board[0][3] = whichletter;

					if(board[1][3] == 10)
					{
						board[1][3] = whichletter;
					}
					else
					{
						board[2][3] = whichletter;
					}
				}
				else if(letterplacement == 5)
				{
					board[0][4] = whichletter;

					if(board[1][4] == 11)
					{
						board[1][4] = whichletter;
					}
					else
					{
						board[2][4] = whichletter;
					}
				}
				else if(letterplacement == 7)
				{
					board[1][0] = whichletter;

					if(board[1][1] == 8)
					{
						board[1][1] = whichletter;
					}
					else
					{
						board[1][2] = whichletter;
					}
				}
				else if(letterplacement == 12)
				{
					board[1][5] = whichletter;

					if(board[1][4] == 11)
					{
						board[1][4] = whichletter;
					}
					else
					{
						board[1][3] = whichletter;
					}
				}
				else if(letterplacement == 13)
				{
					board[2][0] = whichletter;

					if(board[2][1] == 14)
					{
						board[2][1] = whichletter;
					}
					else
					{
						board[2][2] = whichletter;
					}
				}
				else if(letterplacement == 18)
				{
					board[2][5] = whichletter;

					if(board[2][4] == 17)
					{
						board[2][4] = whichletter;
					}
					else
					{
						board[2][3] = whichletter;
					}
				}
				else if(letterplacement == 19)
				{
					board[3][0] = whichletter;

					if(board[3][1] == 20)
					{
						board[3][1] = whichletter;
					}
					else
					{
						board[3][2] = whichletter;
					}
				}
				else if(letterplacement == 24)
				{
					board[3][5] = whichletter;

					if(board[3][4] == 23)
					{
						board[3][4] = whichletter;
					}
					else
					{
						board[3][3] = whichletter;
					}
				}
				else if(letterplacement == 25)
				{
					board[4][0] = whichletter;

					if(board[4][1] == 26)
					{
						board[4][1] = whichletter;
					}
					else
					{
						board[4][2] = whichletter;
					}
				}
				else if(letterplacement == 30)
				{
					board[4][5] = whichletter;

					if(board[4][4] == 29)
					{
						board[4][4] = whichletter;
					}
					else
					{
						board[4][3] = whichletter;
					}
				}
				else if(letterplacement == 32)
				{
					board[5][1] = whichletter;

					if(board[4][1] == 26)
					{
						board[4][1] = whichletter;
					}
					else
					{
						board[3][1] = whichletter;
					}
				}
				else if(letterplacement == 33)
				{
					board[5][2] = whichletter;

					if(board[4][2] == 27)
					{
						board[4][2] = whichletter;
					}
					else
					{
						board[3][2] = whichletter;
					}
				}
				else if(letterplacement == 34)
				{
					board[5][3] = whichletter;

					if(board[4][3] == 28)
					{
						board[4][3] = whichletter;
					}
					else
					{
						board[3][3] = whichletter;
					}
				}
				else if(letterplacement == 35)
				{
					board[5][4] = whichletter;

					if(board[4][4] == 29)
					{
						board[4][4] = whichletter;
					}
					else
					{
						board[3][4] = whichletter;
					}
				}
			}

			int[][] revisedboard = new int[4][4];

			for(int row = 0; row < 4; row++)
			{
				for(int column = 0; column <4; column++)
				{
					revisedboard[row][column] = board[row+1][column+1];
				}
			}

			while(fullchecker == false)
			{
				checker = false;
				while(checker == false)
				{
					checker = true; 
					//2 in the same row
					for(int rows = 0; rows < 4; rows++)
					{
						int twochecker = 0; 
						int sum = 0;
						for(int columns = 0; columns < 4; columns++)
						{
							if(revisedboard[rows][columns] > 99)
							{
								twochecker++;
								sum = revisedboard[rows][columns] + sum; 
							}

						}

						if(twochecker == 2)
						{
							for(int columnadd = 0; columnadd < 4; columnadd++)
							{
								if(revisedboard[rows][columnadd] > 0 && revisedboard[rows][columnadd] < 36)
								{
									if(sum == 208)
									{
										revisedboard[rows][columnadd] = 112;
										checker = false;
									}
									else if(sum == 213)
									{
										revisedboard[rows][columnadd] = 107;
										checker = false;
									}
									else if(sum == 219)
									{
										revisedboard[rows][columnadd] = 101;
										checker = false;
									}
								}
							}
						} 
					}

					//two in the same column 

					for(int columns = 0; columns < 4; columns++)
					{
						int twochecker1 = 0; 
						int sum1 = 0;
						for(int rows1 = 0; rows1 < 4; rows1++)
						{
							if(revisedboard[rows1][columns] > 99)
							{
								twochecker1++;
								sum1 = revisedboard[rows1][columns] + sum1; 
							}

						}
						if(twochecker1 == 2)
						{
							for(int rowsadd = 0; rowsadd < 4; rowsadd++)
							{
								if(revisedboard[rowsadd][columns] > 0 && revisedboard[rowsadd][columns] < 36)
								{
									if(sum1 == 208)
									{
										revisedboard[rowsadd][columns] = 112;
										checker = false;
									}
									else if(sum1 == 213)
									{
										revisedboard[rowsadd][columns] = 107;
										checker = false;
									}
									else if(sum1 == 219)
									{
										revisedboard[rowsadd][columns] = 101;
										checker = false;
									}
								}
							}
						}
					} //for loop 
				}

				//Other Substitution Case - ONE 
				for(int r = 0; r <4; r++)
				{
					for(int c = 0; c<4; c++)
					{
						if(revisedboard[r][c] > 0 && revisedboard[r][c] < 36)
						{
							if((revisedboard[0][c] == 101 || revisedboard[1][c] == 101 || revisedboard[2][c] == 101 || revisedboard[3][c] == 101) && 
									(revisedboard[r][0] == 107 || revisedboard[r][1] == 107 || revisedboard[r][2] == 107 || revisedboard[r][3] == 107))
							{
								revisedboard[r][c] = 112;
							}

							else if((revisedboard[0][c] == 101 || revisedboard[1][c] == 101 || revisedboard[2][c] == 101 || revisedboard[3][c] == 101) && 
									(revisedboard[r][0] == 112 || revisedboard[r][1] == 112 || revisedboard[r][2] == 112 || revisedboard[r][3] == 112))
							{

								revisedboard[r][c] = 107;
							}
							else if((revisedboard[0][c] == 107 || revisedboard[1][c] == 107 || revisedboard[2][c] == 107 || revisedboard[3][c] == 107) && 
									(revisedboard[r][0] == 101 || revisedboard[r][1] == 101 || revisedboard[r][2] == 101 || revisedboard[r][3] == 101))
							{

								revisedboard[r][c] = 112;
							}

							else if((revisedboard[0][c] == 107 || revisedboard[1][c] == 107 || revisedboard[2][c] == 107 || revisedboard[3][c] == 107) && 
									(revisedboard[r][0] == 112 || revisedboard[r][1] == 112 || revisedboard[r][2] == 112 || revisedboard[r][3] == 112))
							{

								revisedboard[r][c] = 101;
							}
							else if((revisedboard[0][c] == 112 || revisedboard[1][c] == 112 || revisedboard[2][c] == 112 || revisedboard[3][c] == 112) && 
									(revisedboard[r][0] == 101 || revisedboard[r][1] == 101 || revisedboard[r][2] == 101 || revisedboard[r][3] == 101))
							{

								revisedboard[r][c] = 107;
							}
							else if((revisedboard[0][c] == 112 || revisedboard[1][c] == 112 || revisedboard[2][c] == 112 || revisedboard[3][c] == 112) && 
									(revisedboard[r][0] == 107 || revisedboard[r][1] == 107 || revisedboard[r][2] == 107 || revisedboard[r][3] == 107))
							{
								revisedboard[r][c] = 101;
							}
						}
					}
				}

				//keep going checker 
				fullchecker = true; 
				for(int z2 = 0; z2 < 4; z2++)
				{
					for(int z3 = 0; z3 < 4; z3++)
					{
						if(revisedboard[z2][z3] > 0 && revisedboard[z2][z3] <36)
						{
							fullchecker = false; 
						}
					}
				}
			}

			for(int z = 0; z<4; z++)
			{
				for(int y = 0; y<4; y++)
				{
					if(revisedboard[z][y] == 101)
					{
						System.out.print("A");
					}
					else if(revisedboard[z][y] == 107)
					{
						System.out.print("B");
					}
					else if(revisedboard[z][y] == 112)
					{
						System.out.print("C");
					}
				}
			} //print result loop
			System.out.println();
		}//big for loop
	}//main
} //class
