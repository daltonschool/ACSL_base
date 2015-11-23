package org.dalton.acsl3.chess12;
import java.util.Scanner;

//Jemma Issroff

public class ChessQueenJI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String res = "";
		for(int j=0; j<5; j++){
			String line = scanner.nextLine().replace(",","").replace(" ", "");
			line=line.substring(0, line.length()-2);
			int[] board = new int[89];

			for(int i=0; i<line.length(); i+=2){
				addPiece(Character.toString(line.charAt(i))+Character.toString(line.charAt(i+1)), board);
			}
			res = "None";

			int num = line.length()/2;
			if(num>0){
				for(int i=10; i<board.length; i++){
					if(board[i]==num && i%10!=0 && i%10!=9){
						res=String.valueOf(i).charAt(0)+", "+String.valueOf(i).charAt(1);
						break;
					}
				}
			}

			System.out.println(res);
		}
	}
	public static int[] addPiece(String piece, int[]board){
		for(int i=0; i<board.length; i++){
			if(i%10==Integer.parseInt(Character.toString(piece.charAt(1))) || piece.charAt(0)==Integer.toString(i).charAt(0)){ 
				if(i!=Integer.parseInt(piece)){ 
					board[i]++; 
				}
			}
		}
		int p = Integer.parseInt(piece);
		board=diag(p, -11, board);
		board=diag(p, -9, board);
		board=diag(p, 11, board);
		board=diag(p, 9, board);
		return board;
	}
	private static int[] diag(int piece, int mod, int[] board) {
		for(int i=piece; i<89; i+=mod){
			if(i%10==0 || i%10==9 || i<0) break;
			if(i!=piece) board[i]+=1;
		}
		return board;
	}
}
