package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ACSL2_STRING15_c17es {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/string15";
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

	static String solve(String s) {
		

		String[] input = null; 
		String[] number = new String[2];
		String result; 
		String numberreal; 
		String before;
		String after;
		int length = 0; 
		int decimal = 0; 
		int sos; 
		 
		input = s.split(",[ ]*");
		
//		for(int l = 0; l<input.length; l++){
//			System.out.println(input[l]);
//		}
		numberreal = input[0].toString(); 
	//	System.out.println(numberreal);
		length = Integer.parseInt(input[1]);
		decimal = Integer.parseInt(input[2]);
		
		String notrounding;
		String round; 
		String help; 
		number =numberreal.split("[.]");
		before = number[0]; 
		result = before; 
		after = number[1];
	
			notrounding = after.substring(0, decimal-1);
			result = result + "." + notrounding; 
			
			round = after.substring(decimal-1);
	
		
//		System.out.println("before " + before);
//		System.out.println("not rounding "+notrounding);
//		System.out.println("rounding "+round);
//		

			if( (length-decimal-1)==before.length()){
				//System.out.println("WORKS");
				if(after.length()>decimal){
					sos =Character.getNumericValue(round.charAt(1));
					if (sos>=5){ 
						help = Integer.toString((Character.getNumericValue(round.charAt(0))+1)); 
						result = result + help;
					}
					else{
						result = result + Character.toString(round.charAt(0));
					}
				}
				else if(after.length()==decimal){
					result = result + round; 
				}
				else{
					result = result + round; 
					for (int l = 0; l < decimal-after.length(); l++);
					result = result + "#";
				}
			}
			else if( (length-decimal-1)<before.length()){
				//System.out.println("DOWN HERE");
				String numbersigns = ""; 
				for(int i=0; i<(length-decimal)-1; i++){
					
					//System.out.println("ehgfejhf " + numbersigns);
					numbersigns = numbersigns + "#";
				}
				numbersigns = numbersigns +".";
				for(int i=0; i<decimal; i++){
					numbersigns = numbersigns + "#";
				}
				
				result = numbersigns; 
			}
			
			else if( (length-decimal-1)>before.length()){
				String numbersigns = ""; 
				for (int j = 0; j <(length-decimal-1)-before.length();j++ ){
					numbersigns = numbersigns + "#";
				}
				result = numbersigns + result; 
				if(after.length()>decimal){
					sos =Character.getNumericValue(round.charAt(1));
					if (sos>=5){ 
						help = Integer.toString((Character.getNumericValue(round.charAt(0))+1)); 
						result = result + help;
					}
					else{
						result = result + Character.toString(round.charAt(0));
					}
				}
				else if(after.length()==decimal){
					result = result + round; 
				}
				else{
					result = result + round; 
					for (int l = 0; l < decimal-after.length(); l++);
					result = result + "#";
				}
			}
			
		
		
		
		
		return result;

	}
}


