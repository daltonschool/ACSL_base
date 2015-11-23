package org.dalton.acsl2.lisp14;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Name: Andrew Milich 
 * School: The Dalton School 
 * Code: 3055 
 */

/*
 *	(ADD (EXP -3 2) (SQR 5) (SUB 6 2) (MULT 6 7 -2 3) (DIV 15 5))
 *	(DIV (MULT 1 -2 -3 -4 -5) (EXP -1 9)) 
 *	(MULT (SUB -3 19 4) (ADD 9 8 -6 3) (SQR 7) (EXP -2 3) (MULT -1234 59 73))
 *	(SQR (MULT 3 4 5))
 *	(MULT (DIV 20 4) (EXP -2 3))
 *	(DIV (ADD 5 4 -6 7) (MULT 3 -1 7) (SUB 5 4))
 *  (ADD (SQR 999) (ADD 3 7 -9 19) (SUB 6 7 94 710) (MULT 12341234 9302) (DIV 1 2 3 4 5 -6) (EXP -1 3))
 */

public class ACSL2_Lisp14_AM {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String line = input.nextLine(); 
		line = line.trim(); //get rid of spaces
		String trimmed_line = line.substring(1,line.length()-1); //trim parentheses 
		ArrayList<String> sublists = new ArrayList<String>(); 

		for(String s : trimmed_line.split("\\("))
			sublists.add("(" + s); 
		String main_operator = sublists.get(0).substring(1); 
		sublists.remove(0); //get rid of first operator; this will be the main operator 

		ExpressionAM orig = new ExpressionAM(); 
		ExpressionAM e = new ExpressionAM(); 
		for(String s : sublists){
			e.elements.add(new ElementAM(s));
			orig.elements.add(new ElementAM(s));
		}
		e.first_element = main_operator; 
		orig.first_element = main_operator; 

		for (int ii = 0; ii < 5; ii++) { //5 operations
			try { 
				String query = input.nextLine(); 
				//remember that you are always working with the original!
				if(query.toLowerCase().contains("count")){
					System.out.println(count(e)); 
				}
				else if (query.toLowerCase().contains("max")) {
					System.out.println(e.elements.get(maximum(e))); 
				}
				else if (query.toLowerCase().contains("remove")) {
					String[] indices = query.split(" "); 
					int l_index = Integer.parseInt(indices[1]);
					int r_index = Integer.parseInt(indices[2]); 
					remove(e, l_index, r_index).print();
				}
				else if (query.toLowerCase().contains("reverse")) {
					String[] indices = query.split(" "); 
					int l_index = Integer.parseInt(indices[1]);
					int r_index = Integer.parseInt(indices[2]); 
					reverse(e, l_index, r_index).print();
				}
				else if (query.toLowerCase().contains("sort")) {
					String[] indices = query.split(" "); 
					int l_index = Integer.parseInt(indices[1]);
					int r_index = Integer.parseInt(indices[2]); 
					sort(e, l_index, r_index).print();
				}
				else {
					System.out.println("insert next piece of data");
				}
			}
			catch(Exception exc){
				System.out.println("Error; insert next piece of test data");
				//exc.printStackTrace(); 
			}
		}
	}

	public static int count(ExpressionAM input){
		return input.elements.size(); 
	}

	public static ExpressionAM remove(ExpressionAM input, int l_index, int r_index){ //CAREFUL: this should not modify original 
		ExpressionAM new_expression = new ExpressionAM(); 
		for (ElementAM e : input.elements) 
			new_expression.elements.add(e);
		new_expression.first_element = input.first_element; 

		//deal with LISP starting at 1
		//deal with REMOVALS CORRECTLTY
		new_expression.elements.subList(l_index-1, r_index).clear(); //get rid of the sublist within the list 
		return new_expression; 
	}

	public static int maximum(ExpressionAM input){
		//this should return the INDEX of the maximum 
		int max = -1; //an INDEX
		int max_count = 0; 
		for (int ii = 0; ii < input.elements.size(); ii ++) {
			int space_count = count_str(input.elements.get(ii).content, " "); 
			if(space_count > max_count){
				max = ii;  
				max_count = space_count; 
			}
		}
		return max; 
	}

	//REVERSE ELEMENTS IN LIST!!!! 
	public static ExpressionAM reverse(ExpressionAM input, int l_index, int r_index){
		ExpressionAM new_expression = new ExpressionAM();

		for (int ii = 0; ii < input.elements.size(); ii++) {
			if(ii >= l_index-1 && ii < r_index)
				new_expression.elements.add(new ElementAM(input.elements.get(ii).reverseContent()));
			else 
				new_expression.elements.add(input.elements.get(ii));	
		}
		new_expression.first_element = input.first_element; 
		//deal with LISP starting at 1
		//deal with REMOVALS CORRECTLTY
		Collections.reverse(new_expression.elements.subList(l_index-1, r_index)); 

		return new_expression; 
	}

	public static ExpressionAM sort(ExpressionAM input, int l_index, int r_index){
		ExpressionAM new_expression = new ExpressionAM(); 
		for (ElementAM e : input.elements) 
			new_expression.elements.add(e);
		new_expression.first_element = input.first_element; 

		//deal with LISP starting at 1
		//deal with REMOVALS CORRECTLTY
		Collections.sort(new_expression.elements.subList(l_index-1, r_index)); 
		return new_expression; 
	}

	public static int count_str(String s, String cha){
		return s.length() - s.replace(cha, "").length();
	}
}

