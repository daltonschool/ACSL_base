package org.dalton.acsl3.abc15;
import java.awt.List;
import java.util.Arrays;
import java.util.Scanner;
/*Charlie DiPrinzio
 * 3/9/16
 * ACSL #3 ABC 
 * 
 */

public class ACSL3_abc15_c16cd {

	public static void main (String[] args){

		Scanner scan = new Scanner(System.in);

		for (int f = 0; f < 5; f++) {


			//Initialize Board and fill with numbers:
			String [][] board = new String[6][6];

			board[0][0] = "1";

			int num = 1;
			for (int j = 0; j < board.length; j++) {
				for (int j2 = 0; j2 < board.length; j2++) {
					String n = Integer.toString(num);
					board[j][j2] = n;
					num++;
				}
			}
			//print(board);




			//Take input
			String input = scan.nextLine();
			String [] inputs = input.split(", ");

			//Fill Table
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < board.length; j++) {
					for (int j2 = 0; j2 < board.length; j2++) {
						if(board[j][j2].equals(inputs[i])) board[j][j2] = "X";
					}
				}
			}
			//print(board);


			int initialLetters = Integer.parseInt(inputs[4]);
			int mult = initialLetters*2;

			//Place Letters in outer board:
			//		for (int i = 5; i < inputs.length; i++) {
			//			System.out.println(inputs[i]);
			//		}

			for (int i = 5; i < inputs.length; i+=2) {
				place(inputs[i], inputs[i+1], board);
			}
			//print(board);


			placeNotX("A", board);
			placeNotXCol("A", board);
			placeNotX("B", board);
			placeNotXCol("B", board);
			placeNotX("C", board);
			placeNotXCol("C", board);


			//print(board);





			//Solve:

			//Iterate Thru each open space in Inner Grid

			int tal = 0;

			//while(tal<16) {	
			//tal = 0;
			//System.out.println("here");
			for (int k = 0; k < 100; k++) {



				for (int j = 1; j < board.length-1; j++) {
					for (int j2 = 1; j2 < board.length-1; j2++) {

						//Check if space is empty
						if(!board[j][j2].equals("X")&&!board[j][j2].equals("A")&&!board[j][j2].equals("B")&&!board[j][j2].equals("C")){
							//System.out.println("empty: " + board[j][j2]);

							//Row:
							String[] test = new String [4]; 	

							if(rowTalley(board, j)>2){
								//System.out.println("row: " + board[j][j2]);
								for (int i = 1; i < board.length-1; i++) {
									test[i-1]=board[j][i]; 
								}
								board[j][j2]= missingLet(test);
							}
							//Column:
							else if(colTalley(board, j2)>2){
								//System.out.println("col: " + board[j][j2]);
								for (int i = 1; i < board.length-1; i++) {
									test[i-1]=board[i][j2]; 
								}
								board[j][j2]= missingLet(test);
							}


							else if(rowTalley(board, j)==2&&colTalley(board, j2)==2){
								//System.out.println("double: " + board[j][j2]);

								String[] row = new String [4]; 
								String[] col = new String [4];
								for (int i = 1; i < board.length-1; i++) {
									row[i-1]=board[j][i];
									col[i-1]=board[i][j2];
								}
								java.util.List<String> r = Arrays.asList(row);
								java.util.List<String> c = Arrays.asList(col);

								if(r.contains("A")&&c.contains("B")) board[j][j2]="C";
								else if(r.contains("B")&&c.contains("C")) board[j][j2]="A";
								else if(r.contains("C")&&c.contains("A"))board[j][j2]="B";	
								else if(r.contains("B")&&c.contains("A"))board[j][j2]="C";
								else if(r.contains("C")&&c.contains("B"))board[j][j2]="A";
								else if(r.contains("A")&&c.contains("C"))board[j][j2]="B";


							}

						}//if empty

						//Check if space is empty
						//else if(!board[j][j2].equals("X")&&!board[j][j2].equals("A")&&!board[j][j2].equals("B")&&!board[j][j2].equals("C")){

						//}

						else {
							tal++;
							//System.out.println("tal");
						}


					}//j2
				}//j

				//tal++;
			}//k

			//		for (int j = 1; j < board.length-1; j++) {
			//			for (int j2 = 1; j2 < board.length-1; j2++) {
			//				//Check if space is empty
			//			
			//			}//J2
			//
			//		}//j

			//print(board);

			String [] output = new String [12];
			int iter= 0; 
			for (int j = 1; j < board.length-1; j++) {
				for (int j2 = 1; j2 < board.length-1; j2++) {
					if(!board[j][j2].equals("X")){
						output[iter]=board[j][j2];
						iter++;
					}
				}
			}

			for (int i = 0; i < output.length; i++) {

				System.out.print(output[i]);
			}

		}//for f: 5 inputs

	}






	public static String missingLet(String[] array){
		java.util.List<String> l = Arrays.asList(array);
		if(l.contains("A")&&l.contains("B")) return "C";
		else if(l.contains("B")&&l.contains("C")) return "A";
		else return "B";

	}



	public static int rowTalley(String[][] board, int j){
		int talley = 0;
		for (int i = 1; i < board.length-1; i++) {
			if(board[j][i].equals("X")||board[j][i].equals("A")||board[j][i].equals("B")||board[j][i].equals("C")){
				talley++;
			}
		}

		return talley;
	}

	public static int colTalley(String[][] board, int j2){
		int talley = 0;
		for (int i = 1; i < board.length-1; i++) {
			if(board[i][j2].equals("X")||board[i][j2].equals("A")||board[i][j2].equals("B")||board[i][j2].equals("C")){
				talley++;
			}
		}

		return talley;
	}


	public static void placeNotX(String placing, String [][] array){
		for (int i = 1; i < array.length-1; i++) {
			boolean xtrue = true;

			if(array[0][i].equals(placing)){	
				int col = 1;
				while(xtrue){
					if(!array[col][i].equals("X")){
						array[col][i]=placing;
						xtrue=false;
					}
					else col++;
				}
			}
			if(array[5][i].equals(placing)){	
				int col = 4;
				while(xtrue){
					if(!array[col][i].equals("X")){
						array[col][i]=placing;
						xtrue=false;
					}
					else col--;
				}
			}
		}
	}
	public static void placeNotXCol(String placing, String [][] array){
		for (int i = 1; i < array.length-1; i++) {
			boolean xtrue = true;

			if(array[i][0].equals(placing)){	
				int col = 1;
				while(xtrue){
					if(!array[i][col].equals("X")){
						array[i][col]=placing;
						xtrue=false;
					}
					else col++;
				}
			}
			if(array[i][5].equals(placing)){	
				int col = 4;
				while(xtrue){
					if(!array[i][col].equals("X")){
						array[i][col]=placing;
						xtrue=false;
					}
					else col--;
				}
			}
		}
	}


	public static void place(String placing, String spot, String [][] array){
		for (int j = 0; j < array.length; j++) {
			for (int j2 = 0; j2 < array.length; j2++) {
				if(array[j][j2].equals(spot)) array[j][j2] = placing;
			}
		}

	}
	public static void print(String[] [] array){
		System.out.println("");
		for (int i = 0; i < array.length ; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
