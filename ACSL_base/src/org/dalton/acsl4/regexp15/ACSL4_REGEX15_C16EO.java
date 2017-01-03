package org.dalton.acsl4.regexp15;
import java.util.regex.*;
import java.util.*;
public class ACSL4_REGEX15_C16EO {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input1 = scan.nextLine();
		for(int i = 0; i < 10; i++) {
			Set<String> set = new HashSet<String>();
			String input2 = scan.nextLine();
			Pattern p = Pattern.compile(input2);
			Matcher m = p.matcher(input1);
			while(m.find()) set.add(m.group());
			Iterator<String> iter = set.iterator();
			if (iter.hasNext()) System.out.print(iter.next());
			while (iter.hasNext()) System.out.print(", " + iter.next());
			System.out.println();
		}
		scan.close();
	}
}