class ElementAM implements Comparable<ElementAM>{
	String content; 

	public ElementAM(String content){
		this.content = content.trim(); 
	}

	public String toString(){
		return content.trim(); 
	}

	//return a string with the reversed content of the current content
	public String reverseContent(){
		String ret = ""; 
		String first_part = content.split(" ")[0] + " "; //get the operation 
		ArrayList<Integer> subelements = new ArrayList<Integer>(); //actual integer love 
		//the rest of the string - get rid of operation, get rid of close parenthesis, 
		String rest = content.split(" ", 2)[1].substring(0, content.split(" ", 2)[1].length()-1);
		//String rest = content.split(" ", 2)[1].substring(0, content.split(" ", 2)[1].length()).substring(0, content.split(" ", 2)[1].length()-1);
		for (int ii = 0; ii < rest.split(" ").length; ii++) 
			subelements.add(Integer.parseInt(rest.split(" ")[ii])); 

		Collections.reverse(subelements); 

		//add the reversed integers
		rest = ""; 
		for (Integer i : subelements) 
			rest += i + " "; 
		rest = rest.trim(); 
		ret = first_part + rest + ")"; 
		ret = ret.trim(); 

		return ret; 
	}

	@Override
	public int compareTo(ElementAM o) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		// TODO Auto-generated method stub
		//System.out.println(this.content.compareTo(o.content));
		if(this.content.compareTo(o.content) < 0){
			//System.out.println(this.content + " is before " + o.content);
			return BEFORE; 
		}
		else if (this.content.compareTo(o.content) > 0){
			//System.out.println(this.content + " is after " + o.content);
			return AFTER; 
		}
		else {
			return EQUAL; 
		}
	}
}

class ExpressionAM {
	String first_element = ""; 
	//list of individual list operations 
	ArrayList<ElementAM> elements = new ArrayList<ElementAM>();

	//print an expression 
	public void print(){
		String str = ""; 
		str = "(" + first_element; 
		for (ElementAM e : elements) {
			str += e.toString().trim() + " "; 
		}
		str = str.trim(); 
		str = str.replace("[", ""); 
		str = str.replace("]", "");
		str = str.replace(",", "");
		str += ")";
		/*
		 * Prints the string 
		 */
		System.out.println(str);
	}
}

