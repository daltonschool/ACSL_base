package org.dalton.acsl2.format13;

/* Theodore Katz
 * Dalton School
 * #3055 */
import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class ACSL2_Format13_TK {
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		for (int count=0;count<5;count++)
		{
			int andcount=0;
			String[] info=input.nextLine().split(", ");
			boolean comma=false;
			boolean exp=info[0].charAt(info[0].length()-1)=='E';
			boolean dol=info[0].charAt(0)=='$';
			if (info[0].charAt(0)=='*')
				info[0]=info[0].substring(1);
			for (int i=0;i<info[0].length();i++)
			{
				if (info[0].charAt(i)=='&')
				{
					andcount++;
					info[0]=info[0].substring(0,i)+"0"+info[0].substring(i+1);
				}
				else if (info[0].charAt(i)==',')
				{
					comma=true;
					info[0]=info[0].substring(0,i)+info[0].substring(i--+1);
				}
			}
			if (exp)
			{
				int temp=info[0].indexOf(".");
				info[0]=info[0].substring(0,info[0].indexOf("0")+1)+"."+(temp==-1?info[0].substring(info[0].indexOf("0")+1):info[0].substring(info[0].indexOf("0")+1,temp)+info[0].substring(temp+1));
				if (info[0].contains(".E"))
					info[0]=info[0].substring(0,info[0].indexOf("."))+info[0].substring(info[0].indexOf(".")+1);
				info[0]+="0";
			}
			DecimalFormat d=new DecimalFormat(info[0]);
			d.setRoundingMode(RoundingMode.HALF_UP);
			String s=d.format(Double.parseDouble(info[1]));
			while (s.charAt(0)=='0')
				s=s.substring(1);
			while (s.charAt(0)=='$'&&s.charAt(1)=='0')
				s="$"+s.substring(2);
			int digcount=0;
			for (int i=0;i<s.length();i++)
				if (s.charAt(i)>='0'&&s.charAt(i)<='9')
					digcount++;
			if (!dol)
				for (int i=0;i<andcount-digcount;i++)
					s="*"+s;
			if (comma)
			{
				int ind=s.indexOf(".")==-1?s.length()-3:s.indexOf(".")-3;
				for (int i=ind;i>0&&s.charAt(i-1)>='0'&&s.charAt(i-1)<='9';i-=3)
					s=s.substring(0,i)+","+s.substring(i);
			}
			System.out.println(s);
		}
	}
}