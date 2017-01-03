package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;


public class ACSL1_chmod15_JS {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/ASCLchmod";
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
		String input = s;
		String[] data = input.split(",[ ]*");
		int size = data.length-1;

		//variables
		//	String [] data = new String[size];

		String [] numbers = new String[8];
		String [] monkey = new String[8];

		//getting three number number into chmod 
		//		for(int i=1; i<size-1;i++){
		//			data[0]=data[i];
		//		}


		numbers[0] = "000";
		numbers[1] = "001";
		numbers[2] = "010";
		numbers[3] = "011";
		numbers[4] = "100";
		numbers[5] = "101";
		numbers[6] = "110";
		numbers[7] = "111";

		monkey[0] = "0";
		monkey[1] = "1";
		monkey[2] = "2";
		monkey[3] = "3";
		monkey[4] = "4";
		monkey[5] = "5";
		monkey[6] = "6";
		monkey[7] = "7";

		String [] turtle = new String[data.length];


		//new stuff

		int[] dataInts = new int[data.length];

		for(int k = 0; k<data.length;k++){
			dataInts[k] = Integer.parseInt(data[k]);
		}

		String [] spanish = new String[data.length-1];

		//spot one
		if(dataInts[1]==0){
			spanish[0] = "000";
		}
		else if(dataInts[1]==1){
			spanish[0] = "001";
		}
		else if(dataInts[1]==2){
			spanish[0] = "010";
		}
		else if(dataInts[1]==3){
			spanish[0] = "011";
		}
		else if(dataInts[1]==4){
			spanish[0] = "100";
		}
		else if(dataInts[1]==5){
			spanish[0] = "101";
		}
		else if(dataInts[1]==6){
			spanish[0] = "110";
		}
		else if(dataInts[1]==7){
			spanish[0] = "111";
		}


		//spot two
		if(dataInts[2]==0){
			spanish[1] = "000";
		}
		else if(dataInts[2]==1){
			spanish[1] = "001";
		}
		else if(dataInts[2]==2){
			spanish[1] = "010";
		}
		else if(dataInts[2]==3){
			spanish[1] = "011";
		}
		else if(dataInts[2]==4){
			spanish[1] = "100";
		}
		else if(dataInts[2]==5){
			spanish[1] = "101";
		}
		else if(dataInts[2]==6){
			spanish[1] = "110";
		}
		else if(dataInts[2]==7){
			spanish[1] = "111";
		}

		//spot three
		if(dataInts[3]==0){
			spanish[2] = "000";
		}
		else if(dataInts[3]==1){
			spanish[2] = "001";
		}
		else if(dataInts[3]==2){
			spanish[2] = "010";
		}
		else if(dataInts[3]==3){
			spanish[2] = "011";
		}
		else if(dataInts[3]==4){
			spanish[2] = "100";
		}
		else if(dataInts[3]==5){
			spanish[2] = "101";
		}
		else if(dataInts[3]==6){
			spanish[2] = "110";
		}
		else if(dataInts[3]==7){
			spanish[2] = "111";
		}

		//spanish to full binary 

		//different binary section
		char [] UserPermission = new char[3];
		UserPermission = spanish[0].toCharArray();

		char [] GroupPermission = new char[3];
		GroupPermission = spanish[1].toCharArray();

		char [] OthersPermission = new char[3];
		OthersPermission = spanish[2].toCharArray();

		//user permission letters
		if(UserPermission[0]!='0'){
			UserPermission[0] = 'r';
		}
		else{
			UserPermission[0] = '-';
		}
		if(UserPermission[1]!='0'){
			UserPermission[1] = 'w';
		}
		else{
			UserPermission[1] = '-';
		}
		if(UserPermission[2]!='0'){
			UserPermission[2] = 'x';
		}
		else{
			UserPermission[2] = '-';
		}


		//group permission letters
		if(GroupPermission[0]!='0'){
			GroupPermission[0] = 'r';
		}
		else{
			GroupPermission[0] = '-';
		}
		if(GroupPermission[1]!='0'){
			GroupPermission[1] = 'w';
		}
		else{
			GroupPermission[1] = '-';
		}
		if(GroupPermission[2]!='0'){
			GroupPermission[2] = 'x';
		}
		else{
			GroupPermission[2] = '-';
		}

		//others permission letters
		if(OthersPermission[0]!='0'){
			OthersPermission[0] = 'r';
		}
		else{
			OthersPermission[0] = '-';
		}
		if(OthersPermission[1]!='0'){
			OthersPermission[1] = 'w';
		}
		else{
			OthersPermission[1] = '-';
		}
		if(OthersPermission[2]!='0'){
			OthersPermission[2] = 'x';
		}
		else{
			OthersPermission[2] = '-';
		}

		//fourth digit		
		if(dataInts[0]==1 && UserPermission[2]!='0'){
			UserPermission[2]='s';
		}
		else if(dataInts[0]==2 && GroupPermission[2]!='0'){
			GroupPermission[2]='s';
		}
		else if(dataInts[0]==4){
			if(OthersPermission[2]!='0'){
				OthersPermission[2]='t';
			}
			else OthersPermission[2] = '-';
			
		}
//		else if(dataInts[0]==4 && OthersPermission[2]=='0'){
//			OthersPermission[2] = '-';
//		}
		
		
		System.out.print(Arrays.toString(spanish).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "")); System.out.print(" and ");
		System.out.print(UserPermission); System.out.print(" "); System.out.print(GroupPermission); System.out.print(" "); System.out.println(OthersPermission);

	

		//		String binaryLong = new String();
		//		binaryLong = Arrays.toString(spanish).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", "");
		//		System.out.println(binaryLong);
		//
		//
		//
		//		//binary to rwx
		//
		//		String [] binary = new String[3];
		//
		//		for(int i = 1; i<spanish.length-1;i++){
		//			binary[i-1] = spanish[i];
		//
		//			if(binary[0]!=null){
		//				binary[0] = "r";
		//			}
		//			else{
		//				binary[0] = "-";
		//			}
		//			if(binary[1]!=null){
		//				binary[1] = "w";
		//			}
		//			else{
		//				binary[1] = "-";
		//			}
		//			if(binary[2]!=null){
		//				binary[2] = "x";
		//			}
		//			else{
		//				binary[2] = "-";
		//			}
		//		}
		//
		//		System.out.println(Arrays.toString(binary));

		return "";
	}



}
