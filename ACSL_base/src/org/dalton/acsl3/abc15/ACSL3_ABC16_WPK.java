package org.dalton.acsl3.abc15;
import java.util.Scanner;

public class ACSL3_ABC16_WPK 
{

	public static void ABC(String[] filledLoc, String[][] givenNums)
	{
		String board[][] = new String[6][6];
		String finBoard[][] = new String[4][4];

		int q = 1;
		for (int i = 0; i < board[0].length; i++) 
		{
			for (int j = 0; j < board.length; j++) 
			{
				board[i][j] = Integer.toString(q);
				q++;
			}
		}

		for (int i = 0; i < filledLoc.length; i++) 
		{
			for (int j = 0; j < board[0].length; j++) 
			{
				for (int j2 = 0; j2 < board.length; j2++) 
				{
					if(filledLoc[i].equals(board[j][j2]))
					{
						board[j][j2] = "X";
					}
				}
			}
		}

		for (int i = 0; i < givenNums[0].length; i++) 
		{
			for (int j = 0; j < board[0].length; j++) 
			{
				for (int j2 = 0; j2 < board.length; j2++) 
				{
					if(givenNums[1][i].equals(board[j][j2]))
					{
						board[j][j2] = givenNums[0][i];
					}
				}
			}
		}

		//print
//		for (int i = 0; i < board[0].length; i++) 
//		{
//			for (int j = 0; j < board.length; j++) 
//			{
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}

		//run through rows from right 
		for (int i = 1; i < (board.length - 1); i++) 
		{
			if(board[i][0].equals("A") || board[i][0].equals("B") || board[i][0].equals("C"))
			{
				for (int j = 1; j < (board[0].length - 1); j++) 
				{
					if(!board[i][j].equals("X"))
					{
						board[i][j] = board[i][0];
						break;
					}
				}
			}
		}

		//run through rows from left 
		for (int i = 1; i < (board.length - 1); i++) 
		{
			if(board[i][(board.length - 1)].equals("A") || board[i][(board.length - 1)].equals("B") || board[i][(board.length - 1)].equals("C"))
			{
				for (int j = (board.length - 2); j > 0; j--) 
				{
					if(!board[i][j].equals("X"))
					{
						board[i][j] = board[i][(board.length - 1)];
						break;
					}
				}
			}
		}

		//run through rows from top 
		for (int i = 1; i < (board[0].length - 1); i++) 
		{
			if(board[0][i].equals("A") || board[0][i].equals("B") || board[0][i].equals("C"))
			{
				for (int j = 1; j < (board.length - 1); j++) 
				{
					if(!board[j][i].equals("X"))
					{
						board[j][i] = board[0][i];
						break;
					}
				}
			}
		}

		//run through rows from bottom 
		for (int i = 1; i < (board[0].length - 1); i++) 
		{
			if(board[(board[0].length - 1)][i].equals("A") || board[(board[0].length - 1)][i].equals("B") || board[(board[0].length - 1)][i].equals("C"))
			{
				for (int j = (board[0].length - 2); j > 0; j--) 
				{
					if(!board[j][i].equals("X"))
					{
						board[j][i] = board[(board[0].length - 1)][i];
						break;
					}
				}
			}
		}

		//print
//		System.out.println();
//		for (int i = 0; i < board[0].length; i++) 
//		{
//			for (int j = 0; j < board.length; j++) 
//			{
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}

		//transfer to final board
		int x = 0;
		for (int i = 1; i < (board.length - 1); i++) 
		{
			int y = 0;
			for (int j = 1; j < (board[0].length - 1); j++) 
			{
				finBoard[x][y] = board[i][j];
				y++;
			}
			x++;
		}

		//print
//		System.out.println();
//		for (int i = 0; i < finBoard[0].length; i++) 
//		{
//			for (int j = 0; j < finBoard.length; j++) 
//			{
//				System.out.print(finBoard[i][j] + " ");
//			}
//			System.out.println();
//		}

		int t = 30;
		while(t > 0){ 
			//run through each space 
			for (int i = 0; i < finBoard.length; i++) 
			{
				for (int j = 0; j < finBoard[0].length; j++) 
				{
//					System.out.println("i: " + i + " j: " + j);
					String near = "";
					if(!finBoard[i][j].equals("A") && !finBoard[i][j].equals("B") && !finBoard[i][j].equals("C") && !finBoard[i][j].equals("X"))
					{
//						System.out.println("+");

						for (int i2 = 0; i2 < finBoard[0].length; i2++) 
						{
							if(finBoard[i][i2].equals("A") || finBoard[i][i2].equals("B") || finBoard[i][i2].equals("C"))
							{
								near += finBoard[i][i2] + 1;
							}
						}
						for (int j2 = 0; j2 < finBoard.length; j2++) {
							if(finBoard[j2][j].equals("A") || finBoard[j2][j].equals("B") || finBoard[j2][j].equals("C"))
							{
								if(i == 1 && j == 0)
								{
//									System.out.println("j2: " + j2);
//									System.out.println("f: " + finBoard[j][j2]);
								}

								near += finBoard[j2][j] + 2;
							}
						}
//						System.out.println("near: " + near);

						if(near.contains("B") && near.contains("C"))
						{
							finBoard[i][j] = "A";
						}
						else if(near.contains("A") && near.contains("C"))
						{
							finBoard[i][j] = "B";
						}
						else if(near.contains("A") && near.contains("B"))
						{
							finBoard[i][j] = "C";
						}

//						System.out.println(finBoard[i][j]);
					}
				}
			}
			t--;
		}

//		//print
//		System.out.println();
//		for (int i = 0; i < finBoard[0].length; i++) 
//		{
//			for (int j = 0; j < finBoard.length; j++) 
//			{
//				System.out.print(finBoard[i][j] + " ");
//			}
//			System.out.println();
//		}

		//sort results
		String res = "";
		for (int i = 0; i < finBoard.length; i++) 
		{
			for (int j = 0; j < finBoard[0].length; j++) 
			{
				if(!finBoard[i][j].equals("X"))
				{
					res += finBoard[i][j];
				}
			}
		}
		System.out.println(res);

	}

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 5; i++) 
		{

			String input = scan.nextLine();
			String[] data = input.split(",[ ]*");
			String[] filledLoc = new String[4];
			filledLoc[0] = data[0];
			filledLoc[1] = data[1];
			filledLoc[2] = data[2];
			filledLoc[3] = data[3];
			String givenNums[][] = new String[2][Integer.parseInt(data[4])];
			int q = 0;
			for (int j = 0; j < Integer.parseInt(data[4]); j++) 
			{
				givenNums[0][j] = data[q+5];
				givenNums[1][j] = data[q+6];
				q+=2;
			}

			ABC(filledLoc, givenNums);
		}
	}
}
