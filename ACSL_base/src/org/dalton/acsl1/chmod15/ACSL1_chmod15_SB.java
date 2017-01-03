package org.dalton.acsl1.chmod15;
import java.util.Scanner;


public class ACSL1_chmod15_SB {

	public static void main(String[] args) {
		
		String userinput;
		String [] digits = new String [4];
		
		Scanner in = new Scanner(System.in);
		 userinput = in.nextLine();
		 
		digits = userinput.split("=>|,|\\s");
		 
		 String[] splitArray = userinput.split(" *(,|=>| ) *");
		
		 int [] ints = new int [4];
		 
		 for (int i=0; i < splitArray.length; i++) {
		        ints[i] = Integer.parseInt(splitArray[i]);
		    }
		 
		 int [] numbersToConvert = new int [3];
		 int cats=0;
		 for (int i = 0; i < 3; i++) {
			 	numbersToConvert[i] = i;
			 	System.out.println(numbersToConvert[i]);
			 	cats += i;
		 	}
		 
		 
		 
		 
		 System.out.println(convertToBinary(5));
		 
		 
		 
		 
		
		 
		 
	}
	
	  public static int[] convertToBinary(int octalvalue) {
	       
		  int octnum, rem, quot, i=1, j;
	        int binnum[] = new int[100];
	        Scanner scan = new Scanner(System.in);
	        System.out.println("here "+octalvalue);
			
	        System.out.print("Enter Octal Number : ");
	        octnum = octalvalue;
			
	        quot = octnum;
			
	        while(quot != 0)
	        {
	            binnum[i++] = quot%2;
	            quot = quot/2;
	        }
	        
	        for (int k = 0; k < binnum.length; k++) {
				
			}
			return binnum;
	        //this is an array, have to find some way to make it an integer 
			//
	    }

}


