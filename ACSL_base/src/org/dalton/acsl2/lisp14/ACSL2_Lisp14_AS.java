package org.dalton.acsl2.lisp14;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Alexandra Schein
 * The Dalton School
 * ACSL2
 */

/* Test data:
 * (ADD (EXP -3 2) (SQR 5) (SUB 6 2) (MULT 6 7 -2 3) (DIV 15 5))
 * (SQR (MULT 3 4 5))
 * (MULT (DIV 20 4) (EXP -2 3))
 * (DIV (ADD 5 4 -6 7) (MULT 3 -1 7) (SUB 5 4))
 * */
public class ACSL2_Lisp14_AS {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String exp = input.nextLine();//the expression
		String output = "";
		for(int i=0; i<5;i++){
			String dataIn = input.nextLine();
			if(!(dataIn.contains(" "))){
				dataIn=dataIn+" ";
			}
			String[] data = dataIn.split(" ");
			if(data[0].equalsIgnoreCase("sort")){
				output = sort(exp, Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			}
			else if(data[0].equalsIgnoreCase("reverse")){
				output = reverse(exp, Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			}
			else if(data[0].equalsIgnoreCase("count")){
				output = count(exp);
			}
			else if(data[0].equalsIgnoreCase("remove")){
				output = remove(exp, Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			}
			else if(data[0].equalsIgnoreCase("maximum")){
				output = maximum(exp);
			}
			
			System.out.println(output);
		}//close for loop

	}//close main

	static String sort(String exp, int start, int finish){//3, 5
		String[] split = exp.split(" " + "\\(");
		int subLength = (finish-start)+1;//3
		String[] subArr = new String[subLength];
		int x = start;
		//make sub array from int start to int finish
		for(int i=0; i<subLength;i++){
			subArr[i]=split[x];
			x++;
		}
		x=0;

		Arrays.sort(subArr);

		//refill initial array with new sorted sub array
		for(int i=start; i<=finish;i++){
			split[i]=subArr[x];
			x++;
		}

		//add in (
		for(int i=1; i<split.length;i++ ){
			split[i]="(" + split[i];
		}

		exp = Arrays.toString(split);
		
		//fix stuff
		exp = check(exp);
		return exp;
	}//close sort

	static String reverse(String exp, int first, int last){
		String[] split = exp.split(" " + "\\(");
		int subLength = (last-first)+1;//4
		String[] subArr = new String[subLength];
		int x = first;
		//make sub array from int start to int finish
		for(int i=0; i<subLength;i++){
			subArr[i]=split[x];
			x++;
		}
		String[] reversed = new String[subLength];//length of 4
		//reverse sub array
		for(int i = 0; i<subArr.length;i++){//subLength=4
			reversed[i]=subArr[subLength-1];//reversed[0]=subArr[4]
			subLength--;
		}
		x=0;
		//reverse numbers
		String nums = "";
		for(int i=0; i<reversed.length; i++){
			nums = reversed[i];
			//reverse the numbers
			nums = dblReverse(nums);
			//put back into array
			reversed[i]=nums;
		}
		
		//refill initial array with new sorted sub array
		for(int i=first; i<=last;i++){
			split[i]=reversed[x];
			x++;
		}

		//add in (
		for(int i=1; i<split.length;i++ ){
			split[i]="(" + split[i];
		}
		exp=Arrays.toString(split);
		//fix some stuff
		exp = check(exp);
		return exp;
	}//close reverse
	
	static String dblReverse(String nums){
		//check if it's the last term and if so, delete one ) at the end
		StringBuffer sb = new StringBuffer(nums);
		if(sb.charAt(sb.length()-1)==')' && sb.charAt(sb.length()-2)==')'){
			sb.deleteCharAt(sb.length()-1);
		}
		nums = sb.toString();
		
		//delete ) at end and ignore 
		nums = nums.substring(0,nums.length()-1);	
		//make array of input
		String[] split = nums.split(" ");
		//save case (mult,sort,etc.)
		String type = split[0];
		//reverse the array from spot 1 to length to ignore the case (mult, sort, etc.)
		String[] reversed = new String[split.length-1];
		int splitLength = split.length;
		for(int i = 0; i < reversed.length; i++){
			reversed[i]=split[splitLength-1];
			splitLength--;
		}
		//add ) back to the end
		nums = type + " " + Arrays.toString(reversed) + ")";
		nums = check(nums);
		return nums;
	}//close double reverse

	static String count(String exp){
		int counter = 0;
		String ans = "";
		StringBuffer sb = new StringBuffer(exp);
		for(int i = 0; i<sb.length();i++){
			if(sb.charAt(i)=='('){
				counter++;
			}//close if
		}//close for	
		counter=counter-1;
		ans= counter+"";
		return ans;
	}//close count
	static String remove(String exp, int first, int last){
		String[] split = exp.split(" " + "\\(");
		List<String> list = new ArrayList<String>(Arrays.asList(split));
		for(int i = first; i <=last; i ++){
			list.remove(split[i]);
		}
		split = list.toArray(new String[0]);
		//add in (
		for(int i=1; i<split.length;i++ ){
			split[i]="(" + split[i];
		}
		exp = Arrays.toString(split);
		//remove some stuff
		StringBuffer sb = new StringBuffer(exp);
		for(int i = 0; i<sb.length(); i++){
			if(sb.charAt(i)=='[' || sb.charAt(i)==']' || sb.charAt(i)==','){
				sb.deleteCharAt(i);
			}
		}
		exp = sb.toString();
		//fix some stuff
		exp = check(exp);
		
		return exp;
	}
	static String maximum(String exp){
		String maxSub = "";
		int max = 0;
		String counter = "";
		String[] split = exp.split("\\(");
		String[] subSplit = new String[100];
		for(int i=0; i<split.length; i++){
			subSplit = split[i].split(" ");
			if(subSplit.length>max){
				max = subSplit.length;
				maxSub=split[i];
			}//close if
		}//close for
		//fix some stuff

		maxSub = check(maxSub);
		
		//delete ) at end
		StringBuffer sb = new StringBuffer(maxSub);
		if(sb.charAt(sb.length()-1)==')' && sb.charAt(sb.length()-2)==')'){
			sb.deleteCharAt(sb.length()-1);
		}
		maxSub = sb.toString();
		
		return "(" + maxSub;	
	}//close maximum
	//check some stuff
	static String check(String exp){
		exp = exp.trim();
		StringBuffer sb = new StringBuffer(exp);
		//remove the brackets and commas
		for(int i = 0; i<sb.length(); i++){
			if(sb.charAt(i)=='[' || sb.charAt(i)==']' || sb.charAt(i)==','){
				sb.deleteCharAt(i);
			}
		}
		//add a ) to an expression that needs it at the end
		if(sb.charAt(sb.length()-1)==')' && sb.charAt(sb.length()-2)!=')'){
			sb.append(')');
		}
		else if(sb.charAt(sb.length()-1)!=')'){// if all inside expressions are removed
			sb.append(')');
		}
		//check if there's a double )) within an expression (not at the end)
		for(int i = 0; i<sb.length(); i++){
			if(i!=sb.length()-1 && sb.charAt(i)==')' && sb.charAt(i-1)==')'){
				sb.deleteCharAt(i);
			}
		}
		exp = sb.toString();
		
		return exp;
	}

}//close class
