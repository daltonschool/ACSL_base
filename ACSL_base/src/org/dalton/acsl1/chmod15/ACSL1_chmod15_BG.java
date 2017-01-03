package org.dalton.acsl1.chmod15;


import java.util.Scanner;

public class ACSL1_chmod15_BG {
	public static void main(String[] args) {
		//get the data
		Scanner scan = new Scanner (System.in);
		
		for (int i = 0; i<100; i++){
		
			String data = scan.nextLine();
			
			
//			for (int j = 0; j < data.length; j++) {
//				System.out.println(data[j] + j);
//			} 
				
				String half = line12(data.substring(2));
	
	
			//	System.out.println(half + "  " +( (int) data.charAt(3) - 48 )+ " " + (int) '4');
		
				
				if (data.charAt(0) == '1' && half.charAt(2) == 'x') {
			
					System.out.println(line13((int) data.charAt(3) - 48) + " " + line13((int) data.charAt(6) - 48) + " " + line13((int) data.charAt(9) -48) + " and " + half.substring(0, 2) + "s" + half.substring(3));
				}
				else if (data.charAt(0) == '2' && half.charAt(6) == 'x') {
					System.out.println(line13((int) data.charAt(3) -48) + " " + line13((int) data.charAt(6) - 48) + " " + line13((int) data.charAt(9) - 48) + " and " + half.substring(0, 6) + "s" + half.substring(7));
				}
				else if (data.charAt(0) == '4' && half.charAt(10) == 'x') {
					System.out.println(line13((int) data.charAt(3)- 48) + " " + line13((int) data.charAt(6) -48) + " " + line13((int) data.charAt(9) -48) + " and " + half.substring(0, 10) + "t");
				}
				else {
					System.out.println(line13((int) data.charAt(3) -48) + " " + line13((int) data.charAt(6)-48) + " " + line13((int) data.charAt(9) -48) + " and " + half);
				}
			}

		//System.out.println(line12(transfer));
	//	System.out.println(line12("5, 6, 2"));
	//	}
	}

	//pulled this from online don't know how it works but its cool
	public static String line12(String line) {
		String[] nums = line.trim().split(" *, *");
		StringBuilder sb = new StringBuilder();
		for (String s : nums) {
		//	System.out.println(sb);
			if (sb.length() > 0) sb.append(" ");
			int num = Integer.parseInt(s);
		//	System.out.println(num);
			sb.append((num & 4) == 0 ? '-' : 'r');
			sb.append((num & 2) == 0 ? '-' : 'w');
			sb.append((num & 1) == 0 ? '-' : 'x');
		}
		return sb.toString();
	}
	
	public static String line13(int ahhh) {
		if (ahhh == 0){
			return "000";
		}
		if (ahhh == 1) {
			return "001";
		}
		if (ahhh == 2) {
			return "010";
		}
		if (ahhh == 3) {
			return "011";
		}
		if (ahhh == 4) {
			return "100";
		}
		if (ahhh == 5) {
			return "101";
		}
		if (ahhh == 6) {
			return "110";
		}
		if (ahhh == 7) {
			return "111";
		}
		else return "somehow broke this";
	
	}

}
