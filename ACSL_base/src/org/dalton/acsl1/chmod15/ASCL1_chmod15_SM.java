package org.dalton.acsl1.chmod15;
import java.util.ArrayList;
import java.util.Scanner;
/* Seneca Meeks 
 * ACSL 1 
 */
public class ASCL1_chmod15_SM {
	public static String to_binary(int val) //Conversion method
	{
		String binary = Integer.toBinaryString(val); //converts oct to binary
		binary = ("000" + binary).substring(binary.length()); //including padded 0s 
		return binary + " "; 
	}  
	public static String permission(ArrayList<String> p, int sp) 	//permission constructor 
	{
		StringBuilder per_out = new StringBuilder(""); 
		StringBuilder owner_per = new StringBuilder("rwx");
		StringBuilder group_per = new StringBuilder("rwx");
		StringBuilder other_per = new StringBuilder("rwx");

		String owner_bin = p.get(0);
		String group_bin = p.get(1);
		String other_bin = p.get(2); 

		for (int i = 0; i < 3; i++) { if (owner_bin.charAt(i) == '0') { owner_per.setCharAt(i,'-'); } }
		for (int i = 0; i < 3; i++) { if (group_bin.charAt(i) == '0') { group_per.setCharAt(i,'-'); } }
		for (int i = 0; i < 3; i++) { if (other_bin.charAt(i) == '0') { other_per.setCharAt(i,'-'); } }
		
		if (sp == 1 && owner_per.charAt(2) == 'x')  { owner_per.setCharAt(2, 's' ); }
		if (sp == 2 && group_per.charAt(2) == 'x')  { group_per.setCharAt(2, 's' ); }
		if (sp == 4 && other_per.charAt(2) == 'x')  { other_per.setCharAt(2, 't' ); }

		per_out.append(owner_per + " ");  
		per_out.append(group_per + " ");  
		per_out.append(other_per);  

		return per_out.toString(); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); 
		while(scan.hasNext()){ 	
			//Declarations
			String[] input = scan.nextLine().split(", "); //stores input
			int sp = Integer.parseInt(input[0]); //special permissions integer 
			int[] val = new int[] {Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])}; //owner_oct, group_oct, other_oct 
			ArrayList<String> bin = new ArrayList<String>();
			String binary_out = ""; 

			for (int i = 0; i < val.length; i++) //constructs binary string
			{
				bin.add(to_binary(val[i])); 
				binary_out += to_binary(val[i]); 	
			}				
			System.out.print("\n" + binary_out + "and " + permission(bin, sp)); 
		}
	} //closes main
}		