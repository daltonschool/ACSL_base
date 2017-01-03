package org.dalton.acsl4.regexp15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class ACSL4_REGEXP16_JJ {
	public static void main(String[] args) throws IOException {
		String filein = "testdata/REGEXP";
		Scanner scan;
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			scan = new Scanner(System.in);
		}

		while(scan.hasNext()) {
			String[] data = new String[6];
			data[0] = scan.nextLine();
			for (int i = 1; i < data.length; i++) {
				data[i] = scan.nextLine();
				REGParse p = new REGParse();
				String answer = solve(p.parseInp(data[0]), data[i]);
				System.out.println(answer);
				if(fop!=null) fop.write((answer+"\n").getBytes());
			}
		}
		fop.flush();
		fop.close();
		scan.close();
	}
	public static String solve (String [] inp, String exp){
		String out = "";
		for (int i = 0; i < inp.length; i++) if(inp[i].matches(exp)) out+=inp[i]+", ";
		if(out=="") out="NONE";
		else out=out.substring(0, out.length()-2);
		return out;
	}
}
class REGParse {
	public REGParse(){
		super();
	}
	public String[] parseInp(String s){
		String[] data = s.split(",[ ]*");
		String[] inp = new String[10];
		for (int i = 0; i < inp.length; i++) {
			inp[i]=data[i];
		}
		return inp;
	}
}
