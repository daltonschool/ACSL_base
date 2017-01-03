package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ACSL2_String15_c17KW {

	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testData/testData"; //name the file from test data
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
		s=s.replace(",", "");
		String[] strings = s.split("[' ']");
		char sign = ' ';
		if ((strings[0].charAt(0)=='+')||(strings[0].charAt(0)=='-')){
			sign = strings[0].charAt(0);
			strings[0] = strings[0].substring(1); //deletes away the sign
			
		}
		int stringLength = strings[0].length()-1;
		int length = Integer.parseInt(strings[1]);
		if (stringLength>length){ 
			strings[0]= "";
			for (int i = 0; i <length-1; i ++){
				if (length-i-1==Integer.parseInt(strings[2])){ 
					strings[0] = strings[0]+"."; 
				}
				strings[0] = strings[0]+'#';
			}
		} else {
			strings[0] = Double.toString((Math.round((Double.parseDouble(strings[0]))*Math.pow(10, Double.parseDouble(strings[2]))))/Math.pow(10,  Double.parseDouble(strings[2])));	
		}
		
		if (strings[0].charAt(0)!='#'){
			//System.out.println("debug1");
			if (stringLength<length){
				//System.out.println("debug2");
				if (sign== ' '){
					//System.out.println("debug3");
					for (int i = 0; i < length-stringLength; i++){
						strings[0]= "#"+strings[0];
					}
				}
			}
			if (sign!=' '){
				strings[0] = sign+strings[0];
			}
			
		} 
		
		
		
		
		return strings[0];
	}

}
