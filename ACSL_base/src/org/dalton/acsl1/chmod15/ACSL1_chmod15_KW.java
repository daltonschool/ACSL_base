package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ACSL1_chmod15_KW {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testData/data"; //name the file from test data
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
		
		s = s.replaceAll("\\s", "");
		s = s.replaceAll(",", "");
		
		String binary = "";//piece of bianary
		char permissions [] = {'r', 'w', 'x'}; 
		
		for (int i = 1; i < 4; i ++){
			binary += (String.format("%3s", Integer.toBinaryString(s.charAt(i)-48)).replace(' ', '0')+" ");
		}
		System.out.print(binary+"AND ");
		//System.out.println(s.charAt(0)-49);
	
		for (int i = 0; i < binary.length(); i++){
			
			if(binary.charAt(i)=='1'){
				if ((i/4) == (s.charAt(0)-49)){
					
					
				}
				System.out.print(permissions[i%4]);
				
			} else if (binary.charAt(i)== ' '){
				System.out.print(" ");
				 
			} else {
				System.out.print("-");
			}
			
		}
		
		return "";
	}

}
