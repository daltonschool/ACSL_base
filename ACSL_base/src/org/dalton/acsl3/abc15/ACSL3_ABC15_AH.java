package org.dalton.acsl3.abc15;
import java.util.Scanner;

/**
 * 
 * @author Alexis Harris
 * ACSL 3
 * 
 */


public class ACSL3_ABC15_AH {

	
	public static void main(String[] args) {

		for (int w = 0; w < 5; w++) {

			Scanner scan = new Scanner(System.in);

			String[] input;

			input = scan.nextLine().split(", "); //this works

			input[4] = "";

			String [][] board = new String [6][6];

			int counter = 1;

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					board[i][j] = Integer.toString(counter);
					counter++;
				}
			}

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					for (int k = 0; k < input.length; k++) {
						if(input[k].equals(board[i][j]))
						{	//puts in the crossed symbol
							if(7 < Integer.parseInt(input[k]) && Integer.parseInt(input[k]) < 12 || 
									13 < Integer.parseInt(input[k]) && Integer.parseInt(input[k]) < 18 ||
									19 < Integer.parseInt(input[k]) && Integer.parseInt(input[k]) < 24 ||
									25 < Integer.parseInt(input[k]) && Integer.parseInt(input[k]) < 30)	
							{
								board[i][j] = "*";
							}	

							if(k != 0)
							{
								if(input[k-1].equals("A")) 
								{
									board[i][j] = "a";
								}
								else if(input[k-1].equals("B")) 
								{
									board[i][j] = "b";
								}
								else if(input[k-1].equals("C")) 
								{
									board[i][j] = "c";
								}
							}
						}

					}
				}
			}

			//

			int counter2 = 0;
			//if there is a letter out of the 4x4 bring it down
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if(i == 0 && j != 0 && j != 5 && board[i][j].equals("a"))
					{
						if(board[i+1][j].equals("*"))
						{
							board[i+2][j] = "&";
						}
						else
						{
							board[i+1][j] = "&";
						}
					}
					if(i == 0 && j != 0 && j != 5 && board[i][j].equals("b"))
					{
						if(board[i+1][j].equals("*"))
						{
							board[i+2][j] = "^";
						}
						else
						{
							board[i+1][j] = "^";
						}
					}
					if(i == 0 && j != 0 && j != 5 && board[i][j].equals("c"))
					{
						if(board[i+1][j].equals("*"))
						{
							board[i+2][j] = "%";
						}
						else
						{
							board[i+1][j] = "%";
						}
					}

					if(i == 5 && j != 0 && j != 5 && board[i][j].equals("a"))
					{
						if(board[i-1][j].equals("*"))
						{
							board[i-2][j] = "&";
						}
						else
						{
							board[i-1][j] = "&";
						}
					}
					if(i == 5 && j != 0 && j != 5 && board[i][j].equals("b"))
					{
						if(board[i-1][j].equals("*"))
						{
							board[i-2][j] = "^";
						}
						else
						{
							board[i-1][j] = "^";
						}
					}
					if(i == 5 && j != 0 && j != 5 && board[i][j].equals("c"))
					{
						if(board[i-1][j].equals("*"))
						{
							board[i-2][j] = "%";
						}
						else
						{
							board[i-1][j] = "&%";
						}
					}


					if(j == 0 && i!=0 && i!=5 && board[i][j].equals("a"))
					{
						if(board[i][j+1].equals("*"))
						{
							board[i][j+2] = "&";
						}
						else
						{
							board[i][j+1] = "&";
						}
					}
					if(j == 0 && i!=0 && i!=5 && board[i][j].equals("b"))
					{
						if(board[i][j+1].equals("*"))
						{
							board[i][j+2] = "^";
						}
						else
						{
							board[i][j+1] = "^";
						}
					}
					if(j == 0 && i!=0 && i!=5 && board[i][j].equals("c"))
					{
						if(board[i][j+1].equals("*"))
						{
							board[i][j+2] = "%";
						}
						else 
						{
							board[i][j+1] = "%";
						}
					}

					if(j == 5 && i!=0 && i!=5 && board[i][j].equals("a"))
					{
						if(board[i][j-1].equals("*"))
						{
							board[i][j-2] = "&";
						}
						else
						{
							board[i][j-1] = "&";
						}
					}
					if(j == 5 && i!=0 && i!=5 && board[i][j].equals("b"))
					{
						if(board[i][j-1].equals("*"))
						{
							board[i][j-2] = "^";
						}
						else
						{
							board[i][j-1] = "^";
						}
					}
					if(j == 5 && i!=0 && i!=5 && board[i][j].equals("c"))
					{
						if(board[i][j-1].equals("*"))
						{
							board[i][j-2] = "%";
						}
						else 
						{
							board[i][j-1] = "%";
						}
					}
				}
			} //end for

			for (int k = 1; k < board.length - 1; k++) {
				for (int k2 = 1; k2 < board.length - 1; k2++) {
					System.out.print(board[k][k2] + " ");
				}
				System.out.println();
			}

			
			//check row, check column
			//have string ABC and take off A, B, C as you find them, leave w/ option
			//to row, column and then intersect the two solutions
			
			String hoptions = "ABC";
			String	voptions = "ABC";
			
			for (int k = 0; k < board.length; k++) {
				for (int k2 = 0; k2 < board.length; k2++) {
					if(board[k][k2] != "&" || board[k][k2] != "^" || board[k][k2] != "%")
					{
						for (int l = 0; l < board.length; l++) {
							
								while (2 <  l && 5 >  l)
								{
									if(board[k][l].equals("a"))
									{
										
									}
									if(board[k][l].equals("b"))
									{
										
									}
									if(board[k][l].equals("c"))
									{
										
									}
								}
							}
											
						
					}
				}
			}
		
		}

	}
}


