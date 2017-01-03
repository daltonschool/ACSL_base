package org.dalton.acsl4.regexp15;
import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;


public class ACSL4_RegExp16_EG {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String input = scan.nextLine();
	String inputString[] = input.split(", ");
	
	while(true)
	{
	ArrayList myList = new ArrayList();
	String input1 = scan.nextLine();
		for (int i = 0; i < inputString.length; i++) {
			if(inputString[i].equals("#"))
			{
				inputString[i] = "";
			}
			if(inputString[i].matches(input1))
			{
				myList.add(inputString[i]);
			}
		}
		if(myList.toArray().length != 0)
		{
		for (int i = 0; i < myList.toArray().length-1; i++) {
			System.out.print(myList.toArray()[i] + ", ");
		}
		System.out.print(myList.toArray()[myList.toArray().length-1]);
		System.out.println();
			
	}
		else {
			System.out.println("NONE");
		}
	}
}
}

