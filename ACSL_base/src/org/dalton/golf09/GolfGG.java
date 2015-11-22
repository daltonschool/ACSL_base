package org.dalton.golf09;
import java.util.Scanner;
public class GolfGG 
{
	/*
	 * Name: Gabriella R. Garbasz
	 * School Number: 9010
	 * The Dalton School
	 */
	
	public static int[] convert(String [] temp)
	{
		int [] data = {0, 0, 0, 0};
		
		for(int i = 0; i<4; i++)
		{
			data[i] = Integer.parseInt(temp [i]);
		}
		return data;
	}
	public static String playerB(int scoreB)
	{
		String answer1 = "";
		if(scoreB > 36)
		{
			int temp = scoreB-36;
			String newtemp = Integer.toString(temp);
			answer1 = (temp+" over par");
		}
		else if(scoreB==36)
		{
			answer1 = ("par");
		}
		else if(scoreB<36)
		{
			int temp2 = 36-scoreB;
			String newtemp2 = Integer.toString(temp2);
			answer1 = (temp2+ " under par");
		}
		
		return answer1;
	}
	
	public static String playerA(int scoreA)
	{
		String answer2 = "";
		if(scoreA > 36)
		{
			int temp = scoreA-36;
			String newtemp = Integer.toString(temp);
			answer2 = (temp+" over par");
		}
		else if(scoreA==36)
		{
			answer2 = ("par");
		}
		else if(scoreA<36)
		{
			int temp2 = 36-scoreA;
			String newtemp2 = Integer.toString(temp2);
			answer2 = (temp2+ " under par");
		}
		
		return answer2;
	}
	
	public static void orderScores(int [] scores, int w1, int w2, int w3, int w4, int w5, int w6, int w7, int w8, int w9)
	{
		int out = 0;
		int A = scores[0];
		int B = scores[1];
		int C = scores[2];
		int D = scores[3];
		int counter = 0;
		for(int i = 0; i<(scores.length-1); i++)
		{
			for(int j = 0; j<(scores.length-1); j++)
			{
				if(scores[j]>scores[j+1])
				{
					out = scores[j];
					scores[j] = scores[j+1];
					scores[j+1] = out;
				}
			}
		}
		
		int p1 = scores[0];
		int p2 = scores[1];
		int p3 = scores[2];
		int p4 = scores[3];
		
		String [] finalscores = {null, null, null, null};
		
		for(int k = 0; k<4; k++)
		{
			if(A==scores[k])
			{
				finalscores[k] = "A";
			}
			else if(B==scores[k])
			{
				finalscores[k] = "B";
			}
			else if(C==scores[k])
			{
				finalscores[k] = "C";
			}
			else if(D==scores[k])
			{
				finalscores[k] = "D";
			}
		}
		
		
		if(finalscores[0].equals("A"))
		{
			if(w1 == 1)
			{
				counter++;
			}
			if(w2 == 1)
			{
				counter++;
			}
			if(w3 == 1)
			{
				counter++;
			}
			if(w4 == 1)
			{
				counter++;
			}
			if(w5 == 1)
			{
				counter++;
			}
			if(w6 == 1)
			{
				counter++;
			}
			if(w7 == 1)
			{
				counter++;
			}
			if(w8 == 1)
			{
				counter++;
			}
			if(w9 == 1)
			{
				counter++;
			}
		}
		
		else if(finalscores[0].equals("B"))
		{
			if(w1 == 2)
			{
				counter++;
			}
			if(w2 == 2)
			{
				counter++;
			}
			if(w3 == 2)
			{
				counter++;
			}
			if(w4 == 2)
			{
				counter++;
			}
			if(w5 == 2)
			{
				counter++;
			}
			if(w6 == 2)
			{
				counter++;
			}
			if(w7 == 2)
			{
				counter++;
			}
			if(w8 == 2)
			{
				counter++;
			}
			if(w9 == 2)
			{
				counter++;
			}
		}
		else if(finalscores[0].equals("C"))
		{
			if(w1 == 3)
			{
				counter++;
			}
			if(w2 == 3)
			{
				counter++;
			}
			if(w3 == 3)
			{
				counter++;
			}
			if(w4 == 3)
			{
				counter++;
			}
			if(w5 == 3)
			{
				counter++;
			}
			if(w6 == 3)
			{
				counter++;
			}
			if(w7 == 3)
			{
				counter++;
			}
			if(w8 == 3)
			{
				counter++;
			}
			if(w9 == 3)
			{
				counter++;
			}
		}
		else if(finalscores[0].equals("D"))
		{
			if(w1 == 4)
			{
				counter++;
			}
			if(w2 == 4)
			{
				counter++;
			}
			if(w3 == 4)
			{
				counter++;
			}
			if(w4 == 4)
			{
				counter++;
			}
			if(w5 == 4)
			{
				counter++;
			}
			if(w6 == 4)
			{
				counter++;
			}
			if(w7 == 4)
			{
				counter++;
			}
			if(w8 == 4)
			{
				counter++;
			}
			if(w9 == 4)
			{
				counter++;
			}
		}
		int answer3 = counter;
		String answer4 = (finalscores[0]+", "+finalscores[1]+", "+finalscores[2]+", "+finalscores[3]);
		System.out.println(answer3);
		System.out.println(answer4);
	}
	
	public static double median(int [] totalScores)
	{
		int out = 0;
		for(int i = 0; i<(totalScores.length-1); i++)
		{
			for(int j = 0; j<(totalScores.length-1); j++)
			{
				if(totalScores[j]>totalScores[j+1])
				{
					out = totalScores[j];
					totalScores[j] = totalScores[j+1];
					totalScores[j+1] = out;
				}
			}
		}
		
		double answer5 = 0.00;
		double first = (double)totalScores[17];
		double second = (double)totalScores[18];
		answer5 = (first+second)/2.0;
		return answer5;
		
	}
	
