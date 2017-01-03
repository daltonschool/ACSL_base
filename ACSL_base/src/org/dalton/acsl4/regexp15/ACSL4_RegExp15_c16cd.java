package org.dalton.acsl4.regexp15;
import java.util.ArrayList;
import java.util.Scanner;


public class ACSL4_RegExp15_c16cd {

	public static void main (String[] args){

		Scanner scan = new Scanner(System.in);

		//Take input of 10 expressions
		String input = scan.nextLine();
		String [] inputs = input.split(", ");	

		for (int f = 0; f < 5; f++) {

			String regex = scan.nextLine();

			ArrayList<String> list = new ArrayList<String>();

			String empty = "";
			for (int i = 0; i < inputs.length; i++) {
				if(inputs[i].matches(regex)){
					list.add(inputs[i]);
				}
				if(inputs[i].matches(empty)) {
					System.out.println("here");
					list.add("#");
				}
			}
			if(list.isEmpty()==true){
				System.out.println("NONE");
			}
			else{

				for (int j = 0; j < list.size(); j++) {
					if(j==list.size()-1) System.out.println(list.get(j));
					else {
						System.out.print(list.get(j)+ ", ");
					}
				}	
			}
		}		
	}
}
