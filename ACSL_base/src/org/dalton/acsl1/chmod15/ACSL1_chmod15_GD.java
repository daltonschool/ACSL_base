package org.dalton.acsl1.chmod15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * ASCL CHMOD 
 * @GretchenDoyle
 * 
 * Test code:
 * 1. 4, 5, 2, 6
 * 2. 1, 0, 1, 6
 *
 */
public class ACSL1_chmod15_GD {
	public static void main(String[] args) throws IOException {
		//declarations:
		String filein = "chmodtest";
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

	static String solve(String s){
		String[] data = s.split(",[ ]*");
		int specialInt = Integer.parseInt(data[0]);
		int ownerOct = Integer.parseInt(data[1]);
		int groupOct = Integer.parseInt(data[2]);
		int othersOct = Integer.parseInt(data[3]);
		String owner = toBinary(ownerOct);
		String group = toBinary(groupOct);
		String others = toBinary(othersOct);
		
		String ownerFinal = permission(owner);
		if(specialInt==1){
			if(ownerFinal.equals("rwx")){
				ownerFinal = "rws";
			}
			if(ownerFinal.equals("r-x")){
				ownerFinal = "r-s";
			}
			if(ownerFinal.equals("--x")){
				ownerFinal = "--s";
			}
			if(ownerFinal.equals("-wx")){
				ownerFinal = "-ws";
			}
		}
		
		String groupFinal = permission(group);
		if(specialInt==2){
			if(groupFinal.equals("rwx")){
				groupFinal = "rws";
			}
			if(groupFinal.equals("r-x")){
				groupFinal = "r-s";
			}
			if(groupFinal.equals("--x")){
				groupFinal = "--s";
			}
			if(groupFinal.equals("-wx")){
				groupFinal = "-ws";
			}
		}
		
		String othersFinal = permission(others);
		if(specialInt==4){
			if(othersFinal.equals("rwx")){
				othersFinal = "rwt";
			}
			if(othersFinal.equals("r-x")){
				othersFinal = "r-t";
			}
			if(othersFinal.equals("--x")){
				othersFinal = "--t";
			}
			if(othersFinal.equals("-wx")){
				othersFinal = "-wt";
			}
		}
		
		//output
		System.out.print(" " + toBinary(ownerOct));
		System.out.print(" " + toBinary(groupOct));
		System.out.print(" " + toBinary(othersOct));
		System.out.print(" and");
		System.out.print(" " + ownerFinal);
		System.out.print(" " + groupFinal);
		System.out.print(" " + othersFinal);

		return "";
	}
	
	//convert octal number to binary
	static String toBinary(int i){
		if(i == 0) return "000";
		
		if(i == 1) return "001";
		
		if(i == 2) return "010";
		
		if(i == 3) return "011";
		
		if(i == 4) return "100";
			
		if(i == 5) return "101";
		
		if(i == 6) return "110";
			
		if(i == 7) return "111";
			
		else return "222";
	}//end of function
	
	static String permission(String i){
		if(i.equals("000")) return "---";
		
		if(i.equals("001"))	return "--x";
		
		if(i.equals("010")) return "-w-";
		
		if(i.equals("011")) return "-wx";
		
		if(i.equals("100")) return "r--";
			
		if(i.equals("101")) return "r-x";
			
		if(i.equals("110")) return "rw-";
		
		if(i.equals("111")) return "rwx";
		
		else return "";
	}
}

