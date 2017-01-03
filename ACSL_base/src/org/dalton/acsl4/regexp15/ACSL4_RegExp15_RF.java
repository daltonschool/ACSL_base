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


public class ACSL4_RegExp15_RF {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/RegExp_testdata";
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

	static String solve(String[] s) {

		Pattern p1 = Pattern.compile(s[1]);
		Pattern p2 = Pattern.compile(s[2]);
		Pattern p3 = Pattern.compile(s[3]);
		Pattern p4 = Pattern.compile(s[4]);
		Pattern p5 = Pattern.compile(s[5]);

		Matcher m1 = p1.matcher(s[0]);
		Matcher m2 = p2.matcher(s[0]);
		Matcher m3 = p3.matcher(s[0]);
		Matcher m4 = p4.matcher(s[0]);
		Matcher m5 = p5.matcher(s[0]);

		String output1 = "";
		String output2 = "";
		String output3 = "";
		String output4 = "";
		String output5 = "";


		//set outputs - but may contain duplicates
		for (int i = 0; i < s[0].length(); i++) {
			if(m1.find()){
				output1 += (m1.group() + ", ");
				if(output1 == ""){
					System.out.println("NONE");
				}
			}
		}
		for (int i = 0; i < s[0].length(); i++) {
			if(m2.find()){
				output2 += (m2.group() + ", ");
				if(output2 == ""){
					System.out.println("NONE");
				}
			}
		}
		for (int i = 0; i < s[0].length(); i++) {
			if(m3.find()){
				output3 += (m3.group() + ", ");
				if(output3 == ""){
					System.out.println("NONE");
				}
			}
		}
		for (int i = 0; i < s[0].length(); i++) {
			if(m4.find()){
				output4 += (m4.group() + ", ");
				if(output4 == ""){
					System.out.println("NONE");
				}
			}
		}
		for (int i = 0; i < s[0].length(); i++) {
			if(m5.find()){
				output5 += (m5.group() + ", ");
				if(output5 == ""){
					System.out.println("NONE");
				}
			}
		}

		String output1arr_nodupes = "";
		String output2arr_nodupes = "";
		String output3arr_nodupes = "";
		String output4arr_nodupes = "";
		String output5arr_nodupes = "";
		
		//take out duplicates
		String[] output1arr = output1.split(",[ ]*");
		for (int i = 0; i < output1arr.length; i++) {
			if(!output1arr_nodupes.contains(output1arr[i])){
				output1arr_nodupes += (output1arr[i] + ", ");
			}
			else{
				continue;
			}
		}
		String[] output2arr = output2.split(",[ ]*");
		for (int i = 0; i < output2arr.length; i++) {
			if(!output2arr_nodupes.contains(output2arr[i])){
				output2arr_nodupes += (output2arr[i] + ", ");
			}
			else{
				continue;
			}
		}
		String[] output3arr = output3.split(",[ ]*");
		for (int i = 0; i < output3arr.length; i++) {
			if(!output3arr_nodupes.contains(output3arr[i])){
				output3arr_nodupes += (output3arr[i] + ", ");
			}
			else{
				continue;
			}
		}
		String[] output4arr = output4.split(",[ ]*");
		for (int i = 0; i < output4arr.length; i++) {
			if(!output4arr_nodupes.contains(output4arr[i])){
				output4arr_nodupes += (output4arr[i] + ", ");
			}
			else{
				continue;
			}
		}
		String[] output5arr = output5.split(",[ ]*");
		for (int i = 0; i < output5arr.length; i++) {
			if(!output5arr_nodupes.contains(output5arr[i])){
				output5arr_nodupes += (output5arr[i] + ", ");
			}
			else{
				continue;
			}
		}
		
		System.out.println(output1arr_nodupes.substring(0, output1arr_nodupes.length()-2));
		System.out.println(output2arr_nodupes.substring(0, output2arr_nodupes.length()-2));
		System.out.println(output3arr_nodupes.substring(0, output3arr_nodupes.length()-2));
		System.out.println(output4arr_nodupes.substring(0, output4arr_nodupes.length()-2));
		System.out.println(output5arr_nodupes.substring(0, output5arr_nodupes.length()-2));

		return "";


	}
}

