package org.dalton.acsl2.string15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;


public class ACSL2_String16_JJ {
	public static void main(String[] args) throws IOException {
		String filein = "testdata/String-in";
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
			String[] data = new String[5];
			for (int i = 0; i < data.length; i++) {
				data[i] = scan.nextLine();
				Parse p = new Parse();
				String answer = solve(p.usingSplit(data[i])[0], Integer.valueOf(p.usingSplit(data[i])[1]), Integer.valueOf(p.usingSplit(data[i])[2]));
				System.out.println(answer);
				if(fop!=null) fop.write((answer+"\n").getBytes());
			}
		}
		fop.flush();
		fop.close();
		scan.close();

		/**
		 * solve for a specific input
		 * @param s the input
		 * @return the output
		 */
	}

	public static String solve(String f, Integer l, Integer dec) {
		boolean add = false;
		if(f.contains("+")) {
			add = true;
			l = l-1;
		}
		if(dec==0) f = f.replace(",", "");
		DecimalFormat df = new DecimalFormat();
		df.setRoundingMode(RoundingMode.HALF_UP);
		df.setMaximumFractionDigits(dec);
		df.setMinimumFractionDigits(dec);
		String inter = String.valueOf(df.format(Double.valueOf(f)));
		df.setMaximumIntegerDigits(l-(dec+1));
		String out = String.valueOf(df.format(Double.valueOf(f)));

		if(!(out.equals(inter))) out = out.replaceAll("\\d", "#");
		else if(out.length()<l) {
			String temp="";
			for(int i=out.length(); i<l; i++) temp+="#";
			out = temp + out;
		}
		if(out.indexOf(".")==l) out = out.replace(".", "");
		if(add==true) out = "+" + out;
		if(l==0) out="";
		return out;
	}
}

class Parse {
	public Parse(){
		super();
	}

	public String[] usingSplit(String s)
	{
		String[] data = s.split(",[ ]*");
		String[] inp = new String[data.length];
		for(int i=0; i<data.length; i++){
			inp[i]= data[i];
		}
		return inp;
	}
}


