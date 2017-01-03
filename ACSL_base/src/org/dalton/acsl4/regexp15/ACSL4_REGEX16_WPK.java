package org.dalton.acsl4.regexp15;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ACSL4_REGEX16_WPK {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] data = scan.nextLine().split(",[ ]*");
		for (int j = 0; j < 5; j++) 
		{
			String check = scan.nextLine();
			String fin = "";
			for (int i = 0; i < data.length; i++) if(Pattern.matches(check, data[i]) == true) fin += data[i] + ", ";
			fin = fin.substring(0, fin.length() - 2);
			System.out.println(fin);
		}
	}
}