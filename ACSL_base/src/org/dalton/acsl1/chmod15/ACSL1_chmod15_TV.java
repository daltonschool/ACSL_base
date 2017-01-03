package org.dalton.acsl1.chmod15;
import java.util.Scanner;
public class ACSL1_chmod15_TV {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String i;
		int s;
		String[] h;
		int e;
		int f;
		int g;
		while (true){ 
			for (int p = 1; p < 6; p++) {
				i = scan.nextLine();
				String stuff = i.substring(3, i.length());
				h = stuff.split(", ");
				s = Integer.parseInt(h[0]);
				e = Integer.parseInt(h[1]);
				f = Integer.parseInt(h[2]);
				g = Integer.parseInt(h[3]);
				String x = number(e)+""+number(f)+""+number(g);
				x = x.substring(0, 3) + " " + x.substring(3, 6) + " " + x.substring(6, x.length()) + " ";
				String y = x;
				y = y.replaceAll("3 ", "- ");
				y = y.replaceAll("1 ", "x ");
				y = y.replaceAll("3([^ ]) ", "-$1 ");
				y = y.replaceAll("1([^ ]) ", "w$1 ");
				y = y.replaceAll("3([^ ][^ ]) ", "-$1 ");
				y = y.replaceAll("1([^ ][^ ]) ", "r$1 ");
				String a = y.substring(0, 3);
				String b = y.substring(4, 7);
				String c = y.substring(8, y.length());
				if (s==1) a = a.replaceAll("x", "s ");
				if (s==2) b = b.replaceAll("x", "s ");
				if (s==4) c = c.replaceAll("x", "t ");
				x = x.replaceAll("3", "0");
				System.out.println(p +". " +x + "and " + a + " " + b + " "+ c);
			}
		}
	}
	static  int	number(int j) {
		if (j ==0) j = 333;
		else if (j ==1) j = 331;
		else if (j ==2) j = 313;
		else if (j ==3) j = 311;
		else if (j ==4) j = 133;
		else if (j ==5) j = 131;
		else if (j ==6) j = 113;
		else if (j ==7) j = 111;
		return j;
	}
}