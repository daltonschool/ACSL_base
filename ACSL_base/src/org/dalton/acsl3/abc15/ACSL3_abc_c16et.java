package org.dalton.acsl3.abc15;
import java.util.Scanner;

public class ACSL3_abc_c16et {

	//function to make it to grid 2
	public static String[][] blocked(String[] stringIn, int[][]g1){
		String[][] blocked = new String[6][6];

		for(int i=0; i<6; i++){
			for(int j=0; j<6; j++){
				blocked[i][j]="-";
			}
		}

		//find filled spots
		for(int i=0; i<4; i++){
			int block = Integer.parseInt(stringIn[i]);
			int r = (int) Math.floor(block/6);
			int c = block-1-6*r;
			//System.out.println("g1[r][c] = " + g1[r][c]);
			blocked[r][c] = "0";
		}

		return blocked;
	}

	public static String[][] initletters(String[] stringIn, String[][] g2){
		String[][] g3 = new String[6][6];

		//put in first letters given
		int num = Integer.parseInt(stringIn[4]);
		for(int i=0; i<num; i++){
			int place = Integer.parseInt(stringIn[6+2*i]);
			//System.out.println("place is " + place + " and i is " + i);
			String letter = stringIn[5+2*i];
			int r = (int) Math.floor((place-1)/6);
			int c = place-1-6*r;

			//top row
			if(r==0){
				if(g2[1][c].equals("0")){
					r=2;
				}
				else r=1;
			}
			//first column
			else if(c==0) {	
				if(g2[r][1].equals("0")){
					c=2;
				}
				else c=1;
			}
			//bottom row
			else if(r==5) {	
				if(g2[4][c].equals("0")){
					r=3;
				}
				else r=4;
			}
			//last column
			else if(c==5){	
				if(g2[r][4].equals("0")){
					c=3;
				}
				else c=4;
			}
			//System.out.println("place is " + place + "r is " + r + " and c is " + c);
			g2[r][c]=letter;
		}

		return g2;
	}

	public static String[][] fourbyfour(String[][]g2){
		String[][] g3 = new String[4][4];
		for(int i=1; i<5; i++){
			for(int j=1; j<5; j++){
				g3[i-1][j-1]=g2[i][j];
			}
		}

		return g3;
	}

	//make A=1, B=2, C=3, D=0
	public static int[][] makenums(String[][]g2){
		int[][] g3 = new int[4][4];
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				if(g2[i][j].equals("A")) g3[i][j]=1;
				else if(g2[i][j].equals("B")) g3[i][j]=2;
				else if(g2[i][j].equals("C")) g3[i][j]=3;
				else if(g2[i][j].equals("0")) g3[i][j]=0;
				else if(g2[i][j].equals("-")) g3[i][j]=5;
			}
		}

		return g3;
	}

	public static int[][] solve(int[][]g3new, String[]stringIn){
		//check if there are any rows with 1 empty spot
		for(int l=0; l<10; l++){
			for(int r=0; r<4; r++){
				for(int c=0; c<4; c++){
					//System.out.println("in columns + r=" + r + " c=" + c);
					if(g3new[r][c]==5){
						//System.out.println("g3new[r][c]=5 r=" + r + " c=" +c);
						boolean A=false;
						boolean B=false;
						boolean C=false;
						boolean D=false;
						int truenum = 0;
						//first go through rows, then columns to find things it can't be
						for(int x=0; x<4; x++){
							//System.out.println("in for");
							if(g3new[x][c]==1||g3new[r][x]==1){
								A=true;
								truenum++;
								//System.out.println(truenum + " in A");
							}
							else if(g3new[x][c]==2||g3new[r][x]==2){
								B=true;
								truenum++;
								//System.out.println(truenum + " in B");	
							}
							else if(g3new[x][c]==3||g3new[r][x]==3){
								C=true;
								truenum++;
								//System.out.println(truenum + " in C");	
							}
							else if(g3new[x][c]==0||g3new[r][x]==0){
								D=true;
								truenum++;
								//System.out.println(truenum + " in D");
							}
							//System.out.println("x is " + x + " and truenum is " + truenum);
						}
						//if there are 3 things it can't be
						if(truenum>=3){
							if(A==false) g3new[r][c]=1;
							else if(B==false) g3new[r][c]=2;
							else if(C==false) g3new[r][c]=3;
						}
					}
				}//for columns
			}//for rows
		}//while
		return g3new;
	}

	public static char[][] backtoletters(int[][]g4){
		char[][] solved = new char[4][4];

		for(int r=0; r<4; r++){
			for(int c=0; c<4; c++)
			{
				if(g4[r][c]==0) solved[r][c]='0';
				else if(g4[r][c]==1) solved[r][c]='A';
				else if(g4[r][c]==2) solved[r][c]='B';
				else if(g4[r][c]==3) solved[r][c]='C';
			}
		}


		return solved;
	}
	
	public static String solution(char[][]solved){
		String solution = "";
		
		for(int r=0; r<4; r++){
			for(int c=0; c<4; c++){
				if(solved[r][c]!='0'){
					solution+=solved[r][c];
				}
			}
		}
		
		return solution;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for(int x=0; x<5; x++) {
			//take in input
			String[] stringIn = scan.nextLine().split(", ");
			//make g1 and fill
			int[][] g1 = new int[6][6];
			for(int i=0; i<6; i++){
				for(int j=0; j<6; j++){
					g1[i][j]=6*i+j+1;
				}
			}

			//find blocked spaces in g1
			String [][] g2 = blocked(stringIn, g1);

			//put letters in the right spaces
			initletters(stringIn, g2);

			//make into a 4x4
			String[][] g3 = fourbyfour(g2);

			//make into chars
			int[][] g3new = makenums(g3);

			//solve
			int[][] g4 = solve(g3new, stringIn);

			//put back into letters
			char[][] solved = backtoletters(g4);
			
			String solution = solution(solved);

//			//print after blocking
//			for(int i=0; i<4; i++){
//				for(int j=0; j<4; j++){
//					System.out.print(g4[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			System.out.println(solution);

		}

	}
}
