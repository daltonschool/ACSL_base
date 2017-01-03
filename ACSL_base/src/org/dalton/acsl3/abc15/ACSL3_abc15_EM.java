package org.dalton.acsl3.abc15;
import java.util.Arrays;
import java.util.Scanner;


public class ACSL3_abc15_EM {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int bas = 0; bas < 5; bas++) {
			
		char[][] grid = new char[4][4];
		for(int i = 0; i<4; i++){
			Arrays.fill(grid[i], '.');
		}
		String input;
		input = scan.next();
		String[] inputarray = input.split(",");

		//put in xs
		int[] inputpt1 = new int[4];
		for (int i = 0; i < inputpt1.length; i++) {
			inputpt1[i] = Integer.parseInt(inputarray[i]);
		}
		for (int i = 0; i < inputpt1.length; i++) {
			int row = ((inputpt1[i]-(inputpt1[i]%6))/6)-1;
			int column = (inputpt1[i]%6)-2;
			grid[row][column] = 'X';
		}
		//put in letters
		for(int i = 0; i < Integer.parseInt(inputarray[4]); i++){
			int num = Integer.parseInt(inputarray[6+2*i]);
			char[] chardummy = inputarray[5+2*i].toCharArray();
			int row = 0;
			int column = 0;
			if(num%6==1){
				row = ((num-(num%6))/6-1);
				column = 0;
				if(grid[row][column] == 'X') column++;
			}
			if(num%6==0){
				row = ((num-(num%6))/6-2);
				column = 3;
				if(grid[row][column] == 'X') column--;
			}
			if(num<6){
				row = 0;
				column = num%6-2;
				if(grid[row][column] == 'X') row++;
			}
			if(num>31){
				row = 3;
				column = num%6-2;
				if(grid[row][column] == 'X') row--;

			}
			grid[row][column] = chardummy[0];
		}
		//fill in other letters
		for(int Z = 0; Z<16; Z++){
			for(int j = 0; j < 4; j++){
				for(int i = 0; i < 4; i++){
					boolean a = true;
					boolean b = true;
					boolean c = true;
					if(grid[i][j]=='.'){
						for(int k = 0; k<4; k++){
							if(grid[i][k]=='A'||grid[k][j]=='A') a = false;
							if(grid[i][k]=='B'||grid[k][j]=='B') b = false; 
							if(grid[i][k]=='C'||grid[k][j]=='C') c = false; 
						}
						if(a==true&&b==false&&c==false) grid[i][j]='A';
						else if(a==false&&b==true&&c==false) grid[i][j]='B';
						else if(a==false&&b==false&&c==true) grid[i][j]='C';
						else{
						}
					}
				} 
			}
		}
		//back to String
		char[] outputarray = new char[12];
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j<4; j++){
				if(grid[i][j]!='X'){
					outputarray[counter] = grid[i][j];
					counter++;
				}
			}
		}
		String output = new String(outputarray);
		System.out.println(output);
		}
	}
}
