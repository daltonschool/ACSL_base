package org.dalton.acsl3.abc15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ACSL3_ABC15_JU {

	//first four points are nulls. Then the number of points they give you. Then letter, place in grid two. 
	//Anything, 7 will be first in the output sequence --actually idk 
	//Anything, 30 will be the final letter - again idk 

	public static void main(String[] args) throws IOException {
		//declarations 
		Scanner scan;
		String filein = "testdata/ABCTEST";
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			//switch to regular terminal input
			scan = new Scanner(System.in);
		}

		//main loop:
		String answer = null; 
		while(scan.hasNext()) {
			answer = solve(scan.nextLine());
			System.out.println(answer);
			if(fop!=null) fop.write((answer+"\n").getBytes());
		}

		fop.flush();
		fop.close();
		scan.close();
	}

	public static String solve(String s) { 
		//declarations
		String input = s;
		String[] data = input.split(", ");
		int null1 = Integer.parseInt(data[0]);
		int null2 = Integer.parseInt(data[1]);
		int null3 = Integer.parseInt(data[2]);
		int null4 = Integer.parseInt(data[3]);

		int points = Integer.parseInt(data[4]);

		String s1 = data[5];
		int p1 = Integer.parseInt(data[6]);

		String s2 = data[7];
		int p2 = Integer.parseInt(data[8]);

		String s3 =	data[9];
		int p3 = Integer.parseInt(data[10]);

		String s4 =	data[11];
		int p4 = Integer.parseInt(data[12]);

		int[][] grid1 = 
			{   {1, 2, 3, 4, 5, 6},
				{7, 8, 9, 10, 11, 12},
				{13, 14, 15, 16, 17, 18},
				{19, 20, 21, 22, 23, 24},
				{25, 26, 27, 28, 29, 30},
				{31, 32, 33, 34, 35, 36},
			};
		int[][] grid2 = 
			{   {1, 2, 3, 4, 5, 6},
				{7, 8, 9, 10, 11, 12},
				{13, 14, 15, 16, 17, 18},
				{19, 20, 21, 22, 23, 24},
				{25, 26, 27, 28, 29, 30},
				{31, 32, 33, 34, 35, 36},
			};
		int[][] grid3 = 
			{	{8, 9, 10, 11},
				{14, 15, 16, 17},
				{20, 21, 22, 23},
				{26, 27, 28, 29},
			};
		
		
		










		return "";

	}
}


