package org.dalton.acsl1.chmod15;
import java.util.Scanner;
/*Charlie DiPrinzio
 * ACSL Program 1
 * 1/6/16
 */


public class ACSL1_chmod15_CD {

	public static void main(String[] args){

		for (int i = 0; i < 5; i++) {
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			String[] inputs = input.split(", ");

			String output = "";
			String [] outputs = new String[3];

			int special = Integer.parseInt(inputs[0]);
			int owner = Integer.parseInt(inputs[1]);
			int group = Integer.parseInt(inputs[2]);
			int others = Integer.parseInt(inputs[3]);

			outputs[0] = Integer.toBinaryString(owner);
			outputs[1] = Integer.toBinaryString(group);
			outputs[2] = Integer.toBinaryString(others);	
			for (int j = 0; j < 3; j++) {
				if(outputs[j].length()<3){
					outputs[j] = '0' + outputs[j];
				}
				if(outputs[j].length()<3){
					outputs[j] = '0' + outputs[j];
				}
			}
			
			//System.out.println(outputs[0]);
			//System.out.println(outputs[1]);
			//System.out.println(outputs[2]);

			String line = inputs[1] + ", " + inputs[2] + ", " + inputs[3];

			String[] nums = line.trim().split(" *, *");
			StringBuilder sb = new StringBuilder();
			for (String s : nums) {
				if (sb.length() > 0) sb.append(" ");
				int num = Integer.parseInt(s);
				sb.append((num & 4) == 0 ? '-' : 'r');
				sb.append((num & 2) == 0 ? '-' : 'w');
				sb.append((num & 1) == 0 ? '-' : 'x');
			}
			String permission = sb.toString();
			//  System.out.println(sb.toString());	

			String[] perm_split = permission.split(" ");

			if(special==1){
				if(perm_split[0].charAt(2)=='x') {
					perm_split[0] = perm_split[0].substring(0,2) + 's';
				}
			}			  
			else if(special==2){
				if(perm_split[1].charAt(2)=='x') {
					perm_split[1] = perm_split[1].substring(0,2) + 's';
				}
			} 
			else if(special==4){
				if(perm_split[2].charAt(2)=='x') {
					perm_split[2] = perm_split[2].substring(0,2) + 't';
				}
			}

			output = outputs[0] + " " + outputs[1] + " " + outputs[2] + " and " + perm_split[0] +" "+perm_split[1]+" "+ perm_split[2];
			System.out.println(output);

		}//for loop

	}//main

}//class




