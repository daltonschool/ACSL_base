package org.dalton.acsl4.matrix10;

import java.util.Scanner;


public class Contest4_2 {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		for(int loop=0; loop<5; loop++)
		{	System.out.println();
			Scanner in=new Scanner(System.in);
			String input=in.nextLine();
			String[] splitter=new String[6];
			splitter=input.split(", ");
			String word=splitter[1];
			int[] encode=new int[4];
			for(int i=0; i<4; i++)
			{
				encode[i]=Integer.parseInt(splitter[i+2]);
			}
			int length=word.length();
			//System.out.println("Length=" + length);
			//System.out.println("length%2="+ length%2);
			if(length%2!=0)
			{
				String space=" ";
				word=word+space;
				length++;
				//System.out.println("New Length=" + length);
			}

			if(splitter[0].equals("E"))
			{
				encode(word, length, encode);
			}
			else if(splitter[0].equals("D"))
			{
				decode(word, length, encode);
			}
		}
	}

	public static void encode(String word, int length, int[] encode)
	{
		int L1=0;
		int L2=0;

		for(int i=0; i<length; i=i+2)
		{
			if(word.charAt(i)==' ')
			{
				L1=27;
			}
			else
			{	
				L1=(int) word.charAt(i)-64;
			}

			if(word.charAt(i+1)==' ')
			{
				L2=27;
			}
			else
			{	
				L2=(int) word.charAt(i+1)-64;
			}
			int newL1=(encode[0]*L1)+(encode[1]*L2);
			int newL2=(encode[2]*L1)+(encode[3]*L2);
			//System.out.println("L1= " + newL1);
			//System.out.println("L2= " + newL2);
			printing(newL1);
			printing(newL2);
		}
	}

	public static void decode(String word, int length, int[] encode)
	{
		int[] newEncode=new int[4];
		newEncode[0]=(encode[3])/((encode[0]*encode[3])-(encode[1]*encode[2]));
		newEncode[1]=-1*encode[1]/((encode[0]*encode[3])-(encode[1]*encode[2]));
		newEncode[2]=-1*encode[2]/((encode[0]*encode[3])-(encode[1]*encode[2]));
		newEncode[3]=(encode[0])/((encode[0]*encode[3])-(encode[1]*encode[2]));
		int L1=0;
		int L2=0;
		for(int i=0; i<length; i=i+2)
		{
			if(word.charAt(i)==' ')
			{
				L1=27;
			}
			else
			{	
				L1=(int) word.charAt(i)-64;
			}

			if(word.charAt(i+1)==' ')
			{
				L2=27;
			}
			else
			{	
				L2=(int) word.charAt(i+1)-64;
			}

			int newL1=(newEncode[0]*L1)+(newEncode[1]*L2);
			int newL2=(newEncode[2]*L1)+(newEncode[3]*L2);
			newL1=makePos(newL1);
			newL2=makePos(newL2);
			//System.out.println("new L1= " + newL1);
			//System.out.println("new L2= " + newL2);
			printing(newL1);
			printing(newL2);
		}
	}
	public static void printing(int L)
	{
		char ret=' ';

		//System.out.println("Lbefore=" + L);

		L=(L%27)+64;

		//System.out.println("Lafter=" + L);
		if(L==64)
		{
			ret=' ';
		}
		else
		{	
			ret=(char)L;
		}

		System.out.print(ret);
	}

	public static int makePos(int L)
	{
		//System.out.println("Lbeforepos=" + L);
		while(L<0)
		{
			L=L+27;
		}
		return L;	
	}

}
