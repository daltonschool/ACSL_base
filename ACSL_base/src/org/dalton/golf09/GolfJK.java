package org.dalton.golf09;
//************************
//	James Kennedy 12/15/09 ACSL Golfing Program 
//
//	The Dalton School: 33580
//***********************
import java.util.Arrays;
import java.util.Scanner;

public class GolfJK{
	

	
	
	public static int playerscore (int[][] scores, int playernum)
	{
	int temp = 0;
		
		
		for(int x = 0; x < 9; x++ )//runs each round
		{
		temp = temp + scores[x][playernum];//adds up players score
		}		
		
		return temp-36;//subtracts par
	
	}
	
	public static void displayscore (int temp)//temp really means the player's score
	{
		
		//relays the over all score for given player
		if(temp>0)
		{
		System.out.println(temp+" over par");		
		}
		else if (temp==0)
		{
		System.out.println("par");
		}
		else
		{
		System.out.println(Math.abs(temp)+" under par");				
		}	
		
	}
	
	public static void roundwins (int[][] scores, int playernum)
	{
	int bigger = 0;
	int wins = 0;	

	
	for(int x = 0; x < 9; x++ )//runs each round
	{
		bigger = 0;//restart the round
		
		for(int y = 0; y < 4; y++)//runs through each player
		{
			if(y!=playernum&&scores[x][playernum]<scores[x][y])//only runs if the checked player is not the over all wining player
			{
				
			bigger++;	
				
			}	
		}
		
		if(bigger==3)
		{
		
		wins++;	
			
		}
	}	
		
	System.out.println(wins);	
	}
	
	public static int lowestplayer (int[][] scores)
	{
		
	int tempscore = playerscore(scores,0);	
	int player = 0;
	
		for(int x = 1; x < 4; x++)//goes through and checks the scores for all the players 
		{
		
			if(tempscore>playerscore(scores,x))
			{
			tempscore=playerscore(scores,x);
			player = x;
			}
		}
			
	return player;	
	}
	
	public static void scorelist(int[][] scores)
	{
	int[] scorestotal = {playerscore(scores,0),playerscore(scores,1),playerscore(scores,2),playerscore(scores,3)};	
	int[] order = new int[4];
	char[] players = {'A','B','C','D'};
	int tempscore = 0;
	int tempplayer=0;

		for(int y= 0; y < 4; y++)//runs through each player that will be checked
		{
			tempscore=2000;	
			
			for(int x= 0; x < 4; x++)//runs through each player that the above player will be checked against
			{
			
				if(scorestotal[x]<tempscore&&scorestotal[x]!=-999)
				{
				tempscore=scorestotal[x];	
				tempplayer=x;	
				}	
			}
				
			order[y]=tempplayer;
			scorestotal[tempplayer]=-999;					
		}		
			
	System.out.println(players[order[0]]+", "+players[order[1]]+", "+players[order[2]]+", "+players[order[3]]);	
	}
	
	
	public static void median (int[][] scores)
	{
	
	int[] allscores = new int[36];	
		
		for(int x = 0; x < 9; x++ )//runs each round
		{
			for(int y= 0; y < 4; y++)//runs through each player
			{
			allscores[y*9+x]=scores[x][y];//puts all info in one collumn 
			}
		}	
		
	Arrays.sort(allscores);//sorts array
		
		if((double) ((allscores[17]+allscores[18])/2) %1 !=0) //will display this if it is a double
		{
		System.out.println((double)((allscores[17]+allscores[18]))/2);	
		}
		else
		{
		System.out.println((allscores[17]+allscores[18])/2);
		}
	}
	
	
	public static void main(String args[]){
	
		int[][] scores = new int[9][4];
		String[] temp = new String[4];
		
		Scanner in = new Scanner (System.in);
	
		for(int x = 0; x < 9; x++ )//runs 9 inputs
		{
		
		temp = in.nextLine().split(",");//takes in input
		
			for(int y= 0; y < 4; y++)//runs through each number in line
			{
			scores[x][y]= Integer.parseInt(temp[y].trim());//puts info into scores array
			}
		}
		
	displayscore(playerscore(scores,1));
	displayscore(playerscore(scores,0));
	roundwins(scores,lowestplayer(scores));
	scorelist(scores);
	median(scores);
	
	
	}//main
	
	
}//class