package org.dalton.acsl1.chmod15;
import java.util.Scanner;
import java.util.*;
public class ACSL1_chmod15_MF {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String ui1 = ""; String ui2 = ""; String ui3 = ""; String ui4 = ""; String ui5 = "";
		ui1 = scan.nextLine(); ui2 = scan.nextLine(); ui3 = scan.nextLine(); ui4 = scan.nextLine(); ui5 = scan.nextLine();
		data(ui1, 1); data(ui2, 2); data(ui3, 3); data(ui4, 4); data(ui5, 5); 
	}
	public static String data(String input ,int round)
	{
		String input2[] = input.split(", ");
		String input3[] = new String[20];
		int input4[] = new int[20];
		String user_input_rwx[] = new String[20];
		int sp = Integer.parseInt(input2[0].split(". ")[1]);
		System.out.print(round + ". ");
		for(int i = 1; i <= 3; i++) 
			{
			input3[i] = ("00" + Integer.toBinaryString(Integer.parseInt(input2[i]))); 
			input3[i]=input3[i].substring(input3[i].length()-3);
			}
		String hello = input3[1] + input3[2] + input3[3];
		String hi[] = hello.split("");
		for(int i = 1; i <= 9; i++)
			{
			input4[i] = Integer.parseInt(hi[i-1]); 
			if(i == 4 || i == 7) System.out.print(" ");
			System.out.print(input4[i]);
			}
		System.out.print(" and ");
		for(int i = 1; i <= 9; i++)
		{
		if(input4[i] == 0) user_input_rwx[i] = "-";
		if(input4[i] == 1)
		{
		if(i == 1 || i == 4 || i == 7) user_input_rwx[i] = "r";
		if(i == 2 || i == 5 || i == 8) user_input_rwx[i] = "w";
		if(i == 3 || i == 6 || i == 9)
		{
		if(i == 3 && sp == 1) user_input_rwx[i] = "s";
		else if(i == 6 && sp == 2) user_input_rwx[i] = "s";
		else if(i == 9 && sp == 4) user_input_rwx[i] = "t";
		else
			{
			user_input_rwx[i] = "x";
			}}}}
		for(int i = 1; i <= 9; i++) 
		{
			if(i == 4 || i == 7) System.out.print(" ");
			System.out.print(user_input_rwx[i]);
		}
		System.out.println("");
		return null;
	}
}