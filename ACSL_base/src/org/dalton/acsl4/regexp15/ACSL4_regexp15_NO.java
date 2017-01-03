package org.dalton.acsl4.regexp15;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ACSL4_regexp15_NO {

	public static void main(String[] args) {

		ArrayList<String> lines = new ArrayList<String>();
		
		try { 
			Scanner in = new Scanner(new File("daita.in"));

			

			for(int i= 0; i < 6 && in.hasNext(); i++) {

				String line = in.nextLine();
				line = line.substring(3, line.length());

				lines.add(line);
			}

			


		} catch (Exception e){
			//System.out.println("catchhhh");
			Scanner in = new Scanner(System.in);

			for(int i= 0; i < 6; i++) {
				System.out.print((i+1) + ". ");
				String line = in.nextLine();

				lines.add(line);
				
			}
		}
		
		String line1 = lines.get(0); 
		String[] line1p = line1.split(", ");


		for(int i = 1; i < lines.size(); i++) {
			System.out.print(i + ". ");

			//System.out.println();
			for(int j = 0; j < line1p.length; j++) {
				//System.out.println("LINE " + line1p[j] + " " + lines.get(i));
				//System.out.println();
				if(line1p[j].matches(lines.get(i))) {
					System.out.print(line1p[j] + ", ");
				} 
			}

			System.out.println();
		}
	}

}
