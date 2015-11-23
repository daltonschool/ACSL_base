/**
 * @author Danielle Midulla
 * School Code: 3055
 *
 */

package org.dalton.acsl4.polish11;

import java.util.Scanner;
import java.util.Stack;

public class ACSL_PolishDM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int j = 1; j<6; j++){
			Stack<Character> ops = new Stack<Character>();
			Scanner input = new Scanner(System.in);
			StringBuffer backout = new StringBuffer();
			System.out.print(j+". ");
			StringBuffer rev = new StringBuffer(input.nextLine());
			char[] in = rev.reverse().toString().toCharArray();
			for(int i = 0; i<in.length; i++){
				if (isOperator(in[i])){
					if((in[i]=='+' || in[i] == '-')&&ops.size()>0&&ops.peek()=='*'){
						while(ops.empty()==false){
							backout.append(ops.pop());
						}
					}//if
					ops.push(in[i]);
				}//if
				else {
					backout.append(in[i]);
				}//else
				if(ops.size() > 2 && ops.peek() == '('){
					ops.pop();
					while(ops.size()>0 && ops.peek() != ')'){
						backout.append(ops.pop());
					}
					ops.pop();
				}//if
			}//for
			ops.trimToSize();
			for(int i = 0; i<ops.size()+1; i++){
				backout.append(ops.pop());
			}
			System.out.println(j+". " + backout.reverse().toString());
		}//for
	}//main
	public static boolean isOperator(char x){
		if(x == '*' || x == '(' || x == ')' || x == '+' || x == '-') return true;
		else return false;
	}//isOperator
}//class