package org.dalton.acsl1.chmod15;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
public class ACSL1_chmod15_DW {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input;
		for(int k = 0 ; k < 5 ; k++){
			input = scan.nextLine();
			Scanner scan2 = new Scanner(new ByteArrayInputStream(input.getBytes())); 
			scan2.useDelimiter(",[ ]*");
			int a = scan2.nextInt();
			int b = scan2.nextInt();
			int c = scan2.nextInt();
			int d = scan2.nextInt();
			String x = new String(convert(b, a, 1));
			String y = new String(convert(c, a, 2));
			String z = new String(convert(d, a, 3));
			System.out.println("and " + x + " " + y + " " + z + " ");
		}
	}
	public static char[] convert (int input, int perm, int who){
		char[] commands = new char[3];
		char[] binary = new char[3];
		if(input>3) binary[0] = '1';
		else binary[0] = '0';
		if(input%4>1) binary[1] = '1';
		else binary[1] = '0';
		if(input%2==1) binary[2] = '1';
		else binary[2] = '0';
		String a = new String(binary);
		System.out.print(a + " ");
		if(binary[0]=='1') commands[0]='r';
		else commands[0]='-';
		if(binary[1]=='1') commands[1]='w';
		else commands[1]='-';
		if(binary[2]=='1'){
			if(perm==who) commands[2] = 's';
			else if(perm==4&&who==3) commands[2] = 't';
			else commands[2] = 'x';
		}
		else commands[2]='-';
		return commands;
	}
}