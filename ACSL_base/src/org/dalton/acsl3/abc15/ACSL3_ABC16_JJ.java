package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Divide grid into two arrays
//Calculate frequency of unknowns across all arrays 
//Solve from least to greatest 

public class ACSL3_ABC16_JJ {
	public static void main(String[] args) throws IOException {
		String filein = "testdata/ABC";
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
			String[] data = new String[5];
			for (int i = 0; i < data.length; i++) {
				data[i] = scan.nextLine();
				ABCParse p = new ABCParse();
				String answer = solve(p.Filler(data[i]), p.FoundLetters(data[i]));
				//System.out.println(answer);
				if(fop!=null) fop.write((answer+"\n").getBytes());
			}
		}
		fop.flush();
		fop.close();
		scan.close();
	}
	public static ArrayList<Integer> NORTH = new ArrayList<Integer>(); 
	public static ArrayList<Integer> EAST = new ArrayList<Integer>();
	public static ArrayList<Integer> SOUTH = new ArrayList<Integer>();
	public static ArrayList<Integer> WEST = new ArrayList<Integer>();

	public static String solve(int[] loc, String[][] found){
		String[] out = new String[36];
		Arrays.fill(out, "E");
		String[][] transpose = new String[6][6];
		String[][] copy = new String[6][6];
		String[][] board = new String[6][6];
		for(int i=0; i<loc.length; i++) out[loc[i]]="F";
		for(int i=0; i<36; i++){ transpose[i%6][i/6%6]=out[i%6+(i/6*6)]; copy[i/6%6][i%6]=out[i];}
		for(int i=0; i<found[0].length; i++){ 
			out[Integer.parseInt(found[1][i])] = found[0][i]; 
			board = pushtoBoard(copy, transpose, found[0][i], Integer.parseInt(found[1][i]));
		}
		Arrays.deepToString(board);
		return null;
	}

	public static String[][] pushtoBoard(String[][] copy, String[][] transpose, String letter, int loc){
		ABCParse abc = new ABCParse();
		for(int i = 0; i<4; i++){
		NORTH.add(2+i); SOUTH.add(32+i);
		WEST.add(7+6*i); EAST.add(12+6*i);
		}
		String[][] board = new String[6][6];
		
		if(NORTH.contains(loc)) {
			transpose[loc/6][loc+abc.firstEmpty(transpose[loc/6]).indexOf("E")]=letter;
		} else if(EAST.contains(loc)) {
			copy[loc/6-1][loc-abc.firstEmpty(copy[loc/6-1]).lastIndexOf("E")]=letter;
		} else if(SOUTH.contains(loc)) {
			transpose[loc/6-1][loc-abc.firstEmpty(transpose[loc/6-1]).lastIndexOf("E")]=letter;
		} else if(WEST.contains(loc)) {
			copy[loc/6][loc+abc.firstEmpty(copy[loc/6]).indexOf("E")]=letter;
		} 
		
		for(int i=0; i<36; i++) {
			board[i/6%6][i%6]=transpose[i%6][i/6%6];
			if(!(board[i/6%6][i%6].equals(copy[i/6%6][i%6]))){
				if(!(board[i/6%6][i%6].equals("E")));
				else board[i/6%6][i%6]= copy[i/6%6][i%6];
			}
		}
		Arrays.deepToString(board);
		return board;
	}
	
}
class ABCParse {
	public ABCParse(){
		super();
	}
	public int[] Filler(String s){
		String[] data = s.split(",[ ]*");
		int[] inp = new int[4];
		for(int i=0; i<inp.length; i++){
			inp[i]= Integer.valueOf(data[i]);
		}
		return inp;
	}
	public String[][] FoundLetters(String s){
		String[] data = s.split(",[ ]*");
		String[][] inp = new String[2][Integer.valueOf(data[4])];
		for(int i=0; i<Integer.valueOf(data[4])*2; i+=2){
			inp[0][i/2]=data[5+i];
			inp[1][i/2]=data[6+i];
		}
		return inp;
	}
	public String firstEmpty(String[] s){
		String row="";
		for(int i=1; i<5; i++){
			row+=s[i];
		}
		return row;
	}
}