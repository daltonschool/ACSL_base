package org.dalton.acsl1.prints10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cara Haas
 * The Dalton School
 * 9075
 */

public class Contest1CH {

	public static void main(String[] args)
	{
		for(int p=0; p<5; p++)
		{	
			Scanner takeIn = new Scanner(System.in);
			String[] comingIn=new String[2];
			int[] input=new int[2];
			int[] returningTop=new int[5];
			int[] returningBottom=new int[5];

			//System.out.println("");
			String first=takeIn.nextLine();
			comingIn=first.split(", ");
			input[0]=Integer.parseInt(comingIn[0]);
			input[1]=Integer.parseInt(comingIn[1]);

			input[0]=input[0]-1;
			input[1]=input[1]-1;

			if(input[0]==0 && input[1]==0)
			{
				System.out.println("None");
			}
			else
			{
				if(input[0]-16>=0)
				{
					input[0]=input[0]-16;
					returningTop[0]=2;
				}
				if(input[0]-8>=0)
				{
					input[0]=input[0]-8;
					returningTop[1]=4;
				}
				if(input[0]-4>=0)
				{
					input[0]=input[0]-4;
					returningTop[2]=6;
				}
				if(input[0]-2>=0)
				{
					input[0]=input[0]-2;
					returningTop[3]=8;
				}
				if(input[0]-1>=0)
				{
					input[0]=input[0]-1;
					returningTop[4]=10;
				}


				if(input[1]-16>=0)
				{
					input[1]=input[1]-16;
					returningBottom[0]=1;
				}
				if(input[1]-8>=0)
				{
					input[1]=input[1]-8;
					returningBottom[1]=3;
				}
				if(input[1]-4>=0)
				{
					input[1]=input[1]-4;
					returningBottom[2]=5;
				}
				if(input[1]-2>=0)
				{
					input[1]=input[1]-2;
					returningBottom[3]=7;
				}
				if(input[1]-1>=0)
				{
					input[1]=input[1]-1;
					returningBottom[4]=9;
				}

				ArrayList<Integer> top=new ArrayList<Integer>();
				ArrayList<Integer> bottom=new ArrayList<Integer>();

				for(int i=0; i<5; i++)
				{
					if(returningTop[i]!=0)
					{
						top.add(returningTop[i]);
					}

					if(returningBottom[i]!=0)
					{
						bottom.add(returningBottom[i]);
					}
				}

				if(top.size()!=0)
				{	
					for(int i=0; i<top.size()-1; i++)
					{
						System.out.print(top.get(i) + ", ");
					}
					System.out.print(top.get(top.size()-1));

					if(bottom.size()!=0)
					{	
						System.out.print(", ");
					}
				}

				if(bottom.size()!=0)
				{	
					for(int i=0; i<bottom.size()-1; i++)
					{
						System.out.print(bottom.get(i) + ", ");
					}

					System.out.print(bottom.get(bottom.size()-1));
				}
				System.out.println("");
			}
		}
	}



}
