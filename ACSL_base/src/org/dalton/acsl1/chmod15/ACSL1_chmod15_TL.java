package org.dalton.acsl1.chmod15;
import java.util.Scanner;

/*
 * Tyler Love
 */
public class ACSL1_chmod15_TL {

	public static void main(String[] args) {
		while(true){
			//get input
			Scanner scan = new Scanner(System.in);
			String in = scan.nextLine();
			String input[] = in.split(", ");
			
			//put input in variables
			String special_ = input[0];
			int octal1 = Integer.parseInt(input[1], 8);
			int octal2 = Integer.parseInt(input[2], 8);
			int octal3 = Integer.parseInt(input[3], 8);
			
			//convert to binary
			String binary1 = String.format("%3s", Integer.toBinaryString(octal1)).replace(" ", "0");
			String binary2 = String.format("%3s", Integer.toBinaryString(octal2)).replace(" ", "0");
			String binary3 = String.format("%3s", Integer.toBinaryString(octal3)).replace(" ", "0");
			
			
			//convert to rwx
			String rwx1 = "";
			String rwx2 = "";
			String rwx3 = "";
			if(binary1.charAt(0)=='1'){
				rwx1 = "r";
			}
			else{
				rwx1 = "-";
			}
			if(binary1.charAt(1)=='1'){
				rwx1 = rwx1 + "w";
			}
			else{
				rwx1 = rwx1 + "-";
			}
			if(binary1.charAt(2)=='1'){
				if (special_.charAt(0)=='1'){
					rwx1 = rwx1 + "s";
				}
				else{
					rwx1 = rwx1 + "x";
				}
			}
			else{
				rwx1 = rwx1 + "-";
			}
			if(binary2.charAt(0)=='1'){
				rwx2 = "r";
			}
			else{
				rwx2 = "-";
			}
			if(binary2.charAt(1)=='1'){
				rwx2 = rwx2 + "w";
			}
			else{
				rwx2 = rwx2 + "-";
			}
			if(binary2.charAt(2)=='1'){
				if (special_.charAt(0)=='2'){
					rwx2 = rwx2 + "s";
				}
				else{
					rwx2 = rwx2 + "x";
				}
			}
			else{
				rwx2 = rwx2 + "-";
			}	
			if(binary3.charAt(0)=='1'){
				rwx3 = "r";
			}
			else{
				rwx3 = "-";
			}
			if(binary3.charAt(1)=='1'){
				rwx3 = rwx3 + "w";
			}
			else{
				rwx3 = rwx3 + "-";
			}
			if(binary3.charAt(2)=='1'){
				if (special_.charAt(0)=='4'){
					rwx3 = rwx3 + "t";
				}
				else{
					rwx3 = rwx3 + "x";
				}
			}
			else{
				rwx3 = rwx3 + "-";
			}
			
			//print out output
			System.out.println(binary1 +" "+ binary2 +" "+ binary3 + " and " + rwx1 +" "+ rwx2 +" "+ rwx3);
		}
	}
}
