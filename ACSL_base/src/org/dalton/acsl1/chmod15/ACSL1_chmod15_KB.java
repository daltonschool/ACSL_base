package org.dalton.acsl1.chmod15;
import java.util.Scanner;


public class ACSL1_chmod15_KB {
	public static void main(String[] args){
		//	String filein = "testdataCHMOD15";
		Scanner scan = new Scanner(System.in);
		int rounds = 5;
		while(rounds > 0){
			users(scan.nextLine());
			rounds--;
		}
	}
	static String users(String b){
		String [] c = b.split(",[ ]*");

		int special =  Integer.parseInt(c[0]);
		int owner = Integer.parseInt(c[1]);
		int group = Integer.parseInt(c[2]);
		int others = Integer.parseInt(c[3]);

		//converting to binary and adding padding zeros
		String ownerzeros = Integer.toBinaryString(owner);
		while(ownerzeros.length() <3){
			ownerzeros = "0" + ownerzeros;
		}
		String groupzeros = Integer.toBinaryString(group);
		while(groupzeros.length() <3){
			groupzeros = "0" + groupzeros;
		}
		String otherszeros = Integer.toBinaryString(others);
		while(otherszeros.length() <3){
			otherszeros = "0" + otherszeros;
		}

		//printing out the binary numbers
		System.out.print(ownerzeros + " " + groupzeros + " " + otherszeros);

		//changing string to char array
		char[] ownerarr = ownerzeros.toCharArray();
		char[] grouparr = groupzeros.toCharArray();
		char[] othersarr = otherszeros.toCharArray();

		//assigning permissions for owner
		if(ownerarr[0] == '1') ownerarr[0] = 'r';
		else if(ownerarr[0] == '0') ownerarr[0] = '-';

		if(ownerarr[1] == '1')ownerarr[1] = 'w';
		else if(ownerarr[1] == '0') ownerarr[1] = '-';

		if(ownerarr[2] == '1' && special == 1) ownerarr[2] = 's';
		else if(ownerarr[2] == '1' && special != 1) ownerarr[2] = 'x';
		else if(ownerarr[2] == '0') ownerarr[2] = '-';

		//assigning permissions for group
		if(grouparr[0] == '1') grouparr[0] = 'r';
		else if(grouparr[0] == '0') grouparr[0] = '-';

		if(grouparr[1] == '1') grouparr[1] = 'w';
		else if(grouparr[1] == '0') grouparr[1] = '-';

		if(grouparr[2] == '1' && special == 2) grouparr[2] = 's';
		else if(grouparr[2] == '1' && special != 2) grouparr[2] = 'x';
		else if(grouparr[2] == '0') grouparr[2] = '-';

		//assigning permissions for group
		if(othersarr[0] == '1') othersarr[0] = 'r';
		else if(othersarr[0] == '0') othersarr[0] = '-';

		if(othersarr[1] == '1') othersarr[1] = 'w';
		else if(othersarr[1] == '0') othersarr[1] = '-';

		if(othersarr[2] == '1' && special == 4) othersarr[2] = 't';
		else if(othersarr[2] == '1' && special != 4) othersarr[2] = 'x';
		else if(othersarr[2] == '0') othersarr[2] = '-';

		String own = String.valueOf(ownerarr);
		String gro = String.valueOf(grouparr);
		String oth = String.valueOf(othersarr);

		System.out.println(" and " + own + " " + gro + " " + oth);

		return null;
	}
}