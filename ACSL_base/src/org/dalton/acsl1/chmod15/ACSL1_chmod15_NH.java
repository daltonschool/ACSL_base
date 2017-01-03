package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ACSL1_chmod15_NH {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "chmodtest";
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

	/**
	 * solve for a specific input
	 * @param s the input
	 * @return the output
	 */
	static String solve(String s) {
		String[] data = s.split(",[ ]*");
		int size = Integer.parseInt(data[0]);
		int sizeOne = Integer.parseInt(data[1]);
		int sizeTwo = Integer.parseInt(data[2]);
		int sizeThree = Integer.parseInt(data[3]);

		//assign the string values

		//String toBinary = "";
		String toBinaryO = "";
		String toBinaryT = "";
		String toBinaryTh = "";

		for(int i = 0; i< data.length; i++){
			//second
			if(sizeOne == 0) toBinaryO = "000";
			if(sizeOne == 1) toBinaryO = "001";
			if(sizeOne == 2) toBinaryO = "010";
			if(sizeOne == 3) toBinaryO = "011";
			if(sizeOne == 4) toBinaryO = "100";
			if(sizeOne == 5) toBinaryO = "101";
			if(sizeOne == 6) toBinaryO = "110";
			if(sizeOne == 7) toBinaryO = "111";
			//third
			if(sizeTwo == 0) toBinaryT = "000";
			if(sizeTwo == 1) toBinaryT = "001";
			if(sizeTwo == 2) toBinaryT = "010";
			if(sizeTwo == 3) toBinaryT = "011";
			if(sizeTwo == 4) toBinaryT = "100";
			if(sizeTwo == 5) toBinaryT = "101";
			if(sizeTwo == 6) toBinaryT = "110";
			if(sizeTwo == 7) toBinaryT = "111";
			//fourth digit
			if(sizeThree == 0) toBinaryTh = "000";
			if(sizeThree == 1) toBinaryTh = "001";
			if(sizeThree == 2) toBinaryTh = "010";
			if(sizeThree == 3) toBinaryTh = "011";
			if(sizeThree == 4) toBinaryTh = "100";
			if(sizeThree == 5) toBinaryTh = "101";
			if(sizeThree == 6) toBinaryTh = "110";
			if(sizeThree == 7) toBinaryTh = "111";

		}

		String hello1 = "";
		String hello2 = "";
		String hello3 = "";
		//0
		if(toBinaryO == "000" ) hello1 = "---";
		if(toBinaryT == "000") hello2 = "---";
		if(toBinaryTh == "000") hello3 = "---";
		//1
		if(toBinaryO == "001") hello1 = "--x";
		if(toBinaryT == "001") hello2 = "--x";
		if(toBinaryTh == "001") hello3 = "--x";
		//2
		if(toBinaryO == "010") hello1 = "-w-";
		if(toBinaryT == "010") hello2 = "-w-";
		if(toBinaryTh == "010") hello3 = "-w-";
		//3
		if(toBinaryO == "011") hello1 = "-wx";
		if(toBinaryT == "011") hello2 = "-wx";
		if(toBinaryTh == "011") hello3 = "-wx";
		//4
		if(toBinaryO == "100") hello1 = "r--";
		if(toBinaryT == "100") hello2 = "r--";
		if(toBinaryTh == "100") hello3 = "r--";
		//5
		if(toBinaryO == "101") hello1 = "r-x";
		if(toBinaryT == "101") hello2 = "r-x";
		if(toBinaryTh == "101") hello3 = "r-x";
		//6
		if(toBinaryO == "110") hello1 = "rw-";
		if(toBinaryT == "110") hello2 = "rw-";
		if(toBinaryTh == "110") hello3 = "rw-";
		//7
		if(toBinaryO == "111") hello1 = "rwx";
		if(toBinaryT == "111") hello2 = "rwx";
		if(toBinaryTh == "111") hello3 = "rwx";

		//SPECIAL CASES 
		//1 + 3 + 5 + 7
		if(size==1) {
			//1
			if(toBinaryO == "001") hello1 = "--s";
			//3
			if(toBinaryO == "011") hello1 = "-ws";
			//5
			if(toBinaryO == "101") hello1 = "r-s";
			//7
			if(toBinaryO == "111") hello1 = "rws";	
		}
		if(size ==2) {
			//1
			if(toBinaryT == "001") hello2 = "--s";
			//3
			if(toBinaryT == "011") hello2 = "-ws";
			//5
			if(toBinaryT == "101") hello2 = "r-s";
			//7
			if(toBinaryT == "111") hello2 = "rws";
		}
		if(size ==3 || size ==4) {
			//1
			if(toBinaryTh == "001") hello3 = "--t";
			//3
			if(toBinaryTh == "011") hello3 = "-wt";
			//5
			if(toBinaryTh == "101") hello3 = "r-t";
			//7
			if(toBinaryTh == "111") hello3 = "rwt";
		}
		System.out.print(toBinaryO  + " " + toBinaryT + " " + toBinaryTh  + " and " + hello1  + " " + hello2 + " " + hello3);
		return "";

	}
}


