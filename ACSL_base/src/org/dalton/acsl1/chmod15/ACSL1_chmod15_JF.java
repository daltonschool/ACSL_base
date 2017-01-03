package org.dalton.acsl1.chmod15;
import java.util.Scanner;

public class ACSL1_chmod15_JF {
	public static void main(String[] args) {
		
		//initialize command variables
		int specialp = 0;
		int owner = 0;
		int group = 0;
		int others = 0;

		int x=5;
		while(x>0){
		
		Scanner scan = new Scanner(System.in);
		
		String input;
		String[] data;
			
			//take the input
			input = scan.nextLine();

			//break up the input
			data = input.split(", ");
			
			//split parse data into different 
			specialp =Integer.parseInt(data[0]);
			owner =Integer.parseInt(data[1]);
			group =Integer.parseInt(data[2]);
			others =Integer.parseInt(data[3]);
						
			//check (use regex later) have to do the 1. later
//			System.out.println(specialp);
//			System.out.println(owner);
//			System.out.println(group);
//			System.out.println(others);			
		    		      
		     // make sure always three digits (change binary to octal?)
//		     System.out.println(Integer.toBinaryString(owner));
//		     System.out.println(Integer.toBinaryString(group));
//		     System.out.println(Integer.toBinaryString(others));
//		     
		    // find out how to get octal to work
		    // Integer.toOctalString(owner);
			
			//initialize strings for commands
		     String ownerc = null;
		     String groupc = null;
		     String othersc = null;
		    
		     //check special permissions
		     if (specialp==1){
		     if (owner ==1) ownerc="--s ";
		     if (owner ==2) ownerc="-w- ";
		     if (owner ==3) ownerc="-ws ";
		     if (owner ==4) ownerc="r-- ";
		     if (owner ==5) ownerc="r-s ";
		     if (owner ==6) ownerc="rw- ";
		     if (owner ==7) ownerc="rws ";
		     if (owner ==0) ownerc="--- ";
		     }
		     else{
		     if (owner ==1) ownerc="--x ";
		     if (owner ==2) ownerc="-w- ";
		     if (owner ==3) ownerc="-wx ";
		     if (owner ==4) ownerc="r-- ";
		     if (owner ==5) ownerc="r-x ";
		     if (owner ==6) ownerc="rw- ";
		     if (owner ==7) ownerc="rwx ";
		     if (owner ==0) ownerc="--- ";
		     }
		     if( specialp==2){
		     if (group ==1) groupc="--s ";
		     if (group ==2) groupc="-w- ";
		     if (group ==3) groupc="-ws ";
		     if (group ==4) groupc="r-- ";
		     if (group ==5) groupc="r-s ";
		     if (group ==6) groupc="rw- ";
		     if (group ==7) groupc="rws ";
		     if (group ==0) groupc="--- ";
		     }
		     else{
		     if (group ==1) groupc="--x ";
		     if (group ==2) groupc="-w- ";
		     if (group ==3) groupc="-wx ";
		     if (group ==4) groupc="r-- ";
		     if (group ==5) groupc="r-x ";
		     if (group ==6) groupc="rw- ";
		     if (group ==7) groupc="rwx ";
		     if (group ==0) groupc="--- ";
		     }
		     if (specialp==4){
		     if (others ==1) othersc="--t";
		     if (others ==2) othersc="-w-";
		     if (others ==3) othersc="-wt";
		     if (others ==4) othersc="r--";
		     if (others ==5) othersc="r-t";
		     if (others ==6) othersc="rw-";
		     if (others ==7) othersc="rwt";
		     if (others ==0) othersc="---";
		     }
		     else{
		     if (others ==1) othersc="--x";
		     if (others ==2) othersc="-w-";
		     if (others ==3) othersc="-wx";
		     if (others ==4) othersc="r--";
		     if (others ==5) othersc="r-x";
		     if (others ==6) othersc="rw-";
		     if (others ==7) othersc="rwx";
		     if (others ==0) othersc="---";
		     }
		     		// always does three digits
		   //System.out.println(String.format("%3s", Integer.toBinaryString(1)).replace(" ", "0"));
		   //  System.out.println(Integer.toString(owner,3));
		     //prints numbers in binary to three digits and commands
		     System.out.println((String.format("%3s", Integer.toBinaryString(owner)).replace(" ", "0")) +" "+(String.format("%3s", Integer.toBinaryString(group)).replace(" ", "0"))+" "+(String.format("%3s", Integer.toBinaryString(others)).replace(" ", "0"))+ " and " + ownerc + groupc+othersc );
		   	
		     
		     x--;
		}
	}
}
