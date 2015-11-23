package org.dalton.acsl3.chess12;
import java.util.*;
public class ChessQueenCA {
	public static void main(String[] args)
	{
		/**
		 * Name: Cordelia Avery
		 * School: Dalton School
		 * Code: 33805
		 */
		Scanner input = new Scanner(System.in);
		String[] data;
		String[] output = new String[5];
		System.out.println("Enter data");
		for(int i=0; i<5; i++) //reads in input
		{
			data = input.nextLine().split(",");
			int[][] grid = new int[(data.length/2)-1][2]; //creates a grid for the input
			for(int j=0; j<data.length-2; j+=2)
			{
				grid[j/2][0]=(int)Double.parseDouble(data[j])-1; //sets the rows
				grid[j/2][1]=(int)Double.parseDouble(data[j+1])-1; //sets the columns
			}
			for(int j=0; j<8; j++) //loops through rows
			{
				int counter = 0;
				for(int k=0; k<8; k++) //loops through columns
				{		
					for(int l=0; l<grid.length; l++) //loops through all the pieces
					{
						if((j!=grid[l][0]&&(grid[l][1]-grid[l][0]==k-j||grid[l][1]+grid[l][0]==j+k||k==grid[l][1]))||(j==grid[l][0]&&k!=grid[l][1]))
						{
							counter++; //checks diagonal, vertical, or horizontal work and that there is no piece on the spot, and increments the counter if yes
						}
					}
					if(counter==grid.length) //if there is a match for every piece
					{
						output[i]=(i+1)+". "+(j+1)+", "+(k+1);
						counter=0;
						break;
					}
					counter=0;
					
				}
				if(output[i]!=null) //if the output is already found, then get out of the row loop
				{
					break;
				}
			}
			
		}
		for(int i=0; i<5; i++)
		{
			if(output[i]!=null)
			{
			System.out.println(output[i]); //prints the output
			}
			else //if there were no matches found
			{
				System.out.println((i+1)+". NONE");
			}
		}
	}
}
