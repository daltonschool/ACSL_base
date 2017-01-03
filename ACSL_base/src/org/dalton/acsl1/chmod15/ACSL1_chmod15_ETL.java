package org.dalton.acsl1.chmod15;
import java.util.Scanner;

public class ACSL1_chmod15_ETL {

	//take input
	public static int[] input(String[] stringIn) {
		int[] input = new int[stringIn.length];
		for(int i=0; i<stringIn.length; i++) {
			input[i]=Integer.parseInt(stringIn[i]);
		}
		return input;
	}
	
	//turn into binary
	public static int[] binary(int[] input){
		int[] binary = new int[9];
	
		//put binary number into an int array
		for(int i=1; i<4; i++){
			String binaryfirst = Integer.toBinaryString(input[i]);
			char[] chars = binaryfirst.toCharArray();			
			int num = i*3-3;
			if(chars.length==3){
				binary[num]=Character.getNumericValue(binaryfirst.charAt(0));
				binary[num+1]=Character.getNumericValue(binaryfirst.charAt(1));
				binary[num+2]=Character.getNumericValue(binaryfirst.charAt(2));
			}
			else if(chars.length==2){
				binary[num]=0;
				binary[num+1]=Character.getNumericValue(binaryfirst.charAt(0));
				binary[num+2]=Character.getNumericValue(binaryfirst.charAt(1));
			}
			else if(chars.length==1){
				binary[num]=0;
				binary[num+1]=0;
				binary[num+2]=Character.getNumericValue(binaryfirst.charAt(0));
			}			
		}		
		return binary;
	}
	
	//turn from binary into letters -- CHANGE THIS TO LOOK AT NUMBERS NOW BC THIS IS WHERE IT MATTERS
	public static String[] words(int[] binary, int[] input){
		String[] words = new String[9];
		for(int i=0; i<words.length; i++){
			words[i]="-";
			if((i==0||i==3||i==6)&&binary[i]==1){
					words[i]="r";
			}
			else if((i==1||i==4||i==7)&&binary[i]==1){
					words[i]="w";
			}
			else if(i==2||i==5||i==8){
				if(binary[i]==1){
					words[i]="x";
				}
			}
			if(input[0]==1&&binary[2]==1) words[2]="s";
			if(input[0]==2&&binary[5]==1) words[5]="s";
			if(input[0]==4&&binary[8]==1) words[8]="t";
			
		}
		
		return words;
	}
	
	public static void main(String[] args) {
		 // TODO Auto-generated method stub
	    Scanner scan = new Scanner(System.in);

	    int count=1;
	    for(int j=0; j<5; j++) {
	      //print the answer
	      String[] stringIn = scan.nextLine().split(", ");
	      String product = "";
	      int[] binaryuse = binary(input(stringIn));
	      String[] words = words(binary(input(stringIn)), input(stringIn));
	      int count2=0;
	      
	      //print binary array
	      for(int i=0; i<9; i++){
	    	  product+= binaryuse[i];
	    	  if(count2%3==2){
	    		  product+=" ";
	    	  }
	    	  count2++;
	      }
	      product+="and ";
	      //print words
	      count2=0;
	      for(int i=0; i<9; i++){
	    	  product+= words[i];
	    	  if(count2%3==2){
	    		  product+=" ";
	    	  }
	    	  count2++;
	      }
	      System.out.println(product);
	    }

		
	}

}
