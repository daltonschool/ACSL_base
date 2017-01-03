package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Kevin Sanaycela
 * ACSL 1: CHMOD
 * January 6, 2015
 */
public class ACSL1_chmod15_KS{
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "src/ACSL1test";
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
	static String solve(String s){
		String[] data = s.split(",[ ]*");

		//declare new int in base ten
		int hun = Integer.parseInt(data[1])*64;
		int ten = Integer.parseInt(data[2])*8;
		int one = Integer.parseInt(data[3])*1;
		int baseten = hun+ten+one;

		//converting to binary
		for (int i = 0; i < 9; i++) {
			if(i==0){
				if(baseten>=256){
					System.out.print("1");
					baseten=baseten%256;
				}
				else{
					System.out.print("0");
					baseten=baseten+0;
				}
			}
			if(i==1){
				if(baseten>=128){
					System.out.print("1");
					baseten=baseten%128;
				}
				else{
					System.out.print("0");
					baseten=baseten+0;
				}
			}
			if(i==2){
				if(baseten>=64){
					System.out.print("1");
					baseten=baseten%64;
					System.out.print(" ");
				}
				else{
					System.out.print("0");
					baseten=baseten+0;
					System.out.print(" ");
				}
			}
			if(i==3){
				if(baseten>=32){
					System.out.print("1");
					baseten=baseten%32;
				}
				else{
					System.out.print("0");
					baseten=baseten+0;
				}
			}
			if(i==4){
				if(baseten>=16){
					System.out.print("1");
					baseten=baseten%16;
				}
				else{
					System.out.print("0");
					baseten=baseten+0;
				}
			}
			if(i==5){
				if(baseten>=8){
					System.out.print("1");
					baseten=baseten%8;
					System.out.print(" ");
				}
				else{
					System.out.print("0");
					baseten=baseten+0;
					System.out.print(" ");
				}
			}
			if(i==6){
				if(baseten>=4){
					System.out.print("1");
					baseten=baseten%4;
				}
				else{
					System.out.print("0");
					baseten=baseten+0;
				}
			}
			if(i==7){
				if(baseten>=2){
					System.out.print("1");
					baseten=baseten%2;
				}
				else{
					System.out.print("0");
					baseten=baseten+0;
				}
			}
			if(i==8){
				if(baseten>=1){
					System.out.print("1");
					baseten=baseten%1;
				}
				else{
					System.out.print("0");
					baseten=baseten+0;
				}
			}		
		}
	
		//separator of the thing 
		System.out.print(" and ");

		//permissions component of the thing 
		//declare new int2 in base ten
		int hun2 = Integer.parseInt(data[1])*64;
		int ten2 = Integer.parseInt(data[2])*8;
		int one2 = Integer.parseInt(data[3])*1;
		int baseten2 = hun2+ten2+one2;
		
		//going through each 2^n and doing the modulo
		for (int k = 0; k < 9; k++) {
			if(k==0){
				if(baseten2>=256){
					System.out.print("r");
					baseten2=baseten2%256;
				}
				else{
					System.out.print("-");
					baseten2=baseten2+0;
				}
			}
			if(k==1){
				if(baseten2>=128){
					System.out.print("w");
					baseten2=baseten2%128;
				}
				else{
					System.out.print("-");
					baseten2=baseten2+0;
				}
			}
			if(k==2){
				if(baseten2>=64){
					if(Integer.parseInt(data[0])==1){
						System.out.print("s");
						baseten2=baseten2%64;
					}
					else{
						System.out.print("x");
						baseten2=baseten2%64;
					}
					System.out.print(" ");
				}
				else{
					System.out.print("-");
					baseten2=baseten2+0;
					System.out.print(" ");
				}
			}
			if(k==3){
				if(baseten2>=32){
					System.out.print("r");
					baseten2=baseten2%32;
				}
				else{
					System.out.print("-");
					baseten2=baseten2+0;
				}
			}
			if(k==4){
				if(baseten2>=16){
					System.out.print("w");
					baseten2=baseten2%16;
				}
				else{
					System.out.print("-");
					baseten2=baseten2+0;
				}
			}
			if(k==5){
				if(baseten2>=8){
					if(Integer.parseInt(data[0])==2){
						System.out.print("t");
						baseten2=baseten2%8;
					}
					//special case 
					else if(Integer.parseInt(data[0])==1||Integer.parseInt(data[0])==4||Integer.parseInt(data[0])==0){
						System.out.print("x");
						baseten2=baseten2%8;
						
					}
					else{
						System.out.print("-");
						baseten2=baseten2+0;
					}
					System.out.print(" ");
				}
				else{
					System.out.print("-");
					System.out.print(" ");
					baseten2=baseten2+0;
				}
			}
			if(k==6){
				if(baseten2>=4){
					System.out.print("r");
					baseten2=baseten2%4;
				}
				else{
					System.out.print("-");
					baseten2=baseten2+0;
				}
			}
			if(k==7){
				if(baseten2>=2){
					System.out.print("w");
					baseten2=baseten2%2;
				}
				else{
					System.out.print("-");
					baseten2=baseten2+0;
				}
			}
			if(k==8){
				if(baseten2>=1){
					if(Integer.parseInt(data[0])==4){
						System.out.print("t");
						baseten2=baseten2%1;
					}
					//special case 
					else if(Integer.parseInt(data[0])==1||Integer.parseInt(data[0])==2||Integer.parseInt(data[0])==0){
						System.out.print("x");
						baseten2=baseten2%1;
					}
					else{
						System.out.print("-");
						baseten2=baseten2+0;
					}
				}
				else{
					System.out.print("-");
					baseten2=baseten2+0;
				}
			}
		}
		return "";
	}
}