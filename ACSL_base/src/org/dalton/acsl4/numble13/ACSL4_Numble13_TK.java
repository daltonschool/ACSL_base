package org.dalton.acsl4.numble13;

/* Theodore Katz
 * Dalton School
 * #3055 */
import java.util.*;
public class ACSL4_Numble13_TK {
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		String[] firsts=input.nextLine().split(", ");
		for (int count=0;count<5;count++)
		{
			String[] line=input.nextLine().split(", ");
			int[] nums={Integer.parseInt(line[0]),Integer.parseInt(line[1]),Integer.parseInt(line[2]),Integer.parseInt(line[3]),Integer.parseInt(line[4])};
			print(top(toArrayList(firsts[0]),nums[0]),nums[0],top(toArrayList(firsts[1]),nums[1]),nums[1],top(toArrayList(firsts[2]),nums[2]),nums[2],nums[3],nums[4]);
		}
	}
	private static ArrayList<Integer> top(ArrayList<Integer> list,int n)
	{
		ArrayList<ArrayList<Integer>> perms=permutations(list);
		int max=0;
		ArrayList<Integer> maxlist=list;
		for (ArrayList<Integer> l:perms)
		{
			int sum=0;
			for (int i=0;i<n;i++)
				sum+=l.get(i);
			if (sum%5==0)	
			{
				if (n!=1&&l.get(n-1)==0&&l.get(n-2)==0)
				{
					l.remove(n-1);
					l.add(0,0);
				}
				if (n!=1&&l.get(n-1)==0&&l.get(n-2)==0)
					continue;
				if (sum>max)
				{
					max=sum;
					maxlist=l;
				}
			}
		}
		return maxlist;
	}
	private static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> digs)
	{
		Collections.sort(digs);
		Collections.reverse(digs);
		ArrayList<ArrayList<Integer>> perms=new ArrayList<ArrayList<Integer>>();
		if (digs.size()==1)
		{
			perms.add(digs);
			return perms;
		}
		for (int i=0;i<digs.size();i++)
		{
			int first=digs.get(i);
			ArrayList<Integer> cloned=(ArrayList<Integer>)digs.clone();
			cloned.remove(i);
			ArrayList<ArrayList<Integer>> temp=permutations(cloned);
			for (int j=0;j<temp.size();j++)
			{
				temp.get(j).add(0,first);
				perms.add(temp.get(j));
			}
		}
		return perms;
	}
	private static ArrayList<Integer> toArrayList(String num)
	{
		ArrayList<Integer> l=new ArrayList<Integer>();
		for (int i=0;i<num.length();i++)
			l.add(Integer.parseInt(num.substring(i,i+1)));
		return l;
	}
	private static void print(ArrayList<Integer> str1,int str1length,ArrayList<Integer> str2,int str2length,ArrayList<Integer> str3,int str3length,int inter1,int inter2)
	{
		int x2=str1.indexOf(inter1);
		int x3=str1.indexOf(inter2);
		int begin2=-1*str2.indexOf(inter1);
		int end2=str2length-str2.indexOf(inter1)-1;
		int begin3=-1*str3.indexOf(inter2);
		int end3=str3length-str3.indexOf(inter2)-1;
		for (int i=Math.min(begin2,begin3);i<=Math.max(end2,end3);i++)
		{
			for (int j=0;j<str1length;j++)
				System.out.print((i==0?str1.get(j):j==x2?i-begin2<str2length&&i>=begin2?str2.get(i-begin2):" ":j==x3?i-begin3<str3length&&i>=begin3?str3.get(i-begin3):" ":" ")+" ");
			System.out.println();
		}
	}
}