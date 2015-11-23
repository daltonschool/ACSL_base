package org.dalton.acsl3.mancala10;
//School: The Dalton School 
//School Code: 9010
//Name: Benjamin Tsoi
import java.util.Scanner;
public class MancalaBT
{	
	public static void main(String[] args)
    {
    	Scanner in = new Scanner (System.in);
    	System.out.println("Welcome to Mancala Simulator!");
    	int data [][] = new int [5][2];
    	int board [] = new int [15];
    	//from 1-14 because arrays start at 0 and making it "start" at 1 makes life easier later on
    	for (int k=1; k<13; k++)
    	{
    		board [k]= 4;
    	}
    	//take in the user's five inputs
    	for (int i=0;i<5;i++)
    	{
    		System.out.println("Please type in the input for line "+(i+1)+".");
    		String input = in.nextLine();
    		//in the board 15 spots (spot"0" is ignored), A will be spot 13 and B will be spot 14
            input = input.replaceAll(", ", ",");
            input = input.replaceAll("a", "13");
            input = input.replaceAll("b", "14");
            input = input.replaceAll("A", "13");
            input = input.replaceAll("B", "14");
            String tempData []= input.split(",");
            //all the data will be stored in a 2D array with i being the starting spot and j being the spot for output
            for (int j=0;j<2;j++)
            {
            	data [i][j] = Integer.parseInt(tempData[j]);
            	//System.out.println("i= "+i+" j= "+j+" data= "+data[i][j]);
            }   
    	}
    	//there are 5 moves in total with players A and B switching off (A goes three times)
    	for (int i=0;i<5;i++)
    	{
    		//position counter, the first starting spot on the board is input by the user
    		int pos = data[i][0];
    		//System.out.println("posbefore= "+pos);
    		int numStones = board[data[i][0]];
    		//System.out.println("numStonesbefore= "+numStones);
    		//player A so add to position 13 going from 6 to 7 
    		boolean turn=true;
    		while(turn==true)
    		{
    			//System.out.println("inside while loop, and value of i= "+i);
    		//this is specifically for player A
    		if(i==0||i==2||i==4)
    		{ 		
    			//after picking up the stones on that spot, it no longer has any
    			board[pos]=0;
    			//loop goes until all the stones are given away
    			for (int n=numStones; n>0; n--)
    			{
    				//System.out.println("inpos= "+pos);
    				//System.out.println("inboard[pos]= "+board[pos]);
    				//for player A going from 6 to 7 is special because spot A is technically between them
    				if(pos+1==7)
    				{
    					//according to the rules, if the last stone is dropped on A then the turn is over
    					if(n==1)
    					{
    					//pos++;
    					board[13]=board[13]+1;
    					//System.out.println("player A stones= "+board[13]);
    					turn=false;
    					}
    					//this is if there are stone(s) left after dropping one on spot A
    					else
    					{
    					//takes into account spot 7 by adding 1 stone to it and subtracting 1 from the total n count
    					pos++;
    					board[7]=board[7]+1;
    					n=n-1;
    					board[13]=board[13]+1;
    					//System.out.println("player A stones= "+board[13]);	
    					}  					
    				}
    				//dropping off 1 stone to that spot
    				else if(pos<6)
    				{
    					pos++;
    					board[pos]=board[pos]+1;
    				}
    				//skips over spot B so goes from 12 to 1
    				else if(pos+1==13)
    				{
    					pos=1;
    					board[pos]=board[pos]+1;
    				}
    				else if(pos<12)
    				{
    					pos++;
    					board[pos]=board[pos]+1;
    				}
    			}
    			//turn over if the spot of the last stone dropped was previously empty or now has 4 stones total
    			if(board[pos]-1==0||board[pos]==4)
    			{
    				turn=false;
    			}
    			//"loop" continues if turn is not over and now the stones in that spot are picked up to be distributed
    			numStones = board[pos];
    			//System.out.println("numstone= " +numStones);
    		}
    		//player B's turn
    		else
    		{
    			board[pos]=0;
    			for (int n=numStones; n>0; n--)
    			{
    				//System.out.println("n= "+n);
    				//System.out.println("inpos= "+pos);
    				//System.out.println("inboard[pos]= "+board[pos]);
    				//spot B technically in between 12 and 1, but computer will increment from 12 to 13
    				if(pos+1==13)
    				{
    					//if last stone dropped onto spot B then turn is over
    					if(n==1)
    					{
    					//pos=1;
    					board[14]=board[14]+1;
    					//System.out.println("player B stones1= "+board[14]);
    					turn=false;
    					//if more stone(s), go to spot 1 and add one stone to it and subtract one from those left
    					}
    					else
    					{
    					pos=1;
    					board[1]=board[1]+1;//problem can't just assume stone left for 1 after landing on B
    					n=n-1;
    					board[14]=board[14]+1;
    					//System.out.println("player B stones2= "+board[14]);
    					}
    				}
    				//everything else is straightforward, no need to care about position A because it is skipped over
    				else if(pos<12)
    				{
    					pos++;
    					board[pos]=board[pos]+1;
    				}
    			}
    			if(board[pos]-1==0||board[pos]==4)
    			{
    				turn=false;
    			}
    			numStones = board[pos];
    			//System.out.println("numstone= " +numStones);
    		}
    		}
    		/*//not sure if this code is necessary DOES A PLAYER EVER WIN BEFORE 5 TURNS?
    		boolean playerB= true;
    		for (int k=1; k<7; k++)
    		{
    			if(board[k]!=0)
    			{
    				playerA= false;
    			}
    			else
    			{
    				
    			}
    		}
    		for (int k=7; k<13; k++)
    		{
    			if(board[k]!=0)
    			{
    				playerB= false;
    			}
    			else
    			{
    				
    			}
    		}
    		if (playerA==true)
    		{
    			System.out.println("Player A wins!");
    		}
    		if (playerB==true)
    		{
    			System.out.println("Player B wins!");
    		}*/
    		//the output for the user after each turn is over
    		System.out.println((i+1)+". "+board[data[i][1]]);
    	}
    }
}