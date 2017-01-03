package org.dalton.acsl1.chmod15;
import java.util.Scanner;
/*
 * Alexis Harris
 * 
 * 0, 0, 0, 0
 * 
 */

public class ACSL1_chmod15_AH {
	
	 public static void main(String[] args) {
		for (int i = 0; i < 8; i++) {
			
		 String[]input = new String[4];
		 Scanner scan = new Scanner(System.in);
		 input = scan.nextLine().split(", "); //this works
		 
		 String num = "";

		 for (int j = 0; j < input.length; j++) {
			 num = num + input[j];
		}
		 
		 //conversions
		 int decimal = 0;
		 decimal = Integer.parseInt(num,8); //convert to base 10 (works)
		 String binary = "";
		 binary = Integer.toBinaryString(decimal); //convert to decimal (works)
		 
		 //four different char arrays
		 //split up the binary based on this
		 // once the binary is split up line it up w/ corresponding rwx permissions
		 //discard first three is char length is 12?
		 
		 //concat to make appropriate legnth if it is legnth 11, 10 or 8, 7
		 if(binary.length() == 11)
		 {
			 binary = "0" + binary; 
		 }
		 else if(binary.length() == 10)
		 {
			 binary = "00" + binary; 			 
		 }
		 else if(binary.length() == 8)
		 {
			 binary = "0" + binary; 
		 }
		 else if (binary.length() == 7)
		 {
			 binary = "00" + binary; 
		 }
		 else if(binary.length() == 6)
		 {
			 binary = "000" + binary;
		 }
		 else if(binary.length() == 5)
		 {
			 binary = "0000" + binary;
		 }
		 else if(binary.length() == 4)
		 {
			 binary = "00000" + binary;
		 }
		 else if(binary.length() == 3)
		 {
			 binary = "000000" + binary;
		 }
		 else if(binary.length() == 2)
		 {
			 binary = "0000000" + binary;
		 }
		 else if(binary.length() == 1)
		 {
			 binary = "00000000" + binary;
		 }
		 
		 String p4 = "";
		 String p1 = "";
		 String p2 = "";
		 String p3 = "";
		 
		 char[]perm1 = new char[3];
		 char[]perm2 = new char[3];
		 char[]perm3 = new char[3];
		 
		 //special permission stuff
		 if(binary.length() == 12)
		 {
			 p4 = binary.substring(0, 3);
			 p1 = binary.substring(3, 6);
			 p2 = binary.substring(6, 9);
			 p3 = binary.substring(9, 12);
			 
			 //System.out.println(p4);
			 
			 //if p4(0) == 1 and p1(2) == 1 go to t
			 //if p4(1) == 1 and p2(2) == 1 go to s
			 //if p(4(3) == 1 and p3(2) == 1 go to s
			 
			 //p1
			 if(p1.charAt(0) == '0')
			 {
				 perm1[0] = '-';
			 }
			 else
			 {
				 perm1[0] = 'r';
			 }
			 
			 if(p1.charAt(1) == '0')
			 {
				 perm1[1] = '-';
			 }
			 else
			 {
				 perm1[1] = 'w';
			 }
			 
			 if(p1.charAt(2) == '0')
			 {
				 perm1[2] = '-';
			 }
			 else
			 {
				 if(p4.charAt(2) == '1')
				 {
					 perm1[2] = 's';
				 }
				 else
				 {
					 perm1[2] = 'x';
				 }	 
			 }
			 
			 //p2
			 if(p2.charAt(0) == '0')
			 {
				 perm2[0] = '-';
			 }
			 else
			 {
				 perm2[0] = 'r';
			 }
			 
			 if(p2.charAt(1) == '0')
			 {
				 perm2[1] = '-';
			 }
			 else
			 {
				 perm2[1] = 'w';
			 }
			 
			 if(p2.charAt(2) == '0')
			 {
				 perm2[2] = '-';
			 }
			 else
			 {
				 if(p4.charAt(1) == '1')
				 {
					 perm2[2] = 's';
				 }
				 else
				 {
					 perm2[2] = 'x';
				 } 
			 }
			 
			 //p3
			 if(p3.charAt(0) == '0')
			 {
				 perm3[0] = '-';
			 }
			 else
			 {
				 perm3[0] = 'r';
			 }
			 
			 if(p3.charAt(1) == '0')
			 {
				 perm3[1] = '-';
			 }
			 else
			 {
				 perm3[1] = 'w';
			 }
			 
			 if(p3.charAt(2) == '0')
			 {
				 perm3[2] = '-';
			 }
			 else
			 {
				 if(p4.charAt(0) == '1')
				 {
					 perm3[2] = 't';
				 }
				 else
				 {
					 perm3[2] = 'x'; 
				 }	
			 }
			 
		 }
		 else
		 {
			 p1 = binary.substring(0, 3);
			 p2 = binary.substring(3, 6);
			 p3 = binary.substring(6, 9);
			 
			 //p1
			 if(p1.charAt(0) == '0')
			 {
				 perm1[0] = '-';
			 }
			 else
			 {
				 perm1[0] = 'r';
			 }
			 
			 if(p1.charAt(1) == '0')
			 {
				 perm1[1] = '-';
			 }
			 else
			 {
				 perm1[1] = 'w';
			 }
			 
			 if(p1.charAt(2) == '0')
			 {
				 perm1[2] = '-';
			 }
			 else
			 {
				 perm1[2] = 'x';
			 }
			 
			 //p2
			 if(p2.charAt(0) == '0')
			 {
				 perm2[0] = '-';
			 }
			 else
			 {
				 perm2[0] = 'r';
			 }
			 
			 if(p2.charAt(1) == '0')
			 {
				 perm2[1] = '-';
			 }
			 else
			 {
				 perm2[1] = 'w';
			 }
			 
			 if(p2.charAt(2) == '0')
			 {
				 perm2[2] = '-';
			 }
			 else
			 {
				 perm2[2] = 'x';
			 }
			 
			 //p3
			 if(p3.charAt(0) == '0')
			 {
				 perm3[0] = '-';
			 }
			 else
			 {
				 perm3[0] = 'r';
			 }
			 
			 if(p3.charAt(1) == '0')
			 {
				 perm3[1] = '-';
			 }
			 else
			 {
				 perm3[1] = 'w';
			 }
			 
			 if(p3.charAt(2) == '0')
			 {
				 perm3[2] = '-';
			 }
			 else
			 {
				 perm3[2] = 'x';
			 }
		 }
		 
		 System.out.print(p1 + " " + p2 + " " + p3 + " and "); //proper print out of the binary
		 
		 for (int j = 0; j < perm3.length; j++) {
				System.out.print(perm1[j]);
			}
		 
		 System.out.print(" ");
		 
		 for (int j = 0; j < perm3.length; j++) {
				System.out.print(perm2[j]);
			}
		 
		 System.out.print(" ");
		 
		 for (int j = 0; j < perm3.length; j++) {
				System.out.print(perm3[j]);
			}
		 
		 }
	}//end main
		 
		 
	 
} //end class
