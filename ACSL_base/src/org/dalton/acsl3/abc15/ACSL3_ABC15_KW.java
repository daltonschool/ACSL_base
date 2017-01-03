package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ACSL3_ABC15_KW {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filein = "testData/testData"; //name the file from test data
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





	public static String solve(String s){

		
		String[] input = s.split("[',']");

		char gridOne [] = new char [36];
		for (int i= 0; i < 36; i ++){
			gridOne[i]=' ';
		}
		int numberGiven = Integer.parseInt(input[4]);

		for (int i = 0; i <4; i++){
			gridOne[Integer.parseInt(input[i])-1]= 'X';
		}



		for (int i = 5; i < (4+(numberGiven*2)); i++){
			
			
			int target = Integer.parseInt(input[i+1])-1;
			char letter = input[i].charAt(0);
			gridOne[target] = letter;
			int dir = 0;
			if (target%6==0){
				dir = 4;
				for (int j = 0; j < 4; j++){
					if (gridOne[target+1]!='X'){
						gridOne[target+1] = letter;
						break;
					} else {
						target++;
					}
				}
			} else if (target%6==5){
				dir = 2;
				for (int j = 0; j < 4; j++){
					if (gridOne[target-1]!='X'){
						gridOne[target-1] = letter;
						break;
					} else {
						target--;
					}
				}
			} else if (target <=5 ){
				dir = 1;
				for (int j = 0; j < 4; j++){
					if (gridOne[target+6]!='X'){
						gridOne[target+6] = letter;
						break;
					} else {
						target+=6;
					}
				}
			} else if (target >=30){
				dir = 3;
				for (int j = 0; j < 4; j++){
					if (gridOne[target-6]!='X'){
						gridOne[target-6] = letter;
						break;
					} else {
						target-=6;
					}
				}
			}
			//	System.out.println(dir);
			i++;
		}


	
		
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		gridOne= fillInOneSpace(gridOne);
		
		String answer = "";
		int myPlace = 7;
		for (int i = 0; i < 4; i ++){
			for (int j = 0; j < 4; j++){
				if (gridOne[myPlace+j]!='X'){
					answer = answer+gridOne[myPlace+j];
				}
			}
			myPlace = myPlace+6;
		}
		
		
		//print(gridOne);
		return answer;
	}




	public static void print(char a[]){


		for (int i= 0; i < 36; i++){
			if (i%6==0){
				System.out.println();
			}
			if (a[i]==' '){
				System.out.print("_");
			} else {
				System.out.print(a[i]);
			}
			System.out.print(" ");

		}
		System.out.println();

	}


	public static char[] fillInOneSpace( char [] grid){//finds if theres only one space free, if not returns 0, if so returns the space;
		int openSpace = 0;
		int secondOpenSpace = 0;
		int numSpaces = 0;
		int place = 7;
	
		String letterLeft = "ABC";

		
		for (int j = 0; j < 4; j++){
			numSpaces = 0;
			openSpace = 0;
			secondOpenSpace = 0;
			letterLeft = "ABC";
			
			for (int i = 0; i < 4; i ++){ 

				if (grid[place+i]==' '){
					numSpaces++;
					if (openSpace>0){
						secondOpenSpace = openSpace;
					}
					openSpace = place+i;
					//	System.out.println(openSpace);
				} else {
					
					letterLeft = letterLeft.replace(Character.toString(grid[place+i]), "");
					
				}

			}
			//	System.out.println(openSpace);

			if (numSpaces==1){
				//System.out.println("Filling in one space");
				grid[openSpace] = letterLeft.charAt(0);
			} else if (numSpaces == 2){
				//System.out.println("Filling in two spaces");
				
				int semiPlace = secondOpenSpace%6 +6;

				char notLetter = ' ';
				
				for (int k = 0; k < 4; k ++){
					if ((grid[semiPlace]!=' ')&&(grid[semiPlace]!='X')){
					//	System.out.println("found data at "+semiPlace);
						notLetter = grid[semiPlace];
						letterLeft = letterLeft.replace(Character.toString(notLetter), "");
						grid[secondOpenSpace] = letterLeft.charAt(0);
						grid[openSpace] = notLetter;  
						break;
					} else {
						//System.out.println("nope");
					}
					semiPlace +=6;
				}
				
			}
			
			place = place+6;
			//System.out.println(" a");
			
		}
		
		//Down
	
		place= 7;
		//System.out.println("hi");
		for (int j = 0; j < 4; j++){
			numSpaces = 0;
			openSpace = 0;
			secondOpenSpace = 0;
			letterLeft = "ABC";
			
			for (int i = 0; i < 4; i ++){ 
				//System.out.print (" "+ (place+(i*6)));
				if (grid[place+(i*6)]==' '){
					numSpaces++;
					if (openSpace>0){
						secondOpenSpace = openSpace;
					}
					openSpace = place+(i*6);
					//	System.out.println(openSpace);
				} else {
					
					letterLeft = letterLeft.replace(Character.toString(grid[place+(i*6)]), "");
					
				}

			}
			//	System.out.println(openSpace);
			
			if (numSpaces==1){
				//	System.out.println(letterLeft);
				grid[openSpace] = letterLeft.charAt(0);
			} else if (numSpaces == 2){
				//System.out.println("Filling in two spaces");
				
				int semiPlace = secondOpenSpace%6 +6;

				char notLetter = ' ';
				
				for (int k = 0; k < 4; k ++){
					if ((grid[semiPlace]!=' ')&&(grid[semiPlace]!='X')){
						//System.out.println("found data at "+semiPlace);
						notLetter = grid[semiPlace];
						letterLeft = letterLeft.replace(Character.toString(notLetter), "");
						grid[secondOpenSpace] = letterLeft.charAt(0);
						grid[openSpace] = notLetter;  
						break;
					} else {
						//System.out.println("nope");
					}
					semiPlace +=6;
				}
				
				
			}
			place = place+1;
			//System.out.println("____________");
			//print(grid);
		}
		
		return grid;
	}
}

