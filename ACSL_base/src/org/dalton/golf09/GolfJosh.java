package org.dalton.golf09;

import java.util.Scanner;
public class GolfJosh
{
	public static int getTotal(int josh_data[]) 
	{
		int total = 0;
		for(int i = 0; i< josh_data.length; i++)
		{
			total = josh_data[i] + total;	
		}
		return total;
	}
	public static int FindplayerA(int playerA[])
	{
		int par = 36;
		int sum = 0;
		int sumA = 0;
		sumA = getTotal(playerA);
		if(sumA < par)
		{		sum = par - sumA;
		System.out.println(sum + " under par");
		}	
		else if(sumA == par)
		{
			System.out.println("Par");
		}
		else if(sumA > par)
		{		sum = sumA - par;
		System.out.println(sum + "over par");
		}//find the difference between par and score for A
		return playerA[8];
	}
	public static int FindplayerB(int playerB[])
	{
		int par = 36;
		int sum = 0;
		int sumB = 0;
		sumB = getTotal(playerB);
		if(sumB < par)
		{		sum = par - sumB;
		System.out.println(sum + " under par");
		}	
		else if(sumB == par)
		{
			System.out.println("Par");
		}
		else if(sumB > par)
		{		sum = sumB - par;
		System.out.println(sum + "over par");
		}//find the difference between par and score for A
		return playerB[8];
	}
	public static void main(String[] args)//open main
	{
		int userinputScores[][] = new int [9][4];
		int[] playerA = new int [9];
		int[] playerB = new int [9];
		int[] playerC = new int [9];
		int[] playerD = new int [9];
		int[] parArray = {3,4,5,4,4,4,5,3,4}; //defines single array for Par
		int par = 36; //par Total

		int holeA = 0;
		int holeB = 0;
		int holeC = 0;
		int holeD = 0;
		int sumA = 0;
		int sumB = 0;
		int sumC = 0;
		int sumD = 0;
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		int[] sumsArray = new int[4];
		int out = 0;

		int[] largeArray= new int[35];

		int sumA2 = 0;
		int sumB2 = 0;
		int sumC2 = 0;
		int sumD2 = 0;
		int[] sumsArray2 = new int[4];

		Scanner in = new Scanner (System.in); //Scanner
		String response = ""; //user's response

		for(int i = 0; i< userinputScores.length; i++)
		{
			response = in.nextLine();
			String dataHole[] = response.split(",");
			for(int j = 0; j < userinputScores[0].length; j++)
			{
				int dataHolex = Integer.parseInt(dataHole[j]);
				userinputScores[i][j] = dataHolex;
			}
		}
		for(int i = 0; i<userinputScores.length; i++)
		{
			playerA[i] = userinputScores[i][0];
			playerB[i] = userinputScores[i][1];
			playerC[i] = userinputScores[i][2];
			playerD[i] = userinputScores[i][3];
		}

		FindplayerB(playerB);
		FindplayerA(playerA);

		for(int i = 0; i<playerA.length; i++)
		{
			holeA = playerA[i];
			holeB = playerB[i];
			holeC = playerC[i];
			holeD = playerD[i];
			if(holeA < holeB && holeA < holeC && holeA < holeD)
			{
				countA++;
			}
			else if(holeB < holeA && holeB < holeC && holeB < holeD)
			{
				countB++;
			}
			else if(holeC < holeA && holeC < holeB && holeC < holeD)
			{
				countC++;
			}
			else
			{
				countD++;
			}
		}
		sumA = getTotal(playerA);
		sumB = getTotal(playerB);
		sumC = getTotal(playerC);
		sumD = getTotal(playerD);
		sumsArray[0] = sumA;
		sumsArray[1] = sumB;
		sumsArray[2] = sumC;
		sumsArray[3] = sumD;
		for(int i = 0; i < sumsArray.length-1; i++)
		{
			for(int j = 0; j< sumsArray.length-1; j++)
			{
				if(sumsArray[j]>sumsArray[j+1])
				{
					out = sumsArray[j];
					sumsArray[j] = sumsArray[j+1];
					sumsArray[j+1] = out;
				}
			}
		}
		if(sumsArray[0] == sumA)
		{
			System.out.println(countA);
		}
		else if(sumsArray[0]== sumB)
		{
			System.out.println(countB);
		}
		else if(sumsArray[0]==sumC)
		{
			System.out.println(countC);
		}
		else
		{
			System.out.println(countD);
		}



		sumA2 = getTotal(playerA);
		sumB2 = getTotal(playerB);
		sumC2 = getTotal(playerC);
		sumD2 = getTotal(playerD);
		sumsArray2[0] = sumA2;
		sumsArray2[1] = sumB2;
		sumsArray2[2] = sumC2;
		sumsArray2[3] = sumD2;

		//sorts low to scores;
		for(int i = 0; i < sumsArray2.length-1; i++)
		{
			for(int j = 0; j< sumsArray2.length-1; j++)
			{
				if(sumsArray2[j]>sumsArray2[j+1])
				{
					out = sumsArray2[j];
					sumsArray2[j] = sumsArray2[j+1];
					sumsArray2[j+1] = out;
				}
			}
		}

		for(int i = 0; i<sumsArray2.length; i++)
		{
			if(sumsArray2[i] == sumA2)
			{

				System.out.print("A");
			}
			else if(sumsArray2[i] == sumB2)
			{
				System.out.print("B");
			}
			else if(sumsArray2[i] == sumC2)
			{
				System.out.print("C");
			}
			else
			{
				System.out.print("D");
			}
			if(i < 3)
			{
				System.out.print(",");
			}
			else
			{
				System.out.println();
			}
		}
		for(int i = 0; i< largeArray.length; i++)
		{
			if(i<9)
			{
				largeArray[i] = playerA[i];
			}
			else if(i >= 9 && i < 18)
			{
				largeArray[i] = playerB[(i-9)];
			}
			else if(i >= 18 && i < 27)
			{
				largeArray[i] = playerC[(i-18)];
			}
			else
			{
				largeArray[i] = playerD[(i-27)];
			}
		}
		for(int i = 0; i<largeArray.length-1; i++ )
		{
			for(int j = 0; j<largeArray.length-1; j++)
			{
				if (largeArray[j]>largeArray[j+1])
				{
					out = largeArray[j];
					largeArray[j] = largeArray[j+1];
					largeArray[j+1] = out;
				}
			}
		}//stick all in one array
		System.out.println((largeArray[17]+largeArray[18]) / 2);
	}
}