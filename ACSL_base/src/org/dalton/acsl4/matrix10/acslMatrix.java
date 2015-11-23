package org.dalton.acsl4.matrix10;

import java.util.*;
public class acslMatrix {

	public static int ConNum (char x)
	{
		char letter = x;
		int num = (int) letter - 64;
		if(num == -32)
		{
			num = 27;
		}
		return num;
	}
	public static char ConString (int y) 
	{
		int num = y + 64; //DO I NEED THIS LINE?
		char offoutput = (char) num;
		return offoutput;
	}
	public static int ProperRange (int z)
	{
		while(z>27)
		{
			z = z -27;
		}
		while(z<1)
		{
			z = z + 27;
		}
		if(z == 27)
		{
			z = 96;
		}
		return z;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(int turn = 0; turn<5; turn++)
		{
			String response = in.nextLine();
			String output = "";
			String parts[] = response.split(", ");
			String operation = parts[0];
			String data = parts[1]; 
			if(parts[1].length()% 2 == 1) //if data has an odd amount, add a space to the end
			{
				StringBuffer sb = new StringBuffer(parts[1]).append(" ");
				data = sb.toString();
			}
			int amat = Integer.parseInt(parts[2]);
			int bmat = Integer.parseInt(parts[3]);
			int cmat = Integer.parseInt(parts[4]);
			int dmat = Integer.parseInt(parts[5]);
			char[] letter = data.toCharArray(); 
			char part1 = 0;
			char part2 = 0;
			int propnum1 = 0;
			int propnum2 = 0;
			if(operation.equalsIgnoreCase("E"))
			{
				for(int i = 0; i<letter.length; i = i + 2) //encoding. Should there be i+1?
				{
					propnum1 = ProperRange(amat*ConNum(letter[i]) + bmat*ConNum(letter[i+1]));
					part1 = ConString(propnum1);
					//part1 = ConString(amat*ConNum(letter[i]) + bmat*ConNum(letter[i+1]));
					propnum2 = ProperRange(cmat*ConNum(letter[i])+dmat*ConNum(letter[i+1]));
					part2 = ConString(propnum2);
					//part2 = ConString(cmat*ConNum(letter[i])+dmat*ConNum(letter[i+1]));
					output = output + part1 + part2;
				}//closes for
			}//closes if


			//decoding

			int adecode = (dmat)/(amat*dmat-bmat*cmat);
			int bdecode = -1*(bmat)/(amat*dmat-bmat*cmat); 
			int cdecode = -1*(cmat)/(amat*dmat-bmat*cmat);
			int ddecode = (amat)/(amat*dmat-bmat*cmat);
			if(operation.equalsIgnoreCase("D"))
			{
				for(int i = 0; i<letter.length; i = i + 2) //decoding
				{
					propnum1 = ProperRange(adecode*ConNum(letter[i]) + bdecode*ConNum(letter[i+1]));
					propnum2 = ProperRange(cdecode*ConNum(letter[i])+ddecode*ConNum(letter[i+1]));
					part1 = ConString(propnum1);
					part2 = ConString(propnum2);
					//part1 = ConString(adecode*ConNum(letter[i]) + bdecode*ConNum(letter[i+1]));
					//part2 = ConString(cdecode*ConNum(letter[i])+ddecode*ConNum(letter[i+1]));
					output = output + part1 + part2;	
				} //closes for
			}//closes if

			System.out.println(output); //official OUTPUT
		}//turn loop
	}//closes main
}//closes class
