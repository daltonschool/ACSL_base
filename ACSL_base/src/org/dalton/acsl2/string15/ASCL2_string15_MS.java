package org.dalton.acsl2.string15;



//Molly Shapiro

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
public class ASCL2_string15_MS {
	public static void main(String[] args) throws IOException {


		//declarations:
		String filein = "testdata/CHMODTEST";
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

	static String solve (String filein) {

		String s = "523.125, 6, 2";
		String p = "";
		String [] data2 = s.split("\\.");
		String [] data = s.split(",[ ]*");
		//put into an int array

		String floatex = data2[0]; 
		String floatex2 = data2[1]; 

		int length = Integer.parseInt(data[1]);
		int decimal = Integer.parseInt(data[2]);
		int decplace = 0;
		//find length of an int:
		int intlength = (int)(Math.log10(decimal)+1);


		//			String floater= Float.toString(floatex);
		//			String [] f = floater.split(".[ ]*");  //parse the float expression
		//			int beforedec = Integer.parseInt(data[0]);  //before the decimal place
		//			int afterdec = Integer.parseInt(data[1]); //after the decimal place
		//		
		//			int beforedeclength = (int)(Math.log10(beforedec)+1); //find length before
		//			int afterdeclength = (int)(Math.log10(afterdec)+1); //find length after
		//			
		//			double [] num = new double[f.length]; //may need a double array
		////	
		//			//turn ints into int array
		//			int [] bdec = new int [beforedeclength]; //beforedec becomes an array
		//			Arrays.fill(bdec, beforedec); 
		//			
		//			int [] adec = new int [afterdeclength]; //afterdec becomes an array
		//			Arrays.fill(adec, afterdec); 
		//			
		////			
		//			//turn int array into double
		//			num[beforedeclength+1]='.'; //insert decimal
		//			
		//			for (int i=0; i<beforedeclength; i++) {
		//			num[i]= bdec[i]; //fill part before decimal
		//			}
		//			for (int i=0; i<afterdeclength; i++) {
		//			num[beforedeclength+2+i]= adec[i]; //fill part after decimal
		//			}
		//			
		//			System.out.print(beforedeclength);
		//			System.out.print(afterdeclength);

		//			for (int i=0; i<f.length; i++) {
		//			num[i]=beforedec;
		//			integers.add(num.nextInt());
		//			}
		//			
		//			for (int i=0; i<f.length; i++) { 
		//				if (num[i]=='.');
		//				decplace = i;
		//			}
		//			
		//int numafterdec = f.length-decplace; //find the number of digits after the decimal place
		//delete number after and round off number before
		//			int delete; 
		//			if (afterdeclength>decimal) {
		//				delete = afterdeclength-decimal;
		//				int rounder = num[num.length-delete]; //this is the thing that you delete that you will use to round off
		//				//num[rounder]=' ';
		//
		return "";
		//				}
	}
	//take in the input
	//parse the expression
	//compare the number of values you want after the decimal place with the number of values you have after the decimal place. 
	//if more, than delete necessary number and round off end (if number you delete >=5, then +1 for last number, et...)
	//count length of the expression. 
	//compare length of expression with desired length. if it is less or greater, then fill length with #s and insert decimal
	//if appropriate, then leave as is

	private static float parseFloat(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	//case for if negative
	//



}




