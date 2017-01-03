package org.dalton.acsl1.chmod15;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACSL1_CHMOD15_MD {

	public static void main(String[] args) throws IOException {

		//declarations:
		String filein = "testdata/all_of_em.txt";
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

	/**
	 * solve for a specific input
	 * @param s the input
	 * @return the output
	 */
	static String solve(String s) {

		String[] set = s.split(", "); //splits the data into a string[]

		int specialPermission = Integer.parseInt(set[0]); //notes the special permissions

		int[] CHMODs = new int[3]; //declare an int[] for holding the 3 different CHMOD's for each user
		CHMODs[0] = Integer.parseInt(set[1]); 
		CHMODs[1] = Integer.parseInt(set[2]);
		CHMODs[2] = Integer.parseInt(set[3]);

		//make boolean arrays of size 3 (octal) for each user
		boolean[] owner = new boolean[3]; 
		owner = OCT_BINARY(CHMODs[0]);
		boolean[] group = new boolean[3];
		group = OCT_BINARY(CHMODs[1]);
		boolean[] other = new boolean[3];
		other = OCT_BINARY(CHMODs[2]);

		//declare the string that will be returned
		String finalString = ""; //string representations of octal values will be concatenated to this String
		
		String ownerOutputBinary = "";
		for (int i = 0; i < 3; i++){
			if (owner[i] == true){
				ownerOutputBinary=ownerOutputBinary.concat("1");
			}
			else ownerOutputBinary=ownerOutputBinary.concat("0");
		}
		finalString = finalString.concat(ownerOutputBinary + " ");
		
		String groupOutputBinary = "";
		for (int i = 0; i < 3; i++){
			if (group[i] == true){
				groupOutputBinary=groupOutputBinary.concat("1");
			}
			else groupOutputBinary=groupOutputBinary.concat("0");
		}
		finalString = finalString.concat(groupOutputBinary + " ");
		
		String otherOutputBinary = "";
		for (int i = 0; i < 3; i++){
			if (other[i] == true){
				otherOutputBinary=otherOutputBinary.concat("1");
			}
			else otherOutputBinary=otherOutputBinary.concat("0");
		}
		finalString = finalString.concat(otherOutputBinary + " and ");

		String ownerOutputPS = "";
		if ((owner[0]) == true){
			ownerOutputPS=ownerOutputPS.concat("r");
		}
		else{
			ownerOutputPS=ownerOutputPS.concat("-");
		}
		if ((owner[1]) == true){
			ownerOutputPS=ownerOutputPS.concat("w");
		}
		else {
			ownerOutputPS=ownerOutputPS.concat("-");
		}
		if ((owner[2]) == true && specialPermission == 1){
			ownerOutputPS=ownerOutputPS.concat("s");
		}
		else if ((owner[2] == true)){
			ownerOutputPS=ownerOutputPS.concat("x");
		}
		else{
			ownerOutputPS=ownerOutputPS.concat("-");
		}
		finalString = finalString.concat(ownerOutputPS + " ");
		
		String groupOutputPS = "";
		if ((group[0]) == true){
			groupOutputPS=groupOutputPS.concat("r");
		}
		else{
			groupOutputPS=groupOutputPS.concat("-");
		}
		if ((group[1]) == true){
			groupOutputPS=groupOutputPS.concat("w");
		}
		else {
			groupOutputPS=groupOutputPS.concat("-");
		}
		if ((group[2]) == true && specialPermission == 2){
			groupOutputPS=groupOutputPS.concat("s");
		}
		else if ((group[2] == true)){
			groupOutputPS=groupOutputPS.concat("x");
		}
		else{
			groupOutputPS=groupOutputPS.concat("-");
		}
		finalString = finalString.concat(groupOutputPS + " ");
		
		String otherOutputPS = "";
		if ((other[0]) == true){
			otherOutputPS=otherOutputPS.concat("r");
		}
		else{
			otherOutputPS=otherOutputPS.concat("-");
		}
		if ((other[1]) == true){
			otherOutputPS=otherOutputPS.concat("w");
		}
		else {
			otherOutputPS=otherOutputPS.concat("-");
		}
		if ((other[2]) == true && specialPermission == 4){
			otherOutputPS=otherOutputPS.concat("t");
		}
		else if ((other[2] == true)){
			otherOutputPS=otherOutputPS.concat("x");
		}
		else{
			otherOutputPS=otherOutputPS.concat("-");
		}
		finalString = finalString.concat(otherOutputPS);
		
		//String heh = s;
		//heh = heh.concat(" -> " + finalString);
		
		//return heh;
		
		return finalString;
	}

	static boolean[] OCT_BINARY(int n){

		boolean[] binary = new boolean[3];

		if (n==1){
			binary[2] = true;
		}
		if (n==2){
			binary[1] = true;
		}
		if (n==3){
			binary[1] = true;
			binary[2] = true;
		}
		if (n==4){
			binary[0] = true;
		}
		if (n==5){
			binary [0] = true;
			binary [2] = true;
		}
		if (n==6){
			binary [0] = true;
			binary [1] = true;
		}
		if (n==7){
			binary [0] = true;
			binary [1] = true;
			binary [2] = true;
		}

		return binary;
	}


}
