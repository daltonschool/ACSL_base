package org.dalton.acsl1.chmod15;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;


//Created by John Remy Young

public class ACSL1_chmod15_JRY {

	public static int inputCount = 0;
	public static String[] octalToBinary = {"000", "001", "010", "011", "100", "101", "110", "111"};
	public static String[] binaryToCommand = {"---","--x", "-w-","-wx", "r--","r-x","rw-","rwx"};
	public static String[] OwnerGroupSpecial = {"---","--s","-w-","-ws","r--","r-s","rw-","rws"};
	public static String[] OtherSpecial = {"---", "--t","-w-","-wt","r--","r-t","rw-","rwt"};
	public static String[] data;
	public static int specialInsert;
	public static String finalOutput;
	public static void main(String args[]){
		while(inputCount < 5)
		{
			CleanUp();
			Scanner input = new Scanner(System.in);
			data = input.nextLine().split(", ");
			ConvertToBinary();
			ConvertToCommand();
			System.out.println(finalOutput);
			inputCount ++;
		}
	}
	public static void CleanUp()
	{
		finalOutput = "";
	}
	public static void ConvertToBinary()
	{
		for(int i = 1; i<4; i++)
		{
			finalOutput = finalOutput + octalToBinary[Integer.parseInt(data[i])] + " ";
		}
		finalOutput = finalOutput + "and ";
	}
	public static void ConvertToCommand()
	{
		if(data[0].equals("0"))
		{
			specialInsert = 0;
		}
		if(data[0].equals("1"))
		{
			specialInsert = 1;
		}
		if(data[0].equals("2"))
		{
			specialInsert = 2;
		}
		if(data[0].equals("4"))
		{
			specialInsert = 3;
		}
		for(int i = 1; i<4; i++)
		{
			if(i ==specialInsert && (i == 1||i==2))
			{
				finalOutput = finalOutput + OwnerGroupSpecial[Integer.parseInt(data[i])];
			}
			else if(i == specialInsert &&(i==3))
			{
				finalOutput = finalOutput + OtherSpecial[Integer.parseInt(data[i])];
			}
			else
			{
				finalOutput = finalOutput + binaryToCommand[Integer.parseInt(data[i])];
			}
			if(i == 1 || i ==2)
			{
			finalOutput = finalOutput + " ";
			}
		}
	}
	
}
