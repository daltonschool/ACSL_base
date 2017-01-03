package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class ACSL1_chomod15_NS {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "testdata/ChomodTestData";
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
		String input = s;
		String [] data = input.split(", ");
		int specialpermissions = Integer.parseInt(data[0]);
		int owner = Integer.parseInt(data[1]); 
		int group = Integer.parseInt(data[2]);
		int others = Integer.parseInt(data[3]);
		String ownerstring = "";
		String groupstring = "";
		String othersstring = "";
		//ownertobinary
		if(owner==0){
			System.out.print("000 ");
			ownerstring = "000";
		}
		else if(owner==1) {
			System.out.print("001 ");
			ownerstring = "001";
		}
		else if(owner==2) {
			System.out.print("010 ");
			ownerstring = "010";
		}
		else if(owner==3) {
			System.out.print("011 ");
			ownerstring = "011";
		}
		else if(owner==4) {
			System.out.print("100 ");
			ownerstring = "100";
		}
		else if(owner==5) {
			System.out.print("101 ");
			ownerstring = "101";
		}
		else if(owner==6) {
			System.out.print("110 ");
			ownerstring = "110";
		}
		else if(owner==7) {
			System.out.print("111 ");
			ownerstring = "111";
		}
		//grouptobinary
		if(group==0){
			System.out.print("000 ");
			groupstring = "000";
		}
		else if(group==1) {
			System.out.print("001 ");
			groupstring = "001";
		}
		else if(group==2) {
			System.out.print("010 ");
			groupstring = "010";
		}
		else if(group==3) {
			System.out.print("011 ");
			groupstring = "011";
		}
		else if(group==4) {
			System.out.print("100 ");
			groupstring = "100";
		}
		else if(group==5) {
			System.out.print("101 ");
			groupstring = "101";
		}
		else if(group==6) {
			System.out.print("110 ");
			groupstring = "110";
		}
		else if(group==7) {
			System.out.print("111 ");
			groupstring = "111";
		}
		//otherstobinary
		if(others==0){
			System.out.print("000 ");
			othersstring = "000";
		}
		else if(others==1) {
			System.out.print("001");
			othersstring = "001";
		}
		else if(others==2) {
			System.out.print("010 ");
			othersstring = "010";
		}
		else if(others==3) {
			System.out.print("011 ");
			othersstring = "011";
		}
		else if(others==4) {
			System.out.print("100 ");
			othersstring = "100";
		}
		else if(others==5) {
			System.out.print("101 ");
			othersstring = "101";
		}
		else if(others==6) {
			System.out.print("110 ");
			othersstring = "110";
		}
		else if(others==7) {
			System.out.print("111 ");
			othersstring = "111";
		}
		System.out.print("and ");
		//ownercommands
		if (ownerstring.equals("000")){
			System.out.print("--- ");
		}
		else if(specialpermissions == 1 && ownerstring.equals("111")) {
			System.out.print("rws");
		}
		else if(specialpermissions == 1 && ownerstring.equals("101")) {
			System.out.print("r-s");
		}
		else if(specialpermissions == 1 && ownerstring.equals("011")) {
			System.out.print("-ws");
		}
		else if(specialpermissions == 1 && ownerstring.equals("001")) {
			System.out.print("--s");
		}
		else if(ownerstring.equals("001")) {
			System.out.print("--x ");
		}
		else if(ownerstring.equals("010")) {
			System.out.print("-w- ");
		}
		else if(ownerstring.equals("011")) {
			System.out.print("-wx ");	
		}
		else if(ownerstring.equals("100")) {
			System.out.print("r-- ");
		}
		else if(ownerstring.equals("101")) {
			System.out.print("r-x ");
		}
		else if(ownerstring.equals("110")) {
			System.out.print("rw- ");
		}
		else if(ownerstring.equals("111")) {
			System.out.print("rwx ");
		}
		//groupcommands
		if (groupstring.equals("000")){
			System.out.print("--- ");
		}
		else if(specialpermissions == 2 && groupstring.equals("001")) {
			System.out.print("--s");
		}
		else if(specialpermissions == 2 && groupstring.equals("011")) {
			System.out.print("-ws");
		}
		else if(specialpermissions == 2 && groupstring.equals("101")) {
			System.out.print("r-s");
		}
		else if(specialpermissions == 2 && groupstring.equals("111")) {
			System.out.print("rws");
		}
		else if(groupstring.equals("001")) {
			System.out.print("--x ");
		}
		else if(groupstring.equals("010")) {
			System.out.print("-w- ");
		}
		else if(groupstring.equals("011")) {
			System.out.print("-wx ");	
		}
		else if(groupstring.equals("100")) {
			System.out.print("r-- ");
		}
		else if(groupstring.equals("101")) {
			System.out.print("r-x ");
		}
		else if(groupstring.equals("110")) {
			System.out.print("rw- ");
		}
		else if(groupstring.equals("111")) {
			System.out.print("rwx ");
		}
		//otherscommands
		if (othersstring.equals("000")){
			System.out.print("--- ");
		}
		else if(specialpermissions == 4 && othersstring.equals("111")) {
			System.out.print("rwt");
		}
		else if(specialpermissions == 4 && othersstring.equals("101")) {
			System.out.print("r-t");
		}
		else if(specialpermissions == 4 && othersstring.equals("011")) {
			System.out.print("-wt");
		}
		else if(specialpermissions == 4 && othersstring.equals("001")) {
			System.out.print("--t");
		}
		else if(othersstring.equals("001")) {
			System.out.print("--x ");
		}
		else if(othersstring.equals("010")) {
			System.out.print("-w- ");
		}
		else if(othersstring.equals("011")) {
			System.out.print("-wx ");	
		}
		else if(othersstring.equals("100")) {
			System.out.print("r-- ");
		}
		else if(othersstring.equals("101")) {
			System.out.print("r-x ");
		}
		else if(othersstring.equals("110")) {
			System.out.print("rw- ");
		}
		else if(othersstring.equals("111")) {
			System.out.print("rwx ");
		}
		return "";
	}
}