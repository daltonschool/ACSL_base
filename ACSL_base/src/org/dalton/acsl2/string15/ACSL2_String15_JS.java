package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ACSL2_String15_JS {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/ACSLString";
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


	}//closes public static void

	static String solve(String s){

		//parsing
		String input = s;
		//double dataDouble = Double.parseDouble(input);
		//String input1 = Double.toString(dataDouble);
		//String[] data = input1.split(",[ ]*");
		//Double.parseDouble(String );
		//int size = data.length-1;
		//System.out.println(input);
		String input1 = input.replace(".", ","); //getting rid of decimal 
		//System.out.println(input1);
		String[] data = input1.split(",[ ]*");


		//variables
		int decimal;
		int length;
		int sizeFloat;
		int[] dataNum = new int[data.length]; //array that has input as numbers
		int[] floatNum = new int[dataNum.length-2]; //array with just number I want to change --> output  (**need to -2)
		//int end = dataNum[dataNum.length-1];

		for(int i = 0; i<data.length; i++){
			dataNum[i] = Integer.parseInt(data[i]); //filling array with int values
		}


		//for(int x = 0; x<floatNum.length-1;x++);{
		//floatNum[x] = dataNum[x];
		//		}

		//defining decimal
		decimal = dataNum[dataNum.length-1];
		//System.out.println(decimal);

		//defining length
		length = dataNum[dataNum.length-2];
		//System.out.println(length);

		//for(int a = 0; a<length; a++){ //equal to length so decimal is included
		//make array that will be output number
		//float[a] = dataNum[a];
		//}

		//number array
		for(int x = 0; x<dataNum.length-2; x++){
			floatNum[x] = dataNum[x];
		}
		String floatX = Arrays.toString(floatNum).replace(" ", "").replace(",",".").replace("[", "").replace("]", "");


		//rounding 
		DecimalFormat df = new DecimalFormat();
		df.setMaximumIntegerDigits(0);
		df.setMaximumFractionDigits(decimal);
		df.setMinimumFractionDigits(decimal);

		double floatN = Double.parseDouble(floatX);
		//String.DecimalFormat("%.decimalf", floatN);
		java.lang.Math.round(floatN);

		BigDecimal bigDecimal = new BigDecimal(floatN);
		bigDecimal = bigDecimal.setScale(decimal,BigDecimal.ROUND_HALF_UP);
		//System.out.println(bigDecimal);

		String output = new String();
		String bakeddates = new String();
		bakeddates = bigDecimal.toPlainString();
		//output = bigDecimal.toPlainString();

		//if(__[0]=="+"){ //need to refer to front of string 
		//	output ="+"+ bigDecimal;
		//}

		//if(data[0]=="-"){

		//}
		char[] beach = input.toCharArray();

		//length issues #
		String water = new String();

		if(bigDecimal.toPlainString().length()>length){
			String[] hashtagBigger = new String[length];
			for(int h = 0; h<length; h++){
				hashtagBigger[h] = "#";
			}
			String turtleshashtag = new String();
			turtleshashtag = Arrays.toString(hashtagBigger).replace("[", "").replace("]", "").replace(" ", "");
			String[] turtles = turtleshashtag.split(",");
			turtles[decimal-1] = ".";

			water = Arrays.toString(turtles).replace("[", "").replace("]", "").replace(",", "").replace(" ","");
		}

		//put hashtag in front
		if(bigDecimal.toPlainString().length()<length){
			String[] hashtagneedBigger = new String[length];
			int smile;
			int hashtag;
			smile = bigDecimal.toPlainString().length();
			hashtag = (length-smile);
			String[] smilehashtag = new String[hashtag];

			//if(beach[0]=='+'||beach[0]=='-'){
			//	for(int b = 1; b<hashtag;b++){
			//	smilehashtag[b] = "#";
			//}
			//}


			if(beach[0]=='+'){
				for(int q = 0; q<hashtag-1;q++){
					smilehashtag[q] = "#";

				}
			}

			else if(beach[0]=='-'){
				for(int q = 0; q<hashtag-1;q++){
					smilehashtag[q] = "#";
				}
			}
			else {
				for(int b = 0; b<hashtag;b++){
					smilehashtag[b] = "#";
				}
			}

			String smilehashtagstring = new String();
			smilehashtagstring = Arrays.toString(smilehashtag).replace("[","").replace("]","").replace(",", "").replace(" ", "").replace("null", "");
			String done = new String();
			if(smilehashtagstring.length()<1){
				done = bigDecimal.toPlainString();
			}
			else {
				done = (smilehashtagstring + bigDecimal);
				//for(int e=length; e>hashtag;e--){
				// smilehashtag[e]
				// }
			}
			water = done;
			//System.out.println(done);
		}
		//so if bigDecimal != length ... make array[length] ... fill with ##

		//plus minus stuff
		//char[] beach = input.toCharArray();
		
		//if(water == ""){
			//water = bakeddates;
		//}
		if(beach[0]=='+'){
			output = '+'+water;
			return output;
		}
		else if (beach[0] =='-'){
			output = '-'+water;
		}
		//output = water;
		if(output.length()==1){
			output = bakeddates;
			return output;
		}
		if(water.length()<1){
			output = bakeddates;
			return output;
		}
		else{
			output = water;
		}
		return output;

	}

}
