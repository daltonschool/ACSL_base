package org.dalton.acsl3.fanorona13;

/* Theodore Katz
 * Dalton School
 * #3055 */
import java.util.*;
public class ACSL3_Fanorona13_TK {
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		A:for (int count=0;count<5;count++)
		{
			int[] board=new int[26];
			board[0]=1;
			String[] line=input.nextLine().split(", ");
			int numw=Integer.parseInt(line[0]);
			for (int i=1;i<=numw;i++)
				board[Integer.parseInt(line[i])]=1;
			for (int i=numw+2;i<line.length;i++)
				board[Integer.parseInt(line[i])]=-1;
			for (int i=1;i<=numw;i++)
			{
				int temp=Integer.parseInt(line[i]);
				ArrayList<Integer> poss=new ArrayList<Integer>();
				int[] possjumps={-6,-5,-4,-1,1,4,5,6};
				for (int j:possjumps)
				{
					if (temp%2==0&&j%2==0||getVal(temp,j)==0)
						continue;
					poss.add(temp+j);
				}
				for (int jump:poss)
				{
					if (board[jump]==0)
					{
						int stuff=board[getVal(jump,jump-temp)]==-1?1:board[getVal(temp,temp-jump)]==-1?-1:0;
						if (stuff==0)
							continue;
						ArrayList<Integer> taken=new ArrayList<Integer>();
						int first=stuff==1?2*jump-temp:2*temp-jump;
						taken.add(first);
						while (board[first=getVal(first,stuff*(jump-temp))]==-1)
							taken.add(first);
						Collections.sort(taken);
						String s="";
						for (int k:taken)
							s+=", "+k;
						System.out.println(s.substring(2));
						continue A;
					}
				}
			}
			System.out.println("NONE");
		}
	}
	private static int getVal(int ind,int direc)
	{
		return (Math.abs((ind-1)/5-(ind+direc-1)/5)>(Math.abs(direc)==1?0:1)||ind+direc<1||ind+direc>25)?0:ind+direc;
	}
}