package org.dalton.acsl2.search10;

import java.util.Scanner; 
public class TDParser {

	final static boolean DEBUG = false;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] inputs = new String[10];
		String data;
		StringBuffer dataBuf = null;
		String outputs = "";
		boolean first = true;

		data = input.nextLine();

		inputs = data.split(", ");

		for(int p=0;p<5;p++){
			data = input.nextLine();

			dataBuf = new StringBuffer(data);
			int loop = dataBuf.length();
			for(int x=0;x<loop;x++){
				if(dataBuf.charAt(x) == '*'){
					dataBuf.ensureCapacity(dataBuf.capacity()+1);
					dataBuf.insert(x, ".");
					x++;
					loop++;
				}
				if(DEBUG) System.out.println("Search String: " + dataBuf + " x=" + x);
			}

			dataBuf.append("$");

			loop = dataBuf.length();
			for(int x=0;x<loop;x++){
				if(dataBuf.charAt(x) == '?'){
					dataBuf.deleteCharAt(x);
					dataBuf.insert(x, ".");
					//x++;
				}
			}

			if(DEBUG) System.out.println(dataBuf);

			for(int i=0; i< 10; i++){
				if(inputs[i].matches(dataBuf.toString())){
					if(first) {
						outputs = inputs[i];
						first = false;
					}
					else {
						outputs = outputs + ", " + inputs[i];
					}
				}
			}
			
			if(!outputs.equals(""))System.out.println(outputs);
			else System.out.println("No Match");
			outputs = "";
			first = true;
		}

		//2BELLS, T4LLS, FALLS, DOL3LS, DUL7LS, DOLLIES, BELLY, BELLIES, TELLY, DELL

	}//end main

}//end program