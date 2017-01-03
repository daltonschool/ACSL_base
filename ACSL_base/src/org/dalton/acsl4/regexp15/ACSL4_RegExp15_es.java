package org.dalton.acsl4.regexp15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ACSL4_RegExp15_es {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/reg15";
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
			String[] data = new String[6];
			for (int i = 0; i < data.length; i++) {
				data[i] = scan.nextLine();
			}
			String answer = solve(data);
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
	static String solve(String[] s) {
		
		String datas = s[0].toString();
		String[]  data = new String[10];
		data = datas.split(",[ ]*");
		
		String[][] answer = new String [5][10];
		String br="";
		
		for(int x =1; x<6; x++){
			String a = "";
			for(int y = 0; y<10; y++){
				Pattern p = Pattern.compile(s[x]);
				 Matcher m = p.matcher(data[y]);
				 boolean b = m.matches();
				if(b==true){
					
					answer[x-1][y] = data[y];
					//System.out.println(answer[x-1][y]);
					a += answer[x-1][y].toString() +", ";
					
					
				}
				
				
			}
			if (a.equals("")){
				a = "#";
			}
			a=a.replaceAll(", $", "");
			if(x<5){
				
				System.out.println(a);
			}
			else {
				br = a; 
			}
			
			
			
		}
		
		
	
		
		return br;
	}
}