	public static int winner(int[]hole)
	{
		int temp = 0;
		int out = 0;
		int A = hole[0];
		int B = hole[1];
		int C = hole[2];
		int D = hole[3];
		int answer3 = 0;
		
		for(int i = 0; i<(hole.length-1); i++)
		{
			for(int j = 0; j<(hole.length-1); j++)
			{
				if(hole[j]>hole[j+1])
				{
					out = hole[j];
					hole[j] = hole[j+1];
					hole[j+1] = out;
				}
			}
		}
		
		temp = hole[0];
		if(hole[1]==temp)
		{
			answer3 = 0;
		}
		else
		{
			if(hole[0]==A)
			{
				answer3 = 1;
			}
			else if(hole[0]==B)
			{
				answer3 = 2;
			}
			else if(hole[0]==C)
			{
				answer3 = 3;
			}
			else if(hole[0]==D)
			{
				answer3 = 4;
			}
			
			
		}
		return answer3;
		
	}
	
	public static void main(String[] args) 
	{
		Scanner n = new Scanner(System.in);
		int par = 36;
		
		System.out.println("Enter the data");
		String line1 = n.nextLine();
		String line2 = n.nextLine();
		String line3 = n.nextLine();
		String line4 = n.nextLine();
		String line5 = n.nextLine();
		String line6 = n.nextLine();
		String line7 = n.nextLine();
		String line8 = n.nextLine();
		String line9 = n.nextLine();
		
		String [] temp1 = line1.split(",");
		String [] temp2 = line2.split(",");
		String [] temp3 = line3.split(",");
		String [] temp4 = line4.split(",");
		String [] temp5 = line5.split(",");
		String [] temp6 = line6.split(",");
		String [] temp7 = line7.split(",");
		String [] temp8 = line8.split(",");
		String [] temp9 = line9.split(",");
		
		int [] hole1 = convert(temp1);
		int [] hole2 = convert(temp2);
		int [] hole3 = convert(temp3);
		int [] hole4 = convert(temp4);
		int [] hole5 = convert(temp5);
		int [] hole6 = convert(temp6);
		int [] hole7 = convert(temp7);
		int [] hole8 = convert(temp8);
		int [] hole9 = convert(temp9);
		
		int scoreA = hole1[0]+hole2[0]+hole3[0]+hole4[0]+hole5[0]+hole6[0]+hole7[0]+hole8[0]+hole9[0];
		int scoreB = hole1[1]+hole2[1]+hole3[1]+hole4[1]+hole5[1]+hole6[1]+hole7[1]+hole8[1]+hole9[1];
		int scoreC = hole1[2]+hole2[2]+hole3[2]+hole4[2]+hole5[2]+hole6[2]+hole7[2]+hole8[2]+hole9[2];
		int scoreD = hole1[3]+hole2[3]+hole3[3]+hole4[3]+hole5[3]+hole6[3]+hole7[3]+hole8[3]+hole9[3];

		int [] scores = {scoreA, scoreB, scoreC, scoreD};
		
		int [] totalScores = new int [36];
		totalScores[0] = hole1[0];
		totalScores[1] = hole1[1];
		totalScores[2] = hole1[2];
		totalScores[3] = hole1[3];
		totalScores[4] = hole2[0];
		totalScores[5] = hole2[1];
		totalScores[6] = hole2[2];
		totalScores[7] = hole2[3];
		totalScores[8] = hole3[0];
		totalScores[9] = hole3[1];
		totalScores[10] = hole3[2];
		totalScores[11] = hole3[3];
		totalScores[12] = hole4[0];
		totalScores[13] = hole4[1];
		totalScores[14] = hole4[2];
		totalScores[15] = hole4[3];
		totalScores[16] = hole5[0];
		totalScores[17] = hole5[1];
		totalScores[18] = hole5[2];
		totalScores[19] = hole5[3];
		totalScores[20] = hole6[0];
		totalScores[21] = hole6[1];
		totalScores[22] = hole6[2];
		totalScores[23] = hole6[3];
		totalScores[24] = hole7[0];
		totalScores[25] = hole7[1];
		totalScores[26] = hole7[2];
		totalScores[27] = hole7[3];
		totalScores[28] = hole8[0];
		totalScores[29] = hole8[1];
		totalScores[30] = hole8[2];
		totalScores[31] = hole8[3];
		totalScores[32] = hole9[0];
		totalScores[33] = hole9[1];
		totalScores[34] = hole9[2];
		totalScores[35] = hole9[3];
		
		
		
		
		String answer1 = playerB(scoreB);
		String answer2 = playerA(scoreA);
		int w1 = winner(hole1);
		int w2 = winner(hole2);
		int w3 = winner(hole3);
		int w4 = winner(hole4);
		int w5 = winner(hole5);
		int w6 = winner(hole6);
		int w7 = winner(hole7);
		int w8 = winner(hole8);
		int w9 = winner(hole9);
		
		
		double tempAnswer5 = median(totalScores);

		System.out.println(answer1);
		System.out.println(answer2);
		orderScores(scores, w1, w2, w3, w4, w5, w6, w7, w8, w9);
		int answer5 = 0;
		if(tempAnswer5%1 == 0.0)
		{
			answer5 = (int)tempAnswer5;
			System.out.println(answer5);
		}
		else
		{
			System.out.println(tempAnswer5);
		}
		
		
		
	}//ends main

}//ends program
