package org.dalton.acsl3.mancala10;

/* Darshan Desai
 * ASCL 3
 * 9075
 */
import java.util.Scanner;
public class mancalaFinal {
	static int[] mancalaBoards = new int[14];
	static boolean playerA=true;
	public static void main (String[] args){
		for (int i=0;i<mancalaBoards.length; i++){	
			mancalaBoards[i]=4;
			mancalaBoards[6]=0;
			mancalaBoards[13]=0;
			}
		for (int k=0; k<5; k++){	
			if (k==0||k==2||k==4) playerA=true;
			else if (k==1||k==3) playerA=false;
			Scanner scan = new Scanner(System.in);
			String input= scan.nextLine();
			String[]b = input.split(",");
			int startingBox = Integer.parseInt(b[0].trim());
			int boxToCheck;
			if (b[1].contains("A")|| b[1].contains("a")) boxToCheck= 6;
			else if (b[1].contains("B")|| b[1].contains("b"))boxToCheck= 13;
			else {
				boxToCheck=Integer.parseInt(b[1].trim());
				if (boxToCheck<=6)boxToCheck--;
			}
			if (startingBox<=6)startingBox--;
			int l=startingBox;
			dropPiece(l);
			System.out.println(mancalaBoards[boxToCheck]);
		}
	}
	public static void dropPiece(int l){  
		int handPieces=mancalaBoards[l];
		mancalaBoards[l]=0;
		while (handPieces>0){	
			l++;
			if (l==6&&!playerA)l++;
			if (l==13&&playerA)l=0;
			if (l==13&&!playerA&&handPieces>0){			
				mancalaBoards[l]++;
				handPieces=handPieces-1;
				l=0;			
				}
			mancalaBoards[l]++;
			handPieces =handPieces-1;
		}	
		if ((!(l==6&&playerA==true&&handPieces==0))&&(!(l==13&&playerA==false&&handPieces==0))&&(!(mancalaBoards[l]==1||mancalaBoards[l]==4) && l<13))dropPiece(l);
	}
}