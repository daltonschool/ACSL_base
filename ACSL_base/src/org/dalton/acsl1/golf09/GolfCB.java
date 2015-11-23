package org.dalton.acsl1.golf09;
import java.util.Scanner;

/**
 * 
 * @author Cara Borenstein
 * The Dalton School
 * ACSL
 * 9101
 *
 *
 */
public class GolfCB {
	
	static Scanner scan = new Scanner(System.in);
	static double scoresArray[][] = new double[4][9];

	/**
	 * playerB's score in relation to par
	 * @param par-36
	 */
	public static void displayPlayerB(int par)
	{
		int row = 1;
		int total = 0;
		int relPar = 0; //relation of score to par
		for(int col = 0; col<9;col++)
		{
			total += scoresArray[row][col];
			
		}
		
		relPar = par-total;
		
		if(relPar>0)
		{
			System.out.println(relPar + " under par");
		}
		else if(relPar ==0)
		{
			System.out.println("par");
		}
		else if(relPar<0)
		{
			relPar = -relPar;
			System.out.println(relPar + " over par");
		}
	}

	/**
	 * playerA's score in relation to par
	 * @param par�36
	 */
	public static void displayPlayerA(int par)
	{
		int row = 0;
		int total = 0;
		int relPar = 0; //relation of score to par
		for(int col = 0; col<9;col++)
		{
			total += scoresArray[row][col];
			
		}
		
		relPar = par-total;
		
		if(relPar>0)
		{
			System.out.println(relPar + " under par");
		}
		else if(relPar ==0)
		{
			System.out.println("par");
		}
		else if(relPar<0)
		{
			relPar = -relPar;
			System.out.println(relPar + " over par");
		}
	}	
	
	/**
	 * calculates total numbers the winning player (winner) won.  int a,b,c are the players that did not win
	 */
	public static void holesWon(int winner, int a, int b, int c)
	{
		int total = 0;
		for(int holeNum = 0; holeNum<9; holeNum++)
		{
			if(scoresArray[winner][holeNum]<scoresArray[a][holeNum])
			{
				if(scoresArray[winner][holeNum]<scoresArray[b][holeNum])
				{
					if(scoresArray[winner][holeNum]<scoresArray[c][holeNum])
					{
						total +=1;
					}
				}
			}
		}
		System.out.println(total);

	}
	
	/**
	 * orders players based on total score (from least to greatest)
	 * @param totalA�total score of playerA
	 * @param totalB�total score of playerB
	 * @param totalC�total score of playerC
	 * @param totalD�total score of playerD
	 */
	public static void order(double totalA, double totalB, double totalC, double totalD)
	{
		double arrayTotal[] = new double[5];
		arrayTotal[0] = totalA;
		arrayTotal[1] = totalB;
		arrayTotal[2] = totalC;
		arrayTotal[3] = totalD;
		arrayTotal[4] = totalA + totalB + totalC + totalD; //bigger than all of the totals --> last

		for(int i = 0; i<4; i++)
		{
			for(int j = 0; j<4; j++)
			{
				
				if(arrayTotal[j]>arrayTotal[j+1])
				{
					double out = arrayTotal[j];
					arrayTotal[j] = arrayTotal[j+1];
					arrayTotal[j+1] = out;
				}
				
			}
			
		}
				
		if(arrayTotal[0] == totalA)
		{
			System.out.print("3. ");
			holesWon(0,1,2,3);
		}
			
		else if(arrayTotal[0] == totalB)
		{
			System.out.print("3. ");
			holesWon(1,0,2,3);
		}
		else if(arrayTotal[0] == totalC)
		{
			System.out.print("3. ");
			holesWon(2,0,1,3);
		}
		else if(arrayTotal[0] == totalD)
		{
			System.out.print("3. ");
			holesWon(3,0,1,2);
		}
		
		System.out.print("4. ");
		
		for(int n = 0; n<5; n++)
		{
			if(n !=3)
			{
				if(arrayTotal[n] == totalA)
				{
					System.out.print("A,");
				}
				else if(arrayTotal[n] == totalB)
				{
					System.out.print("B,");
				}
				else if(arrayTotal[n] == totalC)
				{
					System.out.print("C,");
				}
				else if(arrayTotal[n] == totalD)
				{
					System.out.print("D,");
				}
				
			}
			else if(n ==3)
			{
				if(arrayTotal[3] == totalA)
				{
					System.out.print("A");
				}
				else if(arrayTotal[3] == totalB)
				{
					System.out.print("B");
				}
				else if(arrayTotal[3] == totalC)
				{
					System.out.print("C");
				}
				else if(arrayTotal[3] == totalD)
				{
					System.out.print("D");
				}
				System.out.println(" ");
				
			}
		}
		
	
	}

	public static void median()
	{
		double singleArray[] = new double[36];
		int n =0; 
		//converts double array into single array
		for(int r = 0; r<4; r++)
		{
			for(int c = 0; c<9; c++)
			{	
				singleArray[n] = scoresArray[r][c];
				n = n+1;					
			}
				
		}
		//changes order of elements in single array so it goes from least to greatest
		for(int i = 0; i<35; i++)
		{
			for(int j = 0; j<35;j++)
			{
				if(singleArray[j]>singleArray[j+1])
				{
					double out = singleArray[j];
					singleArray[j] = singleArray[j+1];
					singleArray[j+1] = out;
				}
			}
			
		}
		
		double median = (singleArray[17] + singleArray[18])/2;
		
		int m = (int) median;
		if(median%1.0 ==0) //remainder when divided by 1 is 0 --> display as int
		{
			System.out.println(m);
		}
		else if(median%1.0 != 0) //remainder when divided by 1 is not 0 --> has decimal place and display as double
		{
			System.out.println(median);

		}
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double totalA = 0;
		double totalB = 0;
		double totalC = 0;
		double totalD = 0;
		int par = 36; //3+4+5+4+4+4+5+3+4
	
		for(int holeNum = 0; holeNum<9; holeNum++)
		{
			System.out.println("Enter the score for player A,B,C, and D in the format A,B,C,D for hole " + holeNum);
			String [] array = scan.nextLine().split(",");
			
			double A = Double.parseDouble(array[0]);
			double B = Double.parseDouble(array[1]);
			double C = Double.parseDouble(array[2]);
			double D = Double.parseDouble(array[3]);
			
			scoresArray[0][holeNum] = A; 
			scoresArray[1][holeNum] = B; 
			scoresArray[2][holeNum] = C;
			scoresArray[3][holeNum] = D; 
			
			totalA += A;
			totalB +=B;
			totalC +=C;
			totalD +=D;

		}
		
		System.out.print("1. ");
		displayPlayerB(par);
		System.out.print("2. ");
		displayPlayerA(par);
		order(totalA,totalB,totalC,totalD);
		System.out.print("5. ");
		median();
	
	}

}
