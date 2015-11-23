package org.dalton.acsl4.polish11;
import java.util.Scanner;
import java.util.Stack;

//cara haas

public class PIPFinalCH {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		for(int counter = 0; counter<5; counter++)
		{
			try {
				String infix=input.nextLine();
				String rev=reverse(infix);
				Stack<Character> holders = new Stack<Character>();
				Stack<Character> finalOut= new Stack<Character>();

				int len = infix.length();
				for(int i=0; i<len; i++)
				{
					char c=rev.charAt(i);
					if(isOperand(c)==true)
					{	
						if((c=='+' || c=='-') && holders.size()>0 && (Character) holders.peek()=='*')
						{
							int ksize=holders.size();
							for(int k=0; k<ksize; k++)
							{
								if(holders.peek()==')') break;
								else if(holders.peek()=='*') finalOut.push(holders.pop());
								else break;
							}
							holders.push(c);
						}
						else holders.push(c);
					}
					else if( c==')') holders.push(c);
					else if(c=='(') emptyStack(holders, finalOut);
					else finalOut.push(c);
				}

				finalOut=emptyStack(holders,finalOut);

				System.out.println(printStack(finalOut));
			}
			
			catch (Exception e) {
				e.printStackTrace();}
		}
	}

	public static String reverse(String orig)
	{
		String rev = "";
		for(int i=orig.length()-1;i >=0; i--) rev+=orig.charAt(i);
		return rev;
	}

	public static boolean isOperand(char c)
	{
		boolean isOp=false;
		if(c=='*' || c=='-' || c=='+') isOp=true;
		return isOp;
	}

	public static Stack emptyStack(Stack old, Stack next)
	{
		int len=old.size();
		for(int i=0; i<len; i++)
		{
			char c = (Character) old.pop();
			if(c==')') break;
			else next.push(c);
		}
		return next;
	}

	public static String printStack(Stack s)
	{
		String output = "";
		int len=s.size();
		for(int i= 0; i<len; i++) output+=s.pop();
		return output;
	}
}
