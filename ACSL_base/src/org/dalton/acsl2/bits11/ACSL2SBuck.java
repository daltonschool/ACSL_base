package org.dalton.acsl2.bits11;

/**Sam Buck
 * School: Dalton
 * Code:3055
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ACSL2SBuck {

	public static void main (String[] args)
	{
		for (int m = 0; m < 5; m++)
		{
			System.out.print((m+1) +". ");
			Scanner scan = new Scanner(System.in);
			String[] se = scan.nextLine().trim().split(",");
			String[] e = pro(se);
			int g = 0;
			char[] o = new char[e[1].length()];
			for (int j = 0; j < e[1].length(); j++)
			{
				boolean b = true;
				for (int i = 1; i < e.length - 1; i++) if (e[i].toCharArray()[j] != e[i+1].toCharArray()[j]) b = false;
				if (b) o[j] = e[1].toCharArray()[j];			
				else o[j] = '*';
			}			
			for (int i =0; i< o.length; i++) if (o[i] == '*') g++;
			if (Math.pow(2,g) > Integer.parseInt(e[0])) System.out.println("NONE");
			else System.out.println((m+1) +". " + new String(o));
		}
	}
	
	public String go(String args)
	{
			String[] se = args.trim().split(",");
			String[] e = pro(se);
			int g = 0;
			char[] o = new char[e[1].length()];
			for (int j = 0; j < e[1].length(); j++)
			{
				boolean b = true;
				for (int i = 1; i < e.length - 1; i++) if (e[i].toCharArray()[j] != e[i+1].toCharArray()[j]) b = false;
				if (b) o[j] = e[1].toCharArray()[j];			
				else o[j] = '*';
			}			
			for (int i =0; i< o.length; i++) if (o[i] == '*') g++;
			if (Math.pow(2,g) > Integer.parseInt(e[0])) return "NONE";
			else return new String(o);
		
	}

	private static String[] pro(String[] split) {

		ArrayList<String> se = new ArrayList<String>(Arrays.asList(split));
		int nt = Integer.parseInt(split[0]);
		se.remove(0);
		List<String> list = se;
		Set<String> set = new HashSet<String>(list);
		String[] result = new String[set.size()];
		set.toArray(result);
		ArrayList<String> we = new ArrayList<String>(Arrays.asList(result));
		nt = we.size();
		we.add(0, new Integer(nt).toString());
		String[] fe = new String[we.size()];
		we.toArray(fe);




		return fe;
	}
}