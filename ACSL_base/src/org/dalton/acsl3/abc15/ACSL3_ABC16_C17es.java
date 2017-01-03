package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class ACSL3_ABC16_C17es {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/abc16";
		Scanner scan;
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			//switch to regular terminal input
			scan = new Scanner(System.in);
		}

		//main loop:
		while(scan.hasNext()) {
			String answer = solve(scan.nextLine());
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}

		fop.flush();
		fop.close();
		scan.close();
	}
	public void print(String[][] i){
		for(int r = 0; r < i.length; r++) {
			for(int c = 0; c < i[0].length; c++) {

				//System.out.print(i[r][c] + " ");
			}
			//System.out.print("\n");
		}
	}
	static String solve(String s) {
		String[] input = null; 
		int count = 8;
		int l =5;
		String[][] innerboard = new String[4][4];

		input = s.split(",[ ]*");
		String[][] info = new String[Integer.parseInt(input[4])][2];
		for(int r = 0; r < info.length; r++) {
			for(int c = 0; c < info[0].length; c++) {

				info[r][c] = input[l];
				l++;
			}


		}

		for(int r = 0; r < innerboard.length; r++) {
			for(int c = 0; c < innerboard[0].length; c++) {

				innerboard[r][c] = Integer.toString(count);
				count++;
			}
			count = count+2;

		}
		for(int r = 0; r < innerboard.length; r++) {
			for(int c = 0; c < innerboard[0].length; c++) {

				//System.out.print(innerboard[r][c] + " ");
			}
			//System.out.print("\n");
		}
		String[] blocked = new String[4];
		for(int r = 0; r < blocked.length; r++) {
			blocked[r]=input[r];
		}
		for(int r = 0; r < innerboard.length; r++) {
			for(int c = 0; c < innerboard[0].length; c++) {

				if(Integer.parseInt(innerboard[r][c])==Integer.parseInt(blocked[0])){
					innerboard[r][c]="X";

				}
				else if(Integer.parseInt(innerboard[r][c])==Integer.parseInt(blocked[1])){
					innerboard[r][c]="X";

				}
				else if(Integer.parseInt(innerboard[r][c])==Integer.parseInt(blocked[2])){
					innerboard[r][c]="X";

				}
				else if(Integer.parseInt(innerboard[r][c])==Integer.parseInt(blocked[3])){
					innerboard[r][c]="X";

				}



			}


		}
		int number =0; 

		for(int x =0; x<info.length; x++){
			number = Integer.parseInt(info[x][1]);
			//System.out.println(number);
			boolean done = false;
			if(1<number&&number<6){

				for(int y = 0; y<4; y++){

					if(!innerboard[y][number-2].contains("X")&&done ==false){
						done = true; 
						innerboard[y][number-2]=info[x][0];
					}
					else{

					}
				}

			}


			else if(31<number&&number<36){
				for(int y = 3; y>=0; y--){
					if(!innerboard[y][number-32].contains("X")&&done ==false){
						done = true; 
						innerboard[y][number-32]=info[x][0];
					}
				}

			}
			else if((number-1)%6==0){
				for(int y = 0; y<4; y++){

					if(!innerboard[((number-1)/6)-1][y].contains("X")&&done ==false){
						done = true; 
						innerboard[((number-1)/6)-1][y]=info[x][0];
					}
					else{

					}
				}
			}
			else if((number)%6==0){
				for(int y = 3; y>=0; y--){

					if(!innerboard[((number)/6)-2][y].contains("X")&&done ==false){
						done = true; 
						innerboard[((number)/6)-2][y]=info[x][0];
					}
					else{

					}
				}
			}


		}
		
		
		//board is now set with given info 
		for(int run =0; run <40; run ++){
			for(int c = 0; c<4; c++ ){
				for(int r = 0; r<4; r++){
					//System.out.println("THE ONE IM LOOKING AT" + innerboard[r][c]);
					if(!innerboard[r][c].contains("A")&&!innerboard[r][c].contains("B")&&!innerboard[r][c].contains("C")&&!innerboard[r][c].contains("X")){
						String row = "";
						String column = "";
						for(int x =0; x<4; x++){
							
							row = row + innerboard[r][x];
							
						}
						for(int y =0; y<4; y++){
							
							column = column + innerboard[y][c];
							
						}
						//System.out.println("Strings: " + row);
						//System.out.println("Strings: " + column);
						if (row.contains("A")&&row.contains("B")){
							innerboard[r][c]="C";
						}
						else if (row.contains("A")&&row.contains("C")){
							innerboard[r][c]="B";
						}
						else if (row.contains("C")&&row.contains("B")){
							innerboard[r][c]="A";
						}
						else if (column.contains("A")&&column.contains("B")){
							innerboard[r][c]="C";
						}
						else if (column.contains("A")&&column.contains("C")){
							//System.out.println("YO DOING IT");
							innerboard[r][c]="B";
						}
						else if (column.contains("C")&&column.contains("B")){
							innerboard[r][c]="A";
						}
						else if(!row.contains("A")&&column.contains("A")){
							if(row.contains("C"))innerboard[r][c]="B";
							else if(row.contains("B"))innerboard[r][c]="C";
						}
						else if(!row.contains("B")&&column.contains("B")){
							if(row.contains("C"))innerboard[r][c]="A";
							else if(row.contains("A"))innerboard[r][c]="C";
						}
						else if(!row.contains("C")&&column.contains("C")){
							if(row.contains("B"))innerboard[r][c]="A";
							else if(row.contains("A"))innerboard[r][c]="B";
						}
						
						
					}
				}
			}	
		}
		
		
		//now get the string;
		String solution = "";
		
		for(int r = 0; r < innerboard.length; r++) {
			for(int c = 0; c < innerboard[0].length; c++) {
				if(!innerboard[r][c].contains("X")){
					solution = solution + innerboard[r][c]; 
				}
				
			}
			
		}














//		
//		for(int r = 0; r < innerboard.length; r++) {
//			for(int c = 0; c < innerboard[0].length; c++) {
//
//				System.out.print(innerboard[r][c] + "	");
//			}
//			System.out.print("\n");
//			System.out.print("\n");
//		}

		return solution;

	}
}




