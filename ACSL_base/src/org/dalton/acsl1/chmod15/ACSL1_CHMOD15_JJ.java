package org.dalton.acsl1.chmod15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ACSL1_CHMOD15_JJ {
	public static void main(String[] args) throws IOException {
		String filein = "testdata/CHMOD";
		Scanner scan;
		FileOutputStream fop = null;

		try{
			scan = new Scanner(new BufferedReader(new FileReader(filein)));
			fop = new FileOutputStream(new File(filein+"-out"));
		} catch(FileNotFoundException e) {
			scan = new Scanner(System.in);
		}

		while(scan.hasNext()) {
			String[] data = new String[5];
			for (int i = 0; i < data.length; i++) {
				data[i] = scan.nextLine();
				String answer = solve(data[i]);
				System.out.println(answer);
				if(fop!=null) fop.write((answer+"\n").getBytes());
			}
		}

		fop.flush();
		fop.close();
		scan.close();
	}

	static String solve(String s) {
		Parse p = new Parse();
		int[] inp = p.usingSplit(s);
		int specialCase = inp[0];
		String[] bin = new String[3];
		String out = "";

		DecimalFormat df = new DecimalFormat();

		df.setMinimumIntegerDigits(3);

		for (int i = 1; i < inp.length; i++) {
			bin[i-1]=df.format(Double.valueOf(Integer.toBinaryString(inp[i])));
			out+=bin[i-1]+" ";
		}
		out+="and ";
		for (int i = 0; i < bin.length; i++) {
			for (int j = 0; j < bin.length; j++) {
				if(bin[i].charAt(j)=='1'){
					if(j==0) out+="r";
					else if(j==1) out+="w";
					else if(j==2 && specialCase == 1 && i==0) out+="s";
					else if(j==2 && specialCase == 2 && i==1) out+="s";
					else if(j==2 && specialCase == 4 && i==2) out+="t";
					else out+="x";
				}
				else out+="-";
			}
			out+=" ";
		}
		return out;
	}
}

class Parse {
	public Parse(){
		super();
	}
	
	public int[] usingSplit(String s)
	{
		String[] data = s.split(",[ ]*");
		int[] inp = new int[data.length];
		for(int i=0; i<data.length; i++){
			inp[i]= Integer.valueOf(data[i]);
		}
		return inp;
	}
}