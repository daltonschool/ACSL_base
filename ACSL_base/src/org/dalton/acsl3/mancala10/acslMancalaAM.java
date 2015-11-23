package org.dalton.acsl3.mancala10;

/**
 * Anne Madoff
 * The Dalton School
 * ACSL
 * 9075
 */
import java.util.Scanner;
//test input array

public class acslMancalaAM {

	public static int moveA(int startingBowl,int bowlToPrint,int[] board)
	{
		//System.out.println("hello from line 14");
		//System.out.println("startingBowl = " + startingBowl + " bowlToPrint = " + bowlToPrint);
		int receivingBowl = startingBowl+1;
		if(receivingBowl==14)
			receivingBowl=0;
		int numberOfStones = board[startingBowl];
		//System.out.println("board[startingBowl] = "+ board[startingBowl]);
		board[startingBowl] = 0;
		boolean reset = true;
		//System.out.println("startingBowl = " + startingBowl + " bowlToPrint = " + bowlToPrint+  " numberOfStones = "+ numberOfStones);

		for(int i=0; i<numberOfStones;)
		{
			//System.out.println("line 27: numberOfStones = " + numberOfStones +" receivingBowl = " + receivingBowl+ " board[receivingBowl] = " + board[receivingBowl]);
			if(receivingBowl == 13)
			{
				receivingBowl=0;
				reset=false;
			}

			else
			{
				numberOfStones--;
				board[receivingBowl]++;
				//System.out.println("line 38: numberOfStones = " + numberOfStones +" receivingBowl = " + receivingBowl+ " board[receivingBowl] = " + board[receivingBowl]);
			}
			
			if(numberOfStones!=0&&reset==true)
			{
				receivingBowl++;
			}
			reset = true;
		}

		//System.out.println(board[receivingBowl]+ " in bowl " + receivingBowl);
		if((board[receivingBowl]!=4)&&(board[receivingBowl]!=1)&&(receivingBowl!=6))
		{
			//System.out.println("move called again");
			moveA(receivingBowl, bowlToPrint, board);
		}
		
		return board[bowlToPrint];
	}

	public static int moveB(int startingBowl,int bowlToPrint,int[] board)
	{
		//System.out.println("hello from line 60");
		//System.out.println("startingBowl = " + startingBowl + " bowlToPrint = " + bowlToPrint);
		int receivingBowl = startingBowl+1;
		if(receivingBowl==14)
			receivingBowl=0;
		int numberOfStones = board[startingBowl];
		//System.out.println("board[startingBowl] = "+ board[startingBowl]);
		board[startingBowl] = 0;
		boolean reset = true;
		//System.out.println("startingBowl = " + startingBowl + " bowlToPrint = " + bowlToPrint+  " numberOfStones = "+ numberOfStones);

		for(int i=0; i<numberOfStones;)
		{
			//System.out.println("line 73: numberOfStones = " + numberOfStones +" receivingBowl = " + receivingBowl+ " board[receivingBowl] = " + board[receivingBowl]);
			if(receivingBowl == 6)
			{
				receivingBowl=7;
				reset=false;
			}

			else
			{
				numberOfStones--;
				board[receivingBowl]++;
				//System.out.println("line 84: numberOfStones = " + numberOfStones +" receivingBowl = " + receivingBowl+ " board[receivingBowl] = " + board[receivingBowl]);
			}
			
			if(numberOfStones!=0&&reset==true)
			{
				receivingBowl++;
			}
			reset = true;
			
			if(receivingBowl==14)
			{
				receivingBowl = 0;
			}
		}

		//System.out.println(board[receivingBowl]+ " in bowl " + receivingBowl);
		if((board[receivingBowl]!=4)&&(board[receivingBowl]!=1)&&(receivingBowl!=6))
		{
			//System.out.println("move called again");
			moveB(receivingBowl, bowlToPrint, board);
		}
		
		return board[bowlToPrint];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int[] board = new int[14];
		int[][] input = new int[5][2];

		for(int x=0;x<5; x++)
		{
			String[] temp = in.nextLine().split(", ");
			if(temp[1].equalsIgnoreCase("A"))
			{
				temp[1] = "14";
			}
			else if(temp[1].equalsIgnoreCase("B"))
			{
				temp[1] = "13";
			}

			input[x][0] = Integer.parseInt(temp[0]);
			input[x][1] = Integer.parseInt(temp[1]);
		}

		for(int i=0; i<5; i++)
		{
			if(input[i][0]<=6)
			{
				input[i][0]--;
			}

			if(input[i][1]<=6)
			{
				input[i][1]--;
			}

			if(input[i][1]==14)
			{
				input[i][1] = 6;
			}
		}

		/**for(int x=0; x<5; x++)
		{
			System.out.println(input[x][0] + ", " + input[x][1]);
		}*/


		for(int x=0; x<14; x++)
		{
			if(x==6||x==13)
			{
				board[x] = 0;
			}

			else
			{
				board[x] = 4;
			}
		}
		
		/**for(int x =0; x<14; x++)
		{
			System.out.println(x + " = " + board[x]);
		}*/

		for(int i=0; i<5; i++)
		{
			if(i==0||i==2||i==4)
			{
				//System.out.println(input[i][0]+", "+input[i][1]);
				System.out.println(moveA(input[i][0],input[i][1],board));
			}

			else if(i==1||i==3)
			{
				//System.out.println(input[i][0]+", "+input[i][1]);
				System.out.println(moveB(input[i][0],input[i][1],board));
			}

		}
	}

}
