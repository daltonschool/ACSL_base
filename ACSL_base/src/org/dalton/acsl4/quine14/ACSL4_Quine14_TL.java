package org.dalton.acsl4.quine14;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Tyler Love
 * 
 * ACSL 4
 * 
 * SAMPLE INPUTS:
2, 6, -1
2, 3, 5, 7, -1
1, 3, 4, 5, 6, 7, -1
8, 9, 10, 11, 12, 14, 15, -1
9, 10, 11, 12, 13, 14, 15, -1
 */
public class ACSL4_Quine14_TL {
	public static void main(String[] args) {
		int numruns = 0;
		while(true){
			numruns++;
			//take in input
			Scanner scan = new Scanner(System.in);
			String[] input = scan.nextLine().split(", ");
			ArrayList <String> inputarray = new ArrayList <String>();
			for(int i = 0; i < input.length-1; i++){
				inputarray.add(input[i]);
			}
//			System.out.println(inputarray);
			
			ArrayList <String> zeroarray = new ArrayList<String>();
			zeroarray.add("0");
			zeroarray.add("0");
			zeroarray.add("0");
			zeroarray.add("0");
			ArrayList <String> onearray = new ArrayList<String>();
			onearray.add("0");
			onearray.add("0");
			onearray.add("0");
			onearray.add("1");
			ArrayList <String> twoarray = new ArrayList<String>();
			twoarray.add("0");
			twoarray.add("0");
			twoarray.add("1");
			twoarray.add("0");
			ArrayList <String> threearray = new ArrayList<String>();
			threearray.add("0");
			threearray.add("0");
			threearray.add("1");
			threearray.add("1");
			ArrayList <String> fourarray = new ArrayList<String>();
			fourarray.add("0");
			fourarray.add("1");
			fourarray.add("0");
			fourarray.add("0");
			ArrayList <String> fivearray = new ArrayList<String>();
			fivearray.add("0");
			fivearray.add("1");
			fivearray.add("0");
			fivearray.add("1");
			ArrayList <String> sixarray = new ArrayList<String>();
			sixarray.add("0");
			sixarray.add("1");
			sixarray.add("1");
			sixarray.add("0");
			ArrayList <String> sevenarray = new ArrayList<String>();
			sevenarray.add("0");
			sevenarray.add("1");
			sevenarray.add("1");
			sevenarray.add("1");
			ArrayList <String> eightarray = new ArrayList<String>();
			eightarray.add("1");
			eightarray.add("0");
			eightarray.add("0");
			eightarray.add("0");
			ArrayList <String> ninearray = new ArrayList<String>();
			ninearray.add("1");
			ninearray.add("0");
			ninearray.add("0");
			ninearray.add("1");
			ArrayList <String> tenarray = new ArrayList<String>();
			tenarray.add("1");
			tenarray.add("0");
			tenarray.add("1");
			tenarray.add("0");
			ArrayList <String> elevenarray = new ArrayList<String>();
			elevenarray.add("1");
			elevenarray.add("0");
			elevenarray.add("1");
			elevenarray.add("1");
			ArrayList <String> twelvearray = new ArrayList<String>();
			twelvearray.add("1");
			twelvearray.add("1");
			twelvearray.add("0");
			twelvearray.add("0");
			ArrayList <String> thirteenarray = new ArrayList<String>();
			thirteenarray.add("1");
			thirteenarray.add("1");
			thirteenarray.add("0");
			thirteenarray.add("1");
			ArrayList <String> fourteenarray = new ArrayList<String>();
			fourteenarray.add("1");
			fourteenarray.add("1");
			fourteenarray.add("1");
			fourteenarray.add("0");
			ArrayList <String> fifteenarray = new ArrayList<String>();
			fifteenarray.add("1");
			fifteenarray.add("1");
			fifteenarray.add("1");
			fifteenarray.add("1");
//			System.out.println(zeroarray);
//			System.out.println(onearray);
//			System.out.println(twoarray);
//			System.out.println(threearray);
//			System.out.println(fourarray);
//			System.out.println(fivearray);
//			System.out.println(sixarray);
//			System.out.println(sevenarray);
//			System.out.println(eightarray);
//			System.out.println(ninearray);
//			System.out.println(tenarray);
//			System.out.println(elevenarray);
//			System.out.println(twelvearray);
//			System.out.println(thirteenarray);
//			System.out.println(fourteenarray);
//			System.out.println(fifteenarray);
			
			Map<String, ArrayList> binaryconversion = new HashMap<String, ArrayList>();
			binaryconversion.put("0", zeroarray);
			binaryconversion.put("1", onearray);
			binaryconversion.put("2", twoarray);
			binaryconversion.put("3", threearray);
			binaryconversion.put("4", fourarray);
			binaryconversion.put("5", fivearray);
			binaryconversion.put("6", sixarray);
			binaryconversion.put("7", sevenarray);
			binaryconversion.put("8", eightarray);
			binaryconversion.put("9", ninearray);
			binaryconversion.put("10", tenarray);
			binaryconversion.put("11", elevenarray);
			binaryconversion.put("12", twelvearray);
			binaryconversion.put("13", thirteenarray);
			binaryconversion.put("14", fourteenarray);
			binaryconversion.put("15", fifteenarray);
			
			//convert input into binary
			ArrayList <ArrayList> binaryarray = new ArrayList <ArrayList>();
			for(int i = 0; i < inputarray.size(); i++){
//				System.out.println(inputarray.get(i));
//				System.out.println(binaryconversion.get(inputarray.get(i))[0]);
//				System.out.println(binaryconversion.get(inputarray.get(i))[1]);
//				System.out.println(binaryconversion.get(inputarray.get(i))[2]);
//				System.out.println(binaryarray);
				binaryarray.add(binaryconversion.get(inputarray.get(i)));
//				System.out.println(binaryarray);
			}
			ArrayList <ArrayList> k = binaryarray;
			ArrayList <ArrayList> newcombos = cancombine(binaryarray);
//			System.out.println(cancombine(binaryarray));
			while(k != newcombos){
				k = newcombos;
				newcombos = cancombine(newcombos);
			}
//			for(int a = 0; a < newcombos.size()-1; a++){
//				for(int b = a+1; b <newcombos.size(); b++){
//					if(newcombos.get(a) == newcombos.get(b)){
//						System.out.println("duplicate");
//						newcombos.remove(b);
//						b--;
//					}
//				}
//			}
//			System.out.println(newcombos);

//			ArrayList <ArrayList> newcombos = new ArrayList <ArrayList>();
//			int collisions = 0;
//			for(int m = 0; m < binaryarray.size()-1; m++){
//				for(int n = m+1; n < binaryarray.size(); n++){
//					collisions = 0;
//					for(int j = 0; j < 4; j++){
//						if(binaryarray.get(m).get(j) != binaryarray.get(n).get(j)){
//							collisions++;
//						}
//					}
//					if(collisions == 1){
//						newcombos.add(combine(binaryarray.get(m), binaryarray.get(n)));
//	//					binaryarray.remove(m);
//	//					binaryarray.remove(n);
//	//					m--;
//					}
//				}
//			}
//			System.out.println(combination);
//			System.out.println(newcombos);
			String answer = "";
			if(numruns < 4){
				for(int n = 0; n < newcombos.size(); n++){
					if(n > 0){
						answer = answer + " + ";
					}
					if(newcombos.get(n).get(1) == "1"){
						answer = answer + "A";
					}
					else if(newcombos.get(n).get(1) == "0"){
						answer = answer + "a";
					}
					if(newcombos.get(n).get(2) == "1"){
						answer = answer + "B";
					}
					else if(newcombos.get(n).get(2) == "0"){
						answer = answer + "b";
					}
					if(newcombos.get(n).get(3) == "1"){
						answer = answer + "C";
					}
					else if(newcombos.get(n).get(3) == "0"){
						answer = answer + "c";
					}
				}
			}
			else{
				for(int n = 0; n < newcombos.size(); n++){
					if(n > 0){
						answer = answer + " + ";
					}
					if(newcombos.get(n).get(0) == "1"){
						answer = answer + "A";
					}
					else if(newcombos.get(n).get(0) == "0"){
						answer = answer + "a";
					}
					if(newcombos.get(n).get(1) == "1"){
						answer = answer + "B";
					}
					else if(newcombos.get(n).get(1) == "0"){
						answer = answer + "b";
					}
					if(newcombos.get(n).get(2) == "1"){
						answer = answer + "C";
					}
					else if(newcombos.get(n).get(2) == "0"){
						answer = answer + "c";
					}
					if(newcombos.get(n).get(3) == "1"){
						answer = answer + "D";
					}
					else if(newcombos.get(n).get(3) == "0"){
						answer = answer + "d";
					}
				}
			}
			
			System.out.println(answer);
			
			//combine until you can't
			
			//convert to letters
			
			//**BONUS: simplify
		}//while
	}//main
	
//	public static ArrayList cancombine(ArrayList <ArrayList> binaryarray){
//		return cancombineREAL(binaryarray, newcombos);
//	}
//	
	public static ArrayList cancombine(ArrayList <ArrayList> binaryarray){
		ArrayList <ArrayList> newcombos = new ArrayList <ArrayList>();
		int collisions = 0;
		for(int m = 0; m < binaryarray.size()-1; m++){
			for(int n = m+1; n < binaryarray.size(); n++){
				collisions = 0;
				for(int j = 0; j < 4; j++){
					if(binaryarray.get(m).get(j) != binaryarray.get(n).get(j)){
						collisions++;
					}
				}
				if(collisions == 1){
					newcombos.add(combine(binaryarray.get(m), binaryarray.get(n)));
				}
				else if(collisions == 0){
//					System.out.println("collisions == 0");
					newcombos.add(combine(binaryarray.get(m), binaryarray.get(n)));
				}
			}
		}
		if(newcombos.isEmpty()){
			return binaryarray;
		}
		return newcombos;
	}
	
	public static ArrayList combine(ArrayList array1, ArrayList array2){
		ArrayList <String> combination = new ArrayList <String>();
		for(int j = 0; j < 4; j++){
			if(array1.get(j) != array2.get(j)){
				combination.add("*");
			}
			else{
				combination.add(array1.get(j).toString());
			}
		}
		return combination;
		
	}//combine

}//class
