package org.dalton.acsl1.chmod15;
import java.util.Scanner;

public class ASCL1_chmod15_CP {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] conversions = {"---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx"};
		for(int i = 0; i <5; i++){
			String[] data = input.nextLine().split(",[ ]*");
			int special = Integer.parseInt(data[0]);
			//the binaries for all of em
			String userbi = String.format("%3s",Integer.toBinaryString(Integer.parseInt(data[1]))).replace(' ', '0');
			String groupbi = String.format("%3s",Integer.toBinaryString(Integer.parseInt(data[2]))).replace(' ', '0');
			String othersbi = String.format("%3s",Integer.toBinaryString(Integer.parseInt(data[3]))).replace(' ', '0');
			//permisiions
			String userper = conversions[Integer.parseInt(data[1])];
			String groupper = conversions[Integer.parseInt(data[2])];	
			String othersper = conversions[Integer.parseInt(data[3])];
			//special stuff
			if(special == 1){
				char[] a = userper.toCharArray();
				if(a[2] == 'x') a[2] = 's';
				userper = String.valueOf(a);
			}
			else if(special == 2){
				char[] b = groupper.toCharArray();
				if(b[2] == 'x') b[2] = 's';				
				groupper = String.valueOf(b);
			}
			else if(special == 4){
				char[] c = othersper.toCharArray();
				if(c[2] == 'x') c[2] = 't';
				othersper = String.valueOf(c);
			}
			System.out.println(userbi + " " + groupbi + " " + othersbi + " and " + userper + " " + groupper + " " + othersper);
		}
	}
}
