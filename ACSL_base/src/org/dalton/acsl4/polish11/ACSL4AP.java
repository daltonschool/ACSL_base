package org.dalton.acsl4.polish11;
import java.util.Scanner;
import java.util.Stack;
public class ACSL4AP {
	/**
	 * Alex Pong
	 * Dalton
	 * 3055
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input: ");
		for(int x = 0; x<5; x++)
		{
			String in = input.nextLine(); //take the input
			System.out.println(infix(in));
		}
	}
	public static String infix(String input)
	{
		Stack<Character> operators = new Stack<Character>();
		String toReturn = "";
		input = new StringBuffer(input).reverse().toString();
		for (int i = 0; i < input.length(); i++) 
		{
			char letter = input.charAt(i);
			if(isLetter(letter)) toReturn = toReturn +letter; //add to output string if it's a letter. everything below this should be an operator
			else if (letter == ')') operators.push(letter); //push immediately without comparison if parens
			else if (letter =='(') //pop until you reach the other side of the parens
			{
				while(!(operators.peek()==')')&&!operators.isEmpty()) toReturn = toReturn + operators.pop();
				operators.pop();//get rid of the other side of the parens
			}
			else if (operators.isEmpty()) operators.push(letter); //push to stack if the stack is empty by default
			else if (!operators.isEmpty()&&precedence(letter)>=precedence(operators.peek())) operators.push(letter); //push if the current letter's value is higher than the stacks'
			else if (!operators.isEmpty()&&precedence(letter)<precedence(operators.peek())) //if the stack takes precendence, keep popping, then push
			{
				while(!operators.isEmpty()&&precedence(letter)<precedence(operators.peek())) toReturn = toReturn + operators.pop();
				operators.push(letter);
			}

		} 
		while(!operators.isEmpty()) toReturn = toReturn + operators.pop();//empty the stack at the end to get everything back out
		return new StringBuffer(toReturn).reverse().toString();
	}
	public static boolean isLetter(char c)
	{
		switch (c){
		case '*':return false;
		case '-':return false;
		case '+':return false;
		case '(':return false;
		case ')':return false;
		default: return true;
		}
	}
	public static int precedence(char c)
	{
		switch (c){
		case '*':return 4;
		case '-':return 3;
		case '+':return 3;
		default: return 0;
		}
	}
}
