package org.dalton.acsl1.chmod15;
import java.util.Scanner; //Makoto Nara
public class ACSL1_chmod15_MN {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){ 
			String[] input = scan.nextLine().split(", "), binary = {"000", "001", "010", "011", "100", "101", "110", "111"}, values1 = {"---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx", /*new section*/ "---", "--s", "-w-", "-ws", "r--", "r-s", "rw-", "rws", /*new section*/ "---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx", /*new section*/ "---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx", /*new section*/ "---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx"}, values2 = {"---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx", /*new section*/ "---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx", /*new section*/ "---", "--s", "-w-", "-ws", "r--", "r-s", "rw-", "rws", /*new section*/ "---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx", /*new section*/ "---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx"}, values3 = {"---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx", /*new section*/ "---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx", /*new section*/ "---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx", /*new section*/ "---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx", /*new section*/ "---", "--t", "-w-", "-wt", "r--", "r-t", "rw-", "rwt"};
			System.out.println(binary[Integer.parseInt(input[1])] + " " + binary[Integer.parseInt(input[2])] + " " + binary[Integer.parseInt(input[3])] + " and " + values1[(Integer.parseInt(input[1]) + 8*Integer.parseInt(input[0]))] + " " + values2[(Integer.parseInt(input[2]) + 8*Integer.parseInt(input[0]))] + " " + values3[(Integer.parseInt(input[3]) + 8*Integer.parseInt(input[0]))]);
		}
	}
}